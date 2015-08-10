package com.hand.secondExcam01;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class App 
{
    public static void main( String[] args )
    {
    	String str = "http://www.manning.com/gsmith/SampleChapter1.pdf";	
    	/**
    	使用程序从网上下载pdf, 网址为
    	http://www.manning.com/gsmith/SampleChapter1.pdf,保存
    	在本地,编程时使用带缓冲的读写,将需要保证保存后的pdf文
    	件能正常打开.
    	 *
    	 */
    	// 下载网络文件
     


        try {
        	URL url = new URL(str);
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
          //设置缓冲区为10KB
            BufferedInputStream br = new BufferedInputStream(inStream,10000);
            
            FileOutputStream fos = new FileOutputStream("SampleChapter1.pdf");
            BufferedOutputStream bos = new BufferedOutputStream(fos,10000);
            System.out.println("正在下载文件");
            byte[] input = new byte[10000];
            while ((br.read(input)) != -1) {
               bos.write(input);
	
            }
            bos.close();
            fos.close();
            br.close();
            inStream.close();
            
            System.out.println("文件已经下载完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	
    	
    	
    	

	}
	
	
    	
    		
    	
    	
} 
