package org.kizilay.yusuf.caveatemptor.domain;

import org.kizilay.yusuf.caveatemptor.resource.CategoryResource;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "CATEGORY")
@Entity
public class Category extends BaseDomain {

    @Id
    @SequenceGenerator(name = "CATEGOR_SEQ", sequenceName = "CATEGOR_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGOR_SEQ")
    @Column(name = "CATEGORY_ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parentCategory;


    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Category> childCategories = new HashSet<>();

    @ManyToMany(mappedBy = "categories",  cascade = CascadeType.ALL)
    private Set<Item> items = new HashSet<>();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(Set<Category> childCategories) {
        this.childCategories = childCategories;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
