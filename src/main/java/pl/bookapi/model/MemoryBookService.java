package pl.bookapi.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MemoryBookService {
    private final List<Book> bookList = new ArrayList<>();
    private static Long nextId = 4L;

    public MemoryBookService() {
        this.bookList.add(new Book(1L, "9788324631766", "Thinking	in	Java", "Bruce Eckel", "Helion", "programming"));
        this.bookList.add(new Book(2L, "9788324627738", "Rusz glowa	Java.", "Sierra Kathy, Bates	Bert", "Helion", "programming"));
        this.bookList.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary	Cornell", "Helion", "programming"));
    }

    public List<Book> getBookList(){
        return this.bookList;
    }

    public Book readBook (Long id){
        for (Book book : this.bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return  null;
    }

    public void deleteBook (Long id){
        this.bookList.removeIf(book -> book.getId().equals(id));
    }

    public void addBook(Book newBook){
        newBook.setId(nextId);
        nextId++;
        this.bookList.add(newBook);
    }

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
