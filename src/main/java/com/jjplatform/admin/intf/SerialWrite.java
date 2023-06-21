package com.jjplatform.admin.intf;

import java.io.IOException;
import java.io.OutputStream;

public class SerialWrite implements Runnable {
	OutputStream out;
	
	public SerialWrite(OutputStream out) {this.out = out;}
	
	@Override
	public void run() 
	{
		int c = 0;
		
		try 
		{
			while ((c = System.in.read()) > -1)
			{
				out.write(c);
			}
		} catch (IOException e) {e.printStackTrace();}
	}
}
