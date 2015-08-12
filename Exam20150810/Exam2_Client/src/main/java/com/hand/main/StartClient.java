package com.hand.main;

import java.awt.EventQueue;

import com.hand.view.MainWindows;

public class StartClient {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindows frame = new MainWindows();
					frame.setVisible(true);
					Manager.getChatManager().setWindows(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
