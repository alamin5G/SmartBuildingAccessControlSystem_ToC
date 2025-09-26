import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args ){

        Book book1 = new Book("Java Book", "Sakib", "1234");
        Book book2 = new Book("C Book", "Sakib Mia", "1264");

        book2.displayBook();
        System.out.println(book1.getIsbn());
        System.out.println(book1.getAuthor());

        Lion lion = new Lion("Simba", 20);
        lion.eat();
        lion.roar();
    }
}
