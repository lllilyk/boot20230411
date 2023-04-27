CREATE DATABASE Board;
USE Board;
-- 테이블명 : UpperCamelCase
-- 컬럼명 : lowerCamelCase
-- 제 1 정규형에 만족하는가? PRIMARY KEY 존재여부
CREATE TABLE Board (
	id INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(50) NOT NULL,
    body VARCHAR(1000) NOT NULL,
	writer VARCHAR(20),
    inserted DATETIME DEFAULT NOW()
);

DESC Board;

INSERT INTO Board (title, body, writer)
VALUES ('샘플 제목', '샘플 본문', 'user00');

SELECT * FROM Board ORDER BY id DESC;
