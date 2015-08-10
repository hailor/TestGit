package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// try {
		// URL url = new
		// URL("http://www.manning.com/gsmith/SampleChapter1.pdf");
		// URLConnection connection = url.openConnection();
		// InputStream inputStream = connection.getInputStream();
		//
		// BufferedInputStream bis = new BufferedInputStream(inputStream,80000);
		//
		// FileOutputStream fos = new FileOutputStream("SampleChapter1.pdf");
		// BufferedOutputStream bos = new BufferedOutputStream(fos,80000);
		//
		// byte[] input = new byte[17000];
		//
		// System.out.println("Running...");
		// while (bis.read(input) != -1) {
		// bos.write(input);
		// }
		// bos.close();
		// fos.close();
		// bis.close();
		// inputStream.close();
		//
		// System.out.println("Finish!");
		//
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// } catch (MalformedURLException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		try {
			FileInputStream fis = new FileInputStream("SampleChapter1.pdf");
			BufferedInputStream bis = new BufferedInputStream(fis, 100000);
			FileOutputStream fos = new FileOutputStream("New_SampleChapter1.pdf");
			BufferedOutputStream bos = new BufferedOutputStream(fos, 100000);

			byte[] input = new byte[10000];
			long before = System.currentTimeMillis();
			int count = 0;
			while (bis.read(input) != -1) {
				bos.write(input);
				count++;
			}
			fis.close();
			bis.close();
			fos.close();
			bos.close();
			System.out.println(count);
			System.out.println(System.currentTimeMillis() - before);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
