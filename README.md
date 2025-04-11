# 📚 Sistema de Gerenciamento de Biblioteca

Este é um projeto em Java que simula o funcionamento básico de uma biblioteca. Permite o cadastro de livros e usuários, empréstimo e devolução de exemplares, com controle de disponibilidade e relatórios simples.

## 🔧 Tecnologias Utilizadas

- Java SE
- Swing (Interface Gráfica)
- MySQL (Banco de Dados)
- JDBC (Conexão com o banco)
- Eclipse IDE

## 🧠 Conceitos aplicados

- Orientação a Objetos (POO)
- Padrão de Arquitetura MVC
- Manipulação de banco de dados com JDBC
- Interface gráfica com Swing
- Validação de dados e regras de negócio

## 🎯 Funcionalidades

- Cadastro de livros e usuários
- Empréstimo e devolução de livros
- Relatórios de:
  - Livros disponíveis
  - Livros emprestados
  - Livros atrasados
- Controle de limite de empréstimos por usuário

## 💾 Banco de Dados

O sistema usa MySQL como banco de dados relacional.

### 🔌 Configuração do banco:

1. Instale o MySQL Server
2. Crie o banco com o nome desejado (ex: `biblioteca`)
3. Execute o script SQL fornecido em `/database` para criar as tabelas
4. Configure os dados de acesso no seu código Java:
   ```java
   String url = "jdbc:mysql://localhost:3306/biblioteca";
   String user = "seu_usuario";
   String password = "sua_senha";
