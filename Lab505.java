import javax.swing.*;

public class Lab505 {
    public static boolean is_palindrome(String word){
        word = word.trim();
        StringBuilder builder = new StringBuilder(word);
        StringBuilder wordReverse = builder.reverse();
        return word.equalsIgnoreCase(String.valueOf(wordReverse));
    }
    public static void main(String[] args) {
        String word = JOptionPane.showInputDialog("Ender some word :");
        JOptionPane.showMessageDialog(null,word + (is_palindrome(word)?" is":" is NOT") +" Palindrome");
    }
}
