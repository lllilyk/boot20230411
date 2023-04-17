-- group by : 집계 함수를 그룹별로 리턴할 때 사용

SELECT SUM(Price) FROM Products;

SELECT SUM(Price) FROM Products
GROUP BY CategoryID;
SELECT CategoryID, SUM(Price) FROM Products GROUP BY CategoryID;

SELECT Country, COUNT(CustomerID) FROM Customers
GROUP BY Country; 

-- 나라별 고객 수를 나라이름 역순으로 조회
SELECT Country, COUNT(CustomerID) FROM Customers
GROUP BY Country
ORDER BY Country DESC;

-- 고객이 많은 나라순으로 조회
SELECT Country, COUNT(CustomerID) FROM Customers
GROUP BY Country
ORDER BY 2 DESC;

-- 고객이 가장 많은 나라 조회
SELECT Country, COUNT(CustomerID) FROM Customers
GROUP BY Country
ORDER BY 2 DESC
LIMIT 0, 1;

-- 카테고리별 상품 가격의 평균
SELECT CategoryID, AVG(Price) FROM Products GROUP BY CategoryID;

-- 카테고리별 가장 비싼 상품의 가격 조회
SELECT CategoryID, MAX(Price) FROM Products GROUP BY CategoryID;

-- 카테고리별 가장 싼 상품의 가격 조회
SELECT CategoryID, MIN(Price) FROM Products GROUP BY CategoryID;

-- 상품 가격의 평균이 가장 높은 카테고리 조회
SELECT CategoryId, AVG(Price) FROM Products GROUP BY CategoryID ORDER BY 2 DESC LIMIT 1;

-- 여러 컬럼으로 그루핑
SELECT * FROM Customers;
SELECT Count(CustomerID) FROM Customers;
SELECT Country, COUNT(CustomerID) FROM Customers 
GROUP BY Country;

SELECT * FROM Customers;
SELECT Country, City, COUNT(CustomerID) FROM Customers 
GROUP BY Country, City;

-- 나라별, 도시별 공급자 수 조회
SELECT Country, City, Count(SupplierName) FROM Suppliers 
Group BY Country, City;

