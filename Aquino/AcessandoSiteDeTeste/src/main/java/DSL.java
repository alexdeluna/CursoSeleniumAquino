import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public void escrever(String xpath_campo, String nome) {
		driver.findElement(By.xpath(xpath_campo)).sendKeys(nome);
	}
	
	public String obterValorCampo(String xpath_campo) {
		return driver.findElement(By.xpath(xpath_campo)).getAttribute("value");
	}
	
	public void clicarRadioButton(String button) {
	    driver.findElement(By.xpath(button)).click();
		
	}
	
	public boolean isRadioButton(String xpath) {
		
		return driver.findElement(By.xpath(xpath)).isSelected();
		
		
	}
	
	public void clicarCheckBox(String checkBox) {
		driver.findElement(By.id(checkBox)).click();
	
	}
	
	public void comboBox(String comboBox) {
		
		WebElement element = driver.findElement(By.id(comboBox));
	    Select combo = new Select(element);
	    combo.selectByIndex(2);
		
		
	}


	

}
