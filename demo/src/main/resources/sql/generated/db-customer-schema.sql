
    drop table if exists Customer;

    drop table if exists CustomerDetail;

    create table Customer (
       customerId integer not null auto_increment,
        customerName varchar(255),
        primary key (customerId)
    ) engine=MyISAM;

    create table CustomerDetail (
       creditScore integer,
        customerAddress varchar(255),
        rewardPoints integer,
        customerId integer not null,
        primary key (customerId)
    ) engine=MyISAM;

    alter table CustomerDetail 
       add constraint FKagryk1v151t6tsnex37ehkwv4 
       foreign key (customerId) 
       references Customer (customerId);

    drop table if exists Customer;

    drop table if exists CustomerDetail;

    create table Customer (
       customerId integer not null auto_increment,
        customerName varchar(255),
        primary key (customerId)
    ) engine=MyISAM;

    create table CustomerDetail (
       creditScore integer,
        customerAddress varchar(255),
        rewardPoints integer,
        customerId integer not null,
        primary key (customerId)
    ) engine=MyISAM;

    alter table CustomerDetail 
       add constraint FKagryk1v151t6tsnex37ehkwv4 
       foreign key (customerId) 
       references Customer (customerId);
