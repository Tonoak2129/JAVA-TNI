package MiniGameParty;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RegisterService extends UserAccount {

    public RegisterService(String username , String password , int coupon){
        super(username,password,coupon);
    }

    public RegisterService(String username , String password){
        super(username,password,0);
    }

    public boolean recordAccount() {
        PrintWriter writer = null;
        try {
            FileWriter filename = new FileWriter(getUserFile(), true);
            writer = new PrintWriter(filename);

            if (!isExistingAccount(getUsername())) {
                writer.println(toString());
                return true;
            }

        }
        catch (IOException e)
        {
            System.out.println("Cannot register this account");
        }
        finally
        {
            if (writer != null)
            {
                writer.close();
            }
        }
        return false;
    }

    private boolean isExistingAccount(String account_name) throws IOException {
        File filename = new File(getUserFile());
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
