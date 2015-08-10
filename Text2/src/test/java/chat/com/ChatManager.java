package chat.com;
import java.util.Vector;
//本项目主要是将新建的线程管理起来，并且实现它们之间的通信，就好比一个聊天室
public class ChatManager {
	//将ChatManger单例化，每个客户端互相之间是独立的
	private ChatManager(){}
	private static final ChatManager cm = new ChatManager();
	public static ChatManager getChatManager(){
		return cm;
	}
	//用集合保存客户端对象并添加到集合当中
	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	public void add(ChatSocket cs){
		vector.add(cs);
	}
	//此方法作用为发送信息
	public void publish(ChatSocket cs,String out){
		for(int i=0;i<vector.size();i++){
	    //通过集合，便利输出所有客户端发送的信息到聊天室中
		ChatSocket csChatSocket = vector.get(i);
		if(!cs.equals(csChatSocket)){
			//回调客户端的out方法发送信息
			csChatSocket.out(out+"\n");
			
		}
		}
	}

}
