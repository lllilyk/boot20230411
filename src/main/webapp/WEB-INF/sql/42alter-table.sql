-- ALTER TABLE MODIFY COLUMN : 제약사항 추가
CREATE TABLE MyTable28(
	Col1 INT,
    Col2 INT,
    Col3 INT,
    Col4 INT
);

DESC MyTable28;

ALTER TABLE MyTable28 
MODIFY COLUMN Col1 INT UNIQUE;

ALTER TABLE MyTable28 
MODIFY COLUMN Col2 INT NOT NULL;

ALTER TABLE MyTable28 
MODIFY COLUMN Col3 INT DEFAULT 0;

ALTER TABLE MyTable28 
MODIFY COLUMN Col4 INT NOT NULL UNIQUE DEFAULT 100;

-- PRIMARY KEY 추가 
CREATE TABLE MyTable29 (
	Col1 INT,
    Col2 INT,
    Col3 INT
);

-- ADD PRIMARYKEY
ALTER TABLE MyTable29
ADD PRIMARY KEY (Col1, Col2);

DESC MyTable29;

-- 이미 제약사항을 어기고 있는 데이터가 있는 경우에는 제약사항 추가가 어려우므로 확인 & 수정 후 추가