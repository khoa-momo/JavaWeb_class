---------------------------------Get all room ------------------------
Select r.*, rt.roomTypeName, l.provinceName+' '+l.provinceName+' '+l.streetName as [Address], a.username
From Room r join RoomType rt
On r.roomTypeId = rt.roomTypeId join Location l
On r.locationId = l.locationId join Account a
On r.accountId = a.accountId


---------------------------------Get all Room　paging------------------------
Select r.*, rt.roomTypeName, l.provinceName+' '+l.provinceName+' '+l.streetName as [Address], a.username
From Room r join RoomType rt
On r.roomTypeId = rt.roomTypeId join Location l
On r.locationId = l.locationId join Account a
On r.accountId = a.accountId
Order by roomId
offset (1-1)*6 row fetch next 6 rows only
----
Select count(*)
From Room r join RoomType rt
On r.roomTypeId = rt.roomTypeId


---------------------------------Get filter paging------------------------
Select r.*, rt.roomTypeName, l.provinceName+' '+l.districtName+' '+l.streetName as [Address], a.username
From Room r join RoomType rt
On r.roomTypeId = rt.roomTypeId join Location l
On r.locationId = l.locationId join Account a
On r.accountId = a.accountId 
Where  1 = 1
and l.provinceName like N'%Đà Nẵng%' 
and l.districtName like N'%%'
and l.streetName like N'%%' 
and r.cost >= 2000000
and r.cost <= 3000000

and r.area >= 50 
and r.area <= 60


Order by roomId
offset (1-1)*6 row fetch next 6 rows only

Select distinct l.provinceName
From Location l
Order by l.provinceName

Select distinct l.districtName
From Location l
Order by l.districtName

Select count(*)
From Room r join RoomType rt
On r.roomTypeId = rt.roomTypeId join Location l
On r.locationId = l.locationId join Account a
On r.accountId = a.accountId
Where l.provinceName = N'Hà Nội' 
and l.districtName = N'Quận Ba Đình'
and l.streetName like N'%Chí%' 
and r.area between '10' and '60'
and r.cost between '70000' and '3000000'

----------------------special filter-------------
--by lasted date
Select Top 10 r.*, rt.roomTypeName, l.provinceName+' '+l.districtName+' '+l.streetName as [Address], a.username
From Room r join RoomType rt
On r.roomTypeId = rt.roomTypeId join Location l
On r.locationId = l.locationId join Account a
On r.accountId = a.accountId 
Order by r.dateCreated desc

Delete from Room
Where roomId = 70

Delete from Image_Room
Where roomId = 70

----------------------detail----------------------
Select r.*, rt.roomTypeName
From Room r join RoomType rt
On r.roomTypeId = rt.roomTypeId
Where r.roomId = 20




Select * From Room
Order by Roomid desc
 

Select distinct l.districtName 
From Location l
Where provinceName = N'Hà Nội'
order by l.districtName 

Order by Locationid  

Delete from Location
Where Locationid = 38

insert into tableName (ImageColumn) 
SELECT BulkColumn 
FROM Openrowset( Bulk 'image..Path..here', Single_Blob) as img


insert into Account (userName, passWord, fullName, email, gender, phone) 
values ('cyanceyt', 'nYCYvGS9COsW', 'Corinna Yancey', 'cyanceyt@google.es', 'Female', '4456155673');


Select a.*
From Account a
Where a.username = 'user1abc'

Select * From Fav_Room

Delete From Fav_Room
Where accountid = 1 


--image


Select ir.*
From Room r join Image_Room ir
On r.roomId = ir.roomId 
Where r.roomId = 98 
order by roomid desc

UPDATE Image_Room
SET imageLink = 'https://xaydungtienthanh.vn/wp-content/uploads/2021/08/thiet-ke-phong-tro-co-gac-lung-15m2-16m2-8-1000x692.jp'
WHERE imageLink = 'https://xaydungtienthanh.vn/wp-content/uploads/2021/08/thiet-ke-phong-tro-co-gac-lung-15m2-16m2-3-1000x692.jp';

UPDATE Room
SET accountId = 15
WHERE roomId in (24,25)


UPDATE Account
SET accountRole = 'admin'
WHERE accountId in (31)

Select * From Account

------------------------------------------------
Select r.*, rt.roomTypeName, l.provinceName+' '+l.districtName+' '+l.streetName as [Address], a.username
From Room r join RoomType rt
On r.roomTypeId = rt.roomTypeId join Location l
On r.locationId = l.locationId join Account a
On r.accountId = a.accountId 
Where  a.username = 'user2'


Delete From Image_Room
Where roomId = 90
Delete From Room
Where roomId = 90


Select * From account


Select * From Image_Room





