public class Book {
    private String title;
    private int totalBook;
    private int availableBook;

    public Book(String title , int totalBook){
        this.title = title;
        this.totalBook = totalBook;
        this.availableBook = totalBook;
    }
    public Book(String title){
        this(title,0);
    }
    public Book(int totalBook) {
        this("",totalBook);
        this.availableBook = totalBook;
    }
    public Book(){
        this("",0);
    }
    public String getTitle(){
        return this.title;
    }
    public int getTotalBook(){
        return this.totalBook;
    }
    public int getAvailableBook(){
        return this.availableBook;
    }
    public void borrowBook(){
        if (this.availableBook >= 0) this.availableBook -= 1;
    }
    public void returnBook(){
        if (this.availableBook < this.totalBook) this.availableBook += 1;
    }
}
