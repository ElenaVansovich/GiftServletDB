package sweets;

/**
 * Created by Elena on 10.10.2016.
 */
public class Sweet {

    private String name;
    private double price;
    private double sugar;
    private double weight;

    public Sweet(){
        super();
    }

    /**
     * @param name
     * @param price
     * @param sugar
     * @param weight
     */
    public Sweet(String name, double price, double sugar, double weight)
    {
        this.name = name;
        this.price = price;
        this.sugar = sugar;
        this.weight = weight;
    }

    /**Name of sweet
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return name
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * @return
     */
    public double getSugar() {
        return sugar;
    }

    /**
     * @param sugar
     */
    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    /**
     * @return
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @param sweet
     * @return
     */
    @Override
    public boolean equals(Object sweet){
        if(this == sweet){
            return true;
        }
        if(sweet == null){
            return false;
        }
        if(getClass() != sweet.getClass()){
            return false;
        }
        Sweet other = (Sweet)sweet;
        if(this.name != other.name){
            return false;
        }
        if(this.price != other.price){
            return false;
        }
        if(this.sugar != other.sugar){
            return false;
        }
        if(this.weight != other.weight){
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
        int result = 1;
        result = prime*result + this.name.hashCode();
        result = prime*result + (int)this.price;
        result = prime*result + (int)this.sugar;
        result = prime*result + (int)this.weight;
        return result;
    }

    /**
     * @return
     */
    public String toString(){
        String str = "Name: " + this.getName() + "\n" +
                    "Price: " + this.getPrice() + "\n" +
                    "Sugar: " + this.getSugar() + "\n" +
                    "Weight: " + this.getWeight() + "\n";
        return str;
    }

    public String getClassName(){
        return this.getClassName();
    }
}
