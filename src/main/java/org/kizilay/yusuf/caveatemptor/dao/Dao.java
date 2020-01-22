package org.kizilay.yusuf.caveatemptor.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.core.GenericTypeResolver;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

public class Dao<E> {

    protected SessionFactory sessionFactory;

    private Class<?> classType;

    protected Dao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        classType = GenericTypeResolver.resolveTypeArgument(this.getClass(), Dao.class);
    }

    public E save(E e) {
        session().saveOrUpdate(e);

        return e;
    }

    public Collection<E> saveAll(Collection<E> collectionOfE) {
        collectionOfE.stream().forEach(e -> save(e));

        return collectionOfE;
    }

    public E findById(Serializable k) {
        E e = (E) session().get(classType, k);

        return e;
    }


    public E update(E e) {
        session().update(e);

        return e;
    }

    public Session session() {
        return this.sessionFactory.getCurrentSession();
    }
}
