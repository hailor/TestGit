package com.hand.Server;

import java.io.*;
import java.net.*;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class ServerSo {
	private ServerSocket ss;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	public ServerSo() {
		try

		{
			ss = new ServerSocket(12345);

			while (true) {
				socket = ss.accept();
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);
				JOptionPane.showMessageDialog(null, "有客户端连接到1234端口");
				FileInputStream inputStream = new FileInputStream("SampleChapter1.pdf");
				BufferedOutputStream ows = new BufferedOutputStream(socket.getOutputStream());
				BufferedInputStream bInputStream = new BufferedInputStream(inputStream);
				byte input[] = new byte[30];

				while ((bInputStream.read(input)) != -1) {
					ows.write(input);
				}
				
//				String line = in.readLine();
//				out.println("you input is :" + line);
//				out.close();
//				in.close();
//				socket.close();
			}
		} catch (

		IOException e)

		{
		}

	}

	public static void main(String[] args) {
		new ServerSo();
	}


}
