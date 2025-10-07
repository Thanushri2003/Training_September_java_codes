show databases;
create database Mysql_Assign;
use Mysql_Assign;

desc customer;
desc meter;
desc bill;
desc  Electricity_Usage;
desc payment;

drop table customer;
drop table meter;
drop table bill;
drop table electricity_usage;
drop table payment;

-- 	Question 1 --

-- a--
create table Customer(
	Customer_id int primary key,
    Name varchar(50) not null,
    Address varchar(100) not null,
    Phone_number varchar(10) not null,
    email varchar(50) unique);
    
-- b--
insert into Customer(Customer_id,Name,Address,Phone_number,email) values
(1, 'Ravi Kumar', '123 MG Road', '9876543210', 'ravi@email.com'),
(2, 'Priya Singh', '45 Park Avenue', '9123456789', 'priya@email.com'),
(3, 'John Doe', '78 Lake View', '9988776655', 'john@email.com'),
(4, 'Anil Mehra', '56 Hill Road', '9001122334', 'anil@email.com'),
(5, 'Sunita Rao', '89 River Street', '9112233445', 'sunita@email.com'),
(6, 'Meena Patel', '12 Green Lane', '9223344556', 'meena@email.com'),
(7, 'Rajesh Shah', '34 Blue Street', '9334455667', 'rajesh@email.com'),
(8, 'Kavita Joshi', '67 Red Road', '9445566778', 'kavita@email.com'),
(9, 'Amit Verma', '90 White Field', '9556677889', 'amit@email.com'),
(10, 'Neha Gupta', '21 Yellow Lane', '9667788990', 'neha@email.com');
    
-- c --
create table Meter(
	Meter_id int primary key,
    Customer_id int,
    Installation_date date not null,
    Last_reading_date date not null,
    
    constraint fk_cusid foreign key(Customer_id) references Customer(Customer_id) ON DELETE cascade
    );
    
-- d --
insert into Meter(Meter_id,Customer_id,Installation_date,Last_reading_date) values
(101, 1, '2024-01-15', '2024-03-01'),
(102, 2, '2024-02-10', '2024-03-05'),
(103, 3, '2023-12-20', '2024-03-03'),
(104, 4, '2024-01-25', '2024-03-02'),
(105, 5, '2024-02-15', '2024-03-04'),
(106, 6, '2024-03-01', '2024-03-06'),
(107, 7, '2024-01-10', '2024-03-01'),
(108, 8, '2024-02-20', '2024-03-05'),
(109, 9, '2024-01-30', '2024-03-03'),
(110, 10, '2024-03-02', '2024-03-06');


-- e --
 create table Electricity_Usage(
	Usage_id int primary key,
    Meter_id int,
    Reading_date date not null,
    Usage_units numeric(10,2) CHECK(Usage_units >=0),
    
	constraint fk_meterid foreign key(Meter_id) references Meter(Meter_id) ON DELETE cascade
    );
    
-- f --
insert into Electricity_Usage(Usage_id,Meter_id,Reading_date,Usage_units) values
(201, 101, '2024-03-01', 150),
(202, 102, '2024-03-05', 220),
(203, 103, '2024-03-03', 180),
(204, 104, '2024-03-02', 210),
(205, 105, '2024-03-04', 90),
(206, 106, '2024-03-06', 250),
(207, 107, '2024-03-01', 130),
(208, 108, '2024-03-05', 300),
(209, 109, '2024-03-03', 170),
(210, 110, '2024-03-06', 200);
    
    
-- g --
create table Bill(
	Bill_id int primary key,
    Meter_id int,
    Bill_date date not null,
    Amount_due numeric(10,2) CHECK(Amount_due >=0),
    Due_date date not null,
    Paid  boolean not null default 0,
    
	constraint fk_meterid1 foreign key(Meter_id) references Meter(Meter_id) ON DELETE cascade
	);
 

-- h --
insert into Bill(Bill_id,Meter_id,Bill_date,Amount_due,Due_date,Paid) values
(301, 101, '2024-03-02', 1200, '2024-03-20', 0),
(302, 102, '2024-03-06', 1800, '2024-03-25', 1),
(303, 103, '2024-03-04', 1500, '2024-03-22', 0),
(304, 104, '2024-03-03', 1700, '2024-03-21', 1),
(305, 105, '2024-03-05', 800, '2024-03-23', 0),
(306, 106, '2024-03-07', 2000, '2024-03-26', 1),
(307, 107, '2024-03-02', 1100, '2024-03-20', 0),
(308, 108, '2024-03-06', 2200, '2024-03-25', 1),
(309, 109, '2024-03-04', 1300, '2024-03-22', 0),
(310, 110, '2024-03-07', 1600, '2024-03-26', 1);

-- i --
create table Payment(
	Payment_id int primary key,
	Bill_id int,
    Payment_date date not null,
    Amount_paid numeric(10,2) check(amount_paid >= 0),
    
    constraint fk_billid foreign key(Bill_id) references Bill(Bill_id) on delete cascade
);

-- j --
insert into Payment(Payment_id,Bill_id,Payment_date,Amount_paid) values
(401, 302, '2024-03-10', 1800),
(402, 304, '2024-03-12', 1700),
(403, 306, '2024-03-15', 2000),
(404, 308, '2024-03-18', 2200),
(405, 310, '2024-03-20', 1600),
(406, 302, '2024-03-11', 0),
(407, 304, '2024-03-13', 0),
(408, 306, '2024-03-16', 0),
(409, 308, '2024-03-19', 0),
(410, 310, '2024-03-21', 0);
    
    
select * from Customer;
select * from Meter;
select * from Electricity_Usage;
select * from Bill;
select * from Payment;

-- k --
select 
	c.customer_id,c.name,c.address,c.phone_number,c.email,
    m.meter_id,m.installation_date,m.last_reading_date,
    e.usage_id,e.reading_date,e.usage_units,
    b.bill_id,b.bill_date,b.amount_due,b.due_date,b.paid,
    p.payment_id,p.payment_date,p.amount_paid
from customer c
join meter m on c.customer_id=m.customer_id
left join electricity_usage e on m.meter_id=e.meter_id
left join bill b on m.meter_id=b.meter_id
left join payment p on b.bill_id=p.bill_id;



-- l --
select
    meter_id,
    sum(usage_units) AS Total_Usage
from electricity_usage
group by  meter_id
having sum(usage_units) > 200;

-- m --
select c.customer_id,c.name,sum(b.amount_due)as Unpaid_Amount from customer c
join meter m on c.customer_id=m.customer_id
join bill b on m.customer_id=b.meter_id
where b.paid=0
group by c.customer_id,c.name
order by Unpaid_Amount desc;

-- n --
select b.bill_id,b.meter_id,b.bill_date,b.amount_due,b.due_date,b.paid,
	case 
		when b.paid is true then "Paid"
        else "Unpaid"
	end as Payment_Status
from bill b
left join payment p on b.bill_id=p.bill_id
group by b.bill_id,b.meter_id
order by b.bill_date asc;

-- o --
select c.customer_id,c.name,c.address,c.phone_number,c.email,m.installation_date from customer c 
join meter m on c.customer_id=m.customer_id
where m.installation_date >'2023-12-31';


-- p --
select m.meter_id,m.customer_id,m.last_reading_date,e.usage_units as Total_Usage  from meter m
join electricity_usage e on m.meter_id=e.meter_id
order by Total_Usage desc;




-- extra --
SELECT
    b.bill_id,
    c.customer_id,
    c.name,
    b.meter_id,
    b.bill_date,
    b.amount_due,
    b.due_date,
    b.paid,
    'Unpaid' AS Payment_Status
FROM bill b
join customer c
LEFT JOIN payment p ON b.bill_id = p.bill_id
WHERE b.paid IS NOT TRUE
ORDER BY b.bill_date ASC;

SELECT
    c.customer_id,
    c.name,
    e.meter_id,
    SUM(e.usage_units) AS Total_Usage
FROM electricity_usage e
JOIN customer c ON e.customer_id = c.customer_id
GROUP BY c.customer_id, c.name, e.meter_id
HAVING SUM(e.usage_units) > 200;

    
    
select b.bill_id,b.meter_id,b.bill_date,b.amount_due,b.due_date,b.paid,
	case 
		when b.paid is true then "Paid"
        else "Unpaid"
	end as Payment_Status
from bill b
left join payment p on b.bill_id=p.bill_id
group by b.bill_id,b.meter_id
order by b.bill_date asc;
    

    
    

    
