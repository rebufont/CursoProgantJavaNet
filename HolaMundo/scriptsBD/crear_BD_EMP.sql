create database EMP;

use EMP;

create table Employees(
	id  int not null,
    first varchar(30) not null,
    last varchar(50) not null,
    age int not null
);

insert into Employees values(1, 'Pepe', 'Gutierrez', 7);
insert into Employees values(2, 'Ignacio', 'Abad', 23);


select *
from Employees;
