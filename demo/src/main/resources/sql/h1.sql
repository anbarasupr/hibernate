create database product_category;

use product_category;

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`name`) VALUES('Mobile');
INSERT INTO `category` (`name`) VALUES('Computer');
INSERT INTO `category` (`name`) VALUES('Laptop');

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(10,1) NOT NULL,
  `quantity` int(11) NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `photo` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `featured` tinyint(1) NOT NULL,
  `categoryid` int(11) NOT NULL,
  FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`name`, `price`, `quantity`, `description`, `photo`, `categoryid`, `featured`) VALUES('Mobile 1', '2.0', 2, 'description 1', 'thumb1.gif', 1, 0);
INSERT INTO `product` (`name`, `price`, `quantity`, `description`, `photo`, `categoryid`, `featured`) VALUES('Mobile 2', '1.0', 5, 'description 2', 'thumb2.gif', 1, 1);
INSERT INTO `product` (`name`, `price`, `quantity`, `description`, `photo`, `categoryid`, `featured`) VALUES('Mobile 3', '3.0', 9, 'description 3', 'thumb3.gif', 1, 0);
INSERT INTO `product` (`name`, `price`, `quantity`, `description`, `photo`, `categoryid`, `featured`) VALUES('Computer 1', '5.0', 12, 'description 4', 'thumb1.gif', 2, 1);
INSERT INTO `product` (`name`, `price`, `quantity`, `description`, `photo`, `categoryid`, `featured`) VALUES('Computer 2', '7.0', 5, 'description 5', 'thumb1.gif', 2, 0);
INSERT INTO `product` (`name`, `price`, `quantity`, `description`, `photo`, `categoryid`, `featured`) VALUES('Computer 3', '12.0', 2, 'description 6', 'thumb2.gif', 2, 1);
INSERT INTO `product` (`name`, `price`, `quantity`, `description`, `photo`, `categoryid`, `featured`) VALUES('Laptop 1', '3.0', 8, 'description 7', 'thumb2.gif', 3, 0);
INSERT INTO `product` (`name`, `price`, `quantity`, `description`, `photo`, `categoryid`, `featured`) VALUES('Laptop 2', '4.0', 11, 'description 8', 'thumb3.gif', 3, 1);
INSERT INTO `product` (`name`, `price`, `quantity`, `description`, `photo`, `categoryid`, `featured`) VALUES('Laptop 3', '2.0', 15, 'description 9', 'thumb2.gif', 3, 0);


--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `dateCreated` date NOT NULL,
  `payment` varchar(250) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `invoice`
--

INSERT INTO `invoice` (`name`, `dateCreated`, `payment`) VALUES
('Invoice 1', '2017-12-08', 'cash');
INSERT INTO `invoice` (`name`, `dateCreated`, `payment`) VALUES
('Invoice 2', '2017-12-08', 'cash');
INSERT INTO `invoice` (`name`, `dateCreated`, `payment`) VALUES
('Invoice 3', '2017-12-05', 'cash');


select * from category;

select * from product;

select * from invoice;


-- Create Store Procedure
DELIMITER $$
CREATE PROCEDURE sp_findAll()
BEGIN
	SELECT * FROM product;
END $$
DELIMITER ;



DELIMITER $$
CREATE PROCEDURE sp_findBetween(min decimal, max decimal)
BEGIN
	SELECT * FROM product where price BETWEEN min and max;
END $$
DELIMITER ;




select * from customer;


select * from account;


select * from project;
select * from module;
select * from task;

-- one to one
select * from person;
select * from persondetail;









