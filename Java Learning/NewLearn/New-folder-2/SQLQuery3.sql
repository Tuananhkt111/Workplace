create database Project
go
USE [Project]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 11/4/2018 11:20:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NULL,
	[Character_Name] [varchar](50) NULL,
	[Points] [int] NULL,
	[Role] [varchar](50) NOT NULL,
	[Character_Class] [varchar](50) NULL,
	[Rank] [varchar](50) NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Class]    Script Date: 11/4/2018 11:20:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Class](
	[Name] [varchar](50) NOT NULL,
	[Description] [varchar](300) NULL,
	[Time_Modifier] [float] NULL,
	[Point_Modifier] [float] NULL,
	[Question_Modifier] [bit] NULL,
 CONSTRAINT [PK_Class] PRIMARY KEY CLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Completed_Mission]    Script Date: 11/4/2018 11:20:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Completed_Mission](
	[Username] [varchar](50) NOT NULL,
	[Mission_ID] [varchar](50) NOT NULL,
	[Highest_Score] [int] NULL,
 CONSTRAINT [PK_Completed_Mission] PRIMARY KEY CLUSTERED 
(
	[Username] ASC,
	[Mission_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Inventory]    Script Date: 11/4/2018 11:20:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Inventory](
	[Username] [varchar](50) NOT NULL,
	[Item] [varchar](50) NOT NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [PK_Inventory] PRIMARY KEY CLUSTERED 
(
	[Username] ASC,
	[Item] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Item]    Script Date: 11/4/2018 11:20:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Item](
	[Name] [varchar](50) NULL,
	[Description] [varchar](50) NULL,
	[ID] [varchar](50) NOT NULL,
	[Drop_Rate] [float] NULL,
	[Time_Modifier] [float] NULL,
	[Points_Modifier] [float] NULL,
	[Question_Modifier] [bit] NULL,
 CONSTRAINT [PK_Item] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Mission]    Script Date: 11/4/2018 11:20:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Mission](
	[Question] [varchar](200) NULL,
	[Choice_1] [varchar](50) NULL,
	[Choice_2] [varchar](50) NULL,
	[Choice_3] [varchar](50) NULL,
	[Answer] [varchar](50) NULL,
	[Points] [int] NULL,
	[Item] [varchar](50) NULL,
	[Type] [varchar](50) NULL,
	[ID] [varchar](50) NOT NULL,
	[Rank] [varchar](50) NULL,
	[Name] [varchar](50) NULL,
 CONSTRAINT [PK_Mission] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Account] ([Username], [Password], [Character_Name], [Points], [Role], [Character_Class], [Rank]) VALUES (N'admin', N'admin', N'Popemkt', 99999, N'admin', N'Demon', N'Champion')
GO
INSERT [dbo].[Account] ([Username], [Password], [Character_Name], [Points], [Role], [Character_Class], [Rank]) VALUES (N'popemkt', N'popemkt', N'ThanhMatLz', 2944, N'user', N'Elf', N'Veteran')
GO
INSERT [dbo].[Account] ([Username], [Password], [Character_Name], [Points], [Role], [Character_Class], [Rank]) VALUES (N'popemkt1', N'user', N'Popemkt11', 668, N'user', N'Mecha', N'Rookie')
GO
INSERT [dbo].[Account] ([Username], [Password], [Character_Name], [Points], [Role], [Character_Class], [Rank]) VALUES (N'user', N'user', N'POPEMKT1', 6884, N'user', N'Human', N'Champion')
GO
INSERT [dbo].[Account] ([Username], [Password], [Character_Name], [Points], [Role], [Character_Class], [Rank]) VALUES (N'user1', N'user', N'popemkt', 1738, N'user', N'Elf', N'Veteran')
GO
INSERT [dbo].[Account] ([Username], [Password], [Character_Name], [Points], [Role], [Character_Class], [Rank]) VALUES (N'user2', N'user', N'Popemkt2', 2708, N'user', N'Demon', N'Veteran')
GO
INSERT [dbo].[Account] ([Username], [Password], [Character_Name], [Points], [Role], [Character_Class], [Rank]) VALUES (N'user3', N'user', NULL, NULL, N'user', NULL, NULL)
GO
INSERT [dbo].[Class] ([Name], [Description], [Time_Modifier], [Point_Modifier], [Question_Modifier]) VALUES (N'Demon', N'Being from the underworld released by the Old Gods of Warcraft.  Hunts humans for food and good at battle. Has a passive of 2x Points Modifier.', 1, 2, 0)
GO
INSERT [dbo].[Class] ([Name], [Description], [Time_Modifier], [Point_Modifier], [Question_Modifier]) VALUES (N'Elf', N'Mystical human-like race who excels at magic. Lifespan of approximately 1 millennia. Has passive of extending mission time to 1,5x normal.', 1.5, 1, 0)
GO
INSERT [dbo].[Class] ([Name], [Description], [Time_Modifier], [Point_Modifier], [Question_Modifier]) VALUES (N'Human', N'Favored species by the admins of OASIS. Has no special powers but holds the Third Key.', 1, 1, 0)
GO
INSERT [dbo].[Class] ([Name], [Description], [Time_Modifier], [Point_Modifier], [Question_Modifier]) VALUES (N'Mecha', N'Unknown era robotic creature, extremely intelligent and has power that can rival the power of a Gundam suit. Has 5 Low Sercurity in Inventory upon creation.', 1, 1, 0)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'popemkt', N'Q002', 81)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'popemkt', N'Q003', 130)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'popemkt', N'Q004', 118)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'popemkt', N'Q005', 172)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'popemkt', N'Q012', 265)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'popemkt', N'Q013', 156)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'popemkt1', N'Q002', 76)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'popemkt1', N'Q003', 105)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'popemkt1', N'Q006', 134)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user', N'Q001', 7)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user', N'Q002', 84)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user', N'Q005', 170)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user1', N'Q001', 88)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user1', N'Q003', 251)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user1', N'Q007', 193)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user2', N'Q001', 160)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user2', N'Q002', 142)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user2', N'Q003', 207)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user2', N'Q004', 180)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user2', N'Q008', 490)
GO
INSERT [dbo].[Completed_Mission] ([Username], [Mission_ID], [Highest_Score]) VALUES (N'user2', N'Q010', 175)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'admin', N'I01', 1)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'admin', N'I02', 1)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'admin', N'I03', 1)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'admin', N'I04', 1)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'popemkt', N'I04', 1)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'popemkt', N'I06', 1)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'popemkt1', N'I03', 1)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'popemkt1', N'I04', 2)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'popemkt1', N'I06', 1)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'user', N'I01', 1)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'user', N'I05', 4)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'user', N'I06', 1)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'user1', N'I04', 1)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'user1', N'I05', 2)
GO
INSERT [dbo].[Inventory] ([Username], [Item], [Quantity]) VALUES (N'user2', N'I06', 1)
GO
INSERT [dbo].[Item] ([Name], [Description], [ID], [Drop_Rate], [Time_Modifier], [Points_Modifier], [Question_Modifier]) VALUES (N'Copper Key', N'First Key to become admin of OASIS.', N'I01', 0.2, 1, 1, 0)
GO
INSERT [dbo].[Item] ([Name], [Description], [ID], [Drop_Rate], [Time_Modifier], [Points_Modifier], [Question_Modifier]) VALUES (N'Jade Key', N'Second Key to become admin of OASIS.', N'I02', 0.2, 1, 1, 0)
GO
INSERT [dbo].[Item] ([Name], [Description], [ID], [Drop_Rate], [Time_Modifier], [Points_Modifier], [Question_Modifier]) VALUES (N'Crystal Key', N'Third Key to become admin of OASIS', N'I03', 0.2, 1, 1, 0)
GO
INSERT [dbo].[Item] ([Name], [Description], [ID], [Drop_Rate], [Time_Modifier], [Points_Modifier], [Question_Modifier]) VALUES (N'Null Pointer', N'Almost no time limit in missions.', N'I04', 0.7, 99, 1, 0)
GO
INSERT [dbo].[Item] ([Name], [Description], [ID], [Drop_Rate], [Time_Modifier], [Points_Modifier], [Question_Modifier]) VALUES (N'Low Sercurity', N'Leak one wrong choice .', N'I05', 0.5, 1, 1, 1)
GO
INSERT [dbo].[Item] ([Name], [Description], [ID], [Drop_Rate], [Time_Modifier], [Points_Modifier], [Question_Modifier]) VALUES (N'Duplicated Entry', N'X2 your final mission score.', N'I06', 0.8, 1, 2, 0)
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'What was the name of the robot used by Daito in the movie?', N'Megatron.', N'Some random Anime Robot.', N'Gundam RX-87.', N'3', 100, N'I05', N'Choice', N'Q001', N'Rookie', N'Robotic Identity')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'Which film did the Giant Iron Robot appeared in originally?', N'The Iron Giant.', N'The Giant Iron Robot.', N'The Giantic Iron.', N'1', 100, N'I06', N'Choice', N'Q002', N'Rookie', N'Another Robot')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'Based on what was the Red Bicycle rode by Art3mis ( Lead girl character) inpired from?', N'The Anime Akira.', N'The Movie TRON.', N'Maybe both???', N'3', 150, N'I04', N'Choice', N'Q003', N'Rookie', N'Red Bicycle')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'How many legs did the Octopus-like Alien vessel in War of the Worlds have? ', N'Eight of course.', N'Three perhaps.', N'Only one.', N'2', 120, N'I01', N'Choice', N'Q004', N'Rookie', N'Octopus Legs')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'What Movie did the Holy hand Grenade appear in?', N'Monty Python and the Holy Grail.', N'Monty Python and the Holy Hand Grenade.', N'Ponty Mython and the Holy Hand Grenade.', N'1', 100, N'I06', N'Choice', N'Q005', N'Rookie', N'Holy Smokey')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'How Tracer from Overwatch addressed herself as sexually?', N'A lesbian.', N'Asexual!', N'Totally normal.', N'1', 200, N'I04', N'Choice', N'Q006', N'Veteran', N'T---racer')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'What video game has the most Cameos in the movie to date?', N'Overwatch.', N'BattleBorn.', N'StarCraft.', N'2', 220, N'I05', N'Choice', N'Q007', N'Veteran', N'Cameos')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'Which Movie has the most accurate depiction of Marvel''s Proxima Midnight?', N'Ready Player One.', N'Marvel''s The Avengers 4.', N'Both are the same.', N'1', 250, N'I06', N'Choice', N'Q008', N'Veteran', N'Proxima Midnight')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'The FPS game that has the most weapons appeared as cameos in the movie Ready Player One?', N'', N'', N'', N'Halo', 250, N'I05', N'Written', N'Q009', N'Veteran', N'Weapon Cameos')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'Based on one of the Knights of the Round table, the name of a member among the lead characters?', N'', N'', N'', N'Parzival', 250, N'I02', N'Written', N'Q010', N'Veteran', N'Protagonist')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'That attack from Street fighter that Parzival used to defeat the movie''s boss Sorrento?', N'', N'', N'', N'Hadouken', 320, N'I04', N'Written', N'Q011', N'Champion', N'Street Fighter')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'Which fighting game appeared in the movie Ready Player One?', N'Mortal Kombat.', N'Tekken.', N'Soul Calibur.', N'1', 320, N'I05', N'Choice', N'Q012', N'Champion', N'Fighting Games')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'How many members did the TMNT have?( Write One, Two, ....)', N'', N'', N'', N'Four', 300, N'I04', N'Written', N'Q013', N'Champion', N'-TMNT-')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'The famous Evil Possessed Doll'' s Name that cameoed in the movie Ready Player One. ', N'', N'', N'', N'Chucky', 350, N'I06', N'Written', N'Q014', N'Champion', N'Child''s Play')
GO
INSERT [dbo].[Mission] ([Question], [Choice_1], [Choice_2], [Choice_3], [Answer], [Points], [Item], [Type], [ID], [Rank], [Name]) VALUES (N'The logo of the movie, Ready Player One was actualy a simple maze, which letter was the beginning and which was the end?( Write X-Y)', N'', N'', N'', N'R-O', 350, N'I03', N'Written', N'Q015', N'Champion', N'Ready Maze One')
GO
ALTER TABLE [dbo].[Completed_Mission]  WITH CHECK ADD  CONSTRAINT [FK_Completed_Mission_Mission] FOREIGN KEY([Mission_ID])
REFERENCES [dbo].[Mission] ([ID])
GO
ALTER TABLE [dbo].[Completed_Mission] CHECK CONSTRAINT [FK_Completed_Mission_Mission]
GO
ALTER TABLE [dbo].[Completed_Mission]  WITH CHECK ADD  CONSTRAINT [FK_Completed_Mission_Users] FOREIGN KEY([Username])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Completed_Mission] CHECK CONSTRAINT [FK_Completed_Mission_Users]
GO
ALTER TABLE [dbo].[Inventory]  WITH CHECK ADD  CONSTRAINT [FK_Inventory_Item] FOREIGN KEY([Item])
REFERENCES [dbo].[Item] ([ID])
GO
ALTER TABLE [dbo].[Inventory] CHECK CONSTRAINT [FK_Inventory_Item]
GO
ALTER TABLE [dbo].[Inventory]  WITH CHECK ADD  CONSTRAINT [FK_Inventory_Users] FOREIGN KEY([Username])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Inventory] CHECK CONSTRAINT [FK_Inventory_Users]
GO
ALTER TABLE [dbo].[Mission]  WITH CHECK ADD  CONSTRAINT [FK_Mission_Item] FOREIGN KEY([Item])
REFERENCES [dbo].[Item] ([ID])
GO
ALTER TABLE [dbo].[Mission] CHECK CONSTRAINT [FK_Mission_Item]
GO
