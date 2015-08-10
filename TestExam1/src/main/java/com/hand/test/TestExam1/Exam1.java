package com.hand.test.TestExam1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Exam1 {

	public static void main(String[] args) {
		try {
			
			
			URL url = new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");
			URLConnection connection = url.openConnection();
			
			InputStream is= connection.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			FileOutputStream fos=new FileOutputStream(new File("new.pdf"));
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			byte[] input=new byte[100];
			int l;
			while((l=bis.read(input))>0){
				bos.write(input,0,l);
			}
			bis.close();
			is.close();
			bos.close();
			fos.close();
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
