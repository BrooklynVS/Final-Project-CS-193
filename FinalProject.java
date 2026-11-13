import java.util.Scanner;
import java.net.http.*;
import java.net.URI;
import java.io.IOException;

public class FinalProject {
    private String[] books = {"The Inhertiance Games", "Little Women", "The Naurals", "Twilight", "Going the Mile"};

    public void attemptingToUseAPI() {
	try {
	HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.nytimes.com/svc/books/v3/lists/current/hardcover-fiction.json?api-key=GZ0j0yffgWXQx0eGBWDpxc4o9GQCcGYvreQld3oS7DMAQAe0"))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }
   
    public void displayBooks() {
        for (int i = 0; i < books.length; i++) {
            System.out.println((i+1) + ". " + books[i]);
        }
    }
    public static void main(String[] args) {
         FinalProject fp = new FinalProject();
         System.out.println("The current top 5 books are:");
         fp.displayBooks();
	 System.out.println();
	 System.out.println();
	 System.out.println();
	 fp.attemptingToUseAPI();
    }
}
