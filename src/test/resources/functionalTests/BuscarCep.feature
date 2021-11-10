Feature: Buscar CEP

  Scenario: Validar busca por cep e código de rastreio
    Given entrar no site dos correitos
    When procurar cep invalido
    And confirmar mensagem de cep invalido
    And voltar para o inicio
    And procurar por cep valido
    And confirmar retorno do logradouro
    And voltar para o inicio
    And procurar pelo código de rastreio
    Then validar direcionamento tela rastreamento