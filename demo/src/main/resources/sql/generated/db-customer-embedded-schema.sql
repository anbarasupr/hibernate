
    drop table if exists Customer;

    create table Customer (
       customerId integer not null auto_increment,
        creditScore integer not null,
        customerAddress varchar(255),
        rewardPoints integer not null,
        customerName varchar(255),
        primary key (customerId)
    ) engine=MyISAM;
