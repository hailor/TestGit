package com.hand;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			while (true) {
				// block
				Socket socket = serverSocket.accept();
				// 建立连接
				JOptionPane.showMessageDialog(null, "有用户访问了本机的1234端口");
				//为连接进来的client创建一个ChatSocket03对象,并开启其线程，使其工作
				ChatSocket chatSocket = new ChatSocket(socket);	
				chatSocket.start();
				//将新的Client加入到管理中
				ChatManager.getChatManager().add(chatSocket);
			}
//				serverSocket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}
}

