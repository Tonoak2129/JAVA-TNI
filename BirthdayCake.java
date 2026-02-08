public class BirthdayCake extends Bakery {
    private String message;
    private double pound;

    public BirthdayCake(String message, Double pound, String flavor, double unitPrice){
        super(flavor,unitPrice);
        this.message = message;
        this.pound = pound;
    }
    public String getMessage(){
        return this.message;
    }
    public void changeMessage(String new_message){
        this.message = new_message;
    }
    public int getPackingCost() {
        if (this.pound >= 3)
            return  10;
        return super.getPackingCost();
    }
    public double calculatedTotalPrice(){
        return (getUnitPrice() * this.pound) + getPackingCost();
    }
    public String toString(){
        return super.toString() +
                "\n" + getFlavour() + " birthday cake (message=" + this.message + ")" +
                "\nTotal price of Birthday cake = " + calculatedTotalPrice();
    }
}