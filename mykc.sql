/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/9/9 15:16:36                            */
/*==============================================================*/


drop table if exists exchange_code;

drop table if exists my_course;

drop table if exists my_manage;

drop table if exists my_order;

drop table if exists my_set;

drop table if exists my_user;

/*==============================================================*/
/* Table: exchange_code                                         */
/*==============================================================*/
create table exchange_code
(
   id                   bigint(20) not null auto_increment,
   batch                varchar(30),
   change_code          varchar(100),
   status               tinyint(4),
   user_id              bigint(20),
   activated_time       datetime,
   updated              datetime,
   QR_code              varchar(30),
   primary key (id)
);

/*==============================================================*/
/* Table: my_course                                             */
/*==============================================================*/
create table my_course
(
   id                   bigint(20) not null auto_increment,
   course_id            varchar(20),
   course_name          varchar(100),
   course_image         varchar(200),
   course_sort          varchar(20),
   course_mark          varchar(20),
   course_price         bigint(20),
   course_status        tinyint(4),
   course_intro         varchar(100),
   course_info          varchar(200),
   created              datetime,
   updated              datetime,
   primary key (id)
);

alter table my_course comment '×¢ÊÍ£º¿Î³Ì±í';

/*==============================================================*/
/* Table: my_manage                                             */
/*==============================================================*/
create table my_manage
(
   id                   bigint(30) not null auto_increment,
   course_id            varchar(30),
   batch                varchar(30),
   create_num           int(10),
   free_watch           tinyint(4),
   remark               text,
   created              datetime,
   updated              datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: my_order                                              */
/*==============================================================*/
create table my_order
(
   id                   bigint(50) not null auto_increment,
   order_id             varchar(50),
   course_id            varchar(50),
   user_id              varchar(50),
   order_num            varchar(50),
   created              datetime,
   updated              datetime,
   payment              varchar(50),
   payment_type         int(2),
   pay_time             datetime,
   source               varchar(20),
   status               int(10),
   primary key (id)
);

/*==============================================================*/
/* Table: my_set                                                */
/*==============================================================*/
create table my_set
(
   id                   bigint(20) not null auto_increment,
   video_id             varchar(50),
   course_id            bigint(20),
   video_name           varchar(40),
   video_num            varchar(30),
   video_url            varchar(500),
   video_status         tinyint(4),
   created              datetime,
   updated              datetime,
   primary key (id)
);

/*==============================================================*/
/* Table: my_user                                               */
/*==============================================================*/
create table my_user
(
   id                   bigint(20) not null auto_increment,
   user_id              bigint(20),
   type                 int(10),
   name                 varchar(50),
   nickname             varchar(50),
   status               int(10),
   created              datetime,
   updated              datetime,
   telPhone             varchar(50),
   primary key (id)
);

alter table my_set add constraint FK_Reference_3 foreign key (course_id)
      references my_course (id) on delete restrict on update restrict;

