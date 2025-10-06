show databases;
create database Mysql_Assign;

create table Customer(
	Customer_id int primary key,
    Name varchar(50) not null,
    Address varchar(100) not null,
    Phone_number varchar(10) not null,
    email varchar(50) unique);
    
-- b Add some dummy data in the customer table
insert into Customer values(1 , "Meera","Trichy","9873652140","meera.sri@gmail.com") , (2 , "Tara","Chennai","8976541023","tara.shyam@gmail.com"),
(3 , "Prena","Dindugal","9431568720","prena.vaithi@gmail.com"),(4 , "Dinesh","Chidambaram","96325870114","dinesh.karthika@gmail.com"),(5 , "Sridhar","Thuraiyur","9952154687","sridhar.venkat@gmail.com");
    
create table Meter(
	Meter_id int primary key,
    Customer_id int,
    Installation_date date not null,
    Last_reading_date date not null,
    
    constraint fk_cusid foreign key(Customer_id) references Customer(Customer_id) ON DELETE cascade
    );
    
-- d. Add some dummy data in meter table

insert into 
    
create table Electricity_Usage(
	Usage_id int primary key,
    Meter_id int,
    Reading_date date not null,
    Usage_units numeric(10,2) CHECK(Usage_units >=0),
    
	constraint fk_meterid foreign key(Meter_id) references Meter(Meter_id) ON DELETE cascade
    );

create table Bill(
	Bill_id int primary key,
    Meter_id int,
    Bill_date date not null,
    Amount_due numeric(10,2) CHECK(Amount_due >=0),
    Due_date date not null,
    Paid boolean default 0,
    
	constraint fk_meterid foreign key(Meter_id) references Meter(Meter_id) ON DELETE cascade
	);
  
  -- i. Create table payment with following attributes
create table Payment(
	Payment_id int primary key,
	Bill_id int,
    Payment_date date not null,
    amount_paid decimal(10,2) check(amount_paid >= 0),
    constraint fk_billid foreign key(Bill_id) references Bill(Bill_id) on delete cascade
);
    
    
    
    
    
    

    
    

    