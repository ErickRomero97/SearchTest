package ErickQualityTest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearchTest {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		//System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		//driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver/geckodriver.exe");
		//driver = new FirefoxDriver();
		
		System.setProperty("webdriver.edge.driver", "./src/test/resources/msedgedriver/msedgedriver.exe");
		driver = new EdgeDriver();
	
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGooglePage() {
		WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		
		searchBox.clear();
		searchBox.sendKeys("Lindsey Stirling Shadows");
		searchBox.submit();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		assertEquals("Lindsey Stirling Shadows - Buscar con Google", driver.getTitle());
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
