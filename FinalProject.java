import java.util.Scanner;

public class FinalProject {
    private String[] books = {"The Inhertiance Games", "Little Women", "The Naurals", "Twilight", "Going the Mile"};
    public void displayBooks() {
        for (int i = 0; i < books.length; i++) {
            System.out.println((i+1) + ". " + books[i]);
        }
    }
    public static void main(String[] args) {
         FinalProject fp = new FinalProject();
         System.out.println("The current top 5 books are:");
         fp.displayBooks();

    }
}
