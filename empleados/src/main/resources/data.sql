DROP table IF EXISTS empleado;

create table empleado(
	id int auto_increment primary key,
	nombre varchar(250),
	trabajo varchar(250),
    salario double
);

insert into empleado (nombre, trabajo, salario)values('Jose','limpieza', 0);
insert into empleado (nombre, trabajo, salario)values('Juan','informatico',0);
insert into empleado (nombre, trabajo, salario)values('Pedro','director',0);
insert into empleado (nombre, trabajo, salario)values('Jordi','secretario',0);
insert into empleado (nombre, trabajo, salario)values('Jonatan','operario',0);