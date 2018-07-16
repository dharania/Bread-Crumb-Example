package com.breadcrumb.aem.dataproviders.datamodel;

/**
 * Bread Crumb example :: data model
 *
 * This is a simple class to hold bread crumb data (page path and title)
 *
 * Author: Dharani A
 * Date: 7/16/2018
 *
 */

public class BreadCrumbDataMOdel{

    private String title;
    private String path;

    public BreadCrumbDataMOdel (title, path) {
        title = title;
        path = path;
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
