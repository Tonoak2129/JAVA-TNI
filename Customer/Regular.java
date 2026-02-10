package Customer;

public class Regular extends Customer{
    public Regular(String name,double billAmount){
        super(name,billAmount);
    }

    public boolean isDiscount(){
        return getBillAmount()>=500;
    }

    @Override
    public double calculateFinalBill() {
        return isDiscount() ? getBillAmount()-(getBillAmount() * 0.05) : getBillAmount();
    }

    public String toString(){
        return super.toString() +
                (isDiscount() ? "\nyou get discount 5%":"") +
                "\nTotal price = " + calculateFinalBill();
    }
}