package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAutomation {
	public static void main(String args[]) throws InterruptedException {
		
	    System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver(); 
	    
	    driver.get("file:///E:/Testing/Phase5_AutomateWebApplication/src/Login.html");
	    driver.manage().window().maximize();
	    Thread.sleep(15000);
	    
	    driver.findElement(By.id("uname")).sendKeys("DharaniKesavan");
	    Thread.sleep(10000);
	    driver.findElement(By.name("pass")).sendKeys("dharani");
	    Thread.sleep(10000);
	    	    
	    String pagetit= driver.getTitle();
		System.out.println("Login Driver title = "+ pagetit);
		String actualtit = "Login";
		
		if(actualtit.equalsIgnoreCase(pagetit))
		{
			System.out.println("Login Tested Successfully!");
		}
		else
		{
			System.out.println("Login Test is not Successfull");
		}
		
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	    Thread.sleep(10000);
	    driver.close(); 
	}
}
