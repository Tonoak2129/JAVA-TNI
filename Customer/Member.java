package Customer;

public class Member extends Customer implements Rewardable {
    private String member_level;

    public Member(String name , double billAmount , String member_level){
        super(name,billAmount);
        this.member_level = member_level;
    }

    @Override
    public double calculateFinalBill() {
        return getBillAmount() - (getBillAmount() * getDiscountRate());
    }

    @Override
    public double getDiscountRate() {
        if (member_level.equalsIgnoreCase("gold")) return 0.15;
        if (member_level.equalsIgnoreCase("premium")) return 0.2;
        return 0;
    }

    @Override
    public int collectPoint() {
        return (int)(calculateFinalBill()/100);
    }

    public String toString(){
        return super.toString() +
                "\nMember level: " + member_level + " (Discount " + getDiscountRate() + ")" +
                "\nGet point: " + collectPoint() +
                "\nTotal price: " + calculateFinalBill();
    }

}
