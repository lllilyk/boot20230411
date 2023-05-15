USE Board;

SELECT * FROM Board;

-- login한 사람만 & 한 사람당 좋아요 하나만 가능하도록
CREATE TABLE BoardLike(
	boardId INT NOT NULL,
    memberId VARCHAR(20) NOT NULL,
	PRIMARY KEY (boardId, memberId),
    FOREIGN KEY (boardId) REFERENCES Board(id),
    FOREIGN KEY (memberId) REFERENCES Member(id)
);

SELECT * FROM BoardLike;
