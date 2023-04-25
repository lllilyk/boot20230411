USE w3schools;

CREATE DATABASE leetcode175;
USE leetcode175;

CREATE TABLE Person (
	personId INT PRIMARY KEY,
    lastName VARCHAR(200),
    firstName VARCHAR(200)
);

INSERT INTO Person VALUES(1, 'Wang', 'Allen');
INSERT INTO Person VALUES(2, 'Alice', 'Bob');

SELECT * FROM Person;
DESC Person;

CREATE TABLE Address (
	addressId INT PRIMARY KEY,
    personId INT,
    city VARCHAR(200),
    state VARCHAR(200)
);

INSERT INTO Address VALUES(1, 2, 'New York City', 'New York');
INSERT INTO Address VALUES(2, 3, 'Leetcode', 'California');

SELECT * FROM Address;

-- 문제) 각 인물의 firstName, lastName, city, state를 조회하는 쿼리 작성
-- 주소가 없으면 city, state에 null이 출력되도록 작성
SELECT P.firstName, P.lastName, A.city, A.state
FROM Person P LEFT JOIN Address A ON P.personId = A.personId;

-- 서브쿼리로 풀어보기
USE leetcode175;
SELECT * FROM Person;
SELECT * FROM Address;
SELECT firstName,
	   lastName,
       (SELECT city 
       FROM Address 
       WHERE personId = p.personId) city,
       (SELECT state 
       FROM Address 
       WHERE personId = p.personId) state
FROM Person p;

