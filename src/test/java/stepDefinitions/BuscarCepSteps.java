package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.JsonDataReader;
import pageObjects.BuscarCepPage;

public class BuscarCepSteps {

    TestContext testContext;
    BuscarCepPage buscarCepPage;
    JsonDataReader jsonDataReader;
    String filePath = "src/test/resources/testDataResources/BuscarCep.json";

    public BuscarCepSteps(TestContext testContext) {
        this.testContext = testContext;
        buscarCepPage = testContext.getPageObjectManager().getBuscarCepPage();
        jsonDataReader = new JsonDataReader(filePath);
    }

    @Given("^entrar no site dos correitos$")
    public void entrar_no_site_dos_correitos() throws Throwable {
        buscarCepPage.acessarUrl();
    }

    @When("^procurar cep invalido$")
    public void procurar_cep_invalido() throws Throwable {
        String cepInvalido = jsonDataReader.loaderJson().getString("cepInvalido");
        buscarCepPage.preencherCep(cepInvalido);
        buscarCepPage.selecionarBuscar("cep");
    }

    @When("^confirmar mensagem de cep invalido$")
    public void confirmar_mensagem_de_cep_invalido() throws Throwable {
        buscarCepPage.validarMensagemCepInvalido();
    }

    @When("^voltar para o inicio$")
    public void voltar_para_o_inicio() throws Throwable {
        buscarCepPage.voltarParaInicio();
    }

    @When("^procurar por cep valido$")
    public void procurar_por_cep_valido() throws Throwable {
        String cepValido = jsonDataReader.loaderJson().getString("cepExistente");
        buscarCepPage.preencherCep(cepValido);
        buscarCepPage.selecionarBuscar("cep");
    }

    @When("^confirmar retorno do logradouro$")
    public void confirmar_retorno_do_logradouro() throws Throwable {
        String rua = jsonDataReader.loaderJson().getString("rua");
        String cidadeEstado = jsonDataReader.loaderJson().getString("cidadeEstado");
        buscarCepPage.validarLogradouro(rua, cidadeEstado);
    }

    @When("^procurar pelo código de rastreio$")
    public void procurar_pelo_código_de_rastreio() throws Throwable {
        String codigoRastreioInvalido = jsonDataReader.loaderJson().getString("codigoRastreioInvalido");
        buscarCepPage.preencherObjeto(codigoRastreioInvalido);
        buscarCepPage.selecionarBuscar("objeto");
        buscarCepPage.trocarPagina(3);
    }

    @Then("^validar direcionamento tela rastreamento$")
    public void validar_que_o_código_de_rastreio_nao_existe() throws Throwable {
        buscarCepPage.validarDirecionamentoTelaRastreamento();
    }

}
