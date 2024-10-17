package org.example.Tests;

import org.example.core.BaseTest;
import org.example.Pages.MenuPage;
import org.example.Pages.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;

public class RegrasMovimentacaoTest extends BaseTest {
    MenuPage menuPage = new MenuPage();
    MovimentacaoPage moviPage = new MovimentacaoPage();

    @Test
    public void testInicial(){
        menuPage.acessarTelaInserirMovimentacao();

        moviPage.clicarBotaoPorTexto("Salvar");
        Assert.assertEquals("Data da Movimentação é obrigatório\nData do pagamento é obrigatório\nDescrição é obrigatório\nInteressado é obrigatório\nValor é obrigatório\nValor deve ser um número", moviPage.obterMensagemErro());
    }

    @Test
    public void testDataMovimentacao(){
        menuPage.acessarTelaInserirMovimentacao();

        moviPage.setDataMovimentacao("18/09/2024");
        moviPage.clicarBotaoPorTexto("Salvar");

        Assert.assertEquals("Data do pagamento é obrigatório\nDescrição é obrigatório\nInteressado é obrigatório\nValor é obrigatório\nValor deve ser um número", moviPage.obterMensagemErro());
    }

    @Test
    public void testDataPagamento(){
        menuPage.acessarTelaInserirMovimentacao();

        moviPage.setDataMovimentacao("18/09/2024");
        moviPage.setDataPagamento("19/09/2024");
        moviPage.clicarBotaoPorTexto("Salvar");

        Assert.assertEquals("Descrição é obrigatório\nInteressado é obrigatório\nValor é obrigatório\nValor deve ser um número", moviPage.obterMensagemErro());
    }

    @Test
    public void testDescricao(){
        menuPage.acessarTelaInserirMovimentacao();

        moviPage.setDataMovimentacao("18/09/2024");
        moviPage.setDataPagamento("19/09/2024");
        moviPage.setDescricao("Pagamento realizado");
        moviPage.clicarBotaoPorTexto("Salvar");

        Assert.assertEquals("Interessado é obrigatório\nValor é obrigatório\nValor deve ser um número", moviPage.obterMensagemErro());
    }

    @Test
    public void testInteressado(){
        menuPage.acessarTelaInserirMovimentacao();

        moviPage.setDataMovimentacao("18/09/2024");
        moviPage.setDataPagamento("19/09/2024");
        moviPage.setDescricao("Pagamento realizado");
        moviPage.setInteressado("Luiz");
        moviPage.clicarBotaoPorTexto("Salvar");

        Assert.assertEquals("Valor é obrigatório\nValor deve ser um número", moviPage.obterMensagemErro());
    }

    @Test
    public void testValorObrigatorio(){
        menuPage.acessarTelaInserirMovimentacao();

        moviPage.setDataMovimentacao("18/09/2024");
        moviPage.setDataPagamento("19/09/2024");
        moviPage.setDescricao("Pagamento realizado");
        moviPage.setInteressado("Luiz");
        moviPage.setValor("abc");
        moviPage.clicarBotaoPorTexto("Salvar");

        Assert.assertEquals("Valor deve ser um número", moviPage.obterMensagemErro());
    }

    @Test
    public void testCompleto(){
        menuPage.acessarTelaInserirMovimentacao();

        moviPage.setDataMovimentacao("18/09/2024");
        moviPage.setDataPagamento("19/09/2024");
        moviPage.setDescricao("Pagamento realizado");
        moviPage.setInteressado("Luiz");
        moviPage.setValor("1500");
        moviPage.setConta("Conta de teste 2");
        moviPage.setStatusPago();

        moviPage.clicarBotaoPorTexto("Salvar");

        Assert.assertEquals("Movimentação adicionada com sucesso!", moviPage.obterMensagemSucesso());
    }

}
