package com.breadcrumb.aem.dataproviders.datamodel;

/**
 * Bread Crumb example :: data model
 *
 * This is a simple class to hold bread crumb data (page path and title)
 *
 * Author: Dharani A
 * Date: 1/8/2019
 *
 */

public class BreadCrumbDataModel{

    private String title;
    private String path;

    public BreadCrumbDataModel (String title, String path) {
        this.title = title;
        this.path = path;
    }

    //Accessors
    public String getTitle() {
        return title;
    }
    public void setTitle (String title) {
        this.title = title;
    }
    public String getPath() {
        return path;
    }
    public void setPath (String path) {
        this.path = path;
    }
}
