package kokhanevich.spring.dao;

import java.util.List;
import kokhanevich.spring.entity.Book;

public interface BookDao {
    void add(Book book);

    List<Book> findBookByName(String name);

    List<Book> listBooks();
}
