CREATE TABLE if not exists users
(
    id         serial PRIMARY KEY,
    first_name varchar(50),
    last_name  varchar(100),
    email      varchar(200) NOT NULL UNIQUE,
    password   varchar(64)  NOT NULL,
    role       varchar(20)  NOT NULL
);

create table products
(
    id     serial primary key,
    name   varchar not null,
    price  decimal not null,
    amount smallint
);

create table orders
(
    id      serial primary key,
    user_id int references users (id),
    status  varchar not null
);

create table order_products
(
    order_id   int references orders (id),
    product_id int references products (id),
    quantity   smallint not null
);

create table user_products
(
    user_id    int references users (id),
    product_id int references products (id),
    quantity   smallint not null
);