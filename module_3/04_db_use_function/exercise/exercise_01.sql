use quanlysinhvien;

select * , max(Credit)
from `subject` as s
group by s.SubID
having max(Credit) >= ALL (select max(Credit) from `subject` as s );


select s.SubName,s.Credit,s.`Status`, max(m.mark) as "Điểm cao nhất"
from `subject` as s 
join mark as m on s.SubID = m.SubID;

insert into mark
values (4,3,3,7,1);

update student as s
set s.StudentName = "Long"
where s.StudentId = 2;

select s.StudentName,s.Address,s.Phone , avg(m.mark) as "Điểm trung bình"
from student as s 
join mark as m on s.StudentId = m.StudentId
group by s.StudentID
order by avg(m.mark) DESC;