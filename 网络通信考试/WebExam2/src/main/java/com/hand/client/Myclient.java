package com.hand.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Myclient  {
	Socket socket;
	PrintWriter out;
	public Myclient() {
			try {
				socket = new Socket("127.0.0.1", 12345);
				BufferedInputStream bi = new BufferedInputStream(socket.getInputStream());
				FileOutputStream fos = new FileOutputStream("new.pdf");
				BufferedOutputStream stream = new BufferedOutputStream(fos);
				byte input[] = new byte[30];
				while (bi.read()!=-1) {
					stream.write(input);
				}
				
				stream.close();
				fos.close();
				out.close();
				System.out.println("写入成功");
			} catch (IOException e) {
			}
	}

	public static void main(String[] args) {
		new Myclient();
	}
}
