package com.hand.Exam_2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {
	Socket socket;
	public ChatSocket(Socket s) {
		this.socket	= s;
	}
	public void run() {
		try {
			FileInputStream fis = new FileInputStream(new File("SampleChapter1.pdf"));
			String line;
			int len=0,count=0;
			byte b[] = new byte[1024];
			while((len = fis.read(b)) != -1){	
				FileOutputStream fos = new FileOutputStream(new File("SampleChapter2.pdf"));
				fos.write(b,0,len);
				fos.flush();
				System.out.println(count++);
			}
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
