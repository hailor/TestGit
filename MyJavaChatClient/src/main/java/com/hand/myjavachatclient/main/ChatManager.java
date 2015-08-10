package com.hand.myjavachatclient.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.SocketFactory;

import com.hand.myjavachatclient.view.MainWindow;

public class ChatManager {
	private  ChatManager() {}
	private static final ChatManager instance = new ChatManager();
	public static ChatManager getChatManager() {
		return instance;
	}
	//单例化
	MainWindow window;	
	Socket socket;
	String ip1;
	BufferedReader reader;
	PrintWriter writer;

	public void setWindow(MainWindow window) {
		this.window = window;
	}

	public void connect(String ip) {
		  ip1 = ip;
		new Thread(){
			@Override
			public void run() {
				try {
					socket = new Socket(ip1, 12345);
					
					File file = new File("../Exam02Server/new_pdf.pdf");
					FileInputStream fis = new FileInputStream(file);
					InputStreamReader isr = new InputStreamReader(fis);
					BufferedReader br = new BufferedReader(isr);
					
					FileOutputStream fos = new FileOutputStream("new_pdf.pdf");
					OutputStreamWriter osw = new OutputStreamWriter(fos);
					PrintWriter pw =new PrintWriter(osw,true);
					
					String input;
					while ((input = br.readLine())!= null) {
						pw.println(input);
					}
					
					System.out.println("下载完成");
					window.appendText("下载完成");
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void send() {
		if (writer != null) {
			writer.write(" ");
			writer.flush();
		}
		else{
			window.appendText("当前的连接已经中断");
		}

	}

}
