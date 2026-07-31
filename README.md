# 🥋 DojoSys

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)

## 📌 Sobre o Projeto
O **DojoSys** é um sistema web desenvolvido para gerenciar os alunos de um dojo de judô. 

O que começou como um laboratório prático para consolidar conceitos de backend, evoluiu para uma aplicação Full-Stack. O projeto une o ciclo de aprendizado em Análise e Desenvolvimento de Sistemas com a rotina prática dos tatames, criando uma ferramenta real para acompanhar matrículas, controle de peso dos atletas e as progressões de graduação — desde a branca até a conquista da faixa azul e além.

## 🚀 O que foi desenvolvido
O sistema funciona através da comunicação fluida entre uma interface de usuário e uma API RESTful, divididas em:

### 🖥️ Frontend (Interface Web)
* **Interatividade:** Construída com **HTML** e **JavaScript** puro, utilizando a *Fetch API* para o consumo assíncrono das rotas do servidor.
* **Estilização:** **CSS** (em desenvolvimento) para garantir uma interface limpa, estruturada e amigável.
* **Funcionalidades:** Telas dedicadas para o usuário cadastrar, buscar, editar e deletar alunos dinamicamente, sem precisar recarregar a página.

### ⚙️ Backend (API REST)
Uma estrutura CRUD completa operando nos bastidores com **Java e Spring Boot**, organizada em uma arquitetura limpa (Controller, Service, Repository):
* `POST /judocas`: Cadastra um novo aluno.
* `GET /judocas`: Lista todos os atletas matriculados.
* `GET /judocas/{id}`: Busca os detalhes de um aluno específico.
* `PUT /judocas/{id}`: Atualiza informações como troca de faixa ou alteração de peso.
* `DELETE /judocas/{id}`: Remove um registro do sistema.

**Destaque:** Foram aplicadas regras de negócio na camada de serviço (como impedir o cadastro de atletas sem nome ou com peso zerado/negativo) e o tratamento de erros para retornar o *Status Code* HTTP adequado para o front-end em caso de falha.

## 💾 Banco de Dados (MySQL)
O sistema utiliza o **MySQL** para armazenar as informações de forma definitiva, aplicando conceitos de modelagem relacional. Graças à integração com o **Spring Data JPA (Hibernate)**, o mapeamento objeto-relacional (ORM) gerencia automaticamente a criação e o relacionamento das tabelas no banco `judodb`. 

A estrutura foi desenhada com tabelas interligadas para evitar redundância de dados:

**🥋 Tabela `tb_faixas` (Catálogo de Graduações):**
* `id`: Chave primária.
* `cor`: Descrição da cor da faixa (Ex: Branca, Cinza, Azul, etc.).

**🥋 Tabela `tb_judocas` (Atletas Matriculados):**
* `id`: Chave primária de auto-incremento.
* `nome`: Nome do atleta.
* `idade`: Idade do atleta em anos.
* `peso`: Peso do atleta em quilogramas (número decimal).
* `faixa_id`: **Chave Estrangeira (Foreign Key)**. Relaciona diretamente o atleta à sua respectiva graduação na tabela `tb_faixas`.

## 🛠️ Tecnologias Utilizadas

**Frontend:**
* HTML5
* JavaScript (ES6+)
* CSS3

**Backend:**
* Java
* Spring Boot (Spring Web, Spring Data JPA)
* Maven

**Banco de Dados:**
* MySQL
