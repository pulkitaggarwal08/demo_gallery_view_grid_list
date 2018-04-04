package com.demo_gallery_grid_view.com.model;

/**
 * Created by pulkit on 12/1/18.
 */

public class Images {

    private String imageTitle;
    private Integer imageId;

    public Images() {
    }

    public Images(String imageTitle, Integer imageId) {
        this.imageTitle = imageTitle;
        this.imageId = imageId;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

}
