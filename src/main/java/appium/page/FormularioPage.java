package appium.page;

import appium.core.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FormularioPage extends BasePage {

    public void escreverNome(String nome) {
        //Escrever nome
        escrever(MobileBy.AccessibilityId("nome"), nome);

    }

    public String obterNome() {
        //Checar nome escrito
        return obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarCombo(String valor) {
        //Clicar no combo e Selecionar a opção desejada
        selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorCombo() {
        //Verificar a opção selecionada
        return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck() {
        //Clicar nos elementos
        clicar(By.className("android.widget.CheckBox"));

    }

    public void clicarSwitch() {
        //Clicar nos elementos
        clicar(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarcado() {
        //Verificar status dos elementos
        return isCheckMarcado(By.className("android.widget.CheckBox"));

    }

    public boolean isSwitchMarcado() {
        //Verificar status dos elementos
        return isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void salvar() {
        clicarPorTexto("SALVAR");

    }

    public void salvarDemorado() {
        clicarPorTexto("SALVAR DEMORADO");

    }

    //Validações
    public String obterNomeCadastrado() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));

    }

    //Encontrar algo que inicie com este valor Console: switch
    public String obterConsoleCadastrado() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));

    }

    //O texto que vier do switch terá que terminar com o valor 'Off'
    public String obterCheckCadastrado() {
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));

    }

    public String obterSwitchCadastrado() {
        //O texto que vier do switch terá que terminar com o valor 'Off'
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }
}