package com.hand.test.TestExam3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
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
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ReadXml {

	public static void main(String[] args) {
		try {
			
			
			URL url = new URL("http://hq.sinajs.cn/list=sz300170");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"GBK");
			BufferedReader bis = new BufferedReader(isr);
//			OutputStream os = connection.getOutputStream();
//			BufferedOutputStream bos = new BufferedOutputStream(os);
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
			
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder bulider = factory.newDocumentBuilder();
			Document document=bulider.newDocument();
			Element stock=document.createElement("stock");
			
			Element name = document.createElement("name");
			name.setTextContent(str);
			
			Element open = document.createElement("open");
			open.setTextContent(str1);
			
			Element close = document.createElement("close");
			close.setTextContent(str2);
			
			Element current = document.createElement("current");
			current.setTextContent(str3);
			
			Element hight = document.createElement("hight");
			hight.setTextContent(str4);
			
			Element low = document.createElement("low");
			low.setTextContent(str5);
			
			
			stock.appendChild(name);
			stock.appendChild(open);
			stock.appendChild(close);
			stock.appendChild(current);
			stock.appendChild(hight);
			stock.appendChild(low);
			document.appendChild(stock);
			
			TransformerFactory transformerfactory = TransformerFactory.newInstance();
			Transformer transformer = transformerfactory.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			System.out.println(writer.toString());
			transformer.transform(new DOMSource(document), new StreamResult(new File("hand.xml")));
			
			bis.close();
			isr.close();
			is.close();
			
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
