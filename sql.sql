create table user
(
  id       int auto_increment
    primary key,
  userName varchar(30)     not null,
  email    varchar(60)     not null,
  password varchar(64)     not null,
  role     int default '2' null
  comment '1 is admin, 2 is user',
  constraint user_email_uindex
  unique (email)
)
  engine = InnoDB;

create table note
(
  id              int auto_increment
    primary key,
  user_id         int                         not null,
  title           varchar(255)                null,
  text            mediumtext                  null,
  colorText       varchar(30) default 'black' null,
  colorBackground varchar(30) default 'white' null,
  constraint note_user_id_fk
  foreign key (user_id) references user (id)
    on update cascade
    on delete cascade
)
  engine = InnoDB;

create index note_user_id_fk
  on note (user_id);

INSERT INTO xkeep4.user (id, userName, email, password, role)
 VALUES (1, 'Igor', 'igor@lyutak.com', '1122', null);
INSERT INTO xkeep4.user (id, userName, email, password, role)
VALUES (2, 'Andriy', 'andriy@gmail.com', '1133', null);

INSERT INTO xkeep4.note (id, user_id, title, text, colorText, colorBackground)
VALUES (1, 1, 'First', null, 'red', 'white');
INSERT INTO xkeep4.note (id, user_id, title, text, colorText, colorBackground)
VALUES (2, 1, 'Second', 'sample text', 'black', 'white');
INSERT INTO xkeep4.note (id, user_id, title, text, colorText, colorBackground)
VALUES (3, 2, 'Andriy first', 'text text', 'black', 'white');
INSERT INTO xkeep4.note (id, user_id, title, text, colorText, colorBackground)
VALUES (4, 2, 'Title 3', 'sample text', 'black', 'white');

