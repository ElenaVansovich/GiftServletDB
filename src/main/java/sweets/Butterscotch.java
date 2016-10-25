package sweets;

/**
 * Created by Elena on 10.10.2016.
 */
public class Butterscotch extends Sweet {

    private double milk;

    public Butterscotch(){
        super();
    }

    /**
     * @param name
     * @param price
     * @param sugar
     * @param weight
     * @param milk
     */
    public Butterscotch(String name, double price, double sugar, double weight, double milk){
        super(name, price, sugar, weight);
        this.milk = milk;
    }

    /**
     * @return
     */
    public double getMilk() {
        return milk;
    }

    /**
     * @param milk
     */
    public void setMilk(double milk) {
        this.milk = milk;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        String str = super.toString() +
                "Amount of milk: " + this.getMilk() + "\n";
        return str;
    }

    /**
     * @param butterscotch
     * @return
     */
    @Override
    public boolean equals(Object butterscotch){
        if(this == butterscotch){
            return true;
        }if(butterscotch == null){
            return false;
        }
        if(getClass() != butterscotch.getClass()){
            return false;
        }
        if(!super.equals(butterscotch)){
            return false;
        }
        Butterscotch other = (Butterscotch)butterscotch;
        if(this.milk != other.milk){
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
        int result = super.hashCode()*prime + (int)this.milk;
        return result;
    }

    /**
     * @return
     */
    @Override
    public String getClassName(){
        return SweetType.BUTTERSCOTCH.toString();
    }
}
