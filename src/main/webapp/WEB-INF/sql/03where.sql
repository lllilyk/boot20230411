-- Customers 테이블의 모든 필드 조회
SELECT * FROM Customers

-- WHERE : 특정 레코드를 선택하는 조건절
WHERE Country = 'Mexico';

-- UK 라는 Country 값을 가지는 레코드만 조회
SELECT * FROM Customers
WHERE Country = 'UK';

SELECT * FROM Customers
-- 문자열 필드 값은 작은 따옴표
WHERE Country = 'France';

SELECT * FROM Customers
-- 수 필드값은 따옴표 생략 가능
WHERE CustomerID = 3;

SELECT * FROM Customers
-- 대소문자 구분 안함
WHERE Country = 'france';

-- CustomerName 필드만 조회(Country가 france인) 
SELECT CustomerName FROM Customers
WHERE Country = 'france';

-- Country가 USA인 공급자의 이름과 주소
SELECT SupplierName, Address FROM Suppliers
WHERE Country = 'USA';