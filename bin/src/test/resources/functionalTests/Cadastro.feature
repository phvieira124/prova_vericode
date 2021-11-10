Feature: Cadastro

	Background: Cadastrar usuario
		* acessar formulario para cadastro
		* adicionar registro no Tema Bootstrap V4
	
	@Cadastro
	@ct01_cadastro
	Scenario: Cadastrar custumer em grocerycrud
		Then validar registrao realizado com sucesso
		
	@Cadastro
	@ct02_cadastro
	Scenario: Deletar cadastro
		Given voltar para lista de registros
		And procurar por "Teste Sicredi"
		When deletar o regitrao
		Then validar mensagem de regitro deletado