USE [master]
GO
/****** Object:  Database [PE_21SumB5]    Script Date: 21/08/2021 2:47:27 SA ******/
CREATE DATABASE [PRJ301_SU21B5]
GO
USE [PRJ301_SU21B5]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 21/08/2021 2:47:28 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](20) NOT NULL,
	[password] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Assignment]    Script Date: 21/08/2021 2:47:28 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Assignment](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[BookingID] [int] NOT NULL,
	[RoomID] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Booking]    Script Date: 21/08/2021 2:47:28 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Booking](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[From] [date] NOT NULL,
	[To] [date] NOT NULL,
	[RoomType] [varchar](20) NOT NULL,
	[Status] [nvarchar](20) NULL,
 CONSTRAINT [PK_Booking] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Room]    Script Date: 21/08/2021 2:47:28 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Room](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Title] [varchar](15) NOT NULL,
	[Status] [nvarchar](200) NULL,
	[RoomType] [varchar](20) NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[RoomType]    Script Date: 21/08/2021 2:47:28 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[RoomType](
	[Title] [varchar](20) NOT NULL,
	[Description] [nvarchar](200) NULL,
	[Square] [int] NOT NULL,
	[NumberOfRooms] [int] NULL,
 CONSTRAINT [PK_RoomType] PRIMARY KEY CLUSTERED 
(
	[Title] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Account] ([username], [password]) VALUES (N'user1', N'123456')
GO
INSERT [dbo].[Account] ([username], [password]) VALUES (N'user2', N'654321')
GO
SET IDENTITY_INSERT [dbo].[Assignment] ON 

GO
INSERT [dbo].[Assignment] ([ID], [BookingID], [RoomID]) VALUES (1, 1, 1)
GO
INSERT [dbo].[Assignment] ([ID], [BookingID], [RoomID]) VALUES (2, 2, 2)
GO
INSERT [dbo].[Assignment] ([ID], [BookingID], [RoomID]) VALUES (5, 4, 3)
GO
INSERT [dbo].[Assignment] ([ID], [BookingID], [RoomID]) VALUES (6, 5, 3)
GO
INSERT [dbo].[Assignment] ([ID], [BookingID], [RoomID]) VALUES (7, 8, 15)
GO
INSERT [dbo].[Assignment] ([ID], [BookingID], [RoomID]) VALUES (8, 9, 11)
GO
INSERT [dbo].[Assignment] ([ID], [BookingID], [RoomID]) VALUES (9, 10, 9)
GO
SET IDENTITY_INSERT [dbo].[Assignment] OFF
GO
SET IDENTITY_INSERT [dbo].[Booking] ON 

GO
INSERT [dbo].[Booking] ([ID], [From], [To], [RoomType], [Status]) VALUES (1, CAST(N'2020-01-01' AS Date), CAST(N'2020-01-03' AS Date), N'Single', N'Checked out')
GO
INSERT [dbo].[Booking] ([ID], [From], [To], [RoomType], [Status]) VALUES (2, CAST(N'2020-02-01' AS Date), CAST(N'2020-02-07' AS Date), N'Single', N'Checked out')
GO
INSERT [dbo].[Booking] ([ID], [From], [To], [RoomType], [Status]) VALUES (4, CAST(N'2020-01-03' AS Date), CAST(N'2020-02-08' AS Date), N'Single', N'Checked out')
GO
INSERT [dbo].[Booking] ([ID], [From], [To], [RoomType], [Status]) VALUES (5, CAST(N'2020-08-05' AS Date), CAST(N'2020-08-15' AS Date), N'Single', N'Checked in')
GO
INSERT [dbo].[Booking] ([ID], [From], [To], [RoomType], [Status]) VALUES (6, CAST(N'2020-09-01' AS Date), CAST(N'2020-09-10' AS Date), N'Double', N'Waiting')
GO
INSERT [dbo].[Booking] ([ID], [From], [To], [RoomType], [Status]) VALUES (7, CAST(N'2020-09-12' AS Date), CAST(N'2020-09-15' AS Date), N'Twins', N'Waiting')
GO
INSERT [dbo].[Booking] ([ID], [From], [To], [RoomType], [Status]) VALUES (8, CAST(N'2020-08-01' AS Date), CAST(N'2020-08-02' AS Date), N'Family', N'Checked in')
GO
INSERT [dbo].[Booking] ([ID], [From], [To], [RoomType], [Status]) VALUES (9, CAST(N'2020-07-15' AS Date), CAST(N'2020-09-01' AS Date), N'Twins', N'Checked in')
GO
INSERT [dbo].[Booking] ([ID], [From], [To], [RoomType], [Status]) VALUES (10, CAST(N'2020-08-05' AS Date), CAST(N'2020-08-10' AS Date), N'Double', N'Checked in')
GO
SET IDENTITY_INSERT [dbo].[Booking] OFF
GO
SET IDENTITY_INSERT [dbo].[Room] ON 

GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (1, N'P101', N'Good', N'Single')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (2, N'P102', N'Good', N'Single')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (3, N'P103', N'Good', N'Single')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (4, N'P104', N'Repairing', N'Single')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (5, N'P201', N'Good', N'Double')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (6, N'P202', N'Good', N'Double')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (7, N'P203', N'Has error', N'Double')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (8, N'P204', N'Has error', N'Double')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (9, N'P205', N'Good', N'Double')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (10, N'P206', N'Repairing', N'Double')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (11, N'P207', N'Good', N'Twins')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (12, N'P208', N'Good', N'Twins')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (14, N'P209', N'Has error', N'Twins')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (15, N'P301', N'Good', N'Family')
GO
INSERT [dbo].[Room] ([ID], [Title], [Status], [RoomType]) VALUES (16, N'P302', N'Good', N'Family')
GO
SET IDENTITY_INSERT [dbo].[Room] OFF
GO
INSERT [dbo].[RoomType] ([Title], [Description], [Square], [NumberOfRooms]) VALUES (N'Double', N'A room for two adults with one large bed', 35, 6)
GO
INSERT [dbo].[RoomType] ([Title], [Description], [Square], [NumberOfRooms]) VALUES (N'Family', N'A room for four adults', 70, 2)
GO
INSERT [dbo].[RoomType] ([Title], [Description], [Square], [NumberOfRooms]) VALUES (N'Single', N'A room in for one person', 20, 4)
GO
INSERT [dbo].[RoomType] ([Title], [Description], [Square], [NumberOfRooms]) VALUES (N'Twins', N'A room for two adults with two beds', 35, 3)
GO
ALTER TABLE [dbo].[Assignment]  WITH CHECK ADD  CONSTRAINT [FK_Assignment_Booking] FOREIGN KEY([BookingID])
REFERENCES [dbo].[Booking] ([ID])
GO
ALTER TABLE [dbo].[Assignment] CHECK CONSTRAINT [FK_Assignment_Booking]
GO
ALTER TABLE [dbo].[Assignment]  WITH CHECK ADD  CONSTRAINT [FK_Assignment_Room] FOREIGN KEY([RoomID])
REFERENCES [dbo].[Room] ([ID])
GO
ALTER TABLE [dbo].[Assignment] CHECK CONSTRAINT [FK_Assignment_Room]
GO
ALTER TABLE [dbo].[Booking]  WITH CHECK ADD  CONSTRAINT [FK_Booking_RoomType] FOREIGN KEY([RoomType])
REFERENCES [dbo].[RoomType] ([Title])
GO
ALTER TABLE [dbo].[Booking] CHECK CONSTRAINT [FK_Booking_RoomType]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK_Room_RoomType] FOREIGN KEY([RoomType])
REFERENCES [dbo].[RoomType] ([Title])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_RoomType]
GO
/****** Object:  StoredProcedure [dbo].[sp_GetBookingByType]    Script Date: 21/08/2021 2:47:28 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
USE [master]
GO
ALTER DATABASE [PRJ301_SU21B5] SET  READ_WRITE 
GO
