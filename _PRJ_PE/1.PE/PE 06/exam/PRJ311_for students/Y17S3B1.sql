create database Y17S3B1
GO
USE Y17S3B1
GO
CREATE TABLE [Blogs](
	[BlogID] [int] IDENTITY(1,1) NOT NULL primary key,
	[BlogName] [varchar](100) NOT NULL,
	[BlogDescription] [text] NULL,
	[DateCreated] [datetime] NULL
)
Go
insert into [Blogs] ([BlogName], [BlogDescription], [DateCreated]) 
VALUES (N'FiftyFourandAHalf', N'At fifty-four-and-a-half..', CAST(0x00009E7E00000000 AS DateTime))
insert into [Blogs] ( [BlogName], [BlogDescription], [DateCreated]) 
VALUES ( N'John Battle''s SearchBlog', N'Thoughts on the intersection of search, media, technology, and more.', 
CAST(0x00009DEB00000000 AS DateTime))
insert into [Blogs] ( [BlogName], [BlogDescription], [DateCreated]) 
VALUES ( N'Kitchen Slattern', N'Eat well. Drink more. Work less.', CAST(0x00009E9E00000000 AS DateTime))
GO
CREATE TABLE [Categories](
	[CategoryID] [int] IDENTITY(1,1) NOT NULL primary key,
	[BlogID] [int] NOT NULL references Blogs(BlogID),
	[CategoryName] [varchar](50) NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[Activated] bit
)
GO

insert into [Categories] ( [BlogID],  [CategoryName],  [DateCreated],[Activated] ) 
VALUES ( 1, N'Awards', CAST(0x00009FF800000000 AS DateTime),1)
insert into [Categories] ( [BlogID],  [CategoryName],  [DateCreated],[Activated] ) 
VALUES ( 1, N'Childhood Traumas', CAST(0x00009FF700000000 AS DateTime),1)
insert into [Categories] ( [BlogID],  [CategoryName],  [DateCreated],[Activated] ) 
VALUES ( 1, N'Family', CAST(0x00009FF800000000 AS DateTime),0)
insert into [Categories] ( [BlogID],  [CategoryName],  [DateCreated],[Activated] ) 
VALUES ( 2, N'Internet Big Five', CAST(0x00009FEC00000000 AS DateTime),0)
insert into [Categories] ( [BlogID],  [CategoryName],  [DateCreated], [Activated]) 
VALUES ( 2, N'RoundUps', CAST(0x00009FED00000000 AS DateTime),1)
GO
CREATE TABLE [Entries](
	[EntryID] [int] IDENTITY(1,1) NOT NULL primary key,
	[BlogID] [int] NOT NULL references Blogs(BlogID),
	[Title] [nvarchar](500) NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[Activated] bit
)
Go
insert into [Entries] ( [BlogID], [Title],  [DateCreated], [Activated]) 
VALUES ( 1, N'The Envelope Please, Part II', CAST(0x00009FCC00000000 AS DateTime), 1)
insert into [Entries] ( [BlogID], [Title],  [DateCreated], [Activated]) 
VALUES (1, N'Smarter than me', CAST(0x00009F5200000000 AS DateTime), 0)
insert into [Entries] ( [BlogID], [Title],  [DateCreated], [Activated]) 
VALUES ( 1, N'People My Age', CAST(0x00009FF700000000 AS DateTime), 0)
insert into [Entries] ( [BlogID], [Title],  [DateCreated], [Activated]) 
VALUES ( 2, N'Adjust Your Dial!', CAST(0x00009FF800000000 AS DateTime), 0)
