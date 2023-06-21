package com.jjplatform.admin.intf;

public class Main {
	public static void main(String[] args) {
		try {
			(new Serial()).connect("COM6");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
