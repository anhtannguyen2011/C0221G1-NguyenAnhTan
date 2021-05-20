create database internship;
use internship;

create table faculty(
	faculty_id int primary key,
    faculty_name char(30),
    phone char(10)
);

create table project(
	project_id int primary key,
    project_name char(30),
    expense int,
    place_of_intern char(30)
);

create table instructor(
	instructor_id int primary key,
    instructor_name char(30),
    salary decimal(5,2),
    faculty_id int,
    foreign key (faculty_id) references faculty(faculty_id)
    on delete cascade
    on update cascade
);

create table student(
	student_id int primary key,
    student_name char(40),
    faculty_id int,
    date_of_birth date,
    place_of_birth char(30),
    foreign key (faculty_id) references faculty(faculty_id)
	on delete cascade
    on update cascade
);

create table instructor_student(
	student_id int,
    project_id int,
    instructor_id int,
    grade decimal (5,2),
    primary key (student_id,project_id,instructor_id),
    foreign key (student_id) references student(student_id),
    foreign key (project_id) references project(project_id),
    foreign key (instructor_id) references instructor(instructor_id)
	on delete cascade
    on update cascade
);

-- insert data 

insert into faculty
values (1,"Dia Ly","0909123456"),
		(2,"Ly","0905123456"),
		(3,"QLTN","0903123456"),
		(4,"Van","0901123456"),
		(5,"Anh","0902123456");
        
insert into instructor
values (1,"Van Lam",300.00,1),        
 (2,"Hung Thien",500.00,1),        
 (3,"Anh Dung",200.00,3),        
 (4,"Co Tam",300.00,3),        
 (5,"Lan Thang",100.00,2);      

insert into project
values (1,"Xay Nha",50000,"EFO"),
			(2,"Trong Cay",50000,"EFO"),
			(3,"Ban Hang",50000,"EFO"),
			(4,"Da Cap",50000,"EFO"),
			(5,"Hoc Tap",50000,"EFO");

insert into student
values (1,"Anh Tan",1,"2000-12-5","Da Nang") ,           
       (2,"Huu Tuan",3,"1998-06-5","Quang Ngai")  ,
       (3,"Cong Thanh",3,"1995-02-5","Quang Tri")  ,  
		(4,"Duc Tam",2,"1994-09-5","Hue")  ,	
		(5,"Robert",4,"1992-12-5","Gia Lai") ;
        
-- SET SQL_SAFE_UPDATES = 0;      
insert into instructor_student
values (1,1,1,300.00),
		(2,2,2,400.00),
		(3,3,3,200.00),
		(4,4,4,400.00),
		(5,5,5,400.00);
        
        
 -- Phần 1 :
 -- 1.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên
  
  select i.instructor_id, i.instructor_name , f.faculty_name
  from instructor i join faculty f 
  on i.instructor_id = f.faculty_id;
  
-- 2.Đưa ra thông tin gồm mã số, họ tên 
-- và tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’
select i.instructor_id, i.instructor_name , f.faculty_name
from instructor i join faculty f 
on i.faculty_id = f.faculty_id
where f.faculty_name = "Dia Ly va QLTN";


-- 3.	Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’
select count(st.student_id) as "tong_so_sv_khoa"
from student st join
faculty f on st.faculty_id = f.faculty_id
where f.faculty_name = "CONG NGHE SINH HOC";

-- 4.	Đưa ra danh sách gồm mã số, 
-- họ tên và tuổi của các sinh viên khoa ‘TOAN’

SELECT st.student_id , st.student_name , st.date_of_birth
from student st join faculty f 
on st.faculty_id = f.faculty_id
where f.faculty_name = "Toan";

-- 5.	Cho biết số giảng viên của khoa ‘CONG NGHE SINH HOC’

select count(i.instructor_id) as "tong_giang_vien" 
from instructor i join faculty f
on i.faculty_id =  f.faculty_id
WHERE f.faculty_name = "CONG NGHE SINH HOC";


-- 6. Cho biết thông tin về sinh viên không tham gia thực tập
select * from student st
where st.student_id not in (select sub_qry.id from (select `is`.student_id as id from instructor_student `is`
								join student st on st.student_id = `is`.student_id 
                                join project pj on `is`.project_id = pj.project_id) sub_qry);


-- 7. Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
select f.faculty_id , f.faculty_name , count(i.instructor_id)
from faculty f left join instructor i 
on f.faculty_id = i.faculty_id
group by f.faculty_id;

-- 8.	Cho biết số điện thoại của khoa mà sinh viên có tên ‘Le van son’ đang theo học
select f.phone 
from faculty f
join student s on f.faculty_id = s.faculty_id
where s.student_name = "Le Van Son";

-- Phần 2.
-- 1.	Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn
-- 2.	Cho biết tên đề tài không có sinh viên nào thực tập
-- 3.	Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên.
-- 4.	Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
-- 5.	Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập
-- 6.	Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘DIALY và QLTN’
-- 7.	Đưa ra tên khoa, số lượng sinh viên của mỗi khoa
-- 8.	Cho biết thông tin về các sinh viên thực tập tại quê nhà
-- 9.	Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập
-- 10.	 Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0;

-- 1.	Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn

SELECT p.project_id , p.project_name
from project p join instructor_student `is`
on p.project_id = `is`.project_id
join instructor i on i.instructor_id = `is`.instructor_id
where i.instructor_name = "Tran Son";


-- 2. Cho biết tên đề tài không có sinh viên nào thực tập

;
SELECT p.project_name 
from project p 
where p.project_id not in (SELECT id from (select `is`.project_id as id from instructor_student `is`
											join project p on `is`.project_id = p.project_id
                                            join student s on s.student_id = `is`.student_id) sub_qry);
                                            
-- 3.	Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên.

select i.instructor_id , i.instructor_name , f.faculty_name, count(st.student_id) as tong_so
from instructor i join faculty f on i.faculty_id = f.faculty_id
join instructor_student `is` on `is`.instructor_id = i.instructor_id
join student st on `is`.student_id = st.student_id
group by i.instructor_id
having tong_so >=3;  

-- 4.	Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất  

SELECT p.project_id , p.project_name
from project p
WHERE expense = (select max(expense) from project);

-- 5.Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực 
select p.project_id , p.project_name ,count(st.student_id) as tong_so
from project p join instructor_student `is`
on p.project_id = `is`.project_id
join student st on st.student_id = `is`.student_id
GROUP BY p.project_id
having tong_so > 2;


-- 6.	Đưa ra mã số, họ tên 
--      và điểm của các sinh viên khoa ‘DIALY và QLTN’

select st.student_id , st.student_name,  `is`.grade
from student st join faculty f 
on f.faculty_id = st.faculty_id
join instructor_student `is` on
`is`.student_id = st.student_id
where  f.faculty_name = "DIALY và QLTN"
group by student_id;

-- 7 .Đưa ra tên khoa, số lượng sinh viên của mỗi khoa
select f.faculty_name , count(st.student_id)
from faculty f left join student st on
f.faculty_id = st.faculty_id
group by f.faculty_id ;

-- 8 Cho biết thông tin về các sinh viên thực tập tại quê nhà
select st.*
from student st join instructor_student `is`
on `is`.student_id = st.student_id
join project p on p.project_id = `is`.project_id
where st.place_of_birth = p.place_of_intern
GROUP BY st.student_id;



-- 9 Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập
SELECT st.* from instructor_student as `is`
right join student st on st.student_id = `is`.student_id
where `is`.grade is null  ; 
                            
-- 10 Đưa ra danh sách gồm mã số, họ tên các sinh 
-- viên có điểm thực tập bằng 0     

select st.student_id , st.student_name from student st
join instructor_student `is`
on `is`.student_id = st.student_id
where `is`.grade = 0;                   

