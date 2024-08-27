CREATE DATABASE IF NOT EXISTS yahooInterview;
USE yahooInterview;

DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS `member`;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS order_detail;

CREATE TABLE `member`(
	MEM_ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	MEM_NAME VARCHAR(45) NOT NULL,
	MEM_ACCOUNT VARCHAR(50) NOT NULL,
	MEM_PASSWORD VARCHAR(20) NOT NULL,
	MEM_GENDER CHAR(1),
	MEM_PHONE VARCHAR(20),
	MEM_EMAIL VARCHAR(50) NOT NULL,
	MEM_ADDRESS VARCHAR(100),
	MEM_BIRTHDAY DATE,
	MEM_STATUS INT(1) DEFAULT(1),
	constraint unikey_MEM_ACCOUNT unique(MEM_ACCOUNT)
);
INSERT INTO `member`(MEM_NAME, MEM_ACCOUNT, MEM_PASSWORD, MEM_GENDER, MEM_PHONE, MEM_EMAIL,MEM_ADDRESS, MEM_BIRTHDAY,MEM_STATUS)
VALUES  ('傅勝宏', 'FU830917', '830917', 'm', '0999000000','s9017611@gmail.com','台北市中正區博愛路36號',STR_TO_DATE('1994-09-17','%Y-%m-%d'),1);

-- 訂單 --
create table `order`(
	ORD_ID int auto_increment not null primary key,
    MEM_ID int not null,
    ORD_SUBTOTAL int not null,
    ORD_TOTAL int not null,
    ORD_STATUS INT(1) not null default 0,
    ORD_CREATE datetime default current_timestamp,
    ORD_RECIPIENT varchar(20) not null,
    ORD_RECIPIENT_PHONE varchar(20) not null,
    ORD_PAYMENT INT(2) not null,
    ORD_DELIVERY INT(2) not null,
    ORD_ADDRESS varchar(100) not null,
    constraint order_member_fk foreign key (MEM_ID) references member(MEM_ID)
);
insert into `order`(MEM_ID, ORD_SUBTOTAL, ORD_TOTAL, ORD_RECIPIENT, ORD_RECIPIENT_PHONE, ORD_PAYMENT, ORD_DELIVERY ,ORD_ADDRESS)
values (1, 270, 270, 'leoblue', '0987654321', 1, 1, '桃園');

-- 商品 --
create table product(
	PD_ID int auto_increment not null primary key,
    PD_NAME varchar(30) not null unique, 
    PD_PRICE int not null,
    PD_DESCRIPTION varchar(200),
    PD_STATUS INT(2) not null default 1,
    PD_IS_DEL INT(1) not null default 0,
    PD_CREATE_BY varchar(20) ,
	PD_CREATE_TIME datetime ,
	PD_UPDATE_BY varchar(20) ,
	PD_UPDATE_TIME datetime
);
insert into product(PD_NAME, PD_PRICE, PD_DESCRIPTION, PD_STATUS, PD_IS_DEL, PD_CREATE_BY,PD_CREATE_TIME,PD_UPDATE_BY,PD_UPDATE_TIME)
values ('奶茶風味可麗露', 300, '奶茶風味可麗露最好吃', 1, 0,'嘉',NOW(),'嘉',NOW()),
       ('抹茶風味可麗露', 500, '抹茶風味可麗露最好吃', 1, 0,'嘉',NOW(),'嘉',NOW());

-- 訂單明細 --
create table order_detail(
	ORD_ID int not null,
    PD_ID int not null,
    ORDD_NUMBER int not null,
    ORDD_PRICE int not null,
    ORDD_DISCOUNT_PRICE int not null,
    constraint order_detail_order_fk foreign key (ORD_ID) references `order`(ORD_ID),
    constraint order_detail_product_fk foreign key (PD_ID) references product(PD_ID),
	primary key(ORD_ID, PD_ID)
);
insert into order_detail(ORD_ID, PD_ID, ORDD_NUMBER, ORDD_PRICE, ORDD_DISCOUNT_PRICE)
values (1, 1, 3, 300, 270);
