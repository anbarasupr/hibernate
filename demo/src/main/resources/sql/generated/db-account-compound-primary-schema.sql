
    drop table if exists Account;

    create table Account (
       accountId integer not null,
        userId integer not null,
        accountType varchar(255),
        balance integer not null,
        isJoinedAccount bit not null,
        primary key (accountId, userId)
    ) engine=MyISAM;
