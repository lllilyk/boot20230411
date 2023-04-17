-- null과의 연산은 모두 false
SELECT * FROM Products WHERE CategoryID = 2;
SELECT * FROM Products
WHERE CategoryID = 2
	AND PRICE >= 25.00; -- 4 rows returned
    
SELECT * FROM Products
WHERE CategoryID = 2
	AND PRICE < 25.00; -- 8 rows returned
    
SELECT * FROM Products
WHERE CategoryID = 2
	AND IFNULL(Price, 0) < 25.00; -- 10 rows returned
    
-- NULL을 쓰고 싶으면 IS NULL이용
SELECT * FROM Products
WHERE CategoryID = 2
	AND Price IS NULL;
    
SELECT ProductName, IFNULL(Price, 0) * 1300 FROM Products
WHERE CategoryID = 2; -- 산술 연산 결과도 null


