CREATE DATABASE leetcode181;
USE leetcode181;
CREATE TABLE Employee(
	id INT PRIMARY KEY,
    name VARCHAR(200),
    salary INT,
    managerId INT
);

INSERT INTO Employee VALUES(1, 'Joe', 70000, 3);
INSERT INTO Employee VALUES(2, 'Henry', 80000, 4);
INSERT INTO Employee VALUES(3, 'Sam', 60000, NULL);
INSERT INTO Employee VALUES(4, 'Max', 90000, NULL);

-- 매니저보다 많은 연봉을 받는 직원 이름 조회
-- 같은 테이블끼리 JOIN하는 것을 SELF JOIN이라고 함

-- SELF JOIN
SELECT e1.name Employee 
FROM Employee e1 JOIN Employee e2
ON e1.managerId = e2.id
WHERE e1.salary > e2.salary;

-- 서브(내부) 쿼리 : 어떤 쿼리 안에 일부 쿼리가 포함되어 있는 것
-- 매니저보다 많은 연봉을 받는 직원 이름 조회

SELECT * FROM Employee e1 JOIN Employee e2;
-- 1) 매니저id와 id가 같은 직원의 연봉
SELECT salary FROM Employee e2 WHERE e2.id = e2.managerId;
-- 2) 그 연봉을 받는 직원은 누구?
SELECT name FROM Employee e1 WHERE salary < (SELECT salary FROM Employee e2 WHERE e2.id = e2.managerId);


SELECT name
FROM Employee e1
WHERE salary > (SELECT salary
				FROM Employee e2
                WHERE e2.id = e1.managerId);
