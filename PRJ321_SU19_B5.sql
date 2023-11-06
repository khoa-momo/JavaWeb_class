Select * From MessageTBL
Select * From Requests

Select * From UserTBL 
Where userid = 'mra' and password = '123'




Select * From MessageTBL
Where [to] = 'mrb'

insert into MessageTBL (messagetitle, messagetime, [from], [to], messagecontent, isread) 
values ('m1', GETDATE(), 'mra', 'mrb', 'hi b it is a me mra', 0);



Select * From MessageTBL
Where messageid = 5

UPDATE MessageTBL
SET isread = 1 
WHERE messageid = 5




Select * From UserTBL 
Where userid not in ('mrb')



