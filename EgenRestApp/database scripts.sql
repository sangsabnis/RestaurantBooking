
CREATE TABLE `reservation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `PHONE` varchar(10) DEFAULT NULL,
  `DATETIME` varchar(30) DEFAULT NULL,
  `PARTY_SIZE` varchar(4) DEFAULT NULL,
  `TABLE_NUMBER` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

INSERT INTO `egenrestaurant`.`reservation` (FIRST_NAME, LAST_NAME, EMAIL, ADDRESS1, ADDRESS2, CITY, ZIP, PHONE, DATETIME, PARTY_SIZE) VALUES 
('sangram','sabnis','sangram.sabnis@ab.com','220 etc etc','','Charlotte',28262,'2830338429', '6/12/2016 21:00','4'),
('John','Snow','john.snow@abc.com','23 Workhaven Lane','','Richmond',23294,'8386352866', '2/12/2016 19:00','2');

