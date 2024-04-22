import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AcessandoCitSmart {
	WebDriver driver;
	
	@Before
	public void abrirCitSmart() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.0.15/citsmart/login/login.load");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		//driver.switchTo().frame(0)
		driver.findElement(By.xpath("//*[@id=\"modal-empresa\"]/div[1]/button")).click();
        
    }
	
	@Test
	public void inserindoNome() throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(By.className("input-block-level")).sendKeys("Alexsandro");
		//driver.findElement(By.xpath("//*[@id=\"user\"]")).sendKeys("alexsandroluna");
		////*[@id="user"]		
	}
	
	
}
