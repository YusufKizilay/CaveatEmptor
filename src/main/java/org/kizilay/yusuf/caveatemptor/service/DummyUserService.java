package org.kizilay.yusuf.caveatemptor.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.kizilay.yusuf.caveatemptor.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyUserService {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user){
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();

        session.save(user);

        session.getTransaction().commit();


        session.close();
    }

    public User find(){
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();

        User user=session.find(User.class,new Long(1));

        session.getTransaction().commit();


        session.close();

        return  user;
    }
}
