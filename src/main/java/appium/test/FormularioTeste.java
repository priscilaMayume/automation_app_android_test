package appium.test;

import appium.core.DSL;
import appium.core.DriverFactory;
import appium.page.FormularioPage;
import appium.page.MenuPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
}