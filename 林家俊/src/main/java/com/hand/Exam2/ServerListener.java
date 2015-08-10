package com.hand.Exam2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerListener extends Thread {
	@Override
	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			// 阻塞线程 block
			while (true) {
				Socket socket = serverSocket.accept();
				JOptionPane.showMessageDialog(null, "已经有用户连接12345端口");
				// 将socket传递给新的线程
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
