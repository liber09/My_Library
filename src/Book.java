public class Book {
    String name;
    String author;
    int year;
    int edition;
    boolean available;

    //Creates new instance and initializes variables
    public Book(String name, String author, int year, int edition) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.edition = edition;
        this.available = true;
    }

    //Change available to false
    public void loan() {
        if (available) {
            available = false;
        }
    }
    //Change available to true
    public void returnBook(){
        available = true;
    }

    /*
    Overrides String.toString method and creates a book information string
    depending on if the book is available or not.
     */
    public String toString(){
        String bookInfo;
        if(available){
            bookInfo = "Boken: "+name+
                              "\nAv författaren: "+author+
                              "\nFrån år: "+year+
                              "\nI upplaga: "+edition+
                              "\nÄr tillgänglig\n";
        }
        else{
            bookInfo = "Boken: "+name+
                    "\nAv författaren: "+author+
                    "\nFrån år: "+year+
                    "\nI upplaga: "+edition+
                    "\nÄr inte tillgänglig\n";
        }
        return bookInfo;
    }
}