package com.jjplatform.admin.util;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import java.io.*;

/**
 * 본 클래스는 압축하는데 필요한 소스이며, 압축과 압축해제를 동시에 다루는 클래스이다.
 * @author jskang
 */
public class Compress {
	private String[] fileList = null;
	int SIZE = 1024;

	/**
	 * 압축 메소드
	 * @param dirPath 압축할 파일이 모여있는 디렉토리 경로 (디렉토리안에있는 모든 파일 및 디렉토리를 압축함)
	 * @param outPath 압축파일을 생성할 디렉토리 경로
	 * @author jskang
	 */
	@SuppressWarnings("unused")
	public void compress(String dirPath){
		File file = new File(dirPath);
		if(!file.isDirectory()) {
			return;
		} else if(file == null) {
			return;
		}

		fileList = file.list();
		byte[] buf = new byte[SIZE];
		String outCompressName = dirPath+ "/zip/발주서다운로드.zip";

		FileInputStream fis = null;
		ZipArchiveOutputStream zos = null;
		BufferedInputStream bis = null;

		try {
			// Zip 파일생성
			if(!(new File(dirPath+"/zip").isDirectory())) new File(dirPath+"/zip").mkdir();
			zos = new ZipArchiveOutputStream(new BufferedOutputStream(new FileOutputStream(outCompressName)));
			for( int i=0; i < fileList.length; i++ ){
				//해당 폴더안에 다른 폴더가 있다면 지나간다.
				if( new File(dirPath+"/"+fileList[i]).isDirectory() ){
					continue;
				}
				//encoding 설정
				zos.setEncoding("UTF-8");

				//buffer에 해당파일의 stream을 입력한다.
				fis = new FileInputStream(dirPath + "/" + fileList[i]);
				bis = new BufferedInputStream(fis,SIZE);

				//zip에 넣을 다음 entry 를 가져온다.
				zos.putArchiveEntry(new ZipArchiveEntry(fileList[i]));

				//준비된 버퍼에서 집출력스트림으로 write 한다.
				int len;
				while((len = bis.read(buf,0,SIZE)) != -1){
					zos.write(buf,0,len);
				}

				bis.close();
				fis.close();
				zos.closeArchiveEntry();

			}
			zos.close();

		} catch(IOException e){
			e.printStackTrace();
		} finally{
			try {
				if (zos != null) {
					zos.close();
				}
				if (fis != null) {
					fis.close();
				}
				if (bis != null) {
					bis.close();
				}
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}