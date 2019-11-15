
create table usuarios(
	id int not null auto_increment,
	usuario varchar(30) not null,
	password varchar(30) not null,
	
	primary key (id)
)
;


insert into usuarios(usuario, password) values('pepe', 'pepepass');
insert into usuarios(usuario, password) values('paco', 'pacopass');


select *
from usuarios;
