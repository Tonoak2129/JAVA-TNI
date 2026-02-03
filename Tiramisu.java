public class Tiramisu extends Bakery{
    private int scoop;
    private String topping;

    public Tiramisu(String flavor, String topping, int scoop, double unitPrice){
        super(flavor,unitPrice);
        this.scoop = scoop;
        this.topping = topping;
    }
    public boolean addTopping(){
        return !this.topping.equalsIgnoreCase("no");
    }
    public double getToppingCost(){
        if (addTopping())
            return 5;
        return 0;
    }
    public String getTopping(){
        return this.topping;
    }
    public int getPackingCost() {
        if (this.scoop >= 5)
            return  15;
        return super.getPackingCost();
    }
    public double calculatedTotalPrice(){
        return (getUnitPrice() * this.scoop) + getToppingCost() + getPackingCost();
    }
    public String toString(){
        return super.toString() +
                //" addTop:" + addTopping() +
                "\n" + getFlavour() + " tiramisu " + (addTopping()? "topping with " + getTopping() : "with no topping") +
                "\nTotal price of tiramisu = " + calculatedTotalPrice();
    }
}
