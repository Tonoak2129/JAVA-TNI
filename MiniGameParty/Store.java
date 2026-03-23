package MiniGameParty;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    private String gameName;
    private int gamePrice;

    private static final String filename = "src//MiniGameParty//store.txt";


    public Store(String gameName, int gamePrice) {
        this.gameName = gameName;
        this.gamePrice = gamePrice;
    }

    public Store(){}

    public String getGameName(){
        return gameName;
    }

    public int getGamePrice(){
        return gamePrice;
    }

    public String getStoreFile() {
        return filename;
    }
}