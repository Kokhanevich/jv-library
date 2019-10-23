package kokhanevych.spring.service.impl;

import java.util.List;
import kokhanevych.spring.dao.RentDao;
import kokhanevych.spring.entity.Book;
import kokhanevych.spring.entity.Rent;
import kokhanevych.spring.entity.User;
import kokhanevych.spring.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private RentDao rentDao;

    @Transactional
    @Override
    public Rent rentBook(User user, Book book) {
        return rentDao.rentBook(user, book);
    }

    @Transactional
    @Override
    public void returnBook(User user, Book book) {
        rentDao.returnBook(user, book);
    }

    @Transactional(readOnly = true)
    @Override
    public Rent getRent(User user, Book book) {
        return rentDao.getRent(user, book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksRentByUser(User user) {
        return rentDao.getBooksRentByUser(user);
    }
}
