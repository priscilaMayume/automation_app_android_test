package appium.test;

import appium.core.BaseTest;
import appium.page.MenuPage;
import appium.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

public class SplashTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage page = new SplashPage();

    @Test

    public void deveAguardarSplashSumir() {
        //acessar menu splash
        menu.acessarSplash();

        //verificar que o splash esta sendo exibido
        page.isTelaSplashVisivel();

        //aguardar saida do splash
        page.aguadarSplashSumir();

        //verficar que o formulario esta aparecendo
        Assert.assertTrue(page.existeElementoPorTexto("Formulário"));

    }
}
