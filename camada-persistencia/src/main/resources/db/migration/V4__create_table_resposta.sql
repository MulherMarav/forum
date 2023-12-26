create table resposta(
    id bigint not null auto_increment,
    mensagem varchar(255) not null,
    data_criacao timestamp not null,
    topico_id bigint not null,
    autor_id bigint not null,
    solucao bit(1) not null,
    primary key (id),
    foreign key (topico_id) references topico (id),
    foreign key (autor_id) references usuario (id)
);