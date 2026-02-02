public class Ticket {
    private String ticket_id;
    private Movie movie;
    private String show_time;
    private String seat_number;
    private double price;
    private boolean is_booked;
    private boolean is_used;

    public Ticket(String ticket_id, Movie movie, String show_time, String seat_number, double price){
        this.ticket_id = ticket_id;
        this.movie = movie;
        this.show_time = show_time;
        this.seat_number = seat_number;
        this.price = price;
    }
    public Ticket(){
        this("",null,"","",0.0);
    }
    public String getTicket(){
        return ticket_id;
    }
    public Movie getMovie(){
        return movie;
    }
    public String bookTicket(){
        if (!is_booked) {
            is_booked = true;
            return "Ticket booked successfully!!";
        }
        return "This ticket is already booked";
    }
    public String useTicket(){
        if (!is_booked) return "Please book the ticket first";
        if (!is_used) {
            is_used = true;
            return "Enjoy the movie";
        }
        return "Ticket already used";
    }
    public String toString(){
        return "Ticket Id: " + ticket_id +
                "\nMovie: " + movie +
                "\nShow Time: " + show_time +
                "\nSeat Number: " + seat_number +
                "\nTicket Price: " + price +
                "\nBooked: " + ((is_booked)? "Yes":"No") +
                "\nUsed: " + ((is_used)? "Yes":"No");
    }
}
