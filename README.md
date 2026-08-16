<h1 align="center">🎬 FluxPlay</h1>

<p align="center">
  Plataforma de streaming fullstack, desenvolvida individualmente
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
  <img src="https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white" />
  <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" />
  <img src="https://img.shields.io/badge/Keycloak-4D4D4D?style=for-the-badge&logo=keycloak&logoColor=white" />
</p>

---

## 📖 Sobre o projeto

O **FluxPlay** é uma plataforma de streaming fullstack, desenvolvida individualmente, com um catálogo de filmes e séries organizado por gênero.
Fui responsável por todo o desenvolvimento: **backend, frontend e banco de dados**.

A interface conta com:
- Banner de conteúdo em destaque na página inicial
- Catálogo de **Filmes** e **Séries** navegável por gênero
- Autenticação de usuário via Keycloak (login/logout)

---

## 🖼️ Demonstração

<!-- Suba o print na pasta do repo (ex: /docs/screenshot-home.png) e referencie o caminho relativo, ou use um link de imagem externo -->
<p align="center">
  <img src="docs/screenshot-home.png" width="80%" alt="Tela inicial do FluxPlay com catálogo de filmes e séries" />
</p>

---

## 🛠️ Tecnologias utilizadas

**Backend**
- Java + Maven
- PostgreSQL, com versionamento de banco via Flyway migrations
- Autenticação e segurança com Keycloak
- Hash de senha com BCrypt

**Frontend**
- TypeScript
- SCSS

---

## ⚙️ Funcionalidades

- [x] Autenticação de usuários (login/logout via Keycloak)
- [x] Página inicial com conteúdo em destaque
- [x] Catálogo de filmes organizado por gênero
- [x] Catálogo de séries organizado por gênero
<!-- Adicione mais conforme o projeto crescer: reprodução de mídia, busca, favoritos, etc -->

---

## 🚀 Como rodar o projeto

```bash
# clone o repositório
git clone https://github.com/Whitneycts/fluxplay.git
cd fluxplay

# backend (Maven wrapper já incluso no projeto)
./mvnw spring-boot:run

# frontend
cd frontend
npm install
npm start
```

<!-- Ajuste os comandos conforme o setup real (variáveis de ambiente, docker, etc) -->

---

## 👩‍💻 Sobre o desenvolvimento

Projeto individual, desenvolvido do zero como parte de [contexto do projeto — disciplina, curso, estudo pessoal, etc].
Responsável por todas as etapas:
- Backend (Java, Maven, integração com PostgreSQL e Keycloak)
- Frontend (TypeScript, SCSS)
- Modelagem e versionamento do banco de dados

<!-- Detalhe mais se quiser: "implementei a tela de X", "fiz a API de Y", etc -->
