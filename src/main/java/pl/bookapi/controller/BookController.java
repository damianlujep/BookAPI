package pl.bookapi.controller;

import org.springframework.web.bind.annotation.*;
import pl.bookapi.model.Book;
import pl.bookapi.model.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    final MemoryBookService memoryBookService = new MemoryBookService();

    @RequestMapping("helloBook")
    public Book helloBook(){
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping
    public List<Book> getBookList(){
        return memoryBookService.getBookList();
    }

    @GetMapping("/{id}")
    public Book searchBook(@PathVariable Long id){
        return memoryBookService.readBook(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book newBOok){
        memoryBookService.addBook(newBOok);
    }

    @PutMapping
    public void updateBook(@RequestBody Book bookToUpdate){
        memoryBookService.updateBook(bookToUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        memoryBookService.deleteBook(id);
    }


}


