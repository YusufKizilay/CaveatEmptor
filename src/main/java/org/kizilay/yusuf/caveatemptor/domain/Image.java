package org.kizilay.yusuf.caveatemptor.domain;

import org.kizilay.yusuf.caveatemptor.resource.ImageResource;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Image {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "FILE_NAME")
    private String fileName;

    public Image() {
    }

    public Image(String title, String fileName) {
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

    public ImageResource toResource(){
        return  new ImageResource(this.title, this.fileName);
    }
}
