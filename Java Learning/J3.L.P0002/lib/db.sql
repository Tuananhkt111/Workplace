USE [master]
GO
/****** Object:  Database [BookStoreDB]    Script Date: 11/25/2019 10:19:39 AM ******/
CREATE DATABASE [BookStoreDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookStoreDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\BookStoreDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BookStoreDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\BookStoreDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [BookStoreDB] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookStoreDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BookStoreDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookStoreDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookStoreDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookStoreDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookStoreDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookStoreDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BookStoreDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookStoreDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookStoreDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookStoreDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookStoreDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookStoreDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookStoreDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookStoreDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookStoreDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BookStoreDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookStoreDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookStoreDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookStoreDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookStoreDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookStoreDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookStoreDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookStoreDB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BookStoreDB] SET  MULTI_USER 
GO
ALTER DATABASE [BookStoreDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookStoreDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookStoreDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookStoreDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BookStoreDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BookStoreDB] SET QUERY_STORE = OFF
GO
USE [BookStoreDB]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 11/25/2019 10:19:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[UserID] [varchar](50) NOT NULL,
	[Username] [varchar](50) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Phone] [varchar](50) NOT NULL,
	[Address] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL,
	[RoleID] [varchar](50) NOT NULL,
	[Status] [varchar](50) NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Book]    Script Date: 11/25/2019 10:19:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[BookID] [varchar](50) NOT NULL,
	[Title] [varchar](100) NOT NULL,
	[CatID] [varchar](50) NOT NULL,
	[Author] [varchar](50) NOT NULL,
	[Description] [varchar](500) NOT NULL,
	[Image] [varchar](500) NOT NULL,
	[Price] [float] NOT NULL,
	[ImportDate] [date] NOT NULL,
	[Quantity] [int] NOT NULL,
	[Status] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Book] PRIMARY KEY CLUSTERED 
(
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 11/25/2019 10:19:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CatID] [varchar](50) NOT NULL,
	[CatName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[CatID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Discount]    Script Date: 11/25/2019 10:19:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Discount](
	[DiscountCode] [varchar](50) NOT NULL,
	[UserID] [varchar](50) NOT NULL,
	[SalePercent] [int] NOT NULL,
	[Status] [varchar](50) NOT NULL,
	[DateBegin] [date] NOT NULL,
	[DateEnd] [date] NOT NULL,
 CONSTRAINT [PK_Discount] PRIMARY KEY CLUSTERED 
(
	[DiscountCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 11/25/2019 10:19:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[RoleID] [varchar](50) NOT NULL,
	[RoleName] [varchar](50) NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TransactionDetails]    Script Date: 11/25/2019 10:19:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TransactionDetails](
	[TranID] [varchar](50) NOT NULL,
	[BookID] [varchar](50) NOT NULL,
	[Title] [varchar](100) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Price] [float] NOT NULL,
	[TotalPrice] [float] NOT NULL,
 CONSTRAINT [PK_TransactionDetails] PRIMARY KEY CLUSTERED 
(
	[TranID] ASC,
	[BookID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Transactions]    Script Date: 11/25/2019 10:19:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Transactions](
	[TranID] [varchar](50) NOT NULL,
	[UserID] [varchar](50) NOT NULL,
	[TotalPrice] [float] NOT NULL,
	[TimeBought] [datetime] NOT NULL,
	[SalePercent] [int] NULL,
 CONSTRAINT [PK_ShoppingCart] PRIMARY KEY CLUSTERED 
(
	[TranID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([UserID], [Username], [Email], [Phone], [Address], [Password], [RoleID], [Status]) VALUES (N'admin', N'Administrator', N'a@a', N'1231231231231', N'cong nghe cao', N'Tuananhkt', N'R0001', N'Active')
INSERT [dbo].[Account] ([UserID], [Username], [Email], [Phone], [Address], [Password], [RoleID], [Status]) VALUES (N'admin2', N'sdfsd', N'skjhask@sd', N'123123123123', N'12312321', N'Tuananhkt', N'R0001', N'Active')
INSERT [dbo].[Account] ([UserID], [Username], [Email], [Phone], [Address], [Password], [RoleID], [Status]) VALUES (N'user', N'User', N'a@a', N'123123123123', N'cong', N'Tuananhkt', N'R0002', N'Active')
INSERT [dbo].[Account] ([UserID], [Username], [Email], [Phone], [Address], [Password], [RoleID], [Status]) VALUES (N'user2', N'Tuananhkt2', N'a@a', N'123123123121', N'sfasd', N'Tuananhkt', N'R0002', N'Active')
INSERT [dbo].[Account] ([UserID], [Username], [Email], [Phone], [Address], [Password], [RoleID], [Status]) VALUES (N'user3', N'Tuananhkt', N'a@a', N'1231231231232', N'asd', N'Tuananhkt', N'R0002', N'Active')
INSERT [dbo].[Book] ([BookID], [Title], [CatID], [Author], [Description], [Image], [Price], [ImportDate], [Quantity], [Status]) VALUES (N'2131231231111', N' Harry Potter 1', N'CAT0002', N'Tuan Anha', N'tieu thuyet', N'693274.jpg', 16, CAST(N'2019-11-25' AS Date), 16, N'Active')
INSERT [dbo].[Book] ([BookID], [Title], [CatID], [Author], [Description], [Image], [Price], [ImportDate], [Quantity], [Status]) VALUES (N'2131231231113', N'Harry Potter 2', N'CAT0001', N'Tuan Anh', N'qeqw', N'640653.jpg', 34, CAST(N'2019-11-25' AS Date), 9, N'Active')
INSERT [dbo].[Category] ([CatID], [CatName]) VALUES (N'CAT0001', N'Scifi')
INSERT [dbo].[Category] ([CatID], [CatName]) VALUES (N'CAT0002', N'Love')
INSERT [dbo].[Discount] ([DiscountCode], [UserID], [SalePercent], [Status], [DateBegin], [DateEnd]) VALUES (N'Tuananhkt', N'user', 50, N'Invalid', CAST(N'2019-11-20' AS Date), CAST(N'2019-11-30' AS Date))
INSERT [dbo].[Discount] ([DiscountCode], [UserID], [SalePercent], [Status], [DateBegin], [DateEnd]) VALUES (N'Tuananhkt2', N'user', 30, N'Valid', CAST(N'2019-11-20' AS Date), CAST(N'2019-11-30' AS Date))
INSERT [dbo].[Role] ([RoleID], [RoleName]) VALUES (N'R0001', N'admin')
INSERT [dbo].[Role] ([RoleID], [RoleName]) VALUES (N'R0002', N'user')
INSERT [dbo].[TransactionDetails] ([TranID], [BookID], [Title], [Quantity], [Price], [TotalPrice]) VALUES (N'TRAN2d47eceb-f80d-4b5d-afe1-e176610c91dd', N'2131231231111', N' Harry Potter 1', 1, 16, 16)
INSERT [dbo].[TransactionDetails] ([TranID], [BookID], [Title], [Quantity], [Price], [TotalPrice]) VALUES (N'TRAN2d47eceb-f80d-4b5d-afe1-e176610c91dd', N'2131231231113', N'Harry Potter 2', 1, 34, 34)
INSERT [dbo].[TransactionDetails] ([TranID], [BookID], [Title], [Quantity], [Price], [TotalPrice]) VALUES (N'TRAN462e1a40-eb34-4160-a50d-fb85a38539b8', N'2131231231111', N' Harry Potter 1', 1, 16, 16)
INSERT [dbo].[TransactionDetails] ([TranID], [BookID], [Title], [Quantity], [Price], [TotalPrice]) VALUES (N'TRAN462e1a40-eb34-4160-a50d-fb85a38539b8', N'2131231231113', N'Harry Potter 2', 1, 34, 34)
INSERT [dbo].[TransactionDetails] ([TranID], [BookID], [Title], [Quantity], [Price], [TotalPrice]) VALUES (N'TRAN72cb3214-d82b-41c8-8e07-c71fa5fd72e1', N'2131231231111', N' Harry Potter 1', 2, 16, 32)
INSERT [dbo].[TransactionDetails] ([TranID], [BookID], [Title], [Quantity], [Price], [TotalPrice]) VALUES (N'TRAN72cb3214-d82b-41c8-8e07-c71fa5fd72e1', N'2131231231113', N'Harry Potter 2', 1, 34, 34)
INSERT [dbo].[Transactions] ([TranID], [UserID], [TotalPrice], [TimeBought], [SalePercent]) VALUES (N'TRAN2d47eceb-f80d-4b5d-afe1-e176610c91dd', N'user2', 50, CAST(N'2019-11-25T09:20:12.983' AS DateTime), NULL)
INSERT [dbo].[Transactions] ([TranID], [UserID], [TotalPrice], [TimeBought], [SalePercent]) VALUES (N'TRAN462e1a40-eb34-4160-a50d-fb85a38539b8', N'user', 50, CAST(N'2019-11-25T09:35:45.470' AS DateTime), NULL)
INSERT [dbo].[Transactions] ([TranID], [UserID], [TotalPrice], [TimeBought], [SalePercent]) VALUES (N'TRAN72cb3214-d82b-41c8-8e07-c71fa5fd72e1', N'user', 66, CAST(N'2019-11-25T07:51:14.030' AS DateTime), 50)
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_Role] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Role] ([RoleID])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_Role]
GO
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [FK_Book_Category] FOREIGN KEY([CatID])
REFERENCES [dbo].[Category] ([CatID])
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [FK_Book_Category]
GO
ALTER TABLE [dbo].[Discount]  WITH CHECK ADD  CONSTRAINT [FK_Discount_Account] FOREIGN KEY([UserID])
REFERENCES [dbo].[Account] ([UserID])
GO
ALTER TABLE [dbo].[Discount] CHECK CONSTRAINT [FK_Discount_Account]
GO
ALTER TABLE [dbo].[TransactionDetails]  WITH CHECK ADD  CONSTRAINT [FK_TransactionDetails_Book] FOREIGN KEY([BookID])
REFERENCES [dbo].[Book] ([BookID])
GO
ALTER TABLE [dbo].[TransactionDetails] CHECK CONSTRAINT [FK_TransactionDetails_Book]
GO
ALTER TABLE [dbo].[TransactionDetails]  WITH CHECK ADD  CONSTRAINT [FK_TransactionDetails_Transaction] FOREIGN KEY([TranID])
REFERENCES [dbo].[Transactions] ([TranID])
GO
ALTER TABLE [dbo].[TransactionDetails] CHECK CONSTRAINT [FK_TransactionDetails_Transaction]
GO
ALTER TABLE [dbo].[Transactions]  WITH CHECK ADD  CONSTRAINT [FK_Transaction_Account] FOREIGN KEY([UserID])
REFERENCES [dbo].[Account] ([UserID])
GO
ALTER TABLE [dbo].[Transactions] CHECK CONSTRAINT [FK_Transaction_Account]
GO
USE [master]
GO
ALTER DATABASE [BookStoreDB] SET  READ_WRITE 
GO
