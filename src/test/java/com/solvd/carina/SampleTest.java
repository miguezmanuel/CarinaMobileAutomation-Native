package com.solvd.carina;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class SampleTest implements IAbstractTest {

    @Test
    public void openAppTest() {
        getDriver(); // Inicia la aplicación en el emulador/simulador
        System.out.println("La aplicación se ha abierto correctamente.");
    }
}
