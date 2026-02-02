public class Movie {
    private String title;
    private int minute;
    private String rating;

    public Movie(String title,int minute,String rating){
        this.title = title;
        this.minute = minute;
        this.rating= rating;
    }
    public Movie(){
        this(" ", 0, " ");
    }
    public String getTitle(){
        return this.title;
    }
    public String toString(){
        return this.title + " (" + this.rating + ", " + this.minute + " mins)";
    }
}
