package kokhanevich.spring;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kokhanevich.spring.config.AppConfig;
import kokhanevich.spring.entity.Author;
import kokhanevich.spring.entity.Book;
import kokhanevich.spring.entity.Rent;
import kokhanevich.spring.entity.User;
import kokhanevich.spring.service.AuthorService;
import kokhanevich.spring.service.BookService;
import kokhanevich.spring.service.LibraryService;
import kokhanevich.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        BookService bookService = context.getBean(BookService.class);
        AuthorService authorService = context.getBean(AuthorService.class);
        LibraryService libraryService = context.getBean(LibraryService.class);

        // Add Users
        User sunil = new User("Sunil", "Bora", "suni.bora@example.com");
        userService.add(sunil);
        User david = new User("David", "Miller", "david.miller@example.com");
        userService.add(david);
        User sameer = new User("Sameer", "Singh", "sameer.singh@example.com");
        userService.add(sameer);
        User paul = new User("Paul", "Smith", "paul.smith@example.com");
        userService.add(paul);

        // Add Books
        Book english = new Book("English", 2015, 250d);
        bookService.add(english);
        Book cookBook = new Book("Cooking", 2018, 200d);
        bookService.add(cookBook);
        Book spanish = new Book("Spanish", 2019, 420d);
        bookService.add(spanish);

        // Add Authors
        List<Book> englishBookList = new ArrayList<>();
        List<Book> spanishBookList = new ArrayList<>();

        Author englishAuthor = new Author("John", "Silver");
        englishBookList.add(english);
        englishBookList.add(cookBook);
        englishAuthor.setBookList(englishBookList);
        authorService.add(englishAuthor);

        Author spanishAuthor = new Author("Garcia", "Flint");
        spanishBookList.add(spanish);
        spanishBookList.add(cookBook);
        spanishAuthor.setBookList(spanishBookList);
        authorService.add(spanishAuthor);

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        // Get books
        List<Book> books = bookService.findBookByName("Cooking");
        for (Book book : books) {
            System.out.println("Id = " + book.getId());
            System.out.println("Name = " + book.getName());
            System.out.println("Year = " + book.getYear());
            System.out.println("Price = " + book.getPrice());
            System.out.println();
        }

        // Get authors
        List<Author> authors = authorService.findByNameAndSurname("Garcia", "Flint");
        for (Author author : authors) {
            System.out.println();
            System.out.println("Id = " + author.getId());
            System.out.println("Name = " + author.getName());
            System.out.println("Surname = " + author.getSurname());
            System.out.println();
            System.out.println("Books:");
            System.out.println();
            List<Book> authorBookList = author.getBookList();
            for (Book book : authorBookList) {
                System.out.println("    Id = " + book.getId());
                System.out.println("    Name = " + book.getName());
                System.out.println("    Year = " + book.getYear());
                System.out.println("    Price = " + book.getPrice());
                System.out.println();
            }
            System.out.println();
        }

        // add rents
        Rent rent1 = libraryService.rentBook(sameer, spanish);
        libraryService.rentBook(sameer, english);
        Rent rent2 = libraryService.rentBook(paul, cookBook);
        libraryService.returnBook(paul, cookBook);
        List<Book> booksRentByUser = libraryService.getBooksRentByUser(sameer);
        for (Book book : booksRentByUser) {
            System.out.println(book.getName());
            System.out.println();
        }
        context.close();
    }
}
