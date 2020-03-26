
    drop table if exists Module;

    drop table if exists Project;

    drop table if exists Task;

    create table Module (
       moduleName varchar(255),
        projectId integer not null,
        primary key (projectId)
    ) engine=MyISAM;

    create table Project (
       projectId integer not null auto_increment,
        projectName varchar(255),
        primary key (projectId)
    ) engine=MyISAM;

    create table Task (
       taskName varchar(255),
        projectId integer not null,
        primary key (projectId)
    ) engine=MyISAM;

    alter table Module 
       add constraint FK5d9xjrekhcyg6pg67vy1a15ll 
       foreign key (projectId) 
       references Project (projectId);

    alter table Task 
       add constraint FKd24rqr0fuheafjtyj0xo2mj8q 
       foreign key (projectId) 
       references Module (projectId);
