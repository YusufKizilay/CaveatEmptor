package org.kizilay.yusuf.caveatemptor.resource.multiple;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.kizilay.yusuf.caveatemptor.domain.Image;
import org.kizilay.yusuf.caveatemptor.resource.ImageResource;
import org.kizilay.yusuf.caveatemptor.resource.ArrayResourceHelper;

import java.util.Set;

public class ArrayOfImageResource implements ArrayResourceHelper<ImageResource,Image> {

    @JsonProperty("images")
    private Set<ImageResource> imageResources;

    public Set<ImageResource> getImageResources() {
        return imageResources;
    }

    public void setImageResources(Set<ImageResource> imageResources) {
        this.imageResources = imageResources;
    }

    @Override
    public Set<ImageResource> resources() {
        return this.imageResources;
    }
}
