package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Pages.RetroTiePage;


public class prat2_A_RetroTie {

	@Test
	public void sumOfRetroTie() throws InterruptedException {
		//Configuratins:
		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\Selenium\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Test case:
		/*Enter to Skinnyties site and maximize the windows
		 *Hover on PATTERN button and click on Retro 
		 *Enter "BLACK POPLIN SKINNY TIE" on the Search Box
		 *Click on the result displayed (the first one)
		 *Run of all product on this page and summarize their price
		 *if the sum bigger than 20 > Test case pass
		 */

		driver.get("https://skinnyties.com/");
		driver.manage().window().maximize();
		RetroTiePage retro_tie_page=new RetroTiePage(driver);
		retro_tie_page.hoverOnPATTERNButton();
		retro_tie_page.clickOnRettroCategory();
		retro_tie_page.summarizePrices();	
		driver.close();
	}
}