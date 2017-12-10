package com.testsite.pages;

import com.testsite.Supporter;
import naso.data.FrameworkData;

/***********************************
 *Created by IntelliJ IDEA.
 * User: SomeshKumar
 * Date: 10/12/17
 * Time: 6:37 PM 
 ************************************/
public class CommonPageActions extends Supporter {

    public void launchDemoSite() {
        nasoDriver.launchBrowser(FrameworkData.SITE_URL);
    }

    public void closeBrowser(){
        nasoDriver.closeBrowser();
    }
}
