create table sim1(
   id INT NOT NULL AUTO_INCREMENT,
   ts TIMESTAMP NOT NULL,
   cpu FLOAT NOT NULL,
   mem FLOAT NOT NULL,
   PRIMARY KEY ( id )
);

create table sim2(
   id INT NOT NULL AUTO_INCREMENT,
   ts TIMESTAMP NOT NULL,
   cpu FLOAT NOT NULL,
   mem FLOAT NOT NULL,
   PRIMARY KEY ( id )
);

create table sim3(
   id INT NOT NULL AUTO_INCREMENT,
   ts TIMESTAMP NOT NULL,
   cpu FLOAT NOT NULL,
   mem FLOAT NOT NULL,
   PRIMARY KEY ( id )
);


CREATE DATABASE IF NOT EXISTS yourdbname DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
create table sites(
  site_id int not null auto_increment,
  site_name VARCHAR(30),
  PRIMARY KEY (site_id)
);