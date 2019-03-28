import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//This class initializes the main data in the program
//Calls in all the relevant methods that need to confirm whether books
//Adds in the data and checks for the relevant fields

public class Main {
    public static void main(String[] args) {
        //Define new books
        //Call new methods from the various classes

        Book book1 = new Book();
        book1.setAuthor("");
        book1.setTitle("");

        Book book2 = new Book();
        book2.setAuthor("");
        book2.setTitle("");

        AudioBook audio1 = new AudioBook();
        audio1.setDuration(2);

        

    }
}

class Book {

    //Initializing the base class Book
    //Defining core methods and variables that should be accessible
    //Using setters and getters to define the core

    private static Book instance = null;

    protected Book () { }

    public static Book getInstance() {
        if (instance == null) {
            instance = new Book();
        }

        return instance;
    }

    String title;
    String author;
    String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    void setTitle (String title) {
        this.title = title;
    }

    void displayName (String title) {
        System.out.println("Book: " + title);
    }
}

class AudioBook extends Book {

    private int duration;

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

class BorrowedItems extends Book {
    
    String dateFromBook;

    public void setDateFromBook(String dateFromBook) {
        this.dateFromBook = dateFromBook;
    }

    public String getDateFromBook() {
        return dateFromBook;
    }

    void BorrowedItemsCheck(String dateBorrowedString, String dateDueString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date dateBorrowed = sdf.parse("2012-02-22");
        Date dateDue = sdf.parse("2016-03-23");
        Date dateNow = new Date();

        System.out.println("Date borrowed: " + sdf.format(dateBorrowed));
        System.out.println("Date to be returned: " + sdf.format(dateDue));

        if (dateBorrowed.equals(dateNow)) {
            System.out.println("Book borrowed today");
        } else if (dateDue.equals(dateNow)) {
            System.out.println("Return book today");
        } else if (dateNow.after(dateDue)) {
            System.out.println("Your book is overdue");
        } else {
            System.out.println("Not sure what actions should be taken");
        }
    }
}

