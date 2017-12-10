package com.testsite.tests;

import com.testsite.pages.CommonPageActions;
import com.testsite.pages.HomePage;
import naso.data.Constants;
import naso.data.FrameworkData;

public class Trail_Test {

    public void test1(){
        HomePage homePage = new HomePage();
        CommonPageActions commonPageAction = new CommonPageActions();
        commonPageAction.launchDemoSite();
        homePage.getHomePageText();
        homePage.getHomePageTab2Text();
    }

}
