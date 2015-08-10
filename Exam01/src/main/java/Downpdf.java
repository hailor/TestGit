import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;





public class Downpdf {


	public static void main(String[] args) {
		int a =0; 
		try {
			//URL url = http://www.manning.com/gsmith/SampleChapter1.pdf;
			//File tfile =new File("http://www.manning.com/gsmith/SampleChapter1.pdf");

			URL url = new URL("http://www.manning.com/gsmith/SampleChapter1.pdf");
			URLConnection conn = url.openConnection();
			InputStream inStream = conn.getInputStream();
			FileOutputStream out_file = new FileOutputStream("new_pdf.pdf");

			byte[] buffer = new byte[102400];
			while ((a = inStream.read(buffer)) != -1) {
				out_file.write(buffer, 0, a);
			}
			out_file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
