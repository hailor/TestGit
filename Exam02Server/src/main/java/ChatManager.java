
import java.util.Vector;


public class ChatManager {
	//一个聊天服务器只能有一个聊天的Manager 即ChatManager
	//所以要把这个类做单例化的处理 
	private ChatManager(){}
	private static final ChatManager cm = new ChatManager();
	public static ChatManager getChatManager() {
		return cm;
	}
	//完成单例化

	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	public void add(ChatSocket chatSocket){
		vector.add(chatSocket);
	}

	public void publish(ChatSocket cs,String out){
		for (int i = 0; i < vector.size(); i++) {
			ChatSocket chatSocket = vector.get(i);
			if (!cs.equals(chatSocket)) {
				chatSocket.out(out);
			}


		}


	}
}
