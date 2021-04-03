package br.com.pmshirotsu.myapp;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class FormularioTeste {

    private AndroidDriver<MobileElement> driver;

    @Before
    public void inicializarAppium() throws MalformedURLException {

        //capacidades
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "android_appium");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        //instalar APK
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/home/local/CONDUCTOR/priscila.hirotsu/Documentos/projetos/PESSOAL/myApp/src/main/resources/CTAppium_1_2.apk");

        //driver de conexão e inicializar
        driver  = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Selecionar a opção formulario e clicar
        //vai buscar qualquer elemento que possua o texto Formulario
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();
    }

    @After
    public void tearDown(){
        //encerar a sessão
        driver.quit();
    }

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {
        //Escrever nome
        MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("**Priscila Mayume**");
        //Checar nome escrito
        String text = campoNome.getText();
        Assert.assertEquals("**Priscila Mayume**", text);

    }

    @Test
    public void deveInteragirComCombo() throws MalformedURLException {
        //Clicar no combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();

        //Selecionar a opção desejada
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        //Verificar a opção selecionada
        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        Assert.assertEquals("Nintendo Switch", text);

    }

    @Test
    public void deveInteragirComSwitchCheckBox() throws MalformedURLException {
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

    }

    @Test
    public void deveResolverDesafio() throws MalformedURLException {
        //Preencher o campo 'nome'
        driver.findElement(By.className("android.widget.EditText")).sendKeys("Priscila Mayume");
        //Clicar no checkbox
        driver.findElement(By.className("android.widget.CheckBox")).click();
        //Clicar no switch
        driver.findElement(By.className("android.widget.Switch")).click();
        //Clicar no combo box
        driver.findElement(By.className("android.widget.Spinner")).click();
        //Selecionar a opção desejada do combo box
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
        //Clicar em salvar
        driver.findElement(By.xpath("//*[@text='SALVAR']")).click();

        //Validações
        MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Priscila Mayume']"));
        Assert.assertEquals("Nome: Priscila Mayume", nome.getText());

        //Encontrar algo que inicie com este valor Console: switch
        MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
        Assert.assertEquals("Console: switch", combo.getText());

        MobileElement swit = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
        //O texto que vier do switch terá que terminar com o valor 'Off'
        Assert.assertTrue(swit.getText().endsWith("Off"));

        MobileElement checkbox = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
        //O texto que vier do switch terá que terminar com o valor 'Off'
        Assert.assertTrue(checkbox.getText().endsWith("Marcado"));

    }
}