package org.example.Tests;

import org.example.core.BaseTest;
import org.example.Pages.ContasPage;
import org.example.Pages.MenuPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;


public class ContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void test1_InserirConta(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta de teste");
        contasPage.salvar();
        Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());;
    }

    @Test
    public void test2_AlterarConta(){
        menuPage.acessarTelaListarContas();
        contasPage.clicarAlterarConta("Conta de teste");
        contasPage.apagar_E_Escrever();
        contasPage.setNome("Conta de teste 2");
        contasPage.salvar();
        Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
    }

    @Test
    public void test3_inserirContaMesmoNome(){
        menuPage.acessarTelaInserirConta();
        contasPage.setNome("Conta mesmo nome");
        contasPage.salvar();
        Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
    }
}