package naso.tool;

public interface IAutomationTool {

	public void launchBrowser(String URL);

	public void closeBrowser();

	public void clickElement(String elementXpath);

	public void sendValue(String elementXpath, Object value);

	public void clickAndSwitchToWindow(String elementXpath);

	public void switchToDefaultWindow();
	public void getValue(String elementXpath);
	public boolean isElementDisplayed(String elementXpath);
}
