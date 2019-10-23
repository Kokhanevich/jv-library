package kokhanevych.spring.controller;

import java.util.Optional;
import kokhanevych.spring.entity.Book;
import kokhanevych.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public String getAllBooks(ModelMap modelMap) {
        modelMap.put("allBooks", bookService.listBooks());
        return "book/allBooks";
    }

    @GetMapping("/{id}")
    public String bookInfo(@PathVariable ("id") Long id, ModelMap modelMap) {
        Optional<Book> bookById = bookService.getBookById(id);
        if (bookById.isEmpty()) {
            return "book/warning";
        }
        Book book = bookById.get();
        modelMap.put("book", book);
        return "book/bookInfo";
    }

    @GetMapping("/find")
    public String findByTitle(@RequestParam String title, ModelMap modelMap) {
        modelMap.put("allBooks", bookService.findBookByName(title));
        return "book/allBooks";
    }

    @GetMapping("/add")
    public String addBookPage() {
        return "book/create";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book, ModelMap modelMap) {
        bookService.add(book);
        return getAllBooks(modelMap);
    }

    @GetMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") Long id, ModelMap modelMap) {
        bookService.deleteBook(id);
        return getAllBooks(modelMap);
    }
}
