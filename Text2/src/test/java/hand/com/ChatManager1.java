package hand.com;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
//本界面主要是用来管理socket
public class ChatManager1 {
	
	
	private ChatManager1(){}
	public static final ChatManager1 instance = new ChatManager1();
	public static ChatManager1 getCM(){
		return instance;
	}
	
	MainWindow window;
	String IP;
	Socket socket;
	BufferedReader reader;
	PrintWriter writer;
	
	public void setWindow(MainWindow window) {
		this.window = window;
		window.appendTxt("文本框ChatWindow绑定了。");
	}
	//创建一个连接服务器的方法
	public void connect(String ip){
		this.IP=ip;
		new Thread(){
			public void run() {
				try {
					//通过IP和端口建立连接
					socket = new Socket(IP, 333);
					writer = new PrintWriter(
							     new OutputStreamWriter(
									socket.getOutputStream()));
					reader = new BufferedReader(
							    new InputStreamReader(
									socket.getInputStream()));
					String line;
					//循环输出读取到的数据
					while((line=reader.readLine())!=null){
						window.appendTxt("收到："+line);
					}
					//关闭相应的数据流操作
					writer.close();
					reader.close();
					writer = null;
					reader = null;
					
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	//创建一个发送数据的方法
	public void send(String out){
		
		if(writer!=null){
			writer.write(out+"\n");
			writer.flush();
		}else{
			window.appendTxt("你已经断开连接");
		}
			
		}

}
