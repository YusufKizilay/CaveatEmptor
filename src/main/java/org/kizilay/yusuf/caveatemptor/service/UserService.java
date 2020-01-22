package org.kizilay.yusuf.caveatemptor.service;

import org.kizilay.yusuf.caveatemptor.dao.impl.UserDaoImpl;
import org.kizilay.yusuf.caveatemptor.domain.BillingDetails;
import org.kizilay.yusuf.caveatemptor.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class UserService {

    private UserDaoImpl userDao;

    @Autowired
    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public User saveUser(User user){
        return  userDao.save(user);
    }

    public User findUser(String userName){
        User user=userDao.findByName(userName);

       //User user=userDao.find();

     //  user.setUserName("Yusuf Updated");

        System.out.println("//////////////////////////////////////////////////////////////////////////");

      // User user2=userDao.find();

       //userDao.findByName(userName);

       return user;
    }

    public void updateUser(User user){
        User foundUser=findUser(user.getUserName());

        foundUser.setShippingAddress(user.getShippingAddress());
        foundUser.setBillingAddress(user.getBillingAddress());
        foundUser.setBillingAddress(user.getBillingAddress());

       user.getBillingDetails().stream().forEach(billingDetails -> {
            billingDetails.setUser(foundUser);
        });

        foundUser.setBillingDetails(user.getBillingDetails());
        foundUser.setFirstName(user.getFirstName());
        foundUser.setHomeAddress(user.getHomeAddress());
        foundUser.setLastName(user.getLastName());
        foundUser.setUserName(user.getUserName());
    }

}
