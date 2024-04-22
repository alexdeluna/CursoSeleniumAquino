import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
public class TesteGoogle {
	
private WebDriver driver; 
	
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "C:\\Chrome\\chromedriver.exe");
		driver.manage().window().maximize();
	 }
	@After
	public void finaliza() {
		driver.quit();
		
	}
	
	@Test
	public void teste() {
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		//System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
		
		driver.quit();
		
		
	}

}
