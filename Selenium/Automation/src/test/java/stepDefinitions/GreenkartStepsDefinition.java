package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;


public class GreenkartStepsDefinition {
	public String LandingproductName;
	public String Offerproductname;

	@Given("User is on Greencart landing page")
	public void user_is_on_greencart_landing_page() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Automation\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qa.pointchain.io/login");
		driver.manage().window().maximize();
		driver.wait(5000);
	    driver.findElement(By.xpath("//span[text()='Login']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("demo+authority@pointchain.io");
		driver.wait(2000);
		String LandingproductName = driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
		System.out.println(LandingproductName +"Is extracted from home page");
	}

}
