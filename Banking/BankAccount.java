package Banking;

import java.io.*;
import java.util.Scanner;

public class BankAccount {
    private String accId;
    private double accBalance;
    private final String filename = "src/Banking/users_account.txt";

    public BankAccount(String accId, double accBalance){
        this.accId = accId;
        this.accBalance = accBalance;
    }
    public BankAccount(String accId){
        this(accId,0.0);
    }
    public BankAccount(){
        this("",0.0);
    }
    public String getAccId(){
        return accId;
    }
    public void setAccBalance(double accBalance)  {
        this.accBalance = accBalance;
        updateFile(this.accBalance);
    }
    public double getAccBalance() throws FileNotFoundException {
        File filename = new File(getFilename());
        Scanner scn = new Scanner(filename);

        while (scn.hasNext())
        {
            String[] data = scn.nextLine().split(",");
            if (accId.equalsIgnoreCase(data[0]))
            {
                   accBalance = Double.parseDouble(data[1]);
            }
        }
        return accBalance;
    }
    public String getFilename(){
        return filename;
    }
    public void updateFile(double accBalance) {
        try
        {
            File filename = new File(getFilename());
            Scanner scn = new Scanner(filename);

            String content = "";

            String strAccBalance = String.valueOf(accBalance);

            while (scn.hasNextLine()) {
                String line = scn.nextLine();
                String[] data = line.split(",");
                if (accId.equalsIgnoreCase(data[0])) {
                    line = data[0] + "," + strAccBalance;
                    //System.out.println("change!");
                }

                content += line + "\n";
            }

            scn.close();

            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();

            //System.out.println("Done!");

        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
    }

    public String toString(){
        return accId + ',' + accBalance;
    }
}