package org.kizilay.yusuf.caveatemptor.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.kizilay.yusuf.caveatemptor.dao.CategoryDao;
import org.kizilay.yusuf.caveatemptor.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class CategoryDaoImpl extends CategoryDao {

    private static final String FIND_BY_NAME = "from Category  where name= :name";

    private static final String FIND_ALL = "from Category ";

    private static final String DELETE_BY_NAME = "delete Category  where name= :name";

    @Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Category findByName(String name) {
        Session session = session();

        Query query = session.createQuery(FIND_BY_NAME);
        query.setParameter("name", name);

        return (Category) query.list().get(0);
    }

    @Override
    public List<Category> findAll() {
        Session session = session();

        Query query = session.createQuery(FIND_ALL);

        return query.list();
    }

    @Override
    public void deleteByName(String name) {
        Session session = session();

        Query query = session.createQuery(DELETE_BY_NAME);
        query.setParameter("name", name);
        query.executeUpdate();
    }

}
