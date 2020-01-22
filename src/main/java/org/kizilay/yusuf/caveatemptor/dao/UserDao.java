package org.kizilay.yusuf.caveatemptor.dao;

import org.hibernate.SessionFactory;
import org.kizilay.yusuf.caveatemptor.domain.User;

public abstract class UserDao extends Dao<User> {
    protected UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public abstract User findByName(String name);
}
