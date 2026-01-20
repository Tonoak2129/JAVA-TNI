import javax.swing.*;

public class BorrowBookTest {
    public static void main(String[] args) {
        Book book = new Book("C# Programming",0);

        int choice = JOptionPane.showConfirmDialog(null
                ,"Do you want to borrow books?"
                , "Borrow Book"
                , JOptionPane.YES_NO_OPTION);
        if (choice == 0){
            book.borrowBook();
            if (book.getAvailableBook()>0) System.out.println("Borrowed 1 book, available " + book.getAvailableBook() + " books");
            else JOptionPane.showMessageDialog(null,
                    "No books available to borrow...","Warning Message",JOptionPane.WARNING_MESSAGE);
        }
        else JOptionPane.showMessageDialog(null, "END PROGRAM");
    }
}
