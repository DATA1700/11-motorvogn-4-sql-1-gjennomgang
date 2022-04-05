create table Car (
    brand varchar(50) not null,
    type varchar(50) not null,
    primary key (brand,type)
);

create table Registration (
    id integer auto_increment not null,
    ssn char(11) not null,
    name varchar(50) not null,
    address varchar(50) not null,
    characteristics varchar(50) not null,
    brand varchar(50) not null,
    type varchar(50) not null,
    primary key (id),
    foreign key (brand, type) references Car(brand, type)
);