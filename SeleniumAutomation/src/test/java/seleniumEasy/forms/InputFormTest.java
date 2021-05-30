package seleniumEasy.forms;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InputFormTest {
	public static WebDriver driver=null;
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\atul_rananavare\\ProblemSolvingWorkspace\\SeleniumEasyAutomation\\cromeDriver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.get("https://www.seleniumeasy.com/test/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]")).click();
	}
	
	//@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void TC_001() {
		WebElement formDropDown=driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/a"));
		formDropDown.click();
		
		Robot rb;
		try {
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
		
		String name=driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/a")).getText();
		
		assertEquals(name, "All Examples");
		System.out.println("entered succesfully in: "+name);
		
		
	}
	
	@Test
	public void TC_002() {
		
		driver.findElement(By.xpath("//ul[@id='treemenu']//a[contains(text(),'Input Forms')]")).click();
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[1]/a")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		
		driver.findElement(By.xpath("//input[@id='user-message']")).click();
		driver.findElement(By.xpath("//input[@id='user-message']")).clear();
		driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys("This is entered words");
		
		driver.findElement(By.xpath("//*[@id=\"get-input\"]/button")).click();
		
		String text=driver.findElement(By.xpath("//*[@id=\"display\"]")).getText();
		assertEquals(text, "This is entered words");
		System.out.println("Displayed succesfully in :"+text);
	
		
	}
	
	@Test
	public void TC_003() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		driver.findElement(By.xpath("//input[@id='sum1']")).click();
		driver.findElement(By.xpath("//input[@id='sum1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='sum1']")).sendKeys("4");
		driver.findElement(By.xpath("//input[@id='sum2']")).sendKeys("4");
		
		driver.findElement(By.xpath("//form[@id='gettotal']//button[@type='button']")).click();
		
		String value=driver.findElement(By.xpath("//span[@id='displayvalue']")).getText();
		
		assertEquals(value, "8");
		System.out.println("Displayed succesfully addition :"+value);
		
		js.executeScript("window.scrollBy(4500,0)", "");
	}
	
	
	@Test
	public void TC_004() {
		
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[2]/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[2]/ul/li[1]/a")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)", "");
		
		driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-th']")).click();
		
		/*new WebDriverWait(driver, Duration.ofSeconds(5))
		.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("datepicker-days")));*/
		
		String monthYearValue=driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/thead/tr[2]/th[2]")).getText();
		
		System.out.println(monthYearValue); //March 2021
		
		
		
		
	}
	
	
}
