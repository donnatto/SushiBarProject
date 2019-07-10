use master
go

create database hamachiSushi
go

use hamachiSushi
go


create table Reserva(
	id int identity (1,1) primary key,
	nombre varchar(30) not null,
	apellidos varchar(30) not null,
	fecha date not null,
	hora varchar(6) not null,
	comensales int not null,
	nro_Contacto varchar(15) not null,
	correo varchar(30) not null,
	estado int not null
	)
go


create table Usuario(
	id int identity (1,1) primary key,
	nombre varchar(30) not null,
	apellidos varchar(30) not null,
	correo varchar(30) not null,
	area varchar(30) not null,
	contraseña varchar(30) not null
)
go


create table Postulante(
	id int identity (1,1) primary key,
	nombre varchar(30) not null,
	correo varchar(30) not null,
	nro_Contacto varchar(15) not null,
	descripcion varchar(100) not null
)
go

create table Empleado(
	codigoEmpleado varchar(12) primary key,
	nombre varchar(30) not null,
	apellido varchar(30) not null
)
go

create table Contacto(
	idContacto int identity (1,1) primary key,
	nombre varchar(30) not null,
	correo varchar(30) not null,
	asunto varchar(20) not null,
	mensaje varchar(400) not null
)
