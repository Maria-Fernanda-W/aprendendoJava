# 🧭 Projeto Labirinto em Java

Este projeto foi elaborada para faculdade, ele consiste na leitura e análise de
labirintos definidos em arquivos `.txt`, onde o objetivo é encontrar o caminho 
até o ponto de chegada.


## 📄 Como funciona

O labirinto é representado por um arquivo `.txt`, onde:
- `X` representa uma parede/barreira;
- `*` é usado como separador;
- Espaços em branco (`' '`) são caminhos possíveis;
- `D` representa o destino final.

***Obs.:*** O labirinto deve *<u>sempre</u>* começar um espaço em branco.

O programa carrega as informaçãoes do arquivo, armazena a estrutura do labirinto em memória e realiza a validação do caminho.

## 📁 Estrutura dos Arquivos
```
📁src
├── 📁arquivos                     # Pasta com arquivos com exemplos de labirintos
│   ├── labirinto_1.txt
│   ├── labirinto_2.txt
│   └── labirinto_3.txt
│
├── NullPointerException.java     # Classe personalizada de exceção
│
├── Labirinto.java                # Responsável por carregar e estruturar o labirinto
│
└── Main.java                     # Classe principal que inicia a execução
```

## ✅ Exemplo de entrada

Trecho de `labirinto_1.txt`:

```
 * *X*X*X*X*X*X*X*X*X* * *X*X*X*X*X*X*X*X
X* *X*X*X*X*X*X*X*X*X* *X* * * *X*X*X*X*X

[...]

X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*X*D*X
```

## 🚀 Como executar

1. Clone o repositório:
    ````bash
      git clone https://github.com/Maria-Fernanda-W/aprendendoJava.git
    ````
2. Abra o projeto Labirinto_LeituraDeArquivos em sua IDE Java favorita (IntelliJ, Eclipse, VSCode, etc.)
3. Navegue até o diretório src e execute a classe Main.java.


## 🧑‍💻 Autora

Desenvolvido por **Maria Fernanda W.**

Projeto criado para fins acadêmicos.
