package com.hand;

import java.io.BufferedReader;
import java.io.File;
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
			File file = new File("SampleChapter1.pdf");
			//获取从URL返回的响应信息
			InputStream is = connection.getInputStream();		//获取响应的输入流
			InputStreamReader isr = new InputStreamReader(is);	//包装成InputStreamReader
			BufferedReader br = new BufferedReader(isr);		//包装成BufferedReader
			String line = null;
			StringBuffer sbf = new StringBuffer();
			while ((line = br.readLine())!=null) {				//逐行读取信息
				sbf.append(line);								//读取行不位空时，将该行信息添加到StringBuffer中
			}
			
			br.close();											//关闭各输入流
			isr.close();
			is.close();
			
			System.out.println(sbf.toString());
			
	
		} catch(MalformedURLException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
