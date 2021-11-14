package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import constant.Constant;

public class GeneralPage {
	private By signinButton = By.xpath("//a[@class='login']");
	private By accountLabel = By.xpath("//div[@class='header_user_info']//a[@class='account']/span");
	private By searchTextBox = By.id("search_query_top");
	private By searchButton = By.xpath("//button[contains(@name, 'submit_search')]");
	private String menuOptionXpath = "//div[contains(@id, 'block_top_menu')]/ul[contains(@class, 'menu-content')]/li/a[text()='%s']";
	private String submenuOptionXpath = "//div[contains(@id, 'block_top_menu')]/ul/li/ul/li/ul/li/a[contains(@title,'%s')]";
	
	protected WebElement getSigninButton() {
		return Constant.WEBDRIVER.findElement(signinButton);
	};
	
	protected WebElement getAccountLabel() {
		return Constant.WEBDRIVER.findElement(accountLabel);
	}
	
	protected WebElement getSearchTextBox() {
		return Constant.WEBDRIVER.findElement(searchTextBox);
	}
	
	protected WebElement getSearchButton() {
		return Constant.WEBDRIVER.findElement(searchButton);
	}
	
	protected WebElement getMenuOption(String menu) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(menuOptionXpath, menu)));
	}
	
	protected WebElement getSubMenuOption(String subMenu) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(submenuOptionXpath, subMenu)));
	}
	
	public void goToSigninPage() {
		this.getSigninButton().click();
	}
	
	public String getAccountLabelValue() {
		return this.getAccountLabel().getText();
	}
	
	public void scrollToElement(WebElement  element) {
		((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void enterKeywordInSearchBox(String keyword) {
		this.getSearchTextBox().sendKeys(keyword);
	}
	
	public void clickSearchButton() {
		this.getSearchButton().click();
	}
	
	public void moveToMenuOption(String menu) {
		Actions actions = new Actions(Constant.WEBDRIVER);
		actions.moveToElement(this.getMenuOption(menu)).perform();
	}
	
	public void clickSubMenuOption(String subMenu) {
		Actions actions = new Actions(Constant.WEBDRIVER);
		actions.moveToElement(this.getSubMenuOption(subMenu)).perform();
		this.getSubMenuOption(subMenu).click();
	}
}
