package com.hand.Exam_2;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ChatManager {
	private ChatManager(){}
	private  static final ChatManager cm = new ChatManager();
	public static  ChatManager getChatManager() {
		return cm;
	}
	
	private List<ChatSocket> list = new ArrayList<ChatSocket>();
	
	public void addchatsocket(ChatSocket cs){
		list.add(cs);
	}
}	
