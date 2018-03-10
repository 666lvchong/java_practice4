
INSERT INTO `wechat_business`.`item_info` (`ID`, `NAME`, `NUMBER`, `ITEM_TYPE_ID`, `IN_TIME`, `UPDATE_TIME`, `MAKER`, `ADDR`, `MAKE_TIME`, `EXPIRATION`, `ORIGIN`, `DESCRIPTION`, `DISCOUNT`) VALUES (null, '美国高射炮', '7878778', '1', '2018-01-10 14:24:28', '2018-01-02 14:24:32', '美国', '美国', '2018-01-08', '2018-04-12', '1', '1', '1');
INSERT INTO `wechat_business`.`item_info` (`ID`, `NAME`, `NUMBER`, `ITEM_TYPE_ID`, `IN_TIME`, `UPDATE_TIME`, `MAKER`, `ADDR`, `MAKE_TIME`, `EXPIRATION`, `ORIGIN`, `DESCRIPTION`, `DISCOUNT`) VALUES (null, '德国高射炮', '7878778', '1', '2018-01-10 14:24:28', '2018-01-02 14:24:32', '德国', '德国', '2018-01-08', '2018-04-12', '1', '1', '1');
INSERT INTO `wechat_business`.`item_info` (`ID`, `NAME`, `NUMBER`, `ITEM_TYPE_ID`, `IN_TIME`, `UPDATE_TIME`, `MAKER`, `ADDR`, `MAKE_TIME`, `EXPIRATION`, `ORIGIN`, `DESCRIPTION`, `DISCOUNT`) VALUES (null, '中国高射炮', '7878778', '1', '2018-01-10 14:24:28', '2018-01-02 14:24:32', '中国', '中国', '2018-01-08', '2018-04-12', '1', '1', '1');
INSERT INTO `wechat_business`.`item_info` (`ID`, `NAME`, `NUMBER`, `ITEM_TYPE_ID`, `IN_TIME`, `UPDATE_TIME`, `MAKER`, `ADDR`, `MAKE_TIME`, `EXPIRATION`, `ORIGIN`, `DESCRIPTION`, `DISCOUNT`) VALUES (null, '韩国高射炮', '7878778', '1', '2018-01-10 14:24:28', '2018-01-02 14:24:32', '韩国', '韩国', '2018-01-08', '2018-04-12', '1', '1', '1');
INSERT INTO `wechat_business`.`seller_info` (`ID`, `SHOP_NAME`, `SHOP_NUMBER`, `SHOP_TYPE`, `TAOBAO_ACCOUNT_ID`, `REGISTRATION_TIME`, `ADDRESS`, `EMAIL`, `AFFILIATED_COMPANY`, `COMMERCIAL_REGISTRATION_NUM`, `UPDATE_TIME`, `DEPOSIT`, `CREDITWORTHINESS`) VALUES ('1', '美国军火商贩', '111111', '军火商铺', '1', '2018-01-30 16:46:27', '美国', '825@qq.com', '美国政府', 'FBI情报局', '2017-12-26 16:46:40', '99999999.000', '100');
INSERT INTO `wechat_business`.`seller_info` (`ID`, `SHOP_NAME`, `SHOP_NUMBER`, `SHOP_TYPE`, `TAOBAO_ACCOUNT_ID`, `REGISTRATION_TIME`, `ADDRESS`, `EMAIL`, `AFFILIATED_COMPANY`, `COMMERCIAL_REGISTRATION_NUM`, `UPDATE_TIME`, `DEPOSIT`, `CREDITWORTHINESS`) VALUES ('2', '德国军火商贩', '111112', '军火商铺', '1', '2018-01-30 16:46:27', '德国', '825@qq.com', '德国政府', '希特勒反动派', '2017-12-26 16:46:40', '99999999.000', '100');
INSERT INTO `wechat_business`.`seller_info` (`ID`, `SHOP_NAME`, `SHOP_NUMBER`, `SHOP_TYPE`, `TAOBAO_ACCOUNT_ID`, `REGISTRATION_TIME`, `ADDRESS`, `EMAIL`, `AFFILIATED_COMPANY`, `COMMERCIAL_REGISTRATION_NUM`, `UPDATE_TIME`, `DEPOSIT`, `CREDITWORTHINESS`) VALUES ('3', '中国军火商贩', '111113', '军火商铺', '1', '2018-01-30 16:46:27', '中国', '825@qq.com', '中国政府', '中央情报局', '2017-12-26 16:46:40', '99999999.000', '100');
INSERT INTO `wechat_business`.`seller_info` (`ID`, `SHOP_NAME`, `SHOP_NUMBER`, `SHOP_TYPE`, `TAOBAO_ACCOUNT_ID`, `REGISTRATION_TIME`, `ADDRESS`, `EMAIL`, `AFFILIATED_COMPANY`, `COMMERCIAL_REGISTRATION_NUM`, `UPDATE_TIME`, `DEPOSIT`, `CREDITWORTHINESS`) VALUES ('4', '韩国军火商贩', '111114', '军火商铺', '1', '2018-01-30 16:46:27', '韩国', '825@qq.com', '韩国政府', '青瓦台智障组合', '2017-12-26 16:46:40', '99999999.000', '100');

INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '1', '1', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '1', '2', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '1', '3', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '1', '4', '5.000', '999999.000', 'img/lv_item_img.jpg');

INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '2', '1', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '2', '2', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '2', '3', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '2', '4', '5.000', '999999.000', 'img/lv_item_img.jpg');

INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '3', '1', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '3', '2', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '3', '3', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '3', '4', '5.000', '999999.000', 'img/lv_item_img.jpg');

INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '4', '1', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '4', '2', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '4', '3', '5.000', '999999.000', 'img/lv_item_img.jpg');
INSERT INTO `wechat_business`.`item_relation` (`ID`, `SELLER_INFO_ID`, `ITEM_INFO_ID`, `INVENTORY`, `PRICE`, `IMG_ADDR`) VALUES (null, '4', '4', '5.000', '999999.000', 'img/lv_item_img.jpg');



INSERT INTO `wechat_business`.`taobao_account` (`ID`, `PERSONNEL_ACCOUNT`, `PASSWORD`, `GRADE_ID`, `IS_FROZEN`, `IS_CANCELLATION`, `IS_DELETE`, `PEOPLE_INFO_ID`, `ADD_TIME`, `UPDATE_TIME`) VALUES (default, 'door', '123456', '6', '0', '0', '0', '1', '2017-01-01 00:00:00', '2017-02-02 00:00:00');
INSERT INTO `wechat_business`.`taobao_account` (`ID`, `PERSONNEL_ACCOUNT`, `PASSWORD`, `GRADE_ID`, `IS_FROZEN`, `IS_CANCELLATION`, `IS_DELETE`, `PEOPLE_INFO_ID`, `ADD_TIME`, `UPDATE_TIME`) VALUES (default, 'van', '654321', '1', '0', '0', '0', '2', '2017-01-05 00:00:00', '2017-01-22 00:00:00');


-- -- 人员信息插入数据
INSERT INTO people_info (ID,`NAME`,SEX,AGE,NATION,BIRTHDATE,ID_NUMBER,MOBILE_PHONE,NATIVE_PLACE,MAILBOX,PERMANENT_ADDRESS,PROFESSION,WORK_UNIT,CREATE_TIME,UPDATE_TIME)
VALUES (DEFAULT,'张宇','1',22,'四川','1996-4-25','312456','13569845789','成都','@.com','成都','销售','XXX公司','2018-1-25 09:37:35','2018-1-25 09:37:35'),
			 (DEFAULT,'方红','0',26,'北京','1992-7-15','312546','15596847623','北京','@.com','北京','财务管理','XXX公司','2018-1-22 08:41:56','2018-1-25 10:41:25'),
				(DEFAULT,'方强','1',21,'北京','1997-8-15','312854','13596845521','北京','@.com','北京','程序员','XXX公司','2018-1-22 08:41:56','2018-1-25 10:41:25'),
				(DEFAULT,'张磊','1',26,'上海','1992-6-23','456789','18756942651','上海','@.com','上海','歌手','XXX公司','2018-1-22 08:41:56','2018-1-25 10:41:25'),
				(DEFAULT,'李蕊','0',24,'四川','1994-7-14','312654','15694873265','成都','@.com','成都','公务员','XXX单位','2018-1-22 08:41:56','2018-1-25 10:41:25'),
				(DEFAULT,'石头','1',30,'四川','1988-3-21','213654','15698451265','绵阳','@.com','绵阳','教师','XXX学校','2018-1-22 08:41:56','2018-1-25 10:41:25'),
				(DEFAULT,'丫头','0',23,'沈阳','1995-1-1','511632','18032569487','沈阳','@.com','沈阳','财会','XXX公司','2018-1-22 08:41:56','2018-1-25 10:41:25'),
				(DEFAULT,'吴昊','1',26,'广州','1992-1-9','502316','15649873658','广州','@.com','广州','个体','XXX店','2018-1-22 08:41:56','2018-1-25 10:41:25'),
				(DEFAULT,'张凯','1',21,'四川','1997-6-25','522654','15543215698','成都','@.com','成都','主播',NULL,'2018-1-22 08:41:56','2018-1-25 10:41:25'),
				(DEFAULT,'好菜','1',22,'四川','1996-5-23','512356','18796543256','眉山','@.com','眉山','公务员','XXX单位','2018-1-22 08:41:56','2018-1-25 10:41:25');

-- -- 等级权限插入数据
INSERT INTO grade (ID,GRADE_NUMBER,GRADE_NAME) 
VALUES (DEFAULT,'1','一星级'),
				(DEFAULT,'2','二星级'),
				(DEFAULT,'3','三星级'),
				(DEFAULT,'4','四星级'),
				(DEFAULT,'5','五星级'),
				(DEFAULT,'6','管理员');

-- -- 活动信心表插入数据' ACTIVITY_SATRT_TIME'
INSERT INTO activity_info (ID,DISCOUNT,ACTIVITY_NAME,ACTIVITY_SATRT_TIME,ACTIVITY_END_TIME)
VALUES(DEFAULT,'9.5','商城周年庆','2018-01-01 00:00:00','2018-01-08 23:59:59'),
			(DEFAULT,'9.0','大型优惠节','2018-02-08 00:00:00','2018-02-12 23:59:59');

-- -- 活动关系表插入数据
INSERT INTO activity_relation (ID,ITEM_RELATION_ID,ACTIVITY_INFO_ID)
VALUES(DEFAULT,'2','1'),
			(DEFAULT,'1','2');

SELECT  ID, PERSONNEL_ACCOUNT, `PASSWORD`,GRADE_ID IS_FROZEN, IS_CANCELLATION, IS_DELETE, PEOPLE_INFO_ID, ADD_TIME,UPDATE_TIME  
FROM TAOBAO_ACCOUNT WHERE 1 = 1 OR PERSONNEL_ACCOUNT = 'a' LIMIT 0, 20

SELECT ID,GRADE_NUMBER,GRADE_NAME FROM GRADE WHERE 1=1 AND ID='2'