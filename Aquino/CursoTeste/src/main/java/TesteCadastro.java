import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCadastro {
	
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa(){
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
		
		
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}

	@Test
	public void deveRealizarCadastroComSucesso(){
		page.setNome("Wagner");
		page.setSobrenome("Costa");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Mestrado");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		
		
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Wagner"));
		Assert.assertEquals("Sobrenome: Costa", page.obterSobreNomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.obterEsporteCadastro());
	}
	
	@Test
	public void deveValidarNomeObrigatorio(){
		page.cadastrar();
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSobrenomeObrigatorio(){
		page.setNome("Nome qualquer");
		page.cadastrar();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarSexoObrigatorio(){
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.cadastrar();
		Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarComidaVegetariana(){
		page.setNome("Nome qualquer");
		page.setSobrenome("Sobrenome qualquer");
		page.setSexoFeminino();
		
		
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());
	}
	
	@Test
	public void deveValidarEsportistaIndeciso(){
		dsl.escrever("elementosForm:nome", "Nome qualquer");
		dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
		dsl.clicarRadio("elementosForm:sexo:1");
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
		dsl.selecionarCombo("elementosForm:esportes", "Karate");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
		dsl.clicarBotao("elementosForm:cadastrar");
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());
	}
}
