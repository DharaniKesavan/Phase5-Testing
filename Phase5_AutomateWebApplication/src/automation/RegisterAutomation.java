package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterAutomation {
	public static void main(String args[]) throws InterruptedException {
		
	    System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver(); 
	    
	    driver.get("file:///E:/Testing/Phase5_AutomateWebApplication/src/Register.html");
	    driver.manage().window().maximize();
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("name")).sendKeys("Dharani K");
	    Thread.sleep(1000);
	    driver.findElement(By.name("mail")).sendKeys("dharani@email.com");
	    Thread.sleep(1000);
	    driver.findElement(By.id("pass1")).sendKeys("dharani123");
	    Thread.sleep(1000);
	    driver.findElement(By.id("pass2")).sendKeys("dharani123");
	    Thread.sleep(1000);
	        
	    Select g = new Select(driver.findElement(By.id("gen")));
	    Thread.sleep(1000);
	    g.selectByValue("female");
	    driver.findElement(By.name("add")).sendKeys("Namakkal, Tamilnadu");
	    Thread.sleep(15000);
	    driver.findElement(By.name("phone")).sendKeys("1123456789");
	    Thread.sleep(15000);
	        
	    String pagetit= driver.getTitle();
		System.out.println("Register Driver title = "+ pagetit);
		String actualtit = "Registration";
		
		if(actualtit.equalsIgnoreCase(pagetit))
		{
			System.out.println("Registration Tested Successfully!");
		}
		else
		{
			System.out.println("Register Test is not Successfull");
		}
		
		 driver.findElement(By.xpath("//button[contains(text(),'Register')]")).click();
		 Thread.sleep(15000);
		 driver.close();        
	}
}
