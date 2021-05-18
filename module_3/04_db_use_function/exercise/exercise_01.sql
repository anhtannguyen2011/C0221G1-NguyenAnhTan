use quanlysinhvien;

select * 
from `subject` as s
group by s.sub_id,s.sub_name
having s.credit = (select max(credit) from `subject`);


-- hiển thị thông tin môn học ó điểm thi cao nhất

select s.sub_name , s.sub_id , s.credit ,s.`status`
from `subject` as s
join mark as m on m.sub_id = s.sub_id
where m.mark >= all (select max(mark) from mark);




insert into mark
values (5,3,3,7,1);

update student as s
set s.student_name = "Long"
where s.student_id = 2;

select s.student_name,s.address,s.phone , avg(m.mark) as "Điểm Trung Bình"
from student as s 
left join mark as m on s.student_id = m.student_id
group by s.student_id,s.student_name
order by avg(m.mark) DESC;