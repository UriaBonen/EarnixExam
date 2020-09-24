package Pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RetroTiePage {

    WebDriver driver;	
	private	By PATTERNButtonElement = By.xpath("//*[@class='Header__MainNav hidden-pocket hidden-lap']/ul/li[5]");
	private By retroCategory=By.xpath("//*[@class='Header__MainNav hidden-pocket hidden-lap']/ul/li[5]/div/ul/li[3]");
	private By verifyRettroPage=By.xpath("//*[@class='ProductItem__Price Price Text--subdued']");

	public RetroTiePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void wait(int timeToWaitInSeconds, By expectElement) {
		WebDriverWait wait = new WebDriverWait(driver,timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(expectElement));
	}


	public void hoverOnPATTERNButton() {
		wait(20,PATTERNButtonElement);
		WebElement PATTERNButton=driver.findElement(By.xpath("//*[@class='Header__MainNav hidden-pocket hidden-lap']/ul/li[5]"));
		String PATTERNButtonName=PATTERNButton.getText();
		Actions action=new Actions(driver);	
		Assert.assertEquals(PATTERNButtonName, "PATTERN");
		action.moveToElement(PATTERNButton).build().perform();
	}

	public void clickOnRettroCategory() {
		wait(5,retroCategory);
		driver.findElement(retroCategory).click();
	}

	public void summarizePrices() throws InterruptedException {
		wait(20,verifyRettroPage);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(4000);
		ArrayList<WebElement> tieList=new ArrayList<WebElement>();
		tieList.addAll(driver.findElements(By.xpath("//*[@class='ProductItem__Price Price Text--subdued']")));
		int sumOfPrice=0;
		for (int i = 0; i < tieList.size(); i++) {
			StringBuilder sb = new StringBuilder(tieList.get(i).getText());
			sb.deleteCharAt(0);
			String s=sb.toString();
			int intPrice=Integer.parseInt(s);  
			sumOfPrice+=intPrice;
		}
		Assert.assertTrue(sumOfPrice>20);
	}


}