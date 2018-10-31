USE [training]
GO

/****** Object:  Table [dbo].[user]    Script Date: 2018/10/30 21:39:08 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[user](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[created_time] [date] NULL,
	[modified_time] [date] NULL
) ON [PRIMARY]
GO


