package com.db;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LibraryActionFrame extends JFrame implements ActionListener {
	
	private String user;

	private JLabel lbWelcome;
	private JLabel lbSearch = new JLabel("Search a Doc");
	private JLabel lbAddcopy = new JLabel("Add a copy");
	private JLabel lbAddDoc = new JLabel("Add a document");
	private JLabel lbDltCopy = new JLabel("Delete a copy");
	private JLabel lbDltDoc = new JLabel("Delete a document");
	private JLabel lbMdfDoc = new JLabel("Modify a document");
	private JButton btSearchDoc = new JButton("SEARCH A DOC");
	private JButton btAddCopy = new JButton("ADD A COPY");
	private JButton btAddDoc = new JButton("ADD A DOC");
	private JButton btDltCopy = new JButton("DELETE A COPY");
	private JButton btDltDoc = new JButton("DELETE A DOC");
	private JButton btMdfDoc = new JButton("MODIFY A DOC");
	private JButton btR = new JButton("RETURN");
	private JButton btRDoc = new JButton("RETURN A DOC");
	private JLabel lbRDoc = new JLabel("Return a document");
	
	public LibraryActionFrame(String user)
	{
		super("Administration");
		this.setLayout(new GridLayout(8,2));

//		lbWelcome = new JLabel("Hello, " + user)6
//		this.add(lbWelcome);
		this.user = user;
		this.add(lbSearch);
		this.add(btSearchDoc);
		this.add(lbAddcopy);
		this.add(btAddCopy);
		this.add(lbAddDoc);
		this.add(btAddDoc);
		this.add(lbDltCopy);
		this.add(btDltCopy);
		this.add(lbDltDoc);
		this.add(btDltDoc);
		this.add(lbMdfDoc);
		this.add(btMdfDoc);
		this.add(lbRDoc);
		this.add(btRDoc);
		this.add(btR);
		this.setSize(400, 300);
		GUIUtil.toCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		btAddCopy.addActionListener(this);
		btAddDoc.addActionListener(this);
		btDltCopy.addActionListener(this);
		btDltDoc.addActionListener(this);
		btMdfDoc.addActionListener(this);
		btSearchDoc.addActionListener(this);
		btRDoc.addActionListener(this);
		btR.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == btAddCopy)
		{
			this.dispose();
			new AddCopy(user);
		}
		else if(e.getSource() == btAddDoc)
		{
			this.dispose();
			new AddDocTypeChooseFrame(user);
		}
		if(e.getSource() == btDltCopy){
			this.dispose();
			new DeleteCopy(user);
		}
		else if(e.getSource() == btDltDoc){
			this.dispose();
			new DeleteDoc(user);// need a class
		}
		else if(e.getSource() == btMdfDoc){
			try
			{
			String str = JOptionPane.showInputDialog("Please enter an item ID");

			new modifyDoc(user, str);
			}catch (NullPointerException exc)
			{
				return;
			}
		}
		else if(e.getSource() == btSearchDoc){
			
			new SearchFrame(user);
		}
		else if(e.getSource() == btR){
			this.dispose();
			new LibraryLogInFrame();
		}else if(e.getSource() == btRDoc){
			this.dispose();
			new ReturnInformationFrame(user);
		}
		
	}
	
	

}
