create database Almacen2023;
go
use Almacen2023 ;
go
select * from Personal;
create table Personal(
  codigo varchar(10) primary key  not null,
  nombre varchar(50),
  apellido varchar(50),
  edad  int,
  genero varchar(1),
  correo   varchar(150),
  direccion varchar(150),
  telefono  int ,
  fecha_ingreso  datetime2(7),
  fecha_salida  datetime2(7),
);
/**/
 INSERT INTO Personal (codigo, nombre, apellido, edad, genero, correo, direccion, telefono, fecha_ingreso, fecha_salida)
                          VALUES ('dfsdfsdf','sdfsd',
                          'ddasd',23,'M','FD', 'SDF',
                        23,'2023-07-14 23:38:55.54','2023-07-14 23:38:55.54');
/**/
create table Provedor(
   codigo varchar(10),
   nombre varchar(50),
   id_categoria int,
   nombre_Producto varchar(100),
   correo   varchar(150),
   direccion varchar(150),
   telefono  int ,
   fecha_ingreso  datetime2(7),
   fecha_salida  datetime2(7),
);
insert into Provedor(codigo,nombre,id_categoria,nombre_Producto,correo,direccion,telefono,fecha_ingreso,fecha_salida)
values('PRO0001','Empresa',1,'coca','jjdnajsn@jkdfn','mZlfld',213432,'2023-07-14 23:38:55.54', '2023-07-14 23:38:55.54');
insert into Provedor(codigo,nombre,id_categoria,nombre_Producto,correo,direccion,telefono,fecha_ingreso,fecha_salida)
values('PRO0001','Empresa',1,'Pepsi','jjdnajsn@jkdfn','mZlfld',213432,'2023-07-14 23:38:55.54', '2023-07-14 23:38:55.54');
insert into Categoria(nombre)values('Lactios')
insert into Categoria(nombre)values('CERIAL')
insert into Categoria(nombre)values('LEGUIAS')
select * from Categoria ;
create table Categoria(
  id int primary key identity not null,
  nombre varchar(20),
);
alter table AlmacenA5 add constraint fk_almacen5 foreign key(CodigoProvedor) references Provedor(codigo);
alter table AlmacenA4 add constraint fk_almacen4 foreign key(CodigoProvedor) references Provedor(codigo);
alter table AlmacenA3 add constraint fk_almacen3 foreign key(CodigoProvedor) references Provedor(codigo);
alter table AlmacenA2 add constraint fk_almacen2 foreign key(CodigoProvedor) references Provedor(codigo);
alter table AlmacenA1 add constraint fk_almacen1 foreign key(CodigoProvedor) references Provedor(codigo);
alter table Provedor add constraint fk_Categoria FOREIGN KEY(id_categoria) REFERENCES Categoria(id) ;

ALTER TABLE Proveedor
ADD CONSTRAINT fk_Categoria FOREIGN KEY (id_categoria)
REFERENCES CATEGORIA(id);


drop table Personal;
insert into Provedor(id,codigo,nombre_Producto)values(1,'1234A','coca');
insert into Provedor(id,codigo,nombre_Producto)values(2,'1234A','pepsi');
insert into Provedor(id,codigo,nombre_Producto)values(3,'1234A','guarana');
/*
Sector cerial A1
Sector legunbres A2
Sector fluidos A3
Sector Detergente A4
Sector snack A5
*/
select * from AlmacenA1;
create table AlmacenA1(
  id int primary key identity not null,
  CodigoProvedor varchar(10),
  codigo varchar(10),
  nombre varchar(50),
  cantidad int,
  precioUnitario float,
  precioporDocena float,
  fecha_Entrada  datetime2(7),
  fecha_Limite   datetime2(7),
);
create table AlmacenA2(
  id int primary key identity not null,
  CodigoProvedor varchar(10),
  codigo varchar(10),
  nombre varchar(50),
  cantidad int,
  precioUnitario float,
  precioporDocena float,
  fecha_Entrada  datetime,
  fecha_Limite   datetime,
);
create table AlmacenA3(
  id int primary key identity not null,
  CodigoProvedor varchar(10),
  codigo varchar(10),
  nombre varchar(50),
  cantidad int,
  precioUnitario float,
  precioporDocena float,
  fecha_Entrada  datetime,
  fecha_Limite   datetime,
);
create table AlmacenA4(
  id int primary key identity not null,
  CodigoProvedor varchar(10),
  codigo varchar(10),
  nombre varchar(50),
  cantidad int,
  precioUnitario float,
  precioporDocena float,
  fecha_Entrada  datetime,
  fecha_Limite   datetime,
);
create table AlmacenA5(
   id int primary key identity not null,
  CodigoProvedor varchar(10),
  codigo varchar(10),
  nombre varchar(50),
  cantidad int,
  precioUnitario float,
  precioporDocena float,
  fecha_Entrada  datetime,
  fecha_Limite   datetime,
);

drop table Usuarios;
CREATE TABLE Usuarios(
   id int PRIMARY KEY IDENTITY NOT NULL,
   idPersonal varchar(10) NOT NULL, -- Corrección del nombre de la columna
   usuarios varchar(40),
   contraseña varchar(30),
   id_TipoRol int, -- Agregar clave externa para la relación con Personal
);

create table Rol(
 id int primary key identity not null,
 nombre varchar(30)
);
alter table Usuarios add constraint fk_Rol foreign key(id_TipoRol) references Rol(id);
alter table Usuarios add constraint fk_Personall foreign key(idPersonal) references Personal(codigo); 
select * from Usuarios;
SELECT * FROM Usuarios WHERE usuarios = 'Anthony' AND contraseña = '1234';
insert into Rol(nombre)values('administrador');
insert into Rol(nombre)values('almacen');
insert into Rol(nombre)values('salida');
insert into Personal()values();
DELETE FROM Usuarios
WHERE id = 3;
insert into Usuarios(idPersonal,usuarios,contraseña,id_TipoRol) values('PRO0008','Brillight','1234',3);
insert into Usuarios(idPersonal,usuarios,contraseña,id_TipoRol) values('PRO0007','Anthony','1234',1);
insert into Usuarios(idPersonal,usuarios,contraseña,id_TipoRol) values('PRO0006','Jesus','1234',2);
select * from Usuarios where usuarios = 'Jesus' and contraseña = '1234' ;
select * from Usuarios where usuarios = 'Antoni' and contraseña = '1234' ;
/* codigo varchar(10) primary key  not null,
  nombre varchar(50),
  apellido varchar(50),
  edad  int,
  genero varchar(1),
  correo   varchar(150),
  direccion varchar(150),
  telefono  int ,
  fecha_ingreso  datetime2(7),
  fecha_salida  datetime2(7),
  */
  insert into Personal(codigo,nombre,apellido,edad,genero,correo,direccion,telefono,fecha_ingreso,fecha_salida)values('EXC0003','Brigt','laura',39,'1','juan@lg','Mz 09 pUENTE',423454,'2023-07-14 23:38:55.54','2023-07-14 23:38:55.54');
SELECT nombre_Producto FROM Provedor WHERE codigo = 'dsddsadf';

SELECT * FROM Usuarios ;
SELECT * FROM Personal;
/****/
SELECT  * 
FROM AlmacenA1
WHERE codigo = 'PRO0001';

UNION ALL

SELECT 'AlmacenA2' AS Almacen, id, CodigoProvedor, codigo, nombre, cantidad, precioUnitario, precioporDocena, fecha_Entrada, fecha_Limite
FROM AlmacenA2
WHERE codigo = 'PRO0001'

UNION ALL

SELECT 'AlmacenA3' AS Almacen, id, CodigoProvedor, codigo, nombre, cantidad, precioUnitario, precioporDocena, fecha_Entrada, fecha_Limite
FROM AlmacenA3
WHERE codigo = 'PRO0001'

UNION ALL

SELECT 'AlmacenA4' AS Almacen, id, CodigoProvedor, codigo, nombre, cantidad, precioUnitario, precioporDocena, fecha_Entrada, fecha_Limite
FROM AlmacenA4
WHERE codigo = 'PRO0001'

UNION ALL

SELECT 'AlmacenA5' AS Almacen, id, CodigoProvedor, codigo, nombre, cantidad, precioUnitario, precioporDocena, fecha_Entrada, fecha_Limite
FROM AlmacenA5
WHERE codigo = 'PRO0001';

