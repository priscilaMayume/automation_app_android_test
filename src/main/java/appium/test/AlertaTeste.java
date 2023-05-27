package appium.test;

import appium.core.BaseTest;
import appium.page.AlertasPage;
import appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlertaTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertasPage page = new AlertasPage();

    @Before
    public void setup() {
        //acessar menu alerta
        menu.acessarAlerta();
    }

    @Test
    public void deveConfirmarAlerta() {
        //clicar em alerta confirm
        page.clicarAlertaConfirm();

        //verificar os textos
        Assert.assertEquals("Info", page.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());

        //confirmar alerta
        page.confirmarAlerta();

        //verficar nova mensagem
//        Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
 //       Assert.assertEquals("Confirmado", page.obterMensagemAlerta());

        //sair
        page.sairAlerta();

    }

    @Test
    public void deveClicarForaAlerta() {
        //clicar em alerta simples
        page.clicarAlertaSimples();

        //clicar fora da caixa - clicar em 100,150
        page.clicarForaCaixa();

        //verificar ue a mensagem não esta presente
        Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));

    }
}
