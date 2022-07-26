package com.jjplatform.admin.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import ssg.cpbos.biz.contents.CommContents;
//import ssg.cpbos.biz.utils.CommonUtils;
//
//import com.ibm.icu.math.BigDecimal;
//import com.ibm.icu.text.SimpleDateFormat;

@SuppressWarnings("deprecation")
public class ComExcelHandler implements ResultHandler {
	protected static final Logger LOGGER = LoggerFactory.getLogger(ComExcelHandler.class);

	@SuppressWarnings({ "rawtypes", "unused" })
	private List<Map> returnList;
	private SXSSFWorkbook workbook;
	private SXSSFSheet sheet;
	private Font bodyFont;
	private int rownum = 0;
	private CellStyle bodyStyle;
	private String fontNm = "맑은 고딕";

	private long totCnt = 0;

	private static final int ROW_ACCESS_WINDOW_SIZE = 1000;

	private FileInputStream templateFile;
	private String templateFileName;
	private String templatePath;
	private String imsiTampPath;
	private String ext = "";
	private String menuPath = "";
	private String equalsVal = "";
	private int decimalNum = 0;
	private int firstRownum = 0;

    @SuppressWarnings("rawtypes")
	public ComExcelHandler(List<Map> returnList, Map param, long totCnt) {
        this.returnList = returnList;
        this.totCnt = totCnt;

        this.templatePath = (String) param.get("template");
//        this.imsiTampPath = (String) param.get("imsiTemp") + CommonUtils.getRegerUpder("ID") + "/";
        this.templateFileName = (String) param.get("FILE_NAME");

        // 호출메뉴
//        this.menuPath = CommonUtils.selMenuPath();

        // 소숫점 자릿수
        this.decimalNum =  Integer.parseInt(String.valueOf(param.get("DECIMAL_PLC") == null ? 0 : param.get("DECIMAL_PLC")));

        // 엑셀템플릿파일 지정 (지정안하고 빈 통합문서로도 가능)
        XSSFWorkbook xssfWorkbook = null;
        XSSFSheet originSheet = null;
        File chkPath = null;
        String[] extArr = {".xlsx",".xls"};

		try {
			// 엑셀 확장자 체크
			for(String extStr : extArr){
				chkPath = new File(templatePath + templateFileName + extStr);
				if(chkPath.exists()){
					this.ext =  extStr;
					break;
				}
			}

			this.templateFile = new FileInputStream(chkPath);
			xssfWorkbook = new XSSFWorkbook(templateFile);

			// 엑셀템플릿파일에 쓰여질 부분 검색
	        originSheet = xssfWorkbook.getSheetAt(0);

	        // 단일데이터매핑
//	        if(CommonUtils.selArrayStr(CommContents.getSlf002MCheck).contains(menuPath)) this.setOnlyDataMappin(originSheet.getRow(1), param);
	        this.rownum = originSheet.getLastRowNum();

	        // SXSSF 생성
	        this.workbook = new SXSSFWorkbook(xssfWorkbook, ROW_ACCESS_WINDOW_SIZE);
	        this.sheet = (SXSSFSheet) workbook.getSheetAt(0);

	        // 파일다운을 위한 리턴값
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("path", imsiTampPath);
	        map.put("name", templateFileName + ext);
	        map.put("env", (String) param.get("env"));
	        returnList.add(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	@SuppressWarnings("unchecked")
	@Override
	public void handleResult(ResultContext resultContext) {
		Map<String, Object> data = (Map<String, Object>) resultContext.getResultObject();
//		LOGGER.info(totCnt + " : "+data);

		if(MapUtils.isEmpty(data)) {
			return;
		}

		// body style
		if(firstRownum == 0){
			// 건물주보고양식일경우만 적용
//			if(CommonUtils.selArrayStr(CommContents.getSlf002MCheck).contains(menuPath)) firstRownum = rownum;
			bodyStyle =  bodyStyleSet();
		}

		// 엑셀 생성 호출
		this.write(rownum+1, bodyStyle, data);

		rownum++;
	}

	// body style
	public CellStyle bodyStyleSet(){
		bodyFont = workbook.createFont();
		bodyFont.setFontName(fontNm);

		CellStyle bodyStyle= workbook.createCellStyle();
		bodyStyle.setAlignment(CellStyle.ALIGN_LEFT);
		bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		bodyStyle.setFont(bodyFont);

		return bodyStyle;
	}

	// 엑셀 row 생성
	public void write(int currentRow, CellStyle style, Map<String, Object> data) {
    	SXSSFRow row = (SXSSFRow) sheet.createRow(currentRow);
    	SXSSFCell cell;
    	sheet.setDisplayGridlines(true);

    	// SUMMARY 병합처리
//		if(totCnt == (currentRow - firstRownum) && CommonUtils.selArrayStr(CommContents.MENU_SUMMARY).contains(menuPath)) sheet.addMergedRegion(new CellRangeAddress(currentRow, currentRow, 0, 2 ));

		List<String> keyName = new ArrayList<String>(data.keySet());

		int cellNum = 0;

		String keyVal = "";
		Boolean eFlag = true;
		for(int i=0; i < keyName.size(); i++){
			String key = keyName.get(i);
			cell = (SXSSFCell) row.createCell(cellNum);
			if(!"KEY_VAL".equals(key)) cell.setCellStyle(style);

//			if(CommonUtils.selArrayStr(CommContents.EQUALS_KEY).contains(key) && CommContents.getCtr004MCheck.equals(menuPath)) {
//				keyVal = keyVal + (("REQ_DATE".equals(key)) ? ((String) data.get(key)).replaceAll("-", "") : data.get(key));
//				if(equalsVal.equals(data.get("KEY_VAL"))) eFlag = false;
//			}else{
//				eFlag = true;
//			}

			// NULL 에러 처리
			String strType = (data.get(key) == null) ? "java.lang.String" : data.get(key).getClass().getName();
			String keyData = StringUtils.defaultString(String.valueOf((data.get(key) == null) ? "" : data.get(key)), "");
//			LOGGER.info(strType + " : "+key + " : "+keyData + " : "+(!strType.contains("String") && (CommContents.NUMBER_COLS.contains(key) || !CommContents.SLF002M.contains(key))));
			// 데이터 추출
//			if(!strType.contains("String") && (CommonUtils.selArrayStr(CommContents.NUMBER_COLS).contains(key) || !CommonUtils.selArrayStr(CommContents.SLF002M).contains(key))){
//				CellStyle numStyle = this.setStyleApply("NUM", totCnt == (currentRow - firstRownum));
//				cell.setCellStyle(numStyle);
//				cell.setCellValue(new BigDecimal(keyData).longValue());
//			}else{
//				if(!"KEY_VAL".equals(key) || this.getCenterCheck(menuPath, key)){
//					CellStyle centerStyle = this.setStyleApply("", totCnt == (currentRow - firstRownum));
//
//					if(this.getCenterCheck(menuPath, key)) centerStyle.setAlignment(CellStyle.ALIGN_CENTER);
//					cell.setCellValue((CommonUtils.selArrayStr(CommContents.EQUALS_KEY).contains(key) && !eFlag) ? "" : keyData);
//					if(this.getCenterCheck(menuPath, key)) cell.setCellStyle(centerStyle);
//				}
//			}

			if(cellNum == i) equalsVal = keyVal;

			cellNum++;
		}

		// 모든 row 완료
		if(totCnt == (currentRow - firstRownum)){
			try {
				// 임시폴더 계정별루 존재하지 않을경우 생성후 작업
				File tempFile = new File(imsiTampPath);
				if(!tempFile.exists()) tempFile.mkdirs();

				// 엑셀 파일 스트림 시작
        	    FileOutputStream stream = new FileOutputStream(imsiTampPath + templateFileName + ext);

        	    // 엑셀파일 생성
				download(stream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }

    // 엑셀파일 생성
    public void download(OutputStream stream) throws IOException{
        try {
        	workbook.write(stream);
    	} catch (Exception e) {
    		stream.flush();
    		stream.close();
    	} finally {
    		stream.flush();
    		stream.close();
        	if (workbook != null) {
        		workbook.dispose();
        	}
    	}
    }

    // center 정렬 메뉴별 체크
    public Boolean getCenterCheck(String menuPath, String key) {
//    	if(CommonUtils.selArrayStr(CommContents.getCtm002MCheck).contains(menuPath)) return CommonUtils.selArrayStr(CommContents.CTM002M).contains(key);
//    	if(CommonUtils.selArrayStr(CommContents.getCtr004MCheck).contains(menuPath)) return CommonUtils.selArrayStr(CommContents.CTR004M).contains(key);
//    	if(CommonUtils.selArrayStr(CommContents.getSlf002MCheck).contains(menuPath)) return CommonUtils.selArrayStr(CommContents.SLF002M).contains(key);
		return false;
    }

    // cell style 적용
    public CellStyle setStyleApply(String flag, Boolean bol){
    	CellStyle excelStyle = workbook.createCellStyle();
		//테두리 선 (우,좌,위,아래)
    	excelStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    	excelStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    	excelStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);

    	// 최종건 및 SUMMARY 일 경우
//    	if(bol && CommonUtils.selArrayStr(CommContents.MENU_SUMMARY).contains(menuPath)){
//    		excelStyle.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
//    		excelStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//    	}

//    	if("NUM".equals(flag)) excelStyle.setDataFormat(workbook.createDataFormat().getFormat(CommonUtils.getDeciamlLen(decimalNum).split(" ")[1]));
    	return excelStyle;
    }

    // 단일 데이터 매핑
    @SuppressWarnings("rawtypes")
	public void setOnlyDataMappin(XSSFRow row, Map param){
        XSSFCell cel0 = row.getCell(0);
        XSSFCell cel11 = row.getCell(11);

//        String salesDt = CommonUtils.getMessage("WORD1118") + " : " + (String) param.get("START_DT") + "~" + (String) param.get("END_DT");
//        String reqDt = CommonUtils.getMessage("WORD2936") + " : " + new SimpleDateFormat("yy/MM/dd").format(new Date());

//        cel0.setCellValue(salesDt);
//        cel11.setCellValue(reqDt);
    }
}

