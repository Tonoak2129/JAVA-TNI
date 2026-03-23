package MiniGameParty;

import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homeMenu extends JFrame{
    private JPanel homeMenu;
    private JLabel lbl_homeMenu;
    private JButton but_library;
    private JButton but_store;
    private JButton but_logout;
    private JLabel lbl_library;
    private JLabel lbl_store;
    private JLabel lbl_logout;
    private JPanel headerPanel;
    private JButton but_profile;
    private JLabel lbl_username;
    private JLabel lbl_coin;

    private UserAccount userData;

    private ImageIcon resizeIcon(String path, int width, int height) {
        ImageIcon icon = new ImageIcon(path);
        Image img = icon.getImage();
        Image scaled = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }

    public homeMenu(String username , String password) {
        userData = new UserAccount(username, password);
        int coin = userData.getCoin();

        // ==== Header ====
        headerPanel.setBackground(new Color(119,0,200)); //bar color
        headerPanel.setPreferredSize(new Dimension(0, 100));

        // ==== user profile ===
        lbl_username.setText(username);
        lbl_username.setForeground(Color.WHITE);
        lbl_username.setFont(new Font("Tahoma", Font.BOLD, 40));
        but_profile.setIcon(resizeIcon("src/img/userProfile.jpg", 100, 100));

        // === user coin ===
        lbl_coin.setText("COIN : " + coin);
        lbl_coin.setForeground(Color.WHITE);
        lbl_coin.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbl_coin.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_coin.setBorder(BorderFactory.createEmptyBorder(0,0,0,50));

        // === buttons ===
        lbl_homeMenu.setFont(new Font("Tahoma", Font.BOLD, 60));
        lbl_library.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lbl_store.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lbl_logout.setFont(new Font("Tahoma", Font.PLAIN, 40));

        but_library.setIcon(resizeIcon("src/img/gameFolder.png", 280, 280));
        but_store.setIcon(resizeIcon("src/img/gameStore.png", 280, 280));
        but_logout.setIcon(resizeIcon("src/img/gameLogout.png", 280, 280));

        but_library.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new libraryMenu(username, password);
            }
        });

        but_store.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new storeMenu(username, password);
            }
        });

        but_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new mainMenu();
            }
        });

        setTitle("Game Party");
        setContentPane(homeMenu);
        setMinimumSize(new Dimension(1300, 700));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new homeMenu("test" , "abc");
    }
}