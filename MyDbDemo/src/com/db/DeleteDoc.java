package com.db;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DeleteDoc extends JFrame implements ActionListener {
	
	private String user;

//	private JLabel lbWelcome;
	private JLabel lbDelete = new JLabel("TYPE IN ITEM_ID TO DELETE");
	private JTextField tfWords = new JTextField(30);
	private JButton btSearch = new JButton("DELETE THE DOC");
	private JButton btAdSearch = new JButton("RETURN");
	
	public DeleteDoc(String user)
	{
		super("Delete a Copy");
		this.setLayout(new FlowLayout());
	this.user = user;
//		lbWelcome = new JLabel("Hello, " + user);
//		this.add(lbWelcome);
	    this.add(lbDelete);
		this.add(tfWords);
		this.add(btSearch);
		this.add(btAdSearch);
		this.setSize(400, 150);
		GUIUtil.toCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		btSearch.addActionListener(this);
		btAdSearch.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == btSearch)
		{			
			try{
				administration ad = new administration(tfWords.getText());
			
			ad.deleting();			
		}catch(Exception exc)
		{
			JOptionPane.showMessageDialog(this, "Fail!");
		}
		JOptionPane.showMessageDialog(this, "Delete successfully!");
			}
		else
		{
			this.dispose();
			new LibraryActionFrame(user);
		}
	}	

}
