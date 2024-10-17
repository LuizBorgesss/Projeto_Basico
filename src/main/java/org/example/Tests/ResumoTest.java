package org.example.Tests;

import org.example.Pages.MenuPage;

import org.example.Pages.ResumoPage;
import org.example.core.BaseTest;
import org.example.core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResumoTest extends BaseTest {

    private ResumoPage resumoPage = new ResumoPage();
    private MenuPage menuPage = new MenuPage();

    @Test
    public void test1RemoverMovimentacao(){
        menuPage.acessarTelaResumoMensal();

        resumoPage.excluirMovimentacao();

        Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
    }

    @Test
    public void test2ResumoMensal(){
        menuPage.acessarTelaResumoMensal();

        Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());

        resumoPage.selecionarAno("2016");
        resumoPage.buscar();

        List<WebElement> elementosEncontrados =
                DriverFactory.getDriver().findElements(By.xpath("//*[@id=\"tabelaExtrato\"]/tbody/tr"));
        Assert.assertEquals(0, elementosEncontrados.size());

    }
}
