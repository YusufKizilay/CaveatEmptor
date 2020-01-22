package org.kizilay.yusuf.caveatemptor.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.kizilay.yusuf.caveatemptor.domain.Category;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryResource extends BaseResource<Category> {

    private String id;

    @NotBlank
    private String name;

    private Set<CategoryResource> childs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CategoryResource> getChilds() {
        return childs;
    }

    public void setChilds(Set<CategoryResource> childs) {
        this.childs = childs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Category toDomain() {
        return new Category(this.name);
    }

    public Category to() {
        Category category = new Category(this.name);
        traverse(this, category);

        return category;
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
}
