package org.kizilay.yusuf.caveatemptor.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.kizilay.yusuf.caveatemptor.dao.Dao;
import org.kizilay.yusuf.caveatemptor.dao.ItemDao;
import org.kizilay.yusuf.caveatemptor.domain.Category;
import org.kizilay.yusuf.caveatemptor.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ItemDaoImpl extends  ItemDao {

    private static final String FIND_BY_NAME = "from Item  where name= :name";

    @Autowired
    protected ItemDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Item findByName(String name) {
        Session session = session();

        Query query = session.createQuery(FIND_BY_NAME);
        query.setParameter("name", name);

        return (Item) query.list().get(0);
    }
}
