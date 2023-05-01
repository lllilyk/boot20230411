USE w3schools;
<<<<<<< HEAD
INSERT INTO Customers 
(CustomerName, ContactName, Address, City, Country)
SELECT CustomerName, ContactName, Address, City, Country
FROM Customers;

SELECT COUNT(*) FROM Customers;

DESC Customers;

-- 1 페이지
-- 페이지당 20개 레코드
SELECT * FROM Customers
ORDER BY CustomerID DESC;
SELECT * FROM Customers
ORDER BY CustomerID DESC
LIMIT 0, 20; -- 1 페이지

SELECT * FROM Customers
ORDER BY CustomerID DESC
LIMIT 20, 20; -- 2 페이지

SELECT * FROM Customers
ORDER BY CustomerID DESC
LIMIT 40, 20; -- 3 페이지
=======

INSERT INTO Customers (CustomerName, ContactName, Address, City, Country)
SELECT CustomerName, ContactName, Address, City, Country
FROM Customers; 

-- 전체 레코드(91rows)를 한 번 더 추가
SELECT COUNT(*) FROM Customers; -- 182

-- 세 번 추가
SELECT COUNT(*) FROM Customers; -- 728

-- 페이지당 20개 레코드
-- 1페이지
SELECT * FROM Customers
ORDER BY CustomerID DESC 
LIMIT 0, 20; 

-- 2페이지
SELECT * FROM Customers
ORDER BY CustomerID DESC 
LIMIT 20, 20; 

-- 3페이지
SELECT * FROM Customers
ORDER BY CustomerID DESC 
LIMIT 40, 20; 