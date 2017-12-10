package naso.tool.selenium;

import naso.utils.NasoLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import naso.tool.Browser;

public class BrowserDriver {

	WebDriver webDriver;

	public BrowserDriver( String browserName) {
		 getDriverOf(browserName);
	}

	WebDriver getDriverOf(String browserName) {
		switch (Browser.valueOf(browserName)) {
		case CHROME:
			System.setProperty("webdriver.chrome.driver",
					"F:\\Automation Artifacts\\Browser Drivers\\chromedriver.exe");
			this.webDriver = new ChromeDriver();

			break;
		case FIREFOX:
			System.setProperty("webdriver.gecko.driver", "F:\\Automation Artifacts\\Browser Drivers\\geckodriver.exe");
			this.webDriver = new FirefoxDriver();
			break;
		case INTERNET_EXPLORER:
			this.webDriver = new InternetExplorerDriver();
			break;
		case SAFARI:
			this.webDriver = new SafariDriver();
			break;
		default:
			System.out.println("Selected browser is not in the available list");
			break;
		}
		return this.webDriver = null;
	}
}
