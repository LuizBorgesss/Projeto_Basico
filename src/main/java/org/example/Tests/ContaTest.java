package org.example.Tests;

import org.example.core.BaseTest;
import org.example.core.Pages.ContasPage;
import org.example.core.Pages.MenuPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void testInserirConta(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta de teste");
        contasPage.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());;
    }

    @Test
    public void testAlterarConta(){
        menuPage.acessarTelaListarContas();
        contasPage.clicarAlterarConta("Conta de teste");
        contasPage.apagar_E_Escrever();
        contasPage.setNome("Conta de teste 2");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void inserirContaMesmoNome(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta de teste 2");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }


}
