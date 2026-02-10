package CoffeeShop;

public class Frappuccino extends Drink {
    private boolean whipped;

    public Frappuccino(String drinkName,double basePrice,String size,boolean whipped){
        super(drinkName,basePrice,size);
        this.whipped = whipped;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + getSizeExtra() + ((whipped)?15:0);
    }

    public String toString(){
        return super.toString() + "\n" +
                ((whipped)?"Add whipped 15 Baht":"") +
                "\nTotal price = " + calculateFinalPrice() + " Baht";
    }

}
