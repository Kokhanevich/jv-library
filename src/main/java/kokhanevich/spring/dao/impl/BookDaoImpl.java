package kokhanevich.spring.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import kokhanevich.spring.dao.BookDao;
import kokhanevich.spring.entity.Book;
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
}
