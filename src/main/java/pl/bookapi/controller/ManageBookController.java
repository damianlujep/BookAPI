package pl.bookapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.bookapi.model.Book;
import pl.bookapi.model.BookService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {
    private final BookService bookService;

    @Autowired
    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBookList();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/add")
    public String addBookForm(Model m){
        m.addAttribute("bookModel", new Book());
        return "/books/add-form";
    }

    @PostMapping("/add")
    public ModelAndView addBookFormHandler(@ModelAttribute("bookModel") @Valid Book book, BindingResult result){
        if (result.hasErrors()){
            return new ModelAndView("books/add-form","bookModel", book) ;
        }

        bookService.addBook(book);
        return new ModelAndView("redirect: /admin/books/all");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editBookForm(@PathVariable long id){
        Book bookToEdit = bookService.readBook(id).orElseThrow(EntityNotFoundException::new);

        ModelAndView mv = new ModelAndView("books/edit-form","bookModel", new Book());
        mv.addObject("bookToEdit", bookToEdit);
        return mv;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editBookFormHandler(@PathVariable long id, @ModelAttribute("bookModel") @Valid Book book, BindingResult result){
        if (result.hasErrors()){
            return new ModelAndView("books/edit-form","bookModel", book) ;
        }

        bookService.updateBook(book);
        return new ModelAndView("redirect: ../all");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteBook (@PathVariable long id){
        Book book = bookService.readBook(id).orElseThrow(EntityNotFoundException::new);
        bookService.deleteBook(book.getId());

        return new ModelAndView("redirect: ../all");
    }

    @GetMapping("/details/{id}")
    public ModelAndView showBookDetails (@PathVariable long id){
        Book book = bookService.readBook(id).orElseThrow(EntityNotFoundException::new);

        return new ModelAndView("books/details", "book", book);
    }

}
