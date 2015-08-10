package com.hand.Exam_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread{

Socket socket;
	
	public ChatSocket(Socket s){
		this.socket = s;
	}
	
	public void out(String out){
		try {
			socket.getOutputStream().write((out+"\n").getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {

		try {
			BufferedInputStream inputStream =new BufferedInputStream(new FileInputStream("SampleChapter1.pdf"));
			BufferedOutputStream outputStream =new BufferedOutputStream(socket.getOutputStream());
			byte input[]=new byte[1000];
			while(inputStream.read(input) !=-1){
				outputStream.write(input);
			}
			inputStream.close();
			outputStream.close();
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
