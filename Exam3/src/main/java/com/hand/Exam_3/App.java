package com.hand.Exam_3;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

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

import com.google.gson.JsonObject;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("开始访问网址！");

		URL url;
		try {
			url = new URL("http://hq.sinajs.cn/list=sz300170");
			URLConnection urlConnection = url.openConnection();
			InputStream inputStream = urlConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String line;
			String result = "";
			while ((line = bufferedReader.readLine()) != null) {
				result = result + line;
			}

			System.out.println(result);

			String temp[] = result.split(",");

			// 创建xml節點
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			Element root = document.createElement("xml");
			Element stock = document.createElement("stock");
			// 創建json對象
			JsonObject jsonRoot = new JsonObject();

			for (int i = 0; i < temp.length; i++) {
				System.out.println(temp[i]);
				Element element = null;
				if (i == 0) {
					String strs[] = temp[i].split("\"");
					element = document.createElement("name");
					element.setTextContent(strs[1]);

					jsonRoot.addProperty("name", strs[1]);
				} else if (i == 1) {
					element = document.createElement("open");
					element.setTextContent(temp[i]);

					jsonRoot.addProperty("open", temp[i]);
				} else if (i == 2) {
					element = document.createElement("close");
					element.setTextContent(temp[i]);

					jsonRoot.addProperty("close", temp[i]);
				} else if (i == 3) {
					element = document.createElement("current");
					element.setTextContent(temp[i]);

					jsonRoot.addProperty("current", temp[i]);
				} else if (i == 4) {
					element = document.createElement("high");
					element.setTextContent(temp[i]);

					jsonRoot.addProperty("high", temp[i]);
				} else if (i == 5) {
					element = document.createElement("low");
					element.setTextContent(temp[i]);

					jsonRoot.addProperty("low", temp[i]);
				} else {
					element = document.createElement("其它" + i);
					element.setTextContent(temp[i]);

					jsonRoot.addProperty("其它" + i, temp[i]);
				}

				stock.appendChild(element);

			}
			root.appendChild(stock);
			document.appendChild(root);
			// 生成xml文件
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.transform(new DOMSource(document), new StreamResult(new File("result_xml.xml")));
			// 生成json文件
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
					new FileOutputStream("result_json.json"));
			bufferedOutputStream.write(jsonRoot.toString().getBytes());
			bufferedOutputStream.close();
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();

			System.out.println("数据写入文件完成！");
		} catch (MalformedURLException e) {
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
