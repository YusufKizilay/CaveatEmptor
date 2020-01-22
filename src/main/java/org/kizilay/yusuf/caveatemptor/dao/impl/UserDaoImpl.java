package org.kizilay.yusuf.caveatemptor.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.kizilay.yusuf.caveatemptor.dao.Dao;
import org.kizilay.yusuf.caveatemptor.dao.UserDao;
import org.kizilay.yusuf.caveatemptor.domain.Item;
import org.kizilay.yusuf.caveatemptor.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends UserDao {
    private static final String FIND_BY_NAME = "from User  where userName= :name";

    @Autowired
    protected UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User findByName(String name) {
        Session session = session();

       // User  us=session.find(User.class,new Long(1));

       Query query = session.createQuery(FIND_BY_NAME);
      // query.setCacheable(true);
       query.setParameter("name", name);

        return (User) query.list().get(0);

       // return us;
    }

    public User find(){
        Session session = session();

        return (User)session.find(User.class,new Long(1));
    }
}
