package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class skinnyTies_mainPage {

	WebDriver driver;
	private	By searchButton = By.xpath("//*[@class='Heading Link Link--primary Text--subdued u-h8']");
	private By searchBoxFeild = By.name("q");
	private By ResultSearch = By.xpath("//*[@class='Segment']/div[2]/div/div");

	public  skinnyTies_mainPage(WebDriver driver) {
		this.driver=driver;
	}

	public void wait(int timeToWaitInSeconds, By expectElement) {
		WebDriverWait wait = new WebDriverWait(driver,timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(expectElement));
	}

	public void clickOnSearchButton() throws InterruptedException {
		wait(20,searchButton);
		driver.findElement(searchButton).click();
	}

	public void searchTie(String s) throws InterruptedException {
		wait(20,searchButton);
		driver.findElement(searchButton).click();
		driver.findElement(searchBoxFeild).sendKeys(s);
	}

	public void printTiePrice() throws InterruptedException {
		String tiePrice=driver.findElement(By.xpath("//*[@class='ProductMeta']/div")).getText();
		System.out.println("The price of tie is: "+tiePrice);
	}

	public void printDescriptionTie() {
		String tiePrice=driver.findElement(By.xpath("//*[@class='ProductMeta']/div/div")).getText();
		System.out.println("The desciption of tie is: "+tiePrice);
	}

	public void clickOnTheResultSearch(){
		wait(20,ResultSearch);
		driver.findElement(ResultSearch).click();
		By Product__InfoWrapper=By.xpath("//*[@class='Product__InfoWrapper']");
		wait(20,Product__InfoWrapper);
		boolean Product__InfoWrapperIsExsist=driver.findElements(By.xpath("//*[@class='Product__InfoWrapper']")).size()==0;
		Assert.assertFalse(Product__InfoWrapperIsExsist);
	}


}
