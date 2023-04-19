-- DATABASE(SCHEMA) : 테이블이 있는 곳

-- CREATE DATABASE : DATABASE 만들기
CREATE DATABASE mydb;
USE mydb;

-- 테이블을 만들 때 현재 어떤 DB를 사용하고 있는지 확인할 것
CREATE TABLE MyTable11 (
	Title VARCHAR(10),
    Price INT
);

-- DROP DATABASE 데이터베이스 지우기
-- 주의*10000000000000000
DROP DATABASE mydb; -- MyTable11도 mydb랑 같이 떠나가버림..

USE w3schools;

-- mydb1 데이터베이스 만들기
-- mydb1에 새로운 테이블 만들기
-- mydb1 데이터베이스 삭제하기
-- w3schools 데이터베이스 사용하기 순서대로

CREATE DATABASE mydb1;
USE mydb1;
CREATE TABLE MyTable11(
	Title VARCHAR(10),
    Price INT
);
DROP DATABASE mydb1;
USE w3schools;

-- 같은 db에 있는 경우
SELECT * FROM MyTable10;

USE test;
-- 다른 db에 있는 경우
-- db명을 테이블명 앞에 작성하고 .온점으로 연결
SELECT * FROM w3schools.MyTable10;

USE w3schools;
