USE Board;

DESC Board;
INSERT INTO Board (title, body, writer)
SELECT title, body, writer FROM Board;

SELECT COUNT(*) FROM Board;
