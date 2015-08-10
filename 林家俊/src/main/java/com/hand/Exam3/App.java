package com.hand.Exam3;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class App {

	public static void main(String[] args) {
		new Get().start();
	}

}


class Get extends Thread {
	
	HttpClient client = HttpClients.createDefault();
	
	public void run() {
		HttpGet get = new HttpGet("http://hq.sinajs.cn/list=sz300170");
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			String result = EntityUtils.toString(entity,"UTF-8");
//			ystem.out.println(result);
			String resultHandle = result.substring(21, result.length()-2);
			String[] resultArray = resultHandle.split(",");
//			for (int i = 0; i < resultHandle.split(",").length; i++) {
//				System.out.println(resultHandle.split(",")[i]);
//			}
			
			System.out.println("---------------以下生成json---------------------");
			CreateJson cj = new CreateJson(resultArray);
			cj.newJson();
			System.out.println("----------以下生成xml-------------------");
			CreateXml cx = new CreateXml(resultArray);
			cx.newXml();
			System.out.println("-------------------------------");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



