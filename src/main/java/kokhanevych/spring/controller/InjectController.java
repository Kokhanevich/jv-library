package kokhanevych.spring.controller;

import kokhanevych.spring.config.AppConfig;
import kokhanevych.spring.entity.Book;
import kokhanevych.spring.entity.User;
import kokhanevych.spring.service.BookService;
import kokhanevych.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inject")
public class InjectController {
    AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);
    private UserService userService = context.getBean(UserService.class);
    private BookService bookService = context.getBean(BookService.class);

    @GetMapping
    public String injectData() {
        Book english = new Book("English", 2015, 250d);
        bookService.add(english);
        Book cookBook = new Book("Cooking", 2018, 200d);
        bookService.add(cookBook);
        Book spanish = new Book("Spanish", 2019, 420d);
        bookService.add(spanish);
        User sunil = new User("Sunil", "Bora", "suni.bora@example.com");
        userService.add(sunil);
        User david = new User("David", "Miller", "david.miller@example.com");
        userService.add(david);
        return "forward:";
    }
}
