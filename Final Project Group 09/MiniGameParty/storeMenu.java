package MiniGameParty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class storeMenu extends JFrame {

    private JPanel Store;
    private JLabel lbl_store;
    private JPanel headerPanel;
    private JPanel listPanel;
    private JButton but_back;
    private JLabel lbl_coin;

    private UserAccount userData;
    private StoreService buyGame;
    private StoreService gameStore;

    public storeMenu(String username , String password){
        userData = new UserAccount(username , password);
        buyGame = new StoreService();
        int coin = userData.getCoin();

        // === user coin ===
        lbl_coin.setText("COIN : " + coin);
        lbl_coin.setForeground(Color.WHITE);
        lbl_coin.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbl_coin.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_coin.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));

        Store.setLayout(new BorderLayout());

        // === header ===
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(119,0,200)); //bar color

        lbl_store.setForeground(Color.WHITE);
        lbl_store.setFont(new Font("Tahoma", Font.BOLD, 80));

        but_back.setFont(new Font("Tahoma", Font.BOLD, 20));

        headerPanel.add(lbl_store, BorderLayout.WEST);
        headerPanel.add(lbl_coin, BorderLayout.CENTER);
        headerPanel.add(but_back, BorderLayout.EAST);

        // === shop list ===
        gameStore = new StoreService();

        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(20,20,20));
        listPanel.setOpaque(true);
        listPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        ArrayList<Store> games = gameStore.getGameStoreList();

        for(Store g : games){

            JPanel row = createGameRow(g.getGameName(), g.getGamePrice(), coin);

            row.setAlignmentX(Component.LEFT_ALIGNMENT);
            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

            listPanel.add(row);
        }


        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setBackground(new Color(20,20,20));

        JScrollPane scroll = new JScrollPane(listPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scroll.getViewport().setBackground(listPanel.getBackground());

        centerWrapper.add(scroll, BorderLayout.CENTER);

        Store.add(headerPanel, BorderLayout.NORTH);
        Store.add(centerWrapper, BorderLayout.CENTER);

        but_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new homeMenu(username , password);
            }
        });

        setTitle("Game Party");
        setContentPane(Store);
        setMinimumSize(new Dimension(1300,700));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createGameRow(String gameName, int price, int coin){

        JPanel row = new JPanel(new BorderLayout());
        row.setBackground(new Color(220,220,220));
        row.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        JLabel gameLabel = new JLabel(gameName);
        gameLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
        gameLabel.setForeground(Color.RED);

        JLabel priceLabel = new JLabel(price + " Coin");
        priceLabel.setFont(new Font("Tahoma", Font.BOLD, 28));

        JButton buyButton = new JButton("Buy");
        buyButton.setFont(new Font("Tahoma", Font.BOLD, 28));
        buyButton.setPreferredSize(new Dimension(180,60));

        // already owned game
        if(userData.hasGame(gameName)){
            buyButton.setText("Owned");
            buyButton.setEnabled(false);
        }

        buyButton.addActionListener(e -> {
            boolean success = buyGame.gamePurchase(userData, gameName, price);

            if(success)
            {
                lbl_coin.setText("COIN : " + userData.getCoin());

                buyButton.setText("Owned");
                buyButton.setEnabled(false);

                JOptionPane.showMessageDialog(this, gameName + " added to your library!");

            }
            else
            {
                JOptionPane.showMessageDialog(this, "Not enough coin");
            }

        });

        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT,20,0));
        rightPanel.setOpaque(false);
        rightPanel.add(priceLabel);
        rightPanel.add(buyButton);

        JPanel spacer = new JPanel();
        spacer.setOpaque(false);

        row.add(gameLabel, BorderLayout.WEST);
        row.add(spacer, BorderLayout.CENTER);
        row.add(rightPanel, BorderLayout.EAST);

        return row;
    }

    public static void main(String[] args){
        new storeMenu("test" , "abc");
    }
}