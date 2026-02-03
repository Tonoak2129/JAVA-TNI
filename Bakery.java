public class Bakery {
    private String flavour;
    private double unitPrice;

    private int packingCost = 5;

    public Bakery(String flavour, double unitPrice){
        this.flavour = flavour;
        this.unitPrice = unitPrice;
    }
    public Bakery(){
        this("",0.0);
    }
    public String getFlavour(){
        return this.flavour;
    }
    public double getUnitPrice(){
        return this.unitPrice;
    }
    public int getPackingCost() {
        return this.packingCost;
    }
    public double calculatedTotalPrice(){
        return this.unitPrice + this.packingCost;
    }
    public String toString(){
        return "Thank you for your order!";
    }
}
