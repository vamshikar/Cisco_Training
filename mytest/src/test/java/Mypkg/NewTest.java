package Mypkg;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
   WebDriver driver;	
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\vamshi_v\\Downloads\\chromedriver_win32_85\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://www.google.com");
  }
}
