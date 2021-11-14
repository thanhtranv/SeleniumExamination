package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import constant.Constant;
import dataobjects.InformationAccount;

public class RegisterPage extends GeneralPage {
	private By gender_maleRadio = By.id("id_gender1");
	private By gender_femaleRadio = By.id("id_gender2");
	private By customer_firstnameTextBox = By.id("customer_firstname");
	private By customer_lastnameTextBox = By.id("customer_lastname");
	private By passwordTextBox = By.id("passwd");
	private By dateSelect = By.id("days");
	private By monthSelect = By.id("months");
	private By yearSelect = By.id("years");
	private By receiveofferCheckBox = By.id("optin");
	private By firstnameTextBox = By.id("firstname");
	private By lastnameTextBox = By.id("lastname");
	private By addressTextBox = By.id("address1");
	private By cityTextBox = By.id("city");
	private By stateSelect = By.id("id_state");
	private By postcodeTextBox = By.id("postcode");
	private By countrySelect = By.id("id_country");
	private By phone_mobileTextBox = By.id("phone_mobile");
	private By aliasTextBox = By.id("alias");
	private By submitButton = By.id("submitAccount");
	
	protected WebElement getGenderMaleRadio() {
		return Constant.WEBDRIVER.findElement(gender_maleRadio);
	}
	protected WebElement getGenderFemaleRadio() {
		return Constant.WEBDRIVER.findElement(gender_femaleRadio);
	}
	
	protected WebElement getCustomerFirstNameTextBox() {
		return Constant.WEBDRIVER.findElement(customer_firstnameTextBox);
	}
	
	protected WebElement getCustomerLastNameTextBox() {
		return Constant.WEBDRIVER.findElement(customer_lastnameTextBox);
	}
	
	protected WebElement getPasswordTextBox() {
		return Constant.WEBDRIVER.findElement(passwordTextBox);
	}
	
	protected WebElement getDateSelect() {
		return Constant.WEBDRIVER.findElement(dateSelect);
	}
	
	protected WebElement getMonthSelect() {
		return Constant.WEBDRIVER.findElement(monthSelect);
	}
	
	protected WebElement getYearSelect() {
		return Constant.WEBDRIVER.findElement(yearSelect);
	}
	
	protected WebElement getReceiveOfferCheckBox() {
		return Constant.WEBDRIVER.findElement(receiveofferCheckBox);
	}
	
	protected WebElement getFirstNameTextBox() {
		return Constant.WEBDRIVER.findElement(firstnameTextBox);
	}
	
	protected WebElement getLastNameTextBox() {
		return Constant.WEBDRIVER.findElement(lastnameTextBox);
	}
	
	protected WebElement getAddressTextBox() {
		return Constant.WEBDRIVER.findElement(addressTextBox);
	}
	
	protected WebElement getCityTextBox() {
		return Constant.WEBDRIVER.findElement(cityTextBox);
	}
	
	protected WebElement getStateSelect() {
		return Constant.WEBDRIVER.findElement(stateSelect);
	}
	
	protected WebElement getPostCodeTextBox() {
		return Constant.WEBDRIVER.findElement(postcodeTextBox);
	}
	
	protected WebElement getCountrySelect() {
		return Constant.WEBDRIVER.findElement(countrySelect);
	}
	
	protected WebElement getPhoneMobileTextBox() {
		return Constant.WEBDRIVER.findElement(phone_mobileTextBox);
	}
	
	protected WebElement getAliasTextBox() {
		return Constant.WEBDRIVER.findElement(aliasTextBox);
	}
	
	protected WebElement getSubmitButton() {
		return Constant.WEBDRIVER.findElement(submitButton);
	}
	
	public void enterInformation(InformationAccount i) {
		if(i.gender.toLowerCase() == "male") {
			this.getGenderMaleRadio().click();
		} else if (i.gender.toLowerCase() == "female"){
			this.getGenderFemaleRadio().click();
		}
		
		this.getCustomerFirstNameTextBox().sendKeys(i.customerFirstName);
		this.getCustomerLastNameTextBox().sendKeys(i.customerLastName);
		this.getPasswordTextBox().sendKeys(i.password);
		
		this.scrollToElement(getDateSelect());
		Select dateDropdown = new Select(this.getDateSelect());
		Select monthDropdown = new Select(this.getMonthSelect());
		Select yearDropdown = new Select(this.getYearSelect());
		dateDropdown.selectByValue(i.dateOfBirth);
		monthDropdown.selectByValue(i.monthOfBirth);
		yearDropdown.selectByValue(i.yearOfBirth);
		
		if(i.receiveOffer) {
			this.getReceiveOfferCheckBox().click();
		}
		
		this.scrollToElement(getFirstNameTextBox());
		this.getFirstNameTextBox().clear();
		this.getFirstNameTextBox().sendKeys(i.firstName);
		this.getLastNameTextBox().clear();
		this.getLastNameTextBox().sendKeys(i.lastName);
		
		this.scrollToElement(getAddressTextBox());
		this.getAddressTextBox().sendKeys(i.address);
		this.getCityTextBox().sendKeys(i.city);
		
		this.scrollToElement(getStateSelect());
		Select stateDropdown = new Select(this.getStateSelect());
		stateDropdown.selectByVisibleText(i.state);
		
		this.getPostCodeTextBox().sendKeys(i.postCode);
		Select countryDropdown = new Select(this.getCountrySelect());
		countryDropdown.selectByVisibleText(i.country);
		
		this.scrollToElement(getPhoneMobileTextBox());
		this.getPhoneMobileTextBox().sendKeys(i.phoneMobile);
		this.getAliasTextBox().clear();
		this.getAliasTextBox().sendKeys(i.alias);
	}
	
	public void clickSubmitButton() {
		this.scrollToElement(getSubmitButton());
		this.getSubmitButton().click();
	}
}
