package org.kizilay.yusuf.caveatemptor.controller;

import org.kizilay.yusuf.caveatemptor.resource.ItemResource;
import org.kizilay.yusuf.caveatemptor.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController extends BaseController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/category/{categoryName}/item")
    public ResponseEntity<ItemResource> createItem(@PathVariable String categoryName, @RequestBody ItemResource itemResource) {
        itemService.saveItem(categoryName, itemResource.getSeller(), itemResource.toDomain());

        return new ResponseEntity<>(itemResource, HttpStatus.CREATED);
    }


    @PutMapping("/category/{categoryName}/item")
    public ResponseEntity<ItemResource> updateItem(@PathVariable String categoryName, @RequestBody ItemResource itemResource) {
        itemService.updateItem(categoryName, itemResource.toDomain());

        return new ResponseEntity<>(itemResource, HttpStatus.CREATED);
    }

}
