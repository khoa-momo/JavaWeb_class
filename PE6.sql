Select * From Employee

Select * From JobEmployee
 
Select * From Jobs 
 
Select e.*, je.* 
From Employee e join JobEmployee je
On e.ID = je.Empid join Jobs j 
On je.Jobid = j.ID
 
insert into JobEmployee(Empid, Jobid) 
values ('EMP03', 3);

Delete from JobEmployee
Where Empid = 'EMP01' and Jobid = 2


Select e.FullName, e.ID, je.Jobid
From Employee e full outer join JobEmployee je
On e.ID = je.Empid full outer join Jobs j 
On je.Jobid = j.ID
Where je.Jobid = 1
Order by e.ID


Select * From JobEmployee
Where Jobid = 4


Select * From Employee


Select j.ID 
From Jobs j


Select distinct e.*, j.*
From Employee e join JobEmployee je
On e.ID = je.Empid join Jobs j 
On je.Jobid = j.ID
Where je.Jobid = 4
Order by e.ID
 



Select * From Employee


Select j.* 
From JobEmployee je join Jobs j
On je.Jobid = j.ID
Where Empid = 'EMP01'


With T as
	(
	Select distinct Empid 
	From JobEmployee 
	Where Jobid = '4'
	Group by Empid
	)
select count(*) as Total
from T


Delete from Jobs
Where ID >= 5