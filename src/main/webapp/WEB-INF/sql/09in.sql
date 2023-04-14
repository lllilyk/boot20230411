-- in 특정 값 중에 있으면..
SELECT * FROM Customers
WHERE Country = 'Germany' OR Country = 'France';

SELECT * FROM Customers
WHERE Country IN ('Germany', 'France');

-- 3, 5번 카테고리에 속한 상품들 조회
SELECT * FROM Products
WHERE CategoryID IN(3, 5);

-- 1,3,5,7번 카테고리에 속한 상품들 조회 : 이런 경우에는 IN이 훨씬 편리
SELECT * FROM Products
WHERE CategoryID = 1
	OR CategoryID = 3
    OR CategoryID = 5
    OR CategoryID = 7;
    
SELECT * FROM Products
WHERE CategoryID IN(1, 3, 5, 7);

-- Berlin, London, Madrid, Paris 에 있는 고객들 조회
SELECT * FROM Customers
WHERE City IN ('Berlin', 'London', 'Madrid', 'Paris');

-- Berlin, London, Madrid, Paris 에 있지 않는 고객들 조회
SELECT * FROM Customers
WHERE NOT City IN ('Berlin', 'London', 'Madrid', 'Paris');

SELECT * FROM Customers
WHERE City NOT IN ('Berlin', 'London', 'Madrid', 'Paris');

-- 1,3,5,7 카테고리가 아닌 상품들 조회
SELECT * FROM Products
WHERE CategoryID NOT IN(1, 3, 5, 7);


