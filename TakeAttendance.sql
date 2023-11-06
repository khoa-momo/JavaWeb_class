
Select * From STUDENTS;
Select * From COURSES;
Select * From STUDENT_COURSE;

Select * From COURSE_SCHEDULES; 
Select * From ROLL_CALL_BOOKS;

Select * From INSTRUCTORS; 
Select * From DEPARTMENTS;

Delete from COURSES
Where CourseId >= 12;


Select * From SUBJECTS s
Where s.SubjectId = 99

Select i.*
From INSTRUCTORS i
Where i.InstructorId = 1

Select * From COURSE_SCHEDULES
Order by TeachingDate, courseId, slot;
 

Select * From STUDENT_COURSE
Order by courseid desc

insert into STUDENT_COURSE(CourseId, Studentid)
values ('1023','99');

insert into COURSES(CourseCode, CourseDescription, Subjectid, Instructorid, Termid, CampusID) 
values ('SE1609','SE1609', 225, 2, 5, 1);

Select * From STUDENTS s
Where s.StudentId in (1,2,3)

Select distinct s.SubjectId, s.SubjectCode, s.SubjectName
From SUBJECTS s 


Select s.SubjectId, s.SubjectCode, s.SubjectName
From SUBJECTS s;
-------------------------Page 1---------------------------------
--getSubjectlist only ----------SUBJECTSxCOURSES
Select distinct s.SubjectId, s.SubjectCode, s.SubjectName
From SUBJECTS s full join COURSES c
On s.subjectid = c.subjectid
Where s.SubjectCode like '%MA%'

Select distinct s.*
From SUBJECTS s full join COURSES c
On s.subjectid = c.subjectid
Where s.SubjectCode like '%MA%'

Select s.*
From SUBJECTS s full join COURSES c
On s.subjectid = c.subjectid 
Where s.SubjectCode like '%MA%'

---getCourseBySubject--------COURSESxSUBJECTS
Select s.SubjectCode, count(s.SubjectCode) as[count]
From SUBJECTS s full join COURSES c
On s.subjectid = c.subjectid
Group by s.SubjectCode 

Having s.SubjectId = 30

--
Select s.*
From SUBJECTS s
Where SubjectId = 23
----------------------------------------------------------------
Select std.*, c.*
From Courses c join STUDENT_COURSE sc
On c.Courseid = sc.Courseid join Students std
On sc.studentid = std.studentid
Where c.CourseId = 1014

Select * From COURSES;

Select * From STUDENT_COURSE; 

Select * From STUDENTS;
Select * From ROLL_CALL_BOOKS;
Select * From COURSE_SCHEDULES;



Select rc.RollCallBookId, cs.TeachingScheduleId, cs.TeachingDate, s.Roll#, s.FirstName, rc.IsAbsent
From STUDENTS s join ROLL_CALL_BOOKS rc
On s.StudentId = rc.StudentId join COURSE_SCHEDULES cs
On rc.TeachingScheduleId = cs.TeachingScheduleId
order by cs.TeachingScheduleId desc;

---------
Select * From COURSE_SCHEDULES
Where CourseId = 1014
order by TeachingScheduleId desc, teachingDate desc;

-------------------------
Select rc.*
From ROLL_CALL_BOOKS rc full join COURSE_SCHEDULES cs
On rc.TeachingScheduleId = cs.TeachingScheduleId
Where cs.TeachingScheduleId >= 70
order by cs.TeachingScheduleId desc;



Select rc.*, s.StudentId
From COURSE_SCHEDULES cs full outer join  ROLL_CALL_BOOKS rc 
On cs.TeachingScheduleId = rc.TeachingScheduleId full outer join STUDENTS s
On rc.StudentId = s.StudentId full outer join STUDENT_COURSE sc
On s.StudentId = sc.StudentId
Where cs.TeachingScheduleId >= 70 and sc.CourseId = 1014
order by cs.TeachingScheduleId desc;

---------take course name by id
Select CourseCode
From COURSES
Where CourseId = 1
----------------------------------------list date---------------------------------------------------
Select cs.*
From COURSES c join COURSE_SCHEDULES cs
On c.CourseId = cs.CourseId
Where c.CourseId = 1 --and cs.TeachingDate='2011-07-23'
Order by cs.TeachingDate, slot

--rollcalllist    ---   STUDENTS  x  ROLL_CALL_BOOKS  x  TeachingScheduleId

Select rc.*, s.Roll#, s.FirstName, cs.*
From STUDENTS s full join ROLL_CALL_BOOKS rc
On s.StudentId = rc.StudentId full join COURSE_SCHEDULES cs
On rc.TeachingScheduleId = cs.TeachingScheduleId 
Where TeachingDate like '%2011-07-23%' and cs.CourseId = 1 and slot = 4


order by cs.TeachingScheduleId desc;

-------------------------------------------------------
--insert new record
Select  s.*, cs.*, c.SubjectId --cs-main
From COURSE_SCHEDULES cs join COURSES c
On cs.CourseId = c.CourseId join STUDENT_COURSE sc
On c.CourseId = sc.CourseId join STUDENTS s
On sc.StudentId = s.StudentId
Where c.CourseId = 1 and cs.TeachingDate like '%2011-07-23%' and slot=1
Order by cs.TeachingDate 

delete from
ROLL_CALL_BOOKS where TeachingScheduleId = 50

--cid=4&date=2011-07-23&slot=4

insert into ROLL_CALL_BOOKS(TeachingScheduleId, StudentId, IsAbsent, Comment) values (50, 31, 0, 'bi om');  


--------------------------------------------------------
Select distinct cs.*, c.*, s.StudentId, s.Roll#, s.FirstName, rc.*
From ROLL_CALL_BOOKS rc full join COURSE_SCHEDULES cs 
On rc.TeachingScheduleId = cs.TeachingScheduleId join COURSES c
On cs.CourseId = c.CourseId  join STUDENT_COURSE sc
On c.CourseId = sc.CourseId join STUDENTS s
On sc.StudentId = s.StudentId 
Where cs.TeachingScheduleId = 50 -- c.CourseId = 1 and cs.TeachingDate like '%2011-07-23%' and slot = 4
Order by rc.RollCallBookId desc

Select rc.*, cs.*
From ROLL_CALL_BOOKS rc right join COURSE_SCHEDULES cs
On rc.TeachingScheduleId = cs.TeachingScheduleId
Where cs.TeachingScheduleId = 55

Select * From COURSE_SCHEDULES
Where CourseId = 1
order by TeachingDate, slot



insert into COURSE_SCHEDULES(CourseId, TeachingDate, Slot, RoomId) values (1014, '2020-02-18', 3, 230);  

insert into STUDENT_COURSE(Courseid, StudentId) values (1023, 80); 

insert into ROLL_CALL_BOOKS(Courseid, StudentId) values (1023, 80);  




UPDATE ROLL_CALL_BOOKS
SET IsAbsent = 1, Comment = 'Nghi om'
WHERE RollCallBookId = 1842
 


UPDATE 
    ROLL_CALL_BOOKS rc
SET 
    rc.TeachingScheduleId = COURSE_SCHEDULES.TeachingScheduleId
FROM 
    ROLL_CALL_BOOKS
    JOIN COURSE_SCHEDULES ON TeachingScheduleId
WHERE 
    TeachingScheduleId = 1;














