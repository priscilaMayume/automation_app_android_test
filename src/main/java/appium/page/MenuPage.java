package appium.page;

import appium.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarFormulario() {
        //Selecionar a opção formulario e clicar
        //vai buscar qualquer elemento que possua o texto Formulario
        clicarPorTexto("Formulário");
    }

    public void acessarSplash() {
        clicarPorTexto("Splash");
    }

    public void acessarAlerta() {
        clicarPorTexto("Alertas");
    }

    public void acessarAbas() { clicarPorTexto("Abas"); }

    public void acessarAccordion() { clicarPorTexto("Accordion"); }

}