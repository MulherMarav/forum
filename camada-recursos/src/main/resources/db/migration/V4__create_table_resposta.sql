CREATE TABLE resposta(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensagem VARCHAR(255) NOT NULL,
    data_criacao TIMESTAMP NOT NULL,
    topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    solucao BOOLEAN NOT NULL,
    FOREIGN KEY (topico_id) REFERENCES topico (id),
    FOREIGN KEY (autor_id) REFERENCES usuario (id)
);