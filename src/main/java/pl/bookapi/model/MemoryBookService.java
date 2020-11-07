package pl.bookapi.model;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MemoryBookService implements BookService{
    private final List<Book> bookList = new ArrayList<>();
    private static Long nextId = 4L;

    public MemoryBookService() {
        Author bruceEckel = new Author("Bruce","Eckel", LocalDate.of(1957,7,8));
        Author sierraKathy = new Author("Sierra","Kathy", LocalDate.of(1957,12,20));
        Author cayHorstmann = new Author("Cay","Horstmann", LocalDate.of(1966,8,20));

//        this.bookList.add(new Book(1L, "9788324631766", "Thinking	in	Java", bruceEckel, "Helion", "programming"));
//        this.bookList.add(new Book(2L, "9788324627738", "Rusz glowa	Java.", sierraKathy, "Helion", "programming"));
//        this.bookList.add(new Book(3L, "9780130819338", "Java 2. Podstawy", cayHorstmann, "Helion", "programming"));
    }

    @Override
    public List<Book> getBookList(){
        return this.bookList;
    }

    @Override
    public Optional<Book> readBook(Long id) {
        return bookList.stream().filter(item -> item.getId().equals(id)).findFirst();
    }

//    @Override
//    public Book readBook (Long id){
//        boolean exist = false;
//
//        for (Book book : this.bookList) {
//            if (book.getId().equals(id)) {
//                exist = true;
//                return book;
//            }
//        }
//
//        throw new ResponseStatusException(
//                HttpStatus.NOT_FOUND, "nie ma takiej książki");
//    }

    @Override
    public void deleteBook (Long id){
        this.bookList.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public void addBook(Book newBook){
        newBook.setId(nextId);
        nextId++;
        this.bookList.add(newBook);
    }

    @Override
    public void updateBook(Book updatedBook){
        for (Book book: this.bookList){
            if (book.getId().equals(updatedBook.getId())){
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setIsbn(updatedBook.getIsbn());
                book.setPublisher(updatedBook.getPublisher());
                book.setType(updatedBook.getType());
            }
        }
    }
}
