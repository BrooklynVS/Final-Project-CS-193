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
	        System.out.println("Enter a genre (Either hardcover-fiction or hardcover-nonfiction)");
	        String line = sc.nextLine();                                    
	        if (line.equals("hardcover-fiction")) {                             
	       	    System.out.println("Valid choice\n");           
		    bookType = "hardcover-fiction";                 		
	 	    isNotABookType = false;                         	    
	        } else if (line.equals("hardcover-nonfiction")) {                   
		    System.out.println("Valid choice\n");		
	            bookType = "hardcover-nonfiction";  
		    isNotABookType = false;
	        } else {                                                            
                    System.out.println("Invalid choice.");                      
	        }                                                           
	    }
            HttpClient client = HttpClient.newHttpClient();	    
 	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://api.nytimes.com/svc/books/v3/lists/current/" + bookType + ".json?api-key=GZ0j0yffgWXQx0eGBWDpxc4o9GQCcGYvreQld3oS7DMAQAe0")).GET().build();
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    ArrayList<Book> books = NYTParser.parse(response.body());
            System.out.println("The current top 15 books are:");
	    for (int i = 0; i < books.size(); i++) {
	        System.out.println((i + 1) + ". " + books.get(i).getTitle() + " written by " + books.get(i).getAuthor());
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
