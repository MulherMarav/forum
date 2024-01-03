CREATE TABLE topico(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensagem VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    status VARCHAR(255) NOT NULL,
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuario (id),
    FOREIGN KEY (curso_id) REFERENCES curso (id)
);