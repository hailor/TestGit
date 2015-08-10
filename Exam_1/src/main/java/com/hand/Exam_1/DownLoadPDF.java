package com.hand.Exam_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

public class DownLoadPDF {

	public static void main(String[] args) {
		new ReadHttp().start();
	}
	static class ReadHttp extends Thread{
		public void run() {
			try {
				URL url = new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");
				URLConnection connection = url.openConnection();
				InputStream is = connection.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				
				File file = new File("SampleChapter1.pdf");
				FileOutputStream fos = new FileOutputStream(file);				
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(osw);
				
				String line = null;
				int len=0;
				byte b[] = new byte[1024];
				while((len = is.read(b)) != -1){	
					fos.write(b,0,len);
				}
				JOptionPane.showMessageDialog(null, "下载完毕！");
				fos.close();
				is.close();
				//System.out.println(buffer.toString());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
