package com.hand.Exam_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("开始下载文件！");

		try {
			URL url = new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");
			URLConnection urlConnection = url.openConnection();
			InputStream inputStream = urlConnection.getInputStream();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("file.pdf"));

			byte[] temp = new byte[10240];
			int length = 0;
			while ((length = bufferedInputStream.read(temp)) > 0) {
				bufferedOutputStream.write(temp);
				System.out.println(length);
			}

			bufferedOutputStream.flush();
			bufferedOutputStream.close();
			bufferedInputStream.close();
			inputStream.close();

			System.out.println("文件下载结束！");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("项目结束！");
		}
	}
}
