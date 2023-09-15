CREATE DATABASE  IF NOT EXISTS `JiaoTong_management` ;
USE `JiaoTong_management`;

#############################日常管理#######################

#####通告管理#####

#分组设置(对单位内部的合同工进行分组设置，包含新增，修改、删除、人员维护、人员查看等操作)
create table group_settings(
    id int auto_increment primary key ,
    group_name varchar(20) comment '分组名称',
    personnel_Name varchar(50) comment '人员名称'
);
DROP TABLE group_settings;

#通告管理(此模块可发送及查看已成功发送的通告信息，并查看通告信息的阅读情况)
create table notification_management(
    id int auto_increment primary key ,
    recipient varchar(50) comment '接收人',
    title varchar(50) comment '公告名称',
    type varchar(10) comment '类型',
    time varchar(10) comment '发送时间',
    content varchar(100) comment '公告内容',
    annex varchar(100) comment '附件',
    sending_method varchar(10) comment '发送方式'
);
DROP TABLE notification_management;

######会议管理#######
DROP TABLE
#会议管理(对单位内部的办公室人员进行办公室信息维护，包含申请、修改、启停、查看、删除等操作)
create table meeting_management(
    id int auto_increment primary key ,
    meeting_room_name varchar(10) comment '会议室名称',
    meeting_number varchar(10) comment '会议编号',
    special_instructions varchar(50) comment '会议室内的特殊设施说明',
    Meeting_room_Location varchar(50) comment '会议室位置',
    accommodate varchar(3) comment '容纳总数',
    notes varchar(50) comment '备注'
);
DROP TABLE meeting_management;

#会议预约(可提交会议室预约申请信息)
create table meeting_appointment(
    id int auto_increment primary key ,
    Application_department varchar(50) comment '申请部门',
    meeting_title varchar(20) comment '会议题目',
    meeting_room_name varchar(10) comment '会议室名称',
    start_time varchar(30) comment '计划开始时间',
    end_time varchar(30) comment '计划结束时间',
    person_number varchar(10) comment '参会人数',
    main varchar(50) comment '开会主要内容',
    monogram varchar(10) comment '是否需要会标',
    monogram_content varchar(30) comment '会标内容',
    meeting_type varchar(20) comment '会议类型',
    applicant_person varchar(20) comment '申请人',
    projection_screen varchar(20) comment '是否投屏',
    notes varchar(50) comment '备注',
    meeting_material varchar(100) comment '上传会议材料',
    meeting_agenda varchar(100) comment '上传会议议程'
);
DROP TABLE meeting_appointment;

#预约管理(对提交的会议预约申请进行管理)
create table booking_Management(
    id int auto_increment primary key ,
    number varchar(30) comment '编号',
    meeting_room_name varchar(30) comment '会议室名称',
    meeting_reservation_time varchar(40) comment '会议预约时间',
    reservation_type varchar(20) comment '预约状态'
);
DROP TABLE booking_Management;

#会议签到(生成二维码进行签到操作及进行签到信息的查看及导出操作)
create table meeting_attendance(
    id int auto_increment primary key ,
    number varchar(30) comment '编号',
    name varchar(20) comment '姓名',
    attendance_type varchar(20) comment '签到状态',
    attendance_time varchar(20) comment '签到时间'
);
DROP TABLE meeting_attendance;

#会议纪要(对会议纪要信息进行维护操作)
create table meeting_minutes(
    id int auto_increment primary key ,
    number varchar(30) comment '会议编号',
    meeting_name varchar(30) comment '会议题目',
    host varchar(20) comment '主持人',
    meeting_content varchar(30) comment '会议主要内容',
    meeting_time varchar(30) comment '开会时间',
    record_time varchar(30) comment '记录时间',
    meeting_recorder varchar(100) comment '会议录音',
    document_status varchar(30) comment '单据状态'
);
DROP TABLE meeting_minutes;

#会议招待(由办公室人员进行会议招待申请、查看、修改、撤销操作，申请成功后可在会议招待列表中查看到申请的数据)
create table conference_reception(
    id int auto_increment primary key ,
    reception_manager varchar(20) comment '活动接待负责人',
    application_department varchar(30) comment '申请部门',
    reception_location varchar(30) comment '接待地点',
    reception_time varchar(30) comment '接待日期',
    visiting_content varchar(50) comment '来访内容',
    reception_target varchar(100) comment '接待对象',
    reception_target_number varchar(3) comment '接待对象人数',
    entourage varchar(30) comment '陪同人员',
    entourage_number varchar(30) comment '陪同人员人数',
    logistic_service varchar(50) comment '后勤保障'
);
DROP TABLE conference_reception;

#######维修#######

#维修申请(为单位内部员工提交保修申请操作)
create table repair_request(
    id int auto_increment primary key ,
    repair_department varchar(50) comment '报修部门',
    house_number varchar(20) comment '门牌号',
    repair_applicant varchar(30) comment '报修人',
    repair_content varchar(50) comment '报修内容',
    repair_time varchar(40) comment '报修时间',
    other_problems varchar(50) comment '其它问题'
);
DROP TABLE repair_request;

#维修管理(由网管维修人员对已接单的维修申请进行管理，可进行维修、退单、查看操作)
create table repair_manage(
    id int auto_increment primary key ,
    repair_time varchar(50) comment '维修时间',
    repair_person varchar(30) comment '维修人',
    repair_result varchar(40) comment '维修结果',
    illustrate varchar(50) comment '说明'
);
DROP TABLE repair_manage;

#单据跟踪(此模块由网管人员可查看单位内部人员提交的维修信息，可进行查看及接单操作)
create table document_tracking(
    id int auto_increment primary key ,

    number varchar(30) comment '编号',
    name varchar(30) comment '姓名',
    repair_what varchar(50) comment '维修物件',
    document_status varchar(50) comment '单据状态'
);
DROP TABLE document_tracking;

######伙食管理#####

#充值信息汇总
create table food_Recharge_information(
    id int auto_increment primary key ,
    number varchar(50) comment '编号',
    name varchar(30) comment '账户名称',
    type varchar(20) comment '账户类型',
    money varchar(30) comment '充值金额',
    time varchar(30) comment '充值时间'
);
DROP TABLE food_Recharge_information;

#菜品配置
create table food_information(
    id int auto_increment primary key ,
    food_type varchar(30) comment '类型(早餐、午餐、晚餐)',
    number varchar(30) comment '数量',
    name varchar(30) comment '食品名称',
    price varchar(30) comment '价格'
);
DROP TABLE food_information;

######办公用品申领#######
#办公用品
create table office_supplies(
    id int auto_increment primary key ,
    number varchar(30) comment '单号',
    object varchar(30) comment '办公用品名称',
    department varchar(30) comment '申请部门',
    time varchar(30) comment '申请时间',
    type varchar(30) comment '申请类型',
    state varchar(30) comment '审批状态'
    );
DROP TABLE office_supplies;