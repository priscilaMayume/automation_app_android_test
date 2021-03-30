package br.com.pmshirotsu.myapp;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class FormularioTeste {

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {

        //capacidades
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "MyApp");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        //instalar APK
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/myApp/src/main/resources/CTAppium_1_2.apk");

        //driver de conexão e inicializar
        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //validacoes
        //Selecionar a opção  formulario e clicar
        List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
        //Laço para todos os mobileElements encontrados
        elementosEncontrados.get(1).click();
        //Escrever nome
        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("**Priscila Mayume**");
        //Checar nome escrito
        String text = campoNome.getText();
        Assert.assertEquals("**Priscila Mayume**", text);

        //encerar a sessão
        driver.quit();
    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {

        //capacidades
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "MyApp");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        //instalar APK
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/myApp/src/main/resources/CTAppium_1_2.apk");

        //driver de conexão e inicializar
        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //validacoes
        //Selecionar a opção formulario e clicar
        //class[@att='value']
        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

        //Clicar no combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();

        //Selecionar a opção desejada
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        //Verificar a opção selecionada
        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        Assert.assertEquals("Nintendo Switch", text);

        //encerar a sessão
        driver.quit();
    }

    @Test
    public void deveInteragirComSwitchCheckBox() throws MalformedURLException {

        //capacidades
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "MyApp");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        //instalar APK
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/myApp/src/main/resources/CTAppium_1_2.apk");

        //driver de conexão e inicializar
        AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //validacoes
        //Selecionar a opção formulario e clicar
        //vai buscar qualquer elemento que possua o texto Formulario
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();

        //Verificar status dos elementos
        MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
        MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
        Assert.assertTrue(check.getAttribute("checked").equals("false"));
        Assert.assertTrue(switc.getAttribute("checked").equals("true"));

        //Clicar nos elementos
        check.click();
        switc.click();

        //Verificar estados alterados
        Assert.assertFalse(check.getAttribute("checked").equals("false"));
        Assert.assertFalse(switc.getAttribute("checked").equals("true"));

        //encerar a sessão
        driver.quit();
    }
}