package Mypkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class shopping {
	public shopping(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")
	public WebElement btnCheckout1;
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")
	public WebElement btnCheckout2;
	
	@FindBy(id = "cgv")
	public WebElement btnagree;
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]")
	public WebElement btnCheckout3;
	
	public void clickShopping() {
		btnCheckout1.click();
		btnCheckout2.click();
		btnagree.click();
		btnCheckout3.click();
		
	}

}
