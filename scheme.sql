-- Criação da tabela 'livros'
CREATE TABLE IF NOT EXISTS livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    isbn VARCHAR(50) NOT NULL UNIQUE,
    categoria VARCHAR(50) NOT NULL,
    status VARCHAR(20) DEFAULT 'disponivel'
);

-- Criação da tabela 'usuarios'
CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    tel VARCHAR(20),
    tipoUsuario ENUM('ALUNO', 'PROFESSOR') NOT NULL,
    senha VARCHAR(255) NOT NULL,
    
    livro1 VARCHAR(50) DEFAULT '',
    livro2 VARCHAR(50) DEFAULT '',
    livro3 VARCHAR(50) DEFAULT ''
);
