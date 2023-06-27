## PosTech Software Architecture

Projeto do tech challenge para avaliação do módulo 1 do curso Software Architecture.

### Api backend

Api backend contendo os endpoints que representam todo o processo. Foi utilizada a linguagem Java junto com o Framework Spring boot. Os seguintes pré requisitos são necessários para construir e executar a aplicação:

- Java 17
- Apache maven 3.8.2
- Docker 

A primeira etapa consiste em gerar o build da api backend. Para esta etapa é necessário, a partir do diretório raiz do projeto, executar o seguinte comando maven no terminal:
`mvn clean package`

### Dockerfile e Docker Compose para execução da api com o banco de dados.

Com o build da api backend concluído, as etapas para construção da imagem e execução do docker compose podem ser realizadas com os seguintes comandos a partir da raiz do projeto: 

- Comando do docker para construir a imagem da aplicação
  `docker build -t postech-soat-modulo-1 .`
- Comando do docker compose responsável por iniciar as imagens da api backend junto da imagem do postgresql, que será utilizado como banco de dados. `docker-compose -f ./docker/docker-compose.yml up`

## Acesso a documentação da api (Swagger)

Com a api e o banco de dados iniciados, podemos acessar a documentação da api a partir do endereço ***[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)***
