package com.hand.Exam3;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.StringWriter;
import java.io.Writer;

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

class Get extends Thread{
	
	HttpClient client = HttpClients.createDefault();
	
	@Override
	public void run() {
		
		try {
			
			HttpGet get = new HttpGet("http://hq.sinajs.cn/list=sz300170");
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, "UTF-8");
			
			System.out.println(result);
			
			//XML
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element root = document.createElement("xml");
			
			Element lan = document.createElement("stock");
			Element name = document.createElement("name");
			name.setTextContent("汉得信息");
			Element open = document.createElement("open");
			open.setTextContent("20.00");
			Element close = document.createElement("close");
			close.setTextContent("19.40");
			Element current = document.createElement("current");
			current.setTextContent("21.13");
			Element high = document.createElement("high");
			high.setTextContent("21.34");
			Element low = document.createElement("low");
			low.setTextContent("19.54");
			
			lan.appendChild(name);
			lan.appendChild(open);
			lan.appendChild(close);
			lan.appendChild(current);
			lan.appendChild(high);
			lan.appendChild(low);
			
			root.appendChild(lan);
			
			document.appendChild(root);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			System.out.println(writer.toString());
			
			transformer.transform(new DOMSource(document), new StreamResult("XML.xml"));
			
			//JSON
			
//			JsonObject object = new JsonObject();
//			object.addProperty("cat", "it");
//			
//			JsonArray array = new JsonArray();
//			
//			JsonObject lan1 = new JsonObject();
//			lan1.addProperty("id", 1);
//			lan1.addProperty("ide", "Eclipse");
//			lan1.addProperty("name", "Java");
//			array.add(lan1);
//			
//			JsonObject lan2 = new JsonObject();
//			lan2.addProperty("id", 2);
//			lan2.addProperty("ide", "XCode");
//			lan2.addProperty("name", "Swift");
//			array.add(lan2);
//			
//			JsonObject lan3 = new JsonObject();
//			lan3.addProperty("id", 3);
//			lan3.addProperty("ide", "Visual Studio");
//			lan3.addProperty("name", "C#");
//			array.add(lan3);
//			
//			object.add("languages", array);
//			object.addProperty("pop", true);
//			
//			System.out.println(object.toString());
			
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}
	
}

public class App {

	public static void main(String[] args) {
		
		new Get().start();
		
	}

}
