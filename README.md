# Avaliação Desenvolvedor Softplan - Teste 1
Sienge Software para Construção Civil 

As tecnologias, frameworks e ferramentas utilizadas foram Java 8, PrimeFaces 6, Tomcat 7, Eclipse Oxygen e Google Chrome 63. 

## Importando e Configurando o projeto:
Após o download do projeto, abra o Eclipse crie um novo projeto do tipo Dynamic Web project.No new project informe a pasta sienge. Ao final do processo de criação do projeto, deverá ser criado um novo server o Tomcat 7.
Por fim executar o Tomcat e acessar a aplicação via navegador com a url abaixo. Para execução dos teste o Tomcat não é necessário porque o teste roda via Java Application. 

## Acessando o sistema Sienge:
Para acessar o Sienge, abra um navegador e digite ou cole na barra de endereço a URL http://localhost:8080/sienge/index.xhtml

### Início:
<img align="left" width="100%" height="500" src="/sienge_prints/Sienge_1.png">

### Selecionando um veículo:

<img align="left" width="100%" height="500" src="/sienge_prints/Sienge_2.png">

### Informado os dados numéricos do transporte:

<img align="left" width="100%" height="500" src="/sienge_prints/Sienge_3.png">

### Resultado do valor do transporte é exibido ao usuário:

<img align="left" width="100%" height="500" src="/sienge_prints/Sienge_4.png">

### Limpar:

<img align="left" width="100%" height="500" src="/sienge_prints/Sienge_1.png">

## Teste no Sienge

No projeto Sienge tem a seguinte classe /sienge/src/br/com/sienge/teste/SiengeMBeanTest.java
Essa classe SiengeMBeanTest serve para testar o método principal do Sienge que faz o cálculo do custo total do transporte. 

Após a execução da classe de teste via Java Application esse é o resultado esperado:
<img align="left" width="100%" height="80%" src="/sienge_prints/TesteSienge_1.png">

### * Fique a vontade para alterar os valores diretamente na classe SiengeMBeanTest!

# Avaliação Desenvolvedor Softplan - Teste 2

Correção e melhorias nos arquivos enviados para análise GeradorObservacao e GeradorObservacaoTest
Os arquivos se encontram nos diretórios abaixo nesse mesmo repositório:

### Classe Java:

/sienge/src/br/com/teste2/mbean/GeradorObservacao.java 
### Teste:

/sienge/src/br/com/teste2/teste/GeradorObservacaoTest.java

### Alterações:
Foi alterado o código para deixar a implementação mais limpa. A programação foi mudada em GeradorObservacao.java para ter apenas um método que trata a lista de notas recebidas. Melhorado o controle de retorno para listas com um ou mais números de uma nota.A classe de teste foi mantida a original entendendo que aquele é o resultado esperado, por isso foi programado somente na classe GeradorObservacao.java.

## Execução 

Após a execução da classe de teste via Junit esse é o resultado esperado:
<img align="left" width="80%" height="80%" src="/sienge_prints/Junit_1.png">
