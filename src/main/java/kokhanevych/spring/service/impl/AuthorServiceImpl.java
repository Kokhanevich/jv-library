package kokhanevych.spring.service.impl;

import java.util.List;
import kokhanevych.spring.dao.AuthorDao;
import kokhanevych.spring.entity.Author;
import kokhanevych.spring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Transactional
    @Override
    public void add(Author author) {
        authorDao.add(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByName(String name) {
        return authorDao.findByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        return authorDao.findByNameAndSurname(name, surname);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> getAllAuthors() {
        return authorDao.getAllAuthors();
    }
}
