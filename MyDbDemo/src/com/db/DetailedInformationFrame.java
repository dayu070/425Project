package com.db;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DetailedInformationFrame extends JFrame implements ActionListener {
	private String user,
				   itemID,
				   itemTitle;
	
	private GetDetails getDetails;
	
	private JButton btReturn = new JButton("Return");
	
	public DetailedInformationFrame(String user, String itemID, String itemTitle)
	{
		super("Details for " + itemTitle);
		this.user = user;
		this.itemTitle = itemTitle;
		this.itemID = itemID;
		if (itemID.charAt(0)=='B')
		{
			getDetails = new GetDetails(itemID);
			this.setLayout(new GridLayout(12,2));
			this.add(new JLabel(itemTitle + " details: "));
			this.add(new JLabel("BOOK"));
			this.add(new JLabel("ID: "));
			this.add(new JLabel(getDetails.details[0]));
			this.add(new JLabel("Title: "));
			this.add(new JLabel(getDetails.details[1]));
			this.add(new JLabel("Publisher: "));
			this.add(new JLabel(getDetails.details[2]));
			this.add(new JLabel("Editor: "));
			this.add(new JLabel(getDetails.details[3]));
			this.add(new JLabel("Classification: "));
			this.add(new JLabel(getDetails.details[4]));
			this.add(new JLabel("Position: "));
			this.add(new JLabel(getDetails.details[5]));
			this.add(new JLabel("Author: "));
			this.add(new JLabel(getDetails.details[6]));
			this.add(new JLabel("Keyword: "));
			this.add(new JLabel(getDetails.details[7]));
			this.add(new JLabel("Edition: "));
			this.add(new JLabel(getDetails.details[8]));
			this.add(new JLabel("Year: "));
			this.add(new JLabel(getDetails.details[9]));
			this.add(btReturn);
			this.add(new JLabel(" "));
			this.setSize(1200, 120);
			GUIUtil.toCenter(this);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);
			btReturn.addActionListener(this);
		}else if(itemID.charAt(0)=='M')
		{
			getDetails = new GetDetails(itemID);
			this.setLayout(new GridLayout(11,2));
			this.add(new JLabel(itemTitle + " details: "));
			this.add(new JLabel("MAGAZINE"));
			this.add(new JLabel("ID: "));
			this.add(new JLabel(getDetails.details[0]));
			this.add(new JLabel("Title: "));
			this.add(new JLabel(getDetails.details[1]));
			this.add(new JLabel("Publisher: "));
			this.add(new JLabel(getDetails.details[2]));
			this.add(new JLabel("Editor: "));
			this.add(new JLabel(getDetails.details[3]));
			this.add(new JLabel("Classification: "));
			this.add(new JLabel(getDetails.details[4]));
			this.add(new JLabel("Position: "));
			this.add(new JLabel(getDetails.details[5]));
			this.add(new JLabel("Contributor: "));
			this.add(new JLabel(getDetails.details[6]));
			this.add(new JLabel("Edition: "));
			this.add(new JLabel(getDetails.details[7]));
			this.add(new JLabel("Year: "));
			this.add(new JLabel(getDetails.details[8]));
			this.add(btReturn);
			this.add(new JLabel(" "));
			this.setSize(1100, 120);
			GUIUtil.toCenter(this);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);
			btReturn.addActionListener(this);
		}else if(itemID.charAt(0)=='T')
		{
			getDetails = new GetDetails(itemID);
			this.setLayout(new GridLayout(11,2));
			this.add(new JLabel(itemTitle + " details: "));
			this.add(new JLabel("THESIS"));
			this.add(new JLabel("ID: "));
			this.add(new JLabel(getDetails.details[0]));
			this.add(new JLabel("Title: "));
			this.add(new JLabel(getDetails.details[1]));
			this.add(new JLabel("Publisher: "));
			this.add(new JLabel(getDetails.details[2]));
			this.add(new JLabel("Editor: "));
			this.add(new JLabel(getDetails.details[3]));
			this.add(new JLabel("Classification: "));
			this.add(new JLabel(getDetails.details[4]));
			this.add(new JLabel("Position: "));
			this.add(new JLabel(getDetails.details[5]));
			this.add(new JLabel("Author: "));
			this.add(new JLabel(getDetails.details[6]));
			this.add(new JLabel("Keyword: "));
			this.add(new JLabel(getDetails.details[7]));
			this.add(new JLabel("Date: "));
			this.add(new JLabel(getDetails.details[8]));
			this.add(btReturn);
			this.add(new JLabel(" "));
			this.setSize(1100, 120);
			GUIUtil.toCenter(this);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);
			btReturn.addActionListener(this);
		}else if(itemID.charAt(0)=='R')
		{
			getDetails = new GetDetails(itemID);
			this.setLayout(new GridLayout(11,2));
			this.add(new JLabel(itemTitle + " details: "));
			this.add(new JLabel("TECHNICAL REPORT"));
			this.add(new JLabel("ID: "));
			this.add(new JLabel(getDetails.details[0]));
			this.add(new JLabel("Title: "));
			this.add(new JLabel(getDetails.details[1]));
			this.add(new JLabel("Publisher: "));
			this.add(new JLabel(getDetails.details[2]));
			this.add(new JLabel("Editor: "));
			this.add(new JLabel(getDetails.details[3]));
			this.add(new JLabel("Classification: "));
			this.add(new JLabel(getDetails.details[4]));
			this.add(new JLabel("Position: "));
			this.add(new JLabel(getDetails.details[5]));
			this.add(new JLabel("Author: "));
			this.add(new JLabel(getDetails.details[6]));
			this.add(new JLabel("Keyword: "));
			this.add(new JLabel(getDetails.details[7]));
			this.add(new JLabel("Date: "));
			this.add(new JLabel(getDetails.details[8]));
			this.add(btReturn);
			this.add(new JLabel(" "));
			this.setSize(1100, 120);
			GUIUtil.toCenter(this);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);
			btReturn.addActionListener(this);
		}else if(itemID.charAt(0)=='J')
		{
			getDetails = new GetDetails(itemID);
			this.setLayout(new GridLayout(9,2));
			this.add(new JLabel(itemTitle + " details: "));
			this.add(new JLabel("JOURNAL"));
			this.add(new JLabel("ID: "));
			this.add(new JLabel(getDetails.details[0]));
			this.add(new JLabel("Title: "));
			this.add(new JLabel(getDetails.details[1]));
			this.add(new JLabel("Publisher: "));
			this.add(new JLabel(getDetails.details[2]));
			this.add(new JLabel("Editor: "));
			this.add(new JLabel(getDetails.details[3]));
			this.add(new JLabel("Classification: "));
			this.add(new JLabel(getDetails.details[4]));
			this.add(new JLabel("Position: "));
			this.add(new JLabel(getDetails.details[5]));
			this.add(new JLabel("Date: "));
			this.add(new JLabel(getDetails.details[6]));
			this.add(btReturn);
			this.add(new JLabel(" "));
			this.setSize(900, 120);
			GUIUtil.toCenter(this);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);
			btReturn.addActionListener(this);
		}		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
	}

}
