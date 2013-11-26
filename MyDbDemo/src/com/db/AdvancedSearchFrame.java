package com.db;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AdvancedSearchFrame extends JFrame implements ActionListener {
	
	private JLabel lbTitle = new JLabel("SEARCH BY TITLE: ");
	private JTextField tfTitle = new JTextField(30);
	private JLabel lbAuthor = new JLabel("SEARCH BY AUTHOR: ");
	private JTextField tfAuthor = new JTextField(30);
	private JLabel lbClassification = new JLabel("SEARCH BY CLASSIFICATION: ");
	private JTextField tfClassification = new JTextField(30);
	private JLabel lbKeyword = new JLabel("SEARCH BY KEYWORD: ");
	private JTextField tfKeyword = new JTextField(30);
	private JButton btSearch = new JButton("SEARCH");
	private JButton btReturn = new JButton("RETURN TO NORMAL SEARCH");
	
	private String user;
	
	public AdvancedSearchFrame(String user)
	{
		super("Advanced Search");
		this.user = user;
		this.setLayout(new FlowLayout());
		this.add(lbTitle);
		this.add(tfTitle);
		this.add(lbAuthor);
		this.add(tfAuthor);
		this.add(lbClassification);
		this.add(tfClassification);
		this.add(lbKeyword);
		this.add(tfKeyword);
		this.add(btSearch);
		this.add(btReturn);
		this.setSize(540,180);
		GUIUtil.toCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		btSearch.addActionListener(this);
		btReturn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btSearch)
		{
			System.out.println("Search successfully!");
			this.dispose();
		}
		else
		{
			this.dispose();
			new SearchFrame(user);
		}

	}

}
