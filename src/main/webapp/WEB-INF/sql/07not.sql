-- not
SELECT * FROM Customers; -- 91
SELECT * FROM Customers WHERE Country = 'Germany'; -- 11
SELECT * FROM Customers WHERE NOT Country = 'Germany'; -- 80

-- london에 있지 않은 고객들 조회
SELECT * FROM Customers WHERE NOT City = 'London';

-- 50년대 생이 아닌 직원들 조회
SELECT * FROM Employees WHERE BirthDate >= '1950-01-01' AND BirthDate <= '1959-12-31';
SELECT * FROM Employees WHERE NOT (BirthDate >= '1950-01-01' AND BirthDate <= '1959-12-31');
SELECT * FROM Employees WHERE BirthDate < '1950-01-01' OR BirthDate > '1959-12-31';

-- 1, 2번 카테고리가 아닌 상품들ALTER
SELECT * FROM Products WHERE NOT CategoryID = 1 AND CategoryID = 2;
SELECT * FROM Products WHERE (NOT CategoryID = 1 OR CategoryID = 2);
SELECT * FROM Products WHERE (CategoryID <> 1 AND CategoryID <> 2);

SELECT CustomerID, CustomerName, Address From Customers
WHERE CustomerID;
