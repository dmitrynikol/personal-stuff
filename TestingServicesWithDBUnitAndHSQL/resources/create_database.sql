create table if not exist users (
	id varchar(30) not null,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	email varchar(30),
	primary key (id)
);