package com.db;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchFrame extends JFrame implements ActionListener {
	
	private String user;

	private JLabel lbWelcome;
	private JLabel lbSearch = new JLabel("TYPE IN TO SEARCH");
	private JTextField tfWords = new JTextField(30);
	private JButton btSearch = new JButton("SEARCH");
	private JButton btAdSearch = new JButton("CLICK HERE FOR ADVANCED SEARCH");
	
	public SearchFrame(String user)
	{
		super("SEARCH");
		this.setLayout(new FlowLayout());
		this.user = user;
		lbWelcome = new JLabel("Hello, " + user);
		this.add(lbWelcome);
		this.add(lbSearch);
		this.add(tfWords);
		this.add(btSearch);
		this.add(btAdSearch);
		this.setSize(400, 150);
		GUIUtil.toCenter(this);
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			this.dispose();
			new SearchResultFrame(tfWords.getText(), user);
		}
		else
		{
			this.dispose();
			new AdvancedSearchFrame(user);
		}
	}
	


}
