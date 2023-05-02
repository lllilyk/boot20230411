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
WHERE b.id = 410; -- file 없는 게시물도 조회하고 싶으면 left Join하기

SELECT * FROM Board WHERE id = 32758;
