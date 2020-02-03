# Springboot-Mybatis-MySQL

## 1. MySQL 세팅
```sql
create user 'spring'@'%' IDENTIFIED by 'bitc5600';
create database spring;

-- DCL (grant, revoke)
-- on DB이름.테이블명
grant ALL PRIVILEGES on spring.* to 'spring'@'%';

use spring;

show tables;

CREATE TABLE mem(

id int AUTO_INCREMENT PRIMARY KEY,

username varchar(100) not null,

password varchar(100) not null,

email varchar(100),

createDate timestamp

) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```