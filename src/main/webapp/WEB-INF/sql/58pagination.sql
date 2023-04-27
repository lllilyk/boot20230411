USE w3schools;

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



