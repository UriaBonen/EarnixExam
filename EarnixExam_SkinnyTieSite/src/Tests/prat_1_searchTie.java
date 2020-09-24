package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Pages.skinnyTies_mainPage;
import Pages.RetroTiePage;
public class prat_1_searchTie {

	@Test
	public void searchBLACK_POPLIN_SKINNY_TIE() throws InterruptedException {
//Configurations
		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\Selenium\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
//Test case: 
		/*Enter to Skinnyties site and maximize the windows
		 *Navigate to Search Button and click it
		 *Enter "BLACK POPLIN SKINNY TIE" on the Search Box
		 *Click on the result displayed (the first one)
		 *Print to the console the price and description tie
         */
		 
		driver.get("https://skinnyties.com/");
		driver.manage().window().maximize();
		skinnyTies_mainPage sT_mP=new skinnyTies_mainPage(driver);
		sT_mP.searchTie("BLACK POPLIN SKINNY TIE");
		sT_mP.clickOnTheResultSearch();
		sT_mP.printTiePrice();
		sT_mP.printDescriptionTie();		
		driver.close();
	}


}
