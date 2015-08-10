package com.hand.secondExam03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

import com.google.gson.JsonObject;

/**
 Sina 股票数据接口,以大秦铁路（股票代码：601006）为
例，如果要获取它的最新行情，只需访问新浪的股票数据
接口：http://hq.sinajs.cn/list=sh601006这个url会返回
一串文本，例如：
var	 hq_str_sh601006="大秦铁路,	 27.55,	 27.25,	 26.91,	
27.55,	26.20,	26.91,	26.92,
22114263,	589824680,	4695,	26.91,	57590,	26.90,	14700,	
26.89,	14300,
26.88,	 15100,	 26.87,	 3100,	 26.92,	 8900,	 26.93,	 14230,	
26.94,	25150,	26.95,	15220,	26.96,	2008-01-11,	15:05:32";
这个字符串由许多数据拼接在一起，不同含义的数据用逗
号隔开了，顺序号从0开始。
0：” 大 秦 铁 路 ”， 股 票 名 字 ；name
1：”27.55″，今日开盘价；open
2：”27.25″，昨日收盘价；close
3：”26.91″，当前价格；current
4：”27.55″，今日最高价；high
5：”26.20″，今日最低价；low
编程访问http://hq.sinajs.cn/list=sz300170	 ,解释所得到的数
据,并将生成XML数据文件和JSON文件,并保存到本地,如:	
2
xml数据:
<xml>
<stock>
<name>xxxxx</name>
<	open	>xxxxx</	open	>
……
</stock>
</xml>
json数据:
{name:”xxx”,open:xxxx……}
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	new ReadByGet().start();
    	
    }
    
   
    
    //获取数据方法
    static class  ReadByGet extends Thread{
    	@Override
    	public void run() {
    		try {
				URL url = new URL("http://hq.sinajs.cn/list=sz300170");
				URLConnection connection =  url.openConnection();
				InputStream is = connection.getInputStream();
				InputStreamReader isr = new InputStreamReader(is,"GBK");
				BufferedReader br = new BufferedReader(isr);
				
				String line;
				StringBuilder builder = new StringBuilder();
				while ((line = br.readLine()) != null) {
					builder.append(line);
				}
				br.close();
				isr.close();
				is.close();
//				System.out.println(builder.toString());
				String str = builder.toString();
				String[] list = str.split(",");
		
		    	//验证数组是否正确存储
//		    	for (int i = 0; i < list.length; i++) {
//					System.out.println(list[i]);
//				}
		    	
				//创建XML文本
		    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder2 = factory.newDocumentBuilder();
				Document document = builder2.newDocument();
				Element root = document.createElement("stock");
				
//				0：” 大 秦 铁 路 ”， 股 票 名 字 ；name
//				1：”27.55″，今日开盘价；open
//				2：”27.25″，昨日收盘价；close
//				3：”26.91″，当前价格；current
//				4：”27.55″，今日最高价；high
//				5：”26.20″，今日最低价；low
				
				Element name0 = document.createElement("name");
				name0.setTextContent(list[0]);
				Element name1 = document.createElement("open");
				name1.setTextContent(list[1]);
				Element name2 = document.createElement("close");
				name2.setTextContent(list[2]);
				Element name3 = document.createElement("current");
				name3.setTextContent(list[3]);
				Element name4 = document.createElement("high");
				name4.setTextContent(list[4]);
				Element name5 = document.createElement("low");
				name5.setTextContent(list[5]);
				
				root.appendChild(name0);
				root.appendChild(name1);
				root.appendChild(name2);
				root.appendChild(name3);
				root.appendChild(name4);
				root.appendChild(name5);
				document.appendChild(root);
				
//				System.out.println(list[0]);
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				StringWriter writer= new StringWriter();
				transformer.transform(new DOMSource(document), new StreamResult(writer));
//				System.out.println(writer.toString());
				transformer.transform(new DOMSource(document), new StreamResult(new File("hand.xml")));
				
				//创建JSON文本{name:”xxx”,open:xxxx……}
				JsonObject object = new JsonObject();
				object.addProperty("name", list[0]);
				object.addProperty("open", list[1]);
				object.addProperty("close", list[2]);
				object.addProperty("current", list[3]);
				object.addProperty("high", list[4]);
				object.addProperty("low", list[5]);
				
//				System.out.println(object.toString());
				
				File file =new File("hand.json");
		    	if(!file.exists()){
		    		try {
						file.createNewFile();
					} catch (IOException e) {
						e.printStackTrace();
					}
		    		try {
						FileOutputStream fos = new FileOutputStream(file);
						byte output[] = object.toString().getBytes();
						fos.write(output);
						
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    		
		    		
		    	}
				
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
