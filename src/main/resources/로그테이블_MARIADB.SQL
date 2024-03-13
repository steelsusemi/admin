-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.11.7-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- jjplatform 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `jjplatform` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `jjplatform`;

-- 테이블 jjplatform.board_manage 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_manage` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `BOA_SEQ` decimal(38,0) NOT NULL COMMENT '게시물순번',
  `BOA_TITLE` varchar(200) DEFAULT NULL COMMENT '제목',
  `BOA_CONTENT` text DEFAULT NULL COMMENT '내용',
  `BOA_GB` varchar(200) DEFAULT NULL COMMENT '게시구분',
  `OPEN_START_DATE` varchar(8) DEFAULT NULL COMMENT '오픈일자',
  `OPEN_END_DATE` varchar(8) DEFAULT NULL COMMENT '종료일자',
  `FILE_ID` bigint(20) DEFAULT NULL COMMENT '파일아이디',
  `USE_YN` varchar(1) DEFAULT NULL COMMENT '사용여부',
  `REG_ID` varchar(100) DEFAULT NULL COMMENT '등록자',
  `REG_DTM` datetime DEFAULT NULL COMMENT '등록일시',
  `UPD_ID` varchar(100) DEFAULT NULL COMMENT '수정자',
  `UPD_DTM` datetime DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`COMP_ID`,`BOA_SEQ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='게시물등록관리';

-- 테이블 데이터 jjplatform.board_manage:~0 rows (대략적) 내보내기

-- 테이블 jjplatform.board_reply 구조 내보내기
CREATE TABLE IF NOT EXISTS `board_reply` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `BOA_SEQ` decimal(38,0) NOT NULL COMMENT '게시물순번',
  `REPLY_SEQ` decimal(38,0) NOT NULL COMMENT '답글순번',
  `REPLY_CONTENT` varchar(200) DEFAULT NULL COMMENT '답글',
  `USE_YN` varchar(1) DEFAULT NULL COMMENT '사용여부',
  `REG_ID` varchar(100) DEFAULT NULL COMMENT '등록자',
  `REG_DTM` datetime DEFAULT NULL COMMENT '등록일시',
  `UPD_ID` varchar(100) DEFAULT NULL COMMENT '수정자',
  `UPD_DTM` datetime DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`COMP_ID`,`BOA_SEQ`,`REPLY_SEQ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='게시물답글';

-- 테이블 데이터 jjplatform.board_reply:~0 rows (대략적) 내보내기

-- 테이블 jjplatform.file_manage 구조 내보내기
CREATE TABLE IF NOT EXISTS `file_manage` (
  `FILE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '파일아이디',
  `FILE_NAME` varchar(50) NOT NULL COMMENT '파일명',
  `FILE_HASH` varchar(200) NOT NULL COMMENT '파일HASH명',
  `FILE_PATH` varchar(200) NOT NULL COMMENT '파일경로',
  `FILE_URL` varchar(200) NOT NULL COMMENT '파일URL',
  `FILE_EXTEND` varchar(1000) NOT NULL COMMENT '확장자',
  `DEL_YN` varchar(1) NOT NULL COMMENT '삭제여부',
  `REG_ID` varchar(100) DEFAULT NULL COMMENT '등록자',
  `REG_DTM` datetime DEFAULT NULL COMMENT '등록일시',
  `UPD_ID` varchar(100) DEFAULT NULL COMMENT '수정자',
  `UPD_DTM` datetime DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`FILE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='파일관리마스터';

-- 테이블 데이터 jjplatform.file_manage:~0 rows (대략적) 내보내기

-- 테이블 jjplatform.logging_event 구조 내보내기
CREATE TABLE IF NOT EXISTS `logging_event` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
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
  PRIMARY KEY (`COMP_ID`,`EVENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='로그이벤트';

-- 테이블 데이터 jjplatform.logging_event:~0 rows (대략적) 내보내기

-- 테이블 jjplatform.logging_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `logging_info` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `SEQ` int(11) NOT NULL AUTO_INCREMENT COMMENT '순번',
  `LOG_CODE` varchar(10) NOT NULL COMMENT '로그코드',
  `LOG_MESS` text NOT NULL COMMENT '로그메세지',
  `LOG_CLASS` varchar(1000) NOT NULL COMMENT '에러클래스',
  `END_DT` varchar(100) NOT NULL COMMENT '종료일시',
  `REG_ID` varchar(10) DEFAULT NULL COMMENT '등록아이디',
  `REG_DTM` datetime DEFAULT NULL COMMENT '등록일시',
  `REG_IP` varchar(100) DEFAULT NULL COMMENT '등록아이피',
  `STRT_DT` varchar(100) NOT NULL COMMENT '시작일시',
  PRIMARY KEY (`SEQ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='로그정보';

-- 테이블 데이터 jjplatform.logging_info:~0 rows (대략적) 내보내기

-- 테이블 jjplatform.menu_manage 구조 내보내기
CREATE TABLE IF NOT EXISTS `menu_manage` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `UPPR_MENU_ID` varchar(100) DEFAULT NULL COMMENT '상위메뉴',
  `MENU_SEQ` bigint(20) NOT NULL COMMENT '메뉴순번',
  `MENU_ID` varchar(100) NOT NULL COMMENT '메뉴ID',
  `MENU_NM` varchar(200) DEFAULT NULL COMMENT '메뉴명',
  `USE_YN` varchar(1) DEFAULT NULL COMMENT '사용여부',
  `MENU_LVL1` varchar(1) DEFAULT NULL COMMENT '메뉴레벨1',
  `MENU_LVL2` varchar(1) DEFAULT NULL COMMENT '메뉴레벨2',
  `MENU_LVL3` varchar(1) DEFAULT NULL COMMENT '메뉴레벨3',
  `MENU_AUTH` varchar(10) DEFAULT NULL COMMENT '메뉴권한',
  `REG_ID` varchar(100) DEFAULT NULL COMMENT '등록자',
  `REG_DTM` datetime DEFAULT NULL COMMENT '등록일시',
  `UPD_ID` varchar(100) DEFAULT NULL COMMENT '수정자',
  `UPD_DTM` datetime DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`COMP_ID`,`MENU_SEQ`,`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='메뉴등록관리';

-- 테이블 데이터 jjplatform.menu_manage:~13 rows (대략적) 내보내기
INSERT IGNORE INTO `menu_manage` (`COMP_ID`, `UPPR_MENU_ID`, `MENU_SEQ`, `MENU_ID`, `MENU_NM`, `USE_YN`, `MENU_LVL1`, `MENU_LVL2`, `MENU_LVL3`, `MENU_AUTH`, `REG_ID`, `REG_DTM`, `UPD_ID`, `UPD_DTM`) VALUES
	('00000', 'ADM000M', 1, 'ADM001M', '주식입출금관리', 'Y', 'N', 'Y', 'N', '', 'admin', '2022-07-25 00:00:00', 'admin', '2022-07-25 00:00:00'),
	('00000', 'SYS000M', 1, 'MNU001M', '메뉴관리', 'Y', '', 'Y', '', 'S', NULL, NULL, NULL, NULL),
	('00000', 'SVC000M', 1, 'SVC001M', '서비스관리', 'Y', 'N', 'Y', 'N', '', 'admin', '2022-07-25 00:00:00', 'admin', '2022-07-25 00:00:00'),
	('00000', '', 1, 'SYS000M', '시스템', 'Y', 'Y', '', '', 'S', NULL, NULL, NULL, NULL),
	('00000', 'ADM000M', 2, 'ADM002M', '주식관리', 'Y', 'N', 'Y', 'N', '', 'admin', '2022-07-25 00:00:00', 'admin', '2022-07-25 00:00:00'),
	('00000', '', 2, 'SVC000M', '서비스', 'Y', 'Y', NULL, NULL, 'S', NULL, NULL, NULL, NULL),
	('00000', 'SYS000M', 2, 'USR001M', '사용자관리', 'Y', 'N', 'Y', 'N', '', 'admin', '2022-07-19 00:00:00', 'admin', '2022-07-19 00:00:00'),
	('00000', NULL, 3, 'ADM000M', '관리자만씀', 'Y', 'Y', 'N', 'N', '', 'admin', '2022-07-25 00:00:00', 'admin', '2022-07-25 00:00:00'),
	('00000', 'SYS000M', 3, 'COM000M', '공통코드', 'Y', 'N', 'Y', 'N', '', 'admin', '2022-07-19 00:00:00', 'admin', '2022-07-19 00:00:00'),
	('00000', NULL, 4, 'BOA000M', '게시판', 'Y', 'Y', 'N', 'N', '', 'admin', '2023-05-10 00:00:00', 'admin', '2023-05-10 00:00:00'),
	('00000', 'BOA000M', 5, 'BOA001M', '게시판', 'Y', 'N', 'Y', 'N', '', 'admin', '2023-05-10 00:00:00', 'admin', '2023-07-05 00:00:00'),
	('00000', NULL, 6, 'FAM000M', '스마트팜', 'Y', 'Y', 'N', 'N', '', 'admin', '2024-03-12 00:00:00', 'admin', '2024-03-12 00:00:00'),
	('00000', 'FAM000M', 7, 'FAM001M', '채소 팜', 'Y', 'N', 'Y', 'N', '', 'admin', '2024-03-12 00:00:00', 'admin', '2024-03-13 00:00:00');

-- 테이블 jjplatform.smart_farm_manage 구조 내보내기
CREATE TABLE IF NOT EXISTS `smart_farm_manage` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `FARM_CD` varchar(10) NOT NULL COMMENT '팜코드',
  `CROP_ID` varchar(10) NOT NULL COMMENT '작물ID',
  `CROP_SEQ` decimal(20,0) NOT NULL DEFAULT 0 COMMENT '작물순번',
  `CROP_NAME` varchar(200) DEFAULT NULL COMMENT '작물명',
  `CROP_STTUS` varchar(2) DEFAULT 'G' COMMENT '작물상태(F0001)[G:생장,B:과습,C:건조,W:응급,D:다이]',
  `CROP_CHECK_CD` varchar(2) DEFAULT NULL COMMENT '작물체크코드(F0002)[T:온도,H:습도,L:조도,W:물높이,P:용액희석]',
  `REAL_DATE_TIME` datetime DEFAULT NULL COMMENT '실시간체크일시',
  `CROP_FILE_ID` varchar(100) DEFAULT NULL COMMENT '파일아이디',
  `USE_YN` varchar(1) DEFAULT NULL COMMENT '사용여부',
  `REG_ID` varchar(100) DEFAULT NULL COMMENT '등록자',
  `REG_DTM` datetime DEFAULT NULL COMMENT '등록일시',
  `UPD_ID` varchar(100) DEFAULT NULL COMMENT '수정자',
  `UPD_DTM` datetime DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`FARM_CD`,`CROP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='스마트팜관리';

-- 테이블 데이터 jjplatform.smart_farm_manage:~0 rows (대략적) 내보내기

-- 테이블 jjplatform.stock_in_out_manage 구조 내보내기
CREATE TABLE IF NOT EXISTS `stock_in_out_manage` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `STOCK_APP_ID` varchar(10) NOT NULL COMMENT '주식앱아이디',
  `BANK_ID` varchar(10) NOT NULL COMMENT '거래은행아이디',
  `IN_OUT_DATE` varchar(8) NOT NULL COMMENT '입출금일자',
  `IN_AMT` bigint(10) DEFAULT NULL COMMENT '입금금액',
  `OUT_AMT` bigint(10) DEFAULT NULL COMMENT '출금금액',
  `REG_ID` varchar(100) DEFAULT NULL COMMENT '등록자',
  `REG_DTM` datetime DEFAULT NULL COMMENT '등록일시',
  `UPD_ID` varchar(100) DEFAULT NULL COMMENT '수정자',
  `UPD_DTM` datetime DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`COMP_ID`,`STOCK_APP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='주식입출금관리';

-- 테이블 데이터 jjplatform.stock_in_out_manage:~1 rows (대략적) 내보내기
INSERT IGNORE INTO `stock_in_out_manage` (`COMP_ID`, `STOCK_APP_ID`, `BANK_ID`, `IN_OUT_DATE`, `IN_AMT`, `OUT_AMT`, `REG_ID`, `REG_DTM`, `UPD_ID`, `UPD_DTM`) VALUES
	('00000', 'SHIN', '01', '20220726', 1000, 1000, 'admin', '2022-07-26 00:00:00', 'admin', '2022-07-26 00:00:00');

-- 테이블 jjplatform.stock_manage 구조 내보내기
CREATE TABLE IF NOT EXISTS `stock_manage` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `STOCK_APP_ID` varchar(10) NOT NULL COMMENT '주식앱아이디',
  `STOCK_ID` varchar(50) NOT NULL COMMENT '주식아이디',
  `SELL_BUY_CD` varchar(2) NOT NULL COMMENT '매입/매도코드',
  `SELL_BUY_DATE` varchar(8) NOT NULL COMMENT '매입/매도일자',
  `SELL_BUY_QTY` bigint(10) DEFAULT NULL COMMENT '매입/매도수량',
  `SELL_BUY__AMT` bigint(10) DEFAULT NULL COMMENT '매입/매도금액',
  `REG_ID` varchar(100) DEFAULT NULL COMMENT '등록자',
  `REG_DTM` datetime DEFAULT NULL COMMENT '등록일시',
  `UPD_ID` varchar(100) DEFAULT NULL COMMENT '수정자',
  `UPD_DTM` datetime DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`COMP_ID`,`STOCK_APP_ID`,`STOCK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='주식관리';

-- 테이블 데이터 jjplatform.stock_manage:~0 rows (대략적) 내보내기

-- 테이블 jjplatform.svc_manage 구조 내보내기
CREATE TABLE IF NOT EXISTS `svc_manage` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `SVC_SEQ` decimal(38,0) NOT NULL COMMENT '서비스순번',
  `SVC_ID` varchar(100) NOT NULL COMMENT '서비스ID',
  `SVC_NM` varchar(200) DEFAULT NULL COMMENT '서비스명',
  `PAK_PATH` varchar(200) DEFAULT NULL COMMENT '패키지명',
  `USE_YN` varchar(1) DEFAULT NULL COMMENT '사용여부',
  `SVC_DAO` varchar(100) DEFAULT NULL COMMENT '서비스DAO',
  `SVC_XML` varchar(100) DEFAULT NULL COMMENT '서비스XML',
  `REG_ID` varchar(100) DEFAULT NULL COMMENT '등록자',
  `REG_DTM` datetime DEFAULT NULL COMMENT '등록일시',
  `UPD_ID` varchar(100) DEFAULT NULL COMMENT '수정자',
  `UPD_DTM` datetime DEFAULT NULL COMMENT '수정일시',
  PRIMARY KEY (`COMP_ID`,`SVC_SEQ`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='서비스등록관리';

-- 테이블 데이터 jjplatform.svc_manage:~8 rows (대략적) 내보내기
INSERT IGNORE INTO `svc_manage` (`COMP_ID`, `SVC_SEQ`, `SVC_ID`, `SVC_NM`, `PAK_PATH`, `USE_YN`, `SVC_DAO`, `SVC_XML`, `REG_ID`, `REG_DTM`, `UPD_ID`, `UPD_DTM`) VALUES
	('00000', 1, 'Svc001Service', '서비스관리', 'com.jjplatform.admin.svc.service', 'Y', 'Svc001Dao', 'svc001_SQL', 'admin', '2022-07-25 00:00:00', 'admin', '2024-03-13 00:00:00'),
	('00000', 2, 'Mnu001Service', '메뉴관리', 'com.jjplatform.admin.menu.service', 'Y', 'Mnu001Dao', 'mnu001_SQL', 'admin', '2022-07-25 00:00:00', 'admin', '2024-03-13 00:00:00'),
	('00000', 4, 'Adm001Service', '주식입출금관리', 'com.jjplatform.admin.adm.service', 'Y', 'Adm001Dao', 'adm001_SQL', 'admin', '2022-07-25 00:00:00', 'admin', '2024-03-13 00:00:00'),
	('00000', 5, 'Adm002Service', '주식관리', 'com.jjplatform.admin.adm.service', 'Y', 'Adm002Dao', 'adm002_SQL', 'admin', '2022-07-26 00:00:00', 'admin', '2024-03-13 00:00:00'),
	('00000', 6, 'Usr001Service', '사용자관리', 'com.jjplatform.admin.user.service', 'Y', 'Usr001Dao', 'usr001_SQL', 'admin', '2022-07-26 00:00:00', 'admin', '2024-03-13 00:00:00'),
	('00000', 7, 'Com001Service', '공통코드', 'com.jjplatform.admin.com.service', 'Y', 'Com001Dao', 'com001_SQL', 'admin', '2022-07-26 00:00:00', 'admin', '2024-03-13 00:00:00'),
	('00000', 8, 'Boa001Service', '게시판', 'com.jjplatform.admin.board.service', 'Y', 'Boa001Dao', 'boa001_SQL', 'admin', '2023-07-05 00:00:00', 'admin', '2024-03-13 00:00:00'),
	('00000', 9, 'Fam001Service', '채소팜', 'com.jjplatform.admin.farm.service', 'Y', 'Fam001Dao', 'fam001_SQL', 'admin', '2024-03-13 00:00:00', 'admin', '2024-03-13 00:00:00');

-- 테이블 jjplatform.user_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_info` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `USER_ID` varchar(100) NOT NULL COMMENT '사용자ID',
  `USER_PASS` varchar(500) NOT NULL COMMENT '패스워드',
  `TEL_NO` varchar(12) NOT NULL COMMENT '전화번호',
  `EMAIL` varchar(200) NOT NULL COMMENT '이메일',
  `REG_ID` varchar(100) DEFAULT NULL COMMENT '등록자',
  `REG_DTM` datetime DEFAULT NULL COMMENT '등록시간',
  `REG_IP` varchar(20) DEFAULT NULL COMMENT '등록IP',
  `UPD_ID` varchar(100) DEFAULT NULL COMMENT '수정자ID',
  `UPD_DTM` datetime DEFAULT NULL COMMENT '수정일',
  `UPD_IP` varchar(20) DEFAULT NULL COMMENT '수정IP',
  PRIMARY KEY (`COMP_ID`,`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='사용자정보';

-- 테이블 데이터 jjplatform.user_info:~1 rows (대략적) 내보내기
INSERT IGNORE INTO `user_info` (`COMP_ID`, `USER_ID`, `USER_PASS`, `TEL_NO`, `EMAIL`, `REG_ID`, `REG_DTM`, `REG_IP`, `UPD_ID`, `UPD_DTM`, `UPD_IP`) VALUES
	('00000', 'admin', '$2a$10$SSCZO3zH8ooEakriNbM.EOG26sIcZVG5N445ba3ugMnE0XSXmDehq', '01045459806 ', 'whwncjs95@gmail.com', 'admin', NULL, NULL, NULL, NULL, NULL);

-- 테이블 jjplatform.user_role 구조 내보내기
CREATE TABLE IF NOT EXISTS `user_role` (
  `COMP_ID` varchar(5) NOT NULL COMMENT '소속회사',
  `USER_ID` varchar(100) NOT NULL COMMENT '사용자ID',
  `USER_ROLE` varchar(100) DEFAULT NULL COMMENT '사용자권한',
  PRIMARY KEY (`COMP_ID`,`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='사용자권한';

-- 테이블 데이터 jjplatform.user_role:~1 rows (대략적) 내보내기
INSERT IGNORE INTO `user_role` (`COMP_ID`, `USER_ID`, `USER_ROLE`) VALUES
	('00000', 'ADMIN', 'ROLE_ADMIN');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
