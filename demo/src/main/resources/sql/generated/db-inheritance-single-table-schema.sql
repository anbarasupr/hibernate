
    drop table if exists Project;

    create table Project (
       DTYPE varchar(31) not null,
        projectId integer not null auto_increment,
        projectName varchar(255),
        moduleName varchar(255),
        taskName varchar(255),
        primary key (projectId)
    ) engine=MyISAM;
