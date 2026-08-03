# 🥋 DojoSys API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)

## 📌 Sobre o Projeto
O **DojoSys** é um sistema completo (API REST + Interface Web) desenvolvido para gerenciar os alunos de um dojo de judô. 

Este projeto foi construído como um laboratório prático para explorar e consolidar conceitos fundamentais do desenvolvimento de software. O backend foi focado em uma arquitetura limpa em camadas (Controller, Service, Repository) utilizando **Java e Spring Boot**, enquanto o frontend foi desenhado para consumir essa API de forma assíncrona.

## 🚀 O que foi desenvolvido

### ⚙️ Backend (API REST)
Uma estrutura CRUD completa (Criar, Ler, Atualizar e Deletar) com as seguintes rotas:
* `POST /judocas`: Cadastra um novo aluno.
* `GET /judocas`: Lista todos os atletas matriculados.
* `GET /judocas/{id}`: Busca os detalhes de um aluno específico.
* `PUT /judocas/{id}`: Atualiza informações como troca de faixa ou alteração de peso.
* `DELETE /judocas/{id}`: Remove um registro do sistema.

**Destaque da API:** Foram aplicadas regras de negócio simples na camada de serviço (como impedir o cadastro de atletas sem nome ou com peso zerado/negativo) e o tratamento de erros para retornar o *Status Code* HTTP adequado em caso de falha.

### 🖥️ Frontend (Interface Web)
Para interagir com a API, foi construída uma interface de usuário simples e responsiva:
* **Layout:** Formulários estruturados utilizando **CSS Grid** (organização em colunas) para uma experiência de usuário mais limpa e intuitiva.
* **Navegação em Abas:** Sistema de abas dinâmicas para alternar entre as opções de Matricular, Listar, Atualizar e Apagar alunos.
* **Integração:** Comunicação com o backend realizada de forma assíncrona utilizando **JavaScript (Fetch API)**.

## 💾 Banco de Dados e Relacionamentos (MySQL)
O sistema utiliza o **MySQL** para o armazenamento relacional. Com a ajuda do **Spring Data JPA (Hibernate)**, o mapeamento objeto-relacional (ORM) cuida da criação e gestão das tabelas.

A modelagem do banco de dados (`judodb`) foi estruturada utilizando relacionamentos, separando as entidades para manter a normalização:

* **`tb_faixas`**: Tabela independente que armazena os dados das graduações (ex: Branca, Cinza, Azul).
* **`tb_judocas`**: Tabela principal de alunos. 
    * Possui as colunas de dados do atleta (`id`, `nome`, `idade`, `peso`).
    * **Chave Estrangeira (Foreign Key):** Contém uma coluna que faz referência direta à `tb_faixas`, garantindo a integridade referencial de que todo aluno está vinculado a uma faixa válida do sistema.

## 🛠️ Tecnologias Utilizadas
**Backend:**
* **Java**
* **Spring Boot** (Spring Web, Spring Data JPA)
* **MySQL** para o banco de dados relacional
* **Maven** para gerenciamento de dependências

**Frontend:**
* **HTML5 & CSS3** (Utilizando CSS Grid Layout e Flexbox)
* **JavaScript** (Fetch API para requisições HTTP)

## 👨‍💻 Autor
Desenvolvido por **Maicon Oliveira de Freitas**
