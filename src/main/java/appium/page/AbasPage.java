package appium.page;

import appium.core.BasePage;

public class AbasPage extends BasePage {

    public boolean isPagina1() {
        return existeElementoPorTexto("Este é o conteúdo da Aba 1");
    }

    public void acessarPg2() {
        clicarPorTexto("ABA 2");

    }

    public void acessarPg1() {
        clicarPorTexto("ABA 1");

    }

    public boolean isPagina2() {
        return existeElementoPorTexto("Este é o conteúdo da Aba 2");

    }
}
