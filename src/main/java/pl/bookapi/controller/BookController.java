package pl.bookapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.bookapi.model.Author;
import pl.bookapi.model.Book;
import pl.bookapi.model.BookService;
import pl.bookapi.model.MemoryBookService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    final BookService bookService;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.bookService = memoryBookService;
    }

    @RequestMapping("helloBook")
    public Book helloBook(){
        Author bruceEckel = new Author("Bruce","Eckel", LocalDate.of(1957,7,8));
        return new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel"
                , "Helion", "programming");
    }

    @GetMapping
    public List<Book> getBookList(){
        return bookService.getBookList();
    }

    @GetMapping("/{id}")
    public Book searchBook(@PathVariable Long id){
        return this.bookService.readBook(id).orElseThrow(() -> {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Entity not found"
            );
        });
    }

    @PostMapping
    public void addBook(@RequestBody Book newBOok){
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.registerModule(new JavaTimeModule());
//        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        bookService.addBook(newBOok);
    }

    @PutMapping
    public void updateBook(@RequestBody Book bookToUpdate){
        bookService.updateBook(bookToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

}


