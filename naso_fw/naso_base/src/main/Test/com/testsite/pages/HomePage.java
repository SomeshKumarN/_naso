package com.testsite.pages;

import com.testsite.Supporter;

public class HomePage extends Supporter {

    private String homeTab2Xpath = "//*[@id='ui-id-2']";
    private String homeTextXpath = "//*[@class='entry-title']";
    private String homeTab2ContentXpath = "//*[@id='tabs-2'']/b";
    private String registrationSectionXpath = "//*[@class='widget-title panel-title' and text()='Registration']";
    private String registrationLinkXpath = "//*[@href='registration/index.html']";
    private String interactionSectionXpath = "//*[@class='widget-title panel-title' and text()='interaction']";
    private String draggableLinkXpath = "//*[@href='draggable/index.html']";
    private String droppableLinkXpath = "//*[@href='droppable/index.html']";
    private String resizableLinkXpath = "//*[@href='resizable/index.html']";
    private String selectatbleLinkXpath = "//*[@href='selectable/index.html']";
    private String sortableLinkXpath = "//*[@href='sortable/index.html']";
    private String widgetSectionXpath = "//*[@class='widget-title panel-title' and text()='Widget']";
    private String accordionLinkXpath = "//*[@href='accordion/index.html']";
    private String autocompleteLinkXpath = "//*[@href='autocomplete/index.html']";
    private String datepickerLinkXpath = "//*[@href='datepicker/index.html']";
    private String menuLinkXpath = "//*[@href='menu/index.html']";
    private String sliderLinkXpath = "//*[@href='slider/index.html']";
    private String tabsLinkXpath = "//*[@id='menu-item-98']/a[@href='tabs/index.html']";
    private String tooltipLinkXpath = "//*[@href='tooltip/index.html']";
    private String framesAndWindowsSectionXpath = "//*[@class='widget-title panel-title' and text()='Frames and Windows']";
    private String framesAndWindowsLinkXpath = "//*[@href='frames-and-windows/index.html']";

    public void getHomePageText() {
        if (nasoDriver.isElementDisplayed(homeTextXpath)) {
            System.out.println(nasoDriver.getValue(homeTextXpath));
        }
    }

    public void getHomePageTab2Text() {
        if (nasoDriver.isElementDisplayed(homeTab2Xpath)) {
            nasoDriver.clickElement(homeTab2Xpath);
            System.out.println(nasoDriver.getValue(homeTab2ContentXpath));
        }
    }

    public void presenceOfElement(String elementName, String elementXpath) {
        if (nasoDriver.isElementDisplayed(elementXpath)) {
            System.out.println(elementName + " is Present");
        } else {
            System.out.println(elementName + " is not Present");
        }
    }

    public void isRegistrationSectionPresent() {
        presenceOfElement("RegistrationSection", registrationSectionXpath);
    }

    public void isRegistrationLinkPresent() {
        presenceOfElement("RegistrationLink", registrationLinkXpath);
    }

    public void isInteractionSectionPresent() {
        presenceOfElement("InteractionSection", interactionSectionXpath);
    }

    public void isDraggableLinkPresent() {
        presenceOfElement("DraggableLink", draggableLinkXpath);
    }

    public void isDroppableLinkPresent() {
        presenceOfElement("DroppableLink", droppableLinkXpath);
    }

    public void isResizableLinkPresent() {
        presenceOfElement("ResizableLink", resizableLinkXpath);
    }

    public void isSelectatbleLinkPresent() {
        presenceOfElement("SelectatbleLink", selectatbleLinkXpath);
    }

    public void isSortableLinkPresent() {
        presenceOfElement("SortableLink", sortableLinkXpath);
    }

    public void isWidgetSectionPresent() {
        presenceOfElement("WidgetSection", widgetSectionXpath);
    }

    public void isAccordionLinkPresent() {
        presenceOfElement("AccordionLink", accordionLinkXpath);
    }

    public void isAutocompleteLinkPresent() {
        presenceOfElement("AutocompleteLink", autocompleteLinkXpath);
    }

    public void isDatepickerLinkPresent() {
        presenceOfElement("DatepickerLink", datepickerLinkXpath);
    }

    public void isMenuLinkPresent() {
        presenceOfElement("MenuLink", menuLinkXpath);
    }

    public void isSliderLinkPresent() {
        presenceOfElement("SliderLink", sliderLinkXpath);
    }

    public void isTabsLinkPresent() {
        presenceOfElement("TabsLink", tabsLinkXpath);
    }

    public void isTooltipLinkPresent() {
        presenceOfElement("TooltipLink", tooltipLinkXpath);
    }

    public void isFramesAndWindowsSectionPresent() {
        presenceOfElement("FramesAndWindowsSection", framesAndWindowsSectionXpath);
    }

    public void isFramesAndWindowsLinkPresent() {
        presenceOfElement("FramesAndWindowsLink", framesAndWindowsLinkXpath);
    }
}

