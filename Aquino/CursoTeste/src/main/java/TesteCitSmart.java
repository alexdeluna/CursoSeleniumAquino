import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

public class TesteCitSmart {
	
	
	
	@Test
	public void teste() {
		System.setProperty("webdriver.gecko.driver", "C:\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("http://200.133.17.15/citsmart/login/login.load");
		driver.get("http://192.168.0.15/citsmart/login/login.load");
		driver.manage().window().maximize();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Clique aqui para solicitar uma chave.", alert.getText());
		driver.close();
		
		
		//Actions actions = new Actions(driver);
		//actions.sendKeys("modal-scrollable", Keys.ESCAPE).build().perform();
		
		
		
		/*Alert alert = driver.switchTo().alert();
		alert.dismiss();
		driver.findElement(By.id("modal-scrollable"));
		
		driver.findElement(By.id("user")).click();
		driver.findElement(By.id("user")).click();
		driver.findElement(By.id("user")).click();
		driver.findElement(By.id("user")).click();
		
		
		try {
            Thread.sleep(5000); // Pausa por 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		driver.findElement(By.id("user")).click();*/
		
		//driver.quit();
		//driver.findElement(By.className("close")).click();
		//driver.findElement(By.className("close")).click(); user
		
		
		
		//Actions actions = new Actions(driver);
		//actions.sendKeys(Keys.ESCAPE).build().perform();
		
		//WebElement botao = driver.findElement(By.className("close"));
		//botao.click();
		
		
		
		//System.out.println(driver.getTitle());
		//Assert.assertEquals("Google", driver.getTitle());
		//driver.quit();
		
		
	}
	
	

}
