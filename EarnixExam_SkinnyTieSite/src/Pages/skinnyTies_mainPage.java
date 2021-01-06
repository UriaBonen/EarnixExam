package Pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class skinnyTies_mainPage {

	WebDriver driver;
	private	By searchButton = By.xpath("//*[@class='Heading Link Link--primary Text--subdued u-h8']");
	private By searchBoxFeild = By.name("q");
	private By ResultSearch = By.xpath("//*[@class='Segment']/div[2]/div/div");
	private By viewAll = By.xpath("//*[@class='Heading Link Link--secondary u-h7']");


	public  skinnyTies_mainPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void wait(int timeToWaitInSeconds, By expectElement) {
		WebDriverWait wait = new WebDriverWait(driver,timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(expectElement));
	}

	public skinnyTies_mainPage clickSearch() {
		driver.findElement(searchButton).click();
		return new skinnyTies_mainPage(driver);
	}

	public skinnyTies_mainPage setTieName(String tieName) throws InterruptedException {
		wait(20,searchBoxFeild);
		driver.findElement(searchBoxFeild).sendKeys(tieName);
		return new skinnyTies_mainPage(driver);
	}

	public SearchPage clickViewAll() throws InterruptedException {
		driver.findElement(viewAll).click();
		Thread.sleep(6000);
		return new SearchPage(driver);
	}

	public skinnyTies_mainPage clickOnSearchButton() throws InterruptedException {
		wait(20,searchButton);
		driver.findElement(searchButton).click();
		return new skinnyTies_mainPage(driver);
	}

	public void searchTie(String s) throws InterruptedException {
		wait(20,searchButton);
		driver.findElement(searchButton).click();
		driver.findElement(searchBoxFeild).sendKeys(s);

	}

	public TiePage clickOnFirstResult() throws Exception {
		WebElement results = driver.findElement(By.xpath("//*[@class='Segment__Content']"));
		ArrayList<WebElement> items;
		items=(ArrayList<WebElement>) results.findElements(By.className("ProductItem"));
		Thread.sleep(5000);
		if (items.size()>0) items.get(0).click();
		else throw new Exception("There are no results for this search");
		return new TiePage(driver);
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

	public skinnyTies_mainPage clickMainCategory(String mainCategory) throws InterruptedException {
		WebElement Categoreis =driver.findElement(By.className("Header__Wrapper"));
		ArrayList<WebElement> categories=(ArrayList<WebElement>) Categoreis.findElements(By.className("HorizontalList__Item"));
		int i=0;
		while(i<=categories.size()) {
			if(categories.get(i).getText().equals(mainCategory)){
				Actions action=new Actions(driver);	
				action.moveToElement(categories.get(i)).build().perform();
				boolean isSubCategoriesIsVisable=categories.get(i).findElement(By.className("DropdownMenu")).isDisplayed();
				Assert.assertEquals(isSubCategoriesIsVisable, true);
				categories.get(i).click();
				break;
			}
			i++;
		}
		return new skinnyTies_mainPage(driver);
	}

	public skinnyTies_mainPage clickSubCategory (String mainCategory,String subCategory) {
		WebElement Categoreis =driver.findElement(By.className("Header__Wrapper"));
		ArrayList<WebElement> categories=(ArrayList<WebElement>) Categoreis.findElements(By.className("HorizontalList__Item"));
		int i=0;int j=0;
		while(i<=categories.size()-1) {
			if(categories.get(i).getText().equals(mainCategory)){
				Actions action=new Actions(driver);	
				action.moveToElement(categories.get(i)).build().perform();;
				break;
			}
			i++;
		}
		WebElement chosenCategory=categories.get(i).findElement(By.className("Linklist"));
		ArrayList<WebElement> subCategories=(ArrayList<WebElement>) chosenCategory.findElements(By.className("Linklist__Item"));
		while(j<=subCategories.size()-1) {
			if(subCategories.get(j).getText().equals(subCategory)) {
				subCategories.get(j).click();
			}
			j++;
		}
		return new skinnyTies_mainPage(driver);
	}

	public boolean isSpesificItemPage() {
		WebElement pageHeader=driver.findElement(By.id("main"));
		boolean isSpesificItemPage=driver.findElement(By.xpath("//*[@class='PageHeader']/div/h1")).getText().equals("ALL COLLECTIONS");
		return isSpesificItemPage;
	}
}
