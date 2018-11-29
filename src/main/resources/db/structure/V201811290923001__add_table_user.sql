create table `user` (
  `id` bigint NOT NULL auto_increment comment '主键',
  `name` varchar(255) not null default '' COLLATE utf8mb4_unicode_ci comment '名称',
  `age` int(11) not null default 0 comment '年龄',
  `create_time` datetime not null default current_timestamp comment '创建时间',
  `update_time` datetime not null default current_timestamp on update current_timestamp comment '更新时间',
  `is_delete` int(11) not null default 0 comment '是否删除，0：未删除，1：已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;