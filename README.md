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
git clone https://github.com/phvieira124/prova_vericode.git
```
- Configure o arquivo "Configuration.properties"
```
environment=local
browser=chrome
windowMaximize=true
driverPath={PATH_CHROMEDRIVER}
implicitlyWait=10
url=https://www.correios.com.br/
```
- Execute os teste com o seguinte comando
```
mvn clean test
```
- Após finalizar o comando anterior execute o seguinte comando
```
mvn verify -DskipTests
```
- Após executar os comandos verifique o arquivo de evidência no seguinte diretório
```
{PATH_PROJETO}/target/cucumber-report-html/cucumber-html-reports/src-test-resources-functionalTests-BuscarCep-feature.html
```
****
