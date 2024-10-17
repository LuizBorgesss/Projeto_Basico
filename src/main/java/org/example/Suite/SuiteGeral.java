package org.example.Suite;

import org.example.Pages.LoginPage;
import org.example.Tests.*;
import org.example.core.DriverFactory;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;



@RunWith(Suite.class)
@Suite.SuiteClasses({
        ContaTest.class,
        MovimentacaoTest.class,
        RemoverMovimentacaoContaTest.class,
        SaldoTest.class,
        ResumoTest.class
})

public class SuiteGeral {
    private static LoginPage page = new LoginPage();

    @BeforeClass
    public static void reset(){
        page.acessarTelaInicial();

        page.setEmail("luiz@1");
        page.setSenha("123");
        page.entrar();

        page.resetar();

        DriverFactory.killDriver();
    }


}
