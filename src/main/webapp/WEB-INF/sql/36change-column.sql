-- CHANGE COLUMN : 컬럼 변경
 
DESC MyTable13;
ALTER TABLE MyTable13
CHANGE COLUMN Col3 Col13 VARCHAR(20); -- danger!

INSERT INTO MyTable13 (Col13) 
VALUES('가나다라마바사');
SELECT * FROM MyTable13;

-- 7개의 문자열을 가지고 있는 Col13을 3개의 문자열까지만 허락하는 Col3으로는 변경 불가능
ALTER TABLE MyTable13
CHANGE COLUMN Col13 Col3 VARCHAR(3);

-- 연습
ALTER TABLE MyTable13
CHANGE COLUMN Col10 Col20 VARCHAR(20);
DESC MyTable13;