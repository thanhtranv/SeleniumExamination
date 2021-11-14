package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant;

public class SignInPage {
	private By emailTextBox = By.id("email_create");
	private By createaccountButton = By.id("SubmitCreate");
	
	protected WebElement getEmailTextBox() {
		return Constant.WEBDRIVER.findElement(emailTextBox);
	}
	
	protected WebElement getCreateAccountButton() {
		return Constant.WEBDRIVER.findElement(createaccountButton);
	}
	
	public void goToRegisterPage(String email) {
		this.getEmailTextBox().sendKeys(email);
		this.getCreateAccountButton().click();
	}
}
