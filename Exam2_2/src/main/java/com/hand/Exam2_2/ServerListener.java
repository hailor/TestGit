package com.hand.Exam2_2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListener implements Runnable {
	public void run() {
		try {
			// port:1~65535
			ServerSocket serverSocket = new ServerSocket(34334);
			int count = 1;
			while(true){
				Socket socket = serverSocket.accept();// 阻塞线程，直至有连接
				System.out.println("服务器：有客户端连接:"+(count++));

				//将socket传递给通信线程
				SengSocket ss = new SengSocket(socket);
				new Thread(ss).start();
			}

		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
}
class SengSocket implements Runnable{
	private Socket socket;
	public SengSocket(Socket s){
		this.socket = s;
	}
	public void run() {
		OutputStream os;
		try {
			
			os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			byte[] data = new byte[2000000];
			File obfile = new File("../Exam2_1/SampleChapter1.pdf");//二进制文件名：test.dat
	        BufferedInputStream instream;
	        try {
	            instream = new BufferedInputStream(new FileInputStream(obfile));
	            try {
//	                instream.read(data);
	                bw.write(instream.read(data));
	                instream.close();
	            } catch (IOException ex) {
	            }
	        } catch (FileNotFoundException ex) {
	        }
			
			
			System.out.println("已发送");
			bw.flush();
			
			bw.close();
			osw.close();
			os.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}


