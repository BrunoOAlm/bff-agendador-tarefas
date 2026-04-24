# 🔗 BFF - Agendador de Tarefas

Projeto backend desenvolvido em Java com Spring Boot atuando como camada BFF (Backend For Frontend) para o sistema de Agendador de Tarefas.

---

## 📌 Sobre o projeto

Este projeto tem como objetivo centralizar e orquestrar as requisições entre o frontend e os microsserviços do sistema de Agendador de Tarefas.

Ele atua como uma camada intermediária (BFF), responsável por simplificar o consumo das APIs e reduzir o acoplamento entre o frontend e os serviços internos.

---

## 📌 Responsabilidades do BFF

- Centralizar chamadas para os microsserviços
- Expor endpoints unificados para o frontend
- Orquestrar autenticação e operações do sistema
- Propagar o token JWT entre os serviços
- Reduzir a complexidade do frontend
- Melhorar a organização da arquitetura distribuída

---

## 📌 Arquitetura

O projeto segue o padrão BFF (Backend For Frontend), integrado a uma arquitetura de microsserviços:

Frontend → BFF → Microsserviços (Usuários / Tarefas / Notificações)

---

## 📌 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Security
- JWT (autenticação)
- OpenFeign (comunicação entre serviços)
- Maven
- Git / GitHub

---

## 📌 Funcionalidades

- Autenticação de usuários via JWT
- Cadastro de usuários (proxy para serviço de usuários)
- Gerenciamento de tarefas via microsserviço de tarefas
- Comunicação entre serviços via OpenFeign
- Encapsulamento da lógica de integração
- API unificada para o frontend

---

## 📌 Estrutura do projeto
