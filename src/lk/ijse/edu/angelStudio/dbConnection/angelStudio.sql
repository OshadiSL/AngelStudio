/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Oshadi
 * Created: Jun 20, 2018
 */

drop database angelStudio;
create database angelStudio;
use angelStudio;

create table Customer(
	cid varchar(10)NOT NULL,
	name varchar(100),
	address varchar(100),
	mobileNo varchar(11),
        NIC varchar(11),
	CONSTRAINT PRIMARY KEY (cid)
        
);
INSERT INTO Customer VALUES('C001','Danapala','Panadura','0774567890','941256789V');
INSERT INTO Customer VALUES('C002','Gunapala','Matara','0714325677','939561234V');
INSERT INTO Customer VALUES('C003','Somapala','Galle','0754532566','901235897V');
INSERT INTO Customer VALUES('C004','Oshadhi','Galle','0764888261','987832614V');
INSERT INTO Customer VALUES('C005','Sachin','Panadura','0773189159','961001200V');


create table Orders(
	oid varchar(10)NOT NULL,
        cid varchar(10),
	time varchar(20),
        date varchar (20),
	status varchar(100),
	CONSTRAINT PRIMARY KEY (oid),
        CONSTRAINT FOREIGN KEY (cid) REFERENCES Customer(cid)
	ON UPDATE CASCADE ON DELETE CASCADE
);


INSERT INTO Orders VALUES('P001','C001','8.30','2018-06-05','Print Photo');
INSERT INTO Orders VALUES('P002','C002','10.00','2018-06-11','Rent Camera');
INSERT INTO Orders VALUES('P003','C003','11.56','2018-06-17','Print Photo');
INSERT INTO Orders VALUES('P004','C004','1.00','2018-06-03','Print Photo');

create table Print(
	prid varchar(10)NOT NULL,
        name varchar(100),
	type varchar(20),
        size varchar (20),
	price decimal(10,2),
        qty int,
	CONSTRAINT PRIMARY KEY (prid)
        
);
INSERT INTO Print VALUES('PR001','A4','mat','12x8','150',300);
INSERT INTO Print VALUES('PR002','A4','shin','12x8','200',300);
INSERT INTO Print VALUES('PR003','A3','shin','24x12','250',300);
INSERT INTO Print VALUES('PR004','A3','mat','12x8','200',200);
INSERT INTO Print VALUES('PR005','A2','mat','5x6','100',300);
INSERT INTO Print VALUES('PR006','A2','shin','5x6','100',300);



create table PrintDetails(
	prid varchar(10)NOT NULL,
        oid varchar(10),
	qty int,
        price decimal(10,2),
	CONSTRAINT PRIMARY KEY (prid,oid),
        CONSTRAINT FOREIGN KEY (prid) REFERENCES Print(prid)
        ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT FOREIGN KEY (oid ) REFERENCES Orders(oid )
        ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO PrintDetails VALUES('PR001','P001',4,600.00);
INSERT INTO PrintDetails VALUES('PR002','P002',6,1200.00);
INSERT INTO PrintDetails VALUES('PR003','P003',5,1250.00);
INSERT INTO PrintDetails VALUES('PR004','P004',5,100.00);



create table DesingeType(
	did varchar(10)NOT NULL,
	type varchar(20),
        size varchar (20),
	price decimal(10,2),
        qty int,
	CONSTRAINT PRIMARY KEY (did)
        
);

INSERT INTO DesingeType VALUES('D001','Ten Frame','12x6',500.00,100);
INSERT INTO DesingeType VALUES('D002','15Frames','24x8',1200.00,50);
INSERT INTO DesingeType VALUES('D003','Window Frames ','5x6',250.00,150);
INSERT INTO DesingeType VALUES('D004','glass Photos Frames','12x6',1000.00,100);
INSERT INTO DesingeType VALUES('D005','Vintage Frame','24x8',1400.00,50);
INSERT INTO DesingeType VALUES('D006','rustic Frames','5x6',450.00,150);
INSERT INTO DesingeType VALUES('D007','rustic Frames','5x6',450.00,150);

create table DesingDetail(
	did varchar(10)NOT NULL,
        oid varchar(10),
	qty int,
        price decimal(10,2),
	CONSTRAINT PRIMARY KEY (did,oid),
        CONSTRAINT FOREIGN KEY (did) REFERENCES DesingeType(did)
        ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT FOREIGN KEY (oid ) REFERENCES Orders(oid )
        ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO DesingDetail VALUES('D001','P001',2,1000.00);
INSERT INTO DesingDetail VALUES('D002','P002',1,1200.00);
INSERT INTO DesingDetail VALUES('D003','P003',4,1000.00);
INSERT INTO DesingDetail VALUES('D004','P004',1,1000.00);

create table CamCategory(
	cacid varchar(10)NOT NULL,
        categoryType varchar(100),
	CONSTRAINT PRIMARY KEY (cacid)
        
);
INSERT INTO CamCategory VALUES('CT001','DSLR Cameras');
INSERT INTO CamCategory VALUES('CT002','Compact Cameras');
INSERT INTO CamCategory VALUES('CT003','Mirrorless Cameras');
INSERT INTO CamCategory VALUES('CT004','Action Cameras');
INSERT INTO CamCategory VALUES('CT005','Video Cameras');
INSERT INTO CamCategory VALUES('CT006','Instant Cameras');

create table Camara(
	caid varchar(10)NOT NULL,
        brand varchar(100),
        campany varchar(100),
        bodyType varchar(100),
        clour varchar(100),
        lenseType varchar(100),
        pixels varchar(100),
        Flashers varchar(100),
        RemoteControol varchar(100),
        wifi varchar(100),
        bloototh varchar(100),
        usb varchar(100),
        BatreyDuration varchar(100),
        battryVotage varchar(100),
        battryType varchar(100),
        LenseBrand varchar(100),
        LenseSize varchar(100),
        qty int,
        price decimal (10,2),
	CONSTRAINT PRIMARY KEY (caid)
        
);
INSERT INTO Camara VALUES('CA006','Sony','SonyCompany','?????','black','Canon EF-S','25mm','Flashers','RemoteControol','wife','Bloototh','usb','42hour','14.4V','nickel metal hydride','DSLR Cameras','50-240mm',10,15000.00);
INSERT INTO Camara VALUES('CA001','Sony','SonyCompany','?????','black','Canon EF-S','25mm',' Flashers','RemoteControol','wife','Bloototh','usb','42hour','14.4V','nickel metal hydride','DSLR Cameras','50-240mm',10,15000.00);
INSERT INTO Camara VALUES('CA002','Nikon','NikonCompany','?????','black','AF -5FX Nikon 50mm','50mm','Flashers',' Remote Controol','wife','Bloototh','usb','24hour','7.2V','nickel metal hydride','Compact Cameras','50-80mm',10,20000.00);
INSERT INTO Camara VALUES('CA003','Canon','CanonCompany','?????','black','Auto Focus 70-300mm','70-300mm','null',' Remote Controol','wife','Bloototh','null','72hour','17V','nickel metal hydride','Mirrorless Cameras','50mm',10,10000.00);
INSERT INTO Camara VALUES('CA004','GoPro','GoProCompany','?????','black','EF 50mm f/1.8 STM','50mm','Flashers',' Remote Controol','wife','Bloototh','usb','48hour','12V','nickel metal hydride','Action Cameras','25-36mm',10,22000.00);
INSERT INTO Camara VALUES('CA005','DJL','DJLCompany     ','?????','black','DILD-5s 50-80mm','50-80mm','Flashers',' Remote Controol','wife','null','usb','42hour','14.4V','lithium ion','Video Cameras','50-80mm',10,18500.00);

create table CategoryDetail(
	cacid varchar(10)NOT NULL,
        caid varchar(10),
	CONSTRAINT PRIMARY KEY (cacid,caid),
        CONSTRAINT FOREIGN KEY (cacid) REFERENCES CamCategory(cacid)
        ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT FOREIGN KEY (caid ) REFERENCES Camara(caid)
        ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO CategoryDetail VALUES('CT001','CA001');
INSERT INTO CategoryDetail VALUES('CT002','CA002');
INSERT INTO CategoryDetail VALUES('CT003','CA003');
INSERT INTO CategoryDetail VALUES('CT004','CA004');

create table CameraDetail(
	caid varchar(10)NOT NULL,
        oid varchar(10),
	qty int,
        price decimal(10,2),
	CONSTRAINT PRIMARY KEY (caid,oid),
        CONSTRAINT FOREIGN KEY (caid) REFERENCES Camara(caid)
        ON UPDATE CASCADE ON DELETE CASCADE,
        CONSTRAINT FOREIGN KEY (oid ) REFERENCES Orders(oid )
        ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO CameraDetail VALUES('CA001','P001',4,15000.00);
INSERT INTO CameraDetail VALUES('CA002','P002',5,20000.00);
INSERT INTO CameraDetail VALUES('CA003','P003',6,10000.00);
INSERT INTO CameraDetail VALUES('CA004','P004',10,22000.00);


create table Payment(
	pyid varchar(10)NOT NULL,
        oid varchar(10),
        total decimal(10,2),
        advance decimal(10,2),
        amount decimal(10,2),
        orderType varchar(100),
        blance decimal(10,2),
        paymentType varchar(100),
        
	CONSTRAINT PRIMARY KEY (pyid),
        CONSTRAINT FOREIGN KEY (oid) REFERENCES Orders(oid)
        ON UPDATE CASCADE ON DELETE CASCADE
        
);

INSERT INTO Payment VALUES('PY001','P001',1000.00,500.00,1000.00,'Photo print',500.00,'half');
INSERT INTO Payment VALUES('PY002','P002',20000.00,10000.00,20000.00,'Rent Camera',10000.00,'half');
INSERT INTO Payment VALUES('PY003','P003',1000.00,850.00,1000.00,'Photo print',150.00,'half');
INSERT INTO Payment VALUES('PY004','P004',200.00,120.00,200.00,'Photo print',80.00,'half');
create table ReturnItem(
    retunId varchar(10)NOT NULL,
    cid varchar(10),
    oid varchar(10),
    caid varchar(10),
    name varchar(100),
    NIC varchar(11),
    brand varchar(100),
    LenseBrand varchar(100),
    LenseSize varchar(100),
    price decimal (10,2),
    qty int,
    fullTotal decimal(10,2),
    payAmount decimal(10,2),
    blance decimal(10,2),
    damages varchar(100),
    CONSTRAINT PRIMARY KEY ( retunId ),
    CONSTRAINT FOREIGN KEY (cid) REFERENCES Customer(cid),
    CONSTRAINT FOREIGN KEY (oid) REFERENCES Orders(oid),
    CONSTRAINT FOREIGN KEY (caid) REFERENCES Camara(caid)
    ON UPDATE CASCADE ON DELETE CASCADE
        
);