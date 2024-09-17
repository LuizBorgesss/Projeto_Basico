package org.example.core.Pages;

public class MenuPage extends BasePage{

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

}
