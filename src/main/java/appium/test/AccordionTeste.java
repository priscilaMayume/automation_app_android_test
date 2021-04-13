package appium.test;

import appium.core.BaseTest;
import appium.page.AccordionPage;
import appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private AccordionPage page = new AccordionPage();

    @Test
    public void deveInteragirComAccordion() {
        //acessar o menu accordion
        menu.acessarAccordion();

        //clicar na opção1
        page.selecionarOp1();

        //verificar texto
        esperar(3000);
        Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());

    }
}
