package com.hand;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.XMLWriter;

import com.google.gson.JsonObject;


public class Exam3 {
	public static void main(String[] args) {
		new ReadByHttpGet().start();
	}
}

class ReadByHttpGet extends Thread {

	// 创建一个HttpClient对象
	HttpClient client = HttpClients.createDefault();

	@Override
	public void run() {

		String url = "http://hq.sinajs.cn/list=sz300170";
		HttpGet get = new HttpGet(url); // 定义HttpGet对象访问URL
		try {

			HttpResponse response = client.execute(get); // 执行get,获取响应
			HttpEntity entity = response.getEntity(); // 从响应response中获取消息实体
			String result = EntityUtils.toString(entity, "UTF-8").trim(); // 将实体entity转换为指定编码的字符串
			int beginIndex = result.indexOf('"');
			int endIndex = result.lastIndexOf('"');
			String s = result.substring(beginIndex + 1, endIndex);			// System.out.println(s );
			String mess[] = s.split(",");
			
			System.out.println("结果如下：\n");
			//解析并生成XML文件
			creatXML(mess);
			//解析并生成JSON文件
			createJSON(mess);
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void creatXML(String[] mess) {
		try {
			String xml = "<xml>"
					+ "<stock>"
						+ "<name>"+mess[0]+"</name>"
						+ "<open>"+mess[1]+"</open>"
						+ "<close>"+mess[2]+"</close>"
						+ "<current>"+mess[3]+"</current>"
						+ "<high>"+mess[4]+"</high>"
						+ "<low>"+mess[5]+"</low>"
					+ "</stock>"
				+ "</xml>";
			Document document = DocumentHelper.parseText(xml);
			String fileName = "hand.xml";
            System.out.println("Writing file: " + fileName);
            FileWriter out;
			out = new FileWriter(fileName);
			XMLWriter writer = new XMLWriter(out);
			writer.write(document);
			out.close();		
			System.out.println(document.asXML());
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void createJSON(String[] json) {
		// 开始创建JSON对象

				JsonObject object = new JsonObject();

				object.addProperty("name", json[0]);
				object.addProperty("open", json[1]);
				object.addProperty("close", json[2]);
				object.addProperty("current", json[3]);
				object.addProperty("high", json[4]);
				object.addProperty("low", json[5]);


				String fileName = "hand.json";
	            System.out.println("\nWriting file: " + fileName);
	            
				try {
					FileWriter out = new FileWriter(fileName);
					BufferedWriter writer = new BufferedWriter(out);					
					writer.write(object.toString());
					writer.flush();
					writer.close();
					out.close();		
					System.out.println(object.toString());
					// JSON对象创建完成
				} catch (IOException e) {
					e.printStackTrace();
				}


	}
}