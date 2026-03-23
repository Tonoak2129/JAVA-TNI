package MiniGameParty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Highlow extends JFrame implements Playable {
    private UserAccount userData;
    private static final int[] numbers = {12, 78, 45, 90, 3, 67, 25, 88, 54, 31};
    private int currentIndex = 0;
    private int currentNumber;
    private int nextNumber;

    private JLabel lbl_number;
    private JLabel lbl_status;
    private JButton highBtn;
    private JButton lowBtn;
    private JPanel buttonPanel;

    private int correctGuesses = 0;
    private int totalRounds = 0;

    public Highlow(UserAccount userData) {
        this.userData = userData;
    }

    private int getNextNumber() {
        int num = numbers[currentIndex];
        currentIndex = (currentIndex + 1) % numbers.length;

        return num;
    }

    @Override
    public void play() {
        setTitle("High & Low Game");
        setSize(500, 400);
        setLayout(new BorderLayout(10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        currentNumber = getNextNumber();

        lbl_status.setText("Round: 1/3 | Correct guess: 0");
        lbl_status.setFont(new Font("Tahoma", Font.BOLD, 20));
        lbl_status.setHorizontalAlignment(SwingConstants.CENTER);

        lbl_number.setText("Number: " + currentNumber);
        lbl_number.setFont(new Font("Tahoma", Font.BOLD, 45));
        lbl_number.setHorizontalAlignment(SwingConstants.CENTER);

        highBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
        lowBtn.setFont(new Font("Tahoma", Font.BOLD, 20));

        highBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processChoice("HIGH");
            }
        });

        lowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processChoice("LOW");
            }
        });

        add(lbl_status, BorderLayout.NORTH);
        add(lbl_number, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void processChoice(String choice) {
        nextNumber = getNextNumber();
        totalRounds++;

        boolean isCorrect = false;
        if (nextNumber > currentNumber && choice.equals("HIGH")) isCorrect = true;
        else if (nextNumber < currentNumber && choice.equals("LOW")) isCorrect = true;

        if (nextNumber == currentNumber)
        {
            JOptionPane.showMessageDialog(this, "Tie! next number is " + nextNumber);
            totalRounds--;
        }
        else if (isCorrect)
        {
            correctGuesses++;
            JOptionPane.showMessageDialog(this, "Correct! next number is " + nextNumber);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Wrong! next number is " + nextNumber);
        }

        currentNumber = nextNumber;
        lbl_number.setText("Number: " + currentNumber);
        lbl_status.setText("Round: " + (totalRounds + 1) + "/3 | Correct guess: " + correctGuesses);

        if (totalRounds >= 3) {
            reward();
        }
    }

    @Override
    public void reward() {
        int coin;
        String message = "You guess correct " + correctGuesses + " times";

        if (correctGuesses == 3)
        {
            coin = 20;
            message += "\nGreat! you earned " + coin + " coins";
        }
        else if (correctGuesses == 2)
        {
            coin = 5;
            message += "\ngood! you got " + coin + " coins";
        }
        else
        {
            coin = 0;
            message += "\nNice try! ";
        }

        JOptionPane.showMessageDialog(this, message);

        dispose();

        if (userData != null) {
            int currentCoin = userData.getCoin();
            userData.saveCoinToFile(currentCoin + coin);
        }
    }
}