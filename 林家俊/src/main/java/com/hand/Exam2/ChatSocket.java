package com.hand.Exam2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ChatSocket extends Thread {

	Socket socket;

	public ChatSocket(Socket s) {
		this.socket = s;
	}

	@Override
	public void run() {
		try {
			FileInputStream fis = new FileInputStream("Simple.pdf");
			FileOutputStream fos = new FileOutputStream("New_Simple.pdf");
			byte input[] = new byte[50];
			while (fis.read(input) != -1) {
				fos.write(input);
			}

			// socket.getOutputStream().write(out.getBytes("UTF-8"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
