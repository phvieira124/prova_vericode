package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wait {
	
	public static void waitForElement(WebDriver driver, WebElement element, Long timeoutInSeconds) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		try {
			webDriverWait.until(ExpectedConditions.visibilityOf(element));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void wait(int time) throws InterruptedException {
		Thread.sleep(time);
	}
}
