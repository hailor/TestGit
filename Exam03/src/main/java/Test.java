import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class Test{

	public static void main(String[] args) {

		new ReadByGet().start();//线程启动//调用了被静态生成的类ReadByGet 解决方法是在该类前增加关键字static
	}

	static class ReadByGet extends Thread {//定义线程
		public void run() {
			try {

				URL url = new URL(//定义url路径  指定网站下申请的api 返回xml格式
						"http://hq.sinajs.cn/list=sz300170");
				URLConnection connection = url.openConnection();//打开连接
				InputStream is = connection.getInputStream();//定义输入流
				InputStreamReader isr = new InputStreamReader(is);//包装is
				BufferedReader br = new BufferedReader(isr);//包装isr

				
				String line;
				StringBuilder builder = new StringBuilder();
				while ((line = br.readLine()) != null) {//
					builder.append(line);//将line的内容存进builder对象
				}
				br.close();
				isr.close();
				is.close();
				System.out.println(builder.toString());//输出url返回的xml数据
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder b = factory.newDocumentBuilder();
				Document document = b.newDocument();
				
				
				
				
				
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} 
		}

	}

}
