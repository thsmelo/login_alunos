CREATE DATABASE cadastro_alunos;
USE cadastro_alunos;

CREATE TABLE cursos (
    id_curso INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE alunos (
    id_aluno INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL,
    id_curso INT,
    FOREIGN KEY (id_curso) REFERENCES cursos(id_curso)
);

INSERT INTO cursos (nome)
VALUES ('ADS');

INSERT INTO cursos (nome)
VALUES ('ENG COMP');

INSERT INTO alunos (nome, email, data_nascimento, id_curso)
VALUES ('Lucas', 'lucasantonio@email.com', '2002-06-13', 1);

INSERT INTO alunos (nome, email, data_nascimento, id_curso)
VALUES ('Thiago', 'thiagomelo@email.com', '2003-11-19', 2);
