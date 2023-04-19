-- Character (String) 문자형
-- VARCHAR(길이) : 길이가 가변적인 문자형
CREATE TABLE MyTable02(
	Col1 VARCHAR(3),
    Col2 VARCHAR(5)
);
-- 설정한 길이만큼 꽉 채우는 것 ok
INSERT INTO MyTable02 (Col1, Col2) 
VALUES ('abc', 'abcde'); -- ok

SELECT * FROM MyTable02;

-- 설정한 길이보다 작은 값 넣기 ok
INSERT INTO MyTable02 (Col1, Col2)
VALUES ('ab', 'abc'); -- ok

-- 설정한 길이보다 긴 값을 넣는 것 X
INSERT INTO MyTable02 (Col1, Col2)
VALUES ('abcd', 'abcdef'); -- x

-- MyTable03 연습문제
CREATE TABLE MyTable03(
	Col1 VARCHAR(10),
    Col2 VARCHAR(100),
    Col3 VARCHAR(1000)
);
DESC MyTable03;
SELECT * FROM MyTable03;
INSERT INTO MyTable03 (Col1, Col2, Col3)
VALUES ('ABCDEFGHIJ', 'ASFASDFASFASFASFSDF', 'ASFASDFASDFASDFASFASDFASFASFASD');

-- Numeric (수)

-- int 정수형
-- 최대값 : 2147483647
-- 최소값 : -2147483648

CREATE TABLE MyTable04 (
	Col1 INT
);

DESC MyTable04;
SELECT * FROM MyTable04;

INSERT INTO MyTable04(Col1) VALUES (33); -- ok

INSERT INTO MyTable04(Col1)
VALUES (1234567890); -- ok

INSERT INTO MyTable04(Col1)
VALUES (999999999); -- ok

INSERT INTO MyTable04(Col1)
VALUES (3.14); -- 소수점 이하 생략

-- MyTable05 만들기 연습
CREATE TABLE MyTable05 (
	Cal1 INT,
    Cal2 INT
);

DESC MyTable05;
SELECT * FROM MyTable05;

INSERT INTO MyTable05(Cal1, Cal2)
VALUES (33, 222222);

-- DEC(Decimal) 실수형
-- DEC(총 길이, 소수점 이하 길이)
CREATE TABLE MyTable06(
	Col1 DEC(5, 2),
    Col2 DEC(3, 1)
);
INSERT INTO MyTable06(Col1) VALUES (999.99); -- OK
INSERT INTO MyTable06(Col1) VALUES (-999.99); -- OK

INSERT INTO MyTable06(Col1) VALUES (1000.99); -- FAIL
INSERT INTO MyTable06(Col1) VALUES (999.999); -- FAIL

INSERT INTO MyTable06(Col2) VALUES(11.1);
INSERT INTO MyTable06(Col2) VALUES(-11.1);
SELECT * FROM MyTable06;

DESC MyTable06;

-- MyTable07 만들기
CREATE TABLE MyTable07(
	Col1 DEC(3, 2),
    Col2 DEC(2, 1)
);
DESC MyTable07;

INSERT INTO MyTable07(Col1, Col2)
VALUES (1.11, 1.1);

SELECT * FROM MyTable07;

-- 날짜 시간
-- DATE 날짜 (YYYY-MM-DD)
-- DATETIME 날짜 시간 (YYYY-MM-DD hh:mm:ss)

CREATE TABLE MyTable08(
	Col1 DATE, 
    Col2 DATETIME
);

DESC MyTable08;
INSERT INTO MyTable08(Col1) 
VALUES ('2023-04-19');

-- 최대
INSERT INTO MyTable08(Col1) 
VALUES ('9999-12-31');

-- 최소
INSERT INTO MyTable08(Col1) 
VALUES ('1000-01-01');

INSERT INTO MyTable08(Col2)
VALUES ('2023-04-19 11:41:30'); 

INSERT INTO MyTable08(Col2)
VALUES ('9999-12-31 23:59:59');

INSERT INTO MyTable08(Col2)
VALUES ('1000-01-01 00:00:00');

SELECT * FROM MyTable08;

SELECT NOW();

INSERT INTO MyTable08(Col1, Col2)
VALUES (now(), now() );

-- 예제) MyTable09(학생 정보)
-- 학생 이름, 성별, 생년월일, 기타정보, 시험성적
CREATE TABLE MyTable09(
	Name VARCHAR(20),
    Gender VARCHAR(1),
    BirthDate DATE,
    Score DEC(5, 2),
    Extra VARCHAR(1000)
);

DESC MyTable09;

INSERT INTO MyTable09(Name, Gender, BirthDate, Score, Extra)
VALUES ('손흥민', '여', '2000-02-02', 99.99, '축구선수');

SELECT * FROM MyTable09;

-- 연습) 내가 가지고 있는 교재 정보 
CREATE TABLE MyTable10(
	java VARCHAR(100),
    spring VARCHAR(50),
    jsp VARCHAR(20)
);

DESC MyTable10;

INSERT INTO MyTable10(java, spring, jsp)
VALUES('이것이 자바다', 'MYSPRING', '어쩌고 JSP');

SELECT * FROM MyTable10; 

CREATE TABLE MyTable100(
	Title VARCHAR(100),
    Writer VARCHAR(50),
	Publisher VARCHAR(20),
    PublishedD DATE,
    Price Int,
    Extra VARCHAR(100)
);

DESC MyTable100;

INSERT INTO MyTable100
VALUES('이것이 자바다', '신용권', '한빛', '2022-01-01', 30000, '평점 좋음');

SELECT * FROM MyTable100;