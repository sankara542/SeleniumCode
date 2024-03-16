package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import connections.CommonStepVarables;

public class OfferPage {
	By Search = By.xpath("//input[@id=\"search-field\"]");
	By Productname = By.xpath("//tr[1]//td[1]");
	private WebDriver driver;

	public OfferPage(WebDriver driver) {

		this.driver=driver;	
	}

	public void Search(String name) {

		driver.findElement(Search).sendKeys(name);
	}

	public String getProductName() {

		String text = driver.findElement(Productname).getText();
		return text;		
	}


}
