package appium.page;

import appium.core.BasePage;
import org.openqa.selenium.By;

public class AlertasPage extends BasePage {

    public void clicarAlertaConfirm() {

        //clicar na opção alert confirm
        clicarPorTexto("ALERTA CONFIRM");
    }

    public String obterTituloAlerta() {
        return obterTexto(By.id("android:id/alertTitle"));

    }

    public String obterMensagemAlerta() {
        return obterTexto(By.id("android:id/message"));
    }

    public void confirmarAlerta() {
        clicarPorTexto("CONFIRMAR");
    }

    public void sairAlerta () {
        clicarPorTexto("SAIR");

    }

    public void negarAlerta() {
        clicarPorTexto("NEGAR");
    }
}
