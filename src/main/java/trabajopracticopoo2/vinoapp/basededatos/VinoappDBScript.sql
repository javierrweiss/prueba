--Para ejecutarse en remotemysql   NO OLVIDAR COMENTARIAR O DESCOMENTARIAR!!
--drop database if exists pg5dcP32qz;
--create database pg5dcP32qz;
--use pg5dcP32qz;

--Para ejecutarse en MariaDB o cualquier otro sql utilizando conexión localhost
drop database if exists VinoappDB;
create database VinoappDB;
use VinoappDB;

create table bodegas (
bodega_id int (10) AUTO_INCREMENT,
nombre_bodega varchar (45) NOT NULL,
pais varchar (35),
ubicacion varchar (45),
fundacion int (4),
PRIMARY KEY (bodega_id)
);

create table usuarios (
usuario_id int (10) AUTO_INCREMENT,
cuenta_usuario varchar(45) NOT NULL,
nombre varchar (35) NOT NULL,
apellido varchar (35) NOT NULL,
pais varchar (35) NOT NULL,
region varchar (45) NOT NULL,
ciudad varchar (45) NOT NULL,
email varchar (50) NOT NULL,
cod_postal varchar (12),
nota_de_cata varchar (2500),
PRIMARY KEY (usuario_id)
);

create table tiendas (
tienda_id int (10) AUTO_INCREMENT,
nombre_T varchar (45) NOT NULL,
pais varchar(35),
ciudad varchar (45) NOT NULL,
direccion varchar (45) NOT NULL,
pagina_web varchar (50),
PRIMARY KEY (tienda_id)
);

create table vinos (
vino_id int (10) AUTO_INCREMENT,
nombre varchar(40) NOT NULL,
cepas varchar (35),
color enum ('tinto','blanco','rosado') NOT NULL,
cosecha int (4) UNSIGNED NOT NULL,
categoria enum ('joven','reserva','gran_reserva','espumante_extrabrut','espumante_brut','espumante_sec','espumante_demisec','licoroso','late_harvest') NOT NULL,
enologo varchar (35),
bodega_id int (10),
terruno varchar (40),
PRIMARY KEY (vino_id),
FOREIGN KEY (bodega_id) REFERENCES bodegas (bodega_id)
);

create table premios (
premio_id int (10) AUTO_INCREMENT,
nombre_premio varchar(45) NOT NULL,
puntaje int (3) UNSIGNED,
medalla enum ('oro','plata','bronce'),
ano int (4) NOT NULL,
vino_id int (10),
PRIMARY KEY (premio_id),
FOREIGN KEY (vino_id) REFERENCES vinos (vino_id) 
);

create table rankings (
ranking_id int (10) AUTO_INCREMENT,
ranking enum ('r1','r2','r3','r4','r5'),
usuario_id int (10),
vino_id int (10),
tienda_id int (10),
PRIMARY KEY (ranking_id),
FOREIGN KEY (usuario_id) REFERENCES usuarios (usuario_id),
FOREIGN KEY (vino_id) REFERENCES vinos (vino_id),
FOREIGN KEY (tienda_id) REFERENCES tiendas (tienda_id)
);



-- Es necesario, con la intención de continuar y agrandar el proyecto, agregar una tabla puente
-- llamada notas de cata que registre la relacion entre nota_por_usuario y vino_id. Sería (vino_id (FK), usuario_id  (FK)
-- y nota_de_cata. Y habría que agregar la nota_de_cata_id en las tablas vino y usuario

