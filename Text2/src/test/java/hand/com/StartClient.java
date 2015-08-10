package hand.com;

import java.awt.EventQueue;

public class StartClient {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    //通过创建一个MainWindow来启动一个客户端
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					ChatManager1.getCM().setWindow(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
