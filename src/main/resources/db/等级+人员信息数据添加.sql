

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
				(DEFAULT,'6','管理员')