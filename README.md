# 🥋 Judomenu API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)

## 📌 Sobre o Projeto
O **Judomenu** é uma API REST desenvolvida para gerenciar os alunos de um dojo de judô. 

Este projeto foi construído como um laboratório prático para explorar e consolidar conceitos fundamentais do desenvolvimento backend com **Java e Spring Boot**. O foco principal foi estruturar uma arquitetura limpa em camadas (Controller, Service, Repository) e compreender o fluxo de requisições web.

## 🚀 O que foi desenvolvido
Uma estrutura CRUD completa (Criar, Ler, Atualizar e Deletar) com as seguintes rotas:
* `POST /judocas`: Cadastra um novo aluno.
* `GET /judocas`: Lista todos os atletas matriculados.
* `GET /judocas/{id}`: Busca os detalhes de um aluno específico.
* `PUT /judocas/{id}`: Atualiza informações como troca de faixa ou alteração de peso.
* `DELETE /judocas/{id}`: Remove um registro do sistema.

**Destaque:** Foram aplicadas regras de negócio simples na camada de serviço (como impedir o cadastro de atletas sem nome ou com peso zerado/negativo) e o tratamento de erros para retornar o *Status Code* HTTP adequado em caso de falha.

## 💾 Banco de Dados (MySQL)
O sistema utiliza o **MySQL** para armazenar as informações de forma definitiva. Graças à integração com o **Spring Data JPA (Hibernate)**, não é necessário criar as tabelas manualmente no banco. 

Quando a aplicação é iniciada, ela automaticamente cria um banco de dados chamado `judodb` e gera a tabela `tb_judocas` com as seguintes colunas:
* `id`: Chave primária de auto-incremento.
* `nome`: Nome do atleta.
* `idade`: Idade do atleta em anos.
* `faixa`: Graduação atual do aluno (Ex: Branca, Cinza, Azul).
* `peso`: Peso do atleta em quilogramas (número decimal).

## 🛠️ Tecnologias Utilizadas
* **Java**
* **Spring Boot** (Spring Web, Spring Data JPA)
* **MySQL** para o banco de dados relacional
* **Maven** para gerenciamento de dependências
