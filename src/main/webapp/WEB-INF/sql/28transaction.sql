USE w3schools;

-- transaction : 하나의 업무 단위
-- 하나의 transaction은 여러 insert, update ,delete 명령문으로 구성될 수 있다.
-- 하나의 transaction은 동시에 성공하거나 동시에 실패만 가능

-- 예) 이체(A -> B) 5000원
-- A의 돈은 -5000원 UPDATE
-- B의 돈은 +5000원 UPDATE

CREATE TABLE Bank(
	CustomerName VARCHAR(255),
    money INT DEFAULT 0
);
SELECT * FROM Bank;
INSERT INTO Bank VALUES ('A', 100000);
INSERT INTO Bank VALUES ('B', 100000);

-- 이체 5000원 (A -> B)
UPDATE Bank 
SET money = money - 5000
WHERE customerName = 'A';

UPDATE Bank 
SET money = money + 5000
WHERE customerName = 'B';

-- COMMIT : transaction(업무) 완료
-- ROLLBACK : transaction 실패(transaction 시작 이전으로 되돌리기)

-- 자동 커밋 (autocommit)
SET autocommit = 0; -- 자동 커밋 비활성화(disable)
SET autocommit = 1; -- 자동 커밋 활성화(enable)

UPDATE Bank
SET money = money - 5000
WHERE customerName = 'A';
UPDATE Bank
SET money = money + 5000
WHERE customerName = 'B';

SELECT * FROM Bank;
-- 자동 커밋을 비활성화 한 상태이므로 언제든지 transaction이전으로 되돌리는 것이 가능

ROLLBACK; -- 마지막 커밋으로 되돌리기

SELECT * FROM Bank; -- 5000원 입금 이전으로 돌아감

COMMIT; -- transaction 완료
-- COMMIT 이전까지는 transaction 진행 상태. 남들은 변경사항 확인 불가능 

SELECT * FROM Bank; -- COMMIT 이후에는 누구나 변경사항 확인 가능

ROLLBACK;

-- 이체시 오류(A -> B 5000원)
UPDATE Bank
SET money = money - 5000
WHERE customerName = 'A'; -- 실행됨

-- 오류 발생 가정
ROLLBACK; -- 반드시 ROLLBACK해서 복구

SELECT * FROM Bank;