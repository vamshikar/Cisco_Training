package Mypkg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myaccountsPage {
	public myaccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "search_query_top")
	public WebElement txtSearch;
	
	@FindBy(name = "submit_search")
	public WebElement btnSearch;
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[3]/div[1]/div[2]/a[1]/span[1]")
	public WebElement btnaddCart;
	
	@FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")
					 
	public WebElement btncheckout;
	
	public void search()
	{
		txtSearch.sendKeys("Printed Chiffon Dress");
		btnSearch.click();
		
	}
	
	public void shopping(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
		Actions actions =new Actions(driver);
		WebElement menuOption = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[3]/ul[1]"));
    	Thread.sleep(5000);
		actions.moveToElement(menuOption).perform();
	//	JavascriptExecutor executor = (JavascriptExecutor)driver;
	//	executor.executeScript("arguments[0].click();", btnaddCart);
		driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]/i[1]")).click();
		btnaddCart.click();
		Thread.sleep(5000);
		btncheckout.click();
	}
}
