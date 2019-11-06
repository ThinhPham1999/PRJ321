Use PRJ321_DE130111

Create table Product(
	ProductID varchar(4) primary key,
	ProductName nvarchar(50) not null,
	ProductUnit nvarchar(50) not null,
	ProductPrice int default(0) check(ProductPrice >= 0)
)

Insert into Product(ProductID,ProductName,ProductUnit,ProductPrice) values('P001', N'Samsung Galaxy 10', 'Set', 12000000)
Insert into Product(ProductID,ProductName,ProductUnit,ProductPrice) values('P002', N'IPhone 12X', 'Item', 24000000)
Select * from Product