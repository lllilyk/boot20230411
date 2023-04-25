-- UNIQUE : 중복 허용 안함
USE w3schools;

CREATE TABLE MyTable21(
	Col1 INT,
    Col2 INT UNIQUE       -- 각 행의 서로 다른 값을 가지고 있는 column : key
);

DESC MyTable21;

INSERT INTO MyTable21 (Col1, Col2)
VALUES (1, 1); -- OK
INSERT INTO MyTable21 (Col1, Col2)
VALUES (2, 2); -- OK
 
-- UNIQUE 설정이 Col2에만 해당되기 때문에 Col1에는 같은 값이 들어가도 실행됨
INSERT INTO MyTable21 (Col1, Col2)
VALUES (2, 3); -- OK

-- 이미 Col2에 3이 값으로 들어가 있으므로 unique설정에 부합하지 않아서 실패함
INSERT INTO MyTable21 (Col1, Col2)
VALUES (4, 3); -- FAIL

DESC MyTable21; -- key column 확인 가능

-- 예제
CREATE TABLE MyTable22(
	ssn VARCHAR(13) UNIQUE,
    name VARCHAR(20)
);

DESC MyTable22;
INSERT INTO MyTable22 (ssn, name)
VALUES ('1', '정대만'); -- OK

INSERT INTO MyTable22 (ssn, name)
VALUES ('1', '송태섭'); -- FAIL

INSERT INTO MyTable22 (ssn, name)
VALUES (NULL, '채소연'); -- OK

INSERT INTO MyTable22 (ssn, name)
VALUES (NULL, '강백호'); -- OK

SELECT *  FROM MyTable22;
DELETE FROM MyTable22
WHERE NAME = '강백호';

-- PRIMARY KEY(NOT NULL UNIQUE)
CREATE TABLE MyTable23(
	Col1 VARCHAR(20) NOT NULL UNIQUE DEFAULT ''
);

DESC MyTable23;
