import java.util.ArrayList;
public class Library {
    /*
    Creates a new library and initializes it with some data
     */
    public Library()
    {
        setStartData();
    }
    ArrayList<Book> books = new ArrayList<Book>();

    //Creates some books and add them to the library book list
    public void setStartData(){
        Book book1 = new Book("Gossip","Jack Louis",1989,1);
        Book book2 = new Book("Monster","Jane Stevenson",2015,3);
        Book book3 = new Book("Fortress","Erik Johnson",1973,7);
        Book book4 = new Book("The autumn","My Dawson",2001,2);
        Book book5 = new Book("Fifty shades","Ed Clark",2018,1);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
    }
    //Add a book to the library
    public void addBook(String name,String author,int year,int edition){
        Book book = new Book(name,author,year,edition);
        books.add(book);
    }
    /*
    Search for requested book in the library list
    If exists, return the book object
    If not, return null
     */

    public Book searchBook(String name){
        for(Book book:books){
            if(book.name.equalsIgnoreCase(name)){
                return book;
            }
        }
        return null;
    }

    //Loops through books and if available att to new list, then return that new list
    public ArrayList<Book> listAllAvailableBooks(){
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        for(Book book:books){
            if(book.available){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    //Return book again by calling returnBook on book object.
    public void returnBook(Book book){
        book.returnBook();
    }
}
