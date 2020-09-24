package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TieBarPage extends RetroTiePage {

	private By tieBarButton = By.xpath("//*[@class='Header__MainNav hidden-pocket hidden-lap']/ul/li[6]");
	private By verifyTieBarPage = By.xpath("//*[@class='PageHeader'");
	
	
	public TieBarPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnTieBarButton() throws InterruptedException{
		wait(10, tieBarButton);
		driver.findElement(tieBarButton).click();
	
	}
	
	
	
	
	
	
}
