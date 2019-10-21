package kokhanevich.spring.service;

import java.util.List;
import kokhanevich.spring.entity.Book;
import kokhanevich.spring.entity.Rent;
import kokhanevich.spring.entity.User;

public interface LibraryService {
    Rent rentBook(User user, Book book);

    void returnBook(User user, Book book);

    Rent getRent(User user, Book book);

    List<Book> getBooksRentByUser(User user);
}
