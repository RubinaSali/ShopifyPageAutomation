package com.cognizant.miniproject.StoreNameMandatoryCheck;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AppTest {
	WebDriver driver=null;
	
	@Parameters("browser")
	@BeforeMethod
	//selecting driver
	public void OpenBrowser(String browser) {
//		if(browser.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver","D:\\eclipse\\StoreNameMandatoryCheck\\driver\\chromedriver.exe");
//			driver=new ChromeDriver();
//		}
	if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver","D:\\eclipse\\StoreNameMandatoryCheck\\driver\\msedgedriver.exe");
			driver=new EdgeDriver();

		}
		else if(browser.equalsIgnoreCase("mozilla")){
			System.setProperty("webdriver.gecko.driver","D:\\eclipse\\driver\\geckodriver.exe");
			driver=new FirefoxDriver();

		}
		
		driver.manage().window().maximize();
	}
	   @Test
       public void Test(){
    	
   		driver.get("https://www.shopify.com/in"); 
   		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
   		driver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div/div/nav/ul/li[1]/div[1]/button/span")).click();
   		System.out.println("clicked solutions");
   		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
   		driver.findElement(By.xpath("//*[@id=\"SolutionsDesktopMenu\"]/div/div[1]/ul/li[6]/a/div[1]/span")).click();
   		System.out.println("clicked explore free business tools");
   		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
  		System.out.println("Free Business Tools : ");
  		

   		driver.findElement(By.xpath("//*[@id=\"Main\"]/section[2]/div[2]/ul/li[2]/div/a/h3")).getText();
   		List<WebElement> toolNames = driver.findElements(By.xpath("//h3[(@class=\"block__heading heading--4 heading-text\")]"));
       for (WebElement toolName : toolNames) {
            System.out.println(toolName.getText());
        }
       try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
       
       //Locating, clicking start free trial and creating account
       WebElement freeTrial=driver.findElement(By.linkText("Start free trial"));
   		freeTrial.click();
   		System.out.println("Free trial is clicked");
   		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
   		driver.findElement(By.xpath("//*[@id=\"navigation-skip-button\"]/span/span")).click();
   		System.out.println("skipped 'Lets get started. Which of these best describes you?'");
   		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
   		driver.findElement(By.xpath("//*[@id=\"navigation-skip-button\"]/span/span")).click();
   		System.out.println("skipped 'Where would you like to sell?'");
   		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
   		driver.findElement(By.xpath("//*[@id=\"navigation-skip-button\"]/span/span")).click();
   		System.out.println("skipped 'What do you plan to sell first?'");
   		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
   		
   		
   		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/main/div/div[2]/div[3]/div/div/div/form/nav/div/div[2]/span/button/span/span")).click();
   		System.out.println("skipped 'What would you like to name your store?'");

   		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		//Store name is optional hence no error message is printed.
   		
   		
   		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/main/div/div[2]/div[4]/div/div/div/nav/div/div[2]/button")).click();
   		System.out.println("clicked next for 'Where will your business be located?'");

   		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
   		driver.findElement(By.xpath("//*[@id=\"body-content\"]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/a[1]/div/span")).click();
   		System.out.println("clicked Continue with email");
   		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		
   		//Filling  mandatory fields
   		driver.findElement(By.id("account_email")).sendKeys("rubinasali@gmail.com");
   		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
   		//Create shopify button is not clickable without entering any mandatory field.
   		//Error message for not entering mandatory field cannot be printed as the 'Create Shopify' button is not clickable
   		

   		driver.quit();

   		
   		}
}
