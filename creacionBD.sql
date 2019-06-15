use master
go

create database hamachiSushi
go

use hamachiSushi
go
create table Reserva(
	id int identity not null,
	nombre varchar(30) not null,
	apellidos varchar(30) not null,
	fecha date not null,
	hora varchar(4) not null,
	comensales int not null,
	nro_Contacto varchar(15) not null,
	correo varchar(30) not null
	)
go

create table Usuario(
	id int identity not null,
	nombre varchar(30) not null,
	apellidos varchar(30) not null,
	correo varchar(30) not null,
	area varchar(30) not null,
	contraseña varchar(30) not null
)
go

create table Postulante(
	id int identity not null,
	nombre varchar(30) not null,
	correo varchar(30) not null,
	nro_Contacto varchar(15) not null,
	descripcion varchar(100) not null
)
go
create table Empleado(
	codigoEmpleado varchar(10) not null,
	nombre varchar(30) not null,
	apellidos varchar(30) not null,
)
create table Contacto(
	idContacto int identity not null,
	nombre varchar(30) not null,
	correo varchar(30) not null,
	asunto varchar(20) not null,
	mensaje varchar(200) not null
)
