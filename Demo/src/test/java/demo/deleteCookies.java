package demo;

import org.openqa.selenium.WebDriver;

public class deleteCookies {
	
	 public static void deleteAllCookiesdemo(WebDriver driver)
		{
		        driver.get("http://www.google.com/");
				driver.manage().deleteAllCookies();
				
		} 


}
