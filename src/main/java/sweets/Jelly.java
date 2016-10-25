package sweets;

/**
 * Created by Elena on 10.10.2016.
 */
public class Jelly extends Sweet {

    private double gelatin;

    public Jelly(){
        super();
    }

    /**
     * @param name
     * @param price
     * @param sugar
     * @param weight
     * @param gelatin
     */
    public Jelly(String name, double price, double sugar, double weight, double gelatin){
        super(name, price, sugar, weight);
        this.gelatin = gelatin;
    }

    /**
     * @return
     */
    public double getGelatin() {
        return gelatin;
    }

    /**
     * @param gelatin
     */
    public void setGelatin(double gelatin) {
        this.gelatin = gelatin;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        String str = super.toString() +
                "Amount of gelatin: " + this.getGelatin() + "\n";
        return str;
    }

    /**
     * @param jellySweet
     * @return
     */
    @Override
    public boolean equals(Object jellySweet){
        if(this == jellySweet){
            return true;
        }if(jellySweet == null){
            return false;
        }
        if(getClass() != jellySweet.getClass()){
            return false;
        }
        if(!super.equals(jellySweet)){
            return false;
        }
        Jelly other = (Jelly)jellySweet;
        if(this.gelatin != other.gelatin){
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
        int result = super.hashCode()*prime + (int)this.gelatin;
        return result;
    }

    /**
     * @return
     */
    @Override
    public String getClassName(){
        return SweetType.JELLY.toString();
    }
}
