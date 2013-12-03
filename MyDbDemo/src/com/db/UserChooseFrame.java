package com.db;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class UserChooseFrame extends JFrame implements ActionListener {
	private JLabel lbWelcome = new JLabel("Welcome to the library system!");
	private JButton btMember = new JButton("Member Log In");
	private JButton btLibrarian = new JButton("Librarian Log In");
	
	public UserChooseFrame()
	{
		super("WELCOME");
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(lbWelcome);
		this.add(btMember);
		this.add(btLibrarian);
		this.setSize(300, 120);
		GUIUtil.toCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		btMember.addActionListener(this);
		btLibrarian.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btMember)
		{
			
			new MemberLogInFrame();
		}else if(e.getSource() == btLibrarian){
			this.dispose();
			new LibraryLogInFrame();
			
		}else
		{
			this.dispose();
			
		}
	}
	
	public static void main(String args[]){
		new UserChooseFrame();
	}

}
