import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class AcessandoSiteTeste {
	private WebDriver driver;
	private DSL dsl;
	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		dsl = new DSL(driver);
	}
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void inNome() {
		dsl.escrever("//input[@placeholder='First Name']", "Alexsandro");
		Assert.assertEquals("Alexsandro", dsl.obterValorCampo("//input[@placeholder='First Name']"));
	}
	@Test
	public void inSobreNome() {
		dsl.escrever("//input[@placeholder='Last Name']", "Xavier");
		Assert.assertEquals("Xavier", dsl.obterValorCampo ("//input[@placeholder='Last Name']"));
	}
	@Test
	public void inEndereco() {
		dsl.escrever("//textarea[@ng-model='Adress']", "Rua 10");
		Assert.assertEquals("Rua 10", dsl.obterValorCampo("//textarea[@ng-model='Adress']"));
	}
	@Test
	public void inEmail() {
		dsl.escrever("//input[@ng-model='EmailAdress']", "alexdeluna2804@gmail.com");
		Assert.assertEquals("alexdeluna2804@gmail.com", dsl.obterValorCampo("//input[@ng-model='EmailAdress']"));
	}
	@Test
	public void inPhone() {
		dsl.escrever("//input[@ng-model='Phone']", "81988552233");
		Assert.assertEquals("81988552233", dsl.obterValorCampo("//input[@ng-model='Phone']"));
	}
	@Test
	public void inRadioButton() {
		dsl.clicarRadioButton("//input[@ng-model='radiovalue'='male']");
		Assert.assertTrue(dsl.isRadioButton("//input[@ng-model='radiovalue'='male']"));
	}
	@Test
	public void inCheckBox () {
		dsl.clicarCheckBox("checkbox2");
	}
	@Test
	public void  inComboBox() {
		dsl.comboBox("Skills");
		
	}
		
	}