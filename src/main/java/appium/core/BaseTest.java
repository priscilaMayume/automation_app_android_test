package appium.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

//Essa classe é para o comportamento em comum é todos os cenarios de testes
public class BaseTest {
    //nomear os arquivos dos screenshots
    @Rule
    public TestName testName = new TestName();

    //executa ao final de cada classe de teste
    @AfterClass
    public static void finalizarClasse() {
        //mata a sessao
        DriverFactory.killDriver();
    }

    //executa ao final de cada método de teste
    @After
    public void tearDown() {
    //Ao final dos testes será gerado uma imagem
        gerarScreenShot();
    //mata a sessao quando o app fica inativo
     //   DriverFactory.getDriver().resetApp();

    }

    public void gerarScreenShot() {
        File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void esperar(long tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}