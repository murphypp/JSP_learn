-- 1.查询 "001" 课程比 "002" 课程成绩高的所有学生的学号；(子查询/连表)
SELECT x.student_id  FROM ( SELECT student_id,score FROM t_score where course_id='001') as x 
LEFT JOIN( SELECT student_id ,score FROM t_score where course_id='002') as y ON x.student_id=y.student_id
WHERE x.score>y.score


-- 2.查询平均成绩大于60分的同学的学号和平均成绩
SELECT student_id, AVG(score)
FROM t_score GROUP BY student_id


-- 3.查询所有同学的学号、姓名、选课数、总成绩(比较有难度 group by 和 函数)
SELECT  x.student_id,student_name,count(course_id)as '选课数',sum(score) as'总成绩'
FROM t_student x LEFT JOIN t_score y on x.student_id=y.student_id 
GROUP BY x.student_id ,x.student_name


-- 4.查询 姓 李 同学的个数(考察like和count)
SELECT COUNT(student_id) FROM t_student
WHERE student_name like '李%'


-- 5.查询没有 003课程成绩的学生
SELECT student_id,student_name
FROM t_student 
WHERE NOT EXISTS(
SELECT student_id
FROM t_score
WHERE t_score.course_id='003'
			AND t_score.student_id=t_student.id)


-- 6.查询学过"001"并且也学过编号"002"课程的同学的学号、姓名；
SELECT x.student_id,student_name
FROM t_score x,t_student y
WHERE x.student_id=y.student_id AND course_id='001' 
			AND x.student_id in(SELECT student_id FROM t_score WHERE course_id='002')


-- 7.查询所有课程成绩小于70分的同学的学号、姓名；
SELECT x.student_id,student_name
FROM t_student x LEFT JOIN t_score y on x.student_id=y.student_id 
GROUP BY x.student_name,x.student_id
HAVING MAX(score)<70


-- 8.查询没有学全所有课的同学的学号、姓名；
select student_id,student_name 
from t_student x
WHERE (SELECT COUNT(*) FROM t_score y WHERE x.student_id=y.student_id)<(SELECT COUNT(*) from t_course)


-- 9.查询各科成绩最高和最低的分：以如下形式显示：课程ID，最高分，最低分
SELECT course_id,MAX(score),MIN(score)
FROM t_score GROUP BY course_id

-- 10.查询每门课程有成绩的学生数
SELECT course_id,COUNT(*)
FROM t_score
GROUP BY course_id


-- 11.查询男生、女生人数
SELECT gender ,COUNT(*) FROM t_student GROUP BY gender


-- 12.统计同名同姓人数
SELECT student_name , COUNT(*)
FROM t_student
GROUP BY student_name 
HAVING COUNT(*)>1