package appium.test;

import appium.core.BaseTest;
import appium.page.AbasPage;
import appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbasTeste extends BaseTest {

    private AbasPage page = new AbasPage();
    private MenuPage menu = new MenuPage();

    @Test
    public void deveInteragircombo() {
        //acessar menu abas
        menu.acessarAbas();

        //verificar o que esta na página 1
        Assert.assertTrue(page.isPagina1());

        //acessar a aba 2
        page.acessarPg2();

        //verificar o que esta na página 2
        Assert.assertTrue(page.isPagina2());

        //voltar pra página 1
        page.acessarPg1();
    }
}
