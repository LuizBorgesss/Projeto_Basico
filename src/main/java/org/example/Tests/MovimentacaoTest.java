package org.example.Tests;

import org.example.Utils.DataUtils;
import org.example.core.BaseTest;
import org.example.Pages.MenuPage;
import org.example.Pages.MovimentacaoPage;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import java.util.Date;



public class MovimentacaoTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    MovimentacaoPage moviPage = new MovimentacaoPage();


    @Test
    public void test1_InserirMovimentacao() {
        menuPage.acessarTelaInserirMovimentacao();

        moviPage.setDataMovimentacao(DataUtils.obterDataFormatado(new Date()));
        moviPage.setDataPagamento(DataUtils.obterDataFormatado(new Date()));
        moviPage.setDescricao("PS5 do pai");
        moviPage.setInteressado("Kabum games");
        moviPage.setValor("500");
        moviPage.setConta("Conta para movimentacoes");
        moviPage.setStatusPago();

        moviPage.salvar();

        Assert.assertEquals("Movimentação adicionada com sucesso!", moviPage.obterMensagemSucesso());
    }

    @Test
    public void test2_CamposObrigatorios(){
        menuPage.acessarTelaInserirMovimentacao();

        moviPage.clicarBotaoPorTexto("Salvar");
        Assert.assertEquals("Data da Movimentação é obrigatório\nData do pagamento é obrigatório\nDescrição é obrigatório\nInteressado é obrigatório\nValor é obrigatório\nValor deve ser um número",
                moviPage.obterMensagemErro());

    }

    @Test
    public void test3_InserirMovimentacaoFutura(){
        menuPage.acessarTelaInserirMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

        moviPage.setDataMovimentacao(DataUtils.obterDataFormatado(dataFutura));
        moviPage.setDataPagamento(DataUtils.obterDataFormatado(dataFutura));
        moviPage.setDescricao("PS5 do pai");
        moviPage.setInteressado("Kabum games");
        moviPage.setValor("500");
        moviPage.setConta("Conta para movimentacoes");
        moviPage.setStatusPago();

        moviPage.salvar();

        Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", moviPage.obterMensagemErro());
    }

    @Ignore
    public void test4_InserirMovimentacao() {
        menuPage.acessarTelaInserirMovimentacao();

        moviPage.setDataMovimentacao("17/09/2024");
        moviPage.setDataPagamento("15/09/2024");
        moviPage.setDescricao("PS5 do pai");
        moviPage.setInteressado("Kabum games");
        moviPage.setValor("500");
        moviPage.setConta("Conta 1");
        moviPage.setStatusPago();

        moviPage.clicarBotaoPorTexto("Salvar");

        Assert.assertEquals("Movimentação adicionada com sucesso!", moviPage.obterMensagemSucesso());
    }
}