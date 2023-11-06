Select * From Account

Select * From Assignment
 
Select * From Booking

Select * From Room

Select * From RoomType
 


 Select * From Account

 Select r.*, rt.Square 
 From Room r join RoomType rt
 On r.RoomType = rt.Title 
 Where r.RoomType = 'Single'

 insert into Room(Title, Status, RoomType) values ('P999', 'Good', 'Single') 

 delete from Room 
 Where id = 21






 Select * From Account
 Where username = 'user1' and password='123456'


Select distinct r.RoomType
From Room r join RoomType rt
On r.RoomType = rt.Title  