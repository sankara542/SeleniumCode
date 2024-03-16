package stepDefinitions;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import connections.CommonStepVarables;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.OfferPage;
import pageObject.landingPage;

public class OfferStepDefinitions {
	public CommonStepVarables commonstepvarables;

	public OfferStepDefinitions(CommonStepVarables commonstepvarables) {

		this.commonstepvarables=commonstepvarables;	
	}
	@Then("^Click on Top Deals and secrch with short (.+) in offer page if product exit or not$")
	public void click_on_top_deals_and_secrch_with_short_in_offer_page_if_product_exit_or_not(String ProducName) throws InterruptedException {
		switchToOffersPage();
		OfferPage offerpage = commonstepvarables.pageobjectmanager.getOfferPages();
		offerpage.Search(ProducName);
		Thread.sleep(2000);
		String Offerproductname = offerpage.getProductName();
		System.out.println("Product name is"+ Offerproductname);
		Assert.assertEquals(Offerproductname, commonstepvarables.LandingproductName);
		System.out.println("Testing"+ commonstepvarables.LandingproductName);

	}

	public void switchToOffersPage() throws InterruptedException
	{
		landingPage landing = commonstepvarables.pageobjectmanager.getLandingPages();
		landing.clickOnLink();
		commonstepvarables.reuseablecode.SwitchWindowToChild();
	}

}
