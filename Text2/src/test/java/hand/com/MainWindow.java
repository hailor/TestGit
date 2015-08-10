package hand.com;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
//本项目主要是对客户端界面的设置
public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextArea txt;
	private JTextField ip;
	private JTextField send;
	

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txt = new JTextArea();
		txt.setText("");
		
		ip = new JTextField();
		ip.setText("127.0.0.1");
		ip.setColumns(10);
		
		//创建连接服务器按钮的监听
		JButton button = new JButton("\u8FDE\u63A5\u5230\u670D\u52A1\u5668");
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//将按钮绑定监听，当单击按钮时，调用ChatManager1的connect方法来连接服务器
				ChatManager1.getCM().connect(ip.getText());
			}
		});
		
		send = new JTextField();
		send.setText("");
		send.setColumns(10);
		
		JButton button_1 = new JButton("\u53D1\u9001");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//将按钮绑定，当单击按钮时，调用ChatManager1的send方法来发送数据
				ChatManager1.getCM().send(send.getText());;
				//发送完数据后换行
				appendTxt("我说："+send.getText());
				//将发送区域的内容设置为空
				send.setText("");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(ip, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(send, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
						.addComponent(txt, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(ip, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txt, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(send, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	public void appendTxt(String in){
		//调用系统的方法在窗口中输出
		txt.append(in+"\n");
	}
}
