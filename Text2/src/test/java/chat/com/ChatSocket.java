package chat.com;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
//本项目为服务器类
class ChatSocket extends Thread{
	
	Socket socket;
	//获取传递过来的socket
	public ChatSocket(Socket s){
		this.socket=s;
	}
	//此方法为获取客户端发出的信息，并发送其他客户端
	public void out(String out){		
		try {
			//调用socket中的write方法来向客户端发送信息
			socket.getOutputStream().write(out.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {	
		try {
			//获取输入流
			BufferedReader br = new BufferedReader(
					               new InputStreamReader(
							           socket.getInputStream(), "UTF-8"));
			String line;
			while((line=br.readLine())!=null){
				//调用ChatManager类将读取到的客户端对象和编写的信息发送到聊天室中
				ChatManager.getChatManager().publish(this, line);
		    }
			//关闭输入流
			br.close();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	        
	}
	
}

