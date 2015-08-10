package com.hand.Exam_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String args[]){
		
		try {
			System.out.println("客户端已经启动！");
			
			Socket socket = new Socket("127.0.0.1", 12345);
			
			InputStream inputStream = socket.getInputStream();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("files.pdf"));
			
			System.out.println("开始接收文件！");
			
			byte[] temp = new byte[1024];
			int length = 0;
			
			while((length=bufferedInputStream.read(temp))>0){
				bufferedOutputStream.write(temp);
			}
			
			bufferedOutputStream.close();
			bufferedInputStream.close();
			inputStream.close();
			
			System.out.println("文件接收成功！");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("项目结束！");
		}
		
	}

}
