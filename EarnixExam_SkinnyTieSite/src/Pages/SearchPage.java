package Pages;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	WebDriver driver;

	private By ProductItem = By.xpath("//*[@class='ProductItem ']");
	public SearchPage(WebDriver driver) {
		this.driver=driver;
	}

	public SearchPage clickProductItem() {
		driver.findElement(ProductItem).click();
		return new SearchPage(driver);
	}


	public SearchPage addItems() {
		ArrayList<WebElement> items;
		items=(ArrayList<WebElement>) driver.findElements(By.className("bla"));
		System.out.println(items.size());
		return new SearchPage(driver);
	}




}
