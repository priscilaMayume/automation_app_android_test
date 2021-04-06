package appium.page;

import appium.core.DSL;

public class MenuPage {

    private DSL dsl = new DSL();

    public void acessarFormulario(){
        //Selecionar a opção formulario e clicar
        //vai buscar qualquer elemento que possua o texto Formulario
        dsl.clicarPorTexto("Formulário");
    }
}
