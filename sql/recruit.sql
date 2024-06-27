set foreign_key_checks = 0;
drop table IF EXISTS recruit_company_info;
CREATE TABLE recruit_company_info
(
    id          bigint(20)   not null auto_increment,
    name        varchar(255) not null comment '公司名称',
    address     varchar(255) not null comment '公司地址',
    phonenumber varchar(255) not null comment '联系电话',
    logo        text         null comment '公司LOGO',
    license     text         null comment '营业执照',
    nature      tinyint(1)   not null default 0 comment '企业性质',
    description varchar(255) null comment '企业描述',
    audit_state tinyint(1)   not null default 0 comment '审核状态',
    hot         tinyint(1)   not null default 0 comment '是否热门',
    user_id     bigint(20)   not null default 1 comment '所属用户',
    primary key (id)
) comment '企业信息表';

insert into recruit.recruit_company_info (id, name, address, phonenumber, logo, license, nature, description,
                                          audit_state, hot, user_id)
values (1, '阿里巴巴', '北京', '13184523478', 'http://localhost:8080/profile/upload/logo/al.jpg',
        'http://localhost:8080/profile/upload/logo/yyzz.png', 0,
        '阿里巴巴网络技术有限公司（简称：阿里巴巴集团）是以曾担任英语教师的马云为首的18人于1999年在浙江杭州创立', 2, 0, 1),
       (2, '滴滴出行', '北京', '13184523478', 'http://localhost:8080/profile/upload/logo/dd.jpg',
        'http://localhost:8080/profile/upload/logo/yyzz.png', 0,
        '滴滴出行是涵盖出租车、专车、 快车、顺风车、代驾及 大巴等多项业务在内的一站式出行平台，2015年9月9日由“滴滴打车”更名而来', 2, 0, 2),
       (3, '搜狐媒体', '北京', '13184523478', 'http://localhost:8080/profile/upload/logo/souhu.jpg',
        'http://localhost:8080/profile/upload/logo/yyzz.png', 0,
        '搜狐公司是中国领先的互联网品牌，是中国最主要的新闻提供商，搜狐的网络资产给众多用户在信息、娱乐以及交流方面提供了广泛的选择', 2, 0, 3),
       (4, '京东', '北京', '13184523478', 'http://localhost:8080/profile/upload/logo/jd.jpg',
        'http://localhost:8080/profile/upload/logo/yyzz.png', 0,
        '京东致力于成为一家为社会创造最大价值的公司。经过13年砥砺前行，京东在商业领域一次又一次突破创新，取得了跨越式发展', 2, 0, 4),
       (5, '网易', '北京', '13184523478', 'http://localhost:8080/profile/upload/logo/wangyi.jpg',
        'http://localhost:8080/profile/upload/logo/yyzz.png', 0,
        '网易公司（NASDAQ: NTES）是中国的互联网公司，利用互联网技术，加强人与人之间信息的交流和共享，实现“网聚人的力量”', 2, 0, 5),
       (6, '爱奇艺', '北京', '13184523478', 'http://localhost:8080/profile/upload/logo/aqy.jpg',
        'http://localhost:8080/profile/upload/logo/yyzz.png', 0,
        '自成立伊始，爱奇艺坚持“悦享品质”的公司理念，以“用户体验”为生命，专注为用户提供清晰、流畅、界面友好的观映体验', 2, 0, 6);

set foreign_key_checks = 0;
DROP TABLE IF EXISTS recruit_category;
CREATE TABLE recruit_category
(
    id            bigint(20)  NOT NULL AUTO_INCREMENT comment 'ID',
    category_name varchar(50) NOT NULL comment '分类名称',
    description   text       default null comment '描述',
    parent_id     bigint(20) default null comment '父ID',
    PRIMARY KEY (id)
) comment '岗位分类表';
# insert into recruit_category (category_name, description, parent_id)
# values  ('前端技术', '前端技术技术大分类', null),
#         ('后端技术', '后端技术技术大分类', null),
#         ('人工智能', '人工智能技术大分类', null),
#         ('大数据', '大数据技术大分类', null),
#         ('网络安全', '网络安全技术大分类', null),
#         ('人事/财务/行政', '人事/财务/行政技术大分类', null),
#         ('教育培训', '教育培训技术大分类', null),
#         ('Java', 'Java开发', 2),
#         ('C++', 'C++开发', 2),
#         ('PHP', 'PHP开发', 1),
#         ('.NET', '.NET开发', 2),
#         ('Python', 'Python开发', 3),
#         ('数据挖掘', '数据挖掘', 4),
#         ('网络安全', '网络安全', 5),
#         ('机器学习', '机器学习', 3),
#         ('大数据开发', '大数据开发', 4),
#         ('区块链', '区块链', 4);
insert into recruit_category (id, category_name, description, parent_id)
values (1, '前端技术', '前端技术技术大分类', null),
       (2, '后端技术', '后端技术技术大分类', null),
       (3, '人工智能', '人工智能技术大分类', null),
       (4, '大数据', '大数据技术大分类', null),
       (5, '网络安全', '网络安全技术大分类', null),
       (6, '人事/财务/行政', '人事/财务/行政技术大分类', null),
       (7, '教育培训', '教育培训技术大分类', null),
       (8, 'Java', 'Java开发', 2),
       (9, 'C++', 'C++开发', 2),
       (10, 'PHP', 'PHP开发', 1),
       (11, '.NET', '.NET开发', 2),
       (12, 'Python', 'Python开发', 3),
       (13, '数据挖掘', '数据挖掘', 4),
       (14, '网络安全', '网络安全', 5),
       (15, '机器学习', '机器学习', 3),
       (16, '大数据开发', '大数据开发', 4),
       (17, '区块链', '区块链', 4);
set foreign_key_checks = 1;


set foreign_key_checks = 0;
drop table IF EXISTS recruit_position;
CREATE TABLE recruit_position
(
    id           bigint(20)   not null auto_increment,
    name         varchar(255) comment '职务名称',
    requirement  text         not null comment '要求',
    work_city    varchar(50)  not null comment '工作城市',
    phonenumber  varchar(255) not null comment '联系电话',
    release_date datetime     not null default now() comment '发布时间',
    valid_date   datetime     not null default now() comment '截止日期',
    quantity     int(5)       not null default 1 comment '招聘人数',
    status       tinyint(1)   not null default 0 comment '状态（0是未结束1是结束）',
    audit_state  tinyint(1)   not null default 0 comment '审核状态',
    salary_up    int(8)       not null comment '最高薪资',
    salary_down  int(8)       not null comment '最低薪资',
    hot          boolean      not null default false comment '是否热门',
    company_id   bigint(20)   not null comment '公司ID',
    category_id  bigint(20)   default 17 comment '分类ID',
    primary key (id),
    foreign key (company_id) references recruit_company_info (id),
    foreign key (category_id) references recruit_category (id)
) comment '招聘岗位表';
set foreign_key_checks = 1;

drop table IF EXISTS recruit_student;
CREATE TABLE recruit_student
(
    id              bigint(20) not null auto_increment,
    dept            varchar(255) comment '所在院系',
    stu_class       varchar(255) comment '所在班级',
    code            varchar(255) comment '学号',
    name            varchar(255) comment '姓名',
    sex             char(1) comment '性别',
    height          double(5, 2) comment '身高',
    weight          double(5, 2) comment '体重',
    age             int(3) comment '年龄',
    identity_card   varchar(255) comment '身份证号',
    address         varchar(255) comment '家庭住址',
    tel             varchar(255) comment '联系电话',
    email           varchar(255) comment '邮箱',
    major           varchar(255) comment '所学专业',
    job_intent      varchar(255) comment '求职意向',
    skill           varchar(255) comment '掌握技能',
    award           varchar(255) comment '所获奖项',
    self_evaluation varchar(255) comment '自我评价',
    primary key (id)
) comment '学生个人信息表';

drop table IF EXISTS recruit_classroom;
CREATE TABLE recruit_classroom
(
    id        bigint(20) not null auto_increment comment 'ID',
    classroom varchar(255) comment '教室名',
    place     varchar(255) comment '地点',
    capacity  int(5) comment '容纳人数',
    occupied  tinyint(1) default 0 comment '是否占用(0:没有占用，1:占用)',
    primary key (id)
) comment '教室表';
insert into recruit_classroom (classroom, place, capacity)
values ('博学楼101', '北校区博学楼1号楼', 241),
       ('博学楼102', '北校区博学楼1号楼', 241),
       ('博学楼103', '北校区博学楼1号楼', 241),
       ('博学楼104', '北校区博学楼1号楼', 241),
       ('博学楼105', '北校区博学楼1号楼', 241),
       ('博学楼201', '北校区博学楼1号楼', 241),
       ('博学楼202', '北校区博学楼1号楼', 241),
       ('博学楼203', '北校区博学楼1号楼', 241),
       ('博学楼204', '北校区博学楼1号楼', 241),
       ('博学楼205', '北校区博学楼1号楼', 241),
       ('博学楼301', '北校区博学楼1号楼', 241),
       ('博学楼302', '北校区博学楼1号楼', 241),
       ('博学楼303', '北校区博学楼1号楼', 241),
       ('博学楼304', '北校区博学楼1号楼', 241),
       ('博学楼305', '北校区博学楼1号楼', 241),
       ('博学楼401', '北校区博学楼1号楼', 241),
       ('博学楼402', '北校区博学楼1号楼', 241),
       ('博学楼403', '北校区博学楼1号楼', 241),
       ('博学楼404', '北校区博学楼1号楼', 241),
       ('博学楼405', '北校区博学楼1号楼', 241),
       ('博学楼501', '北校区博学楼1号楼', 241),
       ('博学楼502', '北校区博学楼1号楼', 241),
       ('博学楼503', '北校区博学楼1号楼', 241),
       ('博学楼503', '北校区博学楼1号楼', 241),
       ('博学楼504', '北校区博学楼1号楼', 241),
       ('博学楼505', '北校区博学楼1号楼', 241);

drop table IF EXISTS recruit_delivery;
CREATE TABLE recruit_delivery
(
    id            bigint(20)  not null auto_increment,
    user_id       bigint(20) comment '用户ID',
    user_name     varchar(30) not null comment '用户账号',
    position_id   bigint(20) comment '岗位信息ID',
    position_name varchar(255) comment '岗位名称',
    company_id    bigint(20) comment '公司ID',
    company_name  varchar(255) comment '公司名称',
    status        tinyint(1) default 0 comment '0：未处理，1：通过，2：拒绝',
    primary key (id)
) comment '简历投递信息表';

drop table IF EXISTS recruit_lecture;
CREATE TABLE recruit_lecture
(
    id              bigint(20)   not null auto_increment,
    company_name    varchar(255) comment '公司名称',
    company_address varchar(255) comment '公司地址',
    description     varchar(255) null comment '企业描述',
    phone           varchar(11) default null comment '联系电话',
    direct          varchar(11) comment '方向',
    start_time      datetime    default now() comment '开讲座时间',
    classroom       varchar(255) comment '宣讲座地点（教室名）',
    audit_state     tinyint(1)  default 0 comment '审核状态',
    type            tinyint(1) comment '申请类型',
    primary key (id)
) comment '讲座申请表';

drop table IF EXISTS recruit_resume;
CREATE TABLE recruit_resume
(
    id                   bigint(20)  not null auto_increment comment 'ID',
    user_id              bigint(20) comment '用户ID',
    user_name            varchar(30) not null comment '用户账号',
    sex                  char(1) comment '性别',
    minority             varchar(255) comment '民族',
    height               varchar(255) comment '身高',
    weight               varchar(255) comment '体重',
    political_outlook    varchar(255) comment '政治面貌',
    highest_education    varchar(255) comment '最高学历',
    health               varchar(255) comment '健康状况',
    job_intention        varchar(255) comment '求职意向',
    birthday             varchar(255) comment '出生年月',
    photo                varchar(255) comment '照片',
    major                varchar(255) comment '所学专业',
    current_residence    varchar(255) comment '现居住地',
    postal_address       varchar(255) comment '通讯地址',
    phone                varchar(11) default null comment '联系电话',
    email                varchar(255) comment '邮箱',
    awards               varchar(255) comment '所获奖项',
    professional_courses varchar(255) comment '专业课程',
    self_evaluation      varchar(255) comment '自我评价',
    url                  varchar(255) comment '简历附件',

    primary key (id)
) comment '学生简历信息表';

drop table if exists recruit_message;
CREATE TABLE recruit_message
(
    id           bigint(20) not null auto_increment comment 'ID',
    send_id      bigint(20) comment '发送方ID',
    send_name    varchar(255) comment '发送方用户名',
    receive_id   bigint(20) comment '接收方ID',
    receive_name varchar(255) comment '接收方用户名',
    avatar       varchar(100)        default '' comment '接收方头像',
    content      varchar(255) comment '消息内容',
    is_read      tinyint(1) not null default 0 comment '是否已读',
    create_time  datetime            default now() comment '发布时间',
    primary key (id)
) comment '消息表';

insert into sys_dict_type (dict_name, dict_type, create_time)
values ('企业性质', 'company_nature', sysdate());
insert into sys_dict_data (dict_label, dict_value, dict_type, create_time)
values ('私企', '0', 'company_nature', sysdate()),
       ('国企', '1', 'company_nature', sysdate());

insert into sys_dict_type (dict_name, dict_type, create_time)
values ('教室是否占用', 'recruit_classroom_occupied', sysdate());
insert into sys_dict_data (dict_label, dict_value, dict_type, create_time)
values ('没有占用', '0', 'recruit_classroom_occupied', sysdate()),
       ('占用', '1', 'recruit_classroom_occupied', sysdate());

insert into sys_dict_type (dict_name, dict_type, create_time)
values ('企业审核信息', 'company_status', sysdate());
insert into sys_dict_data (dict_label, dict_value, dict_type, create_time)
values ('未上传', '0', 'company_status', sysdate()),
       ('审核中', '1', 'company_status', sysdate()),
       ('通过', '2', 'company_status', sysdate()),
       ('驳回', '3', 'company_status', sysdate());

insert into sys_dict_type (dict_name, dict_type)
values ('审核状态', 'recruit_audit_status');
insert into sys_dict_data (dict_label, dict_value, dict_type)
values ('审核中', '0', 'recruit_audit_status'),
       ('通过', '1', 'recruit_audit_status'),
       ('拒绝', '2', 'recruit_audit_status');

