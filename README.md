# ecommerce

1ª - Os arquivos foram compilados para executar em localhost. 
2ª - As APIs são executadas na porta 8080 do apache tomcat. 

#### Exemplo da aplicação principal: 
 http://localhost:8080
#### Exemplo do microserviço de pedido:
 http://localhost:8080/pedido
#### Exemplo do microserviço de Produto:
 http://localhost:8080/produto

Visando Facilitar esta sendo utilizado banco de dados H2.
 ###### H2 Painel
  * url h2: http://localhost:8080/h2-console/
  * senha: 123
 
Tecnologias utilizadas no desenvolvimento.
BackEnd 
- Java 11
- Spring Boot 2.2 
- Spring Data JPA 
- Hibernate 
- Maven
- H2 
- Apache Tomcat 
FrontEnd 
- Angular
- Bootstrap

Para uma execução simples do projeto é necessario acessar a pasta **Final Project** descompactar.
 * Requisitos mínimos 
1. JDK 11
2. NodeJS

* A cesse a pasta ```Backend``` e execute o comando ```java -jar ecommerce-0.0.1.jar``` para executar o backend. </br>
  para executar o Frontend temos neste caso suas opção! Se possuir o NodeJs acesse a pasta **supera_front** e execute direto o comando ```ng serve``` ou ```npm start``` porta      padrão **http://localhost:4200/**.
  caso possua um servidor local (por exemplo Xampp ) acesse a pasta Final Project -> e copie os arquivos contidos em **Frontend** para a pasta ```htdocs``` ou para a pasta         ```www```do seu servidor (Acessar em sua porta padrão).
