package com.db;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

import java.awt.event.ActionListener;


public class AddDoc extends JFrame implements ActionListener {
	private String user;
	private int type=-1;
	private JLabel lbID = new JLabel("Item ID: ");
	private JLabel lbPublisher = new JLabel("Publisher: ");
	private JLabel lbEditor = new JLabel("Editor: ");
	private JLabel lbTitle = new JLabel("Title: ");
	private JLabel lbClassification = new JLabel("Classification: ");
	private JLabel lbPosition = new JLabel("Position: ");
	private JLabel lbEdition = new JLabel("Edition: ");
	private JLabel lbKeyword = new JLabel("Keyword: ");
	private JLabel lbYear = new JLabel("Year: ");
	private JLabel lbContributor = new JLabel("Contributor: ");
	private JLabel lbDate = new JLabel("Date: ");
	private JLabel lbAuthorFirstName = new JLabel("Author First Name: ");
	private JLabel lbAuthorMiddleName = new JLabel("Author Middle Name: ");
	private JLabel lbAuthorLastName = new JLabel("Author Last Name: ");
	private JTextField tfID = new JTextField();
	private JTextField tfPublisher = new JTextField();
	private JTextField tfEditor = new JTextField();
	private JTextField tfTitle = new JTextField();
	private JTextField tfClassification = new JTextField();
	private JTextField tfPosition = new JTextField();
	private JTextField tfEdition = new JTextField();
	private JTextField tfKeyword = new JTextField();
	private JTextField tfYear = new JTextField("2000");
	private JTextField tfContributor = new JTextField();
	private JTextField tfDate = new JTextField("2000-10-10 00:00:00");
	private JTextField tfFirst = new JTextField();
	private JTextField tfMiddle = new JTextField();
	private JTextField tfLast = new JTextField();
	private JButton btSubmit = new JButton("Submit");
	private JButton btReturn = new JButton("Return");
	
	public AddDoc(String user, int type)
	{
		super("Add a document");
		this.user = user;
		this.type = type;
		if(type==0)
		{
			this.setLayout(new GridLayout(14,2));
			this.add(new JLabel("Add a book: "));
			this.add(new JLabel(" "));
			this.add(lbID);
			this.add(tfID);
			this.add(lbPublisher);
			this.add(tfPublisher);
			this.add(lbEditor);
			this.add(tfEditor);
			this.add(lbTitle);
			this.add(tfTitle);
			this.add(lbClassification);
			this.add(tfClassification);
			this.add(lbPosition);
			this.add(tfPosition);
			this.add(lbAuthorFirstName);
			this.add(tfFirst);
			this.add(lbAuthorMiddleName);
			this.add(tfMiddle);
			this.add(lbAuthorLastName);
			this.add(tfLast);
			this.add(lbEdition);
			this.add(tfEdition);
			this.add(lbKeyword);
			this.add(tfKeyword);
			this.add(lbYear);
			this.add(tfYear);
			this.add(btSubmit);
			this.add(btReturn);
			this.setSize(600, 700);
			GUIUtil.toCenter(this);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);
			btSubmit.addActionListener(this);
			btReturn.addActionListener(this);
		}else if(type == 1)
		{
			this.setLayout(new GridLayout(14,2));
			this.add(new JLabel("Add a magazine: "));
			this.add(new JLabel(" "));
			this.add(lbID);
			this.add(tfID);
			this.add(lbPublisher);
			this.add(tfPublisher);
			this.add(lbEditor);
			this.add(tfEditor);
			this.add(lbTitle);
			this.add(tfTitle);
			this.add(lbClassification);
			this.add(tfClassification);
			this.add(lbPosition);
			this.add(tfPosition);
			this.add(lbAuthorFirstName);
			this.add(tfFirst);
			this.add(lbAuthorMiddleName);
			this.add(tfMiddle);
			this.add(lbAuthorLastName);
			this.add(tfLast);
			this.add(lbEdition);
			this.add(tfEdition);
			this.add(lbContributor);
			this.add(tfContributor);
			this.add(lbYear);
			this.add(tfYear);
			this.add(btSubmit);
			this.add(btReturn);
			this.setSize(600, 700);
			GUIUtil.toCenter(this);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);
			btSubmit.addActionListener(this);
			btReturn.addActionListener(this);
		}else if(type == 2)
		{
			this.setLayout(new GridLayout(13,2));
			this.add(new JLabel("Add a thesis: "));
			this.add(new JLabel(" "));
			this.add(lbID);
			this.add(tfID);
			this.add(lbPublisher);
			this.add(tfPublisher);
			this.add(lbEditor);
			this.add(tfEditor);
			this.add(lbTitle);
			this.add(tfTitle);
			this.add(lbClassification);
			this.add(tfClassification);
			this.add(lbPosition);
			this.add(tfPosition);
			this.add(lbAuthorFirstName);
			this.add(tfFirst);
			this.add(lbAuthorMiddleName);
			this.add(tfMiddle);
			this.add(lbAuthorLastName);
			this.add(tfLast);
			this.add(lbKeyword);
			this.add(tfKeyword);
			this.add(lbDate);
			this.add(tfDate);
			this.add(btSubmit);
			this.add(btReturn);
			this.setSize(600, 650);
			GUIUtil.toCenter(this);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);
			btSubmit.addActionListener(this);
			btReturn.addActionListener(this);
		}else if(type == 3)
		{
			this.setLayout(new GridLayout(13,2));
			this.add(new JLabel("Add a journal: "));
			this.add(new JLabel(" "));
			this.add(lbID);
			this.add(tfID);
			this.add(lbPublisher);
			this.add(tfPublisher);
			this.add(lbEditor);
			this.add(tfEditor);
			this.add(lbTitle);
			this.add(tfTitle);
			this.add(lbClassification);
			this.add(tfClassification);
			this.add(lbPosition);
			this.add(tfPosition);
			this.add(lbAuthorFirstName);
			this.add(tfFirst);
			this.add(lbAuthorMiddleName);
			this.add(tfMiddle);
			this.add(lbAuthorLastName);
			this.add(tfLast);
			this.add(lbKeyword);
			this.add(tfKeyword);
			this.add(lbDate);
			this.add(tfDate);
			this.add(btSubmit);
			this.add(btReturn);
			this.setSize(600, 650);
			GUIUtil.toCenter(this);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);
			btSubmit.addActionListener(this);
			btReturn.addActionListener(this);
		}else 
		{	
			this.setLayout(new GridLayout(12,2));
			this.add(new JLabel("Add a journal: "));
			this.add(new JLabel(" "));
			this.add(lbID);
			this.add(tfID);
			this.add(lbPublisher);
			this.add(tfPublisher);
			this.add(lbEditor);
			this.add(tfEditor);
			this.add(lbTitle);
			this.add(tfTitle);
			this.add(lbClassification);
			this.add(tfClassification);
			this.add(lbPosition);
			this.add(tfPosition);
			this.add(lbAuthorFirstName);
			this.add(tfFirst);
			this.add(lbAuthorMiddleName);
			this.add(tfMiddle);
			this.add(lbAuthorLastName);
			this.add(tfLast);
			this.add(lbDate);
			this.add(tfDate);
			this.add(btSubmit);
			this.add(btReturn);
			this.setSize(600, 600);
			GUIUtil.toCenter(this);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setVisible(true);
			btSubmit.addActionListener(this);
			btReturn.addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btReturn)
		{
			this.dispose();
			new AddDocTypeChooseFrame(user);
			
		}else if(e.getSource()==btSubmit)
		{
			if(type ==0){
				try
				{
					book b = new book();
					b.adding(tfID.getText(), tfPublisher.getText(), tfEditor.getText(), tfTitle.getText(), tfClassification.getText(), tfPosition.getText(), tfFirst.getText(), tfMiddle.getText(), tfLast.getText(), tfEdition.getText(), tfKeyword.getText(), tfYear.getText());
				}catch(Exception exc)
				{
					JOptionPane.showMessageDialog(this, "Fail!");
				}
				JOptionPane.showMessageDialog(this, "Add successfully!");
			}
			else if (type ==1){
				try
				{
				magezine m = new magezine();
				m.adding(tfID.getText(), tfPublisher.getText(), tfEditor.getText(), tfTitle.getText(), tfClassification.getText(), tfPosition.getText(), tfFirst.getText(), tfMiddle.getText(), tfLast.getText(), tfEdition.getText(), tfContributor.getText(), tfYear.getText());
			}catch(Exception exc)
			{
				JOptionPane.showMessageDialog(this, "Fail!");
			}
			JOptionPane.showMessageDialog(this, "Add successfully!");
		}
			
			else if(type == 2){
				try{
				thesis t = new thesis();
				t.adding(tfID.getText(), tfPublisher.getText(), tfEditor.getText(), tfTitle.getText(), tfClassification.getText(), tfPosition.getText(), tfFirst.getText(), tfMiddle.getText(), tfLast.getText(), tfKeyword.getText(), tfDate.getText());
				}catch(Exception exc)
				{
					JOptionPane.showMessageDialog(this, "Fail!");
				}
				JOptionPane.showMessageDialog(this, "Add successfully!");
			}
			
			else if(type == 3){
				try{
				techReport r = new techReport();
				r.adding(tfID.getText(), tfPublisher.getText(), tfEditor.getText(), tfTitle.getText(), tfClassification.getText(), tfPosition.getText(), tfFirst.getText(), tfMiddle.getText(), tfLast.getText(), tfKeyword.getText(), tfDate.getText());
			}catch(Exception exc)
			{
				JOptionPane.showMessageDialog(this, "Fail!");
			}
			JOptionPane.showMessageDialog(this, "Add successfully!");
		}
				
			else if(type == 4){
				try{
				journal j = new journal();
				j.adding(tfID.getText(), tfPublisher.getText(), tfEditor.getText(), tfTitle.getText(), tfClassification.getText(), tfPosition.getText(), tfKeyword.getText(), tfDate.getText());
			}catch(Exception exc)
			{
				JOptionPane.showMessageDialog(this, "Fail!");
			}
			JOptionPane.showMessageDialog(this, "Add successfully!");
		}
				}
		{
			return;
		}
	}

}
