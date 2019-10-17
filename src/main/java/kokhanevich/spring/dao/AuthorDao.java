package kokhanevich.spring.dao;

import java.util.List;
import kokhanevich.spring.entity.Author;

public interface AuthorDao {
    void add(Author author);

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);

    List<Author> getAllAuthors();
}
