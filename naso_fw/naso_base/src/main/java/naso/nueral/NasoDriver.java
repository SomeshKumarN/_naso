package naso.nueral;

import naso.tool.IAutomationTool;
import naso.tool.selenium.SeleniumTool;
import naso.utils.InputPropReader;
import org.openqa.selenium.WebDriver;

public class NasoDriver implements IAutomationTool {
    //    private static IAutomationTool iAutomationTool = null;
    private final IAutomationTool iAutomationTool;

    public NasoDriver() {

        if (InputPropReader.getValueOf("Tool").equalsIgnoreCase("Selenium")) {
            iAutomationTool = new SeleniumTool(InputPropReader.getValueOf("Browser").toUpperCase());
        } else {
            iAutomationTool = null;
        }
    }

    public NasoDriver(WebDriver driver) {
        iAutomationTool = new SeleniumTool(driver);
    }

    public void launchBrowser(String URL) {
        iAutomationTool.launchBrowser(URL);
    }

    public void closeBrowser() {
        iAutomationTool.closeBrowser();

    }

    public void clickElement(String elementXpath) {
        iAutomationTool.clickElement(elementXpath);

    }

    public void sendValue(String elementXpath, Object value) {
        iAutomationTool.sendValue(elementXpath, value);
    }

    public void clickAndSwitchToWindow(String elementXpath) {
        iAutomationTool.clickAndSwitchToWindow(elementXpath);
    }

    public void switchToDefaultWindow() {
        iAutomationTool.switchToDefaultWindow();
    }

    public void getValue(String elementXpath) {
        iAutomationTool.getValue(elementXpath);
    }

    public boolean isElementDisplayed(String elementXpath) {
        return iAutomationTool.isElementDisplayed(elementXpath);
    }
}
