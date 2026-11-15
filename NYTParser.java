import com.google.gson.*;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class NYTParser {

    public static ArrayList<Book> parse(String jsonData) {

        Gson gson = new Gson();

	JsonObject json = JsonParser.parseString(jsonData).getAsJsonObject();

        JsonObject results = json.getAsJsonObject("results");

        JsonArray books = results.getAsJsonArray("books");

        Type type = new TypeToken<ArrayList<Book>>(){}.getType();

        ArrayList<Book> bookList = gson.fromJson(books, type);

        return bookList;
    }
}
