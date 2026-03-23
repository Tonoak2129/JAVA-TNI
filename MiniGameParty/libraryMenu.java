package MiniGameParty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class libraryMenu extends JFrame {

    private JPanel Library;
    private JLabel lbl_library;
    private JPanel headerPanel;
    private JPanel listPanel;
    private JButton but_back;
    private JLabel lbl_coin;

    private UserAccount userData;
    private GameHub gameService;

    public libraryMenu(String username , String password){
        userData = new UserAccount(username , password);
        int coin = userData.getCoin();

        // === user coin ===
        lbl_coin.setText("COIN : " + coin);
        lbl_coin.setForeground(Color.WHITE);
        lbl_coin.setFont(new Font("Tahoma", Font.BOLD, 30));
        lbl_coin.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl_coin.setBorder(BorderFactory.createEmptyBorder(0,0,0,20));

        Library.setLayout(new BorderLayout());

        // === header ===
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(119,0,200)); //bar color

        lbl_library.setForeground(Color.WHITE);
        lbl_library.setFont(new Font("Tahoma", Font.BOLD, 80));

        but_back.setFont(new Font("Tahoma", Font.BOLD, 20));

        headerPanel.add(lbl_library, BorderLayout.WEST);
        headerPanel.add(lbl_coin, BorderLayout.CENTER);
        headerPanel.add(but_back, BorderLayout.EAST);

        // === owned list ===
        UserAccount account = new UserAccount(username , password);

        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(20,20,20));
        listPanel.setOpaque(true);
        listPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] gameNames = account.setOwnedGameList();
        if (gameNames != null) {
            for (String g : gameNames) {
                if (g == null || g.trim().isEmpty()) continue;
                JPanel row = createGameRow(g.trim());

                row.setAlignmentX(Component.LEFT_ALIGNMENT);
                row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));
                listPanel.add(row);
            }
        }

        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setBackground(new Color(20,20,20));

        JScrollPane scroll = new JScrollPane(listPanel,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scroll.getViewport().setBackground(listPanel.getBackground());

        centerWrapper.add(scroll, BorderLayout.CENTER);

        Library.add(headerPanel, BorderLayout.NORTH);
        Library.add(centerWrapper, BorderLayout.CENTER);

        but_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new homeMenu(username , password);
            }
        });

        setTitle("Game Party");
        setContentPane(Library);
        setMinimumSize(new Dimension(1300,700));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createGameRow(String gameName){
        JPanel row = new JPanel(new BorderLayout());
        row.setBackground(new Color(220,220,220)); //bg color
        row.setBorder(BorderFactory.createEmptyBorder(20,40,20,40));

        JLabel gameLabel = new JLabel(gameName);
        gameLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
        gameLabel.setForeground(Color.RED);

        // === play buttons ===
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Tahoma", Font.BOLD, 28));
        playButton.setFocusPainted(false);
        playButton.setPreferredSize(new Dimension(180, 60));

        gameService = new GameHub(userData);
        playButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, gameName + " started!");
            gameService.launch(gameName);

            // === check for window close ===
            // === update coin after win ===
            Window[] windows = Window.getWindows();
            for (Window window : windows)
            {
                if (window instanceof JFrame gameFrame && window != this && window.isVisible())
                {
                    gameFrame.addWindowListener(new java.awt.event.WindowAdapter()
                    {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent)
                        {
                            lbl_coin.setText("COIN : " + userData.getCoin());
                        }
                    });
                }
            }
        });

        JPanel spacer = new JPanel();
        spacer.setOpaque(false);

        row.add(gameLabel, BorderLayout.WEST);
        row.add(spacer, BorderLayout.CENTER);
        row.add(playButton, BorderLayout.EAST);

        return row;
    }

    public static void main(String[] args){
        libraryMenu test = new libraryMenu("test" , "abc");
    }
}