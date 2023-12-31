create table topico(
    id bigint not null auto_increment,
    titulo varchar(255) not null,
    mensagem varchar(255) not null,
    data_criacao timestamp not null,
    status varchar(255) not null,
    curso_id bigint not null,
    autor_id bigint not null,
    primary key (id),
    foreign key (curso_id) references curso (id),
    foreign key (autor_id) references usuario (id)
);