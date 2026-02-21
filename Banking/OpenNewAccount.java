package Banking;

import java.io.*;
import java.util.Scanner;

public class OpenNewAccount extends BankAccount{

    public OpenNewAccount(String accId, double accBalance){
        super(accId,accBalance);
    }

    public String recordAccount() throws IOException {
        FileWriter filename = new FileWriter(getFilename(),true);
        PrintWriter writer = new PrintWriter(filename);

        if (!isExistingAccount(getAccId()))
            {
                writer.println(toString());
                writer.close();
                return "Created account success!!";
            }
        return "This account has been created!!";
    }

    private boolean isExistingAccount(String account_name) throws IOException {
        File filename = new File(getFilename());
        Scanner scn = new Scanner(filename);

        while (scn.hasNext())
        {
            String[] data = scn.nextLine().split(",");
            if (account_name.equalsIgnoreCase(data[0]))
            {
                scn.close();
                return true;
            }
        }
        scn.close();
        return false;
    }
}