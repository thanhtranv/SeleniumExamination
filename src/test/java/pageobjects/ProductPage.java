package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant;

public class ProductPage extends GeneralPage {
	private String productNameXpath = "//ul[contains(@class, 'product_list')]/li[%s]//a[contains(@class, 'product-name')]";
	
	protected WebElement getProductNameLabel(String order) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(productNameXpath, order)));
	}
	
	public String getProductNameLabelValue(String order) {
		this.scrollToElement(this.getProductNameLabel(order));
		return this.getProductNameLabel(order).getText();
	}
}
