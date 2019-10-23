package kokhanevych.spring.controller;

import java.util.List;
import java.util.Optional;
import kokhanevych.spring.entity.Book;
import kokhanevych.spring.entity.Rent;
import kokhanevych.spring.entity.User;
import kokhanevych.spring.service.BookService;
import kokhanevych.spring.service.LibraryService;
import kokhanevych.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {
    private static final Long USER_ID = 1L;

    @Autowired
    private UserService userService;

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BookService bookService;

    @GetMapping("/getRent")
    public String rentBook(@RequestParam("bookId") Long bookId, ModelMap modelMap) {
        Optional<Book> bookOptional = bookService.getBookById(bookId);
        if (bookOptional.isEmpty()) {
            return "book/warning";
        }
        Optional<User> userOptional = userService.getUser(USER_ID);
        if (userOptional.isEmpty()) {
            return "user/warning";
        }
        Rent rent = libraryService.rentBook(userOptional.get(), bookOptional.get());
        modelMap.put("rent", rent);
        return "forward:/book/all";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam ("bookId") Long bookId, ModelMap modelMap) {
        Optional<Book> bookOptional = bookService.getBookById(bookId);
        if (bookOptional.isEmpty()) {
            return "book/warning";
        }
        Optional<User> userOptional = userService.getUser(USER_ID);
        if (userOptional.isEmpty()) {
            return "user/warning";
        }
        libraryService.returnBook(userOptional.get(), bookOptional.get());
        return getRentedBooks(modelMap);
    }

    @GetMapping("/rentedBooks")
    public String getRentedBooks(ModelMap modelMap) {
        Optional<User> userOptional = userService.getUser(USER_ID);
        if (userOptional.isEmpty()) {
            return "user/warning";
        }
        List<Book> booksRentByUser = libraryService.getBooksRentByUser(userOptional.get());
        modelMap.put("books", booksRentByUser);
        return "rent/rentBooks";
    }
}
