package pageObjects;

import managers.FileReaderManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Wait;

import java.util.List;

public class BuscarCepPage {

    WebDriver driver;

    public BuscarCepPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "relaxation")
    private WebElement cmpCep;

    @FindBy(className = "ic-busca-out")
    private WebElement btnBusca;

    @FindBy(id = "mensagem-resultado")
    private WebElement msgResultadoPesquisaCep;

    @FindBy(xpath = "//*[@data-th=\"Logradouro/Nome\"]")
    private WebElement colunaLogradouro;

    @FindBy(css = "#objetos")
    private WebElement cmpRastreio;

    @FindBy(id = "titulo-pagina")
    private WebElement lblTituloPagina;

    public void acessarUrl() {
        driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void preencherCep(String cep){
        Wait.waitForElement(driver, cmpCep, (long) 60);
        cmpCep.clear();
        cmpCep.sendKeys(cep);
    }

    public void preencherObjeto(String numeroObjeto){
        Wait.waitForElement(driver, cmpRastreio, (long) 60);
        cmpRastreio.sendKeys(numeroObjeto);
    }

    public void selecionarBuscar(String tipoBusca){
        Wait.waitForElement(driver, btnBusca, (long) 60);
        List<WebElement> elementList = driver.findElements(By.className("ic-busca-out"));
        if(tipoBusca.equalsIgnoreCase("cep")){
            elementList.get(1).click();
        }else if (tipoBusca.equalsIgnoreCase("objeto")){
            elementList.get(0).click();
        }
    }

    public void trocarPagina(int indexPagina) throws InterruptedException {
        Thread.sleep(1000);
        String[] arrPaginas = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(arrPaginas[indexPagina]);
    }

    public void validarMensagemCepInvalido() throws InterruptedException {
        trocarPagina(1);
        Wait.waitForElement(driver, msgResultadoPesquisaCep, (long) 60);
        Assert.assertEquals("Não há dados a serem exibidos", msgResultadoPesquisaCep.getText());
    }

    public void voltarParaInicio() throws InterruptedException {
        trocarPagina(0);
    }

    public void validarLogradouro(String rua, String cidadeEstado) throws InterruptedException {
        boolean validacaoRua = false;
        boolean validacaoCidade = false;

        trocarPagina(2);
        Wait.waitForElement(driver, colunaLogradouro, (long) 60);

        List<WebElement> elementList = driver.findElements(By.xpath("//*[@data-th=\"Logradouro/Nome\"]"));
        List<WebElement> elementLocalidade = driver.findElements(By.xpath("//*[@data-th=\"Localidade/UF\"]"));

        for(WebElement element : elementList){
            if(element.getText().contains(rua)){
                validacaoRua = true;
                break;
            }
        }

        for(WebElement element : elementLocalidade){
            if(element.getText().contains(cidadeEstado)){
                validacaoCidade = true;
                break;
            }
        }

        Assert.assertTrue("Busca por rua " + rua, validacaoRua);
        Assert.assertTrue("Busca por cidade " + cidadeEstado, validacaoCidade);
    }

    public void validarDirecionamentoTelaRastreamento(){
        Wait.waitForElement(driver, lblTituloPagina, (long) 60);
        Assert.assertEquals("Rastreamento", lblTituloPagina.getAttribute("innerText"));
    }
}
