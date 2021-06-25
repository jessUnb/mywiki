drop table if exists `test`;
create table `test` (
                        `id` bigint not null comment 'id',
                        `name` varchar(50) comment '名称',
                        `password` varchar(50) comment '密码',
                        primary key (`id`)
)engine=innodb default charset=utf8mb4 comment='测试';

insert into `test` (id, name, password) VALUES (1,'测试','password');

drop table if exists `demo`;
create table `demo` (
                        `id` bigint not null comment 'id',
                        `name` varchar(50) comment '名称',
                        primary key (`id`)
)engine=innodb default charset=utf8mb4 comment='测试';

insert into `demo` (id, name) VALUES (1,'测试');

#电子书表
drop table if exists `ebook`;
create table `ebook` (
    `id` bigint not null comment 'id',
    `name` varchar(50) comment '名称',
    `category1_id` bigint comment '分类1',
    `category2_id` bigint comment '分类2',
    `description` varchar(200) comment '描述',
    `cover` varchar(200) comment '封面',
    `doc_count` int comment '文档数',
    `view_count` int comment '阅读数',
    `vote_count` int comment '点赞数',
    primary key (`id`)
)engine=innodb default charset=utf8mb4 comment='电子书';

insert into `ebook` (id, name, description) VALUES (1, 'Spring Boot入门教程', '零基础入门Java开发，企业级应用开发首选框架');
insert into `ebook` (id, name, description) VALUES (2, 'Vue入门教程', '零基础入门Vue开发，企业级应用开发首选框架');
insert into `ebook` (id, name, description) VALUES (3, 'Python入门教程', '零基础入门Python开发，企业级应用开发首选框架');
insert into `ebook` (id, name, description) VALUES (4, 'Mysql入门教程', '零基础入门Mysql开发，企业级应用开发首选框架');
insert into `ebook` (id, name, description) VALUES (5, 'Oracle入门教程', '零基础入门Oracle开发，企业级应用开发首选框架');

#分类
drop table if exists `category`;
create table `category` (
     `id` bigint not null comment 'id',
     `parent` bigint not null default 0 comment '父id',
     `name` varchar(50) comment '名称',
     `sort` int comment '顺序',
     primary key (`id`)
)engine=innodb default charset=utf8mb4 comment='分类';

insert into `category` (id, parent, name, sort) VALUES (100, 000, '前端开发', 100);
insert into `category` (id, parent, name, sort) VALUES (101, 100, 'Vue', 101);
insert into `category` (id, parent, name, sort) VALUES (102, 100, 'HTML & CSS', 102);
insert into `category` (id, parent, name, sort) VALUES (200, 000, 'Java', 200);
insert into `category` (id, parent, name, sort) VALUES (201, 200, '基础应用', 201);
insert into `category` (id, parent, name, sort) VALUES (202, 200, '框架应用', 202);
insert into `category` (id, parent, name, sort) VALUES (300, 000, 'Python', 300);
insert into `category` (id, parent, name, sort) VALUES (301, 300, '基础应用', 301);
insert into `category` (id, parent, name, sort) VALUES (302, 300, '进阶方向应用', 302);
insert into `category` (id, parent, name, sort) VALUES (400, 000, '数据库', 400);
insert into `category` (id, parent, name, sort) VALUES (401, 400, 'MySQL', 401);
insert into `category` (id, parent, name, sort) VALUES (500, 000, '其它', 500);
insert into `category` (id, parent, name, sort) VALUES (501, 500, '服务器', 501);
insert into `category` (id, parent, name, sort) VALUES (502, 500, '开发工具', 502);
insert into `category` (id, parent, name, sort) VALUES (503, 500, '热门服务端语言', 503);

#文档表
drop table if exists `doc`;
create table `doc` (
     `id` bigint not null comment 'id',
     `ebook_id` bigint not null default 0 comment '电子书id',
     `parent` bigint not null default 0 comment '父id',
     `name` varchar(50) comment '名称',
     `sort` int comment '顺序',
     `view_count` int default 0 comment '阅读数',
     `vote_count` int default 0 comment '点赞数',
     primary key (`id`)
)engine=innodb default charset=utf8mb4 comment='文档';

insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) VALUES (1, 1, 0, '文档1', 1, 0, 0);
insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) VALUES (2, 1, 1, '文档1.1', 1, 0, 0);
insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) VALUES (3, 1, 0, '文档2', 2, 0, 0);
insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) VALUES (4, 1, 3, '文档2.1', 1, 0, 0);
insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) VALUES (5, 1, 3, '文档2.2', 2, 0, 0);
insert into `doc` (id, ebook_id, parent, name, sort, view_count, vote_count) VALUES (6, 1, 5, '文档2.2.1', 1, 0, 0);

#文档内容
drop table if exists `content`;
create table `content` (
   `id` bigint not null comment '文档id',
   `content` mediumtext not null comment '内容',
   primary key (`id`)
)engine=innodb default charset=utf8mb4 comment='文档内容';