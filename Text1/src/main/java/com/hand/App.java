package com.hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class App{
	public static void main(String[] args) {
	     GetThread get = new GetThread();
	     get.start();
		}
		static class GetThread extends Thread{
			public void run() {
				try {
					URL url = new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");
					URLConnection connection=url.openConnection();
					InputStream inputStream = connection.getInputStream();
					InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
					BufferedReader br = new BufferedReader(reader);
					
					String line;
					StringBuilder builder = new StringBuilder();
					while((line=br.readLine())!=null){
						builder.append(line);
					}
					br.close();
					reader.close();
					inputStream.close();
					
//					System.out.println(builder.toString());
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
			}
				
		}
	}
}
    

