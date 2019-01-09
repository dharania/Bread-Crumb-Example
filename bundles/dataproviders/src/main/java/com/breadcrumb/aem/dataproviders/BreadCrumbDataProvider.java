package com.breadcrumb.aem.dataproviders;

import com.adobe.cq.sightly.WCMUsePojo;
import com.breadcrumb.aem.dataproviders.datamodel.BreadCrumbDataModel;
import com.day.cq.wcm.api.Page;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import org.apache.sling.api.resource.ValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Bread Crumb example :: data provider
 *
 * This class provides list of navigation items for breadcrumb component. If a page is being black listed, that's not
 * included in the list
 *
 * Author: Dharani A
 * Date: 1/8/2019
 *
 */

public class BreadCrumbDataProvider extends WCMUsePojo{
    // String constants
    private static final String HOME_PAGE_PATH = "/content/sites/geometrixx/en"; // for testing purpose
    private static final String EXCLUDED_PAGES_PROPERTY_NAME = "excludedPages";
    private static final String EXCLUDED_PAGE_PROPERTY_NAME = "excludedPage";

    private Logger logger = LoggerFactory.getLogger(BreadCrumbDataProvider.class);

    // Private member variables
    private List breadCrumbItems;

    /**
     * Activate component
     * @throws Exception
     */
    @Override
    public void activate() throws Exception {

        ValueMap properties = getProperties();
        String[] excludedPages = properties.get(EXCLUDED_PAGES_PROPERTY_NAME, String[].class);
        List excludedPagesList = new ArrayList();

        breadCrumbItems = new ArrayList();

        //Convert to array list
        if(excludedPages != null && excludedPages.length > 0) {
            String excludedPagesJson = "[" + String.join(",", excludedPages) + "]";
            excludedPagesList = new Gson().fromJson(excludedPagesJson, ArrayList.class);
        }
        // get current page
        Page currentPage = getCurrentPage();

        // recursively get parents up to home page and add to arrayList
       createBreadCrumbList(currentPage, excludedPagesList, 1);
    }

    /**
     * Private method to add parent pages to the list recursively
     * @param currentPage
     */
    private void createBreadCrumbList(Page currentPage, List excludedPages, int iterationCount) {
        if(!currentPage.getPath().equalsIgnoreCase(HOME_PAGE_PATH)) {
            // in case it does not have expected home page path, return after 20 iterations
            if(iterationCount >= 20) {
                logger.info("Bread-crumb root/home page not found for 20 iterations. Exiting...");
                return;
            }
            createBreadCrumbList(currentPage.getParent(), excludedPages, ++iterationCount);
        }
        // check if current page is black listed
        for (Object pathObject: excludedPages) {
            LinkedTreeMap map = (LinkedTreeMap) pathObject;
            String pagePath = map.get(EXCLUDED_PAGE_PROPERTY_NAME).toString();
            if(pagePath.equalsIgnoreCase(currentPage.getPath())) {
                return;
            }
        }
        BreadCrumbDataModel breadCrumbDataModel = new BreadCrumbDataModel(currentPage.getTitle(), currentPage.getPath());
        breadCrumbItems.add(breadCrumbDataModel);
    }

    /**
     * get bread crumb items
     * @return breadCrumbItems
     */
    public List getBreadCrumbItems() {
        return breadCrumbItems;
    }
}
