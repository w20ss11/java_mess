package defaultPack;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.FutureTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;


public class Server extends JFrame {
	private static final long serialVersionUID = 1L;
	static ServerSocket tcpSocket=null;
	String id="";
	private static JTextArea work_state=new JTextArea();
	private static JTextPane current_result=new JTextPane();
	private static ImageIcon icon0 = new ImageIcon("src\\com\\server\\main\\wuren.png");
	private static ImageIcon icon1 = new ImageIcon("src\\com\\server\\main\\youren.png");
	private static JLabel deng = new JLabel();

	public  Server(){
		setFont(new Font("Dialog", Font.PLAIN, 17));

		this.init();
	}
	public void init(){
		//删除D盘下所有txt文件
		//deleteTxt();
		this.setTitle("入侵检测服务器端");
		this.setBounds(100,100,563,388);
		this.createUI();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void createUI(){
		JPanel panel=new JPanel();
		//添加边框
		Border border=BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		TitledBorder tBorder=BorderFactory.createTitledBorder(border,"校验面板",TitledBorder.CENTER,TitledBorder.TOP);
		panel.setBorder(tBorder);
		panel.setLayout(null);
		getContentPane().add(panel);
		//网卡地址
		JLabel nameLbl=new JLabel("服务端工作状态：");
		nameLbl.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		nameLbl.setBounds(10,28,201,25);
		panel.add(nameLbl);

		JLabel label = new JLabel("\u5F53\u524D\u7ED3\u679C\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		label.setBounds(118, 305, 106, 25);
		panel.add(label);
		current_result.setFont(new Font("宋体", Font.PLAIN, 18));

		current_result.setBounds(225, 300, 193, 32);
		panel.add(current_result);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 521, 235);
		panel.add(scrollPane);
		work_state.setFont(new Font("Monospaced", Font.PLAIN, 20));

		scrollPane.setViewportView(work_state);


		deng.setBounds(475, 12, 42, 41);
		deng.setIcon(icon0);
		panel.add(deng);
	}


	public static void main(String[] args) throws Exception
	{

		Server sw=new Server();
		sw.setVisible(true);
		

		tcpSocket = new ServerSocket(10046);
		System.out.println("开启服务端");
		work_state.setText("\r\n"+work_state.getText());

	}

}

