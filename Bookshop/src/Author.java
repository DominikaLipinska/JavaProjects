import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Author extends Person  {
    private List<Book> bookList;
    private int bookNum;

    private static List<Author> extent = new ArrayList<>();

    public Author(String firstName, String latsName) {
        super(firstName, latsName);
        this.bookList = new ArrayList<>();
        this.bookNum = bookList.size();
        addAuthor(this);
    }


    public Author(String firstName, String latsName, String phoneNumber, String email, Adres adres) {
        super(firstName, latsName, phoneNumber, email, adres);
        this.bookList = new ArrayList<>();
        this.bookNum = bookList.size();
        addAuthor(this);
    }

    private void addAuthor(Author author){
        extent.add(author);
    }

    public static void showExtent() {
        System.out.println("Extent of the class: " + Author.class.getName());

        for (Author author : extent) {
            System.out.println(author);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Author>) stream.readObject();
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
