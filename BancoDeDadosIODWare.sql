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
saidas varchar(100)
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
multiThread boolean
);

create table ram(
id_ram int primary key,
nome varchar (50),
geracao varchar(5),
clock int,
tamanho int

);