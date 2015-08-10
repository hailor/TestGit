package com.hand.Exam_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			System.out.println("服务器已经开启！");
			
			ServerSocket serverSocket = new ServerSocket(12345);
			
			Socket socket = serverSocket.accept();
			
			System.out.println("有客户端连接到服务器！开始发送文件！");
			
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("SampleChapter1.pdf"));
			
			OutputStream outputStream = socket.getOutputStream();
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
			
			byte[] temp = new byte[1024];
			int length=0;
			while((length=bufferedInputStream.read(temp))>0){
				bufferedOutputStream.write(temp);
				System.out.println(length);
			}
			
			bufferedOutputStream.close();
			outputStream.close();
			bufferedInputStream.close();
			
			System.out.println("文件发送完成！");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("项目结束！");
		}
		
	}

}
