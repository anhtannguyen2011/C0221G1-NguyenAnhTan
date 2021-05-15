use quanlysinhvien;

select address , count(student_id) AS "Số Lượng Học Viên"
from student
group by address;

select S.student_id ,S.student_name , avg(mark)
from student S join mark M on S.student_id = M.student_id
group by S.student_id , S.student_name;

select S.student_id ,S.student_name , avg(mark)
from student S join mark M on S.student_id = M.student_id
group by S.student_id , S.student_name
having avg(mark) > 15;



select S.student_id ,S.student_name , avg(mark)
from student S join mark M on S.student_id = M.student_id
group by S.student_id , S.student_name
having avg(mark) >= All(select avg(mark) from mark group by mark.student_id);

