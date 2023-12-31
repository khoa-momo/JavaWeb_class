/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP 1000 [id]
      ,[name]
  FROM [IOT1601].[dbo].[Department]

  DELETE FROM Department

  Insert into Department values (1, 'Integrated System'); 
  Insert into Department values (2, 'SoftWare'); 
  Insert into Department values (3, 'Information Assurance'); 



 Create Table Employee(
	id int IDENTITY(1,1) Primary key, 
	name varchar(30),
	dob Date,
	sex varchar(14),
	position varchar(16),
	deptID int
)

 Create Table Employee(
	id int IDENTITY(1,1) Primary key, 
	name varchar(30),
	dob Date,
	sex varchar(14),
	position varchar(16),
	deptID int
)

  Insert into Employee values (1, 'Nguyen Van A', '2000-05-12', 'male', 'developer', 1); 
  Insert into Employee values (2, 'Nguyen Van B', '2001-12-30', 'female', 'tester', 1); 
  Insert into Employee values (3, 'Nguyen Van C', '2002-10-12', 'female', 'manager', 2); 
  Insert into Employee values (4, 'Nguyen Van D', '2003-07-20', 'male', 'designer', 3); 
  Insert into Employee values (5, 'Nguyen Van E', '2002-01-16', 'female', 'developer', 2); 

  Insert into Employee values ('Nguyen Van A', '2000-05-12', 'male', 'developer', 1); 
  Insert into Employee values ('Nguyen Van B', '2001-12-30', 'female', 'tester', 1); 
  Insert into Employee values ('Nguyen Van C', '2002-10-12', 'female', 'manager', 2); 
  Insert into Employee values ('Nguyen Van D', '2003-07-20', 'male', 'designer', 3); 
  Insert into Employee values ('Nguyen Van E', '2002-01-16', 'female', 'developer', 2); 

DELETE FROM Employee
DROP TABLE Employee;
DROP TABLE Department;

Select e.*, d.name [departmentname] 
From Employee e, Department d 
Where e.deptID = d.id


insert into Employee(name, sex, dob, position, deptID) values (?,?,?,?,?)

Insert into Employee values (99,'Nguyen Van Z', '2002-02-26', 'male', 'developer', 1); 

Select * From Employee

Select * From Department

--
Select * From Customer
DELETE FROM Customer WHERE ID = 5

UPDATE Employee
SET empName = 'Nguyen Van Z', position='designer'
WHERE empID = 12;