CREATE DATABASE leetcode183;
USE leetcode183;
CREATE TABLE Customers(
	id INT PRIMARY KEY,
    name VARCHAR(100)
);

INSERT INTO Customers VALUES(1, 'Joe');
INSERT INTO Customers VALUES(2, 'Henry');
INSERT INTO Customers VALUES(3, 'Sam');
INSERT INTO Customers VALUES(4, 'Max');

CREATE TABLE Orders (
	id INT PRIMARY KEY,
    customerId INT,
    FOREIGN KEY (customerId) REFERENCES Customers(id)
);

INSERT INTO Orders VALUES(1, 3);
INSERT INTO Orders VALUES(2, 1);

-- 문제 ) 한번도 주문하지 않은 고객 조회
SELECT * FROM Customers;
SELECT * FROM Orders;

SELECT C.name Customers
FROM Customers C LEFT JOIN Orders O ON C.id = O.CustomerID
WHERE O.id IS NULL;

-- 서브쿼리로 풀어보기
USE leetcode183;
SELECT * FROM Customers;
SELECT * FROM Orders;

SELECT customerId FROM Orders;
SELECT * FROM Customers WHERE id NOT IN (1, 3);
SELECT name FROM Customers 
WHERE id NOT IN (SELECT customerId FROM Orders);

USE w3schools;
SELECT CustomerName FROM Customers
WHERE CustomerID NOT IN (SELECT CustomerID FROM Orders);