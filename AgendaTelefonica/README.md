# 📒 Agenda Telefônica

Este projeto é uma aplicação de linha de comando desenvolvida em **Java** que permite ao usuário
criar e gerenciar múltiplas agendas de contatos. Cada agenda armazena uma lista de contatos com
nome e telefone oferecendo uma forma simples e prática de organizar informações pessoais.

## 🎯 Objetivo

Aplicar os fundamentos da **Programação Orientada a Objetos (POO)** em um projeto real, estruturando
o código em camadas (`model` e `service`) e simulando funcionalidades comuns a sistemas de agenda
ou contato.

## 📂 Estrutura do Projeto

```
📁src
├── 📁model
│   └── Contato.java             # Representa um contato com nome, telefone
│
├── 📁service
│   ├── Agenda.java              # Representa uma agenda com uma lista de contatos
│   └── GerenciadorAgendas.java  # Gerencia múltiplas agendas
│
└── Main.java                    # Classe principal com o menu de interação com o usuário
```

## ✅ Funcionalidades

- Criar novas agendas telefônicas
- Listar todas as agendas existentes
- Adicionar, remover e pesquisar contatos
- Listar contatos de uma agenda específica
- Interface em linha de comando (CLI) para navegação por menus

## 💻 Tecnologias Utilizadas

- **Java SE** (Java Standard Edition)
- `Scanner` para entrada de dados via terminal
- `ArrayList` para estrutura de armazenamento
- Organização em pacotes (`model` e `service`)

## 🧠 Conceitos Praticados

- Programação Orientada a Objetos (POO)
    - Encapsulamento
    - Composição de classes
    - Separação de responsabilidades
- Modularização com pacotes
- Estruturas de repetição e decisão
- Interação com o usuário via console
- Boas práticas de organização e leitura de código

## 🚀 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/Maria-Fernanda-W/aprendendoJava.git
   ```
2. Abra o projeto em sua IDE Java favorita (IntelliJ, Eclipse, VSCode, etc.)
3. Navegue até o diretório `src` e execute a classe `Main.java`.

## 🧑‍💻 Autora

Desenvolvido por **Maria Fernanda W.**

Projeto criado para fins de aprendizado e portfólio.

## 📄 Licença

Este projeto é de autoria exclusiva de Maria Fernanda W.  
Não é permitida a reprodução total ou parcial sem a devida autorização.