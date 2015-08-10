import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ServerListerner extends Thread {

	@Override
	public void run() {

		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			while (true) {
				//ServerSocket 后的参数范为可以是1-65535

				Socket socket = serverSocket.accept();//每当有人访问serverScoket时accpet函数就会返回一个值给scoket对象
				JOptionPane.showMessageDialog(null, "有人連接12345端口"); 
				//運行程序的情況下    瀏覽器地址欄輸入127.0.0.1:12345 		
				//新建一个线程 ，因为每个socket接收到信号时都要去独立的客户端进行独立的通讯   即有人访问12345端口时
				//将scoket传递到新线程
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().add(cs);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
