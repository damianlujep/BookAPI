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

    public List<Book> getBookList(){
        return bookList;
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
