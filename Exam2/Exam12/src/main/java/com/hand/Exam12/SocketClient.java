package com.hand.Exam12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient extends Thread{

	BufferedWriter bw;
	BufferedReader br;
	Socket s;
	
	public static void main(String[] args) {
		try {
			Socket s = new Socket("127.0.0.1",8088);
			new SocketClient(s).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public SocketClient(Socket s){
		this.s = s;
	}
	
	public void run(){
		try {
			OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream(),"UTF-8");
			bw = new BufferedWriter(osw);
			InputStreamReader isr = new InputStreamReader(s.getInputStream(),"UTF-8");
	        br = new BufferedReader(isr);
	        bw.write(s.getLocalPort()+"：客户端连接成功\n");
        	bw.flush();
	        
	        String line;
	        while((line = br.readLine()) != null){
        		System.out.println("ok");
        		System.out.println(line);
	        }
        }catch (Exception e) {
			e.printStackTrace();
		}
	}
}