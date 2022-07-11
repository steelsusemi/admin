-- jjplatform.dbo.LOGGING_INFO definition

-- Drop table

-- DROP TABLE jjplatform.dbo.LOGGING_INFO;

CREATE TABLE jjplatform.dbo.LOGGING_INFO (
	SEQ numeric(38,0) IDENTITY(0,1) NOT NULL,
	LOG_CODE varchar(10) COLLATE Korean_Wansung_CI_AS NOT NULL,
	LOG_MESS text COLLATE Korean_Wansung_CI_AS NOT NULL,
	REG_ID varchar(100) COLLATE Korean_Wansung_CI_AS NULL,
	REG_DTM datetime NULL,
	REG_IP varchar(100) COLLATE Korean_Wansung_CI_AS NULL,
	STRT_DT varchar(100) COLLATE Korean_Wansung_CI_AS NOT NULL,
	END_DT varchar(100) COLLATE Korean_Wansung_CI_AS NOT NULL,
	LOG_CLASS varchar(1000) COLLATE Korean_Wansung_CI_AS NOT NULL,
	CONSTRAINT LOG_INFO_PK PRIMARY KEY (SEQ)
);

-- Extended properties

EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'로그정보 테이블', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOGGING_INFO';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'순번', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOGGING_INFO', @level2type=N'Column', @level2name=N'SEQ';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'로그코드', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOGGING_INFO', @level2type=N'Column', @level2name=N'LOG_CODE';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'로그메세지', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOGGING_INFO', @level2type=N'Column', @level2name=N'LOG_MESS';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'등록아이디', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOGGING_INFO', @level2type=N'Column', @level2name=N'REG_ID';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'등록일시', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOGGING_INFO', @level2type=N'Column', @level2name=N'REG_DTM';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'등록아이피', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOGGING_INFO', @level2type=N'Column', @level2name=N'REG_IP';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'시작일시', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOGGING_INFO', @level2type=N'Column', @level2name=N'STRT_DT';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'종료일시', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOGGING_INFO', @level2type=N'Column', @level2name=N'END_DT';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'에러클래스', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOGGING_INFO', @level2type=N'Column', @level2name=N'LOG_CLASS';


-- Drop table

-- DROP TABLE jjplatform.dbo.LOGGING_EVENT;

CREATE TABLE jjplatform.dbo.LOGGING_EVENT (
	TIMESTMP bigint NOT NULL,
	FORMATTED_MESSAGE text COLLATE Korean_Wansung_CI_AS NOT NULL,
	LOGGER_NAME varchar(254) COLLATE Korean_Wansung_CI_AS NOT NULL,
	LEVEL_STRING varchar(254) COLLATE Korean_Wansung_CI_AS NOT NULL,
	THREAD_NAME varchar(254) COLLATE Korean_Wansung_CI_AS NULL,
	REFERENCE_FLAG smallint NULL,
	ARG0 varchar(254) COLLATE Korean_Wansung_CI_AS NULL,
	ARG1 varchar(254) COLLATE Korean_Wansung_CI_AS NULL,
	ARG2 varchar(254) COLLATE Korean_Wansung_CI_AS NULL,
	ARG3 varchar(254) COLLATE Korean_Wansung_CI_AS NULL,
	CALLER_FILENAME varchar(254) COLLATE Korean_Wansung_CI_AS NOT NULL,
	CALLER_CLASS varchar(254) COLLATE Korean_Wansung_CI_AS NOT NULL,
	CALLER_METHOD varchar(254) COLLATE Korean_Wansung_CI_AS NOT NULL,
	CALLER_LINE char(4) COLLATE Korean_Wansung_CI_AS NOT NULL,
	EVENT_ID bigint IDENTITY(1,1) NOT NULL,
	CONSTRAINT PK__LOGGING___241A510C8B3D5188 PRIMARY KEY (EVENT_ID)
);




-- Drop table

-- DROP TABLE jjplatform.dbo.SVC_MANAGE;

CREATE TABLE jjplatform.dbo.SVC_MANAGE (
	SVC_ID varchar(100) COLLATE Korean_Wansung_CI_AS NOT NULL,
	SVC_NM varchar(200) COLLATE Korean_Wansung_CI_AS NULL,
	USE_YN varchar(1) COLLATE Korean_Wansung_CI_AS NULL,
	SVC_DAO varchar(100) COLLATE Korean_Wansung_CI_AS NULL,
	SVC_XML varchar(100) COLLATE Korean_Wansung_CI_AS NULL,
	REG_ID varchar(100) COLLATE Korean_Wansung_CI_AS NULL,
	REG_DTM datetime NULL,
	UPD_ID varchar(100) COLLATE Korean_Wansung_CI_AS NULL,
	UPD_DTM datetime NULL,
	PAK_PATH varchar(200) COLLATE Korean_Wansung_CI_AS NULL,
	SVC_SEQ numeric(38,0) NOT NULL,
	CONSTRAINT SVC_MANAGE_PK PRIMARY KEY (SVC_SEQ)
);

-- Extended properties

EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'서비스등록관리', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'서비스ID', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE', @level2type=N'Column', @level2name=N'SVC_ID';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'서비스명', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE', @level2type=N'Column', @level2name=N'SVC_NM';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'사용여부', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE', @level2type=N'Column', @level2name=N'USE_YN';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'서비스DAO', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE', @level2type=N'Column', @level2name=N'SVC_DAO';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'서비스XML', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE', @level2type=N'Column', @level2name=N'SVC_XML';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'등록자', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE', @level2type=N'Column', @level2name=N'REG_ID';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'등록일시', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE', @level2type=N'Column', @level2name=N'REG_DTM';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'수정자', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE', @level2type=N'Column', @level2name=N'UPD_ID';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'수정일시', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE', @level2type=N'Column', @level2name=N'UPD_DTM';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'패키지명', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE', @level2type=N'Column', @level2name=N'PAK_PATH';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'서비스순번', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'SVC_MANAGE', @level2type=N'Column', @level2name=N'SVC_SEQ';


-- jjplatform.dbo.MENU_MANAGE definition

-- Drop table

-- DROP TABLE jjplatform.dbo.MENU_MANAGE;

CREATE TABLE jjplatform.dbo.MENU_MANAGE (
	MENU_ID varchar(100) COLLATE Korean_Wansung_CI_AS NOT NULL,
	MENU_NM varchar(200) COLLATE Korean_Wansung_CI_AS NULL,
	USE_YN varchar(1) COLLATE Korean_Wansung_CI_AS NULL,
	MENU_LVL1 varchar(1) COLLATE Korean_Wansung_CI_AS NULL,
	REG_ID varchar(100) COLLATE Korean_Wansung_CI_AS NULL,
	REG_DTM datetime NULL,
	UPD_ID varchar(100) COLLATE Korean_Wansung_CI_AS NULL,
	UPD_DTM datetime NULL,
	MENU_LVL2 varchar(1) COLLATE Korean_Wansung_CI_AS NULL,
	MENU_LVL3 varchar(1) COLLATE Korean_Wansung_CI_AS NULL,
	MENU_SEQ numeric(38,0) NOT NULL,
	UPPR_MENU_ID varchar(100) COLLATE Korean_Wansung_CI_AS NULL,
	COMP_ID varchar(5) COLLATE Korean_Wansung_CI_AS NOT NULL,
	CONSTRAINT MENU_MANAGE_PK PRIMARY KEY (MENU_SEQ,MENU_ID,COMP_ID)
);

-- Extended properties

EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'메뉴ID', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'MENU_ID';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'메뉴명', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'MENU_NM';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'사용여부', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'USE_YN';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'메뉴레벨1', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'MENU_LVL1';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'등록자', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'REG_ID';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'등록일시', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'REG_DTM';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'수정자', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'UPD_ID';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'수정일시', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'UPD_DTM';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'메뉴레벨2', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'MENU_LVL2';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'메뉴레벨3', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'MENU_LVL3';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'메뉴순번', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'MENU_SEQ';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'상위메뉴', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'UPPR_MENU_ID';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'소속회사', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'MENU_MANAGE', @level2type=N'Column', @level2name=N'COMP_ID';
