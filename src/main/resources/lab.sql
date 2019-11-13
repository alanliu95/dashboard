CREATE DATABASE IF NOT EXISTS lab DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
USE lab;
create table sites(
  site_id   int           not null auto_increment,
  site_name VARCHAR(30)   not null unique ,
  PRIMARY KEY (site_id)
)ENGINE=InnoDB;

create table devices(
  dev_id    int           not null auto_increment,
  site_id   int           not null,
  dev_name  varchar(256)  not null unique ,
  dev_token varchar(256)  not null unique,
  dev_info  VARCHAR(256)  null,
  PRIMARY KEY (dev_id)
)ENGINE=InnoDB;

create table order(
id int  not null auto_increment,

  PRIMARY KEY (id)
 );

create table records(
  rec_id   int           not null auto_increment,
  dev_id   int           not null,
  ts       TIMESTAMP     NOT NULL,
  cpu      FLOAT         NOT NULL,
  mem      FLOAT         NOT NULL,
  PRIMARY KEY (rec_id)
)ENGINE=InnoDB;

ALTER TABLE devices ADD CONSTRAINT fk_devices_sites FOREIGN KEY (site_id) REFERENCES sites (site_id);
ALTER TABLE records ADD CONSTRAINT fk_records_devices FOREIGN KEY (dev_id) REFERENCES devices (dev_id);


insert into sites(site_name) VALUES ("实验七楼"), ("实验十五楼");

insert into devices(site_id,dev_name,dev_token,dev_info) VALUES (1,"ubuntu_14th","123","dell服务器"),(1,"win10","456","dell工作站");
insert into devices(site_id,dev_name,dev_token,dev_info) VALUES (2,"name1","114","pc1"),(2,"name3","112","pc3");

insert into records(dev_id,ts,cpu,mem) values (1,"2018-12-26 21:41:49",10,30);
insert into records(dev_id,ts,cpu,mem) values (1,"2018-12-25 21:42:49",1 ,3.5);
insert into records(dev_id,ts,cpu,mem) values (1,"2018-12-25 21:42:49",1 ,3.5),(2,"2018-12-26 21:41:49",10,30),(2,"2018-12-26 21:41:49",10,30);
insert into records(dev_id,ts,cpu,mem) values (4,"2018-12-25 21:42:49",1 ,3.5),(4,"2018-12-25 21:42:49",1 ,3.5),(6,"2018-12-25 21:42:49",1 ,3.5),(6,"2018-12-25 21:42:49",1 ,3.5);
### ALTER TABLE devices ADD UNIQUE (dev_token);