package com.cserny.test.service;

import com.cserny.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by user on 08.03.2016.
 */

@Repository
@Transactional
public class UserRepository
{
    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void init() { }

    public void newUser(String name)
    {
        User user = new User();
        user.setName(name);

        entityManager.persist(user);
    }

    public User getUserByName(String name)
    {
        Query query = entityManager.createNamedQuery(User.USER_FIND_BY_NAME);
        query.setParameter(1, name);
        query.setMaxResults(1);

        return (User) query.getSingleResult();
    }

    public String getAllUserNames()
    {
        StringBuilder builder = new StringBuilder();
        for (User user : entityManager.createNamedQuery(User.USER_FIND_ALL, User.class).getResultList()) {
            builder.append(user.getName()).append(" --- ");
        }

        return builder.toString().trim();
    }
}
