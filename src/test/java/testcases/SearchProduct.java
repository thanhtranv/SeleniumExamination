package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import pageobjects.SearchPage;

public class SearchProduct {
	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().browserVersion(null).setup();
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
		Constant.WEBDRIVER.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Constant.WEBDRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod 
	public void afterMethod() {
		Constant.WEBDRIVER.quit();
	}
	
	@Test
	public void SearchProductTest() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.open();
		
		homePage.moveToMenuOption("Women");
		homePage.clickSubMenuOption("T-shirts");
		
		ProductPage productPage = new ProductPage();
		String firstProduct = productPage.getProductNameLabelValue("1");
		
		productPage.enterKeywordInSearchBox(firstProduct);
		productPage.clickSearchButton();
		Thread.sleep(5000);
		
		SearchPage searchPage = new SearchPage();
		boolean validatedProduct = searchPage.validateDisplayedProduct(firstProduct);
		Assert.assertEquals(validatedProduct, true, "Product is not displayed as expected");
	}
}
