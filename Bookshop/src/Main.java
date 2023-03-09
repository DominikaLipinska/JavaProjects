import java.io.*;

public class Main {
    public static void main(String[] args) {
        final String extentFile = "extent.ser";
        Author author1 = new Author("Name1","Surname1");
        Author author2 = new Author("Name2", "Surname2");
        Book book1 = new Book("T1",author1,2020,12);
        Book book2 = new Book("T2",author2,2023,30,0.2);

        Book.showExtent();
        Author.showExtent();
        var rabateBookList = Book.findRabateBook();
        System.out.println(rabateBookList);

        System.out.println(book2.getPrice(0.2));

        try{
            var out = new ObjectOutputStream(new FileOutputStream(extentFile));
            Book.writeExtent(out);
            Author.writeExtent(out);
            out.close();

            var in = new ObjectInputStream(new FileInputStream(extentFile));
            Book.readExtent(in);
            Author.readExtent(in);
            in.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        Book.showExtent();
        Author.showExtent();
    }
}
