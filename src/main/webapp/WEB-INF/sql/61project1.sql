USE Board;

DESC Board;

CREATE TABLE FileName(
	id INT PRIMARY KEY AUTO_INCREMENT,
	boardId INT NOT NULL,
	fileName VARCHAR(300) NOT NULL,
    FOREIGN KEY (boardId) REFERENCES Board(id)
);

DESC FileName;
SELECT * FROM Board;
SELECT * FROM FileName;
SELECT * FROM Board b JOIN FileName f
ON b.id = f.boardId
WHERE b.id = 32760; -- file 있는 게시물

SELECT * FROM Board b LEFT JOIN FileName f
ON b.id = f.boardId
WHERE b.id = 25582; -- file 없는 게시물도 조회하고 싶으면 left Join하기

SELECT * FROM Board WHERE id = 32758;

SELECT * FROM Board b JOIN FileName f
ON b.id = f.boardId
WHERE b.id = 25582;

-- 첫 페이지의 게시물 5개까지 보기
-- 파일 존재 여부는 알 수 없음 
USE Board;
SELECT * FROM Board 
ORDER BY id DESC
LIMIT 0,5;

-- 최신 5개의 게시물 중 파일이 있는 게시물만 조회
-- fileName만 다른 중복된 게시물도 조회됨
SELECT * 
FROM Board b JOIN FileName f ON b.id = f.boardId 
ORDER BY b.id DESC
LIMIT 0,5;

-- 여러 파일이 있는 게시물까지 중복없이 조회
SELECT *, 
	COUNT(f.id) fileCount
FROM Board b LEFT JOIN FileName f ON b.id = f.boardId 
GROUP BY b.id
ORDER BY b.id DESC
LIMIT 0,5;

SELECT *, 
	COUNT(f.id) fileCount
FROM Board b LEFT JOIN FileName f ON b.id = f.boardId 
WHERE b.id = 32766;

SELECT fileName
FROM Board b JOIN FileName f ON b.id = f.boardId
WHERE fileName IS NOT NULL AND b.id = 32766;