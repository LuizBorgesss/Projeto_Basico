package org.example.Tests;

import org.example.core.BaseTest;
import org.example.core.Pages.BasePage;
import org.example.core.Pages.MenuPage;
import org.example.core.Pages.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;

public class MovimentacaoTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    MovimentacaoPage moviPage = new MovimentacaoPage();


    @Test
    public void inserirMovimentacao(){
        menuPage.acessarTelaInserirMovimentacao();

        moviPage.setDataMovimentacao("17/09/2024");
        moviPage.setDataPagamento("15/09/2024");
        moviPage.setDescricao("PS5 do pai");
        moviPage.setInteressado("Kabum games");
        moviPage.setValor("R$3500");
        moviPage.setConta("Conta de teste 2");
        moviPage.setStatusPago();

        moviPage.clicarBotaoPorTexto("Salvar");

        Assert.assertEquals("Movimentação adicionada com sucesso!", moviPage.obterMensagemSucesso());
    }
}
