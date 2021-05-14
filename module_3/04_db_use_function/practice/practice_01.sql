use quanlysinhvien;

select Address , count(StudentID) AS "Số Lượng Học Viên"
from student
group by Address;

select S.StudentID ,S.StudentName , avg(mark)
from Student S join Mark M on S.StudentID = M.StudentID
group by S.StudentID , S.StudentName;

select S.StudentID ,S.StudentName , avg(mark)
from Student S join Mark M on S.StudentID = M.StudentID
group by S.StudentID , S.StudentName
having avg(mark) > 15;

select S.StudentID ,S.StudentName , avg(mark)
from Student S join Mark M on S.StudentID = M.StudentID
group by S.StudentID , S.StudentName
having avg(mark) >= All(select avg(mark) from mark group by mark.StudentID);

