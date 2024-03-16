package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import connections.CommonStepVarables;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import pageObject.Checkoutpage;

public class Hooks {
	public CommonStepVarables commonstepvarables;
	
	public Hooks(CommonStepVarables commonstepvarables) {
		this.commonstepvarables=commonstepvarables;	
		
	}
	
	@After
	public void AfterScenario() throws InterruptedException, IOException 
	{
		commonstepvarables.visiturl.WebDriverManager().quit();
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws InterruptedException, IOException
	{
		WebDriver driver = commonstepvarables.visiturl.WebDriverManager();
		if(scenario.isFailed()) {
			File sourepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourepath);
			scenario.attach(fileContent, "image/png", "image");
			
		}
		
	}
}
