package naso.nueral;

import naso.tool.Browser;
import naso.tool.selenium.SeleniumTool;
import naso.utils.InputPropReader;
import naso.utils.NasoLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Drivers {
    public static WebDriver seleniumDriver = null;
    private static String toolName = InputPropReader.getValueOf("Tool").toLowerCase();
    private static String browserName = InputPropReader.getValueOf("Browser").toUpperCase();

    public static WebDriver getSeleniumDriver() {
        setSeleniumDriver(seleniumDriver, browserName);
        return seleniumDriver;
    }

    public static void setSeleniumDriver(WebDriver seleniumDriver, String browserName) {

        switch (Browser.valueOf(browserName)) {
            case CHROME:
                Drivers.seleniumDriver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "F:\\Automation Artifacts\\Browser Drivers\\geckodriver.exe");
                Drivers.seleniumDriver = new FirefoxDriver();
                break;
            case INTERNET_EXPLORER:
                Drivers.seleniumDriver = new InternetExplorerDriver();
                break;
            case SAFARI:
                Drivers.seleniumDriver = new SafariDriver();
                break;
            default:
                NasoLogger.logDebug("Browser name mentioned in the INPUT shet is not handled in framework");
                break;
        }
    }
}
