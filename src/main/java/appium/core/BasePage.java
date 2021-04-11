package appium.core;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static appium.core.DriverFactory.getDriver;

public class BasePage {

    public void escrever(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by) {

        return getDriver().findElement(by).getText();
    }

    public void clicar(By by) {
        getDriver().findElement(by).click();

    }

    public void clicarPorTexto(String texto) {
        //Selecionar a opção desejada
        clicar(By.xpath("//*[@text='"+texto+"']"));
//        clicar(By.xpath(("//*[@text='"+texto"'")));

    }

    public void selecionarCombo(By by, String valor) {
        //Clicar no combo
        getDriver().findElement(by).click();
        //Selecionar a opção desejada
        clicarPorTexto(valor);
    }

    public boolean isCheckMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");

    }

    public  boolean existeElementoPorTexto(String texto) {
       List<MobileElement> elemento =  getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
        return elemento.size() > 0;
    }
}