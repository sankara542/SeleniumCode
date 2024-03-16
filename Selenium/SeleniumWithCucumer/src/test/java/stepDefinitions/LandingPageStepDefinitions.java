package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import connections.CommonStepVarables;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObject.landingPage;

public class LandingPageStepDefinitions {
	public CommonStepVarables commonstepvarables;
	public LandingPageStepDefinitions(CommonStepVarables commonstepvarables) {

		this.commonstepvarables=commonstepvarables;	
	}

	@Given("User is in Greencart Landing page")
	public void user_is_in_greencart_landing_page() throws InterruptedException, IOException {
		commonstepvarables.visiturl.WebDriverManager();
	}
	@When("^User search with short name (.+) and extract the actual name of product$")
	public void user_search_with_short_name_and_extract_the_actual_name_of_product(String ProducuName) throws InterruptedException {
		landingPage landing = commonstepvarables.pageobjectmanager.getLandingPages();
		landing.Search(ProducuName);
		Thread.sleep(2000);
		commonstepvarables.LandingproductName = landing.getProductName();
		System.out.println(commonstepvarables.LandingproductName +"Is extracted from home page");

	}

}
