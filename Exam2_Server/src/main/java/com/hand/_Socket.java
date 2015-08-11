package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class _Socket extends Thread {
	
	Socket socket;
	
	public _Socket(Socket s){
		this.socket = s;
	}
	
	public void out(String out) {
		try {
			socket.getOutputStream().write((out+"\n").getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("断开了一个客户端链接");
			Manager.getChatManager().remove(this);
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		out("你已经连接到本服务器了");
		try {
			
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("SampleChapter1.pdf"));
			BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
			byte[] b = new byte[1000];
			while (bis.read(b)!=-1) {
				bos.write(b);
			}
			bos.close();
			bis.close();
			
			System.out.println("断开了一个客户端链接");
			Manager.getChatManager().remove(this);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("断开了一个客户端链接");
			Manager.getChatManager().remove(this);
			e.printStackTrace();
		}
		
	}
}
