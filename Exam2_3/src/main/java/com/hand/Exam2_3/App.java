package com.hand.Exam2_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new Thread(new ReadByGet()).start();
    }
}

class ReadByGet implements Runnable{
	 public void run() {
		 try {
			URL url = new URL("http://hq.sinajs.cn/list=sz300170");
			URLConnection connection = url.openConnection();
			
			InputStream is = connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is,"GBK"); //设置编码格式
			BufferedReader br = new BufferedReader(isr);
			
			String message[] = br.readLine().split(",",7);
			String line[] = message[0].split("\"");
			message[0] = line[1];
			createXML(message);
			createJSON(message);
			
			br.close();
			isr.close();
			is.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 
	 public void createJSON(String message[]){
		 	JsonObject root = new JsonObject();
		 	
		 	root.addProperty("name", message[0]);
		 	root.addProperty("open", message[1]);
		 	root.addProperty("close", message[2]);
		 	root.addProperty("current", message[3]);
		 	root.addProperty("high", message[4]);
		 	root.addProperty("low", message[5]);
		 	
		 	try {
		 	File newfile = new File("hand.json");
			 FileOutputStream fis = new FileOutputStream (newfile);
			 OutputStreamWriter isw = new OutputStreamWriter(fis);
			 BufferedWriter bw = new BufferedWriter(isw);
			 
			 
				bw.write(root.toString());
				bw.close();
				 isw.close();
				 fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
	 
	 public void createXML(String message[]){
		 try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.newDocument();
				
				Element xml = document.createElement("xml");
				Element stock = document.createElement("stock");
				
					Element n1 = document.createElement("name");
					n1.setTextContent(message[0]);
					stock.appendChild(n1);
				
					Element n2 = document.createElement("open");
					n2.setTextContent(message[1]);
					stock.appendChild(n2);
					
					Element n3 = document.createElement("close");
					n3.setTextContent(message[2]);
					stock.appendChild(n3);
					
					Element n4 = document.createElement("current");
					n4.setTextContent(message[3]);
					stock.appendChild(n4);
					
					Element n5 = document.createElement("high");
					n5.setTextContent(message[4]);
					stock.appendChild(n5);
					
					Element n6 = document.createElement("low");
					n6.setTextContent(message[5]);
					stock.appendChild(n6);
					
					xml.appendChild(stock);
				document.appendChild(xml);
				
				//-----输出
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				//以文件输出
				transformer.transform(new DOMSource(document), new StreamResult("hand.xml")); 
				
				
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
	 }
}
