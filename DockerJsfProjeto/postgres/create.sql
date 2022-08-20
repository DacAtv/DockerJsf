CREATE TABLE livro(
    id serial PRIMARY KEY,
    titulo VARCHAR(80),
    dataDeLancamento DATE
);
CREATE TABLE editora(
    codigo SERIAL PRIMARY KEY,
    localDeOrigem VARCHAR(100),
    nomeFantasia VARCHAR(100)
);