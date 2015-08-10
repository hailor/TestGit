package com.hand.Exam_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;



public class ChatManagerClient {
	String IP;
	private ChatManagerClient(){}
	private static final ChatManagerClient instance = new ChatManagerClient();

	public static ChatManagerClient getChatManagerClient() {
		return instance;
	}

	MainWindow window ;
	Socket socket;
	BufferedReader reader;
	PrintWriter writer;
	ServerSocket serverSocket;
	public void setWindow(MainWindow window) {
		this.window = window;
		window.appendText("已绑定CHatManager！");
	}
	public void cennect(String ip){
		this.IP=ip;

		new Thread(){
			public void run() {
				try {
					socket = new Socket(IP, 1234);
					BufferedInputStream inputStream =new BufferedInputStream(socket.getInputStream());
					BufferedOutputStream outputStream =new BufferedOutputStream(new FileOutputStream("newSampleChapter1.pdf"));
					byte input[]=new byte[1000];
					while(inputStream.read(input) !=-1){
						outputStream.write(input);
					}
					inputStream.close();
					outputStream.close();
					window.appendText("收到：发来的文件");

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public  void send(String out){
		if(writer != null){
			writer.write(out+"\n");
			writer.flush();
		}else{
			window.appendText("当前连接中断！请重新连接！");
		}
	}
}
