SELECT * FROM Customers; -- 현재 db의 테이블 조회
SELECT * FROM w3schools.Customers; -- 다른 db의 테이블 조회

USE w3schools; -- 사용할 db 선택하는 명령문
USE test; 

-- <= : 작거나 같다. 
-- >= : 크거나 같다.
SELECT * FROM Products
WHERE Price >= 10.00;

SELECT * FROM Products
WHERE Price <= 10.00;

SELECT * FROM Employees
WHERE Birthdate <= '1958-09-19';