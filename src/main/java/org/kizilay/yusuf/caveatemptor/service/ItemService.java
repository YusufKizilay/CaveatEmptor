package org.kizilay.yusuf.caveatemptor.service;

import org.kizilay.yusuf.caveatemptor.dao.ItemDao;
import org.kizilay.yusuf.caveatemptor.dao.impl.ItemDaoImpl;
import org.kizilay.yusuf.caveatemptor.domain.Category;
import org.kizilay.yusuf.caveatemptor.domain.Item;
import org.kizilay.yusuf.caveatemptor.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class ItemService {

    private final CategoryService categoryService;
    private final ItemDao itemDao;
    private final UserService userService;

    public ItemService(ItemDaoImpl itemDao,CategoryService categoryService,UserService userService) {
        this.itemDao = itemDao;
        this.categoryService=categoryService;
        this.userService=userService;
    }

    public Item saveItem(String categoryName, String seller,Item item) {
        Category category= categoryService.findCategory(categoryName);
        item.getCategories().add(category);

        User user=userService.findUser(seller);
        item.setUser(user);

        return itemDao.save(item);
    }

    public void updateItem(String categoryName, Item item){
        Item foundItem=itemDao.findByName(item.getName()) ;
        Category category = categoryService.findCategory(categoryName);

        foundItem.setName(item.getName());
       foundItem.getCategories().add(category);

       // Set<Category> categories = new HashSet<>();
       // categories.add(category);

        //foundItem.setCategories(categories);
        foundItem.setImages(item.getImages());
        foundItem.setAuctionEnd(item.getAuctionEnd());
        foundItem.setInitialPrice(item.getInitialPrice());
    }

    public void saveItems(Set<Item> items) {

        //Need to fetch category and set found categories to item

        itemDao.saveAll(items);
    }

    public  Item findItem(String name){
        return itemDao.findByName(name);
    }
}
