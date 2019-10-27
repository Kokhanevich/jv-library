package kokhanevych.spring.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.TypedQuery;

import kokhanevych.spring.dao.RoleDao;
import kokhanevych.spring.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public Optional<Role> getRoleByName(String name) {
        TypedQuery<Role> query = sessionFactory.getCurrentSession()
                .createQuery("from Role where roleName=:roleName",
                        Role.class);
        query.setParameter("roleName", name);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Role> getAllRoles() {
        TypedQuery<Role> query = sessionFactory.getCurrentSession().createQuery("from Role",
                Role.class);
        return query.getResultList();
    }
}
