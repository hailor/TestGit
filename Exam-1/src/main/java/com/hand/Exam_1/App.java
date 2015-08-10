package com.hand.Exam_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.text.AbstractDocument.BranchElement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 FileInputStream fileInputStream;
		try {
			
			fileInputStream = new  FileInputStream("SampleChapter1.pdf");
			BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);	
			
			FileOutputStream fileOutputStream =new FileOutputStream("newSampleChapter1.pdf");
			BufferedOutputStream outputStream = new BufferedOutputStream(fileOutputStream);
			
			byte input[]=new byte[1000];
			while(inputStream.read(input) !=-1){
				outputStream.write(input);
			}
			
			System.out.println("读取写入完成！");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}



