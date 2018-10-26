set names utf8;
set foreign_key_checks=0;

drop database if exists twitter;
create database if not exists twitter;

use twitter;

create table user_info(
  id int primary key not null auto_increment comment "ID",
  user_id varchar(16) unique not null comment "ユーザーID",
  password varchar(16) not null comment "パスワード",
  user_name varchar(32) not null comment "ユーザー名",
  logined tinyint not null default 0 comment "ログインフラグ")
default charset=utf8
comment="会員情報テーブル"
;

insert into user_info values (1,"guest","guest","guest",0);

create table tweet(
  id int primary key not null auto_increment comment "ID",
  user_id varchar(16) not null comment "ユーザーID",
  user_name varchar(16) not null comment "ユーザー名",
  title varchar(140) not null comment "タイトル",
  text varchar(140) not null comment "本文",
  update_date datetime not null comment "登録日")
default charset=utf8
comment="商品情報テーブル"
;

insert into tweet values(1,"guest","guest","タイトル","本文",now());

