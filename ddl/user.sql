use seongsland;
drop table user;
create table user (
	seq int(11) not null auto_increment,
	user_id varchar(100) not null,
	user_name varchar(100) not null,
	password varchar(100) not null,
	create_date TIMESTAMP default NOW(),
	modify_date TIMESTAMP,
	constraint user_pk primary key (seq)
) DEFAULT CHARSET=utf8 COLLATE utf8_general_ci
;

insert into user (user_id, user_name, password) value('test1', '테스트1', 'encrypted');
insert into user (user_id, user_name, password) value('test2', '테스트2', 'encrypted');
insert into user (user_id, user_name, password) value('test3', '테스트3', 'encrypted');
