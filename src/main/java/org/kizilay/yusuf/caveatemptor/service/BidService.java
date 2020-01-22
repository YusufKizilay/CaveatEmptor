package org.kizilay.yusuf.caveatemptor.service;

import org.kizilay.yusuf.caveatemptor.dao.BidDao;
import org.kizilay.yusuf.caveatemptor.domain.Bid;
import org.kizilay.yusuf.caveatemptor.domain.Item;
import org.kizilay.yusuf.caveatemptor.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class BidService {

    private BidDao bidDao;
    private ItemService itemService;
    private UserService userService;

    @Autowired
    public BidService(BidDao bidDao,ItemService itemService,UserService userService) {
        this.bidDao = bidDao;
        this.itemService=itemService;
        this.userService=userService;
    }

    public void save(String itemName, String userName, Bid bid){
        Item item=itemService.findItem(itemName);
        User user=userService.findUser(userName);

        bid.setUser(user);
        bid.setItem(item);

        bidDao.save(bid);
    }

    public void update(String itemName, String userName, Bid bid){
        Bid foundBid= bidDao.findById(1);

        foundBid.setAmount(bid.getAmount());
        foundBid.setCreatedOn(new Date());
    }
}
