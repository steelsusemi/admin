SELECT *
FROM svc_manage;


SELECT *
FROM board_reply;

SELECT A.TOT_CNT
			 , A.RNUM
			 , A.COMP_ID
			 , A.SVC_SEQ
			 , A.SVC_ID
			 , A.SVC_NM
			 , A.PAK_PATH
			 , A.USE_YN
			 , A.SVC_DAO
			 , A.SVC_XML
			 , A.REG_ID
			 , A.REG_DTM
			 , A.UPD_ID
			 , A.UPD_DTM
			 , A.ROW_STATUS
		  FROM (
		       SELECT COUNT(*) OVER() AS TOT_CNT
			 		, ROW_NUMBER() OVER(ORDER BY SVC_SEQ ASC) AS RNUM
			 		, COMP_ID
			       	, SVC_SEQ
			       	, SVC_ID
			       	, SVC_NM
			       	, PAK_PATH
			       	, CASE WHEN USE_YN != 'Y' THEN 'N' ELSE USE_YN END AS USE_YN
			       	, SVC_DAO
			       	, SVC_XML
			       	, REG_ID
			        , DATE_FORMAT(REG_DTM, '%Y-%m-%d %T.%s') AS REG_DTM
			       	, UPD_ID
			       	, DATE_FORMAT(UPD_DTM, '%Y-%m-%d %T.%s') AS UPD_DTM
			       	, 'R' AS ROW_STATUS
		         FROM SVC_MANAGE
		   ) A
		   ORDER BY A.SVC_SEQ ASC limit 0, 10