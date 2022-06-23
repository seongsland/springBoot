use seongsland;
drop table test;
create table test (
	test_key varchar(100),
	test_value varchar(100),
	constraint test_pk primary key (test_key)
) DEFAULT CHARSET=utf8 COLLATE utf8_general_ci
;

insert into test values ('test1', '테스트1');
insert into test values ('test2', '테스트2');
insert into test values ('test3', '테스트3');

SELECT test_key, test_value FROM test;