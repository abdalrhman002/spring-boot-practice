create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

INSERT IGNORE INTO `users` VALUES ('am', '{bcrypt}$2a$12$pYJqMA5nhGNmdxcXl4KFDebVvk8Gp9HB6DeH/r4w.xs3Jr.xpzGBa', '1');
INSERT IGNORE INTO `authorities` VALUES ('am', 'admin');

INSERT IGNORE INTO `users` VALUES ('jw', '{noop}123', '1');
INSERT IGNORE INTO `authorities` VALUES ('jw', 'user');

CREATE TABLE `customer` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `email` varchar(45) NOT NULL,
                            `pwd` varchar(200) NOT NULL,
                            `role` varchar(45) NOT NULL,
                            PRIMARY KEY (`id`)
);

INSERT  INTO `customer` (`email`, `pwd`, `role`) VALUES ('am@example.com', '{bcrypt}$2a$12$pYJqMA5nhGNmdxcXl4KFDebVvk8Gp9HB6DeH/r4w.xs3Jr.xpzGBa', 'admin');
INSERT  INTO `customer` (`email`, `pwd`, `role`) VALUES ('jw@example.com', '{noop}123', 'user');