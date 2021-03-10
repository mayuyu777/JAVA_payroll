create schema payrolldb;
use payrolldb;

create table position (
	posid int(11) unique not null auto_increment,
	posname varchar(50) not null,
	basicSalary float not null,
	allowance float default 0,
	primary key(posid)
);

create table employee (
	id int(11) unique not null auto_increment,
	fname varchar(25) not null,
	lname varchar(25) not null,
	mname varchar(25) not null,
	department varchar(50) not null,
	posid int(11) not null,
	state int not null default 0,
	primary key(id),
	foreign key(posid) references position (posid)
	
);
create table payslip (
	sid int(11) unique not null auto_increment,
	id int(11) not null,
	sgrosspay float not null,
	snetpay float not null,
	sovertimepay float not null,
	sdeduction float not null,
	slate int(11) not null,
	sovertime int(11) not null,
	sattendance int(11) not null,
	sdate date not null default CURRENT_DATE,
	primary key(sid),
	foreign key(id) references employee (id)
);

ALTER TABLE employee AUTO_INCREMENT=7778;
ALTER TABLE position AUTO_INCREMENT=132;
ALTER TABLE payslip AUTO_INCREMENT=8193;