package com.jocata.ecomm.daoImpl;

import com.jocata.ecomm.dao.UserDao;
import com.jocata.ecomm.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public User save(User user) {
        em.persist(user);
        return user;
    }

    public User update(User user) {
        User u = em.find(User.class, user.getId());
        if (u != null) {
             return em.merge(user);
        }
        return  null;
    }

    public void delete(User user) {
        User u = em.find(User.class, user.getId());
        if (u != null) {
            em.remove(u);
        }
    }

    public User findUserById(Long id) {
        User u = em.find(User.class, id);
        if (u != null) {
            return em.find(User.class, id);
        }
        return null;
    }

    public List<User> findAllUsers() {
        return em.createQuery("FROM User ", User.class).getResultList();
    }
}
