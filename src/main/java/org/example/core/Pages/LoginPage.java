package org.example.core.Pages;

import org.example.core.DriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private WebDriver driver;
    private BasePage basePage;

    @Before
    public void inicializa(){
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
        basePage = new BasePage();
    }

    public void acessarTelaInicial(){
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/login");
    }

    public void setEmail(String email){
        escreve("email", email);
    }

    public void setSenha(String senha){
        escreve("senha", senha);
    }
    public void entrar(){
        clicarBotaoPorTexto("Entrar");
    }





    // Teste Inserir usuário
    @Ignore
    public void InsertNewUser(){
        basePage.clicarLink("Novo usuário?");
        basePage.escreve("nome", "ContaTest3");
        basePage.escreve("email", "test@3");
        basePage.escreve("senha", "teste3");
        Assert.assertEquals("Usuário inserido com sucesso", basePage.obterTexto(By.xpath("//div[@class='alert alert-success' and @role='alert']\n")));
    }
}
