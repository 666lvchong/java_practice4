-- 2018年1月20日14点58分 邓超 人员基本信息表：主键、姓名、性别、年龄、民族、出生日期、身份证号、手机、籍贯、
-- 邮箱、常住地址、职业、工作单位、添加时间、更新时间
DROP TABLE IF EXISTS PEOPLE_INFO;
CREATE TABLE PEOPLE_INFO(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	`NAME` VARCHAR(30) NOT NULL COMMENT '姓名',
	SEX TINYINT(1) NOT NULL COMMENT '性别 0-女,1-男',
	AGE INT COMMENT '年龄',
	NATION VARCHAR(30) COMMENT '民族',
	BIRTHDATE DATE COMMENT '出生日期 yyyy-MM-dd',
	ID_NUMBER VARCHAR(30) UNIQUE NOT NULL COMMENT '身份证号',
	MOBILE_PHONE VARCHAR(30) COMMENT '手机',
	NATIVE_PLACE VARCHAR(30) COMMENT '籍贯',
	MAILBOX VARCHAR(30) COMMENT '邮箱',
	PERMANENT_ADDRESS VARCHAR(50) COMMENT '常住地址',
	PROFESSION VARCHAR(30) COMMENT '职业',
	WORK_UNIT VARCHAR(30) COMMENT '工作单位', 
	CREATE_TIME DATETIME NOT NULL COMMENT '添加时间 yyyy-MM-dd HH:mm:ss',
	UPDATE_TIME DATETIME NOT NULL COMMENT '更新时间 yyyy-MM-dd HH:mm:ss'
)ENGINE=INNODB COMMENT '人员基本信息表';


-- 2018年1月29日16点18分 邓超 等级权限表：主键ID，人员账户，等级，是否删除，操作时间
DROP TABLE IF EXISTS GRADE;
CREATE TABLE GRADE(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
	GRADE_NUMBER TINYINT(2) COMMENT '等级编号 1-一星级，2-二星级，3-三星级，4-四星级，5-五星级，6-管理员',
	GRADE_NAME VARCHAR(50) COMMENT '等级名称'
)ENGINE=INNODB COMMENT '管理员';


-- 2018年1月20日15:20:58  黄磊  主键ID 商品名 商品编号，类型 库存
-- 单价 添加时间 更新时间 生存商 生产地 生产日期 保质期 原产地 商品描述 卖家信息 商品折扣 CX item_info
DROP TABLE IF EXISTS ITEM_INFO;
CREATE TABLE ITEM_INFO (
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
	`NAME` VARCHAR(30) NOT NULL COMMENT '商品名',
	NUMBER VARCHAR(30) NOT NULL COMMENT '商品编号',
	ITEM_TYPE_ID VARCHAR(30)   NOT NULL COMMENT '商品类型ID' REFERENCES ITEM_TYPE(ID),
	IN_TIME DATETIME NOT NULL COMMENT '添加时间 yyyy-MM-dd HH:mm:ss',
	UPDATE_TIME DATETIME NOT NULL COMMENT '更新时间 yyyy-MM-dd HH:mm:ss',
	MAKER VARCHAR(100) NOT NULL COMMENT '生产商',
	ADDR VARCHAR(100) NOT NULL COMMENT '生产地',
	MAKE_TIME DATE COMMENT '生产日期 yyyy-MM-dd',
	EXPIRATION DATE COMMENT '保质期 yyyy-MM-dd',
	ORIGIN VARCHAR(100)  COMMENT '原产地',
	DESCRIPTION VARCHAR(100)  COMMENT '商品描述',
	DISCOUNT FLOAT COMMENT '折扣'
) ENGINE=InnoDB COMMENT='商品信息';


-- 2018年1月29日15:28:40 黄磊 商品类型表
DROP TABLE IF EXISTS ITEM_TYPE;
CREATE TABLE ITEM_TYPE (
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
	`NAME` VARCHAR(30)   NOT NULL COMMENT '商品类型名称',
		DESCRIPTION VARCHAR(100)  COMMENT '商品类型描述'
) ENGINE=InnoDB COMMENT='商品类型';


-- 2017年12月22日17:30:08 黄派 淘宝账户: 主键ID，人员账户，密码，支付宝信息，是否冻结，是否注销，是否删除，人员信息，添加时间，更新时间 
DROP TABLE IF EXISTS TAOBAO_ACCOUNT;
CREATE TABLE TAOBAO_ACCOUNT(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT'主键ID',
  PERSONNEL_ACCOUNT VARCHAR(30) NOT NULL COMMENT'人员账户',
  `PASSWORD` INT NOT NULL COMMENT'密码',
	GRADE_ID BIGINT COMMENT '权限等级ID' REFERENCES GRADE(ID),
  IS_FROZEN TINYINT(1) DEFAULT 0 COMMENT'是否冻结 -- 0--否，1--是',
  IS_CANCELLATION TINYINT(1) DEFAULT 0 COMMENT'是否注销 -- 0--否，1--是',
  IS_DELETE TINYINT(1)DEFAULT 0 COMMENT'是否删除 -- 0--否，1--是',
  PEOPLE_INFO_ID BIGINT COMMENT'人员信息'REFERENCES PEOPLE_INFO(ID),
  ADD_TIME DATETIME COMMENT'添加时间 yyyy-MM-dd HH:mm:ss',
  UPDATE_TIME DATETIME COMMENT'更新时间 yyyy-MM-dd HH:mm:ss'
)ENGINE=INNODB COMMENT'淘宝账户';


-- 2018年1月20日16:02:17 何鸿举 
-- 订单信息：订单编号，买家信息，订单总金额，创建订单时间，交易成功时间，是否交易成功
DROP TABLE IF EXISTS ORDER_INFO;
CREATE TABLE ORDER_INFO(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
	ORDER_NUM VARCHAR(20) NOT NULL COMMENT '订单编号',
	TAOBAO_ACCOUNT_ID BIGINT NOT NULL COMMENT '淘宝账户' REFERENCES TAOBAO_ACCOUNT(ID) ,
	ORDER_TOTAL_AMOUNT DECIMAL(12) NOT NULL COMMENT '订单总金额',
	CREATION_TIME DATETIME NOT NULL COMMENT '创建订单时间 yyyy-MM-dd HH：mm：ss',
	TRADING_TIME DATETIME NOT NULL COMMENT '交易成功时间 yyyy-MM-dd HH：mm：ss',
	IS_SUCCESS TINYINT(1) NOT NULL COMMENT '是否交易成功，1--是，0--否'
)ENGINE=INNODB COMMENT '订单信息';


-- 2018年1月20日16:02:11何鸿举
-- 订单详情： 订单信息,商品信息，购买商品数量，总金额，商品折扣，订单状态，是否发货，是否退货，是否作废，出货时间，收货时间
DROP TABLE IF EXISTS ORDER_DETAIL;
CREATE TABLE ORDER_DETAIL(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
	ORDER_INFO_ID BIGINT NOT NULL COMMENT '订单信息外键' REFERENCES ORDER_INFO(ID),
	ITEM_INFO_ID BIGINT NOT NULL COMMENT '商品信息外键' REFERENCES ITEM_INFO(ID),
	ITEM_NUMBER INT NOT NULL COMMENT '商品购买数量',
	AMOUNT DOUBLE NOT NULL COMMENT '金额',
	ORDER_STATUS TINYINT(2) NOT NULL COMMENT '订单状态，1-订单开始  2-付款成功 3-已发货 4-已收货 5-订单失败 6-订单成功',
	IS_SENT TINYINT(1) NOT NULL COMMENT '发货状态 1--发货 0--未发货',
	IS_RECEIVED  TINYINT NOT NULL COMMENT '收货状态 1--收货 0--未收货',
	IS_RETURNED  TINYINT NOT NULL COMMENT '退货状态 1--退货 0--未退货',
	SENT_TIME DATETIME COMMENT '发货时间 yyyy-MM-dd HH:mm:ss',
	RECEIVED_TIME DATETIME COMMENT '收货时间 yyyy-MM-dd HH:mm:ss', 
	RETURNED_TIME DATETIME COMMENT '退货时间 yyyy-MM-dd HH:mm:ss'
)ENGINE = INNODB COMMENT '订单详情';


-- 2018年1月20日17:39:39 蔡幸 支付宝信息：支付宝主键ID,支付宝账号，密码，余额，注册日期，支付密码，是否冻结，是否注销，是否删除 --paypal_info
DROP TABLE IF EXISTS PAYPAL_INFO;
CREATE TABLE PAYPAL_INFO(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '支付宝主键ID',
  ACCOUNT VARCHAR(30) NOT NULL COMMENT '支付宝账号',
  PASSWORD VARCHAR(30)NOT NULL COMMENT '密码',
  BALANCE DECIMAL(15,3) NOT NULL COMMENT '余额',
  REGISTER_DATE DATETIME NOT NULL COMMENT '注册日期 yyyy-MM-dd HH：mm：ss',
  PAY_PASSWORD INT(6) NOT NULL COMMENT '支付密码',
  IS_FREEZEN TINYINT(1) NOT NULL COMMENT '是否冻结，1--是，0--否',
  IS_CANCEL TINYINT(1) NOT NULL COMMENT '是否注销，1--是，0--否',
  IS_DELETE TINYINT(1) NOT NULL COMMENT '是否删除，1--是，0--否',
  TAOBAO_ACCOUNT_ID BIGINT COMMENT'淘宝账户'REFERENCES TAOBAO_ACCOUNT(ID)
)ENGINE=INNODB COMMENT '支付宝信息';


-- 2018年1月20日14:50:39 吕冲 订单支付流水信息表: 主键 流水编号 订单信息外键 支付宝信息外键 流水记录类型 支付状态 交易金额 创建交易时间 交易完成时间
DROP TABLE IF EXISTS ORDER_STATEMENT_INFO;
CREATE TABLE ORDER_STATEMENT_INFO(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT'主键',
	SERIAL_NUMBER VARCHAR(30) NOT NULL COMMENT'流水编号',
	ORDER_INFO_ID BIGINT NOT NULL COMMENT'订单信息外键' REFERENCES ORDER_INFO(ID),
	PAYPAL_INFO_ID BIGINT NOT NULL COMMENT'支付宝信息外键' REFERENCES PAYPAL_INFO(ID), 
	FLOW_RECORD_TYPE TINYINT(2) NOT NULL COMMENT'流水记录类型，1--收入,2--支出',
	IS_PAY_STATUS TINYINT(2)  NOT NULL COMMENT'支付状态，1—-支付成功，2--支付失败',
	AMOUNTS DECIMAL(15,3) NOT NULL COMMENT'交易金额',
	LAUNCH_TIME DATETIME NOT NULL COMMENT'创建交易时间，yyyy-MM-dd HH:mm"ss',
	FINSH_TIME DATETIME NOT NULL COMMENT'交易完成时间，yyyy-MM-dd HH:mm:ss'
)ENGINE=INNODB COMMENT'订单支付流水信息表';


-- 2018年1月25日18:21:57 商品关系表 
DROP TABLE IF EXISTS ITEM_RELATION;
CREATE TABLE ITEM_RELATION(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键', 
	SELLER_INFO_ID BIGINT COMMENT'卖家信息' REFERENCES SELLER_INFO(ID),
	ITEM_INFO_ID BIGINT COMMENT'商品信息' REFERENCES ITEM_INFO(ID),
	INVENTORY DECIMAL(15,3) NOT NULL COMMENT '库存',
	PRICE DECIMAL(15,3) NOT NULL COMMENT '单价'
)ENGINE=INNODB COMMENT '商品关系表';


-- 2018年1月20日14点58分 王俊杰 卖家信息：商铺名称 商铺编号 商铺类型 注册时间 
-- 联系电话 地址 邮箱 关联公司名 工商注册号 更新时间 注册人 押金 信誉度 --seller_info	
DROP TABLE IF EXISTS SELLER_INFO;
CREATE TABLE SELLER_INFO(
	ID BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT'主键ID',
	SHOP_NAME VARCHAR(50) NOT NULL COMMENT'商铺名称',
	SHOP_NUMBER VARCHAR(30) UNIQUE NOT NULL COMMENT'商铺编号',
	SHOP_TYPE VARCHAR(50) NOT NULL DEFAULT'普通' COMMENT'商铺类型',
	PAYPAL_INFO_ID BIGINT COMMENT '支付宝信息ID' REFERENCES PAYPAL_INFO(ID),
	PEOPLE_INFO_ID BIGINT COMMENT '人员信息ID' REFERENCES PEOPLE_INFO(ID),
	TAOBAO_ACCOUNT_ID BIGINT COMMENT'所属那个淘宝账户'REFERENCES TAOBAO_ACCOUNT(ID),
	REGISTRATION_TIME DATETIME NOT NULL COMMENT'注册时间 yyyy-MM-dd HH(24):mm:ss',
	ADDRESS VARCHAR(50) NOT NULL COMMENT'地址',
	EMAIL VARCHAR(50) NOT NULL COMMENT'邮箱',
	AFFILIATED_COMPANY VARCHAR(50) COMMENT'关联公司名',
	COMMERCIAL_REGISTRATION_NUM VARCHAR(50) UNIQUE NOT NULL COMMENT'工商注册号',
	UPDATE_TIME DATETIME NOT NULL COMMENT'更新时间 yyyy-MM-dd HH:mm:ss',
	DEPOSIT DECIMAL(15,3) NOT NULL COMMENT'押金',
	CREDITWORTHINESS BIGINT DEFAULT'0' COMMENT'信誉度'
)ENGINE=INNODB COMMENT '卖家信息表';


-- -- 2018年2月9日13点46分 邓超 活动信息表：主键，折扣，活动名称，活动开始时间，活动结束时间
DROP TABLE IF EXISTS ACTIVITY_INFO;
CREATE TABLE ACTIVITY_INFO(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	DISCOUNT DOUBLE COMMENT '折扣',
	ACTIVITY_NAME VARCHAR(30) COMMENT '活动名称',
	ACTIVITY_SATRT_TIME DATETIME COMMENT '活动开始时间 yyyy-MM-dd HH:mm:ss',
	ACTIVITY_END_TIME DATETIME COMMENT '活动结束时间 yyyy-MM-dd HH:mm:ss'
)ENGINE=INNODB COMMENT '活动信息表';

-- -- 2018年2月9日14点00分 邓超 活动关系表：主键，商品关系表外键，活动信息表外键
DROP TABLE IF EXISTS ACTIVITY_RELATION;
CREATE TABLE ACTIVITY_RELATION(
	ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
	ITEM_RELATION_ID BIGINT COMMENT '商品关系表外键ID' REFERENCES ITEM_RELATION(ID),
	ACTIVITY_INFO_ID BIGINT COMMENT '活动信息表外键ID' REFERENCES ACTIVITY_INFO(ID)
)ENGINE=INNODB COMMENT '活动关系表';






