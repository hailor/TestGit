package com.hand.Exam3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXml {
	
	String[] result;
	
	public CreateXml(String[] str) {
		this.result = str;
	}
	
	public void newXml(){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element root = document.createElement("stock");
			
			Element lan1 = document.createElement("name");
			lan1.setTextContent(result[0]);
			
			Element lan2 = document.createElement("open");
			lan2.setTextContent(result[1]);
			
			Element lan3 = document.createElement("close");
			lan3.setTextContent(result[2]);
			
			Element lan4 = document.createElement("current");
			lan4.setTextContent(result[3]);
			
			Element lan5 = document.createElement("high");
			lan5.setTextContent(result[4]);
			
			Element lan6 = document.createElement("low");
			lan6.setTextContent(result[5]);
			
			root.appendChild(lan1);
			root.appendChild(lan2);
			root.appendChild(lan3);
			root.appendChild(lan4);
			root.appendChild(lan5);
			root.appendChild(lan6);
			
			document.appendChild(root);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			FileOutputStream fos = new FileOutputStream("newXml.xml");
			byte[] b = writer.toString().getBytes("UTF-8");
			fos.write(b);
			fos.close();
			System.out.println(writer.toString());
			
			
			}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
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
