package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import constant.Constant;

public class SearchPage extends GeneralPage {
	private By productList = By.xpath("//ul[contains(@class, 'product_list')]//a[contains(@class, 'product-name')]");
	
	protected List<WebElement> getProductList() {
		return Constant.WEBDRIVER.findElements(productList);
	}
	
	public boolean validateDisplayedProduct(String productName) {
		List<WebElement> list = this.getProductList();
		boolean validatedProduct = false;
		
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				this.scrollToElement(list.get(i));
				if (list.get(i).getText().toLowerCase().equals(productName.toLowerCase())) {
					validatedProduct = true;
				}
			}
		} 
		return validatedProduct;
	}
}
