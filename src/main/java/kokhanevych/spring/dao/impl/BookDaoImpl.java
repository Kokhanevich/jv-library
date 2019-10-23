package kokhanevych.spring.dao.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;
import kokhanevych.spring.dao.BookDao;
import kokhanevych.spring.entity.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public Optional<Book> getById(Long id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Book.class, id));
    }

    @Override
    public List<Book> findBookByName(String name) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("from Book where name LIKE :name", Book.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Override
    public List<Book> listBooks() {
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("from Book",
                Book.class);
        return query.getResultList();
    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = new Book();
        book.setId(bookId);
        sessionFactory.getCurrentSession().delete(book);
    }
}
