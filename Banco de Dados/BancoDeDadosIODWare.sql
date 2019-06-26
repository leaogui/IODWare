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



insert into placaVideo values
(1,"GTX 1050","2GB",1455,"1050","pci 3.0",1,"2 HDMI 1 DVI",75),
(2,"GTX 1050 TI","4GB",1392,"1050 ti","pci 3.0",2,"2 HDMI 1 DVI",75),
(3,"GTX 1060","3GB",1708,"1060","pci 3.0",2,"2 HDMI 1 DVI 1 DP",120),
(4,"GTX 1070","8GB",1920,"1070","pci 3.0",2,"2HDMI 1DVI 1DP",150),
(5,"GTX 1080","8GB",1733,"1080","pci 3.0",2,"2 HDMI 2 DP",180);

insert into cpu values
(1,"Intel Core I5 8400","i5","1151",4,6,"8",false,65),
(2,"Intel Core I7 8700","i7","1551",4,6,"8",true,65),
(3,"Ryzen 5 2600","r5","am4",4,6,"zen 2",true,65),
(4,"Ryzen 7 2700","r7","am4",4,8,"zen 2",true,64);

insert into ram values
(1,"Pente 4gb","DDR4",2400,4),
(2,"Pente 8gb","DDR4",2400,8),
(3,"Pente 16gb","DDR4",2400,16);

insert into placaMae values
(1,"h310","h310","1551",2,1,"4 USB 3.0"),
(2,"b360","b360","1551",4,2,"6 USB 3.0"),
(3,"z370","z370","1551",8,3,"4 USB 3.0, 2 USB 3.1"),
(4,"a320","a320","am4",2,1,"4 USB 3.0"),
(5,"b350","b350","am4",4,2,"6 USB 3.0"),
(6,"x370","x370","am4",8,3,"4 USB 3.0, 2 USB 3.1");


insert into fonte values
(1,"400 Watts",400,"bronze",2,true),
(2,"500 Watts",500,"silver",2,true),
(3,"600 Watts",600,"gold",3,true);