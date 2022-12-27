/*
DROP TABLE Favorite

DROP TABLE Img;
DROP TABLE Message;
DROP TABLE Article;
DROP TABLE Member;


SELECT * FROM Member;
SELECT * FROM Article;
SELECT * FROM Message;
SELECT * FROM Img;
*/

/*------------------------------------------------------------------------------*/

create table member (
	memberPk int not null identity(1,1) primary key,
	memberId varchar(32) UNIQUE,
	name varchar(32),
	password varchar(32),
	location nchar(64),
	email varchar(64),
	phone varchar(32),
	userType varchar(32),
	registerTime datetime,
	memberImage varbinary(max),
	lastLogin datetime,
	verification int,
	permission int
)

/*------------------------------------------------------------------------------*/

CREATE TABLE Article(

	articleId INT PRIMARY KEY IDENTITY(0,1),
	memberId_fk VARCHAR(32) NOT NULL,
	updateTime DATETIME NOT NULL,
	topicName VARCHAR(10) NOT NULL,	
	title VARCHAR(50) UNIQUE,
	content NVARCHAR(MAX) NOT NULL,
	"like" INT,
	dislike INT,
	"status" NVARCHAR(50),

	FOREIGN KEY (memberId_fk)   REFERENCES  Member(memberId)

);

/*------------------------------------------------------------------------------*/

CREATE TABLE Message(
	articleId_fk INT NOT NULL,
	messageId INT IDENTITY(1,1) PRIMARY KEY,
	authorId  VARCHAR(32) NOT NULL,
	updateTime DATETIME NOT NULL,
	content NVARCHAR(MAX) NOT NULL,
	"status" VARCHAR(32) NOT NULL,
	"like" INT,
	"dislike" INT,

	FOREIGN KEY (articleId_fk)  REFERENCES  Article(articleId),
);

/*------------------------------------------------------------------------------*/

CREATE TABLE img(
	imgNo INT PRIMARY KEY IDENTITY(0,1),
	articleId_fk INT,
	imgName VARCHAR(MAX),
	img VARBINARY(MAX),

	FOREIGN KEY (articleId_fk)  REFERENCES  Article(articleId),
);
