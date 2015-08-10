package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Exam1 {

	public static void main(String[] args) {
		
		/*
		 *  通过统一资源定位器（java.net.URL）获取连接器（java.net.URLConnection）
		 *  设置请求的参数
		 *  发送请求
		 *  以输入流的形式获取返回内容
		 *  关闭输入流
		 */
		
		try {
			String str = "http://www.manning.com/gsmith/SampleChapter1.pdf";
			URL url = new URL(str);			//访问的URL
			URLConnection connection = url.openConnection();	//打开URL，得到响应
			String fileName = "SampleChapter1.pdf";
			System.out.println("\nStart Writing file: " + fileName);
			System.out.println("\nWriting...");
			//获取从URL返回的响应信息
			InputStream is = connection.getInputStream();		//获取响应的输入流
			BufferedInputStream bis = new BufferedInputStream(is,1000);
//			BufferedReader br = new BufferedReader(bis);
			
//			InputStreamReader isr = new InputStreamReader(is);	//包装成InputStreamReader
//			BufferedReader br = new BufferedReader(isr);		//包装成BufferedReader
			
			FileOutputStream fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos,1000);
//			BufferedWriter bw = new BufferedWriter(bos);
			byte input[] = new byte[100];
			
			while(bis.read(input)!=-1) {
				bos.write(input); 
			}
//			FileWriter out = new FileWriter(fileName);
//			BufferedWriter writer = new BufferedWriter(out);
			
			
//			String line = null;
//			StringBuffer sbf = new StringBuffer();
//			while ((line = br.readLine())!=null) {				//逐行读取信息
//				writer.write(line);
//				sbf.append(line);								//读取行不位空时，将该行信息添加到StringBuffer中
//			}
//			writer.flush();
			
			//关闭输出流
//			writer.close();
//			br.close();
			//关闭各输入流
//			out.close();		
//			isr.close();
			bos.close();
			fos.close();
			bis.close();
			is.close();
			System.out.println("\nFinish Writing file: " + fileName);
		} catch(MalformedURLException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
