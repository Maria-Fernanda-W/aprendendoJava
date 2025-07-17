# First Spring App

Este é um projeto de **estudos** em **Spring Boot**, criado com base no vídeo da Fernanda Kipper - [Curso de Spring para Iniciantes](https://youtu.be/YY_hf0FOIcU?si=QQKso5abp4cVivg1) no YouTube.

O projeto tem como objetivo demonstrar conceitos iniciais de criação de APIs REST com Spring, injeção de dependência (via construtor e `@Autowired`) e configuração customizada.

## Tecnologias
- Java 17+

- Spring Boot

- Maven

- Lombock


## 📁 Estrutura do Projeto

```
📁 src
└── 📁 main
    ├── 📁 java
    |   └── 📁 com.mfw.first_spring_app
    |       ├── 📁 configuration
    |       |   └── HelloConfiguration            # Exp. config de obj externos para o Spring fazer o gerenciamento
    |       |
    |       ├── 📁 controller
    |       |   ├── HelloWorldController          # Exemplo de Get e Post
    |       |   ├── ServiceAutowiredController    # Exemplo Injeção de dependência via @Autowired
    |       |   └── ServiceConstrutorController   # Exemplo Injeção de dependência via Construtor
    |       |  
    |       ├── 📁 domain
    |       |   └── User                          # Exemplo de Classe com uso do Lombock
    |       |
    |       ├── 📁 service
    |       |   └── HelloWorldService             # Exemplo de Service 
    |       |
    |       └── FirstSpringAppApplication         # Arquivo de entrada do Spring
    |
    └── 📁 resource
        ├── application.properties                # Perfil de Configuração Padrão  
        └── application-dev.properties            # Exemplo de Perfil de Configuração Dev
```

## Como rodar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/first-spring-app.git
   cd first-spring-app
   ```

2. Compile e execute o projeto com Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Acesse os links:
   ```
   http://localhost:8080/hello-world
   http://localhost:8080/hello-world/hello
   http://localhost:8080/teste-service-autowired
   http://localhost:8080/teste-service-construtor
   ```

## Endpoints de exemplo

- GET `/teste-service-autowired` - Exemplo de injeção com `@Autowired`

- GET `/teste-service-construtor` - Exemplo de injeção por Construtor

- GET `/hello-world` – Retorna uma mensagem "Hello World"

- GET `/hello-world/hello` – Retorna uma mensagem "End-point /hello-world/hello"

- POST `/hello-world` - Recupera a informação do Body

- POST `/hello-world/{id}?filter=value` - Recupera a informação do Body, Path Variable e Path Parameter


## Autor

Maria Fernanda
