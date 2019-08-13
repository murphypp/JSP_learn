use study_db;


/*
 1.查询 "001" 课程比 "002" 课程成绩高的所有学生的学号；
 查询学生的001课程和002课程的成绩，然后进行比较
 */
select * from t_student where (
    (
        select score
        from t_score where t_score.student_id=t_student.student_id
        and course_id='001'
    )
        >
    (
        select score
        from t_score where t_score.student_id=t_student.student_id
        and course_id='002'
    )
);
/*
 2.查询平均成绩大于60分的同学的学号和平均成绩：
 查询各学生的平均成绩，然后筛选出大于60分的
 */
select  t_score.student_id ,avg(score) as avg_score
from t_student,t_score
having  avg_score>60;
/*
    3..查询所有同学的学号、姓名、选课数、总成绩
    主要是连接表，以学生id分组得到每个学生的选课信息，然后使用count和sum函数
 */
select  t_score.student_id,student_name,count(course_id),sum(score)
from t_student,t_score
where t_student.student_id=t_score.student_id
group by t_student.student_id;
/*
 4。查询 姓 李 同学的个数
 利用like关键字模糊查询，以李开头是 李%
 以李结束是 %李
 包含李是 %李%
 */
select count(*) from t_student
where student_name like '李%';
/*
 5.查询没有 003课程成绩的学生
 也就是在score表中不存在这样一个学生：学了003课程
 */
select * from t_student
where not exists(
    select * from t_score
    where course_id='003'
    and t_score.student_id=t_student.student_id
);
/*
 6.查询学过"001"并且也学过编号"002"课程的同学的学号、姓名；
 就是在score表中有这个同学的001课程和002课程的成绩
 */
select student_id,student_name from t_student
where exists(
    select * from t_score
    where t_score.student_id=t_student.student_id
    and course_id in('001','002')
          );
/*
 7.查询所有课程成绩小于70分的同学的学号、姓名
 就是对于student表中的学生，不满足在score表中的平均成绩大于70的条件
 */
select student_id,student_name from t_student
where not exists(
    select * from t_score
    where t_score.student_id=t_student.student_id
    and score>70
          );
/*
 8.查询没有学全所有课的同学的学号、姓名
 就是对于student表中的学生，
 他不满足在score表中的学过课程的数量等于course表中的课程数量
 */
select * from t_student
where not exists(
    select * from t_score
    where t_score.student_id=t_student.student_id
    group by t_score.student_id
    having count(course_id)=(
        select count(*) from t_course
        )
          );
/*
 9.查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分
 只要根据课程分组就可以了
 */
select course_id,max(score),min(score) from t_score
group by course_id;
/*
 10.查询每门课程有成绩的学生数
 也是根据课程分组，统计每一组中的学生数
 */
select course_id, count(student_id) as count_student from t_score
group by course_id;
/*
 11.查询男生、女生人数
 想要在一次查询中查询某列的几种值的数量，只使用where条件是无法完成的
 查阅资料后发现可以通过在sum函数中设置条件来统计数量
 */
select sum(case when gender='m'then 1 else 0 end ) as 男生人数,
       sum(case when gender='w'then 1 else 0 end ) as 女生人数
from t_student;
/*
 12.统计同名同姓人数
 也就是在student表中的学生，同名同姓即满足：在student表中有相同姓名的数量大于1
 */
select count(*)/2 as 同名同姓人数 from t_student t1
where exists(
    select * from t_student t2
    where t1.student_name=t2.student_name
    having count(*)>1
          )
