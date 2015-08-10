package chat.com;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
//本项目用来创建服务器
class ServerListener extends Thread{
	@SuppressWarnings("resource")
	public void run() {
		try {	
	      //绑定监听器端口
			ServerSocket serverSocket = new ServerSocket(333);
			while(true){
				//使线程处于阻塞状态
				Socket socket = serverSocket.accept();
				//当客户浏览服务器端口时被调用，建立连接
				JOptionPane.showConfirmDialog(null,"有客户连接到了服务器");
				//当客户发出请求之后调用，通过新的线程建立一个客户端
				ChatSocket cs =new ChatSocket(socket);
				cs.start();
				//调用管理线程的ChatManager类，实现客户端之间的通信
				ChatManager.getChatManager().add(cs);
			}
			
		} catch (IOException e) {
			e.printStackTrace();}
	}
}
