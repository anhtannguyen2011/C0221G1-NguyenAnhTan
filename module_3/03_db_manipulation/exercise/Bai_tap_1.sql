use quanlysinhvien;

select * from student as S
where S.StudentName  like "h%";

select * from class as c
where month(c.StartDate) = 12;

select * from `subject` s
where s.Credit >=3 and s.Credit<=5;


SET SQL_SAFE_UPDATES = 0;
update student
set ClassID = 2
where StudentName = "Hung";

select student.StudentName, `subject`.SubName, mark.Mark
from mark join student on mark.StudentID = student.StudentID
join `subject` on mark.SubID = `subject`.SubID
order by mark.Mark DESC, student.StudentName ASC;