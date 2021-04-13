package appium.test;

import appium.core.BaseTest;
import appium.page.AlertasPage;
import appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AlertaTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AlertasPage page = new AlertasPage();

    @Test
    public void deveConfirmarAlerta() {
        //acessar menu alerta
        menu.acessarAlerta();

        //clicar em alerta confirm
        page.clicarAlertaConfirm();

        //verificar os textos
        Assert.assertEquals("Info", page.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());

        //confirmar alerta
        page.confirmarAlerta();

        //verficar nova mensagem
        Assert.assertEquals("Confirmado", page.obterMensagemAlerta());

        //sair
        page.sairAlerta();

    }
}
