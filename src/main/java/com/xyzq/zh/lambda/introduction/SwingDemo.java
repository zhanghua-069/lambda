package com.xyzq.zh.lambda.introduction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingDemo {
	
	/**
	 * Lambda无需指定类型，若参数类型不言而明，则无需显示指定
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Java按钮组件示例"); // 创建Frame窗口
		frame.setSize(400, 200);
		JPanel jp = new JPanel(); // 创建JPanel对象
		JButton btn = new JButton("我是普通按钮"); // 创建JButton对象
		jp.add(btn);

		frame.add(jp);
		frame.setBounds(300, 200, 600, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				System.out.println("button clicked");
			}
		});*/
		
		// event是参数名，和上面匿名内部类示例中的是同一个参数
		// -> 将参数和Lambda表达式的主体分开，而主体是用户点击按钮时会运行的代码
		btn.addActionListener(event -> System.out.println("button clicked"));
	}

}
