package naso.tool.selenium;

import naso.tool.IAutomationTool;

public class SeleniumTool extends BasicSelenium implements IAutomationTool {

    public void launchBrowser(String URL) {
        _get(URL);
        System.out.println("Launch URL called from Selenium tool");
    }

    public String getValue(String xpath) {
        return _findElement(xpath).getText();
    }

    public void closeBrowser() {
        _close();
        System.out.println("close");
    }

    public void clickElement(String elementXpath) {
        _click(elementXpath);
    }

    public void sendValue(String elementXpath, Object value) {
        _sendKeys(elementXpath, value);
    }

    public void clickAndSwitchToWindow(String elementXpath) {
        clickElement(elementXpath);
        _switchToWindow();
    }

    public void switchToDefaultWindow() {
        _switchToDefaultWindow1();
    }

    public boolean isElementDisplayed(String elementXpath) {
        return _isElementDisplayed(elementXpath);
    }

    public void startTest() {
        _startWebdriver();
    }

    public void endTest() {
        _endWebdriver();
    }
}
