package com.hand.Exam2_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket implements Runnable{
	Socket socket;
	public ChatSocket (Socket s){
		this.socket = s;
	}
	
	/*
	 * 在本连接输出信息
	 */
	public void out(String outString){
		try {
			
			this.socket.getOutputStream().write(outString.getBytes("UTF-8"));
//			socket.close();
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		//读取当前的输入
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader inr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(inr);
			String line;
			while((line = br.readLine()) != null){
//				ChatManager.getChatManager().publish(this, line);
			}
			
			br.close();
			inr.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
