package org.kizilay.yusuf.caveatemptor.service;

import org.kizilay.yusuf.caveatemptor.dao.CategoryDao;
import org.kizilay.yusuf.caveatemptor.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void saveCategory(Category category) {
        categoryDao.save(category);
    }

    public List<Category> findCategories() {
        return categoryDao.findAll();
    }

    public void deleteCategory(String name) {
        categoryDao.deleteByName(name);
    }

    public void updateCategory(String id,Category category) {
        Category foundCategory = findCategoryById(Long.valueOf(id));

        foundCategory.getChildCategories().forEach(foundChildCategory -> {
            foundChildCategory.setParentCategory(null);
        });

       category.getChildCategories().forEach(category1 -> {
            category1.setParentCategory(foundCategory);
        });

        foundCategory.setParentCategory(category.getParentCategory());
        foundCategory.setChildCategories(category.getChildCategories());
        foundCategory.setName(category.getName());
        foundCategory.setItems(category.getItems());

    }

    public Set<Category> saveCategories(Set<Category> categories) {
        return (Set<Category>) categoryDao.saveAll(categories);
    }

    public Category findCategory(String name) {
        return categoryDao.findByName(name);
    }

    public Category findCategoryById(Long id) {
        return categoryDao.findById(id);
    }
}
