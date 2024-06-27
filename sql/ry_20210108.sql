create database if not exists recruit;
use recruit;
-- ----------------------------
-- 1、部门表
-- ----------------------------
drop table if exists sys_dept;
create table sys_dept
(
    dept_id     bigint(20) not null auto_increment comment '部门id',
    parent_id   bigint(20)  default 0 comment '父部门id',
    ancestors   varchar(50) default '' comment '祖级列表',
    dept_name   varchar(30) default '' comment '部门名称',
    order_num   int(4)      default 0 comment '显示顺序',
    leader      varchar(20) default null comment '负责人',
    phone       varchar(11) default null comment '联系电话',
    email       varchar(50) default null comment '邮箱',
    status      char(1)     default '0' comment '部门状态（0正常 1停用）',
    del_flag    char(1)     default '0' comment '删除标志（0代表存在 2代表删除）',
    create_by   varchar(64) default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64) default '' comment '更新者',
    update_time datetime comment '更新时间',
    primary key (dept_id)
) engine = innodb
  auto_increment = 200 comment = '部门表';

-- ----------------------------
-- 初始化-部门表数据
-- ----------------------------

insert into sys_dept (dept_id, parent_id, ancestors, dept_name, order_num, leader, phone, email, status, del_flag, create_by, create_time, update_by, update_time)
values  (100, 0, '0', 'xx大学', 0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-03-24 17:15:43', 'admin', '2021-04-22 13:05:14'),
        (101, 100, '0,100', '信息管理学院', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-03-24 17:15:43', 'admin', '2021-04-22 13:05:14'),
        (102, 100, '0,100', '物理学院', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-03-24 17:15:43', '', null),
        (103, 101, '0,100,101', '计算机科学与技术专业', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-03-24 17:15:43', '', null),
        (104, 101, '0,100,101', '计科3D', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-03-24 17:15:43', '', null),
        (105, 101, '0,100,101', '网站建设', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-03-24 17:15:43', '', null),
        (106, 102, '0,100,102', '物理学', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-03-24 17:15:43', '', null),
        (107, 102, '0,100,102', '电学', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2021-03-24 17:15:43', '', null);

-- ----------------------------
-- 2、用户信息表
-- ----------------------------
drop table if exists sys_user;
create table sys_user
(
    user_id     bigint(20)  not null auto_increment comment '用户ID',
    dept_id     bigint(20)   default null comment '部门ID',
    user_name   varchar(30) not null comment '用户账号',
    nick_name   varchar(30) not null comment '用户昵称',
    user_type   varchar(2)   default '00' comment '用户类型（00系统用户）',
    email       varchar(50)  default '' comment '用户邮箱',
    phonenumber varchar(11)  default '' comment '手机号码',
    sex         char(1)      default '0' comment '用户性别（0男 1女 2未知）',
    avatar      varchar(100) default '' comment '头像地址',
    password    varchar(100) default '' comment '密码',
    status      char(1)      default '0' comment '帐号状态（0正常 1停用）',
    del_flag    char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    login_ip    varchar(50)  default '' comment '最后登录IP',
    login_date  datetime comment '最后登录时间',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (user_id)
) engine = innodb
  auto_increment = 100 comment = '用户信息表';

-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
insert into recruit.sys_user (user_id, dept_id, user_name, nick_name, user_type, email, phonenumber, sex, avatar, password, status, del_flag, login_ip, login_date, create_by, create_time, update_by, update_time, remark)
values  (1, 103, 'admin', '**大学', '00', '11966506@163.com', '15432432431', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2021-05-17 22:23:04', 'admin', '2021-05-17 22:23:04', '', '2021-05-31 20:18:32', '管理员'),
        (2, 105, 'test', '测试', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2021-05-17 22:23:04', 'admin', '2021-05-17 22:23:04', '', null, '测试员'),
        (3, null, '123324', '搜狐媒体', '00', '897233@qq.com', '13184523477', '0', '', '$2a$10$ByNDIJTzOXFldmTBnh5.sOwzZriUhr90wdR6Em.lt4eWB.4ozqcOK', '0', '0', '', null, 'admin', null, 'admin', null, null),
        (4, null, '123325', '京东', '00', '897234@qq.com', '13184523476', '0', '', '$2a$10$ByNDIJTzOXFldmTBnh5.sOwzZriUhr90wdR6Em.lt4eWB.4ozqcOK', '0', '0', '', null, 'admin', null, 'admin', null, null),
        (5, null, '123326', '网易', '00', '897235@qq.com', '13184523475', '0', '', '$2a$10$ByNDIJTzOXFldmTBnh5.sOwzZriUhr90wdR6Em.lt4eWB.4ozqcOK', '0', '0', '', null, 'admin', null, 'admin', null, null),
        (101, null, '123327', '福州科技有限公司', '00', '897236@qq.com', '18250014239', '0', '', '$2a$10$ByNDIJTzOXFldmTBnh5.sOwzZriUhr90wdR6Em.lt4eWB.4ozqcOK', '0', '0', '', null, 'admin', null, 'admin', null, null),
        (103, null, 'root', '123123123', '00', '4@qq.com', '13181351311', '0', '', '$2a$10$MPgGiFGrW.J69fs3o/3Pb.04PxX.5jwCOqGQVm82FXg.P3L16uOVS', '0', '0', '', null, '', '2021-05-03 22:43:14', '', null, null),
        (105, null, '123329', '厦门有限公司', '00', '897238@qq.com', '17777777777', '0', '', '$2a$10$ByNDIJTzOXFldmTBnh5.sOwzZriUhr90wdR6Em.lt4eWB.4ozqcOK', '0', '0', '', null, 'admin', null, 'admin', null, null),
        (106, null, '123320', '漳州科技', '00', '897239@qq.com', '15082301111', '0', '', '$2a$10$ByNDIJTzOXFldmTBnh5.sOwzZriUhr90wdR6Em.lt4eWB.4ozqcOK', '0', '0', '', null, 'admin', null, 'admin', null, null),
        (111, null, '123328', 'shandong', '00', '897237@qq.com', '13181351311', '0', '', '$2a$10$ByNDIJTzOXFldmTBnh5.sOwzZriUhr90wdR6Em.lt4eWB.4ozqcOK', '0', '0', '', null, 'admin', null, 'admin', null, null),
        (114, null, '123310', '龙岩科技', '00', '897202@qq.com', '15090329188', '0', '', '$2a$10$ByNDIJTzOXFldmTBnh5.sOwzZriUhr90wdR6Em.lt4eWB.4ozqcOK', '0', '0', '', null, 'admin', null, 'admin', null, null),
        (118, null, '123321', '福建金科有限公司', '00', '897234@qq.com', '18514293987', '0', '', '$2a$10$wZNckLiqOB8GQ/ZgSrFQ5u0Gq/HAv.uyOvIhvR9SiZQ.YG3z64Ls.', '0', '0', '', null, '', '2021-05-31 20:36:53', '', null, null),
        (120, 103, '3171905213', '王山', '00', '1192650769@qq.com', '18396301501', '0', '/profile/avatar/2021/06/09/6630d193-b3bc-4dc5-aee6-81e46ce40b06.jpeg', '$2a$10$LULerr0cAvEZCTPb3hMUEeKY2Vczvu5l.BCyVY5Gybd5npggux8eq', '0', '0', '', null, 'admin', '2021-05-31 21:00:59', '', null, '无'),
        (121, 103, '3171905201', '李易峰', '00', '1192650760@qq.com', '18396301500', '0', '', '$2a$10$aNutzrXUPC2Em0bLFK87z./6EocKSbzbuhqfPRchyD24QHWC/1J3e', '0', '0', '', null, 'admin', '2021-06-08 20:33:15', '', null, null),
        (122, 103, '3171905202', '刘亦菲', '00', '1192650761@qq.com', '18396301502', '1', '', '$2a$10$Nsfo5J73R7iYcS1GeNa9rur90xfrMUu1BspjZsNg0/cIkrYDKnQjK', '0', '0', '', null, 'admin', '2021-06-08 20:34:46', '', null, null),
        (123, 103, '3171905203', '蓝阿花', '00', '1192650762@qq.com', '18396301503', '1', '', '$2a$10$xnhpajUjzRPyBCdkbP15zuw1vXO9ruPnyYZvWJepC2pcflbpQQRF2', '0', '0', '', null, 'admin', '2021-06-08 20:37:16', '', null, null),
        (124, 103, '3171905204', '蓝花', '00', '1192650763@qq.com
', '18396301504', '1', '', '$2a$10$xnhpajUjzRPyBCdkbP15zuw1vXO9ruPnyYZvWJepC2pcflbpQQRF2', '0', '0', '', null, 'admin
', null, '', null, null),
        (125, 103, '3171905205', '蓝一华', '00', '1192650764@qq.com', '18396301505', '0', '', '$2a$10$zLL1s/wlwqNgikcAwK5HVOzqua67gRiayKKz.VIBpZWRY6S9e5HQK', '0', '0', '', null, 'admin', '2021-06-08 21:49:22', 'admin', '2021-06-08 22:00:51', null),
        (126, 103, '3171905206', '张三', '00', '1192650765@qq.com', '18396301590', '0', '', '$2a$10$DF380xfB.ChZidZIU4Db1eN3bAq2c9VOhiJ4lKSw0EimMTowWCfTa', '0', '0', '', null, 'admin', '2021-06-08 21:49:23', 'admin', '2021-06-08 22:01:35', null),
        (127, 103, '3171905207', '李四', '00', '1192650766@qq.com', '18396301571', '0', '', '$2a$10$VHxSKuGelpTaxRGaEsktVOM.9v8NcTyZt5SGmXar7De0gAKTxmq.m', '0', '0', '', null, 'admin', '2021-06-08 21:49:23', 'admin', '2021-06-08 22:02:27', null),
        (128, 103, '3171905208', '王五', '00', '1192650767@qq.com', '18396301572', '0', '', '$2a$10$eehHZTbWr4yrYytC7uY6heVSt69QnTbQvD8GIPQeXwhOts9dEvTG6', '0', '0', '', null, 'admin', '2021-06-08 21:49:23', 'admin', '2021-06-08 22:02:47', null),
        (129, 103, '3171905209', '赵六', '00', '1192650768@qq.com', '18396301573', '0', '', '$2a$10$eCrv1EOTE0TzvFMZvFR6ku0k7HrR0nTbdNmgNkb0F/ZO9ZDorBpbO', '0', '0', '', null, 'admin', '2021-06-08 21:49:24', 'admin', '2021-06-08 22:03:09', null),
        (130, 103, '3171905210', '谢娜', '00', '1192650710@qq.com', '18396301508', '1', '', '$2a$10$kcN8YfaTWS8FT8aW.bV86uie9I5jTbbxnnLGBAw0CecMUYE8P5Fqi', '0', '0', '', null, 'admin', '2021-06-08 21:49:24', 'admin', '2021-06-08 22:04:52', null),
        (131, 103, '3171905211', '苏渝琪', '00', '1192650770@qq.com', '18396301509', '1', '', '$2a$10$xx63CMQ5MifA9PB.Scf4X.xPPRDLYh8Byyf3RiSEmKl33ecLYNZfC', '0', '0', '', null, 'admin', '2021-06-08 21:49:24', 'admin', '2021-06-08 22:05:14', null),
        (132, 103, '3171905212', '邓超', '00', '1192650771@qq.com', '18396301510', '0', '', '$2a$10$QGIjigPpYqKdMpvNeutZIO6q3P9Qdy2oajHeiOpYcyA6pO.Bxsvc6', '0', '0', '', null, 'admin', '2021-06-08 21:49:25', 'admin', '2021-06-08 22:05:32', null),
        (134, 103, '3171905214', '周杰伦', '00', '1192650773@qq.com', '18396301512', '0', '', '$2a$10$PaGvoX.iLvQE8i0TyED2QuA5KLQWZsnpTfFi9lcWzU21qKfIk4fOq', '0', '0', '', null, 'admin', '2021-06-08 21:49:25', 'admin', '2021-06-08 22:05:43', null),
        (135, 103, '3171905215', '周杰', '00', '1192650774@qq.com', '18396301513', '0', '', '$2a$10$nGwOfLYgP/XpAPjbSsoEyeZO.a4PahSgCjeIXY9IhJQBCzIpSokA6', '0', '0', '', null, 'admin', '2021-06-08 21:49:26', 'admin', '2021-06-08 22:05:58', null),
        (136, 103, '3171905216', '邱月', '00', '1192650775@qq.com', '18396301514', '0', '', '$2a$10$XC5tVx6h2hnZctVmV1pPdOgZNh2/rTXUGkLfTknHFvheGHwZVkeG2', '0', '0', '', null, 'admin', '2021-06-08 21:49:26', 'admin', '2021-06-08 22:06:11', null),
        (137, 103, '3171905217', '蓝树琴', '00', '1192650776@qq.com', '18396301515', '1', '', '$2a$10$0fsUihvlhZHYIKgxVoJS7.U4Nwz8M535KJOlcwczPaSxcmww78w1K', '0', '0', '', null, 'admin', '2021-06-08 21:49:26', 'admin', '2021-06-08 22:06:20', null),
        (138, 103, '3171905218', '刘美琪', '00', '1192650777@qq.com', '18396301516', '1', '', '$2a$10$WIiWdX3hjD8HKkrYrIxBvebRGOsATggG94uBYHDiPo.eHUfjw7xUy', '0', '0', '', null, 'admin', '2021-06-08 21:49:27', 'admin', '2021-06-08 22:06:30', null),
        (139, 103, '3171905219', '刘凤英', '00', '1192650778@qq.com', '18396301517', '1', '', '$2a$10$64YKlgijD47J1l9wyfVsteRVVfYZh7OEmU519MtHbrIzxD5MTXB9y', '0', '0', '', null, 'admin', '2021-06-08 21:49:27', 'admin', '2021-06-08 22:06:39', null),
        (140, 103, '3171905220', '蓝凤英', '00', '1192650779@qq.com', '18396301518', '1', '', '$2a$10$ojTe2Xqd7G3ZdvdlpxTe6u0wVLkLqtwyqW8QNPFFruzlxK4zOm/TK', '0', '0', '', null, 'admin', '2021-06-08 21:49:27', 'admin', '2021-06-08 22:06:49', null),
        (141, 103, '3171905221', '蓝开远', '00', '1192650780@qq.com', '18396301519', '0', '', '$2a$10$cuF9NhMH2CqFLi2oEhmkiubKw5e8S34PdUJeFXx1AKizJW0L2XAdu', '0', '0', '', null, 'admin', '2021-06-08 21:49:28', 'admin', '2021-06-08 22:07:01', null),
        (142, 103, '3171905222', '张理学', '00', '1192650781@qq.com', '18396301520', '0', '', '$2a$10$gio47NKI.8Bq29Ce5p8.Duw8Z0zolCrMjOL4y2eoSbpN4Xyyd1OPW', '0', '0', '', null, 'admin', '2021-06-08 21:49:28', 'admin', '2021-06-08 22:07:13', null),
        (143, 103, '3171905223', '蓝耀斌', '00', '1192650782@qq.com', '18396301521', '0', '', '$2a$10$AmDKGRyN0IQoasS.Vx7G/OJF01MZh.jV1iUKjnNoShxGB4HISfplq', '0', '0', '', null, 'admin', '2021-06-08 21:49:29', 'admin', '2021-06-08 22:07:42', null),
        (144, 103, '3171905224', '刘松联', '00', '1192650783@qq.com', '18396301522', '0', '', '$2a$10$mUPRR2QYnsuomounAadgneIEbPokSOdQwhV7nWJA7hK82M6SGX/Ne', '0', '0', '', null, 'admin', '2021-06-08 21:49:29', 'admin', '2021-06-08 22:08:03', null),
        (145, 103, '3171905225', '刘长胜', '00', '1192650784@qq.com', '18396301523', '0', '', '$2a$10$zZOaZIsJjVIljE/sw8f.xuyl8D8F2fceHtTdB83PdR4B/yeUESLlO', '0', '0', '', null, 'admin', '2021-06-08 21:49:29', 'admin', '2021-06-08 22:07:51', null),
        (146, 103, '3171905226', '兰花龙', '00', '1192650785@qq.com', '18396301524', '0', '', '$2a$10$I56VHNq2AKUMIi2PxgQVQOTwC6XY82mCYNy9FbQYxeUuimsDQGara', '0', '0', '', null, 'admin', '2021-06-08 21:49:30', 'admin', '2021-06-08 22:08:12', null),
        (147, 103, '3171905227', '雷先梅', '00', '1192650786@qq.com', '18396301525', '1', '', '$2a$10$JRhe/2AMATHbTgmn5ZAfGeosV/cAJksifXT4kdDBXtTxurSOYxgia', '0', '0', '', null, 'admin', '2021-06-08 21:49:30', 'admin', '2021-06-08 22:08:21', null),
        (148, 103, '3171905228', '陈欣', '00', '1192650787@qq.com', '18396301526', '1', '', '$2a$10$ZXCJKYPy0uHnlW0dsCmMX.N7Y7gX0GO3zL/N0y.JbuWl7emsJ2nnG', '0', '0', '', null, 'admin', '2021-06-08 21:49:31', 'admin', '2021-06-08 22:08:29', null),
        (149, 103, '3171905229', '陈涛', '00', '1192650788@qq.com', '18396301527', '0', '', '$2a$10$hrllrJSh40kyBabx8VulfOhwYFSAfdg1zKefusAxF/FIDkVsI9NGu', '0', '0', '', null, 'admin', '2021-06-08 21:49:31', 'admin', '2021-06-08 22:08:39', null),
        (150, 103, '3171905230', '高翔', '00', '1192650789@qq.com', '18396301528', '1', '', '$2a$10$9nvu93kWauSl9izkP3m1heWbbVwkAkMqooXlWNcXGUv7bZRtOZNV.', '0', '0', '', null, 'admin', '2021-06-08 21:49:31', 'admin', '2021-06-08 22:08:47', null),
        (151, 103, '3171905231', '蓝学伟', '00', '1192650790@qq.com', '18396301529', '0', '', '$2a$10$ajaxyM/pmG63w4xXWl3qFOXWaHlziSSGKxUO2ASJVS9TsZnpLs9Ni', '0', '0', '', null, 'admin', '2021-06-08 21:49:32', 'admin', '2021-06-08 22:08:59', null),
        (152, 103, '3171905232', '李晓莲', '00', '1192650791@qq.com', '18396301530', '1', '', '$2a$10$K.ya4CBON.fcrEOEgrBTDeUhZ0vpVM7z95RFNB.iQvyMt8ZvATtNG', '0', '0', '', null, 'admin', '2021-06-08 21:49:32', 'admin', '2021-06-08 22:09:11', null),
        (153, 103, '3171905233', '蓝杭琴', '00', '1192650792@qq.com', '18396301531', '1', '', '$2a$10$7.INE0DuTyx/imVYn1XXiOMVQ7mzfy2zqcHwAlGrkCE/b6g3vkNom', '0', '0', '', null, 'admin', '2021-06-08 21:49:32', 'admin', '2021-06-08 22:09:23', null),
        (154, 103, '3171905234', '黄杭琴', '00', '1192650793@qq.com', '18396301532', '1', '', '$2a$10$I1q5ynIg5.f8o0bi/se5yeavy8fCMB4RGwX8HqVdZw0qpbJdLKDmi', '0', '0', '', null, 'admin', '2021-06-08 21:49:33', 'admin', '2021-06-08 22:09:34', null),
        (155, 103, '3171905235', '郭海标', '00', '1192650794@qq.com', '18396301533', '0', '', '$2a$10$2ZEhO/xWGaC8CwgBy0rlwOS.Mq4msT5lp.uvsljEMCJTnQ5rw4KQS', '0', '0', '', null, 'admin', '2021-06-08 21:49:33', 'admin', '2021-06-08 22:09:48', null),
        (156, 103, '3171905236', '郭锅', '00', '1192650795@qq.com', '18396301534', '0', '', '$2a$10$BbgOAhhYFb5ZotPIwz8pEee/kQFk4jfCekwwsgU8YPOBqQWRkiRUe', '0', '0', '', null, 'admin', '2021-06-08 21:49:34', 'admin', '2021-06-08 22:10:03', null),
        (157, 103, '3171905237', '林小志', '00', '1192650796@qq.com', '18396301535', '1', '', '$2a$10$1tmIaMuB/zdc3/S5bS1fPubMmcValShbwwFo9YwKQ3Twi9zX3DCZ2', '0', '0', '', null, 'admin', '2021-06-08 21:49:34', 'admin', '2021-06-08 22:10:22', null),
        (158, 103, '3171905238', '林志颖', '00', '1192650797@qq.com', '18396301536', '0', '', '$2a$10$1IPmEpV75fTZHjrTl2BN/eZboRqLKLFrg6wAUnw7KTB95ZK1S70hG', '0', '0', '', null, 'admin', '2021-06-08 21:49:34', 'admin', '2021-06-08 22:10:32', null),
        (159, 103, '3171905239', '林子', '00', '1192650798@qq.com', '18396301537', '0', '', '$2a$10$LlQd3BKgxZSqaNDsFUp8Tee/AFEhdWWelTsED9AjXg1X7JgCtgGJW', '0', '0', '', null, 'admin', '2021-06-08 21:49:35', 'admin', '2021-06-08 22:10:44', null),
        (160, 103, '3171905240', '蓝晶', '00', '1192650799@qq.com', '18396301538', '1', '', '$2a$10$.YPj/.3ZHO1KaknovtJwtOJNWSlmwA0UA7cshe4LyLjxp1m0J6S6W', '0', '0', '', null, 'admin', '2021-06-08 21:49:35', 'admin', '2021-06-08 22:10:52', null),
        (161, 103, '3171905241', '蓝蓝', '00', '1192650800@qq.com', '18396301539', '1', '', '$2a$10$EYgu35l4Ad6El9B704i1F.nJzQ3oFfOz9vAZhFevxs6Ch2KA/EbXm', '0', '0', '', null, 'admin', '2021-06-08 21:49:35', 'admin', '2021-06-08 22:11:06', null),
        (162, 103, '3171905242', '蓝含', '00', '1192650801@qq.com', '18396301540', '1', '', '$2a$10$cxO6HXD3qA/aF3s7Z8p83emW/ECn/iKaLtKJbKbFS4Cb2sloI1f4O', '0', '0', '', null, 'admin', '2021-06-08 21:49:36', 'admin', '2021-06-08 22:11:16', null),
        (163, 103, '3171905243', '陈涵', '00', '1192650802@qq.com', '18396301541', '1', '', '$2a$10$/KqlrX4xrvf5iu0.XzfEGu1UB8SbZ/xZqqhP2KbxF.4A1XEqD0owy', '0', '0', '', null, 'admin', '2021-06-08 21:49:36', 'admin', '2021-06-08 22:11:24', null),
        (164, 103, '3171905244', '钟志斌', '00', '1192650803@qq.com', '18396301542', '0', '', '$2a$10$qz5PTp1fB72cURsQsRTlvuFGAZy9XK4xK43wEmctqqtvG37lLMGGm', '0', '0', '', null, 'admin', '2021-06-08 21:49:36', 'admin', '2021-06-08 22:11:33', null),
        (165, 103, '3171905245', '李林南', '00', '1192650804@qq.com', '18396301543', '0', '', '$2a$10$ON96e4JAMHVu.ibXamXY.up6inXNzvl0FVqXlc29CHwUkr1E3xWqm', '0', '0', '', null, 'admin', '2021-06-08 21:49:37', 'admin', '2021-06-08 22:11:43', null),
        (166, 103, '3171905246', '吴华', '00', '1192650805@qq.com', '18396301544', '1', '', '$2a$10$eGPidJx.92/pHP2u7hU2f.7z8YzybXMwE/Qz4ZCbLPKfwOcx13oTm', '0', '0', '', null, 'admin', '2021-06-08 21:49:37', 'admin', '2021-06-08 22:11:51', null),
        (167, 103, '3171905247', '刘华一', '00', '1192650806@qq.com', '18396301545', '0', '', '$2a$10$LKdKtPhOOEjzQfiLil2KR.cGDgW7CxJzgqJqD2eEMDcDcs.6h3Zk.', '0', '0', '', null, 'admin', '2021-06-08 21:49:37', 'admin', '2021-06-08 22:12:07', null),
        (168, 103, '3171905248', '王浩名', '00', '1192650807@qq.com', '18396301546', '0', '', '$2a$10$ByNDIJTzOXFldmTBnh5.sOwzZriUhr90wdR6Em.lt4eWB.4ozqcOK', '0', '0', '', null, 'admin', '2021-06-08 21:49:38', 'admin', '2021-06-08 22:12:16', null),
        (169, null, '123322', '福建龙州有限公司', '00', '897231@qq.com', '18514293980', '1', '', '$2a$10$ByNDIJTzOXFldmTBnh5.sOwzZriUhr90wdR6Em.lt4eWB.4ozqcOK', '0', '0', '', null, 'admin', null, 'admin
', null, null),
        (170, null, '123323', '厦门金华有限公司', '00', '897232@qq.com', '18514293981', '1', '', '$2a$10$ByNDIJTzOXFldmTBnh5.sOwzZriUhr90wdR6Em.lt4eWB.4ozqcOK', '0', '0', '', null, 'admin', null, 'admin', null, null),
        (171, null, '123421', '福州博思', '00', '45321451@qq.com', '15080238167', '0', '/profile/avatar/2021/06/09/b0e5dd9d-5d21-4afe-a711-29d67eb3e63d.jpeg', '$2a$10$EYOg6EZOYMJtRY98wEgyruaFhR7D4gvxPcMfvd5tX5zInCJo66K1e', '0', '0', '', null, '', '2021-06-09 12:06:39', '', null, null),
        (172, null, '123987', '福州顶点科技', '00', '1192650821@qq.com', '15080239188', '0', '', '$2a$10$kq0nr/GdTLL1.8R/yh7zRe7T/JYiHFuUDAgbDJ80WNlkW5vcDGVQy', '0', '0', '', null, '', '2021-06-10 11:13:26', '', null, null);

-- ----------------------------
-- 3、岗位信息表
-- ----------------------------
drop table if exists sys_post;
create table sys_post
(
    post_id     bigint(20)  not null auto_increment comment '岗位ID',
    post_code   varchar(64) not null comment '岗位编码',
    post_name   varchar(50) not null comment '岗位名称',
    post_sort   int(4)      not null comment '显示顺序',
    status      char(1)     not null comment '状态（0正常 1停用）',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (post_id)
) engine = innodb comment = '岗位信息表';

-- ----------------------------
-- 初始化-岗位信息表数据
-- ----------------------------
insert into sys_post
values (1, 'ceo', '董事长', 1, '0', 'admin', sysdate(), '', null, ''),
 (2, 'se', '项目经理', 2, '0', 'admin', sysdate(), '', null, ''),
 (3, 'hr', '人力资源', 3, '0', 'admin', sysdate(), '', null, ''),
 (4, 'user', '普通员工', 4, '0', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 4、角色信息表
-- ----------------------------
drop table if exists sys_role;
create table sys_role
(
    role_id             bigint(20)   not null auto_increment comment '角色ID',
    role_name           varchar(30)  not null comment '角色名称',
    role_key            varchar(100) not null comment '角色权限字符串',
    role_sort           int(4)       not null comment '显示顺序',
    data_scope          char(1)      default '1' comment '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
    menu_check_strictly tinyint(1)   default 1 comment '菜单树选择项是否关联显示',
    dept_check_strictly tinyint(1)   default 1 comment '部门树选择项是否关联显示',
    status              char(1)      not null comment '角色状态（0正常 1停用）',
    del_flag            char(1)      default '0' comment '删除标志（0代表存在 2代表删除）',
    create_by           varchar(64)  default '' comment '创建者',
    create_time         datetime comment '创建时间',
    update_by           varchar(64)  default '' comment '更新者',
    update_time         datetime comment '更新时间',
    remark              varchar(500) default null comment '备注',
    primary key (role_id)
) engine = innodb
  auto_increment = 100 comment = '角色信息表';

-- ----------------------------
-- 初始化-角色信息表数据
-- ----------------------------
insert into sys_role (role_id, role_name, role_key, role_sort, data_scope, menu_check_strictly, dept_check_strictly, status, del_flag, create_by, create_time, update_by, update_time, remark)
values  (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2021-03-24 17:15:48', '', null, '超级管理员'),
        (2, '普通角色', 'common', 2, '2', 1, 1, '0', '0', 'admin', '2021-03-24 17:15:48', '', null, '普通角色'),
        (100, '已认证企业用户', 'auth_company', 3, '1', 1, 1, '0', '0', 'admin', '2021-04-20 09:07:59', 'admin', '2021-04-25 08:24:31', null),
        (101, '学生', 'student', 4, '1', 1, 1, '0', '0', 'admin', '2021-04-20 09:08:23', '', null, null),
        (102, '未认证企业', 'no_auth_company', 5, '1', 1, 1, '0', '0', 'admin', '2021-04-20 10:07:19', 'admin', '2021-04-23 13:01:09', null);


-- ----------------------------
-- 5、菜单权限表
-- ----------------------------
drop table if exists sys_menu;
create table sys_menu
(
    menu_id     bigint(20)  not null auto_increment comment '菜单ID',
    menu_name   varchar(50) not null comment '菜单名称',
    parent_id   bigint(20)   default 0 comment '父菜单ID',
    order_num   int(4)       default 0 comment '显示顺序',
    path        varchar(200) default '' comment '路由地址',
    component   varchar(255) default null comment '组件路径',
    is_frame    int(1)       default 1 comment '是否为外链（0是 1否）',
    is_cache    int(1)       default 0 comment '是否缓存（0缓存 1不缓存）',
    menu_type   char(1)      default '' comment '菜单类型（M目录 C菜单 F按钮）',
    visible     char(1)      default 0 comment '菜单状态（0显示 1隐藏）',
    status      char(1)      default 0 comment '菜单状态（0正常 1停用）',
    perms       varchar(100) default null comment '权限标识',
    icon        varchar(100) default '#' comment '菜单图标',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default '' comment '备注',
    primary key (menu_id)
) engine = innodb
  auto_increment = 2000 comment = '菜单权限表';

-- ----------------------------
-- 初始化-菜单信息表数据
-- ----------------------------
insert into recruit.sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values  (1, '系统管理', 0, 1, 'system', null, 1, 0, 'M', '0', '0', '', 'system', 'admin', '2021-03-24 17:15:49', '', null, '系统管理目录'),
        (2, '系统监控', 0, 2, 'monitor', null, 1, 0, 'M', '0', '0', '', 'monitor', 'admin', '2021-03-24 17:15:49', 'admin', '2021-05-08 23:31:51', '系统监控目录'),
        (3, '系统工具', 0, 3, 'tool', null, 1, 0, 'M', '0', '0', '', 'tool', 'admin', '2021-03-24 17:15:49', 'admin', '2021-05-08 23:31:34', '系统工具目录'),
        (4, '学校官网', 0, 4, 'http://baidu.com', null, 0, 0, 'M', '0', '0', '', 'guide', 'admin', '2021-03-24 17:15:49', 'admin', '2021-04-30 23:56:31', '若依官网地址'),
        (100, '学生管理', 2063, 1, 'user', 'system/user/index', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2021-03-24 17:15:50', 'admin', '2021-04-30 14:43:10', '用户管理菜单'),
        (101, '角色管理', 1, 2, 'role', 'system/role/index', 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2021-03-24 17:15:50', '', null, '角色管理菜单'),
        (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2021-03-24 17:15:50', '', null, '菜单管理菜单'),
        (103, '学院管理', 1, 4, 'dept', 'system/dept/index', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2021-03-24 17:15:50', 'admin', '2021-04-30 11:21:14', '部门管理菜单'),
        (104, '岗位管理', 1, 5, 'post', 'system/post/index', 1, 0, 'C', '0', '0', 'system:post:list', 'post', 'admin', '2021-03-24 17:15:50', '', null, '岗位管理菜单'),
        (105, '字典管理', 1, 6, 'dict', 'system/dict/index', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2021-03-24 17:15:50', 'admin', '2021-05-08 23:32:25', '字典管理菜单'),
        (106, '参数设置', 1, 7, 'config', 'system/config/index', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2021-03-24 17:15:50', 'admin', '2021-05-09 10:24:24', '参数设置菜单'),
        (107, '通知公告', 1, 8, 'notice', 'system/notice/index', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2021-03-24 17:15:50', 'admin', '2021-04-30 11:27:59', '通知公告菜单'),
        (108, '日志管理', 1, 9, 'log', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', '2021-03-24 17:15:50', 'admin', '2021-05-08 23:32:16', '日志管理菜单'),
        (109, '在线用户', 2, 1, 'online', 'monitor/online/index', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2021-03-24 17:15:50', '', null, '在线用户菜单'),
        (111, '数据监控', 2, 3, 'druid', 'monitor/druid/index', 1, 0, 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin', '2021-03-24 17:15:50', '', null, '数据监控菜单'),
        (112, '服务监控', 2, 4, 'server', 'monitor/server/index', 1, 0, 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2021-03-24 17:15:50', '', null, '服务监控菜单'),
        (113, '缓存监控', 2, 5, 'cache', 'monitor/cache/index', 1, 0, 'C', '0', '0', 'monitor:cache:list', 'redis', 'admin', '2021-03-24 17:15:50', '', null, '缓存监控菜单'),
        (114, '表单构建', 3, 1, 'build', 'tool/build/index', 1, 0, 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2021-03-24 17:15:50', '', null, '表单构建菜单'),
        (115, '代码生成', 3, 2, 'gen', 'tool/gen/index', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2021-03-24 17:15:50', '', null, '代码生成菜单'),
        (116, '系统接口', 3, 3, 'swagger', 'tool/swagger/index', 1, 0, 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin', '2021-03-24 17:15:50', '', null, '系统接口菜单'),
        (500, '操作日志', 108, 1, 'operlog', 'monitor/operlog/index', 1, 0, 'C', '0', '0', 'monitor:operlog:list', 'form', 'admin', '2021-03-24 17:15:50', '', null, '操作日志菜单'),
        (501, '登录日志', 108, 2, 'logininfor', 'monitor/logininfor/index', 1, 0, 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2021-03-24 17:15:50', '', null, '登录日志菜单'),
        (1001, '用户查询', 100, 1, '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', '2021-03-24 17:15:51', '', null, ''),
        (1002, '用户新增', 100, 2, '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', '2021-03-24 17:15:51', '', null, ''),
        (1003, '用户修改', 100, 3, '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', '2021-03-24 17:15:51', '', null, ''),
        (1004, '用户删除', 100, 4, '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', '2021-03-24 17:15:51', '', null, ''),
        (1005, '用户导出', 100, 5, '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', '2021-03-24 17:15:51', '', null, ''),
        (1006, '用户导入', 100, 6, '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', '2021-03-24 17:15:51', '', null, ''),
        (1007, '重置密码', 100, 7, '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2021-03-24 17:15:51', '', null, ''),
        (1008, '角色查询', 101, 1, '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', '2021-03-24 17:15:52', '', null, ''),
        (1009, '角色新增', 101, 2, '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', '2021-03-24 17:15:52', '', null, ''),
        (1010, '角色修改', 101, 3, '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', '2021-03-24 17:15:52', '', null, ''),
        (1011, '角色删除', 101, 4, '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', '2021-03-24 17:15:52', '', null, ''),
        (1012, '角色导出', 101, 5, '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', '2021-03-24 17:15:52', '', null, ''),
        (1013, '菜单查询', 102, 1, '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', '2021-03-24 17:15:52', '', null, ''),
        (1014, '菜单新增', 102, 2, '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', '2021-03-24 17:15:52', '', null, ''),
        (1015, '菜单修改', 102, 3, '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2021-03-24 17:15:52', '', null, ''),
        (1016, '菜单删除', 102, 4, '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2021-03-24 17:15:52', '', null, ''),
        (1017, '部门查询', 103, 1, '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', '2021-03-24 17:15:53', '', null, ''),
        (1018, '部门新增', 103, 2, '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', '2021-03-24 17:15:53', '', null, ''),
        (1019, '部门修改', 103, 3, '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2021-03-24 17:15:53', '', null, ''),
        (1020, '部门删除', 103, 4, '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2021-03-24 17:15:53', '', null, ''),
        (1021, '岗位查询', 104, 1, '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', '2021-03-24 17:15:53', '', null, ''),
        (1022, '岗位新增', 104, 2, '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', '2021-03-24 17:15:53', '', null, ''),
        (1023, '岗位修改', 104, 3, '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', '2021-03-24 17:15:53', '', null, ''),
        (1024, '岗位删除', 104, 4, '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', '2021-03-24 17:15:53', '', null, ''),
        (1025, '岗位导出', 104, 5, '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', '2021-03-24 17:15:53', '', null, ''),
        (1026, '字典查询', 105, 1, '#', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2021-03-24 17:15:54', '', null, ''),
        (1027, '字典新增', 105, 2, '#', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', '2021-03-24 17:15:54', '', null, ''),
        (1028, '字典修改', 105, 3, '#', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2021-03-24 17:15:54', '', null, ''),
        (1029, '字典删除', 105, 4, '#', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2021-03-24 17:15:54', '', null, ''),
        (1030, '字典导出', 105, 5, '#', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', '2021-03-24 17:15:54', '', null, ''),
        (1031, '参数查询', 106, 1, '#', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin', '2021-03-24 17:15:54', '', null, ''),
        (1032, '参数新增', 106, 2, '#', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', '2021-03-24 17:15:54', '', null, ''),
        (1033, '参数修改', 106, 3, '#', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', '2021-03-24 17:15:54', '', null, ''),
        (1034, '参数删除', 106, 4, '#', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin', '2021-03-24 17:15:54', '', null, ''),
        (1035, '参数导出', 106, 5, '#', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin', '2021-03-24 17:15:54', '', null, ''),
        (1036, '公告查询', 107, 1, '#', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin', '2021-03-24 17:15:55', '', null, ''),
        (1037, '公告新增', 107, 2, '#', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', '2021-03-24 17:15:55', '', null, ''),
        (1038, '公告修改', 107, 3, '#', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2021-03-24 17:15:55', '', null, ''),
        (1039, '公告删除', 107, 4, '#', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2021-03-24 17:15:55', '', null, ''),
        (1040, '操作查询', 500, 1, '#', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query', '#', 'admin', '2021-03-24 17:15:55', '', null, ''),
        (1041, '操作删除', 500, 2, '#', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin', '2021-03-24 17:15:55', '', null, ''),
        (1042, '日志导出', 500, 4, '#', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export', '#', 'admin', '2021-03-24 17:15:55', '', null, ''),
        (1043, '登录查询', 501, 1, '#', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin', '2021-03-24 17:15:56', '', null, ''),
        (1044, '登录删除', 501, 2, '#', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin', '2021-03-24 17:15:56', '', null, ''),
        (1045, '日志导出', 501, 3, '#', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin', '2021-03-24 17:15:56', '', null, ''),
        (1046, '在线查询', 109, 1, '#', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2021-03-24 17:15:56', '', null, ''),
        (1047, '批量强退', 109, 2, '#', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2021-03-24 17:15:56', '', null, ''),
        (1048, '单条强退', 109, 3, '#', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2021-03-24 17:15:56', '', null, ''),
        (1049, '任务查询', 110, 1, '#', '', 1, 0, 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2021-03-24 17:15:57', '', null, ''),
        (1050, '任务新增', 110, 2, '#', '', 1, 0, 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2021-03-24 17:15:57', '', null, ''),
        (1051, '任务修改', 110, 3, '#', '', 1, 0, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2021-03-24 17:15:57', '', null, ''),
        (1052, '任务删除', 110, 4, '#', '', 1, 0, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2021-03-24 17:15:57', '', null, ''),
        (1053, '状态修改', 110, 5, '#', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2021-03-24 17:15:57', '', null, ''),
        (1054, '任务导出', 110, 7, '#', '', 1, 0, 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2021-03-24 17:15:57', '', null, ''),
        (1055, '生成查询', 115, 1, '#', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2021-03-24 17:15:58', '', null, ''),
        (1056, '生成修改', 115, 2, '#', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2021-03-24 17:15:58', '', null, ''),
        (1057, '生成删除', 115, 3, '#', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2021-03-24 17:15:58', '', null, ''),
        (1058, '导入代码', 115, 2, '#', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2021-03-24 17:15:58', '', null, ''),
        (1059, '预览代码', 115, 4, '#', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2021-03-24 17:15:58', '', null, ''),
        (1060, '生成代码', 115, 5, '#', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2021-03-24 17:15:58', '', null, ''),
        (2000, '招聘管理', 0, 1, 'recruit', null, 1, 0, 'M', '0', '0', '', 'checkbox', 'admin', '2021-03-25 08:45:03', 'admin', '2021-03-25 08:45:19', ''),
        (2001, '企业信息', 2000, 1, 'company', 'system/recruit/company/index', 1, 0, 'C', '0', '0', 'recruit:info:list', 'guide', 'admin', '2021-03-25 08:46:56', 'admin', '2021-05-11 12:42:51', '企业信息菜单'),
        (2002, '企业信息查询', 2001, 1, '#', '', 1, 0, 'F', '0', '0', 'recruit:info:query', '#', 'admin', '2021-03-25 08:46:58', '', null, ''),
        (2003, '企业信息新增', 2001, 2, '#', '', 1, 0, 'F', '0', '0', 'recruit:info:add', '#', 'admin', '2021-03-25 08:46:58', '', null, ''),
        (2004, '企业信息修改', 2001, 3, '#', '', 1, 0, 'F', '0', '0', 'recruit:info:edit', '#', 'admin', '2021-03-25 08:46:59', '', null, ''),
        (2005, '企业信息删除', 2001, 4, '#', '', 1, 0, 'F', '0', '0', 'recruit:info:remove', '#', 'admin', '2021-03-25 08:46:59', '', null, ''),
        (2006, '企业信息导出', 2001, 5, '#', '', 1, 0, 'F', '0', '0', 'recruit:info:export', '#', 'admin', '2021-03-25 08:47:00', '', null, ''),
        (2007, '岗位分类', 2000, 1, 'category', 'system/recruit/category/index', 1, 0, 'C', '0', '0', 'recruit:category:list', 'build', 'admin', '2021-03-25 09:11:21', 'admin', '2021-05-11 12:43:05', '岗位分类菜单'),
        (2008, '岗位分类查询', 2007, 1, '#', '', 1, 0, 'F', '0', '0', 'recruit:category:query', '#', 'admin', '2021-03-25 09:11:22', '', null, ''),
        (2009, '岗位分类新增', 2007, 2, '#', '', 1, 0, 'F', '0', '0', 'recruit:category:add', '#', 'admin', '2021-03-25 09:11:22', '', null, ''),
        (2010, '岗位分类修改', 2007, 3, '#', '', 1, 0, 'F', '0', '0', 'recruit:category:edit', '#', 'admin', '2021-03-25 09:11:23', '', null, ''),
        (2011, '岗位分类删除', 2007, 4, '#', '', 1, 0, 'F', '0', '0', 'recruit:category:remove', '#', 'admin', '2021-03-25 09:11:23', '', null, ''),
        (2012, '岗位分类导出', 2007, 5, '#', '', 1, 0, 'F', '0', '0', 'recruit:category:export', '#', 'admin', '2021-03-25 09:11:24', '', null, ''),
        (2024, '招聘岗位', 2000, 1, 'position', 'system/recruit/position/index', 1, 0, 'C', '0', '0', 'recruit:position:list', 'component', 'admin', '2021-03-25 09:12:09', 'admin', '2021-05-11 12:43:18', '招聘岗位菜单'),
        (2020, '招聘岗位查询', 2024, 1, '#', '', 1, 0, 'F', '0', '0', 'recruit:position:query', '#', 'admin', '2021-03-25 09:12:11', '', null, ''),
        (2021, '招聘岗位新增', 2024, 2, '#', '', 1, 0, 'F', '0', '0', 'recruit:position:add', '#', 'admin', '2021-03-25 09:12:11', '', null, ''),
        (2022, '招聘岗位修改', 2024, 3, '#', '', 1, 0, 'F', '0', '0', 'recruit:position:edit', '#', 'admin', '2021-03-25 09:12:12', '', null, ''),
        (2023, '招聘岗位删除', 2024, 4, '#', '', 1, 0, 'F', '0', '0', 'recruit:position:remove', '#', 'admin', '2021-03-25 09:12:12', '', null, ''),
        (2024, '招聘岗位导出', 2024, 5, '#', '', 1, 0, 'F', '0', '0', 'recruit:position:export', '#', 'admin', '2021-03-25 09:12:13', '', null, ''),
        (2025, '基础设施管理', 2000, 1, 'classroom', 'system/recruit/classroom/index', 1, 0, 'C', '0', '0', 'recruit:classroom:list', 'edit', 'admin', '2021-04-03 21:29:14', 'admin', '2021-05-11 12:43:26', '教室菜单'),
        (2026, '教室查询', 2025, 1, '#', '', 1, 0, 'F', '0', '0', 'recruit:classroom:query', '#', 'admin', '2021-04-03 21:29:16', '', null, ''),
        (2027, '教室新增', 2025, 2, '#', '', 1, 0, 'F', '0', '0', 'recruit:classroom:add', '#', 'admin', '2021-04-03 21:29:16', '', null, ''),
        (2028, '教室修改', 2025, 3, '#', '', 1, 0, 'F', '0', '0', 'recruit:classroom:edit', '#', 'admin', '2021-04-03 21:29:17', '', null, ''),
        (2029, '教室删除', 2025, 4, '#', '', 1, 0, 'F', '0', '0', 'recruit:classroom:remove', '#', 'admin', '2021-04-03 21:29:17', '', null, ''),
        (2030, '教室导出', 2025, 5, '#', '', 1, 0, 'F', '0', '0', 'recruit:classroom:export', '#', 'admin', '2021-04-03 21:29:18', '', null, ''),
        (2031, '简历投递信息', 2000, 1, 'delivery', 'system/recruit/delivery/index', 1, 0, 'C', '0', '0', 'recruit:delivery:list', 'drag', 'admin', '2021-04-03 21:29:28', 'admin', '2021-05-11 12:43:35', '简历投递信息菜单'),
        (2032, '简历投递信息查询', 2031, 1, '#', '', 1, 0, 'F', '0', '0', 'recruit:delivery:query', '#', 'admin', '2021-04-03 21:29:30', '', null, ''),
        (2034, '简历投递信息修改', 2031, 3, '#', '', 1, 0, 'F', '0', '0', 'recruit:delivery:edit', '#', 'admin', '2021-04-03 21:29:31', '', null, ''),
        (2035, '简历投递信息删除', 2031, 4, '#', '', 1, 0, 'F', '0', '0', 'recruit:delivery:remove', '#', 'admin', '2021-04-03 21:29:31', '', null, ''),
        (2036, '简历投递信息导出', 2031, 5, '#', '', 1, 0, 'F', '0', '0', 'recruit:delivery:export', '#', 'admin', '2021-04-03 21:29:32', '', null, ''),
        (2037, '讲座申请', 2000, 1, 'lecture', 'system/recruit/lecture/index', 1, 0, 'C', '0', '0', 'recruit:lecture:list', 'education', 'admin', '2021-04-03 21:29:35', 'admin', '2021-05-11 12:43:46', '讲座申请菜单'),
        (2038, '讲座申请查询', 2037, 1, '#', '', 1, 0, 'F', '0', '0', 'recruit:lecture:query', '#', 'admin', '2021-04-03 21:29:37', '', null, ''),
        (2039, '讲座申请新增', 2037, 2, '#', '', 1, 0, 'F', '0', '0', 'recruit:lecture:add', '#', 'admin', '2021-04-03 21:29:37', '', null, ''),
        (2040, '讲座申请修改', 2037, 3, '#', '', 1, 0, 'F', '0', '0', 'recruit:lecture:edit', '#', 'admin', '2021-04-03 21:29:38', '', null, ''),
        (2041, '讲座申请删除', 2037, 4, '#', '', 1, 0, 'F', '0', '0', 'recruit:lecture:remove', '#', 'admin', '2021-04-03 21:29:38', '', null, ''),
        (2042, '讲座申请导出', 2037, 5, '#', '', 1, 0, 'F', '0', '0', 'recruit:lecture:export', '#', 'admin', '2021-04-03 21:29:39', '', null, ''),
        (2043, '消息', 2000, 1, 'message', 'system/recruit/message/index', 1, 0, 'C', '0', '0', 'recruit:message:list', '#', 'admin', '2021-04-03 21:29:47', 'admin', '2021-04-22 13:02:56', '消息菜单'),
        (2044, '消息查询', 2043, 1, '#', '', 1, 0, 'F', '0', '0', 'recruit:message:query', '#', 'admin', '2021-04-03 21:29:49', '', null, ''),
        (2045, '消息新增', 2043, 2, '#', '', 1, 0, 'F', '0', '0', 'recruit:message:add', '#', 'admin', '2021-04-03 21:29:49', '', null, ''),
        (2046, '消息修改', 2043, 3, '#', '', 1, 0, 'F', '0', '0', 'recruit:message:edit', '#', 'admin', '2021-04-03 21:29:50', '', null, ''),
        (2047, '消息删除', 2043, 4, '#', '', 1, 0, 'F', '0', '0', 'recruit:message:remove', '#', 'admin', '2021-04-03 21:29:50', '', null, ''),
        (2048, '消息导出', 2043, 5, '#', '', 1, 0, 'F', '0', '0', 'recruit:message:export', '#', 'admin', '2021-04-03 21:29:51', '', null, ''),
        (2049, '学生简历信息', 2000, 1, 'resume', 'system/recruit/resume/index', 1, 0, 'C', '0', '0', 'recruit:resume:list', 'education', 'admin', '2021-04-03 21:30:06', 'admin', '2021-05-11 12:44:20', '学生简历信息菜单'),
        (2050, '学生简历信息查询', 2049, 1, '#', '', 1, 0, 'F', '0', '0', 'recruit:resume:query', '#', 'admin', '2021-04-03 21:30:08', '', null, ''),
        (2051, '学生简历信息新增', 2049, 2, '#', '', 1, 0, 'F', '0', '0', 'recruit:resume:add', '#', 'admin', '2021-04-03 21:30:08', '', null, ''),
        (2052, '学生简历信息修改', 2049, 3, '#', '', 1, 0, 'F', '0', '0', 'recruit:resume:edit', '#', 'admin', '2021-04-03 21:30:09', '', null, ''),
        (2053, '学生简历信息删除', 2049, 4, '#', '', 1, 0, 'F', '0', '0', 'recruit:resume:remove', '#', 'admin', '2021-04-03 21:30:09', '', null, ''),
        (2054, '学生简历信息导出', 2049, 5, '#', '', 1, 0, 'F', '0', '0', 'recruit:resume:export', '#', 'admin', '2021-04-03 21:30:10', '', null, ''),
        (2055, '学生个人信息', 2000, 1, 'student', 'system/recruit/student/index', 1, 0, 'C', '0', '0', 'recruit:student:list', '#', 'admin', '2021-04-03 21:30:20', 'admin', '2021-05-05 23:39:10', '学生个人信息菜单'),
        (2056, '学生个人信息查询', 2055, 1, '#', '', 1, 0, 'F', '0', '0', 'recruit:student:query', '#', 'admin', '2021-04-03 21:30:21', '', null, ''),
        (2057, '学生个人信息新增', 2055, 2, '#', '', 1, 0, 'F', '0', '0', 'recruit:student:add', '#', 'admin', '2021-04-03 21:30:21', '', null, ''),
        (2058, '学生个人信息修改', 2055, 3, '#', '', 1, 0, 'F', '0', '0', 'recruit:student:edit', '#', 'admin', '2021-04-03 21:30:22', '', null, ''),
        (2059, '学生个人信息删除', 2055, 4, '#', '', 1, 0, 'F', '0', '0', 'recruit:student:remove', '#', 'admin', '2021-04-03 21:30:23', '', null, ''),
        (2060, '学生个人信息导出', 2055, 5, '#', '', 1, 0, 'F', '0', '0', 'recruit:student:export', '#', 'admin', '2021-04-03 21:30:23', '', null, ''),
        (2061, '企业信息同意', 2001, 6, '', null, 1, 0, 'F', '0', '0', 'recruit:info:agree', '#', 'admin', '2021-04-23 13:41:11', '', null, ''),
        (2062, '企业信息驳回', 2001, 7, '', null, 1, 0, 'F', '0', '0', 'recruit:info:reject', '#', 'admin', '2021-04-23 13:42:42', '', null, ''),
        (2063, '用户管理', 1, 1, 'sysuser', null, 1, 0, 'M', '0', '0', null, 'user', 'admin', '2021-04-29 23:21:29', '', null, ''),
        (2064, '企业用户', 2063, 2, 'company-user', 'system/user/company/index', 1, 0, 'C', '0', '0', '', 'post', 'admin', '2021-04-29 23:39:03', 'admin', '2021-04-30 14:44:05', '');

-- ----------------------------
-- 6、用户和角色关联表  用户N-1角色
-- ----------------------------
drop table if exists sys_user_role;
create table sys_user_role
(
    user_id bigint(20) not null comment '用户ID',
    role_id bigint(20) not null comment '角色ID',
    primary key (user_id, role_id)
) engine = innodb comment = '用户和角色关联表';

-- ----------------------------
-- 初始化-用户和角色关联表数据
-- ----------------------------
insert into sys_user_role
values ('1', '1'),
 ('2', '2');


-- ----------------------------
-- 7、角色和菜单关联表  角色1-N菜单
-- ----------------------------
drop table if exists sys_role_menu;
create table sys_role_menu
(
    role_id bigint(20) not null comment '角色ID',
    menu_id bigint(20) not null comment '菜单ID',
    primary key (role_id, menu_id)
) engine = innodb comment = '角色和菜单关联表';

-- ----------------------------
-- 初始化-角色和菜单关联表数据
-- ----------------------------
insert into sys_role_menu (role_id, menu_id)
values  (2, 1),
        (2, 2),
        (2, 3),
        (2, 4),
        (2, 100),
        (2, 101),
        (2, 102),
        (2, 103),
        (2, 104),
        (2, 105),
        (2, 106),
        (2, 107),
        (2, 108),
        (2, 109),
        (2, 110),
        (2, 111),
        (2, 112),
        (2, 113),
        (2, 114),
        (2, 115),
        (2, 116),
        (2, 500),
        (2, 501),
        (2, 1000),
        (2, 1001),
        (2, 1002),
        (2, 1003),
        (2, 1004),
        (2, 1005),
        (2, 1006),
        (2, 1007),
        (2, 1008),
        (2, 1009),
        (2, 1010),
        (2, 1011),
        (2, 1012),
        (2, 1013),
        (2, 1014),
        (2, 1015),
        (2, 1016),
        (2, 1017),
        (2, 1018),
        (2, 1019),
        (2, 1020),
        (2, 1021),
        (2, 1022),
        (2, 1023),
        (2, 1024),
        (2, 1025),
        (2, 1026),
        (2, 1027),
        (2, 1028),
        (2, 1029),
        (2, 1030),
        (2, 1031),
        (2, 1032),
        (2, 1033),
        (2, 1034),
        (2, 1035),
        (2, 1036),
        (2, 1037),
        (2, 1038),
        (2, 1039),
        (2, 1040),
        (2, 1041),
        (2, 1042),
        (2, 1043),
        (2, 1044),
        (2, 1045),
        (2, 1046),
        (2, 1047),
        (2, 1048),
        (2, 1049),
        (2, 1050),
        (2, 1051),
        (2, 1052),
        (2, 1053),
        (2, 1054),
        (2, 1055),
        (2, 1056),
        (2, 1057),
        (2, 1058),
        (2, 1059),
        (2, 1060),
        (100, 2000),
        (100, 2001),
        (100, 2004),
        (100, 2005),
        (100, 2006),
        (100, 2024),
        (100, 2020),
        (100, 2021),
        (100, 2022),
        (100, 2023),
        (100, 2024),
        (100, 2025),
        (100, 2026),
        (100, 2027),
        (100, 2028),
        (100, 2029),
        (100, 2030),
        (100, 2031),
        (100, 2032),
        (100, 2034),
        (100, 2035),
        (100, 2036),
        (100, 2037),
        (100, 2038),
        (100, 2039),
        (100, 2040),
        (100, 2041),
        (100, 2042),
        (102, 2000),
        (102, 2001),
        (102, 2002),
        (102, 2003),
        (102, 2004),
        (102, 2005),
        (102, 2006);

-- ----------------------------
-- 8、角色和部门关联表  角色1-N部门
-- ----------------------------
drop table if exists sys_role_dept;
create table sys_role_dept
(
    role_id bigint(20) not null comment '角色ID',
    dept_id bigint(20) not null comment '部门ID',
    primary key (role_id, dept_id)
) engine = innodb comment = '角色和部门关联表';

-- ----------------------------
-- 初始化-角色和部门关联表数据
-- ----------------------------
insert into sys_role_dept
values ('2', '100'),
 ('2', '101'),
 ('2', '105');


-- ----------------------------
-- 9、用户与岗位关联表  用户1-N岗位
-- ----------------------------
drop table if exists sys_user_post;
create table sys_user_post
(
    user_id bigint(20) not null comment '用户ID',
    post_id bigint(20) not null comment '岗位ID',
    primary key (user_id, post_id)
) engine = innodb comment = '用户与岗位关联表';

-- ----------------------------
-- 初始化-用户与岗位关联表数据
-- ----------------------------
insert into sys_user_post
values ('1', '1'),
 ('2', '2');


-- ----------------------------
-- 10、操作日志记录
-- ----------------------------
drop table if exists sys_oper_log;
create table sys_oper_log
(
    oper_id        bigint(20) not null auto_increment comment '日志主键',
    title          varchar(50)   default '' comment '模块标题',
    business_type  int(2)        default 0 comment '业务类型（0其它 1新增 2修改 3删除）',
    method         varchar(100)  default '' comment '方法名称',
    request_method varchar(10)   default '' comment '请求方式',
    operator_type  int(1)        default 0 comment '操作类别（0其它 1后台用户 2手机端用户）',
    oper_name      varchar(50)   default '' comment '操作人员',
    dept_name      varchar(50)   default '' comment '部门名称',
    oper_url       varchar(255)  default '' comment '请求URL',
    oper_ip        varchar(50)   default '' comment '主机地址',
    oper_location  varchar(255)  default '' comment '操作地点',
    oper_param     varchar(2000) default '' comment '请求参数',
    json_result    varchar(2000) default '' comment '返回参数',
    status         int(1)        default 0 comment '操作状态（0正常 1异常）',
    error_msg      varchar(2000) default '' comment '错误消息',
    oper_time      datetime comment '操作时间',
    primary key (oper_id)
) engine = innodb
  auto_increment = 100 comment = '操作日志记录';


-- ----------------------------
-- 11、字典类型表
-- ----------------------------
drop table if exists sys_dict_type;
create table sys_dict_type
(
    dict_id     bigint(20) not null auto_increment comment '字典主键',
    dict_name   varchar(100) default '' comment '字典名称',
    dict_type   varchar(100) default '' comment '字典类型',
    status      char(1)      default '0' comment '状态（0正常 1停用）',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (dict_id),
    unique (dict_type)
) engine = innodb
  auto_increment = 100 comment = '字典类型表';

insert into sys_dict_type
values (1, '用户性别', 'sys_user_sex', '0', 'admin', sysdate(), '', null, '用户性别列表'),
 (2, '菜单状态', 'sys_show_hide', '0', 'admin', sysdate(), '', null, '菜单状态列表'),
 (3, '系统开关', 'sys_normal_disable', '0', 'admin', sysdate(), '', null, '系统开关列表'),
 (4, '任务状态', 'sys_job_status', '0', 'admin', sysdate(), '', null, '任务状态列表'),
 (5, '任务分组', 'sys_job_group', '0', 'admin', sysdate(), '', null, '任务分组列表'),
 (6, '系统是否', 'sys_yes_no', '0', 'admin', sysdate(), '', null, '系统是否列表'),
 (7, '通知类型', 'sys_notice_type', '0', 'admin', sysdate(), '', null, '通知类型列表'),
 (8, '通知状态', 'sys_notice_status', '0', 'admin', sysdate(), '', null, '通知状态列表'),
 (9, '操作类型', 'sys_oper_type', '0', 'admin', sysdate(), '', null, '操作类型列表'),
 (10, '系统状态', 'sys_common_status', '0', 'admin', sysdate(), '', null, '登录状态列表');


-- ----------------------------
-- 12、字典数据表
-- ----------------------------
drop table if exists sys_dict_data;
create table sys_dict_data
(
    dict_code   bigint(20) not null auto_increment comment '字典编码',
    dict_sort   int(4)       default 0 comment '字典排序',
    dict_label  varchar(100) default '' comment '字典标签',
    dict_value  varchar(100) default '' comment '字典键值',
    dict_type   varchar(100) default '' comment '字典类型',
    css_class   varchar(100) default null comment '样式属性（其他样式扩展）',
    list_class  varchar(100) default null comment '表格回显样式',
    is_default  char(1)      default 'N' comment '是否默认（Y是 N否）',
    status      char(1)      default '0' comment '状态（0正常 1停用）',
    create_by   varchar(64)  default '' comment '创建者',
    create_time datetime comment '创建时间',
    update_by   varchar(64)  default '' comment '更新者',
    update_time datetime comment '更新时间',
    remark      varchar(500) default null comment '备注',
    primary key (dict_code)
) engine = innodb
  auto_increment = 100 comment = '字典数据表';

insert into sys_dict_data
values (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', sysdate(), '', null, '性别男'),
 (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', sysdate(), '', null, '性别女'),
 (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', sysdate(), '', null, '性别未知'),
 (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '显示菜单'),
 (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '隐藏菜单'),
 (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常状态'),
 (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '停用状态'),
 (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常状态'),
 (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '停用状态'),
 (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', sysdate(), '', null, '默认分组'),
 (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', sysdate(), '', null, '系统分组'),
 (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '系统默认是'),
 (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '系统默认否'),
 (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', sysdate(), '', null, '通知'),
 (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', sysdate(), '', null, '公告'),
 (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '正常状态'),
 (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '关闭状态'),
 (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', sysdate(), '', null, '新增操作'),
 (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', sysdate(), '', null, '修改操作'),
 (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '删除操作'),
 (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', sysdate(), '', null, '授权操作'),
 (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', sysdate(), '', null, '导出操作'),
 (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', sysdate(), '', null, '导入操作'),
 (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '强退操作'),
 (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', sysdate(), '', null, '生成操作'),
 (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '清空操作'),
 (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', sysdate(), '', null, '正常状态'),
 (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', sysdate(), '', null, '停用状态');


-- ----------------------------
-- 13、参数配置表
-- ----------------------------
drop table if exists sys_config;
create table sys_config
(
    config_id    int(5) not null auto_increment comment '参数主键',
    config_name  varchar(100) default '' comment '参数名称',
    config_key   varchar(100) default '' comment '参数键名',
    config_value varchar(500) default '' comment '参数键值',
    config_type  char(1)      default 'N' comment '系统内置（Y是 N否）',
    create_by    varchar(64)  default '' comment '创建者',
    create_time  datetime comment '创建时间',
    update_by    varchar(64)  default '' comment '更新者',
    update_time  datetime comment '更新时间',
    remark       varchar(500) default null comment '备注',
    primary key (config_id)
) engine = innodb
  auto_increment = 100 comment = '参数配置表';

insert into sys_config
values (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', sysdate(), '', null,
        '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow'),
 (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', sysdate(), '', null, '初始化密码 123456'),
 (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', sysdate(), '', null,
        '深色主题theme-dark，浅色主题theme-light');


-- ----------------------------
-- 14、系统访问记录
-- ----------------------------
drop table if exists sys_logininfor;
create table sys_logininfor
(
    info_id        bigint(20) not null auto_increment comment '访问ID',
    user_name      varchar(50)  default '' comment '用户账号',
    ipaddr         varchar(50)  default '' comment '登录IP地址',
    login_location varchar(255) default '' comment '登录地点',
    browser        varchar(50)  default '' comment '浏览器类型',
    os             varchar(50)  default '' comment '操作系统',
    status         char(1)      default '0' comment '登录状态（0成功 1失败）',
    msg            varchar(255) default '' comment '提示消息',
    login_time     datetime comment '访问时间',
    primary key (info_id)
) engine = innodb
  auto_increment = 100 comment = '系统访问记录';


-- ----------------------------
-- 15、定时任务调度表
-- ----------------------------
drop table if exists sys_job;
create table sys_job
(
    job_id          bigint(20)   not null auto_increment comment '任务ID',
    job_name        varchar(64)  default '' comment '任务名称',
    job_group       varchar(64)  default 'DEFAULT' comment '任务组名',
    invoke_target   varchar(500) not null comment '调用目标字符串',
    cron_expression varchar(255) default '' comment 'cron执行表达式',
    misfire_policy  varchar(20)  default '3' comment '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
    concurrent      char(1)      default '1' comment '是否并发执行（0允许 1禁止）',
    status          char(1)      default '0' comment '状态（0正常 1暂停）',
    create_by       varchar(64)  default '' comment '创建者',
    create_time     datetime comment '创建时间',
    update_by       varchar(64)  default '' comment '更新者',
    update_time     datetime comment '更新时间',
    remark          varchar(500) default '' comment '备注信息',
    primary key (job_id, job_name, job_group)
) engine = innodb
  auto_increment = 100 comment = '定时任务调度表';

insert into sys_job
values (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', sysdate(), '', null,
        ''),
 (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', sysdate(), '',
        null, ''),
 (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3',
        '1', '1', 'admin', sysdate(), '', null, '');


-- ----------------------------
-- 16、定时任务调度日志表
-- ----------------------------
drop table if exists sys_job_log;
create table sys_job_log
(
    job_log_id     bigint(20)   not null auto_increment comment '任务日志ID',
    job_name       varchar(64)  not null comment '任务名称',
    job_group      varchar(64)  not null comment '任务组名',
    invoke_target  varchar(500) not null comment '调用目标字符串',
    job_message    varchar(500) comment '日志信息',
    status         char(1)       default '0' comment '执行状态（0正常 1失败）',
    exception_info varchar(2000) default '' comment '异常信息',
    create_time    datetime comment '创建时间',
    primary key (job_log_id)
) engine = innodb comment = '定时任务调度日志表';


-- ----------------------------
-- 17、通知公告表
-- ----------------------------
drop table if exists sys_notice;
create table sys_notice
(
    notice_id      int(4)      not null auto_increment comment '公告ID',
    notice_title   varchar(50) not null comment '公告标题',
    notice_type    char(1)     not null comment '公告类型（1通知 2公告）',
    notice_content longblob     default null comment '公告内容',
    status         char(1)      default '0' comment '公告状态（0正常 1关闭）',
    create_by      varchar(64)  default '' comment '创建者',
    create_time    datetime comment '创建时间',
    update_by      varchar(64)  default '' comment '更新者',
    update_time    datetime comment '更新时间',
    remark         varchar(255) default null comment '备注',
    primary key (notice_id)
) engine = innodb
  auto_increment = 10 comment = '通知公告表';

-- ----------------------------
-- 初始化-公告信息表数据
-- ----------------------------
insert into sys_notice
values ('1', '温馨提醒：2018-07-01 若依新版本发布啦', '2', '新版本内容', '0', 'admin', sysdate(), '', null, '管理员'),
 ('2', '维护通知：2018-07-01 若依系统凌晨维护', '1', '维护内容', '0', 'admin', sysdate(), '', null, '管理员');


-- ----------------------------
-- 18、代码生成业务表
-- ----------------------------
drop table if exists gen_table;
create table gen_table
(
    table_id          bigint(20) not null auto_increment comment '编号',
    table_name        varchar(200) default '' comment '表名称',
    table_comment     varchar(500) default '' comment '表描述',
    sub_table_name    varchar(64)  default null comment '关联子表的表名',
    sub_table_fk_name varchar(64)  default null comment '子表关联的外键名',
    class_name        varchar(100) default '' comment '实体类名称',
    tpl_category      varchar(200) default 'crud' comment '使用的模板（crud单表操作 tree树表操作）',
    package_name      varchar(100) comment '生成包路径',
    module_name       varchar(30) comment '生成模块名',
    business_name     varchar(30) comment '生成业务名',
    function_name     varchar(50) comment '生成功能名',
    function_author   varchar(50) comment '生成功能作者',
    gen_type          char(1)      default '0' comment '生成代码方式（0zip压缩包 1自定义路径）',
    gen_path          varchar(200) default '/' comment '生成路径（不填默认项目路径）',
    options           varchar(1000) comment '其它生成选项',
    create_by         varchar(64)  default '' comment '创建者',
    create_time       datetime comment '创建时间',
    update_by         varchar(64)  default '' comment '更新者',
    update_time       datetime comment '更新时间',
    remark            varchar(500) default null comment '备注',
    primary key (table_id)
) engine = innodb
  auto_increment = 1 comment = '代码生成业务表';


-- ----------------------------
-- 19、代码生成业务表字段
-- ----------------------------
drop table if exists gen_table_column;
create table gen_table_column
(
    column_id      bigint(20) not null auto_increment comment '编号',
    table_id       varchar(64) comment '归属表编号',
    column_name    varchar(200) comment '列名称',
    column_comment varchar(500) comment '列描述',
    column_type    varchar(100) comment '列类型',
    java_type      varchar(500) comment 'JAVA类型',
    java_field     varchar(200) comment 'JAVA字段名',
    is_pk          char(1) comment '是否主键（1是）',
    is_increment   char(1) comment '是否自增（1是）',
    is_required    char(1) comment '是否必填（1是）',
    is_insert      char(1) comment '是否为插入字段（1是）',
    is_edit        char(1) comment '是否编辑字段（1是）',
    is_list        char(1) comment '是否列表字段（1是）',
    is_query       char(1) comment '是否查询字段（1是）',
    query_type     varchar(200) default 'EQ' comment '查询方式（等于、不等于、大于、小于、范围）',
    html_type      varchar(200) comment '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
    dict_type      varchar(200) default '' comment '字典类型',
    sort           int comment '排序',
    create_by      varchar(64)  default '' comment '创建者',
    create_time    datetime comment '创建时间',
    update_by      varchar(64)  default '' comment '更新者',
    update_time    datetime comment '更新时间',
    primary key (column_id)
) engine = innodb
  auto_increment = 1 comment = '代码生成业务表字段';
