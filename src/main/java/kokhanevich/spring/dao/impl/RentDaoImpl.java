package kokhanevich.spring.dao.impl;

import java.util.List;
import javax.persistence.TypedQuery;
import kokhanevich.spring.dao.RentDao;
import kokhanevich.spring.entity.Book;
import kokhanevich.spring.entity.Rent;
import kokhanevich.spring.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImpl implements RentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Rent rentBook(User user, Book book) {
        Rent rent = new Rent(user, book);
        sessionFactory.getCurrentSession().save(rent);
        return rent;
    }

    @Override
    public void returnBook(User user, Book book) {
        Rent rent = getRent(user, book);
        rent.setActive(false);
        sessionFactory.getCurrentSession().update(rent);
    }

    @Override
    public Rent getRent(User user, Book book) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Rent where user_id LIKE :user_id and book_id LIKE :book_id");
        query.setParameter("user_id","%" + user.getId() + "%");
        query.setParameter("book_id", "%" + book.getId() + "%");
        return (Rent) query.getSingleResult();
    }

    @Override
    public List<Book> getBooksRentByUser(User user) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession()
                .createQuery("select book from Rent where user_id LIKE :user_id", Book.class);
        query.setParameter("user_id", "%" + user.getId() + "%");
        return query.getResultList();
    }
}
