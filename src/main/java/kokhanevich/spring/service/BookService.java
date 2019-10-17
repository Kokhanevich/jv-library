package kokhanevich.spring.service;

import java.util.List;
import kokhanevich.spring.entity.Book;

public interface BookService {
    void add(Book book);

    List<Book> findBookByName(String name);

    List<Book> listBooks();
}
