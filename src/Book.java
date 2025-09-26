public class Book {
    String title;
    private String author;
    private String isbn;


    // Constructor
    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getAuthor(){
        return author;
    }

    public void displayBook(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

}


