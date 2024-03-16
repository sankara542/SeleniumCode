package connections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

public class VisitUrl {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws InterruptedException, IOException {

		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop= new Properties();
		prop.load(file);
		String Url = prop.getProperty("QaUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		if(driver == null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(Url);
				driver.manage().window().maximize();
				Thread.sleep(2000);
			}

			if(browser.equalsIgnoreCase(".")) {	
				try {
					System.setProperty("webdriver.gecko.driver","C:\\Users\\saiku\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
					driver = new FirefoxDriver();
					driver.get(Url);
					driver.manage().window().maximize();
					Thread.sleep(3000);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Thread.sleep(3000);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		}
		return driver;
	}

}
