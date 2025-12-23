import java.util.Scanner;

public class Lab602 {
    public static Scanner scn = new Scanner(System.in);
    public static void find_rank( double rating , double[] ranking) {
        int rank = ranking.length+1;
        for (int i = 0;i<ranking.length;i++){
            if(rating>=ranking[i]){
                rank--;
            }
        }
        System.out.println("This movie is ranked number " + rank);
    }

    public static void main(String[] args) {
        String[] movies = {"Me Before You", "Titanic", "Before Sunrise", "The Holiday", "A Walk to Remember"};
        double[] rate_scores = {4.2, 4.9, 4.4, 3.7, 4.3};
        int found = 0;
        System.out.print("Enter a movies title: ");
        String search = scn.nextLine();
        System.out.println("");

        for (int i = 0; i<movies.length;i++) {
            if (search.equalsIgnoreCase(movies[i])) {
                System.out.println("The rating score of " + movies[i] + "\" is " + rate_scores[i]);
                find_rank(rate_scores[i],rate_scores);
                found++;
            }
        }
        if (found==0) System.out.println("Cannot found this movie title...");
    }
}
