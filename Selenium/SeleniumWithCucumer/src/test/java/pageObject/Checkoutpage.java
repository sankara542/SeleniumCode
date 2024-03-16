package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import connections.CommonStepVarables;

public class Checkoutpage {
	
	private WebDriver driver;
	By amout = By.xpath("//p[@class=\"product-price\"]");
	By increanment = By.xpath("//a[@class=\"increment\"]");
	By clickOnAddCart = By.xpath("//button[text()=\"ADD TO CART\"]");
	By clickonCart = By.xpath("//img[@alt=\"Cart\"]");
	By clickonproceed = By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]");
	By productname = By.xpath("//p[@class=\"product-name\"]");
	By Quantity = By.xpath("//p[@class=\"quantity\"]");
	By Prize = By.xpath("//td[4]//p[@class=\"amount\"]");
	By Total = By.xpath("//td[5]//p[@class=\"amount\"]");
	By apply = By.xpath("//button[text()=\"Apply\"]");
	By placeoder = By.xpath("//button[text()=\"Place Order\"]");


	public Checkoutpage(WebDriver driver) {

		this.driver=driver;	
	}

	public String getproductprice() {
		String prizeofproduct=driver.findElement(amout).getText();
		return prizeofproduct;
	}

	public void increaseproduct(int Prize) {
		int i = Prize-1;
		while (i>0) {

			driver.findElement(increanment).click();
			System.out.println("Clicked on Plus button");
			i--;		
		}

	}

	public void clickOnAddCart() {
		driver.findElement(clickOnAddCart).click();	
	}

	public void clickonCart() {
		driver.findElement(clickonCart).click();
		driver.findElement(clickonproceed).click();		
	}
	
	public String getproductname() {
		
		String Productname = driver.findElement(productname).getText().split("-")[0].trim();
		return Productname;
	}
	
	public String getQuantity() {
		String quantity = driver.findElement(Quantity).getText();
		return quantity;		
	}
	
	public String getprize() {
		String prize = driver.findElement(Prize).getText();
		return prize;
	}
	
	public String total() {
		String total = driver.findElement(Total).getText();
		return total;	
	}
	
	public Boolean verifyapplybutton() {
		return driver.findElement(apply).isDisplayed();
	}
	
	public Boolean verifyplaceorderbutton() {
		return driver.findElement(placeoder).isDisplayed();
	}
}
