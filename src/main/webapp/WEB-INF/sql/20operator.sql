-- 산술연산 가능 :  +, -, *, /, %
SELECT * FROM Products;
SELECT ProductName, Price * 1300 FROM Products;
SELECT ProductName, Price * 1300 wonPrice FROM Products;

SELECT ProductName, Price / 100 FROM Products;
SELECT ProductName, Price + 100 FROM Products;
SELECT ProductName, Price - 100 FROM Products;

-- 문자열 연결
SELECT City + Country FROM Customers; -- x
SELECT CONCAT(City, Country) FROM Customers; -- O
SELECT CONCAT(City, "," , Country) FROM Customers; -- O
SELECT CONCAT(City, " " , Country) FROM Customers; -- O
-- as
SELECT CONCAT(City, "," , Country) cityOfCountry 
FROM Customers; -- O

-- 직원 이름 "firstName, lastName" 형식으로 조회
SELECT CONCAT(firstName, ", ", lastName) AS EmployeeName FROM Employees;

-- 원화(*1300)로 10만원 이상인 상품들 조회
SELECT * FROM Products 
WHERE Price*1300 >= 100000;

SELECT * FROM Products
WHERE Price*1000 >= 100000;

SELECT ProductName, Price*1300 FROM Products;

-- 부분 문자열 : substring
-- 첫 번째 파라미터 : 원본 문자열
-- 두 번째 파라미터 : 시작 인덱스
-- 세 번째 파라미터 : 길이 
-- 첫 글자는 인덱스 1
SELECT SUBSTRING('hello world', 3, 3);

SELECT SUBSTRING('ppyong', 3, 3);
SELECT CustomerName FROM Customers;
SELECT SUBSTRING(CustomerName, 1, 3) FROM Customers;

-- 고객 테이블에서 고객명, 나라이름(앞3글자만) 조회
SELECT CustomerName, substring(Country, 1, 3) Country FROM Customers;

