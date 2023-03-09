import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {
    private String title;
    private Author author;
    private int year;
    private float price;
    private Double rabate;
    private static double maxRabate = 0.3;
    private static List<Book> extent = new ArrayList<>();

    public Book(String title,Author author, int year, float price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        addBook(this);
    }

    public Book(String title,Author author, int year, float price, Double rabate) {
        this(title,author,year,price);
        this.rabate = rabate;
    }

    private void addBook(Book book){
        extent.add(book);
    }
    private void removeBook(Book book){
        extent.remove(book);
    }
    private void removeBook(List<Book> books){extent.removeAll(books);}

    public Float getPrice(){return price;}
    public Float getPrice(double rabate) {
        if (rabate<0 || rabate>1){
            return null;
        }else {
            return price*(1-(float) rabate);
        }
    }

    public static void showExtent() {
        System.out.println("Extent of the class: " + Book.class.getName());

        for (Book book : extent) {
            System.out.println(book);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Book>) stream.readObject();
    }

    public static List<Book> findRabateBook(){
        List<Book> rabateBook = new ArrayList<>();
        for (Book book : extent) {
            if (book.rabate != null) rabateBook.add(book);
        }
        return rabateBook;
    }

    @Override
    public String toString() {
        return "Book: \""+title+"\" "+ author +" "+ year + " price: " + price + " rabte: " + rabate;
    }
}

