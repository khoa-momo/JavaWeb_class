Select * From Departments

Select * From Employees

Select * From Students


Select e.*, d.name [deptname]
From Employees e join Departments d
On e.did = d.id
Where e.name like '%%'
and e.gender like '%%'
and e.did = 3
and Year(e.dob) between 1900 and 2000
and Month(e.dob) between 1 and 12
and Day(e.dob) between 1 and 30