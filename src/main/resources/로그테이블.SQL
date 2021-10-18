-- Drop table

-- DROP TABLE jjplatform.dbo.LOG_INFO;

CREATE TABLE jjplatform.dbo.LOG_INFO (
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

EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'로그정보 테이블', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOG_INFO';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'순번', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOG_INFO', @level2type=N'Column', @level2name=N'SEQ';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'로그코드', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOG_INFO', @level2type=N'Column', @level2name=N'LOG_CODE';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'로그메세지', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOG_INFO', @level2type=N'Column', @level2name=N'LOG_MESS';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'등록아이디', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOG_INFO', @level2type=N'Column', @level2name=N'REG_ID';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'등록일시', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOG_INFO', @level2type=N'Column', @level2name=N'REG_DTM';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'등록아이피', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOG_INFO', @level2type=N'Column', @level2name=N'REG_IP';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'시작일시', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOG_INFO', @level2type=N'Column', @level2name=N'STRT_DT';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'종료일시', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOG_INFO', @level2type=N'Column', @level2name=N'END_DT';
EXEC jjplatform.sys.sp_addextendedproperty @name=N'MS_Description', @value=N'에러클래스', @level0type=N'Schema', @level0name=N'dbo', @level1type=N'Table', @level1name=N'LOG_INFO', @level2type=N'Column', @level2name=N'LOG_CLASS';




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
