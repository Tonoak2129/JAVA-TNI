package MiniGameParty;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Hangman extends JFrame implements Playable {
    private UserAccount userData;
    private static final Random random = new Random();

    private String word;
    private String categoryName;
    private String hiddenWord = "";
    private String inputSave = "";
    private int health = 5;

    private JLabel lbl_hint, lbl_word, lbl_health, lbl_guessed, lbl_status;
    private JTextField txt_input;

    public Hangman(UserAccount userData) {
        this.userData = userData;
    }

    private void initGame() {
        String[] catHolder = new String[1];
        this.word = Hangman_RandomWord(catHolder);
        this.categoryName = catHolder[0];

        for (int i = 0; i < word.length(); i++)
        {
            hiddenWord += "_";
        }
    }

    @Override
    public void play() {
        initGame();

        setTitle("HANGMAN");
        setSize(500, 450);
        setLayout(new GridLayout(6, 1, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        lbl_hint = new JLabel("Hint: " + categoryName, SwingConstants.CENTER);
        lbl_word = new JLabel(Hangman_DisplaySpace(hiddenWord), SwingConstants.CENTER);
        lbl_word.setFont(new Font("Tahoma", Font.BOLD, 30));

        lbl_health = new JLabel("Health: " + Hangman_HealthDisplay(health), SwingConstants.CENTER);
        lbl_health.setForeground(Color.RED);

        lbl_guessed = new JLabel("Already guessed: ", SwingConstants.CENTER);

        lbl_status = new JLabel("Type a letter and press Enter", SwingConstants.CENTER);

        txt_input = new JTextField();
        txt_input.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txt_input.setHorizontalAlignment(JTextField.CENTER);

        txt_input.addActionListener(e -> processGuess());

        add(lbl_hint);
        add(lbl_word);
        add(lbl_health);
        add(lbl_guessed);
        add(txt_input);
        add(lbl_status);

        setVisible(true);
    }

    private void processGuess() {
        String input = txt_input.getText().trim().toUpperCase();
        txt_input.setText("");

        if (input.length() != 1 || !Character.isLetter(input.charAt(0)))
        {
            lbl_status.setText("Please enter ONE letter (A-Z)");
            return;
        }

        char guessLetter = input.charAt(0);

        // === already guess ===
        if (inputSave.indexOf(guessLetter) != -1)
        {
            lbl_status.setText("Already guessed: " + guessLetter);
            return;
        }

        inputSave += guessLetter + " ";
        lbl_guessed.setText("Already guessed: " + inputSave);

        // === check word ===
        if (Hangman_CheckLetter(word, guessLetter))
        {
            hiddenWord = Hangman_Display(hiddenWord, word, guessLetter);
            lbl_word.setText(Hangman_DisplaySpace(hiddenWord));
            lbl_status.setText("Correct!");
        }
        else
        {
            health--;
            lbl_health.setText("Health: " + Hangman_HealthDisplay(health));
            lbl_status.setText("Wrong!");
        }

        checkGameStatus();
    }

    private void checkGameStatus() {
        if (Hangman_CheckWin(word, hiddenWord))
        {
            JOptionPane.showMessageDialog(this, "You Win!");

            reward();
            dispose();
        }
        else if (health <= 0)
        {
            JOptionPane.showMessageDialog(this, "You Lost! The word was: " + word);
            dispose();
        }
    }

    public static String Hangman_RandomWord(String[] category) {
        String[] animals = {"DOG", "MOLE", "BUNNY", "HORSE", "DOLPHIN", "ELEPHANT"};
        String[] foods = {"HAM", "UDON", "STEAK", "BURGER", "NOODLE", "KAPRAO"};
        String[] sports = {"TENNIS", "BOXING", "FOOTBALL", "VOLLEYBALL", "BASKETBALL", "TAKRAW"};

        int r = random.nextInt(3);
        if (r == 0)
        {
            category[0] = "Animal";
            return animals[random.nextInt(animals.length)];
        }
        else if (r == 1)
        {
            category[0] = "Food";
            return foods[random.nextInt(foods.length)];
        }
        else
        {
            category[0] = "Sport";
            return sports[random.nextInt(sports.length)];
        }
    }

    public static String Hangman_Display(String display, String word, char guessLetter) {
        StringBuilder newDisplay = new StringBuilder(display);
        for (int i = 0; i < word.length(); i++)
        {
            if (word.charAt(i) == guessLetter)
            {
                newDisplay.setCharAt(i, guessLetter);
            }
        }
        return newDisplay.toString();
    }

    static String Hangman_DisplaySpace(String display) {
        return String.join("  ", display.split(""));
    }

    static boolean Hangman_CheckWin(String word, String guess) {
        return word.equalsIgnoreCase(guess);
    }

    static boolean Hangman_CheckLetter(String word, char guessLetter) {
        return word.indexOf(guessLetter) != -1;
    }

    static String Hangman_HealthDisplay(int health) {
        String h = "";
        for (int i = 0; i < health; i++) h += "❤ ";
        return h;
    }

    @Override
    public void reward() {
        if (userData != null)
        {
            int newCoin = userData.getCoin() + 10;
            userData.saveCoinToFile(newCoin);
        }
    }
}
