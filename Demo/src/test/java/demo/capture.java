package demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class capture {
	
	 public static void captureScreenShot (WebDriver driver) 
 	  {
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);  
  try {
	  
	  FileUtils.copyFile(src, new File ("C:\\\\Selenium\\Screen\\abc.png"));
  }
  catch(IOException e)
  {
	  e.printStackTrace();
  }
 	  
 	  }

}
