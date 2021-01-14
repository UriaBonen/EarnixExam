package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.RetroTiePage;
import Pages.skinnyTies_mainPage;


public class prat2_A_RetroTie {
	WebDriver driver;

	@BeforeMethod
	public void configurations() {
		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\Selenium\\newVersion\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://skinnyties.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}


	//@Test
	public void navigateToRetroCategory() throws InterruptedException {
		skinnyTies_mainPage sk=new skinnyTies_mainPage(driver);
		sk.clickSubCategory("PATTERN", "Retro");
		RetroTiePage retroTiePage=new RetroTiePage(driver);
		Assert.assertTrue(retroTiePage.isRetroItemPage());
	}


	@Test
	public void filterByTwoDotFiveInch() throws InterruptedException {
		navigateToRetroCategory();
		RetroTiePage retroTiePage=new RetroTiePage(driver);
		retroTiePage.filterByNameButton("2.5 inches");
		retroTiePage.validatfilter("bla");
	}

	///@Test
	public void isResetButtonExsit() throws Exception{
		//navigateToRetroCategory();
		RetroTiePage retroTiePage=new RetroTiePage(driver);
		filterByTwoDotFiveInch();
		boolean reset= retroTiePage.resetButtonExist();
		System.out.println(reset);
		retroTiePage.clickReset();
	}


	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}
}