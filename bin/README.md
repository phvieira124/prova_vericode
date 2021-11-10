# Projeto de automação de testes web

## Ferramentas utilizadas
- JDK 8
- Maven 3.6.3
- Chromedriver
- Junit
- Cucumber

## Como executar o teste local
- Execute o comando na pasta do projeto
```
$ git clone https://gitlab.com/keren.felizardo/desafio_sicredi_web.git
```
- Configure o arquivo "Configuration.properties"
```
environment=local
browser=chrome
windowMaximize=true
driverPath={PATH_CHROMEDRIVER}
implicitlyWait=10
url=https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap-v4
```
- Execute os teste com o seguinte comando
```
$ mvn clean test
```
- Após finalizar o comando anterior execute o seguinte comando
```
$ mvn verify -DskipTests
```
- Após executar os comandos verifique o arquivo de evidência no seguinte diretório
```
{PATH_PROJETO}/target/cucumber-report-html/cucumber-html-reports/Cadastro.html
```

