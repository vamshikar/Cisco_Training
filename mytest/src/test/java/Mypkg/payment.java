package Mypkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class payment {
	
	public payment(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/p[1]/a[1]")
	public WebElement btnPayByBankWire;
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")
	public WebElement btnConfirmOrder;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/p[1]/strong[1]")
	public WebElement txtMessage;
	
	
	public void makePayment() {
		btnPayByBankWire.click();
		btnConfirmOrder.click();
	}
	
	public void checkMessage() {
		String actResult = txtMessage.getText();
		Assert.assertEquals(actResult, "Your order on My Store is complete.");
	}
}
