CREATE TABLE users
(
    id   serial PRIMARY KEY,
    name varchar not null
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