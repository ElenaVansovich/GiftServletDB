package sweets;

/**
 * Created by Elena on 10.10.2016.
 */
public class Chocolate extends Sweet {
    private double chocolate;

    public Chocolate(){
        super();
    }

    /**
     * @param name
     * @param price
     * @param sugar
     * @param weight
     * @param chocolate
     */
    public Chocolate(String name, double price, double sugar, double weight, double chocolate){
        super(name, price, sugar, weight);
        this.chocolate = chocolate;
    }

    /**
     * @return
     */
    public double getChocolate() {
        return chocolate;
    }

    /**
     * @param chocolate
     */
    public void setChocolate(double chocolate) {
        this.chocolate = chocolate;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        String str = super.toString() +
                "Amount of chocolate: " + this.getChocolate() + "\n";
        return str;
    }

    /**
     * @param chocolateSweet
     * @return
     */
    @Override
    public boolean equals(Object chocolateSweet){
        if(this == chocolateSweet){
            return true;
        }if(chocolateSweet == null){
            return false;
        }
        if(getClass() != chocolateSweet.getClass()){
            return false;
        }
        if(!super.equals(chocolateSweet)){
            return false;
        }
        Chocolate other = (Chocolate)chocolateSweet;
        if(this.chocolate != other.chocolate){
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
        int result = super.hashCode()*prime + (int)this.chocolate;
        return result;
    }

    /**
     * @return
     */
    @Override
    public String getClassName(){
        return SweetType.CHOCOLATE.toString();
    }
}
