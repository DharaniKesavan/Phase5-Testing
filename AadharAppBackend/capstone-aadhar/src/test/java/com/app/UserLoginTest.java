package com.app;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserLoginTest {
	
	public WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");  
		driver = new ChromeDriver();	  
	}
	
	@Test
	public void f() throws IOException, InterruptedException {
  
		driver.manage().window().maximize();
		driver.get("http://localhost:4200/");	
		driver.findElement(By.cssSelector("#email")).sendKeys("Ayla@email.com");	
		driver.findElement(By.id("password")).sendKeys("6663339991");
		driver.findElement(By.xpath("/html/body/app-root/app-userlogin/div/div/div[1]/form/div[3]/button")).click();
	}
 
  	 @AfterTest
  	  public void afterTest() {
  		driver.close();
		System.out.println("User Login Test completed Successfully!!!");
  	  }
}
