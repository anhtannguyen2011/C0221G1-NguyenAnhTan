use quanlysinhvien;

select * from student as S
where S.student_name  like "h%";

select * from class as c
where month(c.start_date) = 12;

select * from `subject` s
where s.credit >=3 and s.credit<=5;


SET SQL_SAFE_UPDATES = 0;
update student
set class_id = 2
where student_name = "Hung";

select student.student_name, `subject`.sub_name, mark.mark
from mark join student on mark.student_id = student.student_id
join `subject` on mark.sub_id = `subject`.sub_id
order by mark.mark DESC, student.student_name ASC;