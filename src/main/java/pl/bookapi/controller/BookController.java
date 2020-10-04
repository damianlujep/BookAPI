package pl.bookapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
        return new Book(1L, "9788324631766", "Thinking in Java", bruceEckel
                , "Helion", "programming");
    }

    @GetMapping
    public List<Book> getBookList(){
        return bookService.getBookList();
    }

    @GetMapping("/{id}")
    public Book searchBook(@PathVariable Long id){
        return bookService.readBook(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book newBOok){
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


