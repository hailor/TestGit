package com.hand.Exam_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class Gupiao {
	public static void main(String[] args) {
		new ReadHttp().start();
	}
	static class ReadHttp extends Thread{
		public void run() {
			try {
				URL url = new URL("http://hq.sinajs.cn/list=sh601006");
				URLConnection connection = url.openConnection();
				InputStream is = connection.getInputStream();
				InputStreamReader isr = new InputStreamReader(is,"GB2312");
				BufferedReader br = new BufferedReader(isr);

				String line = null;
				StringBuffer buffer = new StringBuffer();
				while ( (line = br.readLine())!=null) {
					buffer.append(line);
				}
				String[] split = buffer.toString().split(",");
				//生成XML文件	
				try {
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					Document document = builder.newDocument();

					Element root = document.createElement("xml");

					Element stock = document.createElement("stock");
					Element name = document.createElement("name");			
					name.setTextContent("大秦铁路");
					Element open = document.createElement("open");
					open.setTextContent(split[1]);
					Element close = document.createElement("close");
					close.setTextContent(split[2]);
					Element current = document.createElement("current");
					current.setTextContent(split[3]);
					Element high = document.createElement("high");
					high.setTextContent(split[4]);
					Element low = document.createElement("low");
					low.setTextContent(split[5]);


					stock.appendChild(name);
					stock.appendChild(open);
					stock.appendChild(close);
					stock.appendChild(current);
					stock.appendChild(high);
					stock.appendChild(low);

					root.appendChild(stock);

					document.appendChild(root);

					try {
						TransformerFactory factory2 = TransformerFactory.newInstance();
						Transformer transformer = factory2.newTransformer();
						transformer.transform(new DOMSource(document), new StreamResult(new File("Sina.xml")));

					} catch (TransformerConfigurationException e) {
						e.printStackTrace();
					} catch (TransformerFactoryConfigurationError e) {
						e.printStackTrace();
					} catch (TransformerException e) {
						e.printStackTrace();
					}
					//生成JSON
					JsonObject Object = new JsonObject();
					Object.addProperty("name", "大秦铁路");
					Object.addProperty("open", split[1]);
					Object.addProperty("close", split[2]);
					Object.addProperty("current", split[3]);
					Object.addProperty("high", split[4]);
					Object.addProperty("low", split[5]);
					
					File file = new File("Sina.json");
					FileOutputStream fos = new FileOutputStream(file);
					byte[] b = Object.toString().getBytes();
						fos.write(b,0,b.length);
					fos.close();
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				}
				br.close();
				isr.close();
				is.close();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
