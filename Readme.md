## FIAP Postech Software Architecture - modulo 1

### API Backend do tech challenge 

Pré requisitos para construir e executar a aplicação:

- Java 17
- Apache maven 3.8.2
- Docker 

Etapas para construir a aplicação e imagem do docker:
- A partir do diretório raiz do projeto executar os seguintes comandos no terminal:
- Executar o comando do maven para construir aplicação
`mvn clean package`
- Após o build da aplicação concluído, executar o comando do docker para construir a imagem da aplicação
`docker build -t postech-soat-modulo-1 .`
- Com o build da imagem docker concluído executar o comando do docker compose para iniciar a imagem gerada junto com o container do postgresql que será utilizado como banco de dados. `docker-compose -f ./docker/docker-compose.yml up`