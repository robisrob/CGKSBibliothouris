package be.cegeka.bibliothouris.domain.books;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jensde on 25/01/2017.
 */
@Named
public class BookRepository implements Search {
    private List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks(){
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    @Override
    public List<Book> searchByISBN(String ISBN) {
        List<Book> outputList = new ArrayList<>();
        for (Book book : books) {
            String isbnBook = book.getIsbn();
            if (ISBN.equals(isbnBook)){
                outputList.add(book);
            }
        }
        return outputList;
    }
}
