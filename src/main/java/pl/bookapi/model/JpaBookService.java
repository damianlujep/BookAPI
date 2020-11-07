package pl.bookapi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.bookapi.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JpaBookService implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public JpaBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> readBook(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public void addBook(Book newBook) {
        bookRepository.save(newBook);
    }

    @Override
    public void updateBook(Book updatedBook) {
        bookRepository.save(updatedBook);
    }
}
