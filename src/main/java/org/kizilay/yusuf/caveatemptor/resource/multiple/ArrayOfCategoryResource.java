package org.kizilay.yusuf.caveatemptor.resource.multiple;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.kizilay.yusuf.caveatemptor.domain.Category;
import org.kizilay.yusuf.caveatemptor.resource.BaseResource;
import org.kizilay.yusuf.caveatemptor.resource.CategoryResource;
import org.springframework.util.CollectionUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonRootName("categories")
public class ArrayOfCategoryResource extends BaseResource<Set<Category>> {

    @Valid
    @NotEmpty
    @JsonProperty("categories")
    private Set<CategoryResource> categoryResources;

    public Set<CategoryResource> getCategoryResources() {
        return categoryResources;
    }

    public void setCategoryResources(Set<CategoryResource> categoryResources) {
        this.categoryResources = categoryResources;
    }

    private void traverse(CategoryResource resource, Category category) {
        Set<CategoryResource> childResources = resource.getChilds();

        if (!CollectionUtils.isEmpty(childResources)) {
            childResources.stream().forEach(childResource -> {
                Category childCategory = childResource.toDomain();
                childCategory.setParentCategory(category);

                category.getChildCategories().add(childCategory);
                traverse(childResource, childCategory);
            });
        }
    }

    private static void traverseForResource(Category category,CategoryResource resource) {
        Set<Category> childCategories = category.getChildCategories();

        if (!CollectionUtils.isEmpty(childCategories)) {
            childCategories.stream().forEach(childCategory -> {
                CategoryResource childResource=new CategoryResource();
                childResource.setName(childCategory.getName());
                childResource.setId(String.valueOf(childCategory.getId()));

                if(resource.getChilds()!=null){
                    resource.getChilds().add(childResource);
                }
                else{
                    Set<CategoryResource> resources=new HashSet<>();
                    resources.add(childResource);
                    resource.setChilds(resources);
                }

                traverseForResource(childCategory,childResource);
            });
        }
    }

    @Override
    public Set<Category> toDomain() {
        Set<Category> categories = new HashSet<>();

        this.categoryResources.stream().forEach(resource -> {
            Category category = resource.toDomain();
            traverse(resource, category);
            categories.add(category);
        });

        return categories;
    }

    public static ArrayOfCategoryResource fromDomain(List<Category> categories, boolean single){
        ArrayOfCategoryResource arrayOfCategoryResource=new ArrayOfCategoryResource();

        Set<CategoryResource> categoryResources=new HashSet<>();

        categories.stream().forEach(category -> {
            CategoryResource categoryResource=new CategoryResource();
            categoryResource.setName(category.getName());
            categoryResource.setId(String.valueOf(category.getId()));

            traverseForResource(category,categoryResource);

            if(category.getParentCategory()== null || single){
                categoryResources.add(categoryResource);
            }

        });

        arrayOfCategoryResource.setCategoryResources(categoryResources);
        return arrayOfCategoryResource;
    }
}
