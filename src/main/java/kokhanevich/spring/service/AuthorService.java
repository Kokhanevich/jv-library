package kokhanevich.spring.service;

import java.util.List;
import kokhanevich.spring.entity.Author;

public interface AuthorService {
    void add(Author author);

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);

    List<Author> getAllAuthors();
}
