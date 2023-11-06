Select * From Categories

Select * From Categories

Select * From Certificate

Select * From Employee_Certificate

Select * From Employee


Select * From Account

Select c.id, c.name
From [Certificate] c join Employee_Certificate ec
on c.id = ec.cid join Employee e
on ec.eid = e.id
Where e.id = 1001






