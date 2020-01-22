package org.kizilay.yusuf.caveatemptor.controller;


import org.kizilay.yusuf.caveatemptor.domain.Category;
import org.kizilay.yusuf.caveatemptor.resource.CategoryResource;
import org.kizilay.yusuf.caveatemptor.resource.multiple.ArrayOfCategoryResource;
import org.kizilay.yusuf.caveatemptor.service.CategoryService;
import org.kizilay.yusuf.caveatemptor.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
public class CategoryController extends BaseController {

    private CategoryService categoryService;

    private ItemService itemService;

    @Autowired
    public CategoryController(CategoryService categoryService, ItemService itemService) {
        this.categoryService = categoryService;
        this.itemService = itemService;
    }

    @PostMapping("/category")
    public ResponseEntity<ArrayOfCategoryResource> saveCategories(@RequestBody ArrayOfCategoryResource categoriesResource) {
        categoryService.saveCategories(categoriesResource.toDomain());

        return new ResponseEntity<>(categoriesResource, HttpStatus.CREATED);
    }

//    @GetMapping("/category")
//    public ResponseEntity<ArrayOfCategoryResource> findCategories() {
//        List<Category> categories = categoryService.findCategories();
//        return new ResponseEntity<>(ArrayOfCategoryResource.fromDomain(categories), HttpStatus.OK);
//    }

    @GetMapping("/category")
    public ResponseEntity<Object> findCategory(@RequestParam(name = "name", required = false) String categoryName ) {

        if(categoryName==null){
            List<Category> categories = categoryService.findCategories();
            return new ResponseEntity<>(ArrayOfCategoryResource.fromDomain(categories,false), HttpStatus.OK);
        }

        Category category = categoryService.findCategory(categoryName);

        List<Category> categories=new ArrayList<>();
        categories.add(category);


        ArrayOfCategoryResource arrayOfCategoryResource= ArrayOfCategoryResource.fromDomain(categories,true);

        Iterator iter = arrayOfCategoryResource.getCategoryResources().iterator();

        CategoryResource first = (CategoryResource) iter.next();

        return new ResponseEntity<>(first, HttpStatus.OK);
    }

    @DeleteMapping("/category")
    public void deleteCategory(@RequestParam(name = "name") String categoryName) {
        categoryService.deleteCategory(categoryName);
    }

    @PutMapping("/category/{id}")
    public void updateCategory(@PathVariable String id, @RequestBody CategoryResource categoryResource) {
        categoryService.updateCategory(id,categoryResource.to());
    }


}
