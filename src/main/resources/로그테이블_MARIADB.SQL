-- jjp.LOGGING_INFO definition
CREATE TABLE `logging_info` (
  COMP_ID varchar(5) NOT NULL		 COMMENT '소속회사',
  `SEQ` int(11) NOT NULL AUTO_INCREMENT COMMENT '순번', 			
  `LOG_CODE` varchar(10) NOT null		COMMENT '로그코드', 	
  `LOG_MESS` text NOT null				COMMENT '로그메세지',	
  `LOG_CLASS` varchar(1000) NOT null	COMMENT '에러클래스',
  `END_DT` varchar(100) NOT null		COMMENT '종료일시', 	  
  `REG_ID` varchar(10) DEFAULT null		COMMENT '등록아이디',	
  `REG_DTM` date DEFAULT null			COMMENT '등록일시', 	
  `REG_IP` varchar(100) DEFAULT null	COMMENT '등록아이피',	
  `STRT_DT` varchar(100) NOT null		COMMENT '시작일시', 	
  PRIMARY KEY (`SEQ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='로그정보';


-- jjp.logging_event definition
CREATE TABLE `logging_event` (
   COMP_ID varchar(5) NOT NULL		 COMMENT '소속회사',
  `EVENT_ID` bigint(20) NOT NULL,
  `TIMESTMP` bigint(20) NOT NULL,
  `FORMATTED_MESSAGE` text NOT NULL,
  `LOGGER_NAME` varchar(254) NOT NULL,
  `LEVEL_STRING` varchar(254) NOT NULL,
  `THREAD_NAME` varchar(254) DEFAULT NULL,
  `REFERENCE_FLAG` smallint(6) DEFAULT NULL,
  `ARG0` varchar(254) DEFAULT NULL,
  `ARG1` varchar(254) DEFAULT NULL,
  `ARG2` varchar(254) DEFAULT NULL,
  `ARG3` varchar(254) DEFAULT NULL,
  `CALLER_FILENAME` varchar(254) NOT NULL,
  `CALLER_CLASS` varchar(254) NOT NULL,
  `CALLER_METHOD` varchar(254) NOT NULL,
  `CALLER_LINE` char(4) NOT NULL,  
  PRIMARY KEY (COMP_ID,`EVENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='로그이벤트';




-- jjp.SVC_MANAGE definition
CREATE TABLE SVC_MANAGE (
	COMP_ID varchar(5) NOT NULL		 COMMENT '소속회사',
	SVC_SEQ numeric(38,0) NOT NULL	 COMMENT '서비스순번',
	SVC_ID varchar(100) NOT NULL	 COMMENT '서비스ID', 
	SVC_NM varchar(200) NULL		 COMMENT '서비스명',
    PAK_PATH varchar(200) NULL		 COMMENT '패키지명', 	
	USE_YN varchar(1) NULL			 COMMENT '사용여부', 
	SVC_DAO varchar(100) NULL		 COMMENT '서비스DAO',
	SVC_XML varchar(100) NULL		 COMMENT '서비스XML',
	REG_ID varchar(100) NULL		 COMMENT '등록자', 
	REG_DTM date NULL				 COMMENT '등록일시', 
	UPD_ID varchar(100) NULL		 COMMENT '수정자', 
	UPD_DTM date NULL				 COMMENT '수정일시', 
	PRIMARY KEY (COMP_ID,SVC_SEQ)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='서비스등록관리';


-- jjp.MENU_MANAGE definition
CREATE TABLE jjp.MENU_MANAGE (
	COMP_ID varchar(5) NOT NULL				COMMENT '소속회사',
	UPPR_MENU_ID varchar(100) NULL			COMMENT '상위메뉴',
	MENU_SEQ numeric(38,0) NOT NULL			COMMENT '메뉴순번', 	
	MENU_ID varchar(100) NOT NULL			COMMENT '메뉴ID', 
	MENU_NM varchar(200) NULL				COMMENT '메뉴명', 
	USE_YN varchar(1) NULL					COMMENT '사용여부', 
	MENU_LVL1 varchar(1) NULL				COMMENT '메뉴레벨1',
	MENU_LVL2 varchar(1) NULL				COMMENT '메뉴레벨2',
	MENU_LVL3 varchar(1) NULL				COMMENT '메뉴레벨3',
	MENU_AUTH varchar(10) DEFAULT NULL 		COMMENT '메뉴권한',
	REG_ID varchar(100) NULL				COMMENT '등록자', 
	REG_DTM date NULL		 				COMMENT '등록일시', 
	UPD_ID varchar(100) NULL				COMMENT '수정자', 
	UPD_DTM date NULL						COMMENT '수정일시', 
	PRIMARY KEY (COMP_ID,MENU_SEQ,MENU_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='메뉴등록관리';

INSERT INTO jjplatform.menu_manage (COMP_ID, UPPR_MENU_ID, MENU_SEQ, MENU_ID, MENU_NM, USE_YN, MENU_LVL1, MENU_LVL2, MENU_LVL3, MENU_AUTH, REG_ID, REG_DTM, UPD_ID, UPD_DTM) VALUES('00000', 'SYS000M', 1, 'MNU001M', '메뉴관리', 'Y', '', 'Y', '', 'S', NULL, NULL, NULL, NULL);
INSERT INTO jjplatform.menu_manage (COMP_ID, UPPR_MENU_ID, MENU_SEQ, MENU_ID, MENU_NM, USE_YN, MENU_LVL1, MENU_LVL2, MENU_LVL3, MENU_AUTH, REG_ID, REG_DTM, UPD_ID, UPD_DTM) VALUES('00000', '', 1, 'SYS000M', '시스템', 'Y', 'Y', '', '', 'S', NULL, NULL, NULL, NULL);
INSERT INTO jjplatform.menu_manage (COMP_ID, UPPR_MENU_ID, MENU_SEQ, MENU_ID, MENU_NM, USE_YN, MENU_LVL1, MENU_LVL2, MENU_LVL3, MENU_AUTH, REG_ID, REG_DTM, UPD_ID, UPD_DTM) VALUES('00000', '', 2, 'SVC000M', '서비스', 'Y', 'Y', NULL, NULL, 'S', NULL, NULL, NULL, NULL);
INSERT INTO jjplatform.menu_manage (COMP_ID, UPPR_MENU_ID, MENU_SEQ, MENU_ID, MENU_NM, USE_YN, MENU_LVL1, MENU_LVL2, MENU_LVL3, MENU_AUTH, REG_ID, REG_DTM, UPD_ID, UPD_DTM) VALUES('00000', 'SYS000M', 2, 'USR001M', '사용자관리', 'Y', '', 'Y', '', 'S', 'user', NOW(), 'user', NOW());



-- jjp.USER_INFO definition
CREATE TABLE jjp.USER_INFO (
	COMP_ID varchar(5) NOT NULL		COMMENT '소속회사',
	USER_ID varchar(100) NOT NULL	COMMENT '사용자ID', 	
	USER_PASS varchar(500) NOT NULL	COMMENT '패스워드', 	
	TEL_NO varchar(12) NOT NULL		COMMENT '전화번호', 	
	EMAIL varchar(200) NOT NULL		COMMENT '이메일', 	
	REG_ID varchar(100) NULL		COMMENT '등록자', 	
	REG_DTM date NULL				COMMENT '등록시간', 	
	REG_IP varchar(20) NULL			COMMENT '등록IP', 	
	UPD_ID varchar(100) NULL		COMMENT '수정자ID', 	
	UPD_DTM date NULL				COMMENT '수정일', 	
	UPD_IP varchar(20) NULL			COMMENT '수정IP', 		
	PRIMARY KEY (COMP_ID,USER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='사용자정보';


-- jjp.USER_ROLE definition
CREATE TABLE jjp.USER_ROLE (
	COMP_ID varchar(5) NOT NULL		COMMENT '소속회사',
	USER_ID varchar(100) NOT NULL   COMMENT '사용자ID',
	USER_ROLE varchar(100) NULL     COMMENT '사용자권한',
	PRIMARY KEY (COMP_ID,USER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='사용자권한';

-- jjp.STOCK_IN_OUT_MANAGE definition
CREATE TABLE `stock_in_out_manage` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `STOCK_APP_ID` varchar(10) DEFAULT NULL COMMENT '주식앱아이디',
  `BANK_ID` varchar(10) NOT NULL COMMENT '거래은행아이디',
  `IN_OUT_DATE` varchar(8) NOT NULL COMMENT '입출금일자',
  `IN_AMT` bigInt(10) DEFAULT NULL COMMENT '입금금액',
  `OUT_AMT` bigInt(10) DEFAULT NULL COMMENT '출금금액',
  `REG_ID` varchar(100) DEFAULT NULL COMMENT '등록자',
  `REG_DTM` date DEFAULT NULL COMMENT '등록일시',
  `UPD_ID` varchar(100) DEFAULT NULL COMMENT '수정자',
  `UPD_DTM` date DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`COMP_ID`,`STOCK_APP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='주식입출금관리';		

-- jjp.STOCK_MANAGE definition
CREATE TABLE `stock_manage` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `STOCK_APP_ID` varchar(10) DEFAULT NULL COMMENT '주식앱아이디',
  `STOCK_ID` varchar(50) NOT NULL COMMENT '주식아이디',
  `SELL_BUY_CD` varchar(2) NOT NULL COMMENT '매입/매도코드',
  `SELL_BUY_DATE` varchar(8) NOT NULL COMMENT '매입/매도일자',
  `SELL_BUY_QTY` bigInt(10) DEFAULT NULL COMMENT '매입/매도수량',
  `SELL_BUY__AMT` bigInt(10) DEFAULT NULL COMMENT '매입/매도금액',
  `REG_ID` varchar(100) DEFAULT NULL COMMENT '등록자',
  `REG_DTM` date DEFAULT NULL COMMENT '등록일시',
  `UPD_ID` varchar(100) DEFAULT NULL COMMENT '수정자',
  `UPD_DTM` date DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`COMP_ID`,`STOCK_APP_ID`,`STOCK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='주식관리';	
