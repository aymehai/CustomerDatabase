CREATE DATABASE `customers`;

USE customers;

SELECT count(*) as `Customer Count` from customers;

SELECT count(distinct company) as 'Distinct Compaines' from customers;

alter table customers add Company VARCHAR(50);

alter table customers MODIFY CompanyID Integer auto_increment primary key;

SELECT companyID, company from customers;

create table Company (
companyID int NOT NULL AUTO_INCREMENT,
Company varchar(50),
primary key (companyID)
);

select * from Company;

describe Company;

insert into Company(company)values ('Dave Company');

select * from customers;

INSERT INTO customers (Company) select Company from Company;

select * from Company;

select customers from Company;

select companyID, Company from customers;

update customers c set c.companyID = (select t.companyID from
Company t where t.company=c.company limit 1);

select c.companyID,c.company,t.companyID,t.Company from
customers c inner join Company t on c.CompanyID=t.CompanyID;

alter table customers drop column CompanyID;

select * from customers;

select * from Company where companyID = 667;

select c.companyID,c.FirstName,t.companyID,t.Company from
customers c inner join Company t on c.CompanyID=t.CompanyID;

select fullname, company from customers
inner join Company on 
customers.companyid=Company.companyid;
