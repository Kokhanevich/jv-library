package kokhanevych.spring.service.impl;

import java.util.List;
import java.util.Optional;

import kokhanevych.spring.dao.BookDao;
import kokhanevych.spring.entity.Book;
import kokhanevych.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Book> getBookById(Long id) {
        return bookDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findBookByName(String name) {
        return bookDao.findBookByName(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Transactional
    @Override
    public void deleteBook(Long bookId) {
        bookDao.deleteBook(bookId);
    }
}
