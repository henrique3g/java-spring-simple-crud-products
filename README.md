# java-spring-simple-crud-products 
Uma pequena aplicação, bem simples de um crud de produtos utilizando Java com Spring 

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/jhenriqueribeirodesa/)
[![Github](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/henrique3g)


## Requisitos para rodar a aplicação
 - Java 8+
 - Maven
 - Banco de dados (default: MySql)
 - Editor/IDE de sua preferência.

## Passos para executar
 - Faça o clone do projeto na sua máquina.
 - Abra o arquivo `application.properties` na pasta `src/main/resources/` e se estiver usando o MySql como banco, edite as seguintes configurações:
   - Substitua os valores entre chaves `{}` pelas configurações da sua máquina.
   - `spring.datasource.url=jdbc:mysql://{url_banco}:{porta_banco}/{nome_banco}` sendo que normalmente `url_banco` e `porta_banco` são `localhost` e `3306`;
   - `spring.datasource.username={usuario_banco}`, coloque o usuário do seu banco;
   - `spring.datasource.password={senha_banco}`, coloque a senha do seu banco;
   - Por padrão a aplicação vai rodar na porta `8083` se esta porta já estiver em uso ou quiser rodar em outra é só trocar;
 - Sua IDE tem suporte a Java?
   - Abra o projeto na IDE e provavelmente é só clicar no botão de `run` ou algo assim.
   - **OU** abra o terminal na pasta do projeto que você clonou e rode o seguinte comando `./mvnw spring-boot:run`;
   
   #### Fique a vontade para baixar e fazer oque quiser! E se quiser bater um papo é só chamar no [LinkedIn](https://www.linkedin.com/in/jhenriqueribeirodesa/)
