USE Board;

DESC Member;
SELECT * FROM Member;

-- 댓글 테이블
CREATE TABLE Comment (
	id INT PRIMARY KEY AUTO_INCREMENT,
    boardId INT NOT NULL,
	content VARCHAR(500) NOT NULL,
    memberId VARCHAR(20) NOT NULL,
    inserted DATETIME NOT NULL DEFAULT NOW(),
    FOREIGN KEY (boardId) REFERENCES Board(id),
    FOREIGN KEY (memberId) REFERENCES Member(id)
);

INSERT INTO Comment (boardId, content, memberId)
VALUES (32787, '댓글 하나', 'user1');
INSERT INTO Comment (boardId, content, memberId)
VALUES (32787, '댓글 둘', 'user1');
INSERT INTO Comment (boardId, content, memberId)
VALUES (32787, '댓글 셋', 'user1');


