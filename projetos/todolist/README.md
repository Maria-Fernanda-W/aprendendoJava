# 📝 Todo List

Uma aplicação RESTful de lista de tarefas (Todo List), desenvolvida com Spring Boot. Permite o gerenciamento de usuários e tarefas, com persistência em banco de dados H2 em memória.

Aprimoramento do projeto desenvolvido em estudos/todolist

❗Em desenvolvimento

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring JDBC
- H2 Database
- Lombok

## ⚙️ Como Executar o Projeto Localmente

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/Maria-Fernanda-W/aprendendoJavaPrivate.git
   ```

2. **Abra o projeto em sua IDE (IntelliJ, Eclipse, VSCode, etc.)**
caminho: aprendendoJavaPrivate/projetos/todolist

3. **Execute a aplicação:**
    - Via IDE: Rode a classe `TodolistApplication.java`
    - Via terminal:
      ```bash
      ./mvnw spring-boot:run
      ```

4. **Acesse o banco H2 (opcional):**
    - URL: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    - JDBC URL: `jdbc:h2:mem:todolist`
    - User: `admin`
    - Password: `admin`


## 📍 Endpoints Disponíveis

### 🙋 Usuários
- `POST /users` – Cria um novo usuário

### ✅ Tarefas

- `GET /tasks` – Lista todas as tarefas do usuário
- `POST /tasks` – Cria uma nova tarefa
- `PUT /tasks/{id}` – Atualiza uma tarefa
- `DELETE /tasks/{id}` – Apaga uma tarefa

> **Nota:** Autenticação simples (basic auth) baseada no usuário (implementação com filtro).


## 📂 Estrutura do Projeto

```
📁 main
├──📁 java
│   └──📁 br.com.mariafernanda.todolist 
│       ├──📁 config
│       │   ├── ExceptionHandlerController.java
│       │   └── FilterTaskAuth.java
│       │
│       ├──📁 controller
│       │   ├── TaskController.java
│       │   └── UserController.java
│       │
│       ├──📁 dto
│       │   ├── 📁 request
│       │   │   ├── TaskRequestDTO
│       │   │   └── UserRequestDTO
│       │   │
│       │   └── 📁 response
│       │       ├── TaskResponseDTO
│       │       └── UserResponseDTO
│       │ 
│       ├──📁 model
│       │   ├── TaskModel.java
│       │   └── UserModel.java
│       │ 
│       ├──📁 repository
│       │   ├── ITaskRepository.java
│       │   └── IUserRepository.java
│       │ 
│       ├──📁 service
│       │   ├── TaskService.java
│       |   └── UserService.java
│       │
│       ├──📁 utils
│       │   └── Utils.java
│       │
│       └── TodolistApplication.java
│       
└──📁 resources
    └── application.properties
```

## 👩‍💻 Autor

Desenvolvido por Maria Fernanda

## 📄 Licença

Este projeto está licenciado sob a licença MIT.
