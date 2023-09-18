CREATE DATABASE  IF NOT EXISTS `JiaoTong_management` ;
USE `JiaoTong_management`;
# 用户
create table user(
  id int  auto_increment primary key ,
  username varchar(5),
  password varchar(20)
);
# 电话簿
drop table phone_directory;
create table phone_directory(
    id int  auto_increment primary key ,
    name varchar(5) comment '姓名',
    department_name varchar(15) comment '部门名称',
    job varchar(15) comment '职务',
    house_number varchar(5) comment '门牌号',
    phone_number varchar(13) comment '手机号',
    telephone varchar(13) comment '座机',
    office varchar(5) comment '办公室',
    email varchar(30) comment '邮箱'
);

select * from phone_directory;

# 我的审批
create table approval(
    id int auto_increment primary key ,
    name varchar(10) comment '审批单名称',
    opinion varchar(50) comment '意见',
    status varchar(15) comment '审批状态'
);
# 外聘须知
create table ououtsourcing(
    id int auto_increment primary key ,
    content varchar(100) comment '发布的内容'
);
drop table wait_approval;
# 待审批
create table wait_approval(
    id int auto_increment primary key ,
    key_card varchar(10) comment '门卡',
    other_equipment varchar(50) comment '其他设备',
    `comment` varchar(50) comment '备注',
    is_borrow_material varchar(10) comment '是否有向档案室借阅资料',
    is_all_return varchar(10) comment '是否已全部归还',
    is_borrow_money varchar(10) comment '是否有借款',
    is_return_money varchar(10) comment '是否还清',
    other_explain varchar(10) comment '其他说明',
    is_sign_resign varchar(10) comment '是否签订离岗保密承诺书',
    is_connect_all varchar(10) comment '是否已交接清楚全部资料',
    work_other_explain varchar(50) comment '工作其他说明',
    resign_date varchar(10) comment '离岗日期'

);

# 会议招待费待审批单
create table serve(
    id int auto_increment primary key ,
    serve_type varchar(10) comment  '招待类型',
    type_standard varchar(4) comment '类型标准'

);
# 慰问金待审批单
create table solatium(
    id int auto_increment primary key ,
    opinion varchar(20) comment '意见',
    idiograph varchar(4) comment '个人签名'
);
# 基础信息
create table basic_information(
    id int auto_increment primary key ,
    name varchar(5) comment '姓名',
    key_id varchar(18) comment '身份证号',
    gender varchar(2) comment '性别',
    birthday varchar(11) comment '出生年月',
    class varchar(10) comment '等级',
    classify varchar(10) comment '人员分类',
    staffing varchar(10) comment '正式编制',
    department_name varchar(10) comment '部门名称',
    education varchar(10) comment '文化程度',
    job varchar(20) comment '主职务',
    birthplace varchar(10) comment '籍贯',
    nationality varchar(15) comment '民族',
    join_party_date varchar(12) comment '入党日期',
    entry_date varchar(12) comment '入职日期',
    politics_status varchar(10) comment '政治面貌',
    marriage varchar(2) comment '婚姻'

);
drop table family_members;
# 家庭主要成员
create table family_members(
    id int auto_increment primary key ,
    name varchar(5) comment '亲属姓名',
    relation varchar(4) comment '与本人关系',
    is_life_child varchar(2) comment '是否与子女共同生活',
    marriage_status varchar(2) comment '婚姻状况',
    marriage_change varchar(2) comment '婚姻变化情况',
    `work` varchar(15) comment '工作（学习）单位',
    now_job varchar(50) comment '现任职务',
    company_type varchar(20) comment '单位性质',
    is_advanced_job varchar(2) comment '是否担任高级职务',
    is_local_foreign varchar(2) comment '是否在国（境）外',
    card_name varchar(50) comment '证件名称',
    card_id varchar(50) comment '证件号'
);
# 出国
create table foreign_nation(
    id int auto_increment primary key ,
    `name` varchar(5) comment '亲属姓名',
    relation varchar(5) comment '与本人关系',
    key_id varchar(18) comment '身份证号',
    nation varchar(50) comment '所在国家（地区）',
    work_city varchar(50) comment '工作生活城市',
    `work` varchar(50) comment '工作（学习）',
    job varchar(15) comment '职务',
    start_date varchar(11) comment '起始日期',
    end_date varchar(11) comment '返回日期',
    `comment` varchar(50) comment '备注'
);
# 亲属从事相关职业
create table  family_job(
    id int auto_increment primary key ,
    name varchar(6) comment '报告事项（亲属姓名）',
    relation varchar(5) comment '与本人关系',
    key_card varchar(18) comment '身份证号',
    job varchar(20) comment '职务',
    company_name varchar(20) comment '单位名称',
    is_partner varchar(16) comment '是否为单位合伙人或设立人',
    is_local_practice varchar(2) comment '是否在本单位辖区内执业',
    prefecture varchar(20) comment '辖区',
    scope_practice varchar(100) comment '执业范围',
    is_apply_challenge varchar(2) comment '是否提出回避申请',
    challenge_status varchar(30) comment '回避申请的具体情形',
    `comment` varchar(50) comment '备注'
 );

# 移居
create table migrate(
    id int auto_increment primary key ,
    name varchar(5) comment '亲属姓名',
    relation varchar(5) comment '与本人关系',
    migrate_nation varchar(50) comment '移居国家（地区）',
    live_city varchar(50) comment '现住城市',
    migrate_card varchar(50) comment '移居证件号码',
    migrate_type varchar(10) comment '移居类别',
    migrate_date varchar(11) comment '移居日期',
    `comment` varchar(50) comment '备注'
 );

# 刑事责任
create table criminal_responsibility(
    id int auto_increment primary key ,
    name varchar(5) comment '姓名',
    relation varchar(5) comment '与本人关系',
    key_card varchar(18) comment '身份证号',
    inquiry_date varchar(11) comment '被追究日期',
    inquiry_reason varchar(50) comment '被追究原因',
    processing_phase varchar(50) comment '处理阶段',
    processing_result varchar(50) comment '处理结果',
    `comment` varchar(50) comment '备注'
);

# 证件信息
create table ID_information(
    id int auto_increment primary key ,
    creat_date varchar(20) comment '创建日期',
    `comment` varchar(50) comment '备注',
    certificate_validity_date varchar(20) comment '证件有效日期',
    certificate_type varchar(10) comment '证件类型',
    photo varchar(100) comment '照片',
    certificate_number varchar(15) comment '证件编号',
    number_round varchar(10) comment '往返次数',
    certificate_date varchar(15) comment '证件时效',
    custodian_organization varchar(15) comment '保管机构'
);
#门卡
create table door_card(
    id int primary key auto_increment,
    card_number varchar(50) comment '门卡卡号'
);

# 临时代管人设置
create table temporary_custodian(
    id int auto_increment primary key ,
    loggedder varchar(20) comment '登录者',
    agent varchar(5) comment '代理者人',
    start_date varchar(20) comment '代理开始时间',
    end_date varchar(20) comment '代理结束时间',
    agent_document varchar(20) comment '代理者单据'
);
drop table contractor;
# 合同工
create table contractor(
    id int auto_increment primary key ,
    name varchar(5) comment '姓名',
    gender varchar(2) comment '性别',
    birthday varchar(11) comment '出生年月',
    class varchar(10) comment '等级',
    classify varchar(10) comment '人员分类',
    degree_education varchar(10) comment '文化程度',
    major_job varchar(20) comment '主职务',
    honor varchar(20) comment '头衔',
    birthplace varchar(10) comment '籍贯',
    nationality varchar(15) comment '民族',
    join_party_date varchar(12) comment '入党日期',
    politics_status varchar(10) comment '政治面貌',
    education_background varchar(5) comment '全日制学历',
    degree varchar(10) comment '全日制学位',
    school_specialty varchar(30) comment '全日制毕业院校专业',
    now_education_background varchar(15) comment '在职教育学历',
    now_degree varchar(10) comment '在职教育学位',
    now_school_specialty varchar(30) comment '在职教育毕业院校专业',
    key_card varchar(18) comment '身份证号',
    phone_number varchar(13) comment '手机号',
    spouse_company varchar(30) comment '配偶单位',
    spouse_job varchar(20) comment '配偶职务',
    parent_word varchar(30) comment '父母单位',
    parent_job varchar(20) comment '父母职务',
    child_company varchar(30) comment '子女工作单位',
    child_job varchar(20) comment '子女职务',
    staffing varchar(10) comment '正式编制',
    parent_name varchar(5) comment '父母姓名',
    child_name varchar(5) comment '子女姓名',
    this_public_holiday varchar(10) comment '当年公休',
    surplus_public_holiday varchar(10) comment '剩余公休'
);

# 外聘人员
create table external_personnel(
    id int auto_increment primary key ,
    name varchar(10) comment '姓名',
    school varchar(30) comment '学校',
    specialty varchar(10) comment '专业',
    study_year varchar(10) comment '学年',
    start_date varchar(12) comment '外聘开始日期',
    end_date varchar(12) comment '外聘结束日期',
    source varchar(10) comment '来源',
    introducer varchar(10) comment '介绍人姓名',
    department varchar(15) comment '部门',
    key_card varchar(18) comment '身份证号',
    upload_letter varchar(100) comment '上传介绍信',
    personnel_status varchar(5) comment '外聘状态',
    address varchar(30) comment '家庭地址',
    degree_education varchar(10) comment '文化程度',
    gift_date varchar(12) comment '出礼品期',
    birthplace varchar(10) comment '籍贯',
    school_linkman varchar(30) comment '学校联系人',
    linkman_phone varchar(13) comment '学校联系人电话',
    linkman_job varchar(30) comment '学校联系人职务',
    profile_photo varchar(100) comment '头像',
    health_code varchar(100) comment '健康码',
    email varchar(30) comment '邮箱'
);
# 外聘人员合同
create table external_personnel_contract(
    id int auto_increment primary key ,
    contract_id varchar(13) comment '合同编号',
    key_card varchar(18) comment '身份证号',
    phone varchar(13) comment '联系电话',
    postcode varchar(8) comment '邮编',
    new_or_renewed varchar(5) comment '新\续签',
    resident_address varchar(20) comment '常驻居住地址',
    domicile_place varchar(10) comment '户籍所在地',
    postal_address varchar(20) comment '通讯地址',
    station varchar(20) comment '岗位',
    contract_type varchar(10) comment '合同类型',
    start_date varchar(10) comment '合同开始日期',
    end_date varchar(10) comment '合同结束日期',
    probation_period varchar(20) comment '试用期限'

);
# 合同备份
create table contract_backup(
    id int primary key auto_increment,
    upload_files varchar(100) comment '上传文件'

);

# 节假日配置
create table holiday_configuration(
    id int primary key auto_increment,
    holiday_name varchar(15) comment '节假日名称',
    date varchar(15) comment '日期',
    word_status varchar(5) comment '工作状态',
    is_holiday varchar(2) comment '是否节假日'
);

# 门卡配置
create table door_card_configuration(
    id int auto_increment primary key ,
    door_card varchar(20) comment '门禁卡号',
    is_door_connect varchar(5) comment '门禁是否连接',
    attendance_card varchar(20) comment '出勤机卡号',
    is_attendance_connect varchar(5) comment '出勤机是否连接',
    special_card varchar(20) comment '特殊通道卡号',
    is_staff_passage varchar(5) comment '员工通道是否连接',
    first_card_date varchar(20) comment '首次绑卡时间'
);

# 证件借还
create table papers_borrow_return(
    id int primary key auto_increment,
    collection_date varchar(20) comment '领取日期',
    collection_name varchar(5) comment '领取人',
    `comment` varchar(50) comment '备注',
    return_date varchar(20) comment '预计交回日期'
);
# 汇总时间设置
create table summary_time_setting(
    id int primary key auto_increment,
    start_date varchar(20) comment '开始时间',
    submission_deadline varchar(20) comment '上报截止时间',
    title varchar(30) comment '标题'
);
# 电子签章申请
create table electronic_seal_application(
    id int primary key auto_increment,
    seal_type varchar(10) comment '签章类型',
    application_type varchar(10) comment '申请类型',
    application_date varchar(20) comment '申请日期',
    status varchar(10) comment '审批状态',
    application_department varchar(20) comment '申请部门',
    applicat varchar(5) comment '申请人'
);

# 出境申请
create table exit_application(
    id int primary key auto_increment,
    name varchar(5) comment '姓名',
    personnel_type varchar(10) comment '人员类型',
    start_date varchar(20) comment '开始日期',
    end_date varchar(20) comment '结束日期',
    reason varchar(50) comment '原因',
    is_check_commitment varchar(5) comment '是否查看承诺书',
    gender varchar(2) comment '性别',
    birthday varchar(20) comment '出生年月',
    politics_status varchar(10) comment '政治面貌',
    company varchar(50) comment '工作单位',
    go_abroad_type varchar(2) comment '出国(境)类型',
    job varchar(20) comment '职务（职称）',
    degree_secrecy varchar(2) comment '涉密程度',
    passport_number varchar(20) comment '护照号码',
    destination_abroad varchar(20) comment '出国（境）目的地',
    exit_approval_number varchar(30) comment '出国（境）审批编号',
    group_unit varchar(50) comment '组团单位',
    travel_country varchar(20) comment '前往国家（地区）',
    stop_date varchar(20) comment '停留日期',
    group_members varchar(20) comment '出国（境）情况，团组其他人员',
    overseas_travel_date varchar(50) comment '国（境）外行程--日期',
    overseas_travel_place varchar(20) comment '国（境）外行程--地点',
    overseas_travel_things varchar(30) comment '国（境）外行程--事项',
    attachment varchar(100) comment '附件'

                             );
# 回访信息
create table callback(
    id int primary key auto_increment,
    name varchar(5) comment '姓名',
    callback_information_item varchar(50) comment '回访信息项',
    personnel_situation varchar(50) comment '外放接待人员，陪同人员情况',
    study_situation varchar(50) comment '与外方交流学习的主要情况',
    communication_situation varchar(50) comment '与当地华人华侨接触、交往情况'
);

# 出勤汇总
create table attendance_summary(
    id int primary key auto_increment,
    department varchar(10) comment '部门',
    start_date varchar(20) comment '开始时间',
    end_date varchar(20) comment '结束时间',
    status varchar(10) comment '状态'
);

# 出差申请
create table travel_application(
    id int primary key auto_increment,
    name varchar(5) comment '出差人员',
    travel_date varchar(20) comment '出差日期',
    return_date varchar(20) comment '返回日期',
    travel_things varchar(100) comment '出差事由',
    financial_resources varchar(5) comment '经费来源（金额）',
    vehicle varchar(20) comment '交通工具',
    travel_place varchar(50) comment '出差地点',
    travel_days varchar(5) comment '出差天数'
);
# 加班申请

create table work_application(
    id int primary key auto_increment,
    name varchar(5) comment '姓名',
    department varchar(10) comment '部门',
    work_type varchar(5) comment '加班类型',
    start_date varchar(20) comment '加班开始时间',
    end_date varchar(20) comment '加班结束时间',
    reasons varchar(10) comment '事由'
);

#出警申请

create table  police_application(
    id int primary key auto_increment,
    police_date varchar(20) comment '出警日期',
    primary_time varchar(20) comment '出警时间',
    department varchar(10) comment '部门',
    reasons varchar(100) comment '出警事由',
    place varchar(20) comment '出警地点'
);
# 请假申请
create table contact_person(
    id int primary key auto_increment,
    linkman varchar(5) comment '联系人',
    link_phone varchar(13) comment '联系电话',
    relation varchar(5) comment '与本人关系'

);
# 合同工申请
create table contract_application(
    id int primary key auto_increment,
    name varchar(5) comment '姓名',
    gender varchar(2) comment '性别',
    marriage varchar(3) comment '婚否',
    start_date varchar(20) comment '开始节假日',
    end_date varchar(20) comment '结束节假日',
    application_type varchar(10) comment '请假类型',
    place varchar(20) comment '前往地点',
    reasons varchar(100) comment '事由',
    surplus_days varchar(3) comment '公休剩余天数'


);

# 外聘人员
create table external_application(
    id int primary key auto_increment,
    name varchar(5) comment '姓名',
    gender varchar(2) comment '性别',
    department varchar(10) comment '部门',
    reasons varchar(100) comment '事由',
    days varchar(20) comment '天数',
    start_date varchar(20) comment '请假开始时间',
    end_date varchar(20) comment '请假结束时间',
    application_type varchar(10) comment '请假类型',
    approver varchar(10) comment '审批人'

);
# 销假申请
create table leave_clearance_application(
    id int primary key auto_increment,
    name varchar(5) comment '申请人',
    department varchar(10) comment '申请部门',
    surplus_days varchar(3) comment '公休剩余天数',
    note_leave varchar(20) comment '请假单',
    start_date varchar(20) comment '销假开始时间',
    end_date varchar(20) comment '销假结束时间'


);
# 工资统计
create table wage_statistics(
    id int primary key auto_increment,
    name varchar(12) comment '姓名',
    key_id varchar(18) comment '身份证',
    month varchar(10) comment '月份',
    salary_payable varchar(15) comment '应发薪金',
    net_salary varchar(15) comment '实发薪金'
);

# 交接管理
create table handover_management(
    id int primary key auto_increment,
    name varchar(5) comment '姓名',
    department varchar(10) comment '所在部门',
    job varchar(10) comment '职务',
    personnel_category varchar(5) comment '人员类别',
    leave_category varchar(5) comment '离岗类别',
    status varchar(5) comment '交接状态'
);

# 离岗管理
create table departure_management(
    id int primary key auto_increment,
    department varchar(10) comment '部门',
    personnel varchar(10) comment '人员',
    key_card varchar(18) comment '身份证号',
    specialty varchar(10) comment '专业',
    gender varchar(2) comment '性别',
    enrollment_date varchar(20) comment '入职日期',
    left_date varchar(20) comment '离职日期'
);