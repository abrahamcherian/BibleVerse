import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DailyVerse_Chrome{

	@Test
	public static void main(String args[]) throws InterruptedException {
	  // Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aby\\Downloads\\selenium-2.41.0\\ChromeDriver\\chromedriver.exe");
	  //Adding capabilities for chrome browser extensions
//	  ChromeOptions options = new ChromeOptions();
//	  options.addExtensions(new File("/path/to/extension.crx"));
//	  DesiredCapabilities capabilities = new DesiredCapabilities();
//	  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	  
//	 // creating a new chrome webdriver configured with extensions.
//	  WebDriver _driver = new ChromeDriver(capabilities);
	  
	  //creating a new chrome webdriver configured without extensions.
	  WebDriver _driver = new ChromeDriver();
	  
	 if(isInternetReachable()){
		 
			//Opening biblegateway.com website
					_driver.get("http://www.biblegateway.com/");
					Thread.sleep(2000);
					_driver.manage().window().maximize();
					//Fetching the Verse of the day
					String VerseoftheDay = _driver.findElement(By.xpath("//*[@class='votd-box']/p")).getText() + "\n" + _driver.findElement(By.xpath("//*[@class='bcv']")).getText() ;
					System.out.println(VerseoftheDay);
					
					//Printing Website information
		//			System.out.println("URL : "+ _driver.getCurrentUrl());
		//			System.out.println("Title of the page is : "+ _driver.getTitle());
					
					//Opening Facebook.com
					_driver.get("http://www.facebook.com/");
					Thread.sleep(2000);
					
					//Entering username and password
					_driver.findElement(By.name("email")).click();
					_driver.findElement(By.name("email")).sendKeys(<username>);
					_driver.findElement(By.name("pass")).click();
					_driver.findElement(By.name("pass")).sendKeys(<password>);
					
					//clicking on login button
					_driver.findElement(By.id("loginbutton")).click();
					System.out.println("Clicked on the Login button.");
					Thread.sleep(7000);
					
					
					//cLicking on my name on facebook page
		//			_driver.findElement(By.cssSelector(".navLink.bigPadding")).click();
		//			_driver.findElement(By.linkText("Abraham"));
		//			System.out.println("clicked on my name Abraham on the header..");
		//			Thread.sleep(3000);
					
					//cLicking on the text box to enter data
					_driver.findElement(By.name("xhpc_message")).click();
					System.out.println("Clicked on the box.. What's on your mind?");
					Thread.sleep(3000);
					
					//cLicking on the text box to enter data
					_driver.findElement(By.name("xhpc_message_text")).sendKeys(VerseoftheDay);
					System.out.println("Entered the verse of the day");
					Thread.sleep(3000);
		//					
					//click on Post button
		//			_driver.findElement(By.xpath("//*[@id='u_0_1a']/div/div[4]/div/ul/li[2]/button")).click();
					_driver.findElement(By.xpath("//button[text()='Post']")).click();
					
					System.out.println("Clicked on Post button");
					Thread.sleep(3000);
					
					//clicking on the wheel icon to display logout menu
					_driver.findElement(By.xpath("//*[@id='userNavigationLabel']")).click();
					Thread.sleep(2000);
					
					//clicking on logout menu item
					//_driver.findElement(By.xpath("//*[@value='Log Out']")).click();
					_driver.get("https://www.facebook.com/logout.php");
					Thread.sleep(2000);
					
					System.out.println("Clicked on Logout button");
					Thread.sleep(2000);
	 	}// if internet is reachable, if not the inner code is not executed.
	 	else
	 	{	
	 		System.out.println("\n I'm sorry the Internet is not connected.");
	 	}	//closing internet connectivity check.
	 
					//closing the browser
					_driver.close();
					
					//Quittingi the web Driver
					_driver.quit();	
					
		
	}
	
	//checks for connection to the internet through dummy request
    public static boolean isInternetReachable() throws InterruptedException
    {
        try {
            //make a URL to a known source
            URL url = new URL("http://www.google.com");

            //open a connection to that source
            HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

            //trying to retrieve data from the source. If there
            //is no connection, this line will fail
            Object objData = urlConnect.getContent();
        	//objData.wait(100);
            Thread.sleep(2000);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	
	
} 