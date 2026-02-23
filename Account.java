public class Account {
    private String accName;
    private String accPass;
    private int accPoint;

    public Account(String accName, String accPass, int accPoint){
        this.accName = accName;
        this.accPass = accName;
        this.accPoint = accPoint;
    }
    public Account(String accName){
        this.accName = accName;
    }
}
