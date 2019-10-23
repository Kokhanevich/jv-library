package kokhanevych.spring.service;

import java.util.List;
import java.util.Optional;

import kokhanevych.spring.entity.Book;

public interface BookService {
    void add(Book book);

    Optional<Book> getBookById(Long id);

    List<Book> findBookByName(String name);

    List<Book> listBooks();

    void deleteBook(Long bookId);
}
