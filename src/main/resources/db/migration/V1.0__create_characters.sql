create table character(
    id int not null,
    name varchar(100) not null,
    height int not null,
    homeworld varchar(100) not null
);

insert into character(id, name, height, homeworld)
values (1, 'Yoda', 66, 'unknown');

insert into character(id, name, height, homeworld)
values (2, 'Luke Skywalker', 172, 'Tatooine');