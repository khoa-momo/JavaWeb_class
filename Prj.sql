Insert into Department values (1, 'Integrated System'); 
Insert into Department values (2, 'SoftWare'); 
Insert into Department values (3, 'Information Assurance'); 

Insert into Employee values (1, 'Nguyen Van A', '2000-05-12', 'male', 'developer', 1); 
Insert into Employee values (2, 'Nguyen Van B', '2001-12-30', 'female', 'tester', 1); 
Insert into Employee values (3, 'Nguyen Van C', '2002-10-12', 'female', 'manager', 2); 
Insert into Employee values (4, 'Nguyen Van D', '2003-07-20', 'male', 'designer', 3); 
Insert into Employee values (5, 'Nguyen Van E', '2002-01-16', 'female', 'developer', 2); 

--key IDENTITY
Insert into Employee values ('Nguyen Van Minh', '2000-05-12', 'male', 'developer', 1); 
Insert into Employee values ('Nguyen Van Ly', '2001-12-30', 'female', 'tester', 1);  
Insert into Employee values ('Nguyen Van Thu', '2002-10-12', 'female', 'manager', 2); 
Insert into Employee values ('Nguyen Van Nam', '2003-07-20', 'male', 'designer', 3); 
Insert into Employee values ('Nguyen Van Ha', '2002-01-16', 'female', 'developer', 2); 

DELETE FROM Department
DROP TABLE Employee;
DROP TABLE Department;

Select e.*, d.name [departmentname] 
From Employee e join Department d 
On e.deptID = d.id;

 
Insert into Employee values ('Nguyen Van ZZZ', '2002-01-16', 'female', 'developer', 3); 

Select * From Employee 
Select * From Department


DELETE FROM Employee WHERE empID = 21


UPDATE Employee
SET empName = 'Nguyen Van M', dob='2001-03-12', sex='female', position='Developer', deptID = 1
WHERE empID = 8;     


--Filter female
select e.*, d.deptName [departmentname] 
from Employee e, Department d 
where e.deptID = d.deptID
and empName like '%M%'and sex = 'female' and position='Developer' 
and Year(e.dob) between 2000 and 2005
and Month(e.dob) between 1 and 3
and Day(e.dob) between 10 and 12;

----------------------Filter/paging ---------------------
select e.*, d.deptName [departmentname] 
From Employee e join Department d 
On e.deptID = d.deptID
Where e.empName like '%%' 
and e.sex = 'male'
and position like '%%'
and Year(e.dob) between 1900 and 3000
and Month(e.dob) between 1 and 12
and Day(e.dob) between 1 and 31
and e.deptID like '%1%'
Order By empId
offset (1-1)*5 row fetch next 5 rows only



select count(empid) from Employee 

select count(*)
From Employee e join Department d 
On e.deptID = d.deptID
Where e.empName like '%%' 
and e.sex like '%male%'
and position like '%Developer%'
and Year(e.dob) between 1900 and 3000
and Month(e.dob) between 1 and 12
and Day(e.dob) between 1 and 31
and e.deptID like '%1%'

GROUP BY d.deptName, empid

Order By empId




-----------------------------------------------

select e.*, d.deptName [departmentname] 
From Employee e join Department d 
On e.deptID = d.deptID
Where e.empName like 'm' or e.sex = '' 
or Year(e.dob) between 2000 and 2001;

Select o.EmployeeID, e.LastName, e.FirstName, o.OrderID, o.OrderDate, o.RequiredDate, o.ShippedDate
From Orders o join Employees e
On o.EmployeeID = e.EmployeeID
Where DateDiff(day, o.RequiredDate, o.ShippedDate) > 7
Order by o.EmployeeID


--Filter loc DATE--
--Select OrderID, Day(OrderDate) as [OrderDay], Month(OrderDate) as [OrderMonth], Year(OrderDate) as [OrderYear], Freight, Tax, Tax/100 as [Freight with Tax]
--From Orders
--Where Year(OrderDate) = 1996 and Month(OrderDate) = 8 and Day(OrderDate) between 1 and 5   


select distinct position
from Employee



select * from Employee
select count(*) [numEmp] from Employee e

Select e.*, d.deptName [departmentname] From Employee e, Department d 
where e.deptID = d.deptID
order by e.empID offset 5 rows fetch next 10 rows only








Create Table Department(
	deptID int IDENTITY(1,1) Primary key, 
	deptName varchar(30),
)

Create Table Employee(
	empID int IDENTITY(1,1) Primary key, 
	empName varchar(30),
	dob Date,
	sex varchar(14),
	position varchar(16),
	deptID int foreign key references Department(deptID) 
)


----------------------Filter/paging ---------------------
select e.*, d.deptName [departmentname] 
From Employee e join Department d 
On e.deptID = d.deptID
Where e.empName like '%%' 
and e.sex = 'male'
and position like '%%'
and e.dob <= '2002-08-04' and e.dob >= '2001-08-01'
and e.deptID like '%1%'
