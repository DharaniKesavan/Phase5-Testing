package com.app;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminLoginTest {
	public WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");  
		driver = new ChromeDriver();	  
	}
	
	  @Test
	  public void f() throws IOException, InterruptedException {  
	    driver.manage().window().maximize();
		driver.get("http://localhost:4200/adminsignin");	
		driver.findElement(By.id("uName")).sendKeys("Admin");	
		driver.findElement(By.id("pass")).sendKeys("Admin@123");
		driver.findElement(By.xpath("/html/body/app-root/app-adminlogin/div/div/div[1]/form/div[3]/button")).click();	
	}

  	 @AfterTest
  	  public void afterTest() {
  		driver.close();
		System.out.println("Admin Login Test completed Successfully!!!");
  	  }
}

