package MiniGameParty;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreService extends Store {

    public ArrayList<Store> getGameStoreList(){
        ArrayList<Store> games = new ArrayList<>();

        try {

            Scanner scn = new Scanner(new File(getStoreFile()));

            while(scn.hasNextLine()){

                String line = scn.nextLine();
                String[] data = line.split(",");

                String name = data[0];
                int price = Integer.parseInt(data[1]);

                games.add(new Store(name, price));
            }

            scn.close();

        }
        catch (IOException e)
        {
            System.out.println("Cannot read store");
        }
        return games;
    }

    public boolean gamePurchase(UserAccount user, String gameName, int gamePrice){

        int userCoin = user.getCoin();

        if (userCoin >= gamePrice)
        {
            user.saveCoinToFile(userCoin - gamePrice);
            user.addOwnedGameList(gameName);
            return true;
        }
        return false;
    }
}