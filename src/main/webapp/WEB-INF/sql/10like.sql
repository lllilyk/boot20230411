-- LIKE : 대소문자 구분 X
-- % : A% A로 시작하는 글자
-- _ : A_ A로 시작하는 두 글자
SELECT * FROM Customers WHERE CustomerName LIKE 'A%';