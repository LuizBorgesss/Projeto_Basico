package org.example.Tests;

import org.example.Pages.HomePage;
import org.example.Pages.MenuPage;
import org.example.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {

    MenuPage menu = new MenuPage();
    HomePage page = new HomePage();

    @Test
    public void testSaldoConta(){
        menu.acessarTelaPrincipal();
        Assert.assertEquals("534,00", page.obterSaldoConta("Conta para saldo"));
    }
}
