

select e.*, d.deptName [departmentname] 
from Employee e, Department d 
where e.deptID = d.deptID
and e.empName like '%%' 
and e.sex like '%'
and position like '%%'
and Year(e.dob) between 1900 and 3000
and Month(e.dob) between 1 and 12
and Day(e.dob) between 1 and 31
and e.deptID like '%1%'

Select p.ProductId, p.ProductName, c.CategoryName, p.UnitPrice, p.UnitsInStock, c.CategoryID

Select p.*, c.CategoryName, c.Description
From Products p join Categories c
On p.CategoryID = c.CategoryID
Where c.CategoryID = 1

Select count(*) [productNum] From Products p 

Insert into Orders values ('Nguyen Van A', '2002-01-16', 'female', 'developer', 2); 

Select * From Categories

Select * From Shippers




Select ShipperId, CompanyName
From Shippers

SELECT GETDATE();



Select p.*, c.CategoryName, c.Description
From Products p join Categories c
On p.CategoryID = c.CategoryID
and p.ProductID in (2,3,5)

insert into Orders(OrderDate, Shipvia, ShipName, ShipAddress) values (getDate(),1,'mre','hn')


Select o.* From Orders o 
Order by OrderID desc

Select * From [Order Details]
Order by OrderID desc

Select c.* From Customers c 


ALTER TABLE Customers
ADD username nvarchar(100)

ALTER TABLE Customers
ADD [password] nvarchar(100)
















