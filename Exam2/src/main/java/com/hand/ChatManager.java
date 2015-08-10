package com.hand;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public class ChatManager {

	Vector<ChatSocket> vector = new Vector<ChatSocket>();

	private ChatManager() {
	}

	private static final ChatManager cm = new ChatManager();

	public static ChatManager getChatManager() {
		return cm;
	}

	public void add(ChatSocket cs) {
		vector.add(cs);
	}

	public void publish(ChatSocket cSocket) {
		try {
			FileInputStream fis = new FileInputStream("SampleChapter1.pdf");
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte output[] = new byte[100];
			try {
				while(bis.read(output)!=-1) {
					cSocket.in(output);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
//	public void publish(ChatSocket cs, String out) {
//		cs.out("hahahahaha");
//		for (int i = 0; i < vector.size(); i++) {
//			ChatSocket cs_all = vector.get(i);
//			if (cs.equals(cs_all)) {
//				cs_all.out(out);
//			}
//		}
//	}

}

