package be.cegeka.bibliothouris.domain.books;

import java.util.List;

/**
 * Created by elisel on 25/01/2017.
 */
public interface Search {
   List<Book> searchByISBN(String ISBN);
}
