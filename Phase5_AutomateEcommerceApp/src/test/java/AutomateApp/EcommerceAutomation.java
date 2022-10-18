package AutomateApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class EcommerceAutomation {
	
	public WebDriver driver;
	
	@BeforeTest
	public void LaunchChrome() {	
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");	
		driver = new ChromeDriver();	  
	}

	
	@Test
	public void f() throws InterruptedException, IOException {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		//To find the load time
		Long loadtime = (Long) ((JavascriptExecutor) driver).executeScript("return performance.timing.loadEventEnd - performance.timing.navigationStart;");
		System.out.println("Load time of the webpage = " + loadtime+"ms\n");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
	    File scr = ts.getScreenshotAs(OutputType.FILE);
	    File Dest = new File("G:\\Phase5_Ecommerce\\flipkart.png");
	    FileUtils.copyFile(scr, Dest);		
		Thread.sleep(3000);
		
		
		//To search the given text in search bar
		driver.findElement(By.className("_3704LK")).sendKeys("iPhone 13");	
		TakesScreenshot ts1 = (TakesScreenshot)driver;
	    File scr1 = ts1.getScreenshotAs(OutputType.FILE);
	    File Dest1 = new File("G:\\Phase5_Ecommerce\\search.png");
	    FileUtils.copyFile(scr1, Dest1);
	    Thread.sleep(3000);

		driver.findElement(By.className("L0Z3Pu")).click();
		TakesScreenshot ts2 = (TakesScreenshot)driver;
	    File scr2 = ts2.getScreenshotAs(OutputType.FILE);
	    File Dest2 = new File("G:\\Phase5_Ecommerce\\search-button.png");
	    FileUtils.copyFile(scr2, Dest2);
	    Thread.sleep(3000);

	    
	    //Check if the image loaded or not
		WebElement i = driver.findElement(By.xpath("//img[@class='_396cs4 _3exPp9']"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement j = driver.findElement(By.xpath("//img[@class='_396cs4 _3exPp9']"));
		Boolean p = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete "
				+ "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", j);
		if (p) {
			System.out.println("Image Loaded Successfully!\n");
			TakesScreenshot ts3 = (TakesScreenshot)driver;
		    File scr3 = ts3.getScreenshotAs(OutputType.FILE);
		    File Dest3 = new File("G:\\Phase5_Ecommerce\\result.png");
		    FileUtils.copyFile(scr3, Dest3);
		    Thread.sleep(3000);
		} 
		else {
			System.out.println("Image Not Loaded\n");
		}
		
		
		//Image visible till the screen height only
		java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		System.out.println("Resoultion of the page : Screen Width = "+ width+", Screen Height = "+height);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		int w=driver.findElement(By.cssSelector("img[class='_396cs4 _3exPp9']")).getSize().getWidth();
		int h=driver.findElement(By.cssSelector("img[class='_396cs4 _3exPp9']")).getSize().getHeight();
		System.out.println("Resoultion of the image : Image Width = "+ w +", Image Height = "+ h);
		WebElement img = driver.findElement(By.cssSelector("img[class='_396cs4 _3exPp9']"));     
		if(img.isDisplayed()){
			if (h<height){
          		System.out.println("Image is visible till the screen height itself!\n"); 
      		}
			else {
				System.out.println("Image is not visible till the screen height\n");
			}
		}
		
		
		//Check if the page has scroll feature		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
		Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
		if (test == true) {
			System.out.println("Scrollbar is present!\n");
		} 
		else {
			System.out.println("Scrollbar is not present\n");
		}	
		Thread.sleep(3000);
		
		
		//Verify that the image is downloaded just before user scroll down
		WebElement image = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[8]/div/div/div/a/div[2]/div[1]/div[1]"));     
		if (image.isDisplayed()){
			System.out.println("Before scrolling the image is not present..."); 	          
		}
		
      	System.out.println("--------Scrolling-------");
    	Thread.sleep(3000);
    	JavascriptExecutor scroll = (JavascriptExecutor) driver;
    	scroll.executeScript("window.scrollBy(0,1800)");
    	Thread.sleep(3000);
    	
        WebElement img1 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[8]/div/div/div/a/div[2]/div[1]/div[1]")); 
        if(img1.isDisplayed()) {
        	System.out.println("After scrolling the image is present!\n"); 
        }  
	       
        TakesScreenshot ts4 = (TakesScreenshot)driver;
	    File scr4 = ts4.getScreenshotAs(OutputType.FILE);
	    File Dest4 = new File("G:\\Phase5_Ecommerce\\scroll.png");
	    FileUtils.copyFile(scr4, Dest4);
	    
	    
	    //Verify that it navigates to the bottom of the page
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			System.out.println("Navigates to the bottom of the page!\n");
			
			TakesScreenshot ts5 = (TakesScreenshot)driver;
		    File scr5 = ts5.getScreenshotAs(OutputType.FILE);
		    File Dest5 = new File("G:\\Phase5_Ecommerce\\bottom.png");
		    FileUtils.copyFile(scr5, Dest5);
		} 
		catch (Exception e) {
			System.out.println("Can't navigate to the bottom of the page\n");
		}
		Thread.sleep(3000);
		
		//Check whether different browsers and screen resolutions render it the same way
		driver.get("https://www.flipkart.com");
		Thread.sleep(10000);
		System.out.println("***********chrome************");
		Dimension d1 = driver.manage().window().getSize();
		System.out.println( "Initial Height = "+d1.getHeight() +"\nInitial Width = "+d1.getWidth());
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
		driver.manage().window().setSize(new Dimension(700, 615));
		d1 = driver.manage().window().getSize();
		System.out.println("After changing resolution...");
		System.out.println( "Final Height = "+d1.getHeight() +"\nFinal Width = "+d1.getWidth());
		Thread.sleep(15000);
	  
		
		System.setProperty("webdriver.edge.driver", "E:\\edgedriver_win64\\msedgedriver.exe");
		WebDriver edge= new EdgeDriver();
		edge.get("https://www.flipkart.com");
		System.out.println("***********edge************");
		Dimension d2 = edge.manage().window().getSize();
		System.out.println( "Initial Height = "+d2.getHeight() +"\nInitial Width = "+d2.getWidth());
		
		edge.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		edge.manage().window().setSize(new Dimension(700, 615));
		d2 = edge.manage().window().getSize();
		System.out.println("After changing resolution...");
		System.out.println( "Final Height = "+d2.getHeight() +"\nFinal Width = "+d2.getWidth());
		Thread.sleep(15000);
		edge.close();
	}
	
	
	@AfterTest
	public void afterTest() {
		driver.close();
		System.out.println("\nAutomate an Ecommerce App test is completed Successfully!!!");
	}

}
