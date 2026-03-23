package MiniGameParty;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RockPaperScissors extends JFrame implements Playable {

    private UserAccount userData;
    private static final Random random = new Random();

    private int playerHealth = 3;
    private int botHealth = 3;

    private  JPanel RockPaperScissors;
    private JPanel btnPanel;

    private JLabel lbl_status;
    private JLabel lbl_result;

    private JButton btn_rock;
    private JButton btn_paper;
    private JButton btn_scissor;


    public RockPaperScissors(UserAccount userData) {
        this.userData = userData;
    }

    private void initGame() {
        playerHealth = 3;
        botHealth = 3;
    }

    @Override
    public void play() {
        initGame();

        setContentPane(RockPaperScissors);
        setTitle("ROCK PAPER SCISSORS");
        setSize(500, 400);
        setLayout(new GridLayout(4, 1, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        lbl_status.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_result.setHorizontalAlignment(SwingConstants.CENTER);

        lbl_status.setText(getStatusText());
        lbl_status.setFont(new Font("Tahoma", Font.BOLD, 20));

        lbl_result.setText("Choose your move");
        lbl_result.setFont(new Font("Tahoma", Font.PLAIN, 18));

        btn_rock.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn_paper.setFont(new Font("Tahoma", Font.BOLD, 16));
        btn_scissor.setFont(new Font("Tahoma", Font.BOLD, 16));

        btn_rock.addActionListener(e -> processChoice(1));
        btn_paper.addActionListener(e -> processChoice(2));
        btn_scissor.addActionListener(e -> processChoice(3));

        add(lbl_status);
        add(lbl_result);
        add(btnPanel);

        setVisible(true);
    }

    private void processChoice(int playerChoice) {

        int botChoice = RockPaperScissors_Bot();
        String result = RockPaperScissors_CheckWin(playerChoice, botChoice);

        if (result.equals("Player wins")) {
            botHealth--;
        } else if (result.equals("Bot wins")) {
            playerHealth--;
        }

        lbl_result.setText("Player: " + convert(playerChoice) +
                " | Bot: " + convert(botChoice) +
                " → " + result);

        lbl_status.setText(getStatusText());

        checkGameStatus();
    }

    private void checkGameStatus() {
        if (playerHealth <= 0 || botHealth <= 0) {

            String finalResult = (playerHealth > botHealth) ? "YOU WIN!" : "YOU LOSE!";

            JOptionPane.showMessageDialog(this, finalResult);

            reward();
            dispose();
        }
    }

    private String getStatusText() {
        return "Player HP: " + playerHealth + "   |   Bot HP: " + botHealth;
    }

    private String convert(int choice) {
        if (choice == 1) return "Rock";
        if (choice == 2) return "Paper";
        return "Scissors";
    }


    public static int RockPaperScissors_Bot() {
        return random.nextInt(3) + 1;
    }

    public static String RockPaperScissors_CheckWin(int player, int bot) {
        if (player == bot) return "Draw";
        if (
                (player == 1 && bot == 3) ||
                        (player == 2 && bot == 1) ||
                        (player == 3 && bot == 2)
        ) {
            return "Player wins";
        }
        return "Bot wins";
    }

    @Override
    public void reward() {
        int coin;
        if (playerHealth == 3)
        {
            coin = 15;
        }
        else if (playerHealth < 3 && playerHealth > 0)
        {
            coin = 15;
        }
        else
        {
            coin = 0;
        }

        if (userData != null)
        {
            int newCoin = userData.getCoin() + coin;
            userData.saveCoinToFile(newCoin);
        }
    }
}