# Encurtador de URL

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

Desafio realizado onde era necessário implementar um serviço que permite encurtar URLs longas para torná-las mais compactas e fáceis de utilizar.

O link para desafio proposto se encontra [aqui](https://github.com/backend-br/desafios/blob/master/url-shortener/PROBLEM.md)

## Requisitos 

- Java 21
- Maven

## Instalação

**Clone o projeto e acesse a pasta**

```bash
git@github.com:matheusgmello/desafio-url-shortener.git
```

- Instale as dependências com o Maven.
- Suba a aplicação com o Maven via terminal (`mvn spring-boot:run`)
- Acesse (`http://localhost:8080`)

## Rotas

```bash

POST /encurta-ai 

{
  "urlOriginal":"https://translate.google.com/"
}

```

```bash

GET /r/{urlEncurtada}

```

## Tecnologias
- [Java](https://docs.oracle.com/en/java/javase/17/)
- [Spring](https://spring.io/projects/spring-boot/) 


## Conecte-se comigo
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/matheusgmello)
[![Reddit](https://img.shields.io/badge/Reddit-%23FF4500.svg?style=for-the-badge&logo=Reddit&logoColor=white)](https://www.reddit.com/user/math7zw)
[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/matheusgmello/)