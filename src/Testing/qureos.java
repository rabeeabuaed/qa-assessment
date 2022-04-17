package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class qureos {
	public static WebDriver driver;
	static String driverPath = "C:\\selenium\\chromedriver_win32\\chromedriver.exe";
	public static String baseUrl = "https://app.qureos.com/";

	
	
	public static void login(WebDriver driver, String baseUrl, String driverPath) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		// go to "https://app.qureos.com/" website
		driver.get(baseUrl);
		// define username element and throw the username
		driver.findElement(
				By.xpath("//*[@id=\"__next\"]/main/section/div/section/section/div/div/form/section[1]/input")) 
				.sendKeys("rabeeabuaed@gmail.com");
		 //define Pass element and throw the password
		driver.findElement(By.cssSelector(
				"#__next > main > section > div > section > section > div > div > form > section:nth-child(2) > input"))
				.sendKeys("Rabee_1992n");
		 //define login button 
			driver.findElement(
				By.xpath("//*[@id=\"__next\"]/main/section/div/section/section/div/div/form/div/section/button"))
				.click();
		// sleep the page for 3 second
		Thread.sleep(3000);
		// make sure the login is success
		Assert.assertEquals("https://app.qureos.com/home?refresh=1", driver.getCurrentUrl());
		Thread.sleep(3000);
		// close the browser
		driver.quit();
	}
	// main function
	public static void main(String[] args) throws InterruptedException {
		try {
			// call the function
			login(driver, baseUrl, driverPath);

		} catch (Exception e) {
			e.printStackTrace();
	        System.out.println(e.getMessage());
		}
	}

}
