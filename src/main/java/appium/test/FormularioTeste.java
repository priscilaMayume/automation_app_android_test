package appium.test;

import appium.core.BaseTest;
import appium.core.DriverFactory;
import appium.page.FormularioPage;
import appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FormularioTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();

    @Before
    public void inicializarAppium()  {
        //Selecionar a opção formulario e clicar
        //vai buscar qualquer elemento que possua o texto Formulario
        menu.acessarFormulario();

    }

    @Test
    public void devePreencherCampoTexto() {
        //Escrever nome
        page.escreverNome("**Priscila Mayume**");

        //Checar nome escrito
        assertEquals("**Priscila Mayume**", page.obterNome());

    }

    @Test
    public void deveInteragirComCombo(){
        //Clicar no combo e Selecionar a opção desejada
        page.selecionarCombo("Nintendo Switch");

        //Verificar a opção selecionada
        assertEquals("Nintendo Switch", page.obterValorCombo());

    }

    @Test
    public void deveInteragirComSwitchCheckBox()  {

        //Verificar status dos elementos
        Assert.assertFalse(page.isCheckMarcado());
        assertTrue(page.isSwitchMarcado());

        //Clicar nos elementos
        page.clicarCheck();
        page.clicarSwitch();

        //Verificar estados alterados
        assertTrue(page.isCheckMarcado());
        Assert.assertFalse(page.isSwitchMarcado());
    }

    @Test
    public void deveRealizarCadastro()  {
        //Preencher o campo 'nome'
        page.escreverNome("Priscila Mayume");
        //Clicar no checkbox
        page.clicarCheck();
        //Clicar no switch
        page.clicarSwitch();
        //Clicar no combo box e na opção desejada do combo box
        page.selecionarCombo( "Nintendo Switch");
        //Clicar em salvar
        page.salvar();

        //Validações
        assertEquals("Nome: Priscila Mayume", page.obterNomeCadastrado());

        //Encontrar algo que inicie com este valor Console: switch
        assertEquals("Console: switch", page.obterConsoleCadastrado());

        //O texto que vier do switch terá que terminar com o valor 'Off'
        assertTrue(page.obterCheckCadastrado().endsWith("Off"));

        //O texto que vier do switch terá que terminar com o valor 'Off'
        assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));
    }

    @Test
    public void deveRealizarCadastroDemorado() {
        //Preencher o campo 'nome'
        page.escreverNome("Priscila Mayume");
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //Clicar em salvar
        page.salvarDemorado();
//        esperar(6000);

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Nome: Priscila Mayume']")));

        //Validações
        assertEquals("Nome: Priscila Mayume", page.obterNomeCadastrado());

    }

    @Test
    public void deveAlterarData() {
        page.clicarPorTexto("01/01/2000");
        page.clicarPorTexto("20");
        page.clicarPorTexto("OK");

        Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));

    }

    @Test
    public void deveAlterarHora() {
        page.clicarPorTexto("06:00");
        page.clicar(MobileBy.AccessibilityId("10"));
        page.clicar(MobileBy.AccessibilityId("40"));
        page.clicarPorTexto("OK");

        Assert.assertTrue(page.existeElementoPorTexto("10:40"));

    }
}