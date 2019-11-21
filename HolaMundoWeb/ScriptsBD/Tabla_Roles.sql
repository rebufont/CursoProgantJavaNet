drop table permisos;
drop table roles_usuarios;
drop table roles;

create table roles(
	id			int				not null auto_increment
 , 	nombre		varchar(20)		not null 
 , primary key(id)
);

create table permisos
(
	id				int				not null auto_increment
 , 	id_rol			int				not null
 ,	nombre			varchar(10)		not null
 ,	objeto			varchar(20)		not null
 , primary key(id)
 , foreign key(id_rol) references roles(id)
);

create table roles_usuarios
(
	id			int				not null auto_increment
 ,	id_rol		int				not null
 ,	id_usuario	int				not null
 , primary key(id)
 , foreign key(id_rol) references roles(id)
 , foreign key(id_usuario) references usuarios(id)
);



select *
from usuarios;

insert into usuarios(usuario, password) values ('pepeusr', 'pepeusr');
insert into usuarios(usuario, password) values ('pacoope', 'pacoope');
insert into usuarios(usuario, password) values ('luisges', 'luisges');
insert into usuarios(usuario, password) values ('mariaadm', 'mariaadm');


select *
from roles_usuarios;

DELETE FROM ROLES;

insert into roles(nombre) values('Usuario');
insert into roles(nombre) values('Operario');
insert into roles(nombre) values('Gestor');
insert into roles(nombre) values('Administrador');

select distinct nombre, objeto
from permisos
order by 2, 1
;

insert into permisos(id_rol, nombre, objeto) values
((select r.id from roles r where r.nombre = 'Usuario'), 'ACCESO', 'PEDIDOS');

insert into permisos(id_rol, nombre, objeto) values
((select r.id from roles r where r.nombre = 'Operario'), 'ACCESO', 'ALMACEN');

insert into permisos(id_rol, nombre, objeto) values
((select r.id from roles r where r.nombre = 'Operario'), 'MODIFICAR', 'ALMACEN');

insert into permisos(id_rol, nombre, objeto) values
((select r.id from roles r where r.nombre = 'Gestor'), 'ACCESO', 'ALMACEN');

insert into permisos(id_rol, nombre, objeto) values
((select r.id from roles r where r.nombre = 'Gestor'), 'ACCESO', 'PEDIDOS');

insert into permisos(id_rol, nombre, objeto) values
((select r.id from roles r where r.nombre = 'Gestor'), 'MODIFICAR', 'ALMACEN');

insert into permisos(id_rol, nombre, objeto) values
((select r.id from roles r where r.nombre = 'Gestor'), 'ELIMINAR', 'ALMACEN');

insert into permisos(id_rol, nombre, objeto) values
((select r.id from roles r where r.nombre = 'Administrador'), 'ACCESO', 'ADMINISTRACION');

select *
from roles;

delete from roles where id = 4;

DELETE FROM roles_usuarios;

insert into roles_usuarios(id_rol, id_usuario) values(
	(select r.id from roles r where r.nombre = 'Usuario'),
    (select u.id from usuarios u where u.usuario = 'pepeusr')
);

insert into roles_usuarios(id_rol, id_usuario) values(
	(select r.id from roles r where r.nombre = 'Operario'),
    (select u.id from usuarios u where u.usuario = 'pacoope')
);

insert into roles_usuarios(id_rol, id_usuario) values(
	(select r.id from roles r where r.nombre = 'Gestor'),
    (select u.id from usuarios u where u.usuario = 'luisges')
);

insert into roles_usuarios(id_rol, id_usuario) values(
	(select r.id from roles r where r.nombre = 'Administrador'),
    (select u.id from usuarios u where u.usuario = 'mariaadm')
);



select *
from usuarios;

select *
from roles;

select p.nombre as permiso, p.objeto, r.nombre as rol
from permisos p
inner join roles r on r.id = p.id_rol
order by 2, 1
;

select u.usuario, r.nombre as rol, p.objeto, p.nombre as permiso
from permisos p
inner join roles r on r.id = p.id_rol
inner join roles_usuarios ru on ru.id_rol = r.id
inner join usuarios u on u.id = ru.id_usuario
order by 1, 2, 3, 4
;

drop view vw_permisos;

create view vw_permisos_usuarios
as
select u.usuario, r.nombre as rol, p.objeto, p.nombre as permiso
from permisos p
inner join roles r on r.id = p.id_rol
inner join roles_usuarios ru on ru.id_rol = r.id
inner join usuarios u on u.id = ru.id_usuario
;

select *
from vw_permisos_usuarios
;



