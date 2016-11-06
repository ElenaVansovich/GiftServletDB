package database;

import sweets.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Elena on 10/23/2016.
 */
public class ManagementSystem {

    private static Connection connection = null;

    String selectSweets = "SELECT idsweet, name, price, sugar, weight, type FROM sweet";

    String orderBySweet = "SELECT idsweet, name, price, sugar, weight, type FROM sweet ORDER BY ";

    String selectMilk = "SELECT idsweet, milk FROM butterscotch WHERE idsweet = ?";
    String selectChocolate = "SELECT idsweet, chocolate FROM chocolate WHERE idsweet = ?";
    String selectGelatin = "SELECT idsweet, gelatin FROM jelly WHERE idsweet = ?";
    String selectLiqueur = "SELECT idsweet, liqueur FROM liqueur WHERE idsweet = ?";
    String selectWafer = "SELECT idsweet, wafer FROM wafer WHERE idsweet = ?";

    String selectSweetsWithParam = "SELECT idsweet, name, price, sugar, weight, type "
                                +"FROM sweet WHERE price < ? AND sugar < ? AND weight < ?";

    String idsweetOrderBy = "SELECT idsweet FROM sweet ORDER BY idsweet DESC";

    String insertSweet = "INSERT INTO sweet (idsweet, name, price, sugar, weight, type)"
            + "VALUES( ?, ?, ?, ?, ?, ? )";

    String insertButterscotch = "INSERT INTO butterscotch (idsweet, milk)"
            + "VALUES( ?, ? )";
    String insertChocolate = "INSERT INTO chocolate (idsweet, chocolate)"
            + "VALUES( ?, ? )";
    String insertJelly = "INSERT INTO jelly (idsweet, gelatin)"
            + "VALUES( ?, ? )";
    String insertLiqueur = "INSERT INTO liqueur (idsweet, liqueur)"
            + "VALUES( ?, ? )";
    String insertWafer = "INSERT INTO wafer (idsweet, wafer)"
            + "VALUES( ?, ? )";

    String deleteButterscotch = "DELETE FROM butterscotch";
    String deleteChocolate = "DELETE FROM chocolate";
    String deleteJelly = "DELETE FROM jelly";
    String deleteLiqueur = "DELETE FROM liqueur";
    String deleteWafer = "DELETE FROM wafer";
    String deleteSweet = "DELETE FROM sweet";

    String selectWeight = "SELECT weight FROM sweet";

    int idsweetParam = 1;

    int nameParam = 2;
    int priceParam = 3;
    int sugarParam = 4;
    int weightParam = 5;

    int sweetInfParam = 2;

    int typeParam = 6;

    int priceParamSearch = 1;
    int sugarParamSearch = 2;
    int weightParamSearch = 3;

    String fileProperties = "persistence.properties";

    public ManagementSystem() {

        Properties props = new Properties();

        Thread currentThread = Thread.currentThread();
        ClassLoader contextClassLoader = currentThread.getContextClassLoader();
        InputStream propertiesStream = contextClassLoader.getResourceAsStream(fileProperties);
        try{
            props.load(propertiesStream);
            propertiesStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String driver = props.getProperty("jdbc.driver");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String connectionURL = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.user");
        String password = props.getProperty("jdbc.password");

        try {
            connection = DriverManager
                    .getConnection(connectionURL,username, password);

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }

    /**
     * @return
     * @throws SQLException
     */
    public List<Sweet> getAllSweets() throws SQLException {
        PreparedStatement stmt;
        stmt = connection.prepareStatement(selectSweets);
        List<Sweet> sweetList = getSweets(stmt);
        stmt.close();
        return sweetList;
    }

    /**
     * @param stmt
     * @return
     * @throws SQLException
     */
    public List<Sweet> getSweets(PreparedStatement stmt) throws SQLException {
        List<Sweet> sweetList = new ArrayList<Sweet>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(idsweetParam);
            if((rs.getString(typeParam)).equals(SweetType.BUTTERSCOTCH.toString())) {
                sweetList.add(getButterscotchDB(rs, id));
            }
            else if(rs.getString(typeParam).equals(SweetType.CHOCOLATE.toString())) {
                sweetList.add(getChocolateDB(rs, id));
            }
            else if(rs.getString(typeParam).equals(SweetType.JELLY.toString())) {
                sweetList.add(getJellyDB(rs, id));
            }
            else if(rs.getString(typeParam).equals(SweetType.LIQUEUR.toString())) {
                sweetList.add(getLiqueurDB(rs, id));
            }
            else if(rs.getString(typeParam).equals(SweetType.WAFER.toString())) {
                sweetList.add(getWaferDB(rs, id));
            }
        }
        rs.close();
        return sweetList;
    }

    /**
     * @return
     * @throws SQLException
     */
    public List<Sweet> sortByPrice() throws SQLException {
        PreparedStatement stmt;
        stmt = connection.prepareStatement(orderBySweet + "price");
        List<Sweet> sweetList = getSweets(stmt);
        stmt.close();
        return sweetList;
    }

    /**
     * @return
     * @throws SQLException
     */
    public List<Sweet> sortBySugar() throws SQLException {
        PreparedStatement stmt;
        stmt = connection.prepareStatement(orderBySweet + "sugar");
        List<Sweet> sweetList = getSweets(stmt);
        stmt.close();
        return sweetList;
    }

    /**
     * @return
     * @throws SQLException
     */
    public List<Sweet> sortByWeight() throws SQLException {
        PreparedStatement stmt;
        stmt = connection.prepareStatement(orderBySweet + "weight");
        List<Sweet> sweetList = getSweets(stmt);
        stmt.close();
        return sweetList;
    }

    /**
     * @param rs
     * @param id
     * @return
     * @throws SQLException
     */
    public Butterscotch getButterscotchDB(ResultSet rs, int id) throws SQLException {
        Butterscotch butterscotch = null;
        ResultSet rsButterscotch;
        PreparedStatement stmt;

        stmt = connection.prepareStatement(selectMilk);
        stmt.setInt(idsweetParam, id);
        rsButterscotch = stmt.executeQuery();
        if (rsButterscotch.next()) {
            butterscotch = new Butterscotch(rs.getString(nameParam), rs.getDouble(priceParam),
                    rs.getDouble(sugarParam), rs.getDouble(weightParam), rsButterscotch.getDouble(sweetInfParam));
        }
        rsButterscotch.close();
        stmt.close();
        return butterscotch;
    }

    /**
     * @param rs
     * @param id
     * @return
     * @throws SQLException
     */
    public Chocolate getChocolateDB(ResultSet rs, int id) throws SQLException {
        Chocolate chocolate = null;
        ResultSet rsChocolate;
        PreparedStatement stmt;
        stmt = connection.prepareStatement(selectChocolate);
        stmt.setInt(idsweetParam, id);
        rsChocolate = stmt.executeQuery();
        if (rsChocolate.next()) {
            chocolate = new Chocolate(rs.getString(nameParam), rs.getDouble(priceParam),
                    rs.getDouble(sugarParam), rs.getDouble(weightParam), rsChocolate.getDouble(sweetInfParam));
        }
        rsChocolate.close();
        stmt.close();
        return chocolate;
    }

    /**
     * @param rs
     * @param id
     * @return
     * @throws SQLException
     */
    public Jelly getJellyDB(ResultSet rs, int id) throws SQLException {
        Jelly jelly = null;
        ResultSet rsJelly;
        PreparedStatement stmt;

        stmt = connection.prepareStatement(selectGelatin);
        stmt.setInt(idsweetParam, id);
        rsJelly = stmt.executeQuery();
        if (rsJelly.next()) {
            jelly = new Jelly(rs.getString(nameParam), rs.getDouble(priceParam),
                    rs.getDouble(sugarParam), rs.getDouble(weightParam), rsJelly.getDouble(sweetInfParam));
        }
        rsJelly.close();
        stmt.close();
        return jelly;
    }

    /**
     * @param rs
     * @param id
     * @return
     * @throws SQLException
     */
    public Liqueur getLiqueurDB(ResultSet rs, int id) throws SQLException {
        Liqueur liqueur = null;
        ResultSet rsLiqueur;
        PreparedStatement stmt;

        stmt = connection.prepareStatement(selectLiqueur);
        stmt.setInt(idsweetParam, id);
        rsLiqueur = stmt.executeQuery();
        if (rsLiqueur.next()) {
            liqueur = new Liqueur(rs.getString(nameParam), rs.getDouble(priceParam),
                    rs.getDouble(sugarParam), rs.getDouble(weightParam), rsLiqueur.getDouble(sweetInfParam));
        }
        rsLiqueur.close();
        stmt.close();
        return liqueur;
    }

    /**
     * @param rs
     * @param id
     * @return
     * @throws SQLException
     */
    public Wafer getWaferDB(ResultSet rs, int id) throws SQLException {
        Wafer wafer = null;
        ResultSet rsWafer;
        PreparedStatement stmt;
        stmt = connection.prepareStatement(selectWafer);
        stmt.setInt(idsweetParam, id);
        rsWafer = stmt.executeQuery();
        if (rsWafer.next()) {
            wafer = new Wafer(rs.getString(nameParam), rs.getDouble(priceParam),
                    rs.getDouble(sugarParam), rs.getDouble(weightParam), rsWafer.getDouble(sweetInfParam));
        }
        rsWafer.close();
        stmt.close();
        return wafer;
    }

    /**
     * @param price
     * @param sugar
     * @param weight
     * @return
     * @throws SQLException
     */
    public List<Sweet> getSweetsWithParameters(double price, double sugar, double weight) throws SQLException {
        PreparedStatement stmt;
        stmt = connection.prepareStatement(selectSweetsWithParam);
        stmt.setDouble(priceParamSearch, price);
        stmt.setDouble(sugarParamSearch, sugar);
        stmt.setDouble(weightParamSearch, weight);

        List<Sweet> sweetList = getSweets(stmt);
        stmt.close();
        return sweetList;
    }

    /**
     * @return
     * @throws SQLException
     */
    public int generateId() throws SQLException{
        int id;
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(idsweetOrderBy);
        if(rs.next()){
            id = rs.getInt(idsweetParam) + 1;
        }
        else {
            id = 1;
        }
        stmt.close();
        rs.close();
        return id;
    }

    /**
     * @param sweet
     * @throws SQLException
     */
    public void addSweet(Sweet sweet) throws SQLException{

        PreparedStatement stmt;

        int id = generateId();

        stmt = connection.prepareStatement(insertSweet);
        stmt.setInt(idsweetParam, id);
        stmt.setString(nameParam, sweet.getName());
        stmt.setDouble(priceParam, sweet.getPrice());
        stmt.setDouble(sugarParam, sweet.getSugar());
        stmt.setDouble(weightParam, sweet.getWeight());


        if((sweet.getClassName()).equals(SweetType.BUTTERSCOTCH.toString())) {
            stmt.setString(typeParam, SweetType.BUTTERSCOTCH.toString());
            stmt.execute();
            stmt = connection.prepareStatement(insertButterscotch);
            stmt.setInt(idsweetParam, id);
            stmt.setDouble(sweetInfParam, ((Butterscotch) sweet).getMilk());
        }
        else if((sweet.getClassName()).equals(SweetType.CHOCOLATE.toString())) {
            stmt.setString(typeParam, SweetType.CHOCOLATE.toString());
            stmt.execute();
            stmt = connection.prepareStatement(insertChocolate);
            stmt.setInt(idsweetParam, id);
            stmt.setDouble(sweetInfParam, ((Chocolate) sweet).getChocolate());
        }
        else if((sweet.getClassName()).equals(SweetType.JELLY.toString())) {
            stmt.setString(typeParam, SweetType.JELLY.toString());
            stmt.execute();
            stmt = connection.prepareStatement(insertJelly);
            stmt.setInt(idsweetParam, id);
            stmt.setDouble(sweetInfParam, ((Jelly) sweet).getGelatin());
        }
        else if((sweet.getClassName()).equals(SweetType.LIQUEUR.toString())) {
            stmt.setString(typeParam, SweetType.LIQUEUR.toString());
            stmt.execute();
            stmt = connection.prepareStatement(insertLiqueur);
            stmt.setInt(idsweetParam, id);
            stmt.setDouble(sweetInfParam, ((Liqueur) sweet).getLiqueur());
        }
        else if((sweet.getClassName()).equals(SweetType.WAFER.toString())) {
            stmt.setString(typeParam, SweetType.WAFER.toString());
            stmt.execute();
            stmt = connection.prepareStatement(insertWafer);
            stmt.setInt(idsweetParam, id);
            stmt.setDouble(sweetInfParam, ((Wafer) sweet).getWafer());
        }
        stmt.execute();
        stmt.close();
    }

    /**
     * @throws SQLException
     */
    public void clearGift() throws SQLException {
        PreparedStatement stmt;
        stmt = connection.prepareStatement(deleteButterscotch);
        stmt.execute();
        stmt = connection.prepareStatement(deleteChocolate);
        stmt.execute();
        stmt = connection.prepareStatement(deleteJelly);
        stmt.execute();
        stmt = connection.prepareStatement(deleteLiqueur);
        stmt.execute();
        stmt = connection.prepareStatement(deleteWafer);
        stmt.execute();
        stmt = connection.prepareStatement(deleteSweet);
        stmt.execute();
        stmt.close();
    }

    /**
     * @return
     * @throws SQLException
     */
    public double totalWeight() throws SQLException {
        double totalWeight = 0;
        Statement stmt;
        ResultSet rs;

        stmt = connection.createStatement();
        rs = stmt.executeQuery(selectWeight);
        while (rs.next()) {
            totalWeight += rs.getDouble(1);
        }
        stmt.close();
        rs.close();
        return totalWeight;
    }
}
