package com.hand.Exam12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer extends Thread{
	
	List<BufferedWriter> list_out = new ArrayList<BufferedWriter>();
	BufferedWriter bw;
	BufferedReader br;
	public static void main(String[] args) {
		new SocketServer().start();
	}
	
	public void run(){
		try {
			ServerSocket ss = new ServerSocket(8088);
			Socket s;
			while(true){
				s = ss.accept();
				OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream(),"UTF-8");
				bw = new BufferedWriter(osw);
		        list_out.add(bw);
		        bw.write("服务器：连接服务器成功\n");
		        bw.flush();
		        InputStreamReader isr = new InputStreamReader(s.getInputStream(),"UTF-8");
		        br = new BufferedReader(isr);
				String line;
				while((line = br.readLine()) != null){
					System.out.println(line);
				}
				readFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFile(){
		File file = new File("file.pdf");
		if(file.exists()){
			try {
				//字节流
				FileInputStream fis = new FileInputStream(file);
				//字符流（字节流向字符流转换的时候，要指定编码，否则会乱码）
				InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				
				String line;
				while((line = br.readLine()) != null){
					//System.out.println(line);
					bw.write(line);
				}
				br.close();
				isr.close();
				fis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}