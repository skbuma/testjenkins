package ListenersPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersJava.class)
public class ListenersClass {
  
	
	 @Test
	  public void f() throws InterruptedException {
		 
		  WebDriver driver = new ChromeDriver(); 
		  
		  driver.get("https://www.facebook.com");
		  driver.manage().window().maximize();
		  Thread.sleep(3000);
		  
		  
		  System.out.println("ListenerClass ");
		  
		  driver.close();
	  }
	
	
}
