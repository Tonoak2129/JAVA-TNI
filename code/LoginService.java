package MiniGameParty;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoginService extends UserAccount{

    public LoginService(String username, String password) {
        super(username, password);
    }

    public boolean loginAccount() throws IOException {
        File filename = new File(getUserFile());
        Scanner scn = new Scanner(filename);

        while (scn.hasNext())
        {
            String[] data = scn.nextLine().split(",");
            if (getUsername().equalsIgnoreCase(data[0]) && getPassword().equals(data[1]))
            {
                scn.close();
                return true;
            }
        }
        scn.close();
        return false;
    }

}
