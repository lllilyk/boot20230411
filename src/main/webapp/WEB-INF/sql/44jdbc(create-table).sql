USE w3schools;

CREATE TABLE MyTable33 (
	Title VARCHAR(200),
    Published DATE,
    Price INT,
    Updated DATETIME,
    Weight DEC(10, 3)
);

SELECT * FROM MyTable33;

SELECT * FROM Suppliers WHERE SupplierID = 1;
SELECT EmployeeID FROM Employees WHERE LastName = 'LEE';

SELECT * FROM Customers ORDER BY 1 DESC;
SELECT CustomerID FROM Customers WHERE CustomerName = '정대만';

SELECT * FROM Employees WHERE EmployeeID = 2;

use w3schools;
-- yesterday
SELECT CustomerName FROM Customers;

SELECT LastName FROM Employees;

SELECT * FROM Employees;
SELECT ProductName, Price FROM Products;
SELECT ProductName FROM Products WHERE CategoryID = 5;

SELECT CustomerName FROM Customers WHERE Country = 'CANADA';
SELECT * FROM Products;
SELECT ProductName, Price FROM Products WHERE CategoryID = 3;

CREATE TABLE MyTable34(
	Col1 INT,
    Col2 VARCHAR(30)
);

INSERT INTO MyTable34 (Col1, Col2)
VALUES (99, 'hello');

SELECT * FROM MyTable34;

CREATE TABLE MyTable35(
	Col1 Dec(3,2),
    Col2 VARCHAR(30)
);

SELECT * FROM MyTable35;

CREATE TABLE MyTable36(
	Col1 INT,
    Col2 VARCHAR(50),
    Col3 DEC(10, 2)
);

INSERT INTO MyTable36 (Col1, Col2, Col3)
VALUES (22, 'hello', 3.14);

SELECT * FROM MyTable36;

CREATE TABLE MyTable37(
	Age INT,
    Name VARCHAR(30),
    Score DEC(10, 3)
);

SELECT * FROM MyTable37;

CREATE TABLE MyTable38(
	Col1 INT,
    Col2 INT,
    Col3 VARCHAR(200),
	Col4 VARCHAR(200),
    Col5 DEC(10, 3),
    Col6 DEC(10, 3)
);
