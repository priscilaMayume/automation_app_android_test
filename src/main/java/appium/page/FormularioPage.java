package appium.page;

import appium.core.DSL;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

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

    public void selecionarCombo(String valor) {
        //Clicar no combo e Selecionar a opção desejada
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorCombo() {
        //Verificar a opção selecionada
        return dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck() {
        //Clicar nos elementos
        dsl.clicar(By.className("android.widget.CheckBox"));

    }

    public void clicarSwitch() {
        //Clicar nos elementos
        dsl.clicar(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarcado() {
        //Verificar status dos elementos
        return dsl.isCheckMarcado(By.className("android.widget.CheckBox"));

    }

    public boolean isSwitchMarcado() {
        //Verificar status dos elementos
        return dsl.isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void salvar() {
        dsl.clicarPorTexto("SALVAR");

    }

    //Validações
    public String obterNomeCadastrado() {
        return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));

    }

    //Encontrar algo que inicie com este valor Console: switch
    public String obterConsoleCadastrado() {
        return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));

    }

    //O texto que vier do switch terá que terminar com o valor 'Off'
    public String obterCheckCadastrado() {
        return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));

    }

    public String obterSwitchCadastrado() {
        //O texto que vier do switch terá que terminar com o valor 'Off'
        return dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }
}