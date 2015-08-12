package com.hand.Exam2_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

	public static void main(String[] args) {
		new Thread(new Connection()).start();
	}

}

class Connection implements Runnable{

	public void run() {
		try {
			
			Socket socket = new Socket("127.0.0.1", 34334);
			InputStream is = socket.getInputStream();
			InputStreamReader inr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(inr);
			byte b[] = new byte[2000000];
			 
			 
			 File newfile = new File("SampleChapter1.pdf");
			 FileOutputStream fis = new FileOutputStream (newfile);
			 fis.write(is.read(b));
			 fis.flush();
			 fis.close();
			
			
			br.close();
			inr.close();
			is.close();
			System.out.println("接收完毕");
			socket.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
