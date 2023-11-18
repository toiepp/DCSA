CREATE TABLE if not exists users
(
    id         serial PRIMARY KEY,
    first_name varchar(50),
    last_name  varchar(100),
    email      varchar(200) NOT NULL UNIQUE,
    password   varchar(64)  NOT NULL,
    role       varchar(20)  NOT NULL
);

create table if not exists products
(
    id      serial primary key,
    name    varchar not null,
    price   decimal not null,
    amount  smallint,
    user_id int references users (id)
);

create table if not exists orders
(
    id      serial primary key,
    user_id int references users (id),
    status  varchar not null
);

create table if not exists order_products
(
    order_id   int references orders (id),
    product_id int references products (id),
    quantity   smallint not null
);

create table if not exists user_products
(
    user_id    int references users (id),
    product_id int references products (id),
    quantity   smallint not null
);

insert into users (first_name, last_name, email, password, role)
values (null, null, 'user@user.com', '$2a$12$PhJcoB1kPdgTMEpRPszwfOtvMNVTQTzFyACEmWqE9Mg6RAPIzAToS', 'USER'),
       (null, null, 'seller1@seller.com', '$2a$12$BYAI.NP8UvE9NEk9x1XITeBuZqgcqz/9jqjSDYEe/Syy2gJC7ZM.i', 'SELLER'),
       (null, null, 'seller2@seller.com', '$2a$12$BYAI.NP8UvE9NEk9x1XITeBuZqgcqz/9jqjSDYEe/Syy2gJC7ZM.i', 'SELLER'),
       (null, null, 'admin@admin.com', '$2a$12$x3Bat3vi.41MzbXwcp3c1ev.iEnVIH5JO.2WbuT5x69cMs/hDajEC', 'ADMIN');

insert into products (name, price, amount, user_id)
values ('Ham - Proscuitto', 1702.07, 10, 2);
insert into products (name, price, amount, user_id)
values ('Bread Base - Italian', 713.35, 30, 2);
insert into products (name, price, amount, user_id)
values ('Cheese - Camembert', 1816.6, 68, 3);
insert into products (name, price, amount, user_id)
values ('Pork - Back Ribs', 4573.61, 48, 2);
insert into products (name, price, amount, user_id)
values ('Longos - Chicken Curried', 4103.65, 70, 3);
insert into products (name, price, amount, user_id)
values ('Butter Ripple - Phillips', 2612.72, 64, 2);
insert into products (name, price, amount, user_id)
values ('Oil - Olive Bertolli', 161.12, 29, 3);
insert into products (name, price, amount, user_id)
values ('Beer - Paulaner Hefeweisse', 543.54, 93, 3);
insert into products (name, price, amount, user_id)
values ('Apple - Macintosh', 1101.86, 58, 3);
insert into products (name, price, amount, user_id)
values ('Halibut - Fletches', 1395.77, 26, 3);
insert into products (name, price, amount, user_id)
values ('Steamers White', 2275.05, 18, 2);
insert into products (name, price, amount, user_id)
values ('Juice - Grapefruit, 341 Ml', 4438.22, 49, 2);
insert into products (name, price, amount, user_id)
values ('Veal - Heart', 1344.8, 10, 2);
insert into products (name, price, amount, user_id)
values ('Vinegar - Champagne', 4273.55, 58, 3);
insert into products (name, price, amount, user_id)
values ('Wine - White, Lindemans Bin 95', 1814.63, 10, 3);
insert into products (name, price, amount, user_id)
values ('Crab - Blue, Frozen', 1740.72, 12, 2);
insert into products (name, price, amount, user_id)
values ('Chips Potato Salt Vinegar 43g', 2784.58, 18, 2);
insert into products (name, price, amount, user_id)
values ('Hersey Shakes', 4185.2, 71, 3);
insert into products (name, price, amount, user_id)
values ('Sachet', 999.85, 94, 2);
insert into products (name, price, amount, user_id)
values ('Lamb - Sausage Casings', 4019.31, 31, 2);
insert into products (name, price, amount, user_id)
values ('Squash - Guords', 3435.38, 35, 3);
insert into products (name, price, amount, user_id)
values ('Canada Dry', 4315.2, 41, 3);
insert into products (name, price, amount, user_id)
values ('Beer - Maudite', 4698.57, 84, 2);
insert into products (name, price, amount, user_id)
values ('Celery', 2160.97, 21, 2);
insert into products (name, price, amount, user_id)
values ('Dc - Sakura Fu', 2310.0, 65, 3);
insert into products (name, price, amount, user_id)
values ('Clams - Littleneck, Whole', 3915.61, 49, 2);
insert into products (name, price, amount, user_id)
values ('Pastry - Trippleberry Muffin - Mini', 4293.3, 36, 2);
insert into products (name, price, amount, user_id)
values ('Dawn Professionl Pot And Pan', 2736.47, 53, 3);
insert into products (name, price, amount, user_id)
values ('Salad Dressing', 3720.9, 57, 3);
insert into products (name, price, amount, user_id)
values ('Vermacelli - Sprinkles, Assorted', 2735.57, 73, 2);
insert into products (name, price, amount, user_id)
values ('Food Colouring - Blue', 4746.56, 97, 2);
insert into products (name, price, amount, user_id)
values ('Sparkling Wine - Rose, Freixenet', 4667.02, 90, 2);
insert into products (name, price, amount, user_id)
values ('Pear - Asian', 4144.85, 21, 3);
insert into products (name, price, amount, user_id)
values ('Asparagus - White, Canned', 230.68, 91, 2);
insert into products (name, price, amount, user_id)
values ('Stainless Steel Cleaner Vision', 3946.65, 45, 3);
insert into products (name, price, amount, user_id)
values ('Water - Mineral, Carbonated', 1719.59, 58, 2);
insert into products (name, price, amount, user_id)
values ('Cheese - Shred Cheddar / Mozza', 266.94, 87, 3);
insert into products (name, price, amount, user_id)
values ('Tomatoes', 151.64, 31, 3);
insert into products (name, price, amount, user_id)
values ('Bread - White Mini Epi', 77.42, 28, 3);
insert into products (name, price, amount, user_id)
values ('Crab - Claws, 26 - 30', 466.06, 91, 2);
insert into products (name, price, amount, user_id)
values ('Wine - Rubyport', 4327.84, 10, 2);
insert into products (name, price, amount, user_id)
values ('Pate - Peppercorn', 473.09, 98, 2);
insert into products (name, price, amount, user_id)
values ('Cheese - Goat With Herbs', 2137.18, 41, 2);
insert into products (name, price, amount, user_id)
values ('Pastry - Apple Large', 3486.71, 33, 2);
insert into products (name, price, amount, user_id)
values ('Syrup - Monin, Amaretta', 3845.72, 74, 2);
insert into products (name, price, amount, user_id)
values ('Kellogs All Bran Bars', 2307.73, 73, 3);
insert into products (name, price, amount, user_id)
values ('Nut - Macadamia', 2349.0, 28, 2);
insert into products (name, price, amount, user_id)
values ('Sauce Bbq Smokey', 3584.59, 66, 3);
insert into products (name, price, amount, user_id)
values ('True - Vue Containers', 3010.07, 48, 3);
insert into products (name, price, amount, user_id)
values ('Soup - Cream Of Potato / Leek', 843.21, 21, 2);
