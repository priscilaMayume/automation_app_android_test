package appium.test;

import appium.core.DSL;
import appium.core.DriverFactory;
import appium.page.FormularioPage;
import appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FormularioTeste {

    private DSL dsl = new DSL();
    private MenuPage menu = new MenuPage();
    private FormularioPage page = new FormularioPage();

    @Before
    public void inicializarAppium()  {
        //Selecionar a opção formulario e clicar
        //vai buscar qualquer elemento que possua o texto Formulario
        menu.acessarFormulario();

    }

    @After
    public void tearDown(){

        DriverFactory.killDriver();
    }

    @Test
    public void devePreencherCampoTexto() {
        //Escrever nome
        page.escreverNome("**Priscila Mayume**");

        //Checar nome escrito
        assertEquals("**Priscila Mayume**", page.obterNome());

    }

    @Test //Parou na aula 21 - 9:21
    public void deveInteragirComCombo(){
        //Clicar no combo e Selecionar a opção desejada
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

        //Verificar a opção selecionada
        String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
        assertEquals("Nintendo Switch", text);

    }

    @Test
    public void deveInteragirComSwitchCheckBox()  {

        //Verificar status dos elementos
        Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

        //Clicar nos elementos
        dsl.clicar(By.className("android.widget.CheckBox"));
        dsl.clicar(MobileBy.AccessibilityId("switch"));

        //Verificar estados alterados
        assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
    }

    @Test
    public void deveRealizarCadastro()  {
        //Preencher o campo 'nome'
        dsl.escrever(By.className("android.widget.EditText"),"Priscila Mayume");
        //Clicar no checkbox
        dsl.clicar(By.className("android.widget.CheckBox"));
        //Clicar no switch
        dsl.clicar(By.className("android.widget.Switch"));
        //Clicar no combo box e na opção desejada do combo box
        dsl.selecionarCombo(By.className("android.widget.Spinner"), "Nintendo Switch");
        //Clicar em salvar
        dsl.clicarPorTexto("SALVAR");

        //Validações
        assertEquals("Nome: Priscila Mayume", dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Priscila Mayume']")));

        //Encontrar algo que inicie com este valor Console: switch
        assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]")));

        //O texto que vier do switch terá que terminar com o valor 'Off'
        assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]")).endsWith("Off"));

        //O texto que vier do switch terá que terminar com o valor 'Off'
        assertTrue( dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]")).endsWith("Marcado"));
    }
}