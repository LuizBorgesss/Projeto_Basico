package org.example.Pages;

import org.example.core.BasePage;
import org.openqa.selenium.By;

public class MovimentacaoPage extends BasePage {

    public void setDataMovimentacao(String data){
        escreve("data_transacao", data);
    }

    public void setDataPagamento(String data){
        escreve("data_pagamento", data);
    }

    public void setDescricao(String descricao){
        escreve("descricao", descricao);
    }

    public void setInteressado(String interessado){
        escreve("interessado", interessado);
    }

    public void setValor(String valor){
        escreve("valor", valor);
    }

    public void setConta(String conta){
        selecionarCombo("conta", conta);
    }

    public void setStatusPago(){
        clicarRadio("status_pago");
    }

    public void salvar(){
        clicarBotaoPorTexto("Salvar");
    }

    public String obterMensagemSucesso(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }

    public String obterMensagemErro(){
        return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
    }

    public void clicarExcluirMovimentacao(String string){
        obterCelula("Conta", string, "Ações", "tabelaExtrato")
                .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
    }

}
