package br.com.pmshirotsu.myapp;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class FormularioTeste {

    @Test
    public void deveInstalarAPK() throws MalformedURLException {

        //capacidades
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "aula_appium");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        //instalar APK
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/myApp/src/main/resources/CTAppium_1_2.apk");

        //driver de conexão e inicializar
        AndroidDriver<WebElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        //encerar a sessão
        driver.quit();
    }
}

