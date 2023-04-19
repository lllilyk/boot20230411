-- NOT NULL : NULL 허용 안함 
-- NOT NULL 설정해두면 좋음
CREATE TABLE MyTable17 (
	Col1 INT,
    Col2 INT NOT NULL
);

INSERT INTO MyTable17(Col1, Col2)
VALUES (100, 200);

INSERT INTO MyTable17(Col2)
VALUES(200); -- OK

-- NULL을 허용하지 않겠다고 설정해두었으므로 실패
INSERT INTO MyTable17(Col1)
VALUES(100); -- FAIL

-- 연습 MyTable18 만들기(두 개의 컬럼, varchar(20)
-- col2만 NOT NULL 제약사항을 적용해서 테이블 만들기

CREATE TABLE MyTable18 (
	Col1 VARCHAR(20),
    Col2 VARCHAR(20) NOT NULL
);

INSERT INTO MyTable18(Col2)
VALUES(1212); -- OK

INSERT INTO MyTable18(Col1)
VALUES(1212); -- FAIL

DESC MyTable18;


-- DEFAULT와 NOT NULL의 차이
CREATE TABLE MyTable19 (
	Col1 INT DEFAULT 0,
    Col2 INT NOT NULL
);
DESC MyTable19;
INSERT INTO MyTable19 (Col1, Col2)
VALUES (100, 200); -- OK

INSERT INTO MyTable19 (Col2)
VALUES (200); -- OK

INSERT INTO MyTable19 (Col1)
VALUES (100); -- FAIL

SELECT * FROM MyTable19;

-- 값을 넣지 않으면 기본값으로 입력되지만 
-- 아래와 같은 경우는 NULL이라는 값을 명시적으로 입력
-- 값을 넣지않은것과는 다름
INSERT INTO MyTable19 (Col1, Col2)
VALUES (NULL, 200); -- OK

-- not null default 조합 가능
CREATE TABLE MyTable20 (
	Col1 INT, -- NULL 허용, DEFAULT 없음
    Col2 INT NOT NULL, -- NULL 허용 안함, DEFAULT 없음
    Col3 INT DEFAULT 0, -- NULL 허용, DEFAULT 0
    Col4 INT NOT NULL DEFAULT 0 -- NULL 허용 안함, DEFAULT 0
);

DESC MyTable20;
