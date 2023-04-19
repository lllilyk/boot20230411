-- null과의 연산은 모두 false
SELECT * FROM Products WHERE CategoryID = 2;
SELECT * FROM Products
WHERE CategoryID = 2
	AND PRICE >= 25.00; -- 4 rows returned

SELECT COUNT(ProductID) FROM Products WHERE CategoryID = 2 AND Price < 25.00; 
SELECT * FROM Products 
WHERE CategoryID = 2 AND Price < 25.00;-- 8 rows returned
    
SELECT COUNT(ProductID) FROM Products WHERE CategoryID = 2 AND IFNULL(Price, 0) < 25.00;
SELECT * FROM Products 
WHERE CategoryID = 2 AND IFNULL(Price, 0) < 25.00;

-- NULL을 쓰고 싶으면 IS NULL이용
SELECT * FROM Products
WHERE CategoryID = 2
	AND Price IS NULL;
    
SELECT * FROM Employees ORDER BY 1 DESC;
SELECT * FROM Employees
WHERE Notes IS NULL AND FirstName = '뿅뿅';
    
SELECT ProductName, IFNULL(Price, 0) * 1300 FROM Products
WHERE CategoryID = 2; -- 산술 연산 결과도 null