package be.cegeka.bibliothouris.domain.books;

<<<<<<< HEAD
import be.cegeka.bibliothouris.domain.members.Member;
import org.apache.commons.lang3.StringUtils;
import be.cegeka.bibliothouris.domain.members.MemberRepository;

import javax.inject.Inject;
=======
>>>>>>> 77e889d49f634ff0d7598cdfd7b3043585e91779
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jensde on 25/01/2017.
 */
@Named
public class BookRepository  {
    private List<Book> books = new ArrayList<>();
    private List<String> isbnNumbers = new ArrayList<>();
    public List<LendABook> lendedBooks;

    public BookRepository() {
        this.lendedBooks = new ArrayList<>();
    }
    public List<Book> getAllBooks() {
        return books;
    }

    public List<String> getIsbnNumbers() {
        return isbnNumbers;
    }

    public void addBook(Book book) {
        books.add(book);
        isbnNumbers.add(book.getIsbn());
    }

    public void enhancedBook(String isbn, String title, String lastName, String firstName) {
        if ((isbn != null) && (title != null) && (lastName != null)) {
            books.add(new Book(isbn, title, lastName, firstName));

        } else {
            System.out.println("Invalid entry");
        }
    }


    public List<Book> getBookListISBN(String ISBN) {
        List<Book> outputList = new ArrayList<>();

        for (Book book : books) {
            String isbnBook = book.getIsbn();
            if (isbnBook.startsWith(ISBN)) {
                outputList.add(book);
            }
        }
        if (outputList.isEmpty()) {
            System.out.println("There is no book found.");
        }
        return outputList;
    }

    private List<Book> getbookListTitle(String title) {
        List<Book> outputList = new ArrayList<>();

        for (Book book : books) {
            String titleBook = book.getTitle();

            if (titleBook.startsWith(title)) {
                outputList.add(book);
            }
        }

        if (outputList.isEmpty()) {
            System.out.println("There is no book found.");
        }
        return outputList;
    }



    public List<Book> getbookListAuthor(String author) {
        List<Book> booklist = new ArrayList<>();
        for (Book book : books) {
            String fullName = book.getAuthorFirstName() + " " + book.getAuthorLastName();
            String lastName = book.getAuthorLastName();
            if (fullName.startsWith(author) || lastName.startsWith(author)) {
                booklist.add(book);
            }
            System.out.println("There is no book found.");
        }
        return booklist;
    }



    public String searchByISBN(String ISBN) {
        String output = "";
        List<Book> booklist = getBookListISBN(ISBN);
        for (Book book : booklist) {
            String det = book.getDetails();
            output += det + System.lineSeparator();
        }
        return output;
    }

<<<<<<< HEAD
    public Book getBookByISBN(String ISBN) {
        for (Book book : books) {
            String isbn = book.getIsbn();
            if (isbn.equals(ISBN)) {
                return book;
            }
=======

    public String searchByTitle(String title) {
        String output = "";
        List<Book> booklist = getbookListTitle(title);
        for (Book book : booklist) {
            String det = book.getDetails();
            output += det + System.lineSeparator();
>>>>>>> 77e889d49f634ff0d7598cdfd7b3043585e91779
        }
        return output;
    }

    public String searchByAuthor(String author) {
        String output = "";
        List<Book> booklist = getbookListAuthor(author);
        for (Book book : booklist) {
            output += book.getDetails() + System.lineSeparator();
        }

        return output;
    }

    public boolean validateISBNExists(String ISBN) {
        if (getIsbnNumbers().contains(ISBN)) {
            return true;
        }
        return false;
    }

    public boolean validateINSSExists(String INSS) {
        return false;
    }


<<<<<<< HEAD
    public void lendABook(String isbn, String inss) {
        if (validateISBNExists(isbn)) {
            LendABook len = new LendABook(isbn, inss);
            lendedBooks.add(len);
            Book book = getBookByISBN(isbn);
            book.setLended(true);
        } else {
            System.out.println("This book does not exists.");
        }
    }
    @Inject
    private MemberRepository memberRepository;
    public String getLendingMember(String isbn) {
        String lendedMember = "";
        Book book1 = null;
        for (LendABook lendedBook : lendedBooks) {
            if (lendedBook.getIsbn().equals(isbn)) {
                String inss = lendedBook.getInss();
                Member member = memberRepository.getMember("inss");
                book1 = getBookByISBN("isbn");

                String lastName = member.getLastName();
                String firstName = member.getFirstName();
                lendedMember = inss + lastName + firstName;
            }

        }
        book1.setLenderInfo(lendedMember);
        return lendedMember;
    }


=======



    public Book getBookByISBN(String ISBN ){
        for (Book book : books) {
            String isbn = book.getIsbn();
            if (isbn.equals(ISBN)){
                return book;
            }
        }
        System.out.println("This book does not exists.");
        return null;
    }






>>>>>>> 77e889d49f634ff0d7598cdfd7b3043585e91779
}
