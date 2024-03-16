package stepDefinitions;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import connections.CommonStepVarables;
import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.Checkoutpage;
import pageObject.landingPage;

public class CheckOutStepDefinitions {
	public CommonStepVarables commonstepvarables;
	public Checkoutpage checkoutpage;
	String ProductPize;
	public CheckOutStepDefinitions(CommonStepVarables commonstepvarables) {

		this.commonstepvarables=commonstepvarables;	
		this.checkoutpage=commonstepvarables.pageobjectmanager.getCheckoutpage();
	}

	@And("^Added on (.+) items of selected products to cart$")
	public void Added_items_of_selected_products_to_cart(String Quantity) throws InterruptedException{
		ProductPize = checkoutpage.getproductprice();
		System.out.println(ProductPize+": Pize of product");
		checkoutpage.increaseproduct(Integer.parseInt(Quantity));
		Thread.sleep(2000);
		checkoutpage.clickOnAddCart();
		Thread.sleep(2000);
		checkoutpage.clickonCart();	
		Thread.sleep(2000);
	}
	
	@When("^User in checkout page verify totalamout and product name and quantity as (.+)$")
	public void User_in_checkout_page_verify_totalamout_and_product_name_and_quantity(String Quantity1) {
		String productname = checkoutpage.getproductname();
		Assert.assertEquals(productname, commonstepvarables.LandingproductName);
		String quantity = checkoutpage.getQuantity();
		Assert.assertEquals(quantity, Quantity1);
		String prize = checkoutpage.getprize();
		Assert.assertEquals(prize, ProductPize);
		String total = checkoutpage.total();
		int totalamout = (Integer.parseInt(prize))*(Integer.parseInt(Quantity1));
		System.out.println("Print total amout of product :" +totalamout);
		Assert.assertEquals(total, Integer.toString(totalamout));
	}
	
	@And("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		Assert.assertTrue(checkoutpage.verifyapplybutton());
		Assert.assertTrue(checkoutpage.verifyplaceorderbutton());
	}

}
