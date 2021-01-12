package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.skinnyTies_mainPage;
import Pages.RetroTiePage;
import Pages.TiePage;
public class SearchTieBox {
	WebDriver driver;

	@BeforeMethod
	public void configurations() {
		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\Selenium\\newVersion\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://skinnyties.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void viewAll () throws InterruptedException {		
		String tieName="BLACK";
		skinnyTies_mainPage sT_mP=new skinnyTies_mainPage(driver);
		sT_mP.clickOnSearchButton()
		.setTieName(tieName)
		.clickViewAll();
		Assert.assertEquals(driver.getTitle().contains("BLACK* – SkinnyTiesShop"), true);
	}

	@Test
	public void clickOnFirstResult() throws Exception {
		skinnyTies_mainPage sT_mP=new skinnyTies_mainPage(driver);
		sT_mP.searchTie("black");
		sT_mP.clickOnFirstResult();
		TiePage tiePage=new TiePage(driver);
		Assert.assertEquals(true, tiePage.getProductTitel().contains("BLA"));
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
