
    drop table if exists hibernate_sequence;

    drop table if exists Module;

    drop table if exists Project;

    drop table if exists Task;

    create table hibernate_sequence (
       next_val bigint
    ) engine=MyISAM;

    insert into hibernate_sequence values ( 1 );

    create table Module (
       projectId integer not null,
        projectName varchar(255),
        moduleName varchar(255),
        primary key (projectId)
    ) engine=MyISAM;

    create table Project (
       projectId integer not null,
        projectName varchar(255),
        primary key (projectId)
    ) engine=MyISAM;

    create table Task (
       projectId integer not null,
        projectName varchar(255),
        moduleName varchar(255),
        taskName varchar(255),
        primary key (projectId)
    ) engine=MyISAM;
