package naso.tool.selenium;

import naso.tool.Browser;
import naso.utils.InputPropReader;
import naso.utils.NasoLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;
import java.util.Set;

public class BasicSelenium {

    private static WebDriver driver = null;

    WebDriver _getDriverOf(String browserName) {
        switch (Browser.valueOf(browserName)) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "F:\\Automation Artifacts\\Browser Drivers\\geckodriver.exe");
                return new FirefoxDriver();
            case INTERNET_EXPLORER:
                return new InternetExplorerDriver();
            case SAFARI:
                return new SafariDriver();
            default:
                NasoLogger.logDebug("Browser name mentioned in the INPUT shet is not handled in framework");
                break;
        }
        return null;
    }

    protected void _get(String url) {
        driver.get(url);
    }

    protected String _getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    protected String _getTitle() {
        String title = driver.getTitle();
        return title;
    }

    protected List<WebElement> _findElements(String elementXpath) {
        List<WebElement> elementsList = driver.findElements(By.xpath(elementXpath));
        return elementsList;
    }

    protected WebElement _findElement(String elementXpath) {
        WebElement element = driver.findElement(By.xpath(elementXpath));
        return element;
    }

    protected String _getPageSource() {
        return driver.getPageSource();
    }

    protected void _close() {
        driver.close();
    }

    protected void _quit() {
        driver.quit();
    }

    protected Set<String> _getWindowHandles() {
        Set<String> handles = driver.getWindowHandles();
        return handles;
    }

    protected String _getWindowHandle() {
        String handle = driver.getWindowHandle();
        return handle;
    }

    protected void _click(String elementXpath) {
        _findElement(elementXpath).click();
    }

    protected void _sendKeys(String elementXpath, Object value) {
        _findElement(elementXpath).sendKeys(value.toString());
    }

    protected void _switchToWindow() {
        for (String windowHandle : _getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }

    protected void _switchToDefaultWindow1() {
        driver.switchTo().defaultContent();
    }

    protected boolean _isElementDisplayed(String elementXpath) {
        boolean isElementDisplayed = false;
        if (_findElement(elementXpath).isDisplayed()) {
            isElementDisplayed = true;
        }
        return isElementDisplayed;
    }

    protected void _startWebdriver() {
        if (driver == null) {
            this.driver = _getDriverOf(InputPropReader.getValueOf("Browser").toUpperCase());
        } else if (driver != null) {
            driver.quit();
            this.driver = _getDriverOf(InputPropReader.getValueOf("Browser").toUpperCase());
        }
    }

    protected void _endWebdriver() {
        driver.quit();
    }
}
