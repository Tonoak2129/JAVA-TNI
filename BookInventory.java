import javax.swing.*;

public class BookInventory {
    public static void main(String[] args) {
        Book[] books = new Book[3];

        for (int i = 0; i < books.length;i++) {
            books[i] = new Book(JOptionPane.showInputDialog("Enter book title:"),
                    Integer.parseInt(JOptionPane.showInputDialog("Enter the total number:")));
        }
        for (int i = 0; i < books.length;i++){
            System.out.println(books[i].getTitle() + " has " + books[i].getTotalBook() + " books, can borrow"
             + books[i].getAvailableBook() + " books");
        }
    }
}
