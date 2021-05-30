package www.goibibo.com;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboHomePage {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\atul_rananavare\\ProblemSolvingWorkspace\\SeleniumAutomation\\cromeDriver\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		
		WebElement element=driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']"));
		element.click();
		element.sendKeys("Pune");
		
		try {
			Robot rb= new Robot();
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
				
		
		driver.findElement(By.cssSelector("label[for='student_fare_check']")).click();
		
		driver.close();
	}

}
