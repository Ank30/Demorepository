package demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Scroll {
	
	WebDriver driver;
  @Test
    public void scroll()
	  {
		  driver.get("http://www.google.com/");
		  WebElement box = driver.findElement(By.name("q"));
		  box.sendKeys("Actions");
		  box.submit();
		  //driver.findElement(By.name("btnK")).click();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		  JavascriptExecutor js = (JavascriptExecutor) driver ;
		  js.executeScript("window.scrollBy(0,1000)");
		  
		  
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
  }

}
