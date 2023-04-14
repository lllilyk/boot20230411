SELECT * FROM Customers
WHERE CustomerID >= 10 AND CustomerID < 20;

-- between은 지정된 값(포함) 그 이상, 이하를 의미하므로 주의
SELECT * FROM Customers
WHERE CustomerID BETWEEN 10 AND 19;

SELECT * FROM Employees;

-- 50년대 생 직원들 조회
SELECT * FROM Employees
WHERE BirthDate BETWEEN '1950-01-01' AND '1959-12-31';

-- 50년대 생이 아닌 직원들 조회
SELECT * FROM Employees
WHERE NOT (BirthDate BETWEEN '1950-01-01' AND '1959-12-31');

-- 가격이 10달러대 (10.00부터 19.99달러 사이)의 상품 조회
SELECT * FROM Products
WHERE Price BETWEEN 10.00 AND 19.99;

SELECT * FROM Products
WHERE Price >= 10.00 AND Price < 20.00;
