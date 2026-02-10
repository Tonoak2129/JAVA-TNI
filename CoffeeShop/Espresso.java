package CoffeeShop;

public class Espresso extends Drink{
    private int shot = 0;

    public Espresso(String drinkName , double basePrice ,String size,int shot){
        super(drinkName,basePrice,size);
        this.shot = shot;
    }
    public void addShot(int shot){
        shot += 1;
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
                "Total price = "  + calculateFinalPrice() + " Baht";
    }
}
