package com.db;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class modifyDoc extends JFrame implements ActionListener {
	private String user,
				   itemID;

	
	private GetDetails getDetails;
	
	private JButton btReturn = new JButton("Return");
	private JButton btSubmit = new JButton("Submit");
	private JTextField tf1 = new JTextField();
	private JTextField tf2 = new JTextField();
	private JTextField tf3 = new JTextField();
	private JTextField tf4 = new JTextField();
	private JTextField tf5 = new JTextField();
	private JTextField tf6 = new JTextField();
	private JTextField tf7 = new JTextField();
	private JTextField tf8= new JTextField();
	private JTextField tf9 = new JTextField();
	private JTextField tf10 = new JTextField();
	
	public modifyDoc(String user, String itemID)
	{
		super("Modify");
		this.user = user;
		this.itemID = itemID;
		
		if (itemID.charAt(0)=='B')
		{
			getDetails = new GetDetails(itemID);
			tf1 = new JTextField(getDetails.details[0]);
			tf2 = new JTextField(getDetails.details[1]);
			tf3 = new JTextField(getDetails.details[2]);
			tf4 = new JTextField(getDetails.details[3]);
			tf5 = new JTextField(getDetails.details[4]);
			tf6 = new JTextField(getDetails.details[5]);
			tf7 = new JTextField(getDetails.details[6]);
			tf8= new JTextField(getDetails.details[7]);
			tf9 = new JTextField(getDetails.details[8]);
			tf10 = new JTextField(getDetails.details[9]);
			this.setLayout(new GridLayout(12,2));
			this.add(new JLabel("details: "));
			this.add(new JLabel("BOOK"));
			this.add(new JLabel("ID: "));
			this.add(new JLabel(getDetails.details[0]));
			this.add(new JLabel("Title: "));
			this.add(tf2);
			this.add(new JLabel("Publisher: "));
			this.add(tf3);
			this.add(new JLabel("Editor: "));
			this.add(tf4);
			this.add(new JLabel("Classification: "));
			this.add(tf5);
			this.add(new JLabel("Position: "));
			this.add(tf6);
			this.add(new JLabel("Author: "));
			this.add(tf7);
			this.add(new JLabel("Keyword: "));
			this.add(tf8);
			this.add(new JLabel("Edition: "));
			this.add(tf9);
			this.add(new JLabel("Year: "));
			this.add(tf10);
			this.add(btSubmit);
			this.add(btReturn);
			
			this.setSize(600, 600);
			GUIUtil.toCenter(this);
			
			this.setResizable(false);
			this.setVisible(true);
			btSubmit.addActionListener(this);
			btReturn.addActionListener(this);
		}else if(itemID.charAt(0)=='M')
		{
			getDetails = new GetDetails(itemID);
			tf1 = new JTextField(getDetails.details[0]);
			tf2 = new JTextField(getDetails.details[1]);
			tf3 = new JTextField(getDetails.details[2]);
			tf4 = new JTextField(getDetails.details[3]);
			tf5 = new JTextField(getDetails.details[4]);
			tf6 = new JTextField(getDetails.details[5]);
			tf7 = new JTextField(getDetails.details[6]);
			tf8= new JTextField(getDetails.details[7]);
			tf9 = new JTextField(getDetails.details[8]);
			this.setLayout(new GridLayout(12,2));
			this.add(new JLabel("details: "));
			this.add(new JLabel("MAGEZINE"));
			this.add(new JLabel("ID: "));
			this.add(new JLabel(getDetails.details[0]));
			this.add(new JLabel("Title: "));
			this.add(tf2);
			this.add(new JLabel("Publisher: "));
			this.add(tf3);
			this.add(new JLabel("Editor: "));
			this.add(tf4);
			this.add(new JLabel("Classification: "));
			this.add(tf5);
			this.add(new JLabel("Position: "));
			this.add(tf6);
			this.add(new JLabel("Contributor: "));
			this.add(tf7);
			this.add(new JLabel("Edition: "));
			this.add(tf8);
			this.add(new JLabel("Year: "));
			this.add(tf9);
			this.add(btSubmit);
			this.add(btReturn);
			
			this.setSize(600, 600);
			GUIUtil.toCenter(this);
			
			this.setResizable(false);
			this.setVisible(true);
			btSubmit.addActionListener(this);
			btReturn.addActionListener(this);
		}else if(itemID.charAt(0)=='T')
		{
			getDetails = new GetDetails(itemID);
			tf1 = new JTextField(getDetails.details[0]);
			tf2 = new JTextField(getDetails.details[1]);
			tf3 = new JTextField(getDetails.details[2]);
			tf4 = new JTextField(getDetails.details[3]);
			tf5 = new JTextField(getDetails.details[4]);
			tf6 = new JTextField(getDetails.details[5]);
			tf7 = new JTextField(getDetails.details[6]);
			tf8= new JTextField(getDetails.details[7]);
			tf9 = new JTextField(getDetails.details[8]);
			this.setLayout(new GridLayout(12,2));
			this.add(new JLabel("details: "));
			this.add(new JLabel("THESIS"));
			this.add(new JLabel("ID: "));
			this.add(new JLabel(getDetails.details[0]));
			this.add(new JLabel("Title: "));
			this.add(tf2);
			this.add(new JLabel("Publisher: "));
			this.add(tf3);
			this.add(new JLabel("Editor: "));
			this.add(tf4);
			this.add(new JLabel("Classification: "));
			this.add(tf5);
			this.add(new JLabel("Position: "));
			this.add(tf6);
			this.add(new JLabel("Author: "));
			this.add(tf7);
			this.add(new JLabel("Keyword: "));
			this.add(tf8);
			this.add(new JLabel("Date: "));
			this.add(tf9);
			this.add(btSubmit);
			this.add(btReturn);
			
			this.setSize(600, 600);
			GUIUtil.toCenter(this);
			
			this.setResizable(false);
			this.setVisible(true);
			btSubmit.addActionListener(this);
			btReturn.addActionListener(this);
		}else if(itemID.charAt(0)=='R')
		{
			getDetails = new GetDetails(itemID);
			tf1 = new JTextField(getDetails.details[0]);
			tf2 = new JTextField(getDetails.details[1]);
			tf3 = new JTextField(getDetails.details[2]);
			tf4 = new JTextField(getDetails.details[3]);
			tf5 = new JTextField(getDetails.details[4]);
			tf6 = new JTextField(getDetails.details[5]);
			tf7 = new JTextField(getDetails.details[6]);
			tf8= new JTextField(getDetails.details[7]);
			tf9 = new JTextField(getDetails.details[8]);
			this.setLayout(new GridLayout(12,2));
			this.add(new JLabel("details: "));
			this.add(new JLabel("TECH REPORT"));
			this.add(new JLabel("ID: "));
			this.add(new JLabel(getDetails.details[0]));
			this.add(new JLabel("Title: "));
			this.add(tf2);
			this.add(new JLabel("Publisher: "));
			this.add(tf3);
			this.add(new JLabel("Editor: "));
			this.add(tf4);
			this.add(new JLabel("Classification: "));
			this.add(tf5);
			this.add(new JLabel("Position: "));
			this.add(tf6);
			this.add(new JLabel("Author: "));
			this.add(tf7);
			this.add(new JLabel("Keyword: "));
			this.add(tf8);
			this.add(new JLabel("Date: "));
			this.add(tf9);
			this.add(btSubmit);
			this.add(btReturn);
			
			this.setSize(600, 600);
			GUIUtil.toCenter(this);
			
			this.setResizable(false);
			this.setVisible(true);
			btSubmit.addActionListener(this);
			btReturn.addActionListener(this);
		}else if(itemID.charAt(0)=='J')
		{
			getDetails = new GetDetails(itemID);
			tf1 = new JTextField(getDetails.details[0]);
			tf2 = new JTextField(getDetails.details[1]);
			tf3 = new JTextField(getDetails.details[2]);
			tf4 = new JTextField(getDetails.details[3]);
			tf5 = new JTextField(getDetails.details[4]);
			tf6 = new JTextField(getDetails.details[5]);
			tf7 = new JTextField(getDetails.details[6]);
			this.setLayout(new GridLayout(12,2));
			this.add(new JLabel("details: "));
			this.add(new JLabel("JOURNAL"));
			this.add(new JLabel("ID: "));
			this.add(new JLabel(getDetails.details[0]));
			this.add(new JLabel("Title: "));
			this.add(tf2);
			this.add(new JLabel("Publisher: "));
			this.add(tf3);
			this.add(new JLabel("Editor: "));
			this.add(tf4);
			this.add(new JLabel("Classification: "));
			this.add(tf5);
			this.add(new JLabel("Position: "));
			this.add(tf6);
			this.add(new JLabel("Date: "));
			this.add(tf7);
			this.add(btSubmit);
			this.add(btReturn);
			
			this.setSize(600, 600);
			GUIUtil.toCenter(this);
			
			this.setResizable(false);
			this.setVisible(true);
			btSubmit.addActionListener(this);
			btReturn.addActionListener(this);
		}		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btReturn)
		this.dispose();
		else if(e.getSource() == btSubmit)
		{
			if(itemID.charAt(0)=='B')
			{
				book b = new book();
				b.modifying(itemID, tf3.getText(), tf4.getText(), tf2.getText(), tf5.getText(), tf6.getText(), tf9.getText(), tf8.getText(), tf10.getText());
				JOptionPane.showMessageDialog(this, "Update successfully!");
			}
			else if(itemID.charAt(0)=='M')
			{
				magezine m = new magezine();
				m.modifying(itemID, tf3.getText(), tf4.getText(), tf2.getText(), tf5.getText(), tf6.getText(), tf8.getText(), tf7.getText(), tf9.getText());
				JOptionPane.showMessageDialog(this, "Update successfully!");	
			}
			else if(itemID.charAt(0)=='T')
			{
				thesis t = new thesis();
				t.modifying(itemID, tf3.getText(), tf4.getText(), tf2.getText(), tf5.getText(), tf6.getText(), tf8.getText(), tf9.getText());
				JOptionPane.showMessageDialog(this, "Update successfully!");	
			}
			else if(itemID.charAt(0)=='R')
			{
				techReport r = new techReport();
				r.modifying(itemID, tf3.getText(), tf4.getText(), tf2.getText(), tf5.getText(), tf6.getText(), tf8.getText(), tf9.getText());
				JOptionPane.showMessageDialog(this, "Update successfully!");	
			}
			else if(itemID.charAt(0)=='J')
			{
				journal j = new journal();
				j.modifying(itemID, tf3.getText(), tf4.getText(), tf2.getText(), tf5.getText(), tf6.getText(), tf7.getText());
				JOptionPane.showMessageDialog(this, "Update successfully!");	
			}
		}
	}

}
