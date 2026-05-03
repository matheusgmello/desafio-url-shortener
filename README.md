# URL Shortener

API backend para encurtamento de URLs com redirecionamento HTTP, persistência em PostgreSQL e documentação OpenAPI via Swagger UI.

Este repositório foi desenvolvido como solução para o desafio técnico de encurtador de URLs proposto pela comunidade backend-br. O foco do projeto está em uma implementação backend simples, objetiva e fácil de avaliar em contexto de portfólio.

Desafio de referência: [backend-br/url-shortener](https://github.com/backend-br/desafios/blob/master/url-shortener/PROBLEM.md)

## Status do projeto

Status atual: concluído como desafio técnico, com escopo enxuto e funcional.

O projeto já implementa o fluxo principal de encurtamento e redirecionamento, mas ainda tem espaço para evoluções em validação, observabilidade e estratégia de testes.

## Funcionalidades implementadas

- Criar uma URL encurtada a partir de uma URL original
- Persistir links encurtados em banco PostgreSQL
- Redirecionar acessos para a URL original via rota pública
- Expor documentação interativa da API com Swagger UI

## Stack utilizada

- Java 21
- Spring Boot 3.3.2
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven Wrapper
- springdoc-openapi / Swagger UI
- Apache Commons Lang
- JUnit 5
- Docker Compose

## Arquitetura e estrutura

O projeto segue uma estrutura simples em camadas, concentrada no domínio de links:

- `controller`: recebe as requisições HTTP e monta a resposta da API
- `service`: concentra a regra de encurtamento e recuperação da URL original
- `repository`: acesso aos dados com Spring Data JPA
- `entity`: mapeamento da tabela `links`
- `response`: objeto de resposta retornado no endpoint de criação

Estrutura principal:

```text
src
├── main
│   ├── java/dev/matheus/url_shortener
│   │   ├── UrlShortenerApplication.java
│   │   └── links
│   │       ├── Link.java
│   │       ├── LinkController.java
│   │       ├── LinkRepository.java
│   │       ├── LinkResponse.java
│   │       └── LinkService.java
│   └── resources
│       └── application.properties
└── test
    └── java/dev/matheus/url_shortener
        └── UrlShortenerApplicationTests.java
```

## Fluxo principal

1. O cliente envia uma URL original para `POST /encurta-ai`.
2. O serviço gera um identificador alfanumérico aleatório.
3. O link é salvo no PostgreSQL.
4. A API devolve a URL encurtada no formato `http://localhost:8080/r/{codigo}`.
5. Ao acessar `GET /r/{codigo}`, a aplicação busca o registro no banco e responde com redirecionamento para a URL original.

## Endpoints principais

### `POST /encurta-ai`

Cria um novo link encurtado.

Exemplo de requisição:

```json
{
  "urlOriginal": "https://translate.google.com/"
}
```

Exemplo de comportamento da resposta:

- Retorna `201 Created`
- Informa a URL original
- Informa a URL encurtada de redirecionamento
- Informa a data de criação

### `GET /r/{urlEncurtada}`

Redireciona para a URL original salva no banco.

- Retorna redirecionamento HTTP quando o código existe
- Retorna `404` quando o código não é encontrado

## Documentação da API

Com a aplicação em execução, a documentação interativa fica disponível em:

- `http://localhost:8080/swagger-ui/index.html`
- `http://localhost:8080/v3/api-docs`

## Como rodar localmente

### Pré-requisitos

- Java 21
- Docker e Docker Compose, se quiser subir o PostgreSQL por container

### 1. Subir o banco de dados

O repositório já inclui um `docker-compose.yml` para o PostgreSQL:

```bash
docker compose up -d
```

Configuração atual do container:

- banco: `url-shortener`
- usuário: `admin`
- senha: `admin`
- porta: `5432`

### 2. Rodar a aplicação

No Windows:

```bash
mvnw.cmd spring-boot:run
```

No Linux/macOS:

```bash
./mvnw spring-boot:run
```

Aplicação disponível em:

- `http://localhost:8080`

## Configuração de ambiente

Atualmente a conexão com o banco está definida diretamente em `src/main/resources/application.properties`, com foco em desenvolvimento local:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/url-shortener
spring.datasource.username=admin
spring.datasource.password=admin
```

Para uso fora do ambiente local, o ideal é sobrescrever essas configurações por variáveis de ambiente do Spring Boot, por exemplo:

```bash
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/url-shortener
SPRING_DATASOURCE_USERNAME=admin
SPRING_DATASOURCE_PASSWORD=admin
```

## Docker

O repositório possui apenas `docker-compose.yml` para o banco PostgreSQL.


## Banco de dados

- Banco utilizado: PostgreSQL
- A persistência é feita com Spring Data JPA
- A entidade principal é `Link`, mapeada para a tabela `links`

Campos persistidos na entidade:

- `id`
- `urlLonga`
- `urlEncurtada`
- `urlQrCode`
- `urlCriadaEm`
