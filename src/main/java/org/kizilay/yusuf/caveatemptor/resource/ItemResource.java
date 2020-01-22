package org.kizilay.yusuf.caveatemptor.resource;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.kizilay.yusuf.caveatemptor.domain.Item;
import org.kizilay.yusuf.caveatemptor.resource.multiple.ArrayOfCategoryResource;
import org.kizilay.yusuf.caveatemptor.resource.multiple.ArrayOfImageResource;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.Set;
public class ItemResource extends BaseResource<Item> {

    private String name;

    private BigDecimal initialPrice;

    private String seller;

    @JsonProperty("images")
    private Set<ImageResource> imageResources;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Set<ImageResource> getImageResources() {
        return imageResources;
    }

    public void setImageResources(Set<ImageResource> imageResources) {
        this.imageResources = imageResources;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public Item toDomain() {
        Item item = new Item(this.name, this.initialPrice, null);

        this.imageResources.forEach(imageResource -> {
            item.getImages().add(imageResource.toDomain());
        });

        return item;
    }
}
