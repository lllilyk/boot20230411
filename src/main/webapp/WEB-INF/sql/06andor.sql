USE w3schools;

-- AND
SELECT * 
FROM Customers
WHERE CustomerId > 4 AND Country = 'Germany';

SELECT *
FROM Employees
WHERE LastName >= 'M' AND BirthDate > '1960-01-01';

-- 카테고리 ID가 2이고 가격이 20이상인 상품들을 조회
SELECT * FROM Products
WHERE CategoryID = 2 AND PRICE > 20;

SELECT * FROM Employees
WHERE BirthDate >= '1950-01-01' AND BirthDate <= '1959-12-31';

-- OR
SELECT * FROM Customers
WHERE Country = 'Germany';

SELECT * FROM Customers
WHERE Country = 'France';

SELECT * FROM Customers
WHERE Country = 'Germany' OR Country = 'France';

-- city : london or madrid
SELECT * FROM Customers
WHERE City = 'London' OR City = 'Madrid';

SELECT * FROM Categories
WHERE CategoryID = 1 OR CategoryID = 2;
