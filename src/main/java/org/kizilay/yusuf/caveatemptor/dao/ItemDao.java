package org.kizilay.yusuf.caveatemptor.dao;

import org.hibernate.SessionFactory;
import org.kizilay.yusuf.caveatemptor.domain.Category;
import org.kizilay.yusuf.caveatemptor.domain.Item;

import java.util.Collection;

public abstract class ItemDao extends Dao<Item> {
    protected ItemDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public abstract Item findByName(String name);
}
