package com.hand;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
	     GetThread get = new GetThread();
	     get.start();
			
		}
		static class GetThread extends Thread{

			public void run() {
				try {
					
					
					URL url = new URL("http://hq.sinajs.cn/list=sz300170");
					URLConnection connection=url.openConnection();
					InputStream inputStream = connection.getInputStream();
					InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
					BufferedReader br = new BufferedReader(reader);
					
					String line;
					StringBuilder builder = new StringBuilder();
					while((line=br.readLine())!=null){
						builder.append(line);
						System.out.println("以下是原数据：");
				    	System.out.println(builder.toString());
						JsonObject object = new JsonObject();
						object.addProperty("name", "大秦铁路");
						object.addProperty("open", "27.55");
						object.addProperty("close", "27.25");
						object.addProperty("current", "26.91");
						object.addProperty("high", "27.55");
						object.addProperty("low", "26.20");
				    	DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
						DocumentBuilder builder1;
						builder1 = factory.newDocumentBuilder();
				    	Document document=(Document) builder1.newDocument();
				    	Element xml = document.createElement("xml");
				    	Element stock = document.createElement("stock");
				    	Element name = document.createElement("name");
				    	name.setTextContent("大秦铁路");
				    	Element open = document.createElement("open");
				    	open.setTextContent("27.55");
				    	Element close = document.createElement("close");
				    	close.setTextContent("27.25");
				    	Element current = document.createElement("current");
				    	current.setTextContent("26.91");
				    	Element high = document.createElement("high");
				    	high.setTextContent("27.55");
				    	Element low = document.createElement("low");
				    	low.setTextContent("26.20");
				    	xml.appendChild(stock);
				    	stock.appendChild(name);
				    	stock.appendChild(open);
				    	stock.appendChild(close);
				    	stock.appendChild(current);
				    	stock.appendChild(high);
				    	stock.appendChild(low);
				    	System.out.println();
				    	System.out.println("以下是xml格式数据：");
				    	NodeList clist=stock.getChildNodes();
						for (int j = 0; j < clist.getLength(); j++) {
							Node c=(Node) clist.item(j);
							if(c instanceof Element){
							System.out.println(c.getNodeName()+"="+c.getTextContent());
							}
						}
						TransformerFactory transformerFactory =TransformerFactory.newInstance();
						Transformer tranformer=transformerFactory.newTransformer();
						tranformer.transform(new DOMSource(document), new StreamResult(new File("test.xml")));
						System.out.println();
						System.out.println("以下是json格式数据：");
						System.out.println(object.toString());
						
					}
					br.close();
					reader.close();
					inputStream.close();
					
					
					
				} catch (MalformedURLException e) {
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
}
