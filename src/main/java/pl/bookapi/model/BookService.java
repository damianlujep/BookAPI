package pl.bookapi.model;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getBookList();
    Optional<Book> readBook (Long id);
    void deleteBook (Long id);
    void addBook(Book newBook);
    void updateBook(Book updatedBook);
}
