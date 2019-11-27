create table agenda(
	id		int				not null auto_increment,
    nom		varchar(50)		not null,
    dir		varchar(100)	not null,
    cp		varchar(5)		not null,
    tel		varchar(15)		not null,
    
    primary key(id)
);

select *
from agenda

