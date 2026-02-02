import javax.swing.*;

public class TicketInfo {
    public String select_showtime(Movie movie){
        int choice = Integer.parseInt(JOptionPane.showInputDialog(movie +
                "\nPress 1 to select show time = 13:00" +
                "\nPress 2 to select show time = 14:00" +
                "\nPress 3 to select show time = 15:00" +
                "\nEnter a number:"));
        if (choice == 1) return "13:00";
        if (choice == 2) return "14:30";
        if (choice == 3) return "15:00";
        return "Error time";
    }
    public String select_seat_number(){
        String row = JOptionPane.showInputDialog("Select seat row [A-G]:");
        String number = JOptionPane.showInputDialog("Select seat number [1-12]:");
        return row.toUpperCase()+number;
    }

    public void main(String[] args) {
        Movie movie = new Movie("Titanic",120,"PG-13");
        String show_time = select_showtime(movie);
        String seat_number = select_seat_number();

        Ticket ticket = new Ticket("T001",movie,show_time,seat_number,240);
        JOptionPane.showMessageDialog(null,ticket);
    }
}
