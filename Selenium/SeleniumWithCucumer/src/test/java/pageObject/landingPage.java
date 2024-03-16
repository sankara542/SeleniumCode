package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import connections.CommonStepVarables;

public class landingPage {
	By Search = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	By Productname = By.xpath("//h4[@class='product-name']");
	By ClickOnLink = By.xpath("//div//a[text()='Top Deals']");
	private WebDriver driver;

	public landingPage(WebDriver driver) {

		this.driver=driver;	
	}

	public void Search(String name) {

		driver.findElement(Search).sendKeys(name);
	}

	public String getProductName() {

		String text = driver.findElement(Productname).getText().split("-")[0].trim();
		return text;		
	}

	public void clickOnLink() {

		driver.findElement(ClickOnLink).click();
	}
}
