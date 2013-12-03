package com.db;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

import java.awt.event.ActionListener;


public class AddDocTypeChooseFrame extends JFrame implements ActionListener {
	private JLabel lbChoose = new JLabel("Please choose a type of document:");
	private JButton btBook = new JButton("Add a book");
	private JButton btMagazine = new JButton("Add a magazine");
	private JButton btJournal = new JButton("Add a journal");
	private JButton btThesis = new JButton("Add a thesis");
	private JButton btTechnicalReport = new JButton("Add a technical report");
	private JButton btReturn = new JButton("Return");
	
	private String user;
	
	public AddDocTypeChooseFrame(String user)
	{
		super("Choose");
		this.user = user;
		this.setLayout(new FlowLayout());
		this.add(lbChoose);
		this.add(btBook);
		this.add(btMagazine);
		this.add(btJournal);
		this.add(btThesis);
		this.add(btTechnicalReport);
		this.add(btReturn);
		this.setSize(200,270);
		GUIUtil.toCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		btBook.addActionListener(this);
		btMagazine.addActionListener(this);
		btJournal.addActionListener(this);
		btThesis.addActionListener(this);
		btTechnicalReport.addActionListener(this);
		btReturn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btBook)
		{
			this.dispose();
			new AddDoc(user, 0);
		}else if(e.getSource() == btMagazine)
		{
			this.dispose();
			new AddDoc(user, 1);
		}else if(e.getSource() == btJournal)
		{
			this.dispose();
			new AddDoc(user, 4);
		}else if(e.getSource() == btThesis)
		{
			this.dispose();
			new AddDoc(user, 2);
		}else if(e.getSource() == btTechnicalReport)
		{
			this.dispose();
			new AddDoc(user, 3);
		}else if(e.getSource() == btReturn)
		{
			this.dispose();
			new LibraryActionFrame(user);
		}
	}

}
