import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner input = new Scanner(System.in);
        ArrayList<String> menu = new ArrayList<String>();
        int usersChoice;

        menu.add("1.Lägg till en bok i biblioteket");
        menu.add("2.Sök efter en bok");
        menu.add("3.Lista alla tillgängliga böcker");
        menu.add("4.Återlämna en bok");
        menu.add("5.Avsluta");
        System.out.println("Välkommen till biblioteket!");

        do {
            for (String menuOption:menu)
            {
                System.out.println(menuOption);
            }
            usersChoice = input.nextInt();
            input.nextLine();

            switch(usersChoice){
                case 1:
                    System.out.println("Ange bokens namn: ");
                    String name = input.nextLine();
                    System.out.println("Ange författarens namn: ");
                    String author = input.nextLine();
                    System.out.println("Ange årtal: ");
                    int year = input.nextInt();
                    System.out.println("Ange upplaga: ");
                    int edition = input.nextInt();
                    input.nextLine();
                    library.addBook(name,author,year,edition);
                    System.out.println("Tack,boken "+name+" är tillagd.");
                    break;
                case 2:
                    System.out.println("Vilken bok söker du efter?");
                    String wantedBook = input.nextLine();
                    Book book = library.searchBook(wantedBook);
                    if (book != null && book.available)
                    {
                        System.out.println(book);
                        System.out.println("Vill du låna boken?\n1.Ja/2.Nej");
                        int loanBook = input.nextInt();
                        if(loanBook == 1){
                            book.loan();
                            System.out.println("Trevlig läsning och välkommen åter!");
                        }
                    }
                    else if(book != null)
                    {
                        System.out.println(book);
                    }
                    else
                    {
                        System.out.println("Tyvärr finns inte boken du letade efter...");
                    }
                    break;
                case 3:
                    ArrayList<Book> availableBooks = library.listAllAvailableBooks();
                    for(Book bookInfo:availableBooks)
                    {
                        System.out.print(bookInfo + "\n");
                    }
                    break;
                case 4:
                    System.out.println("Vilken bok vill du lämna tillbaka?");
                    String bookToReturn = input.nextLine();
                    Book usersBook = library.searchBook(bookToReturn);
                    if(usersBook != null && !usersBook.available){
                        library.returnBook(usersBook);
                        System.out.println("Tack för din retur!");
                    }
                    else if(usersBook != null)
                    {
                        System.out.println("Boken finns redan inne");
                    }
                    else{
                        System.out.println("Boken verkar inte finnas i vårt bibliotek,var vänlig försök igen...");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }while (usersChoice !=5);
    }
}