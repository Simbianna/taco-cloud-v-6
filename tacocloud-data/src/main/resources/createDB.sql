/*CREATE SEQUENCE hibernate_sequence START 1;*/

create table if not exists ingredient
(
    id   varchar(4) unique,
    name varchar(25) not null,
    type varchar(10) not null
);

create table if not exists taco_order
(
    id              serial primary key,
    delivery_name   varchar(50)  not null,
    delivery_street varchar(50)  not null,
    delivery_city   varchar(50)  not null,
    delivery_state  varchar(100) not null,
    delivery_zip    varchar(10)  not null,
    cc_number       varchar(16)  not null,
    cc_expiration   varchar(5)   not null,
    cccvv           varchar(3)   not null,
    placed_at       timestamp    not null
);

create table if not exists taco
(
    id         serial primary key,
    name       varchar(50) not null,
    created_at timestamp   not null default now()
);

create table if not exists taco_ingredients
(
    ingredients_id varchar(4) not null,
    taco_id       bigint not null
);

create table if not exists taco_order_tacos
(
    taco_order_id bigint not null,
    tacos_id      bigint not null
);

alter table taco_order_tacos
    add foreign key (taco_order_id) references taco_order (id);
alter table taco_order_tacos
    add foreign key (tacos_id) references taco (id);

alter table taco_ingredients
    add foreign key (taco_id) references taco (id);
alter table taco_ingredients
    add foreign key (ingredients_id) references ingredient (id);

create table if not exists users
(
    id          serial primary key,
    username    VARCHAR(100),
    password    VARCHAR(100),
    fullname    VARCHAR(100),
    street      VARCHAR(100),
    city        VARCHAR(100),
    state       VARCHAR(100),
    zip         VARCHAR(100),
    phoneNumber VARCHAR(100)
);