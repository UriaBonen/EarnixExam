package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.RetroTiePage;
import Pages.TieBarPage;

public class part2_B_TieBar {
	WebDriver driver;

	@BeforeMethod
	public void configurations() {
		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\Selenium\\newVersion\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://skinnyties.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void sumOfTieBar() throws InterruptedException {
		
		//Test case:
		/*Enter to Skinnyties site and maximize the windows
		 *Click on Tie Bar button and 
		 *Run of all product on this page and summarize their price
		 *if the sum bigger than 20 > Test case will pass
		 */
	
		TieBarPage tie_Bar_Page=new TieBarPage(driver);
		tie_Bar_Page.clickOnTieBarButton();
		tie_Bar_Page.summarizePrices();
		driver.close();
	}
}
