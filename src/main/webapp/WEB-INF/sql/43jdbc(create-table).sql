USE w3schools;

DESC MyTable30;
CREATE TABLE MyTable30 (
	Col1 INT,
    Co12 VARCHAR(30)
);

INSERT INTO MyTable30(Col1, Co12)
VALUES (30, 'JAVA'); -- OK

SELECT * FROM MyTable30;

-- INT 형식에 맞는 String 값은 잘 들어감 (엄격하지 x)
INSERT INTO MyTable30 (Col1)
VALUES ('33'); -- OK

INSERT INTO MyTable30 (Col1)
VALUES ('Three'); -- fail

INSERT INTO MyTable30 (Co12)
VALUES ('JAVA');

-- String 타입으로 변경되어서 값이 잘 들어감
INSERT INTO MyTable30 (Co12)
VALUES (77); -- OK

-- 
CREATE TABLE MyTable31 (
	Col1 DATE, 
    Col2 DATETIME
);

-- DATE : YYYY-MM-DD
-- DATETIME : YYYY-MM-DD HH:mm:SS
INSERT INTO MyTable31 (Col1, Col2)
VALUES ('2023-04-20', '2023-04-20 09:29:12');

SELECT * FROM MyTable31;

CREATE TABLE MyTable32 (
	Name VARCHAR(30),
    Age INT,
    Price DEC(10, 2),
    Birth DATE,
    Inserted DATETIME
);

DESC MyTable32;

SELECT * FROM MyTable32;

SELECT * FROM Suppliers;

CREATE TABLE PPPYONG (
	Number INT,
    Sdate DATE,
    Trip DATETIME,
    School VARCHAR(20),
    ScoreAvg DEC(10,2)
);

DESC PPPYONG;

SELECT * FROM PPPYONG;
DELETE FROM PPPYONG 
WHERE Number = 7;

