package appium.core;

import org.openqa.selenium.By;

import static appium.core.DriverFactory.getDriver;

public class DSL {

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

}