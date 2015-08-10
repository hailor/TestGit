package com.hand.Exam_2;

import java.nio.charset.Charset;
import java.util.Vector;

public class ChatManager {

	private ChatManager(){}
	private static final ChatManager cm = new ChatManager();
	public static ChatManager getChatManager(){
		return cm;
	}
	
	Vector<ChatSocket> vector = new Vector<ChatSocket>();
	
	public void add(ChatSocket cs){
		vector.add(cs);
	}
	
	public void publish(ChatSocket cs,String out){
		for (int i = 0; i < vector.size(); i++) {
			ChatSocket cSocket = vector.get(i);
			if(!cs.equals(cSocket)){
				cSocket.out(out);
			}
		}
	}
}
