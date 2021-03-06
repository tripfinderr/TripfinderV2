USE [TRIP_FINDER]
GO
/****** Object:  User [NT AUTHORITY\SYSTEM]    Script Date: 14.06.2021 17:04:07 ******/
CREATE USER [NT AUTHORITY\SYSTEM] FOR LOGIN [NT AUTHORITY\SYSTEM] WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [NT AUTHORITY\SYSTEM]
GO
/****** Object:  Table [dbo].[Favlar]    Script Date: 14.06.2021 17:04:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Favlar](
	[UserNickName] [varchar](200) NULL,
	[MekanIsimleri] [varchar](200) NULL,
	[Favori] [varchar](200) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GidilenMekanlarByUsers]    Script Date: 14.06.2021 17:04:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GidilenMekanlarByUsers](
	[UserNickName] [varchar](200) NULL,
	[GidilenMekan] [varchar](200) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HavaDurumu]    Script Date: 14.06.2021 17:04:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HavaDurumu](
	[Sehir] [varchar](50) NULL,
	[Ilce] [varchar](50) NULL,
	[CDerece] [bigint] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Notlar]    Script Date: 14.06.2021 17:04:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Notlar](
	[Notlar] [varchar](8000) NULL,
	[UserNickName] [varchar](200) NULL,
	[NotBasligi] [varchar](500) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SehirDurumlari]    Script Date: 14.06.2021 17:04:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SehirDurumlari](
	[Sehirler] [varchar](200) NULL,
	[ServisDurumu] [varchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Turlar]    Script Date: 14.06.2021 17:04:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Turlar](
	[UserId] [int] NULL,
	[Turİsmi] [varchar](200) NULL,
	[MekanIsimleri] [varchar](200) NULL,
	[Kordinatlar] [varchar](200) NULL,
	[MekanAciklamalari] [varchar](200) NULL,
	[MekanFotoURL] [varchar](5000) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserInformations]    Script Date: 14.06.2021 17:04:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserInformations](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](1000) NULL,
	[UserSurname] [varchar](1000) NULL,
	[UserMailAdress] [varchar](1000) NULL,
	[UserNickName] [varchar](1000) NULL,
	[UserPassword] [varchar](1000) NULL,
	[UserAgainPassword] [varchar](1000) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserInformations1]    Script Date: 14.06.2021 17:04:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserInformations1](
	[UserId] [bigint] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](1000) NULL,
	[UserSurname] [varchar](1000) NULL,
	[UserMailAdress] [varchar](1000) NULL,
	[UserNickName] [varchar](1000) NULL,
	[UserPassword] [varchar](1000) NULL,
	[UserAgainPassword] [varchar](1000) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Yorumlar]    Script Date: 14.06.2021 17:04:07 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Yorumlar](
	[UserNickName] [varchar](200) NULL,
	[TurIsmi] [varchar](200) NULL,
	[MekanIsimleri] [varchar](200) NULL,
	[MekanYorumu] [varchar](1000) NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Favlar] ([UserNickName], [MekanIsimleri], [Favori]) VALUES (N'', N'Topkapı Sarayı', N'YES')
GO
INSERT [dbo].[GidilenMekanlarByUsers] ([UserNickName], [GidilenMekan]) VALUES (N'OK2', N'Karaköy')
INSERT [dbo].[GidilenMekanlarByUsers] ([UserNickName], [GidilenMekan]) VALUES (N'OK3', N'PENDİK')
INSERT [dbo].[GidilenMekanlarByUsers] ([UserNickName], [GidilenMekan]) VALUES (N'ok12', N'Karaköy')
INSERT [dbo].[GidilenMekanlarByUsers] ([UserNickName], [GidilenMekan]) VALUES (N'ok12', N'Pendik')
INSERT [dbo].[GidilenMekanlarByUsers] ([UserNickName], [GidilenMekan]) VALUES (N'', N'Karaköy')
INSERT [dbo].[GidilenMekanlarByUsers] ([UserNickName], [GidilenMekan]) VALUES (N'aa', N'Karaköy')
INSERT [dbo].[GidilenMekanlarByUsers] ([UserNickName], [GidilenMekan]) VALUES (N'dddd', N'Karaköy')
INSERT [dbo].[GidilenMekanlarByUsers] ([UserNickName], [GidilenMekan]) VALUES (N'ok12', N'Bebek Parkı')
GO
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Adalar', 25)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Arnavutköy', 25)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Ataşehir', 24)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Avcılar', 23)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Bağcılar', 22)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Bahçelievler', 27)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Bakırköy', 27)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Başakşehir', 25)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Bayrampaşa', 25)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Beşiktaş', 26)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Beykoz', 30)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Beylikdüzü', 27)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Beyoğlu', 24)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Büyükçekmece', 25)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Çatalca', 26)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Çekmeköy', 28)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Esenler', 30)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Esenyurt', 29)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Eyüpsultan', 28)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Fatih', 27)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Gaziosmanpaşa', 26)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Güngören', 23)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Kadıköy', 23)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Kağıthane', 23)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Kartal', 27)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Küçükçekmece', 28)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Maltepe', 29)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Pendik', 28)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Sancaktepe', 27)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Sarıyer', 27)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Silivri', 26)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Sultanbeyli', 26)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Sultangazi', 30)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Şile', 29)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Şişli', 22)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Tuzla', 23)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Ümraniye', 21)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'Üsküdar', 22)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', N'ZeytinBurnu', 26)
INSERT [dbo].[HavaDurumu] ([Sehir], [Ilce], [CDerece]) VALUES (N'İstanbul', NULL, NULL)
GO
INSERT [dbo].[Notlar] ([Notlar], [UserNickName], [NotBasligi]) VALUES (N'asdasdsadsadasdas', N'onsekiz53', N'not1')
INSERT [dbo].[Notlar] ([Notlar], [UserNickName], [NotBasligi]) VALUES (N'', N'OK2', NULL)
INSERT [dbo].[Notlar] ([Notlar], [UserNickName], [NotBasligi]) VALUES (N'denemenot', N'OK2', NULL)
INSERT [dbo].[Notlar] ([Notlar], [UserNickName], [NotBasligi]) VALUES (N'FGFGDHFDHGHFGHFGHF', N'OK2', NULL)
GO
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'adana', N'deneme')
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'John', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'bursa', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Adana', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Adıyaman', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Ağrı', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Amasya', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Ankara', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Antalya', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Artvin', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Aydın', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Balıkesir', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Bilecik', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Bingöl', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Bitlis', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Bolu', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Burdur', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Bursa', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Çanakkale', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Çankırı', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Çorum', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Denizli', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Diyarbakır', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Edirne', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Elazığ', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Erzincan', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Erzurum', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Eskişehir', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Gaziantep', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Giresun', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Gümüşhane', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Hakkari', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Hatay', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Isparta', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Mersin', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'istanbul', N'VAR')
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'İzmir', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Kars', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Kastamonu', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Kayseri', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Kırklareli', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Kırşehir', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Kocaeli', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Konya', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Kütahya', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Malatya', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Manisa', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Kahraman Maraş', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Mardin', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Muğla', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Nevşehir', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Niğde', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Ordu', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Rize', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Sakarya', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Samsun', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Siirt', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Sinop', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Sivas', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Tekirdağ', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Tokat', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Trabzon', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Tunceli', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Şanlıurfa', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Uşak', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Van', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Yozgat', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Zonguldak', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Aksaray', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Bayburt', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Karaman', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Kırıkkale', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Batman', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Şırnak', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Bartın', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Ardahan', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Iğdır', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Yalova', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Karabük', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Kilis', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Osmaniye', NULL)
INSERT [dbo].[SehirDurumlari] ([Sehirler], [ServisDurumu]) VALUES (N'Düzce', NULL)
GO
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (1, N'Klasik1', N'Gülhane Parkı', N'41.01379738320633,28.98141844302613', N'Gülhane Parkı‘nda sabah sessiz sakinken yürüyüş yapın. Manzaraya karşı Simit – Çay kahvaltı yapın', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYyRmQ0dL8XfgsOIpA8alxGpjqwRrU6awj8w&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik1', N'Topkapı Sarayı', N'41.01136538201609,28.98299471153415', N'Topkapı Sarayı’nı ziyaret edin
', N'https://scontent.fsaw2-2.fna.fbcdn.net/v/t1.6435-9/150404982_5317754531598261_226352613388606469_n.jpg?_nc_cat=107&ccb=1-3&_nc_sid=973b4a&_nc_ohc=gU6isjpqBHUAX_SHYx3&_nc_ht=scontent.fsaw2-2.fna&oh=bb4599428e47baf129f269da0f9374e2&oe=60DAD070')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik1', N'Ayasofya', N'41.00828342289405,28.979831675272226', N'Ayasofya‘yı ziyaret edin, Yarımada’nın en az dokunulmuş yerlerinden biri olan Cankurtaran’da çay – kahve molası verin', N'https://scontent.fsaw2-2.fna.fbcdn.net/v/t1.6435-9/192208350_1584762955060995_2350351126908450420_n.jpg?_nc_cat=109&ccb=1-3&_nc_sid=8bfeb9&_nc_ohc=rmG4thL6eIYAX8zoOto&_nc_ht=scontent.fsaw2-2.fna&oh=df2d5a40ee6919722f3e5bc9215f9163&oe=60DA9689')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik1', N'Yerebatan Sarnıcı', N'41.00851351717582,28.977835082697442', N'Yerebatan Sarnıcı’nınbüyülü atmosferini seyredin', N'https://scontent.fsaw2-1.fna.fbcdn.net/v/t31.18172-8/15676204_1862848917331894_2422999308171418390_o.jpg?_nc_cat=100&ccb=1-3&_nc_sid=973b4a&_nc_ohc=eHJ0dn6kmFMAX9hDXkK&_nc_ht=scontent.fsaw2-1.fna&oh=5ebbde666643a99bb42873cb972d069d&oe=60DA86D5')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik1', N'Sultanahmet Camii', N'41.0055796053843,28.97688889990013', N'Sultanahmet Camii‘ni ziyaret edin', N'https://scontent.fsaw2-3.fna.fbcdn.net/v/t31.18172-8/12184232_1054857971220503_1481777993003599765_o.jpg?_nc_cat=106&ccb=1-3&_nc_sid=973b4a&_nc_ohc=sUyueUoFjwcAX_d2N6G&_nc_ht=scontent.fsaw2-3.fna&oh=3e12b01a26f740078be61f3f22002bb3&oe=60DC807D')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik1', N'Tarihi Sultan Ahmet Köftecisi', N'41.065879951539934,29.007950867874086', N'Tarihi Sultan Ahmet Köftecisi‘nde köfye yiyin', N'https://scontent.fsaw2-1.fna.fbcdn.net/v/t1.6435-9/179464470_3970249713018858_8961132361132177565_n.jpg?_nc_cat=102&ccb=1-3&_nc_sid=973b4a&_nc_ohc=aw2lHW6nsNcAX-zhFNJ&_nc_ht=scontent.fsaw2-1.fna&oh=e1c51dea21b37cd5345c6691b17c2b8b&oe=60DC0895')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik1', N'Hafız Mustafa – Edebiyat Kıraathanesi', N'41.00816822552145,28.976660884553763', N'Hafız Mustafa – Edebiyat Kıraathanesi’nde Osmanlı Kahvesi için veya Çikolatalı Künefe yiyin', N'https://mekan.com/files/images/business-image/image/1000_H/14/143695_33a2.jpg?r=1')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik1', N'Şerefiye Sarnıcı', N'41.00757629272487,28.972555859429672', N'Şerefiye Sarnıcı‘nı ziyaret edin (yeni tadilatı biten bu yere gitmenizi şiddetle öneririm)', N'https://scontent.fsaw2-1.fna.fbcdn.net/v/t1.6435-9/70956516_498295397399158_5682567480107597824_n.jpg?_nc_cat=111&ccb=1-3&_nc_sid=973b4a&_nc_ohc=GZ5iK_FFg0kAX8YXBvI&_nc_ht=scontent.fsaw2-1.fna&oh=c874ae4d14bc548c743e277ec5345610&oe=60D97E4B')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik1', N'Kapalı Çarşı', N'41.01082240847832,28.968046640370815', N'Kapalı Çarşı’da kalabalığın içerisine karışın
', N'https://www.google.com/imgres?imgurl=https%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F1a%2F06%2F4a%2F2e%2F11-64-4000-1461-19.jpg&imgrefurl=https%3A%2F%2Fwww.tripadvisor.com.tr%2FLocationPhotos-g293974-d7811846-Grand_Bazaar-Istanbul.html&tbnid=ZMjlKs2bvFPxKM&vet=12ahUKEwio3rH03fTwAhURgHMKHfn-ByUQMygAegUIARCsAQ..i&docid=NdA_dIggSvHJdM&w=550&h=367&q=kapal%C4%B1%20%C3%A7ar%C5%9F%C4%B1%20foto%C4%9Fraflar%C4%B1&safe=active&ved=2ahUKEwio3rH03fTwAhURgHMKHfn-ByUQMygAegUIARCsAQ')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik1', N'Süleymaniye Camii', N'41.016274621238246,28.96423912873714', N'Süleymaniye Camii‘ni ziyaret edin, bahçesinden kubbelerle birlikte İstanbul fotoğrafı çekin', N'https://www.google.com/imgres?imgurl=https%3A%2F%2Fcdn1.ntv.com.tr%2Fgorsel%2FVKEoxgDl5UyALbc91dZjKQ.jpg%3Fwidth%3D1000%26mode%3Dcrop%26scale%3Dboth&imgrefurl=https%3A%2F%2Fwww.ntv.com.tr%2Fgaleri%2Fseyahat%2Fbir-devrin-guc-simgesi-suleymaniye-camii-hakkinda-bilmeniz-gerekenler%2CNdi8WR3H7U-rlKywE_-fAA&tbnid=VgB4wi1aB0EF2M&vet=12ahUKEwiMkuL-3fTwAhUJ-xoKHYoUCFQQMygBegUIARC1AQ..i&docid=9PoEW7KgGhtZGM&w=1000&h=749&q=S%C3%BCleymaniye%20camii&safe=active&ved=2ahUKEwiMkuL-3fTwAhUJ-xoKHYoUCFQQMygBegUIARC1AQ')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik1', N'Tarihi Meşhur Kuru Fasulyeci Erzincanlı Ali Baba', N'41.015482298743336,28.96326622502447', N'Tarihi Meşhur Kuru Fasulyeci Erzincanlı Ali Baba‘da kuru fasulye yiyin', N'https://fastly.4sqi.net/img/general/200x200/48796320_hnXmv7QDYT5RSfH2nIFujiqcXjh8i1w8Bh7qGRa_oCY.jpg')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik2', N'Mum’s Cafe', N'41.02496381414312,28.979196311534608', N'Mum’s Cafe‘de kahvaltı yapın
', N'https://www.tripadvisor.com.tr/Restaurant_Review-g293974-d5414945-Reviews-Mums-Istanbul.html#photos;aggregationId=&albumid=101&filter=7&ff=85085328')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik2', N'Karaköy', N'41.02551567597491,28.97766952366442', N'Karaköy’ün sokaklarında dolanın, yeriniz varsa Karabatak‘ta bir kahve için
', N'https://staticb.yolcu360.com/blog/wp-content/uploads/2018/07/31135513/Karako%CC%88y-5.jpg')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik2', N'Karaköy Güllüoğlu', N'41.01560647002921,28.979790198044086', N'Güllüoğlu‘nda baklava yiyin', N'https://lh3.googleusercontent.com/proxy/1OnQ8ctoko7iTZoIUAthv_VgwK3TV3XvhJ2wmTVZr6hqNkt64i4ncokGCIJjfGH8qvRlWUZyrNhhkWDxmDaWKuWoA2cnP8gKvKSHavJYtskOwI-bGMQZc_NzFiDlP9qm4e1_BVhxwuQgvQrZNXTzOpGpJb1k07l7wTE')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik2', N'Galata Köprüsü', N'41.020104520893426,28.97327374222741', N'Galata Köprüsü‘nde balık tutan amcaların arasından yürüyün, her iki taraftan da fotoğraf çekin
', N'https://iasbh.tmgrup.com.tr/1ed22c/960/505/0/0/606/319?u=https://isbh.tmgrup.com.tr/sbh/2018/08/31/yeni-galata-koprusu-calisma-nedeniyle-trafige-kapatilacak-1535729538492.jpeg')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik2', N'Yeni Camii', N'41.01714197877357,28.971632673699705', N'Yeni Camii‘yi ziyaret edin', N'https://istanbuldagez.net/wp-content/uploads/2018/07/yeni-camii-800x416.jpg')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik2', N'Mısır Çarşısı', N'41.01667007676524,28.970433567351172', N'Mısır Çarşısı‘nın içerisinde kaybolun', N'https://gezilecekyerler-listesi.com/wp-content/uploads/2020/07/misir-carsisi--696x385.jpg')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik2', N'Tarihi Eminönü Balıkçısı', N'41.018567076975124,28.971119369207575', N'Tarihi Eminönü Balıkçısı’nda tekneden balık ekmek yiyin', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSIGWz7ygd0Y-JvGHSac8KbHHhU6_HaW9PeAQ&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik2', N'Atölye Kafası', N'41.01843720696047,28.9675251782044', N'Atölye Kafası‘nda bir soluklanıp çay için', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmeeYNZPeT56d5R-fkXH-_iSMVitXCQslpWw&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik2', N'Balat', N'41.02836624236719,28.94812429640867', N'Balat‘ı keşfedin (Fener Rum Ortodoks Patrikhanesi , Aya Yorgi Kilisesi, Fener Rum Lisesi, Usturumca Sokak, Kiremit Caddesi, Merdivenli Yokuş)
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUA-DUs47ACfyNU51QsDH-quE3UUcDXMwFGQ&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik2', N'Cafe Naftalin', N'41.03011328123078,28.951037740371316', N'Cafe Naftalin K‘da tart yiyin ve kahve için
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVHNB9hiclrzqNHr681umubUIdDbGsrWmaRQ&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik2', N'Kumkapı ', N'41.00487460997088,28.96521225150344', N'Kumkapı – Kör Agop‘ta fasıla gidin', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcROsn4cgW8tkeifC1fhC9SBzslSpyITA5MJKQ&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'Privato Kafe ', N'41.0269837747119,28.974012269207908', N'Privato Kafe’de kahvaltı edin', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTM3YQ_fw6HAZLBIDdhYWlYMICzvL3ZA99YMw&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'Galata Kulesi', N'41.025860593077105,28.974124082698054', N'Galata Kulesi‘ni sabah erken kimse yokken ziyaret edin
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyt-spGKbtXEZrTPRBh1qfi7jGJi5htV3A1A&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'Tünel', N'41.02874050114476,28.97427495571788', N'Tünel‘de yürüyün', N'')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'Mandabatmaz', N'41.032903234863966, 28.976235898044646', N'Mandabatmaz’da kahvaltı sonrası hemencik bir Türk Kahvesi için', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSavkWewbRP1gecH3WInxhPmsfQDoKQ9M6iUQ&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'Çiçek Pasajı', N'41.03409923879106,28.978076369208054', N'Çiçek Pasajı‘nı ve Anzavur Pasajı‘nı gezin
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSS_A7CWNb-XNEN5ni6ucTnY9ZNdO0-8GAVw&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'Anzavur Pasajı', N'41.03343819766058,28.97673553665885', NULL, N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_JTgk-p2vU3UY7JOdq1HEP8mc7noxEmlcLA&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'Fransız Sokağı', N'41.02487144991668,28.979430811534588', N'Fransız Sokağı‘ndan sadece geçin, oturmayın : )', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTlkLzf6q9Y0xqSm1vKMaGwlEmog0G7gJxU9A&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'Eski Fransız Yetimhanesi', N'41.02979844936536, 28.979370740371422', N'Eski Fransız Yetimhanesi‘nde Beyoğlu’nun kalabalığından kaçıp bir çay molası verin', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgYyitzDzbglPX16wqtP3Jb1DCRZr4ySe8MQ&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'Atlas Pasajı', N'41.034396323958774,28.979282940371476', N'Atlas Pasajı‘nda alışveriş yapın
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpyLxFEa8D5lcF0Wg1L8JOakvKyEupIubUKQ&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'İstiklal Caddesi', N'41.03395733214254,28.977995613391247', N'Meşhur İstiklal Caddesi‘nde yürüyün', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThsK0LFDLSp-PbZ3IQ80KzEvaeBPn4hnlb0Q&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'İnci Pastanesi', N'41.03622611173546,28.981763913391283', N'İnci Pastanesi‘nde profiterol yiyin veya J’adore’da Oh la la la Beatrice yiyin
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXmBmnIy2AoKAovoa4o0VmEIa6kiy9EqRzfA&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N' Kızılkayalar', N'41.0363361187122,28.984784013391362', N'Acıktıysanız Kızılkayalar’da bir hamburger attırın, üzerine de Avam Kahvesi’nde leblebi & gazoz!
', NULL)
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'Cihangir', N'41.033054812252836,28.985003429233554', N'Cihangir‘i keşfedin (Tarihi Savoy Pastanesi’nde Savoy’un Milföy Pastası, Kahve6’da kahve molası)
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLNejvTqdRgR536c8qvsxnBOLW9H3xmnQtaw&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'MK Mangal Keyfi‘', N'41.03583269238874,28.98080362873775', N'MK Mangal Keyfi‘nde yemek yiyin', N'')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik3', N'Nevizade', N'41.03492557928074,28.977323065247504', N'Nevizade‘de veya Asmalı Mescit’te bir şeyler için', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3SHBBtbBF4WlSRqVIS7Z8oAzPyqtTV-L7rg&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik4', N'Rumeli Hisarı ', N'41.08493384294808,29.056691321816945', N'Rumeli Hisarı Kale Kafe’de boğaza nazır kahvaltı yapın
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYdMrahoEnMo8TBucYNutwTsCEcoHXSyJlJg&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik4', N'Hisarlar Müzesi', N'41.08495810308035,29.056680592980324', N'Rumeli Hisarı – Hisarlar Müzesi’ni gezin
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQimfLvJEVzyDNg4Rar5Z3qWa5iVqkJ8vcv5w&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik4', N'Tevfik Fikret’in evi', N'41.08271361018841, 29.05378680361529641.08271361018841,29.053786803615296', N'Sahil boyu yürüyün, Tevfik Fikret’in evini (Aşiyan Müzesi’ni) gezin
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQBijI4JGxv24n7-nKQPp9tGWHT6POgroweew&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik4', N'Bebek Parkı', N'41.076464797907,29.043512998046083', N'Bebek Parkı’nda biraz mola verin. Girandola‘da dondurma yiyin veya Starbucks’ta güzel manzare eşliğinde kahve için veya  Abbas‘ta waffle yiyin 
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSOG_aZagvo4poYOtmG5OTtZeDLbv7oKEIHRg&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik4', N'ArnavutKöy', N'41.1519102283992,28.666624042830403', N'Arnavutköy’e yürüyün, Bodrum Mantı‘da karışık mantı yiyin
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRh21zY3g5NfFEIYnBZ8CT1Y0-VudqYugPg7A&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik4', N'Kuruçeşme', N'41.06013846476179,29.032021035696697', N'Kuruçeşme‘ye doğru yürümeye devam edin
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbD8CsPzqa1w1bhuD6BE5Slcdolnij11pvow&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik4', N'Ortaköy Camii', N'41.04746994532037,29.026976811535313', N'Ortaköy Camii‘ni ziyaret edin, önündeki Beltur’da bir çay molası verin
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOjK9Zd8Dcj9riw1VJG7k9-R7zOWuMdaJPFg&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik5', N'Boğaz Turu', N'41.04320592211015,29.014912100583995', N'Boğaz Turu‘na katılın (11:45 Eminönü kalkış, 13:00 Sarıyer varış) 
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3qsOiual8i4fJtOiVRJoEZAyYyONwy5eH6w&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik5', N'Sarıyer', N'41.15809198382286,29.034595076692476', N'Sarıyer‘den Anadolu Kavağı’na geçin, sahilde balık yiyin, Yoros Kalesi’ne tırmanın (16:00 vapuru ile Sarıyer’e 16:10 vapuruyla da Sarıyer’den Beşiktaş Vapuruna binin)
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShiyKBz5sGAvqOjKw5snXH2wEoqras_SdV-g&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik5', N'Beşiktaş Dürümce', N'41.042170662914,29.00828331339139', N'Beşiktaş Dürümce‘de dürüm yiyin veya Balkan Lokantası‘nda sulu yemekler yiyin
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKA6pcLmM-ziO9-ZKwCIWlDBuPhELDDUUhaQ&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik5', N'Beşiktaş', N'41.04332312921535,29.006478580029516', N'Beşiktaş’ta gezinin
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSO9Jf0grTJH4Ynvg3WUMjBMWjlxq9t6X_wvA&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik5', N'Valonia', N'41.04497711204209,29.003183271064714', N'Valonia‘da çikolatanın dibine vurun
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaO1GlcSoVB7YnYJ7Q7f4L0T5OTNitqZyC5Q&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik5', N'Akaretler', N'41.0430066620938,28.999058231727204', N'Akaretler’den Maçka’ya doğru yürüyün
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxTHg65nZFj0DtTOQth4nlKPq5cDWEQeYB6A&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik5', N'Nişantaşı', N'41.045841612621054,28.98826640747727', N'Nişantaşı‘nın ışıl ışıl sokaklarını görün
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhTCEHxByM4eu9gbhynVVEuBtFulwe-E8Q-g&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik5', N'Coffebain ', N'41.03677817884185,28.98340143371103', N'Coffebain veya MOC’ta kahve molası verin
', NULL)
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik6', N'Heybeliada', N'40.87388847090611,29.08980417074595', N'Heybeliada‘ya doğru yola çıkın
', N'https://www.google.com/imgres?imgurl=https%3A%2F%2Fgezentianne.com%2Fwp-content%2Fuploads%2F2017%2F07%2Fheybeliada_nerede_nasil_gidilir_vapur_saatleri-e1500461543955.jpg&imgrefurl=https%3A%2F%2Fgezentianne.com%2Fheybeliada-nerede-nasil-gidilir-vapur-saatleri%2F&tbnid=MXx97iWlrQvFPM&vet=12ahUKEwio56ry4vTwAhV85bsIHYsmCPAQMygVegUIARDeAQ..i&docid=oqQXTwZUAzuxhM&w=800&h=534&q=Heybeliada&hl=tr&safe=active&ved=2ahUKEwio56ry4vTwAhV85bsIHYsmCPAQMygVegUIARDeAQ')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik6', N'Luz Cafe', N'40.877643188868234,29.099460801752493', N'Vapurda simit – peynir – çay keyfi yapın (martılara simit vermeyi unutmayın :))
', N'https://www.google.com/imgres?imgurl=https%3A%2F%2Fi1.wp.com%2F2.bp.blogspot.com%2F-E8kL9b4fPwg%2FUZdFKIHNXtI%2FAAAAAAAABs0%2FIyn5yHg118I%2Fs1600%2Fcafeluz1.jpg&imgrefurl=http%3A%2F%2Fkucukmartha.com%2Fheybeliada-kesfi-luz-cafe%2F&tbnid=G0ST1P8e3J6qEM&vet=12ahUKEwi7l8aD4_TwAhW06rsIHdmGA0AQMygBegUIARCjAQ..i&docid=7cDm0GwV5RyDGM&w=1600&h=1066&q=Luz%20Cafe&hl=tr&safe=active&ved=2ahUKEwi7l8aD4_TwAhW06rsIHdmGA0AQMygBegUIARCjAQ')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik6', N'Değirmen Burnu', N'40.88467571341942,29.09377448754257', N'Değirmen Burnu‘nda gün batımını izleyin
', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVLBT7XRVGPeJYBGx4-ba19s_acFyMnjZ0vA&usqp=CAU')
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik6', N'Farklı Bi Yer', N'40.876693777622364,29.10087971338626', N'Farklı Bi Yer’de akşam yemeği yiyin
', NULL)
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik7', N'Mosquito', N'40.9965701957426,29.031484012607592', N'Mosquito’da kahvaltı yapın
', NULL)
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik7', N'Kadıköy', N'40.975684630976154,29.047946270405212', N'Kadıköy sokaklarını keşfedin (Boğa Heykeli, Süreyya Operası, Moda Sahnesi vs)
', NULL)
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik7', N'Baylan', N'40.99054354750148,29.023848742226463', N'Baylan’da veya Asuman’da tatlı molası verin
', NULL)
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik7', N'Moda Çay Bahçesi', N'40.98118369361874,29.02149732218236', N'Moda Çay Bahçesi’nde çay için
', NULL)
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik7', N'Moda', N'40.98237430442353, 29.020488811540446', N'Moda’yı keşfedin  – Ali Usta’da dondurma yiyin
', NULL)
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik7', N'Kuzguncuk ', N'41.03275876743185,29.02986520301261', N'Kuzguncuk La Venu’de bir kahve için, Kuzguncuk Bostanı’nı ziyaret edin
', NULL)
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik7', N'Filizler Köftecisi’', N'41.01999496818412, 29.008290269207674', N'Filizler Köftecisi’nde köfte yiyin
', NULL)
INSERT [dbo].[Turlar] ([UserId], [Turİsmi], [MekanIsimleri], [Kordinatlar], [MekanAciklamalari], [MekanFotoURL]) VALUES (NULL, N'Klasik7', N'Kız Kulesi', N'41.02122535083943,29.004127480600634', N'Gün batımını Kız Kulesi’nin karşısındaki minderlerde seyredin
', NULL)
GO
SET IDENTITY_INSERT [dbo].[UserInformations] ON 

INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5010, N'asdsad', N'OK1', N'OK1', N'OK1', N'OK1', N'OK1')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5011, N'OK2', N'OK2', N'OK2', N'OK2', N'OK2', N'OK2')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5012, N'okok', N'soyisimule', N'mailule', N'ok12', N'ok12', N'ok12')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (2012, N'aaaa', N'aaaa', N'aaa', N'aa', N'aaa', N'aaaaa')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (3010, N'aaaa', N'bbb', N'cccc', N'dddd', N'eeeee', N'ffff')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (3011, N'aaaa', N'bbb', N'cccc', N'dddd', N'eeeee', N'ffff')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (3012, N'aaaa', N'bbb', N'cccc', N'dddd', N'eeeee', N'ffff')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5014, N'', N'asdasd', N'asdasd', N'asdasd', N'asdasd', N'asdasd')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (3013, N'aaaa', N'bbb', N'cccc', N'dddd', N'eeeee', N'ffff')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5015, N'o', N'okok', N'okok', N'okok', N'okok', N'okok')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5016, N'okok', N'okok', N'okok', N'okok', N'okok', N'okok')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (1014, N'apisim1', N'apisoyisim1', N'apimail1', N'apinickname1', N'apipass1', N'apiagainpass1')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (1015, N'apisim1', N'apisoyisim1', N'apimail1', N'apinickname1', N'apipass1', N'apiagainpass1')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (3014, N'aaaa', N'bbb', N'cccc', N'dddd', N'eeeee', N'ffff')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (3015, N'a1', N'b1', N'c2', N'd3', N'e4', N'f4')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5017, N'qwer', N'qwer', N'qwer', N'qwer', N'qwer', N'qwer')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5018, N'a', N'asdasd', N'asdasd', N'asdasd', N'asdfg', N'asdfg')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5021, N'asdasd', N'asdasd', N'asdasd@', N'asdasd', N'asdasd', N'asdasd')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (3019, N'OK', N'OK', N'OK', N'd3', N'e4', N'f4')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (6010, N'ok15', N'ok15', N'ok15@hotmail.com', N'okokok', N'okokok', N'okokok')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5022, N'asdasd', N'asdasd', N'asdasd@', N'asdasd', N'asdasd', N'asdasd')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5023, N'ASDASD', N'ASDASD', N'ASDASD@', N'ASDASD', N'ASDASD', N'ASDASD')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5019, N'asdasd', N'asdasd', N'asd@asd', N'asd', N'asdasd', N'asdasd')
INSERT [dbo].[UserInformations] ([UserId], [UserName], [UserSurname], [UserMailAdress], [UserNickName], [UserPassword], [UserAgainPassword]) VALUES (5020, N'ULEEEEEE', N'asdasd', N'asdasd@', N'asdasd', N'asdasd', N'asdasd')
SET IDENTITY_INSERT [dbo].[UserInformations] OFF
GO
INSERT [dbo].[Yorumlar] ([UserNickName], [TurIsmi], [MekanIsimleri], [MekanYorumu]) VALUES (N'OK', NULL, N'Ayasofya', N'ashdgbashjdgasjdgasjdgsajdgasjdghasjdghasjdgjhasdgjhsadgjs')
GO
