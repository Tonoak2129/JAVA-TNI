package MiniGameParty;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class UserAccount {
    private String username;
    private String password;
    private int coin;

    private String[] ownedGameList;

    private final String filename = "src/MiniGameParty/users.txt";


    public UserAccount(String username , String password , int coin){
        this.username = username;
        this.password = password;
        this.coin = coin;
    }

    public UserAccount(String username , String password){
        this(username,password,0);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getUserFile() {
        return filename;
    }

    public int  getCoin() {
        Scanner scn = null;
        try {
            File filename = new File(getUserFile());
            scn = new Scanner(filename);

            while (scn.hasNext()) {
                String[] data = scn.nextLine().split(",");
                if (username.equalsIgnoreCase(data[0])) {
                    coin = Integer.parseInt(data[2]);
                }
            }
            scn.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Cannot get coin");
        }
        finally
        {
            if (scn != null)
            {
                scn.close();
            }
        }
        return coin;
    }

    public void saveCoinToFile(int coin) {
        this.coin = coin;
        updateFile();
    }

    public String[] setOwnedGameList(){
        Scanner scn = null;
        try {
            File filename = new File(getUserFile());
            scn = new Scanner(filename);

            while (scn.hasNextLine()) {

                String[] data = scn.nextLine().split(",");

                if (username.equalsIgnoreCase(data[0])) {

                    if(data.length < 4 || data[3].trim().isEmpty()){
                        ownedGameList = new String[]{"Rock Paper Scissors"};
                    }
                    else{
                        ownedGameList = data[3].split("\\|");
                    }

                }
            }
            scn.close();
        }
        catch (IOException e) {
            System.out.println("Cannot read user file");
        }
        finally
        {
            if (scn != null)
            {
                scn.close();
            }
        }
        return ownedGameList;
    }

    public void addOwnedGameList(String gameName) {

        String gameNameFormatted = "";
        String[] splitName = gameName.split(" ");

        // === capital letter format ===
        for (int i = 0; i < splitName.length; i++)
        {
            gameNameFormatted += splitName[i].substring(0,1).toUpperCase()
                    + splitName[i].substring(1).toLowerCase()
                    + " ";
        }
        gameNameFormatted = gameNameFormatted.trim();

        // === add game ===
        if (!hasGame(gameName)) {
            ownedGameList = Arrays.copyOf(ownedGameList, ownedGameList.length + 1);
            ownedGameList[ownedGameList.length - 1] = gameNameFormatted;

            updateFile();
        }
    }

    public boolean hasGame(String game){
        setOwnedGameList();

        for(String g : ownedGameList){
            if(g.equalsIgnoreCase(game)){
                return true;
            }
        }

        return false;
    }

    public void updateFile(){
        Scanner scn = null;
        try
        {
            File path = new File(getUserFile());
            scn = new Scanner(path);

            String content = "";

            while (scn.hasNextLine()) {
                String line = scn.nextLine();
                String[] data = line.split(",");
                if (username.equalsIgnoreCase(data[0])) {
                    line = toString();
                }

                content += line + "\n";
            }

            scn.close();

            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();
        }
        catch (IOException e)
        {
            System.out.println("Cannot update coin");
        }
        finally
        {
            if (scn != null)
            {
                scn.close();
            }
        }
    }

    public String toString(){
        if (ownedGameList == null)
        {
            setOwnedGameList();
        }

        if (ownedGameList == null || ownedGameList.length == 0)
        {
            ownedGameList = new String[]{"Rock Paper Scissors"};
        }

        return username.toLowerCase() + ',' + password + ',' + coin + ',' + String.join("|", ownedGameList);
    }
}
