package com.hand.Exam_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
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
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new ReadByGet().start();
    }
}
class ReadByGet extends Thread{
	@Override
	public void run() {
		
		try {
			
			URL url = new URL("http://hq.sinajs.cn/list=sz300170");
		    
			URLConnection urlConnection =url.openConnection();
			
			InputStream iyu =urlConnection.getInputStream();
			
			InputStreamReader irs = new InputStreamReader(iyu,"gb2312");
			
			BufferedReader rs = new BufferedReader(irs);
			
			String line;
			
			StringBuilder builder = new StringBuilder();
			while((line=rs.readLine())!=null){
				builder.append(line);
			}
			rs.close();
			irs.close();
			iyu.close();
			System.out.println(builder.toString());
			
			List<String> list =new ArrayList<String>();
			String inof = builder.toString();
			String in[]=inof.split(",");
			String ins[]=in[0].split("\"");
		    
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = factory.newDocumentBuilder();
			Document document = dbuilder.newDocument();
			Element root =document.createElement("stock");
			Element name=document.createElement("name");
			name.setTextContent(ins[1]);
			Element open=document.createElement("open");
			open.setTextContent(in[1]);
			Element close=document.createElement("close");
			close.setTextContent(in[2]);
			Element current=document.createElement("current");
			current.setTextContent(in[3]);
			Element high=document.createElement("high");
			high.setTextContent(in[4]);
			Element low=document.createElement("low");
			low.setTextContent(in[5]);
			root.appendChild(name);
			root.appendChild(open);
			root.appendChild(close);
			root.appendChild(current);
			root.appendChild(high);
			root.appendChild(low);
			document.appendChild(root);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StringWriter writer =new StringWriter();
			transformer.transform(new DOMSource(document), new StreamResult(writer));
			System.out.println(writer.toString());
			transformer.transform(new DOMSource(document), new StreamResult(new File("hd.xml")));
			JsonObject object =new JsonObject();
			object.addProperty("name", ins[1]);
			object.addProperty("open", in[1]);
			object.addProperty("close", in[2]);
			object.addProperty("current", in[3]);
			object.addProperty("high", in[4]);
			object.addProperty("low", in[5]);
			System.out.println(object.toString());
			File jsonfile =new File("jsonhd.json");
			FileOutputStream fos = new FileOutputStream(jsonfile);
			OutputStreamWriter osw =new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(object.toString());
			bw.close();
			osw.close();
			fos.close();
			System.out.println("保存成功！");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
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