 INSERT INTO role values(1,"ROLE_BUYER");
 INSERT INTO role values(2,"ROLE_ADMIN");

 INSERT INTO address values(1,"Fairfield","IOWA","501W Jefferson Ave","52556");
 INSERT INTO address values(2,"Fairfield","IOWA","501W Jefferson Ave","52556");

INSERT INTO user values(1,"user@mum.edu","buyer", "united","1234567890","$2a$10$Bubj9p7UUnxM7oo7kvRnSedODr/6uB2vlYvbBdWmPpkUPJm3x3eI2",1,1);
INSERT INTO user values(2,"admin@mum.edu","admin", "united","1234567890","$2a$10$Bubj9p7UUnxM7oo7kvRnSedODr/6uB2vlYvbBdWmPpkUPJm3x3eI2",2,2);


INSERT INTO `car` (`id`,`carNumber`,`color`,`description`,`engine`,`expireDate`,`main_picture_path`,`mileAge`,`name`,`price`,`transmisson`,`user`) VALUES (1,11,'black','Lorem Ipsum is simply dummy text of the printing and typesetting industry. ','11','2019-12-12 00:00:00','1532012362461_2007-toyota-rav4-11.jpg','1500','RAV4',1500,'123',2);
INSERT INTO `car` (`id`,`carNumber`,`color`,`description`,`engine`,`expireDate`,`main_picture_path`,`mileAge`,`name`,`price`,`transmisson`,`user`) VALUES (2,11,'black','Lorem Ipsum is simply dummy text of the printing and typesetting industry. ','11','2019-12-12 00:00:00','1532012362461_2007-toyota-rav4-11.jpg','1500','BMW',1500,'123',2);
