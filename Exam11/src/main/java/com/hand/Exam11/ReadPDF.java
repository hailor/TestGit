package com.hand.Exam11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class ReadPDF {

	public static void main(String[] args) {
		
		try {
			//创建一个URL
			URL url = new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");
			//打开链接
			URLConnection connection = url.openConnection();
			//获取connection的输入流
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			File file = new File("E:\\file.pdf");
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			String line;
			//StringBuilder builder = new StringBuilder();
			while((line = br.readLine()) != null){
				System.out.println(line);
				bw.write(line);
			}
			bw.flush();
			bw.close();
			osw.close();
			fos.close();
			br.close();
			isr.close();
			is.close();
			//System.out.println(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String readFile(){
		StringBuilder builder = new StringBuilder();
		try {
			//创建一个URL
			URL url = new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");
			//打开链接
			URLConnection connection = url.openConnection();
			//获取connection的输入流
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			String line;
			
			while((line = br.readLine()) != null){
				builder.append(line);
			}
			br.close();
			isr.close();
			is.close();
			System.out.println(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
}