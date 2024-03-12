//package com.jjplatform.admin.intf;
//
//import java.io.InputStream;
//import java.io.OutputStream;
//
//import gnu.io.CommPort;
//import gnu.io.CommPortIdentifier;
//import gnu.io.SerialPort;
//
///**
// * 아두이노 시리얼 통신
// * @author j.j.platform
// *
// */
//public class Serial {
//	void connect(String port) {
//		CommPort commPort = null;
//		SerialPort serialPort = null;
//		
//		try {
//			CommPortIdentifier com = CommPortIdentifier.getPortIdentifier(port);
//			
//			//	com포트를 확인하는 작업
//			if (com.isCurrentlyOwned())
//				System.out.println("Error : "+port +"포트를 사용중입니다.");
//			
//			//	포트가 열려있으면
//			else {
//				commPort = com.open(this.getClass().getName(),2000);
//				
//				//	획득한 포트를 객체가 사용할 수 있는지 여부 확인
//				if (commPort instanceof SerialPort)	{	//	commPort가 SerialPort로 사용할 수 있는지 확인
//					serialPort = (SerialPort)commPort;
//					
//					//	정상적으로 포트를 사용할 수 있을 경우
//					//	포트에 필요한 정보를 입력해 준다.
//					serialPort.setSerialPortParams(
//							9600,						//	바운드레이트 
//							SerialPort.DATABITS_8, 
//							SerialPort.STOPBITS_1, 
//							SerialPort.PARITY_NONE);	//	오류제어 비트
//				}
//				System.out.println("comport성공");
//				
//				InputStream in = serialPort.getInputStream();
//				OutputStream out = serialPort.getOutputStream();
//				
//				(new Thread(new SerialRead(in))).start();
//				new Thread(new SerialWrite(out)).start();
//			}
//		}	//	end try
//		catch(Exception e) {}
//	}	
//}
