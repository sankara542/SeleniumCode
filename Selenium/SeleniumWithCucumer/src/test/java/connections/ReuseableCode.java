package connections;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class ReuseableCode {

	public WebDriver driver;

	public ReuseableCode(WebDriver driver) {
		this.driver= driver;
	}

	public void SwitchWindowToChild() throws InterruptedException {
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> il = s1.iterator();
		String Parentwindow = il.next();
		String Childwindow = il.next();
		driver.switchTo().window(Childwindow);
		Thread.sleep(3000);
	}


}
