package Mypkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signinpage {
		
	public signinpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	public WebElement txtuname;
	
	@FindBy(id = "passwd")
	public WebElement txtpwd;
	
	@FindBy(id = "SubmitLogin")
	public WebElement btnLogin;
	
	public void ClickLogin(String userName,String pword) throws InterruptedException
	{
		txtuname.sendKeys(userName);
		txtpwd.sendKeys(pword);
		Thread.sleep(2000);
		btnLogin.click();
	}

}
