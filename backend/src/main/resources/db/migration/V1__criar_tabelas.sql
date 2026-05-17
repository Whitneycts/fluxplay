CREATE TABLE conteudo (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    anoLancamento INT NOT NULL,
    urlImagem VARCHAR(255) NOT NULL
);

CREATE TABLE usuario (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(60) NOT NULL
);