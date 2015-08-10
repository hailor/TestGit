package com.hand;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {
	@Override
	public void run() {
		//1-65535
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			while (true) {
				//block
				Socket socket = serverSocket.accept();
				//建立连接
				JOptionPane.showMessageDialog(null, "有客户端链接到了本机的12345端口");
				//将socket传递给新的线程
				_Socket cs = new _Socket(socket);
				cs.start();
				Manager.getChatManager().add(cs);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
