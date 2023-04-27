USE w3schools;
INSERT INTO Customers (CustomerName, ContactName, Address, City, Country)
SELECT CustomerName, ContactName, Address, City, Country
FROM Customers; 
-- 전체 레코드를 한 번 더 추가