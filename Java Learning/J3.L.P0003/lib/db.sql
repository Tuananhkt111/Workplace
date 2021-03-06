USE [master]
GO
/****** Object:  Database [HotelBookingDB]    Script Date: 12/2/2019 11:51:38 AM ******/
CREATE DATABASE [HotelBookingDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'HotelBookingDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\HotelBookingDB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'HotelBookingDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\HotelBookingDB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [HotelBookingDB] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [HotelBookingDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [HotelBookingDB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [HotelBookingDB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [HotelBookingDB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [HotelBookingDB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [HotelBookingDB] SET ARITHABORT OFF 
GO
ALTER DATABASE [HotelBookingDB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [HotelBookingDB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [HotelBookingDB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [HotelBookingDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [HotelBookingDB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [HotelBookingDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [HotelBookingDB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [HotelBookingDB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [HotelBookingDB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [HotelBookingDB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [HotelBookingDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [HotelBookingDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [HotelBookingDB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [HotelBookingDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [HotelBookingDB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [HotelBookingDB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [HotelBookingDB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [HotelBookingDB] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [HotelBookingDB] SET  MULTI_USER 
GO
ALTER DATABASE [HotelBookingDB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [HotelBookingDB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [HotelBookingDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [HotelBookingDB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [HotelBookingDB] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [HotelBookingDB] SET QUERY_STORE = OFF
GO
USE [HotelBookingDB]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 12/2/2019 11:51:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Email] [varchar](400) NOT NULL,
	[Password] [varchar](500) NOT NULL,
	[Name] [varchar](100) NOT NULL,
	[RoleID] [varchar](50) NOT NULL,
	[Phone] [varchar](50) NOT NULL,
	[Address] [varchar](500) NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[Status] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Area]    Script Date: 12/2/2019 11:51:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Area](
	[AreaID] [varchar](50) NOT NULL,
	[AreaName] [varchar](100) NOT NULL,
 CONSTRAINT [PK_Area] PRIMARY KEY CLUSTERED 
(
	[AreaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Discount]    Script Date: 12/2/2019 11:51:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Discount](
	[DiscountCode] [varchar](50) NOT NULL,
	[SalePercent] [int] NOT NULL,
	[Status] [varchar](50) NOT NULL,
	[DateBegin] [datetime] NOT NULL,
	[DateEnd] [datetime] NOT NULL,
 CONSTRAINT [PK_Discount] PRIMARY KEY CLUSTERED 
(
	[DiscountCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hotel]    Script Date: 12/2/2019 11:51:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hotel](
	[HotelID] [varchar](50) NOT NULL,
	[HotelName] [varchar](100) NOT NULL,
	[AreaID] [varchar](50) NOT NULL,
	[Address] [varchar](100) NOT NULL,
	[Phone] [varchar](50) NOT NULL,
	[Photo] [varchar](200) NOT NULL,
	[Description] [varchar](500) NOT NULL,
	[Status] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Hotel] PRIMARY KEY CLUSTERED 
(
	[HotelID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 12/2/2019 11:51:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[RoleID] [varchar](50) NOT NULL,
	[RoleName] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 12/2/2019 11:51:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[RoomID] [varchar](50) NOT NULL,
	[RoomTypeID] [varchar](50) NOT NULL,
	[Status] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[RoomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoomType]    Script Date: 12/2/2019 11:51:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoomType](
	[RoomTypeID] [varchar](50) NOT NULL,
	[RoomType] [varchar](50) NOT NULL,
	[MaxPeople] [int] NOT NULL,
	[Price] [float] NOT NULL,
	[Description] [varchar](500) NOT NULL,
	[Status] [varchar](50) NOT NULL,
	[HotelID] [varchar](50) NOT NULL,
 CONSTRAINT [PK_RoomType] PRIMARY KEY CLUSTERED 
(
	[RoomTypeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TransactionDetails]    Script Date: 12/2/2019 11:51:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TransactionDetails](
	[TranID] [varchar](500) NOT NULL,
	[RoomID] [varchar](50) NOT NULL,
	[HotelName] [varchar](100) NOT NULL,
	[RoomType] [varchar](50) NOT NULL,
	[DateCheckin] [datetime] NOT NULL,
	[DateCheckout] [datetime] NOT NULL,
	[SubPrice] [float] NOT NULL,
 CONSTRAINT [PK_TransactionDetails] PRIMARY KEY CLUSTERED 
(
	[TranID] ASC,
	[RoomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Transactions]    Script Date: 12/2/2019 11:51:38 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Transactions](
	[TranID] [varchar](500) NOT NULL,
	[Email] [varchar](400) NOT NULL,
	[DiscountCode] [varchar](50) NULL,
	[TotalPrice] [float] NOT NULL,
	[DateBooked] [datetime] NOT NULL,
	[Status] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Transactions] PRIMARY KEY CLUSTERED 
(
	[TranID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_Role] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Role] ([RoleID])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_Role]
GO
ALTER TABLE [dbo].[Hotel]  WITH CHECK ADD  CONSTRAINT [FK_Hotel_Area] FOREIGN KEY([AreaID])
REFERENCES [dbo].[Area] ([AreaID])
GO
ALTER TABLE [dbo].[Hotel] CHECK CONSTRAINT [FK_Hotel_Area]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK_Room_RoomType] FOREIGN KEY([RoomTypeID])
REFERENCES [dbo].[RoomType] ([RoomTypeID])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_RoomType]
GO
ALTER TABLE [dbo].[RoomType]  WITH CHECK ADD  CONSTRAINT [FK_RoomType_Hotel] FOREIGN KEY([HotelID])
REFERENCES [dbo].[Hotel] ([HotelID])
GO
ALTER TABLE [dbo].[RoomType] CHECK CONSTRAINT [FK_RoomType_Hotel]
GO
ALTER TABLE [dbo].[TransactionDetails]  WITH CHECK ADD  CONSTRAINT [FK_TransactionDetails_Room] FOREIGN KEY([RoomID])
REFERENCES [dbo].[Room] ([RoomID])
GO
ALTER TABLE [dbo].[TransactionDetails] CHECK CONSTRAINT [FK_TransactionDetails_Room]
GO
ALTER TABLE [dbo].[TransactionDetails]  WITH CHECK ADD  CONSTRAINT [FK_TransactionDetails_Transactions] FOREIGN KEY([TranID])
REFERENCES [dbo].[Transactions] ([TranID])
GO
ALTER TABLE [dbo].[TransactionDetails] CHECK CONSTRAINT [FK_TransactionDetails_Transactions]
GO
ALTER TABLE [dbo].[Transactions]  WITH CHECK ADD  CONSTRAINT [FK_Transactions_Account] FOREIGN KEY([Email])
REFERENCES [dbo].[Account] ([Email])
GO
ALTER TABLE [dbo].[Transactions] CHECK CONSTRAINT [FK_Transactions_Account]
GO
ALTER TABLE [dbo].[Transactions]  WITH CHECK ADD  CONSTRAINT [FK_Transactions_Discount] FOREIGN KEY([DiscountCode])
REFERENCES [dbo].[Discount] ([DiscountCode])
GO
ALTER TABLE [dbo].[Transactions] CHECK CONSTRAINT [FK_Transactions_Discount]
GO
USE [master]
GO
ALTER DATABASE [HotelBookingDB] SET  READ_WRITE 
GO
