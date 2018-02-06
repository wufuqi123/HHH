package cn.dati;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JTextArea;

public class HHUI {
	static class Monitor implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	if(isRun) {
	    		return;
	    	}
	    	jta.setText("正在搜索");
	    	isRun=true;
	    	long startTime=System.currentTimeMillis();
	    	RunP.run(new Callback() {
				
				@Override
				public void succeed(String content) {
					RunP.openDefaultBrowser(content);
					jta.setText("搜索成功，问题："+content+"\n"+"总耗时："+(System.currentTimeMillis()-startTime)+"毫秒");
					isRun=false;
				}
			});	   
	    }
	}
	public static JTextArea jta;
	public static boolean isRun=false;
	public static void main(String[] args) {
		 Frame f=new Frame("冲顶大会搜索神器");  
         f.setSize(500,400);  
         f.setLocation(300,200);  
         f.setLayout(new FlowLayout());   
         f.setBackground( Color.white);
         jta=new JTextArea();
         Button b=new Button("点击搜索");  
         f.add(b);  
         f.add(jta,BorderLayout.CENTER);  
         Monitor bh = new Monitor();
         b.addActionListener(bh);
         f.setVisible(true); 
         f.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(-1);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
}


