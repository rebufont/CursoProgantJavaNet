use emp;

create table productos(
	id int not null,
	nombreprod varchar(50) not null,
	precio decimal(18,2) not null,
	stock int not null,
	primary key(id)
);

insert into productos values(1, 'Lechuga', 1.25, 200);
insert into productos values(2, 'Naranjas', 1.50, 75);