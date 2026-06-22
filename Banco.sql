use AplicacaoClinicaVet;

create table Medicos
(
	id int not null primary key auto_increment,
    crmv int not null,
    nome varchar(50) not null,
    data_nascimento datetime not null,
    created_at datetime not null,
    email varchar(50),
    telefone varchar(50),
    ativo boolean
);

create table Donos
(
	id int not null primary key auto_increment,
    nome varchar(50) not null,
    telefone varchar(50) not null,
    cpf varchar(50) not null,
    data_nascimento datetime not null,
    created_at datetime not null,
    email varchar(50)
);

create table Procedimentos
(
	id int not null primary key auto_increment,
    nome varchar(50) not null,
    descricao varchar(50) not null,
    custo decimal(10,2) not null
);

create table Pets
(
	id int not null primary key auto_increment,
    nome varchar(50) not null,
    dono_id int not null,
    especie varchar(50) not null,
    raca varchar(50) not null,
    sexo varchar(30) not null,
    data_nascimento datetime not null,
    peso float,
    observacoes varchar(50),
    created_at datetime not null,
    
    constraint pertence_a foreign key(dono_id) references Donos(id)
);

create table Atendimentos
(
	id int not null primary key auto_increment,
    id_medico int not null,
    id_pet int not null,
    status varchar(50),
    motivo_visita text,
    diagnostico text,
    created_at datetime not null,
    
    constraint realizado_por foreign key(id_medico) references Medicos(id),
    constraint realizado_em foreign key(id_pet) references Pets(id)
);

create table Servicos
(
	id int not null primary key auto_increment,
    id_atendimento int not null,
    id_procedimento int not null,
    valor decimal(10,2),
    created_at datetime,
    
    constraint fornecido_em foreign key(id_atendimento) references Atendimentos(id),
    constraint realizou foreign key(id_procedimento) references Procedimentos(id)
);

drop table Servicos;
drop table Atendimentos;
drop table Pets;
drop table Procedimentos;
drop table Donos;
drop table Medicos;

Select * from Donos;
Select * from Pets;