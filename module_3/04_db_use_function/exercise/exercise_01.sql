use quanlysinhvien;

select * 
from `subject` as s
group by s.sub_id,s.sub_name
having s.credit = (select max(credit) from `subject`);


-- hiển thị thông tin môn học ó điểm thi cao nhất

select s.*, m.mark as "Điểm Cao Nhất"  from `subject` as s 
join mark as m on m.sub_id = s.sub_id
group by s.sub_id,s.sub_name
having m.mark >= all(select max(mark) from mark group by mark.mark_id);



-- hiển thị tất cả các môn học có điểm thi cao nhất
-- select s.sub_name,s.credit,s.`Status`, max(m.mark) as "Điểm Cao Nhất"
-- from `subject` as s 
-- join mark as m on s.sub_id = m.sub_id
-- group by s.sub_id,s.sub_name
-- order by max(m.mark) DESC;

insert into mark
values (4,3,3,7,1);

update student as s
set s.student_name = "Long"
where s.student_id = 2;

select s.student_name,s.address,s.phone , avg(m.mark) as "Điểm Trung Bình"
from student as s 
join mark as m on s.student_id = m.student_id
group by s.student_id,s.student_name
order by avg(m.mark) DESC;