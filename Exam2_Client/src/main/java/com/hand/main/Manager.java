package com.hand.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.hand.view.MainWindows;

public class Manager {

	private Manager() {
	}

	private static final Manager instance = new Manager();

	public static Manager getChatManager() {
		return instance;
	}

	MainWindows windows;
	String IP;
	Socket socket;
	
	public void setWindows(MainWindows windows) {
		this.windows = windows;
		windows.appendText("文本框已经和ChatManager绑定了。");
	}

	public void connect(String ip) {
		this.IP = ip;
		new Thread() {
			@Override
			public void run() {
				try {
					socket = new Socket(IP, 12345);
					
					BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("SampleChapter1.pdf"));
					byte[] b = new byte[1000];
					windows.appendText("开始接受服务端发送的文件...");
					System.out.println("开始接受服务端发送的文件...");
					while (bis.read(b)!=-1) {
						bos.write(b);
					}
					bos.close();
					bis.close();
					windows.appendText("文件接收完毕！");
					System.out.println("文件接收完毕！");
					
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}
