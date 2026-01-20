import javax.swing.*;

public class ReturnBookTest {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", 5);

        while (true) {
            int choice = JOptionPane.showConfirmDialog(null
                    , "Do you want to borrow/return books?"
                    , "Borrow/Return Book"
                    , JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                int menu = Integer.parseInt(JOptionPane.showInputDialog(
                        "Press 1 to borrow book " +
                                "\nPress 2 to return book"));
                if (menu == 1) {
                    book.borrowBook();
                    if (book.getAvailableBook() >= 0) {
                        System.out.println("Borrowed 1 book, available " + book.getAvailableBook() + " books");
                        System.out.println("total:" + book.getTotalBook());
                        System.out.println("avai:" + book.getAvailableBook());
                    }
                    else JOptionPane.showMessageDialog(null,
                            "No books available to borrow...", "Warning Message", JOptionPane.WARNING_MESSAGE);
                }//end of borrow
            else if (menu == 2) {
                    book.returnBook();
                    System.out.println("total:" + book.getTotalBook());
                    System.out.println("avai:" + book.getAvailableBook());
                    if (book.getTotalBook() > book.getAvailableBook())
                        System.out.println("Returned 1 book, available " + book.getAvailableBook() + " books");
                    else JOptionPane.showMessageDialog(null,
                            "Cannot return! All books are already here", "Warning Message", JOptionPane.WARNING_MESSAGE);
                }
            else break;
            }
        }
        JOptionPane.showMessageDialog(null, "END PROGRAM");
    }
}


