package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TiePage {

	private WebDriver driver;
 	private By productTitel = By.xpath("//*[@class='ProductMeta__Title Heading u-h2']");

	public TiePage(WebDriver driver) {
		this.driver = driver;
	}
public String getProductTitel() {
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(productTitel));
	System.out.println(driver.findElement(productTitel).getText());
	return driver.findElement(productTitel).getText();
}
}