import java.util.Scanner;
import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import java.util.ArrayList;

public class FinalProject {
    public void attemptingToUseGson() {
        try {
            Scanner sc = new Scanner(System.in);
            String bookType = "";
            boolean isNotABookType = true;
	    while (isNotABookType) {
	        System.out.println("Enter a genre (Options are: fiction, nonfiction, " +
		    "young-adult, graphic-books-and-manga and picture-books)");
	        String line = sc.nextLine();
	        if (line.equals("fiction")) {
	       	    System.out.println("Valid choice\n");
		    bookType = "hardcover-fiction";
	 	    isNotABookType = false;
	        } else if (line.equals("nonfiction")) {
		    System.out.println("Valid choice\n");
		    bookType = "hardcover-nonfiction";  
		    isNotABookType = false;
		} else if (line.equals("graphic-books-and-manga")){
                    System.out.println("Valid choice\n");
                    bookType = "graphic-books-and-manga";
                    isNotABookType = false;
                } else if (line.equals("picture-books")){
                    System.out.println("Valid choice\n");
                    bookType = "picture-books";
                    isNotABookType = false;
                } else if (line.equals("young-adult")){
                    System.out.println("Valid choice\n");
                    bookType = "young-adult-hardcover";
                    isNotABookType = false;
                } else {
                    System.out.println("Invalid choice.");
	        }
	    }
            HttpClient client = HttpClient.newHttpClient();	    
 	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.nytimes.com/svc/books/v3/lists/current/"
		+ bookType + ".json?api-key=GZ0j0yffgWXQx0eGBWDpxc4o9GQCcGYvreQld3oS7DMAQAe0")).GET().build();
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    ArrayList<Book> books = NYTParser.parse(response.body());
            System.out.println("The current top " + books.size() + " books are:");
	    for (int i = 0; i < books.size(); i++) {
	        System.out.println(books.get(i).getRank() + ". " + books.get(i).getTitle() + " written by "
		    + books.get(i).getAuthor());
		System.out.println("    " + books.get(i).getDescription());
	    }
	} catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
	    e.printStackTrace();
	}
    } 

    public static void main(String[] args) {
         FinalProject fp = new FinalProject();
	 fp.attemptingToUseGson();
    }
}
