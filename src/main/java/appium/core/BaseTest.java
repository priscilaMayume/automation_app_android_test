package appium.core;

import org.junit.After;

//Essa classe é para o comportamento em comum é todos os cenarios de testes
public class BaseTest {

    @After
    public void tearDown() {
        DriverFactory.killDriver();

    }
}