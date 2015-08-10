package com.hand.Exam13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class App {
    public static void main( String[] args ){
    	new ReadByGet().start();
    }
}
    
class ReadByGet extends Thread{
	@Override
	public void run(){
		try {
			/**
			 * 1、new URL() 创建一个URL
			 * 2、URLConnection url.openConnection() 打开连接
			 * 3、InputStream connection.getInputStream() 获取connection的输入流
			 */
			//创建一个URL
			URL url = new URL("http://hq.sinajs.cn/list=sh601006");
			//打开链接
			URLConnection connection = url.openConnection();
			//获取connection的输入流
			InputStream is = connection.getInputStream();
			//若有乱码，则指定编码格式为UTF-8
			InputStreamReader isr = new InputStreamReader(is,"GBK");
			BufferedReader br = new BufferedReader(isr);
			
			String line;
			StringBuilder builder = new StringBuilder();
			while((line = br.readLine()) != null){
				builder.append(line);
			}
			br.close();
			isr.close();
			is.close();
			System.out.println(builder.toString());
			String a[] = builder.toString().split(",");
			String b[] = a[0].split("\"");
			/*String result = "<xml><stock>";
			
			result ="<name>"+b[1]+"</name>";
			result += "<open>"+a[1]+"</open>";
			result += "<close>"+a[2]+"</close>";
			result += "<current>"+a[3]+"</current>";
			result += "<high>"+a[4]+"</high>";
			result += "<low>"+a[5]+"</low>";
			result += "</stock></xml>";*/
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = factory.newDocumentBuilder();
			Document document = dbuilder.newDocument();
			Element xml = document.createElement("xml");
			Element stock = document.createElement("stock");
			Element name = document.createElement("name");
			Element open = document.createElement("open");
			Element close = document.createElement("close");
			Element current = document.createElement("current");
			Element high = document.createElement("high");
			Element low = document.createElement("low");
			name.setTextContent(b[1]);
			open.setTextContent(a[1]);
			close.setTextContent(a[2]);
			current.setTextContent(a[3]);
			high.setTextContent(a[4]);
			low.setTextContent(a[5]);
			stock.appendChild(name);
			stock.appendChild(open);
			stock.appendChild(close);
			stock.appendChild(current);
			stock.appendChild(high);
			stock.appendChild(low);
			xml.appendChild(stock);
			document.appendChild(xml);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult(new File("test.xml")));
		
			JsonObject object = new JsonObject();
			
			object.addProperty("name", b[1]);
			object.addProperty("open", a[1]);
			object.addProperty("close", a[2]);
			object.addProperty("current", a[3]);
			object.addProperty("high", a[4]);
			object.addProperty("low", a[5]);
			
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("text.json"))));
			bw.write(object.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}