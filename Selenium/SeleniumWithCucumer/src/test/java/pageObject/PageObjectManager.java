package pageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public landingPage Landingpage;
	public OfferPage offerPage;
	public Checkoutpage checkoutpage;
	public WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver= driver;
	}

	public landingPage getLandingPages() {
		Landingpage= new landingPage(driver);
		return Landingpage;
	}

	public OfferPage getOfferPages() {
		offerPage= new OfferPage(driver);
		return offerPage;
	}
	
	public Checkoutpage getCheckoutpage() {
		checkoutpage= new Checkoutpage(driver);
		return checkoutpage;
	}

}
