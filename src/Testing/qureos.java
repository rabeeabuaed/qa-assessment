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
		driver.get(baseUrl);
		driver.findElement(
				By.xpath("//*[@id=\"__next\"]/main/section/div/section/section/div/div/form/section[1]/input"))
				.sendKeys("rabeeabuaed@gmail.com");
		driver.findElement(By.cssSelector(
				"#__next > main > section > div > section > section > div > div > form > section:nth-child(2) > input"))
				.sendKeys("Rabee_1992n");
		driver.findElement(
				By.xpath("//*[@id=\"__next\"]/main/section/div/section/section/div/div/form/div/section/button"))
				.click();
		Thread.sleep(3000);
		Assert.assertEquals("https://app.qureos.com/home?refresh=1", driver.getCurrentUrl());
		Thread.sleep(3000);

		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		try {
			login(driver, baseUrl, driverPath);

		} catch (Exception e) {
			e.printStackTrace();
	        System.out.println(e.getMessage());
		}
	}

}
