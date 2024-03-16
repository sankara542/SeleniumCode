package connections;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObject.PageObjectManager;

public class CommonStepVarables {
	public WebDriver driver;
	public String LandingproductName;
	public PageObjectManager pageobjectmanager;
	public VisitUrl visiturl;
	public ReuseableCode reuseablecode;

	public CommonStepVarables() throws InterruptedException, IOException
	{
		visiturl= new VisitUrl();
		pageobjectmanager= new PageObjectManager(visiturl.WebDriverManager());
		reuseablecode= new ReuseableCode(visiturl.WebDriverManager());

	}

}
