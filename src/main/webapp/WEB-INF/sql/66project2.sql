USE Board;

-- 게시물의 좋아요 수
SELECT b.id,
	   b.title,
       b.body,
       b.inserted,
       b.writer,
       f.fileName,
       (SELECT COUNT(*) FROM BoardLike WHERE boardId = b.id) countLike
FROM Board b LEFT JOIN FileName f ON b.id = f.boardId
WHERE b.id = 32794;

SELECT * FROM BoardLike;
SELECT * FROM FileName;