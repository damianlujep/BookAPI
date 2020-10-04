package pl.bookapi.model;

import java.util.List;

public interface BookService {

    List<Book> getBookList();
    Book readBook (Long id);
    void deleteBook (Long id);
    void addBook(Book newBook);
    void updateBook(Book updatedBook);
}
