package com.hand.Exam_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;




public class ServerListener extends Thread{

	public void run() {  
		try {
			
			ServerSocket serverSocket = new ServerSocket(1234);
			//accept 阻塞当前进程
			
			//建立连接
			while(true){
				Socket socket = serverSocket.accept();
			JOptionPane.showMessageDialog(null, "有客户连接到本机的1234端口");
			
			//將socket傳遞給新的線程
			ChatSocket cs = new ChatSocket(socket);
			cs.start();
			ChatManager.getChatManager().add(cs);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	   }
}
