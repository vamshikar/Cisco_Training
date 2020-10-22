package Mypkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NewTest {
   WebDriver driver;	
   @BeforeClass
   public void initialze() {
	   System.setProperty("webdriver.chrome.driver", "C:\\Users\\vamshi_v\\Downloads\\chromedriver_win32_85\\chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.get("http://automationpractice.com/index.php");  
   }
  @Test(priority=1,enabled=true)
  public void f() throws InterruptedException, IOException {
	  //try {
	  SoftAssert softAssert = new SoftAssert();
	  PageObjects page = new PageObjects(driver);
	  signinpage spage = new signinpage(driver);
	  myaccountsPage mpage = new myaccountsPage(driver);
	  shopping shop = new shopping(driver);
	  payment pay = new payment(driver);
	  
	  page.login();
	  int i;
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  
	  String strexpected1 = driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText();
	  System.out.println(strexpected1);
	  Assert.assertEquals("AUTHENTICATION", strexpected1);
	  
	  FileInputStream fs = new FileInputStream("D:\\Sample.xlsx");
	//Creating a workbook
	  XSSFWorkbook workbook = new XSSFWorkbook(fs);
	  XSSFSheet sheet = workbook.getSheetAt(0);
	  int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	  System.out.println(rowcount);
	  for(i =1;i<=rowcount;i++) {
	
	  String un = sheet.getRow(i).getCell(0).getStringCellValue();
	  String pwd = sheet.getRow(i).getCell(1).getStringCellValue();
	  spage.ClickLogin(un,pwd);
	  Thread.sleep(2000);
	  String strexpected = driver.findElement(By.xpath("//div[@id='center_column']/p")).getText(); 
	  System.out.println(strexpected);
	  Assert.assertEquals("Welcome to your account. Here you can manage all of your personal information and orders.", strexpected);
	  mpage.search();
	  mpage.shopping(driver);	  
	  shop.clickShopping();
	  pay.makePayment();
	  pay.checkMessage();
	  
	  
	  softAssert.assertAll();
	 // driver.findElement(By.partialLinkText("out")).click();
	  }
	  /*}
	  catch(Exception ex ) {
		  ex.printStackTrace();
	  }
	  finally {
		  if(driver!=null)
			  System.out.println("End");
			 // driver.quit();
	  }*/
	  //driver.findElement(By.partialLinkText("out")).click();
  }
  
  @AfterClass
  public void teardown() {
	  //driver.quit();
  }
}
