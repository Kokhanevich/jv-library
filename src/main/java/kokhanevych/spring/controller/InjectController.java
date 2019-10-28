package kokhanevych.spring.controller;

import kokhanevych.spring.entity.Book;
import kokhanevych.spring.service.BookService;
import kokhanevych.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inject")
public class InjectController {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String injectData() {
        Book english = new Book("English", 2015, 250d);
        bookService.add(english);
        Book cookBook = new Book("Cooking", 2018, 200d);
        bookService.add(cookBook);
        Book spanish = new Book("Spanish", 2019, 420d);
        bookService.add(spanish);
        return "forward:";
    }
}
