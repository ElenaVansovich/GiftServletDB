package sweets;

/**
 * Created by Elena on 10.10.2016.
 */
public class Wafer extends Sweet {

    private double wafer;

    public Wafer(){
        super();
    }

    /**
     * @param name
     * @param price
     * @param sugar
     * @param weight
     * @param wafer
     */
    public Wafer(String name, double price, double sugar, double weight, double wafer){
        super(name, price, sugar, weight);
        this.wafer = wafer;
    }

    /**
     * @return
     */
    public double getWafer() {
        return wafer;
    }

    /**
     * @param wafer
     */
    public void setWafer(double wafer) {
        this.wafer = wafer;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        String str = super.toString() +
                "Amount of wafer: " + this.getWafer() + "\n";
        return str;
    }

    /**
     * @param waferSweet
     * @return
     */
    @Override
    public boolean equals(Object waferSweet){
        if(this == waferSweet){
            return true;
        }if(waferSweet == null){
            return false;
        }
        if(getClass() != waferSweet.getClass()){
            return false;
        }
        if(!super.equals(waferSweet)){
            return false;
        }
        Wafer other = (Wafer)waferSweet;
        if(this.wafer != other.wafer){
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
        int result = super.hashCode()*prime + (int)this.wafer;
        return result;
    }

    /**
     * @return
     */
    @Override
    public String getClassName(){
        return SweetType.WAFER.toString();
    }
}
