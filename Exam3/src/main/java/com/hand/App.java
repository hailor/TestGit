package com.hand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;

import javax.swing.JScrollBar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		try {

			HttpClient client = HttpClients.createDefault();
			HttpGet get = new HttpGet("http://hq.sinajs.cn/list=sz300170");
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity, "UTF-8");
			String[] array = result.split(",");
			String[] temp = array[0].split("\"");
			array[0] = temp[1];

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element root = document.createElement("xml");

			Element stock = document.createElement("stock");

			Element name = document.createElement("name");
			name.setTextContent(array[0]);
			Element open = document.createElement("open");
			open.setTextContent(array[1]);
			Element close = document.createElement("close");
			close.setTextContent(array[2]);
			Element current = document.createElement("current");
			current.setTextContent(array[3]);
			Element high = document.createElement("high");
			high.setTextContent(array[4]);
			Element low = document.createElement("low");
			low.setTextContent(array[5]);

			stock.appendChild(name);
			stock.appendChild(open);
			stock.appendChild(close);
			stock.appendChild(current);
			stock.appendChild(high);
			stock.appendChild(low);
			root.appendChild(stock);
			document.appendChild(root);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream("New_xml.xml")));
			
			System.out.println("xml文件生成完毕！");
			
			JsonObject object = new JsonObject();
			object.addProperty("name", array[0]);
			object.addProperty("open", array[1]);
			object.addProperty("close", array[2]);
			object.addProperty("current", array[3]);
			object.addProperty("high", array[4]);
			object.addProperty("low", array[5]);
//			System.out.println(object.toString());
			
			FileOutputStream fos = new FileOutputStream("New_json.json");
			byte[] b = new byte[100];
			b = object.toString().getBytes();
			fos.write(b);
			fos.close();
			
			System.out.println("json文件生成完毕！");

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
