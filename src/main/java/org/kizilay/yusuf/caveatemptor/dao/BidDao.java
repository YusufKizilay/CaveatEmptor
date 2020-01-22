package org.kizilay.yusuf.caveatemptor.dao;

import org.hibernate.SessionFactory;
import org.kizilay.yusuf.caveatemptor.domain.Bid;
import org.springframework.stereotype.Repository;

@Repository
public class BidDao extends Dao<Bid> {
    protected BidDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
