package com.hand.Exam2_1;

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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//http://www.manning.com/gsmith/SampleChapter1.pdf
    	new Thread(new ReadByGet()).start();
    	System.out.println("下载中..");
    }
}

class ReadByGet implements Runnable {
	
	HttpClient client = HttpClients.createDefault();
	public void run() {
		HttpGet get = new HttpGet("http://www.manning.com/gsmith/SampleChapter1.pdf");
		try {
			
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
//			String result = EntityUtils.toString(entity, "UTF-8");
			byte b [] = EntityUtils.toByteArray(entity);
//			System.out.println(result);
			File newfile = new File("SampleChapter1.pdf");
			 FileOutputStream fis = new FileOutputStream (newfile);
//			 OutputStreamWriter isw = new OutputStreamWriter(fis);
//			 BufferedWriter bw = new BufferedWriter(isw);
			 fis.write(b);
			 fis.flush();
			 fis.close();
			 System.out.println("恭喜，下载完成！");
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
