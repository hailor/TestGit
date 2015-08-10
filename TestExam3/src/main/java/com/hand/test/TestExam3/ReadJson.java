package com.hand.test.TestExam3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ReadJson {

	public static void main(String[] args) {
		try {
			
			
			
			URL url = new URL("http://hq.sinajs.cn/list=sz300170");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"GBK");
			BufferedReader bis = new BufferedReader(isr);
//		OutputStream os = connection.getOutputStream();
//		BufferedOutputStream bos = new BufferedOutputStream(os);
			StringBuilder builder = new StringBuilder();
			
			
			String line;
			while ((line=bis.readLine())!=null){
				builder.append(line);
			}
			System.out.println(builder.toString());
			
			String str = builder.substring(21, 25);
//			System.out.println(str);
			String str1 = builder.substring(26, 32);
//			System.out.println(str1);
			String str2 = builder.substring(33, 39);
//			System.out.println(str2);
			String str3 = builder.substring(40, 46);
//			System.out.println(str3);
			String str4 = builder.substring(47, 53);
//			System.out.println(str4);
			String str5 = builder.substring(54, 60);
//			System.out.println(str5);
			String str6 = builder.substring(61, 67);
//			System.out.println(str6);
			
			
			JsonObject object = new JsonObject();
			object.addProperty("name", str);
			object.addProperty("open", str1);
			object.addProperty("close", str2);
			object.addProperty("current", str3);
			object.addProperty("high", str4);
			object.addProperty("low", str5);
			
			System.out.println(object.toString());
			
			File file =new File("hand.json");
			
			
			
			
			OutputStream os= new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			
			String line1 = object.toString();
			
			bw.write(line1);
			
			bw.close();
			osw.close();
			os.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
