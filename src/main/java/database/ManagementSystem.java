package database;

import sweets.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elena on 10/23/2016.
 */
public class ManagementSystem {

    private static Connection connection = null;

    public ManagementSystem() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/sweetsjdb","root", "root");

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
        stmt = connection.prepareStatement("SELECT idsweet, name, price, sugar, weight, type FROM sweet");
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
            int id = rs.getInt(1);
            if((rs.getString(6)).equals(SweetType.BUTTERSCOTCH.toString())) {
                sweetList.add(getButterscotchDB(rs, id));
            }
            else if(rs.getString(6).equals(SweetType.CHOCOLATE.toString())) {
                sweetList.add(getChocolateDB(rs, id));
            }
            else if(rs.getString(6).equals(SweetType.JELLY.toString())) {
                sweetList.add(getJellyDB(rs, id));
            }
            else if(rs.getString(6).equals(SweetType.LIQUEUR.toString())) {
                sweetList.add(getLiqueurDB(rs, id));
            }
            else if(rs.getString(6).equals(SweetType.WAFER.toString())) {
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
        stmt = connection.prepareStatement("SELECT idsweet, name, price, sugar, weight, type FROM sweet ORDER BY price");
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
        stmt = connection.prepareStatement("SELECT idsweet, name, price, sugar, weight, type FROM sweet ORDER BY sugar");
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
        stmt = connection.prepareStatement("SELECT idsweet, name, price, sugar, weight, type FROM sweet ORDER BY weight");
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

        stmt = connection.prepareStatement("SELECT milk FROM butterscotch WHERE idsweet = ?");
        stmt.setInt(1, id);
        rsButterscotch = stmt.executeQuery();
        if (rsButterscotch.next()) {
            butterscotch = new Butterscotch(rs.getString(2), rs.getDouble(3),
                    rs.getDouble(4), rs.getDouble(5), rsButterscotch.getDouble(1));
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
        stmt = connection.prepareStatement("SELECT chocolate FROM chocolate WHERE idsweet = ?");
        stmt.setInt(1, id);
        rsChocolate = stmt.executeQuery();
        if (rsChocolate.next()) {
            chocolate = new Chocolate(rs.getString(2), rs.getDouble(3),
                    rs.getDouble(4), rs.getDouble(5), rsChocolate.getDouble(1));
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

        stmt = connection.prepareStatement("SELECT gelatin FROM jelly WHERE idsweet = ?");
        stmt.setInt(1, id);
        rsJelly = stmt.executeQuery();
        if (rsJelly.next()) {
            jelly = new Jelly(rs.getString(2), rs.getDouble(3),
                    rs.getDouble(4), rs.getDouble(5), rsJelly.getDouble(1));
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

        stmt = connection.prepareStatement("SELECT liqueur FROM liqueur WHERE idsweet = ?");
        stmt.setInt(1, id);
        rsLiqueur = stmt.executeQuery();
        if (rsLiqueur.next()) {
            liqueur = new Liqueur(rs.getString(2), rs.getDouble(3),
                    rs.getDouble(4), rs.getDouble(5), rsLiqueur.getDouble(1));
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

        stmt = connection.prepareStatement("SELECT wafer FROM wafer WHERE idsweet = ?");
        stmt.setInt(1, id);
        rsWafer = stmt.executeQuery();
        if (rsWafer.next()) {
            wafer = new Wafer(rs.getString(2), rs.getDouble(3),
                    rs.getDouble(4), rs.getDouble(5), rsWafer.getDouble(1));
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
        stmt = connection.prepareStatement("SELECT idsweet, name, price, sugar, weight, type FROM sweet WHERE price < ? AND sugar < ? AND weight < ?");
        stmt.setDouble(1, price);
        stmt.setDouble(2, sugar);
        stmt.setDouble(3, weight);

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
        ResultSet rs = stmt.executeQuery("SELECT idsweet FROM sweet ORDER BY idsweet DESC ");
        if(rs.next()){
            id = rs.getInt(1) + 1;
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

        stmt = connection.prepareStatement("INSERT INTO sweet "
                + "(idsweet, name, price, sugar, weight, type)"
                + "VALUES( ?, ?, ?, ?, ?, ? )");
        stmt.setInt(1, id);
        stmt.setString(2, sweet.getName());
        stmt.setDouble(3, sweet.getPrice());
        stmt.setDouble(4, sweet.getSugar());
        stmt.setDouble(5, sweet.getWeight());


        if((sweet.getClassName()).equals(SweetType.BUTTERSCOTCH.toString())) {
            stmt.setString(6, SweetType.BUTTERSCOTCH.toString());
            stmt.execute();
            stmt = connection.prepareStatement("INSERT INTO butterscotch "
                    + "(idsweet, milk)"
                    + "VALUES( ?, ? )");
            stmt.setInt(1, id);
            stmt.setDouble(2, ((Butterscotch) sweet).getMilk());
        }
        else if((sweet.getClassName()).equals(SweetType.CHOCOLATE.toString())) {
            stmt.setString(6, SweetType.CHOCOLATE.toString());
            stmt.execute();
            stmt = connection.prepareStatement("INSERT INTO chocolate "
                    + "(idsweet, chocolate)"
                    + "VALUES( ?, ? )");
            stmt.setInt(1, id);
            stmt.setDouble(2, ((Chocolate) sweet).getChocolate());
        }
        else if((sweet.getClassName()).equals(SweetType.JELLY.toString())) {
            stmt.setString(6, SweetType.JELLY.toString());
            stmt.execute();
            stmt = connection.prepareStatement("INSERT INTO jelly "
                    + "(idsweet, gelatin)"
                    + "VALUES( ?, ? )");
            stmt.setInt(1, id);
            stmt.setDouble(2, ((Jelly) sweet).getGelatin());
        }
        else if((sweet.getClassName()).equals(SweetType.LIQUEUR.toString())) {
            stmt.setString(6, SweetType.LIQUEUR.toString());
            stmt.execute();
            stmt = connection.prepareStatement("INSERT INTO liqueur "
                    + "(idsweet, liqueur)"
                    + "VALUES( ?, ? )");
            stmt.setInt(1, id);
            stmt.setDouble(2, ((Liqueur) sweet).getLiqueur());
        }
        else if((sweet.getClassName()).equals(SweetType.WAFER.toString())) {
            stmt.setString(6, SweetType.WAFER.toString());
            stmt.execute();
            stmt = connection.prepareStatement("INSERT INTO wafer "
                    + "(idsweet, wafer)"
                    + "VALUES( ?, ? )");
            stmt.setInt(1, id);
            stmt.setDouble(2, ((Wafer) sweet).getWafer());
        }
        stmt.execute();
        stmt.close();
    }

    /**
     * @throws SQLException
     */
    public void clearGift() throws SQLException {
        PreparedStatement stmt;
        stmt = connection.prepareStatement("DELETE FROM butterscotch");
        stmt.execute();
        stmt = connection.prepareStatement("DELETE FROM chocolate");
        stmt.execute();
        stmt = connection.prepareStatement("DELETE FROM jelly");
        stmt.execute();
        stmt = connection.prepareStatement("DELETE FROM liqueur");
        stmt.execute();
        stmt = connection.prepareStatement("DELETE FROM wafer");
        stmt.execute();
        stmt = connection.prepareStatement("DELETE FROM sweet");
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
        rs = stmt.executeQuery("SELECT weight FROM sweet");
        while (rs.next()) {
            totalWeight += rs.getDouble(1);
        }
        stmt.close();
        rs.close();
        return totalWeight;
    }
}
