package com.hand.Exam_2;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class SocketListener extends Thread {

	public void run() {
		try {
			ServerSocket serverSocket = new ServerSocket(13579);
			while(true){
				Socket socket = serverSocket.accept();
				JOptionPane.showMessageDialog(null, "客户端已登录，正在接收文件...");
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().addchatsocket(cs);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
