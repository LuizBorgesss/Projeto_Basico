package org.example.Pages;

import org.example.core.BasePage;

public class MenuPage extends BasePage {

    public void acessarTelaInserirConta(){
        clicarLink("Contas");
        clicarLink("Adicionar");
    }

    public void acessarTelaListarContas(){
        clicarLink("Contas");
        clicarLink("Listar");
    }

    public void acessarTelaInserirMovimentacao(){
        clicarLink("Criar Movimentação");
    }

    public void acessarTelaResumoMensal(){
        clicarLink("Resumo Mensal");
    }

    public void acessarTelaPrincipal(){
        clicarLink("Home");
    }
}
