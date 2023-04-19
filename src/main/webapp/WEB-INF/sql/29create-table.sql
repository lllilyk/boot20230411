-- CREATE TABLE : 새 테이블 만들기
-- TABLE 이름 작성 규칙 (회사마다 다름)
-- 우리 과정에서는 UpperCamelCase(테이블명은 대소문자 구별O)
-- lower_snake_case, UPPER_SNAKE_CASE쓰기도 함

CREATE TABLE MyTable01(
	-- 컬럼 정의
    -- 컬럼명 값의 TYPE, ...
    -- 컬럼명 작성규칙(회사 규칙 따르기)
    -- 우리 과정에서는 UpperCamelCase(대소문자 구별X)
	
    Col1 INT,
    Col2 VARCHAR(255)
);
    
SELECT * FROM MyTable01;
-- DESC : 테이블 구조 보기
DESC MyTable01;
INSERT INTO MyTable01 (Col1, Col2)
VALUES (30, '가나다');

SELECT * FROM MyTable01;