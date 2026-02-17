package Banking;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public abstract class AccountTransaction extends BankAccount implements Transactionable {
    public AccountTransaction(String accId){
        super(accId);
    }

    public boolean hasAccountId() throws IOException {
        File filename = new File(getFilename());
        Scanner scn = new Scanner(filename);

        while (scn.hasNext())
        {
            String[] data = scn.nextLine().split(",");
            if (getAccId().equalsIgnoreCase(data[0]))
            {
                scn.close();
                return true;
            }
        }
        scn.close();
        return false;
    }

    public void deposit(double amount){
        setAccBalance(amount);
    }

    public void withdraw(double amount){
        if (amount < getAccBalance()) {
            setAccBalance(getAccBalance()-amount);
        }
    }

    public double checkBalance(){
        return getAccBalance();
    }
}
