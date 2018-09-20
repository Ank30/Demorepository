package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Datadriven {
	WebDriver driver;
  @Test
  public void TestMercury() {
	  Readexcel();
	   }
  public void Readexcel() {
	  File file = new File("C:\\Selenium\\selen\\TestData.xlsx");
	  try {
	  InputStream is= new FileInputStream(file);
	  XSSFWorkbook xssf= new XSSFWorkbook(is);
	  XSSFSheet sheet1=xssf.getSheet("credentials");
	  for(int i=1;i<=sheet1.getLastRowNum();i++) {
			String username=sheet1.getRow(i).getCell(0).getStringCellValue();  
			String password=sheet1.getRow(i).getCell(1).getStringCellValue();  
			String result=login(username, password);
			sheet1.getRow(i).createCell(2).setCellValue(result);
	  }
	  
	  OutputStream os=new FileOutputStream(file);
	  xssf.write(os);
	  os.close();
	  }catch (FileNotFoundException e) {
		// TODO: handle exception
		  e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}}
	  public String login(String username, String password) {
		  driver.findElement(By.name("userName")).sendKeys(username);
		  driver.findElement(By.name("password")).sendKeys(password);
		  driver.findElement(By.name("login")).click();
		  String title=driver.getTitle();
		  if(title.equalsIgnoreCase("Find a Flight: Mercury Tours:")) {
			  
			  driver.findElement(By.linkText("SIGN-OFF")).click();
			  return "Pass";
		  }
		  else
		  return "Fail";
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver = new ChromeDriver();	 
		driver.get("http://newtours.demoaut.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
