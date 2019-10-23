package kokhanevych.spring.dao;

import java.util.List;
import java.util.Optional;

import kokhanevych.spring.entity.Book;

public interface BookDao {
    void add(Book book);

    Optional<Book> getById(Long id);

    List<Book> findBookByName(String name);

    List<Book> listBooks();

    void deleteBook(Long bookId);
}
