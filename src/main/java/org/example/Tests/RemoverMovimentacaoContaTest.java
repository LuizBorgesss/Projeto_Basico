package org.example.Tests;

import org.example.Pages.ContasPage;
import org.example.Pages.MenuPage;
import org.example.core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class RemoverMovimentacaoContaTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    ContasPage contasPage = new ContasPage();

    @Test
    public void excluirContaMovimentacao(){
        menuPage.acessarTelaListarContas();

        contasPage.clicarExcluirConta("Conta com movimentacao");

        Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
    }
}
