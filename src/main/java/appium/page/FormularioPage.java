package appium.page;

import appium.core.DSL;
import io.appium.java_client.MobileBy;

public class FormularioPage {

    private DSL dsl = new DSL();

    public void escreverNome(String nome) {
        //Escrever nome
        dsl.escrever(MobileBy.AccessibilityId("nome"), nome);

    }
    public String obterNome() {
        //Checar nome escrito
      return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
    }
}
