-- PRIMARY KEY : NOT NULL + UNIQUE
CREATE TABLE MyTable24(
	Col1 INT PRIMARY KEY
);
DESC MyTable24;
DESC MyTable23;

-- primary key 제약사항을 아래처럼 따로 주는 것도 가능
CREATE TABLE MyTable25 (
	Col1 INT,
    PRIMARY KEY(Col1)
);
DESC MyTable25;

CREATE TABLE MyTable26 (
	Col1 INT,
    Col2 INT,
    PRIMARY KEY(Col1, Col2) -- (Col1, Col2)의 조합이 유일하도록 제약
);
DESC MyTable26;

INSERT INTO MyTable26(Col1, Col2)
VALUES (1, 1); -- OK

INSERT INTO MyTable26(Col1, Col2)
VALUES (2, 2); -- OK

INSERT INTO MyTable26(Col1, Col2)
VALUES (1, 2); -- OK

-- primary key는 하나의 테이블에 하나까지(없거나) 존재 가능
CREATE TABLE MyTable27 (
	Col1 INT,
    Col2 INT,
    PRIMARY KEY(Col1),
    PRIMARY KEY(Col2)
); -- fail

DESC MyTable27;

-- 제약 사항 (CONSTRAINTS)
-- DEFAULT, UNIQUE, NOT NULL, PRIMARY KEY

-- 이미 만들어진 테이블에 제약 사항을 추가하는 것도 가능