CREATE DATABASE [PRJ301_FA21]
GO
USE [PRJ301_FA21]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 24/10/2021 10:45:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Class]    Script Date: 24/10/2021 10:45:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Class](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [varchar](50) NOT NULL,
	[grade] [tinyint] NOT NULL,
	[schoolyear] [int] NOT NULL,
	[room] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Class] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SchoolYear]    Script Date: 24/10/2021 10:45:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SchoolYear](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[title] [varchar](50) NOT NULL,
	[startdate] [date] NULL,
	[enddate] [date] NULL,
 CONSTRAINT [PK_SchoolYear] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Student]    Script Date: 24/10/2021 10:45:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Student](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fullname] [nvarchar](30) NOT NULL,
	[sex] [varchar](10) NOT NULL,
	[dob] [date] NOT NULL,
	[email] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Student] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Student_Class]    Script Date: 24/10/2021 10:45:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Student_Class](
	[studentid] [int] NOT NULL,
	[classid] [int] NOT NULL,
 CONSTRAINT [PK_Student_Class] PRIMARY KEY CLUSTERED 
(
	[studentid] ASC,
	[classid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Account] ([username], [password]) VALUES (N'user1', N'abc123')
GO
INSERT [dbo].[Account] ([username], [password]) VALUES (N'user2', N'123abc')
GO
SET IDENTITY_INSERT [dbo].[Class] ON 

GO
INSERT [dbo].[Class] ([id], [title], [grade], [schoolyear], [room]) VALUES (1, N'1Thimphu', 1, 3, N'C301')
GO
INSERT [dbo].[Class] ([id], [title], [grade], [schoolyear], [room]) VALUES (2, N'2Prague', 2, 1, N'C302')
GO
INSERT [dbo].[Class] ([id], [title], [grade], [schoolyear], [room]) VALUES (3, N'3Nairobi', 3, 2, N'D405')
GO
INSERT [dbo].[Class] ([id], [title], [grade], [schoolyear], [room]) VALUES (4, N'4Salvado', 4, 3, N'C202')
GO
INSERT [dbo].[Class] ([id], [title], [grade], [schoolyear], [room]) VALUES (5, N'4Soledad', 4, 3, N'C205')
GO
INSERT [dbo].[Class] ([id], [title], [grade], [schoolyear], [room]) VALUES (6, N'1Tokyo', 1, 3, N'C207')
GO
SET IDENTITY_INSERT [dbo].[Class] OFF
GO
SET IDENTITY_INSERT [dbo].[SchoolYear] ON 

GO
INSERT [dbo].[SchoolYear] ([id], [title], [startdate], [enddate]) VALUES (1, N'2019-2020', NULL, NULL)
GO
INSERT [dbo].[SchoolYear] ([id], [title], [startdate], [enddate]) VALUES (2, N'2020-2021', NULL, NULL)
GO
INSERT [dbo].[SchoolYear] ([id], [title], [startdate], [enddate]) VALUES (3, N'2021-2022', NULL, NULL)
GO
SET IDENTITY_INSERT [dbo].[SchoolYear] OFF
GO
SET IDENTITY_INSERT [dbo].[Student] ON 

GO
INSERT [dbo].[Student] ([id], [fullname], [sex], [dob], [email]) VALUES (1, N'Vu Minh Chau', N'female', CAST(N'2012-12-11' AS Date), N'chauvuminh@dewey.edu.vn')
GO
INSERT [dbo].[Student] ([id], [fullname], [sex], [dob], [email]) VALUES (3, N'Khuc Ha Khanh An', N'female', CAST(N'2012-09-11' AS Date), N'ankhuchakhanh@dewey.edu.vn')
GO
INSERT [dbo].[Student] ([id], [fullname], [sex], [dob], [email]) VALUES (4, N'Nguyen Hoang Kien', N'male', CAST(N'2012-01-02' AS Date), N'kiennguyenhoang@dewey.edu.vn')
GO
INSERT [dbo].[Student] ([id], [fullname], [sex], [dob], [email]) VALUES (5, N'Vu Minh Khang', N'male', CAST(N'2015-11-25' AS Date), N'khangvuminh@dewey.edu.vn')
GO
INSERT [dbo].[Student] ([id], [fullname], [sex], [dob], [email]) VALUES (6, N'Dau Quang Minh', N'male', CAST(N'2015-02-06' AS Date), N'minhdauquang@dewey.edu.vn')
GO
INSERT [dbo].[Student] ([id], [fullname], [sex], [dob], [email]) VALUES (7, N'Nguyen Bao Ngoc', N'female', CAST(N'2015-05-05' AS Date), N'ngocnguyenbao@dewey.edu.vn')
GO
INSERT [dbo].[Student] ([id], [fullname], [sex], [dob], [email]) VALUES (8, N'Dam Kim My', N'female', CAST(N'2012-07-06' AS Date), N'mydamkim@dewey.edu.vn')
GO
SET IDENTITY_INSERT [dbo].[Student] OFF
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (1, 2)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (1, 3)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (1, 4)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (3, 2)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (3, 3)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (3, 5)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (4, 2)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (4, 3)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (4, 5)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (5, 1)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (6, 1)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (7, 1)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (8, 2)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (8, 3)
GO
INSERT [dbo].[Student_Class] ([studentid], [classid]) VALUES (8, 4)
GO
ALTER TABLE [dbo].[Class]  WITH CHECK ADD  CONSTRAINT [FK_Class_SchoolYear] FOREIGN KEY([schoolyear])
REFERENCES [dbo].[SchoolYear] ([id])
GO
ALTER TABLE [dbo].[Class] CHECK CONSTRAINT [FK_Class_SchoolYear]
GO
ALTER TABLE [dbo].[Student_Class]  WITH CHECK ADD  CONSTRAINT [FK_Student_Class_Class] FOREIGN KEY([classid])
REFERENCES [dbo].[Class] ([id])
GO
ALTER TABLE [dbo].[Student_Class] CHECK CONSTRAINT [FK_Student_Class_Class]
GO
ALTER TABLE [dbo].[Student_Class]  WITH CHECK ADD  CONSTRAINT [FK_Student_Class_Student] FOREIGN KEY([studentid])
REFERENCES [dbo].[Student] ([id])
GO
ALTER TABLE [dbo].[Student_Class] CHECK CONSTRAINT [FK_Student_Class_Student]
GO
