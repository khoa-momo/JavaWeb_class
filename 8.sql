Select * From SchoolYear

Select * From Student

Select * From Class

Select * From Student_Class

insert into SchoolYear(title, startdate, enddate) values ('2020/01/03','2020/01/03');


Delete From Student_Class
Where studentid = 7

Delete From Student
Where id = 7





Select Student.*,SchoolYear.id as school_year_id, SchoolYear.title 
From Student inner join  Student_Class 
on Student.id = Student_Class.studentid
inner join Class on Student_Class.classid = Class.id
inner join SchoolYear on SchoolYear.id = Class.schoolyear