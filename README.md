# 🥷 Cadastro de Ninjas

Sistema completo desenvolvido com **Spring Boot** para o gerenciamento de **Ninjas e Missões**, com API RESTful, interface web com **Thymeleaf**, persistência em banco de dados **H2**, e documentação automática via **Swagger UI**.

---

## 📌 Sobre o Projeto

Este projeto é uma aplicação Spring Boot desenvolvida para gerenciar o cadastro de ninjas e suas missões. Ele oferece uma API RESTful completa para operações CRUD (Create, Read, Update, Delete) em entidades de Ninja e Missão, além de uma interface de usuário simples baseada em Thymeleaf para a interação com os dados dos Ninjas. A aplicação utiliza um banco de dados em memória H2 para persistência de dados e Flyway para gerenciamento de migrações de esquema de banco de dados. A documentação da API é fornecida através do Swagger UI.

---

## ⚙️ Tecnologias Utilizadas

As principais tecnologias e ferramentas utilizadas neste projeto incluem:

*   **Java 17**: Linguagem de programação principal.
*   **Spring Boot**: Framework para facilitar o desenvolvimento de aplicações Java.
  *   `spring-boot-starter-web`: Para construção de aplicações web e APIs RESTful.
  *   `spring-boot-starter-data-jpa`: Para persistência de dados com JPA e Hibernate.
  *   `spring-boot-starter-thymeleaf`: Para o desenvolvimento do frontend com templates HTML.
  *   `spring-boot-starter-test`: Para testes da aplicação.
*   **Lombok**: Biblioteca que reduz a verbosidade do código Java, gerando automaticamente getters, setters, construtores, etc.
*   **H2 Database**: Banco de dados relacional em memória, ideal para desenvolvimento e testes.
*   **Flyway**: Ferramenta de migração de banco de dados para gerenciar e versionar o esquema do banco de dados.
*   **Springdoc OpenAPI (Swagger UI)**: Para gerar automaticamente a documentação da API e fornecer uma interface interativa para testá-la.
*   **JPA / Hibernate (Java Persistence API)**: Padrão para mapeamento objeto-relacional (ORM) em aplicações Java.
*   **Maven**: Ferramenta de automação de build e gerenciamento de dependências.

---

## 📎 Funcionalidades
O projeto oferece as seguintes funcionalidades principais:

### Gerenciamento de Ninjas

*   **Criação de Ninjas**: Adiciona novos ninjas ao sistema com informações como nome, email, idade, rank e URL da imagem.
*   **Listagem de Ninjas**: Recupera uma lista de todos os ninjas cadastrados.
*   **Busca de Ninja por ID**: Permite buscar um ninja específico utilizando seu identificador único.
*   **Atualização de Ninjas**: Modifica as informações de um ninja existente.
*   **Exclusão de Ninjas**: Remove um ninja do sistema.

### Gerenciamento de Missões

*   **Criação de Missões**: Adiciona novas missões ao sistema.
*   **Listagem de Missões**: Recupera uma lista de todas as missões cadastradas.
*   **Atualização de Missões**: Modifica as informações de uma missão existente.
*   **Exclusão de Missões**: Remove uma missão do sistema.

### Interface de Usuário (Thymeleaf)

*   **Adicionar Ninja**: Formulário para cadastrar novos ninjas.
*   **Listar Ninjas**: Página para visualizar todos os ninjas cadastrados.
*   **Detalhes do Ninja**: Página para visualizar detalhes de um ninja específico.

### Documentação da API

*   **Swagger UI**: Interface interativa para explorar e testar todos os endpoints da API RESTful.

---

## 🦾 Como Rodar o Projeto

Para rodar este projeto localmente, siga os passos abaixo:

1.  **Pré-requisitos**:
  *   Java Development Kit (JDK) 17 ou superior instalado.
  *   Maven instalado.

2.  **Clonar o Repositório**:

    ```bash
    git clone https://github.com/lucasaita1/CadastroDeNinjas.git
    cd CadastroDeNinjas
    ```

3.  **Compilar e Executar a Aplicação**:

    Você pode compilar e executar a aplicação usando Maven:

    ```bash
    mvn spring-boot:run
    ```

    A aplicação será iniciada e estará acessível em `http://localhost:8080`.

---


## 🏗️ Estrutura do Projeto

A estrutura principal do projeto é organizada da seguinte forma:

```
CadastroDeNinjas/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── dev/aluno/java10x/CadastroDeNinjas/
│   │   │       ├── CadastroDeNinjasApplication.java
│   │   │       ├── Missoes/
│   │   │       │   ├── MissaoController.java
│   │   │       │   ├── MissaoDTO.java
│   │   │       │   ├── MissaoMapper.java
│   │   │       │   ├── MissaoModel.java
│   │   │       │   ├── MissaoRepository.java
│   │   │       │   └── MissaoService.java
│   │   │       └── Ninjas/
│   │   │           ├── NinjaController.java
│   │   │           ├── NinjaControllerUi.java
│   │   │           ├── NinjaDTO.java
│   │   │           ├── NinjaMapper.java
│   │   │           ├── NinjaModel.java
│   │   │           ├── NinjaRepository.java
│   │   │           └── NinjaService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── db/
│   │       │   └── migrations/
│   │       │       ├── V2__Add_Rank_tb_cadastro.sql
│   │       │       └── V3__Add_imgUrl_tb_cadastro.sql
│   │       └── templates/
│   │           ├── adicionarNinja.html
│   │           ├── detalhesNinja.html
│   │           └── listarNinjas.html
│   └── test/
│       └── java/
│           └── dev/aluno/java10x/CadastroDeNinjas/
│               └── CadastroDeNinjasApplicationTests.java
├── pom.xml
└── mvnw
└── mvnw.cmd
```
---
## 🔍 Endpoints da API (Swagger UI)

Após iniciar a aplicação, você pode acessar a documentação interativa da API no Swagger UI através do seguinte link:

`http://localhost:8080/swagger-ui.html`

---
## 💻 Interface Web (Thymeleaf)

Após iniciar a aplicação, para acessar a interface do Thymeleaf front-end, use o seguinte link:

`http://localhost:8080/ninja/ui/listar`

---

## 🔧 Próximos Passos

- Integração com banco de dados real (PostgreSQL ou MySQL)
- Autenticação com Spring Security e JWT
- Testes automatizados com JUnit e Mockito
- Incorporação do Docker
- AWS e microsserviços 

---

## 📎 Autor

**Lucas Prates Aita**\
👨‍💻 [GitHub](https://github.com/lucasaita1) | 📧 [lucasaita4000@gmail.com](mailto\:lucasaita4000@gmail.com)

