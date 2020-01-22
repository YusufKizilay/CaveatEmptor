package org.kizilay.yusuf.caveatemptor.dao.impl;

import org.hibernate.SessionFactory;
import org.kizilay.yusuf.caveatemptor.dao.BidDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BidDaoImpl extends BidDao {
    @Autowired
    protected BidDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
