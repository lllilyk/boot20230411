USE w3schools;

-- DROP TABLE : 테이블 삭제
-- DANGER!!!!!!!!!!!!!!!!!!!!!!!

DESC MyTable01;

DROP TABLE MyTable01;

DROP TABLE MyTable02, MyTable03; -- 주의

-- WARNING
-- TRUNCATE : 테이블 유지, 데이터 삭제(복구 불가)
SELECT * FROM MyTable04;
TRUNCATE MyTable04; -- 주의