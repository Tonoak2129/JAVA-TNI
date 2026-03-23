package MiniGameParty;

import MiniGameParty.old.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class TicTacToe extends JFrame implements Playable {
    private UserAccount userData;
    private static final Random random = new Random();

    private String slot = "123456789";
    private JButton[] buttons = new JButton[9];


    public TicTacToe(UserAccount userData) {
        this.userData = userData;
    }

    private void Board() {
        for (int i = 0; i < 9; i++) {
            int index = i;
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Tahoma", Font.BOLD, 40));

            buttons[i].addActionListener((ActionEvent e) -> playerMove(index));

            add(buttons[i]);
        }
    }//end of Board

    private void playerMove(int index) {
        // Player move
        slot = slot.substring(0, index) + 'X' + slot.substring(index + 1);
        buttons[index].setText("X");
        buttons[index].setEnabled(false);

        if (TicTacToe_CheckWin(slot, 'X'))
        {
            JOptionPane.showMessageDialog(this, "You win!");

            reward();
            dispose();
            return;
        }

        if (TicTacToe_Draw(slot))
        {
            JOptionPane.showMessageDialog(this, "Draw!");

            dispose();
            return;
        }

        // Bot move
        int botPick = TicTacToe_Bot(slot);

        slot = slot.substring(0, botPick) + 'O' + slot.substring(botPick + 1);
        buttons[botPick].setText("O");
        buttons[botPick].setEnabled(false);

        if (TicTacToe_CheckWin(slot, 'O'))
        {
            JOptionPane.showMessageDialog(this, "Bot wins!");

            dispose();
        }
    }//end of playerMove

    public static int TicTacToe_Bot(String slot) {
        while (true) {
            int index = random.nextInt(9);
            if (slot.charAt(index) == (char) ('1' + index))
            {
                return index;
            }
        }
    }//end of TicTacToe_Bot

    public static boolean TicTacToe_CheckWin(String slot, char mark) {
        // === roll ===
        for (int i = 0; i <= 6; i += 3)
        {
            if (slot.charAt(i) == mark && slot.charAt(i + 1) == mark && slot.charAt(i + 2) == mark)
                return true;
        }
        // === column ===
        for (int i = 0; i < 3; i++)
        {
            if (slot.charAt(i) == mark && slot.charAt(i + 3) == mark && slot.charAt(i + 6) == mark)
                return true;
        }
        // === diagonal ===
        if (slot.charAt(0) == mark && slot.charAt(4) == mark && slot.charAt(8) == mark)
            return true;

        else if (slot.charAt(2) == mark && slot.charAt(4) == mark && slot.charAt(6) == mark)
            return true;

        return false;
    }//end of TicTacToe_CheckWin

    static boolean TicTacToe_Draw(String slot) {
        for (int i = 0; i < slot.length(); i++) {
            if (slot.charAt(i) >= '1' && slot.charAt(i) <= '9')
                return false;
        }
        return true;
    }//end of TicTacToe_Draw

    @Override
    public void play() {
        setTitle("TIC TAC TOE");
        setSize(500, 500);
        setLayout(new GridLayout(3, 3));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Board();

        setVisible(true);
    }

    @Override
    public void reward() {
        if (userData != null) {
            int newCoin = userData.getCoin() + 5;
            userData.saveCoinToFile(newCoin);
        }

    }
}
