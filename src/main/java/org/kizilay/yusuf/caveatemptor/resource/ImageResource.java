package org.kizilay.yusuf.caveatemptor.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.kizilay.yusuf.caveatemptor.domain.Image;

import javax.persistence.Column;


@JsonRootName("Image")
public class ImageResource extends BaseResource<Image> {

    @JsonProperty("title")
    private String title;

    @JsonProperty("filename")
    private String fileName;

    public ImageResource() {
    }

    public ImageResource(String title, String fileName) {
        this.title = title;
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Image toDomain() {
        return new Image(this.title,this.fileName);
    }
}
