package CoffeeShop;

public class Espresso extends Drink{
    private int shot = 0;

    public Espresso(String drinkName , double basePrice ,String size){
        super(drinkName,basePrice,size);
    }
    public void addShot(int shot){
            this.shot += shot;

    }

    public int getShot(){
        return shot;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + getSizeExtra() + (shot*15);
    }

    public String toString(){
        return super.toString() + "\n" +
                ((shot>0)?"Added " + shot + " shot" : "") +
                "\nTotal price = "  + calculateFinalPrice() + " Baht";
    }
}