package kokhanevych.spring.dao;

import java.util.List;
import kokhanevych.spring.entity.Book;
import kokhanevych.spring.entity.Rent;
import kokhanevych.spring.entity.User;

public interface RentDao {
    Rent rentBook(User user, Book book);

    void returnBook(User user, Book book);

    Rent getRent(User user, Book book);

    List<Book> getBooksRentByUser(User user);
}
