create database iodware;

use iodware;

create table placaVideo(
id_gpu int primary key,
nome varchar(100),
memoria varchar(5),
clock int,
modelo varchar(50),
slot varchar(20), 
ventoinhas int,
saidas varchar(100),
pdu int
);

create table placaMae(
id_mobo int primary key,
nome varchar(100),
modelo varchar(50),
socket varchar(10),
slot_memo int,
slot_pci int,
saidas varchar(100)
);

create table fonte(
id_psu int primary key,
nome varchar (100),
watts int,
eightyplus varchar (20),
cabosSeisPinos int,
pfc boolean
);

create table cpu(
id_cpu int primary key,               	
nome varchar (100),
modelo varchar(50),
socket varchar (100),
clock int,	
cores int,
geracao varchar (30),
multiThread boolean,
pdu int
);

create table ram(
id_ram int primary key,
nome varchar (50),
geracao varchar(5),
clock int,
tamanho int
);

create table cpu_mb(
id_cpu_mb int primary key,
id_cpu int,
id_mb int,
foreign key (id_cpu) references cpu(id_cpu),
foreign key (id_mb) references placaMae(id_mobo)
);

create table gpu_mb(
id_gpu_mb int primary key,
id_gpu int,
id_mb int,
foreign key (id_gpu) references placaVideo(id_gpu),
foreign key (id_mb) references placaMae(id_mobo)
);

create table psu_mb(
id_psu_mb int primary key,
id_psu int,
id_mb int,
foreign key (id_psu) references fonte(id_psu),
foreign key (id_mb) references placaMae(id_mobo)
);

create table ram_mb(
id_ram_mb int primary key,
id_ram int,
id_mb int,
foreign key (id_ram) references ram(id_ram),
foreign key (id_mb) references placaMae(id_mobo)
);