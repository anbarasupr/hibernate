
    drop table if exists hibernate_sequence;

    drop table if exists Person;

    drop table if exists PersonDetail;

    create table hibernate_sequence (
       next_val bigint
    ) engine=MyISAM;

    insert into hibernate_sequence values ( 1 );

    insert into hibernate_sequence values ( 1 );

    create table Person (
       personId_PK integer not null,
        personName varchar(255),
        personDetail_FK integer,
        primary key (personId_PK)
    ) engine=MyISAM;

    create table PersonDetail (
       personDetailId_PK integer not null,
        address varchar(255),
        income double precision not null,
        job varchar(255),
        primary key (personDetailId_PK)
    ) engine=MyISAM;

    alter table Person 
       add constraint FK98kd0dgtagsfx5xwkpq8nmtbu 
       foreign key (personDetail_FK) 
       references PersonDetail (personDetailId_PK);
