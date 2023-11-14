CREATE TABLE books
(
    id          SERIAL PRIMARY KEY NOT NULL,
    author      VARCHAR(100)       NOT NULL,
    distributor INT                NOT NULL,
    tag         VARCHAR(50)        NOT NULL,
    price       SMALLINT           NOT NULL,
    name        VARCHAR(100)       NOT NULL
);

CREATE TABLE clients
(
    id        SERIAL PRIMARY KEY NOT NULL,
    full_name VARCHAR(100)       NOT NULL,
    email     VARCHAR(200)       NOT NULL,
    password  VARCHAR(64)        NOT NULL
);

CREATE TABLE telephone
(
    id           SERIAL PRIMARY KEY NOT NULL,
    manufacturer VARCHAR(50)        NOT NULL,
    volume       SMALLINT           NOT NULL,
    distributor  INT                NOT NULL,
    tag          VARCHAR(50)        NOT NULL,
    price        SMALLINT           NOT NULL,
    name         VARCHAR(100)       NOT NULL
);

CREATE TABLE washing_machine
(
    id           SERIAL PRIMARY KEY NOT NULL,
    manufacturer VARCHAR(50)        NOT NULL,
    volume       SMALLINT           NOT NULL,
    distributor  INT                NOT NULL,
    tag          VARCHAR(50)        NOT NULL,
    price        SMALLINT           NOT NULL,
    name         VARCHAR(100)       NOT NULL
);


insert into clients (id, full_name, email, password)
values (1, 'Deny Tuck', 'dtuck0@symantec.com', '$2a$04$zTN3lheTGPtI29rKQ4tBqOxzfoUdBI7ZOo4ijwiS1LVj7LUwYJ/2S');
insert into clients (id, full_name, email, password)
values (2, 'Quintana Bonifazio', 'qbonifazio1@jiathis.com',
        '$2a$04$AfJ42xfCKB7sVEoiGfDO.uYVgXSl5YN6Pcvl23ub3yt1e5NjTWHYS');
insert into clients (id, full_name, email, password)
values (3, 'Jodi Brake', 'jbrake2@sourceforge.net', '$2a$04$vb5J8ezlkiJ..FvEJiylEOkR1IJDbes3mE7Q7mN/FqxpHcrkfKV36');
insert into clients (id, full_name, email, password)
values (4, 'Matthias Rennenbach', 'mrennenbach3@vk.com',
        '$2a$04$yzxhjfvcYWQM6FPsEKz2hORmBwq4yHTuRNfXJBtOwqXGDlX6dw8we');
insert into clients (id, full_name, email, password)
values (5, 'Etheline Garvin', 'egarvin4@studiopress.com',
        '$2a$04$AqlRm0bRIlBNZFkREw7XMeUZS/0aq9BAp/wi2zJGu8ThoB4Bdo5ta');
insert into clients (id, full_name, email, password)
values (6, 'Brant Jones', 'bjones5@wisc.edu', '$2a$04$nw6Bvn3kFfrw/0NXktw/e.g22cBL8EPYSYGBmcE4/cNQOJ9k0twq2');
insert into clients (id, full_name, email, password)
values (7, 'Shirleen Faill', 'sfaill6@opera.com', '$2a$04$vPB7Yc9S1/7sjgpY5P1WCOzx7DTKoQIcu4R.dZQWuC8Gahr8wAw3u');
insert into clients (id, full_name, email, password)
values (8, 'Skye Itzkowicz', 'sitzkowicz7@scribd.com', '$2a$04$jxuQHUWlQ3u52I/3Ks6N5.vRWklQoZmB9y3a2VMJbpMwrxRodn/FG');
insert into clients (id, full_name, email, password)
values (9, 'Augie Haggata', 'ahaggata8@parallels.com', '$2a$04$hG61zQG2LW5Fg8y/qswGsOU6Yi5uU7t9/G6UI4oR/sQXWYTVhKF1W');
insert into clients (id, full_name, email, password)
values (10, 'Kinnie Rubin', 'krubin9@hostgator.com', '$2a$04$o248TkKCAy4FnIOzK0tnlOU6sH80XYihg4R.WDMkxGycsNrcJF/we');
insert into clients (id, full_name, email, password)
values (11, 'Alexandros Rzehorz', 'arzehorza@geocities.jp',
        '$2a$04$UctVR3qJdtdH60WPq1rJHuWoM71KNtlSmQjtVqIEdVUcHVjGSoedG');
insert into clients (id, full_name, email, password)
values (12, 'Helge Rollo', 'hrollob@marketwatch.com', '$2a$04$va1q0SCBU6HdCn4IJmxqteNziJpGowpO.uTklPufQGq0xQOeNMMWS');
insert into clients (id, full_name, email, password)
values (13, 'Annamaria Dauber', 'adauberc@ucla.edu', '$2a$04$Iah/cuIHYupyYtHIkiewDe3y0bl.WtJ2l.8Ycap8qIUjxp6ff8F.W');
insert into clients (id, full_name, email, password)
values (14, 'Jori Kerss', 'jkerssd@eepurl.com', '$2a$04$CaDHtf6GRuHT3d17ztcb3edrq2PeFr4kd/SjzpT36imGpMbCcHHn6');
insert into clients (id, full_name, email, password)
values (15, 'Veriee Le Provost', 'vlee@blogger.com', '$2a$04$4afkjzgOTIhuuqga9jmSU.Aob7WZTNHm199vM0v2clQfqJmsl5xMK');
insert into clients (id, full_name, email, password)
values (16, 'Minta Blaber', 'mblaberf@gizmodo.com', '$2a$04$FXl5km1vQyiM5MU1IbLy7.KxOmHg5NAYxg/syJ.WrT3fceqLcBKEC');
insert into clients (id, full_name, email, password)
values (17, 'Gwennie Quakley', 'gquakleyg@shutterfly.com',
        '$2a$04$cAZxQedl3lAtxrqQnHjI9uh2EK4BJ3E1P3Bhdp4aIuvXs16tv0XuO');
insert into clients (id, full_name, email, password)
values (18, 'Estel Ollett', 'eolletth@npr.org', '$2a$04$TINQ0kI86y9UqYGMvG4C1ezBSb0jia5S7LPoREgGBwFM.bdyu10Le');
insert into clients (id, full_name, email, password)
values (19, 'Barnard Snoddy', 'bsnoddyi@taobao.com', '$2a$04$.y7RlUmsDuNwlv3GhZVjQOH/1ev8P.P5M40kjmgcfI8r35ClCJC2m');
insert into clients (id, full_name, email, password)
values (20, 'Arin MacCardle', 'amaccardlej@yahoo.com', '$2a$04$UmWfZeoxV9V4UZssZoXaZO1QBZzOxZiR75B4CLxCCjBBWBpNppjSm');

insert into telephone (manufacturer, volume, distributor, tag, price, name) values ('Eadel', 2127, 11, 'Industrial', 19822, 'Sachet');
insert into telephone (manufacturer, volume, distributor, tag, price, name) values ('Kazu', 3544, 88, 'Garden', 10331, 'Wine - Red, Metus Rose');
insert into telephone (manufacturer, volume, distributor, tag, price, name) values ('Skyba', 2914, 9, 'Toys', 25652, 'Bar Mix - Lime');
insert into telephone (manufacturer, volume, distributor, tag, price, name) values ('Edgeblab', 4369, 53, 'Music', 23308, 'Napkin Colour');
insert into telephone (manufacturer, volume, distributor, tag, price, name) values ('Jatri', 2982, 94, 'Automotive', 15802, 'Asparagus - White, Fresh');
insert into telephone (manufacturer, volume, distributor, tag, price, name) values ('Centidel', 2199, 97, 'Sports', 22264, 'Sage - Ground');
insert into telephone (manufacturer, volume, distributor, tag, price, name) values ('Wordware', 3408, 30, 'Games', 20118, 'Wine - Riesling Dr. Pauly');
insert into telephone (manufacturer, volume, distributor, tag, price, name) values ('Yozio', 4159, 90, 'Garden', 8672, 'Coconut - Whole');
insert into telephone (manufacturer, volume, distributor, tag, price, name) values ('Browsezoom', 3172, 66, 'Tools', 3960, 'Mushroom - Crimini');
insert into telephone (manufacturer, volume, distributor, tag, price, name) values ('Brainverse', 2652, 8, 'Health', 17006, 'Lobster - Baby, Boiled');

insert into washing_machine (manufacturer, volume, distributor, tag, price, name) values ('Topiczoom', 3443, 99, 'Industrial', 28225, 'Salmon Steak - Cohoe 6 Oz');
insert into washing_machine (manufacturer, volume, distributor, tag, price, name) values ('Babbleblab', 2011, 63, 'Games', 20419, 'Instant Coffee');
insert into washing_machine (manufacturer, volume, distributor, tag, price, name) values ('Cogilith', 4926, 31, 'Electronics', 2222, 'Juice - Orange');
insert into washing_machine (manufacturer, volume, distributor, tag, price, name) values ('Cogibox', 3951, 75, 'Home', 6494, 'Mushroom - Oyster, Fresh');
insert into washing_machine (manufacturer, volume, distributor, tag, price, name) values ('Innojam', 3114, 9, 'Tools', 12269, 'Spice - Greek 1 Step');
insert into washing_machine (manufacturer, volume, distributor, tag, price, name) values ('Ooba', 2529, 74, 'Music', 23197, 'Wine - Segura Viudas Aria Brut');
insert into washing_machine (manufacturer, volume, distributor, tag, price, name) values ('Rhynoodle', 2925, 95, 'Automotive', 16002, 'Oil - Macadamia');
insert into washing_machine (manufacturer, volume, distributor, tag, price, name) values ('Meevee', 4634, 46, 'Movies', 8778, 'Pepper - Chipotle, Canned');
insert into washing_machine (manufacturer, volume, distributor, tag, price, name) values ('Brightbean', 4241, 19, 'Computers', 16109, 'Wine - Pinot Noir Stoneleigh');
insert into washing_machine (manufacturer, volume, distributor, tag, price, name) values ('Tambee', 4461, 15, 'Computers', 8203, 'Cattail Hearts');

insert into books (author, distributor, tag, price, name) values ('Ruthe Flarity', 165, 'Toys', 22764, 'Bright Eyes');
insert into books (author, distributor, tag, price, name) values ('Bride Daines', 177, 'Books', 13240, 'Beginning of the Great Revival (a.k.a. The Founding of a Party)');
insert into books (author, distributor, tag, price, name) values ('Ilyse Ianizzi', 154, 'Home', 20365, 'Zone 39');
insert into books (author, distributor, tag, price, name) values ('Iorgo Le Estut', 177, 'Toys', 22346, 'Every Which Way But Loose');
insert into books (author, distributor, tag, price, name) values ('Barton Wayvill', 154, 'Games', 21062, 'Modern Romance');
insert into books (author, distributor, tag, price, name) values ('Alanson Skehan', 104, 'Health', 5654, 'Macbeth');
insert into books (author, distributor, tag, price, name) values ('Adolphe McGillreich', 104, 'Home', 20845, 'Stepford Wives, The');
insert into books (author, distributor, tag, price, name) values ('Kalil McGrae', 198, 'Games', 23776, 'Vampire Journals');
insert into books (author, distributor, tag, price, name) values ('Cirilo Digwood', 143, 'Toys', 20687, 'Djomeh');
insert into books (author, distributor, tag, price, name) values ('Leia Guice', 169, 'Shoes', 25067, 'Man with Two Brains, The');
