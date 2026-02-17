import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        File filename = new File("src/users.txt");
        Scanner scn = new Scanner(filename);

        while (scn.hasNext()){
            String[] data = scn.nextLine().split(",");
            //data[0] username
            //data[1] password
            //data[2] gender
            //data[3] birthyear
            String username = data[0];
            String password = data[1];
            String gender = data[2];
            int birthYear = Integer.parseInt(data[3]);
            System.out.println("username = " + data[0]);
            System.out.println("password = " + data[1]);
            System.out.println("password = " + hide_password(data[1]));
            System.out.println("gender = " + data[2]);
            System.out.println("birthyear = " + data[3]);
            System.out.println();
        }
        scn.close();
    }
    public static String hide_password(String password){
        String hide_password = "";
        for (int i = 0; i<password.length();i++){
            if (i==0) hide_password += password.charAt(i);
            else if (i == password.length()-1) hide_password += password.charAt(i);
            else hide_password += '*';
        }
        return hide_password;
    }
}
