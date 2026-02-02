import javax.swing.*;

public class TicketUsed {
    public static String show_movie_list(Ticket... tickets) {
        String list = "";
        for (Ticket t : tickets){
            list += t.getTicket() + ": " + t.getMovie() + "\n";
        }
        return list;
    }

    public static void main(String[] args) {
        Ticket[] tickets = new Ticket[]{
                new Ticket("T001", new Movie("Titanic", 120, "PG-13"), "12:00", "B7", 280),
                new Ticket("T002", new Movie("Pokemon", 102, "PG"), "11:00", "G11", 240),
                new Ticket("T003", new Movie("Silent Hill", 125, "R-13"), "14:30", "H2", 240)
        };
        Ticket movieMenu = null;
        int Yes_No = JOptionPane.showConfirmDialog
                (null,"Do you want to book or use a ticket?","ticket",JOptionPane.YES_NO_OPTION);

        if (Yes_No==JOptionPane.YES_OPTION) {

            while (true) {
                String input = JOptionPane.showInputDialog(show_movie_list(tickets) + "\nEnter a ticket id for booking:");
                for (Ticket t : tickets){
                    if (t.getTicket().equalsIgnoreCase(input)) movieMenu = t;
                }
                int choice = Integer.parseInt(JOptionPane.showInputDialog(movieMenu.getMovie() +
                        "\nPress 1 to book a ticket" +
                        "\nPress 2 to use a ticket" +
                        "\nPress 3 to see a ticket status" +
                        "\n\nEnter a menu:"));
                if (choice == 1) {
                    JOptionPane.showMessageDialog(null ,
                            movieMenu.bookTicket() +
                                    "\n-------------------------\n" +
                                    movieMenu);
                }
                if (choice == 2) {
                    JOptionPane.showMessageDialog(null ,
                            movieMenu.useTicket() +
                                    "\n-------------------------\n" +
                                    movieMenu);
                }
                if (choice == 3) {
                    JOptionPane.showMessageDialog(null ,movieMenu);
                    Yes_No = JOptionPane.showConfirmDialog
                            (null,"Do you want to book or use other tickets?",
                                    "ticket",
                                    JOptionPane.YES_NO_OPTION);
                    if (Yes_No==JOptionPane.YES_OPTION) continue;
                    else break;

                }
            }
        }

    }
}