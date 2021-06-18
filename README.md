# OctoEvents
É uma APIRest que através de endpoint incluido no WebHooks do Github, salva os eventos que são disparados, mas especificamente as issues abertas e fechadas.

## Motivação
Este projeto foi desenvolvido com objetivo de avaliação do team da jayatech.

## Tecnologias / Frameworks
- Spring Webflux
- Java
- MongoDB (MongoDB Atlas)
- Ngrok
- Github
- Swagger

## Passo a passo
### MongoDB
- O projeto foi criado com conexão ao MongoDB, e foi usado o MongoDB Atlas como repositorio de dados.

    #### Passos para instalação e conexão:
    - É necessario ter uma conta no MongoDB Atlas:
        - Link para criação de conta: https://account.mongodb.com/account/login
    - Após a criação da conta, você deve criar um cluster:
    - Com o cluster criado, clique em **CONNECT**, para obter a string de conexão. Essa string de conexão deve ser inserida no arquivo **aplication.properties** do projeto.
    - Pode ser usado para visualização dos dados o MongoDB Compass. 
        - Link para download: https://www.mongodb.com/try/download/compass

### Ngrok
- É uma poderosa ferramenta que cria túneis entre portas da sua máquina local e os servidores dele, o que possibilita outras pessoas acessarem o que quer que esteja naquela porta que disponibilizamos.(trecho retirado do site https://www.conectaai.com/ onde também tem um tutorial para instalação)
    #### Passos para instalação e conexão;
        1 - Criar conta em https://ngrok.com/
        2 - Download do ngrok;
        3 - Unzip para instalar - unzip /path/to/ngrok.zip
        4 - Autenticação com o token obtido no site: ./ngrok authtoken {token}
        5 - Rodar o ngrok: ./ngrok http 80

## Como usar
1 - Subir DB;
2 - Rodar aplicação;
3 - Rodar o ngrok: ./ngrok http {porta}
4 - Copiar o Web Interface gerado pelo ngrok
5 - Criar ou escolher um repositorio do github
6 - Vá em Settings>>Webhooks>>Add webhooks e cole o link do item 4 acrescentando /issues.
- **Exemplo: http://ad060548be7f.ngrok.io/issues**

7 - Ao criar ou fechar uma issue, a aplicação vai salvar os eventos do github.
8 - Para consultar as issues usar /issues/{number}/events
- **Exemplo: http://localhost/issues/{number}/events**


## Endpoints criados
    POST /issues
    GET /issues/{number}/events
