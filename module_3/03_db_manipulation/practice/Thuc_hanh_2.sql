use quanlysinhvien;
select * from student;
select * from student 
where `Status` = TRUE;

select * from `subject` 
where Credit < 10;

select S.StudentID , S.StudentName, C.ClassName
from student S join class C on S.ClassID = C.ClassID;


select S.StudentID , S.StudentName, Sub.SubName, M.Mark
from student S join mark M on S.StudentId = M.StudentId join `subject` Sub on M.SubId = Sub.SubId;

select S.StudentID, S.StudentName, C.ClassName
from Student S join class C on S.ClassID = C.ClassID
where C.ClassName = "A1";

select S.StudentID , S.StudentName, Sub.SubName, M.Mark
from student S join mark M on S.StudentId = M.StudentId join `subject` Sub on M.SubId = Sub.SubId
where Sub.SubName = "CF";