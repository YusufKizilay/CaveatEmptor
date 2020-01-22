package org.kizilay.yusuf.caveatemptor.resource.multiple;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.kizilay.yusuf.caveatemptor.domain.Item;
import org.kizilay.yusuf.caveatemptor.resource.ItemResource;
import org.kizilay.yusuf.caveatemptor.resource.ArrayResourceHelper;

import java.util.Set;

public class ArrayOfItemResource implements ArrayResourceHelper<ItemResource,Item> {

    @JsonProperty("items")
    private Set<ItemResource> itemResources;

    public Set<ItemResource> getItemResources() {
        return itemResources;
    }

    public void setItemResources(Set<ItemResource> itemResources) {
        this.itemResources = itemResources;
    }

    @Override
    public Set<ItemResource> resources() {
        return getItemResources();
    }
}
