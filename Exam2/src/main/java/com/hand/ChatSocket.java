package com.hand;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {
	Socket socket;
	String filename = "SampleChapter1_1.pdf";
	FileOutputStream fos;
	BufferedOutputStream bos;

	public ChatSocket(Socket socket) {
		this.socket = socket;
	}

//	public void out(String out) {
//		try {
//			socket.getOutputStream().write(out.getBytes("UTF-8"));
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	public void in (byte[] input) {
		try {
			 fos = new FileOutputStream(filename);
			 bos = new BufferedOutputStream(fos);
			bos.write(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = br.readLine())!=null) {
				ChatManager.getChatManager().publish(this);
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

