package seleniumEasy.forms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class InitialSetupSteps {
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
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
