-- limit m : 위에서부터 m개
-- limit 0, m 과 limit m은 같음

-- limit n, m : n번부터 m개

SELECT * FROM Customers ORDER BY CustomerID;

-- index는 0부터!
SELECT * FROM Customers ORDER BY CustomerID LIMIT 3;
SELECT * FROM Customers ORDER BY CustomerID LIMIT 0, 3;

-- 4번부터 6번까지 조회하고 싶을 때
SELECT * FROM Customers ORDER BY CustomerID;
SELECT * FROM Customers ORDER BY CustomerID LIMIT 3, 3;

-- 두 번째로 나이가 많은 직원 조회
SELECT * FROM Employees ORDER BY BirthDate;
SELECT * FROM Employees ORDER BY BirthDate limit 1, 1;

-- 2번 카테고리 상품 중 두 번째로 가격이 비싼 상품 조회
SELECT * FROM Products WHERE CategoryID = 2 ORDER BY Price DESC;
SELECT * FROM Products WHERE CategoryID = 2 ORDER BY Price DESC LIMIT 1, 1;
