drop table if exists user;

create Table user(
	empid int primary key auto_increment,
	emp_username varchar(50) not null,
	emp_password varchar(50) not null
	);
    

insert into user(empid,emp_username,emp_password) values (1,'superuser123','superuser123');
insert into user(empid,emp_username,emp_password) values (2,'superuser234','superuser234');
insert into user(empid,emp_username,emp_password) values (3,'superuser345','superuser345');
