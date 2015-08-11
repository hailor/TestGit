package com.hand.WebExam1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		try {
			FileInputStream inputStream = new FileInputStream("SampleChapter1.pdf");
			BufferedInputStream bInputStream = new BufferedInputStream(inputStream);
			FileOutputStream outputStream = new FileOutputStream("newSampleChapter.pdf");
			BufferedOutputStream stream = new BufferedOutputStream(outputStream);
			
			byte input[] = new byte[30];

			while ((bInputStream.read(input)) != -1) {
				stream.write(input);
			}
			bInputStream.close();
			stream.close();
			inputStream.close();
			outputStream.close();
			
			System.out.println("读取完成，写入完成");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
