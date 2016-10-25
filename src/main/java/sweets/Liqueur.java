package sweets;

/**
 * Created by Elena on 10.10.2016.
 */
public class Liqueur extends Sweet {

    private double liqueur;

    public Liqueur(){
        super();
    }

    /**
     * @param name
     * @param price
     * @param sugar
     * @param weight
     * @param liqueur
     */
    public Liqueur(String name, double price, double sugar, double weight, double liqueur){
        super(name, price, sugar, weight);
        this.liqueur = liqueur;
    }

    /**
     * @return
     */
    public double getLiqueur() {
        return liqueur;
    }

    /**
     * @param liqueur
     */
    public void setLiqueur(double liqueur) {
        this.liqueur = liqueur;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        String str = "Type: " + "liqueur" + "\n" +
                super.toString() +
                "Amount of liqueur: " + this.getLiqueur() + "\n";
        return str;
    }

    /**
     * @param liqueurSweet
     * @return
     */
    @Override
    public boolean equals(Object liqueurSweet){
        if(this == liqueurSweet){
            return true;
        }if(liqueurSweet == null){
            return false;
        }
        if(getClass() != liqueurSweet.getClass()){
            return false;
        }
        if(!super.equals(liqueurSweet)){
            return false;
        }
        Liqueur other = (Liqueur)liqueurSweet;
        if(this.liqueur != other.liqueur){
            return false;
        }
        return true;
    }

    /**
     * @return
     */
    @Override
    public int hashCode(){
        final int prime = 31;
        int result = super.hashCode()*prime + (int)this.liqueur;
        return result;
    }

    /**
     * @return
     */
    @Override
    public String getClassName(){
        return SweetType.LIQUEUR.toString();
    }
}
