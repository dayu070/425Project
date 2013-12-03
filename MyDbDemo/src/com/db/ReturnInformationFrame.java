package com.db;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

import java.awt.event.ActionListener;

public class ReturnInformationFrame extends JFrame implements ActionListener {
	private String user;
	private JLabel lbID = new JLabel("Item ID: ");
	private JLabel lbCopy = new JLabel("Copy ID: ");
	private JTextField tfID = new JTextField("");
	private JTextField tfCopy = new JTextField("");
	private JButton btSubmit= new JButton("Submit");
	private JButton btCancel= new JButton("Cancel");
	
	public ReturnInformationFrame(String user)
	{
		super("Return Information");
		this.user = user;
		this.setLayout(new GridLayout(3,2));
		this.add(lbID);
		this.add(tfID);
		this.add(lbCopy);
		this.add(tfCopy);
		this.add(btSubmit);
		this.add(btCancel);
		this.setSize(600, 150);
		GUIUtil.toCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		btSubmit.addActionListener(this);
		btCancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btCancel)
		{
			this.dispose();
			new LibraryActionFrame(user);
		}else
		{
			ReturnDoc rd = new ReturnDoc(tfCopy.getText(), tfID.getText());
			try
			{
				rd.returnBook();
			}catch(Exception exc)
			{
				JOptionPane.showMessageDialog(this, "Returning is denied!");
			}
			JOptionPane.showMessageDialog(this, "Return successfully!");
		}
	}

}
