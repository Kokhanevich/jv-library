package kokhanevych.spring.controller;

import java.util.List;
import java.util.Optional;
import kokhanevych.spring.entity.Book;
import kokhanevych.spring.entity.User;
import kokhanevych.spring.service.BookService;
import kokhanevych.spring.service.LibraryService;
import kokhanevych.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private UserService userService;

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BookService bookService;

    @GetMapping("/getRent")
    public String rentBook(@RequestParam("bookId") Long bookId) {
        Optional<Book> bookOptional = bookService.getBookById(bookId);
        if (bookOptional.isEmpty()) {
            return "book/warning";
        }
        Optional<User> userOptional = getCurrentUser();
        if (userOptional.isEmpty()) {
            return "user/warning";
        }
        libraryService.rentBook(userOptional.get(), bookOptional.get());
        return "forward:/book/all";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam ("bookId") Long bookId, ModelMap modelMap) {
        Optional<Book> bookOptional = bookService.getBookById(bookId);
        if (bookOptional.isEmpty()) {
            return "book/warning";
        }
        Optional<User> userOptional = getCurrentUser();
        if (userOptional.isEmpty()) {
            return "user/warning";
        }
        libraryService.returnBook(userOptional.get(), bookOptional.get());
        return getRentedBooks(modelMap);
    }

    @GetMapping("/rentedBooks")
    public String getRentedBooks(ModelMap modelMap) {
        Optional<User> userOptional = getCurrentUser();
        if (userOptional.isEmpty()) {
            return "user/warning";
        }
        List<Book> booksRentByUser = libraryService.getBooksRentByUser(userOptional.get());
        modelMap.put("books", booksRentByUser);
        return "rent/rentBooks";
    }

    private Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByUserName(authentication.getName());
    }
}
