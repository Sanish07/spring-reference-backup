create database spring_jdbc;

show databases;

use spring_jdbc;

create table student(id int primary key, name varchar(50) not null, city varchar(20));

show tables;

insert into student(id,name,city) values(101,"Sanish","Bhandara");

select * from student;

desc student;