package org.kizilay.yusuf.caveatemptor.dao;

import org.hibernate.SessionFactory;
import org.kizilay.yusuf.caveatemptor.domain.Category;

import java.util.List;

public abstract class CategoryDao extends Dao<Category> {

    protected CategoryDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public abstract Category findByName(String name);

    public abstract List<Category> findAll();

    public abstract void deleteByName(String name);
}
