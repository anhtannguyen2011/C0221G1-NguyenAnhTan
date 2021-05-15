use quanlysinhvien;

select * , max(credit)
from `subject` as s
group by s.sub_id
 having max(credit) >= ALL (select max(credit) from `subject` as s );


select s.sub_name,s.credit,s.`Status`, max(m.mark) as "Điểm cao nhất"
from `subject` as s 
join mark as m on s.sub_id = m.sub_id;

insert into mark
values (4,3,3,7,1);

update student as s
set s.student_name = "Long"
where s.student_id = 2;

select s.student_name,s.address,s.phone , avg(m.mark) as "Điểm trung bình"
from student as s 
join mark as m on s.student_id = m.student_id
group by s.student_id
order by avg(m.mark) DESC;