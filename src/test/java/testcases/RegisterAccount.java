package testcases;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constant.Constant;
import dataobjects.InformationAccount;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import pageobjects.SignInPage;

public class RegisterAccount {
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
	public void RegisterAccountTest() {
		HomePage homePage = new HomePage();
		homePage.open();
		homePage.goToSigninPage();
		
		Random random = new Random(); 
		int number = random.nextInt();
		String emailRandom = "thanh" + number + "@gmail.com";
		
		InformationAccount info = new InformationAccount("male", "Thanh", "Tran", emailRandom, "123456", "13", "2", "1995", true, "Thanh", "Tran", "tan phu", "abc", "Texas", "70000", "United States", "012345678", "adress");
		
		SignInPage signInPage = new SignInPage();
		signInPage.goToRegisterPage(info.email);
		
		RegisterPage registerPage = new RegisterPage();
		registerPage.enterInformation(info);
		registerPage.clickSubmitButton();
		
		String userName = info.customerFirstName + " " + info.customerLastName;
		String createdAccount = homePage.getAccountLabelValue();
		Assert.assertEquals(createdAccount, userName, "User is not created as expected");
	}
}
