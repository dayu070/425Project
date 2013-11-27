package com.db;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SearchResultFrame extends JFrame implements ActionListener {
	private String user;
	
	private NormalSearch normalSearch;
	
	private AdvancedSearch advancedSearch;
	
	private JLabel lbSearch = new JLabel("Search Results");
	private JLabel [] resultsArray;
	private JButton [] getDetails;
	private JButton [] borrow;
	private JButton btReturn = new JButton("Return for another search");
	
	private int numberOfResults;
	
	private String[] results;
	
	public SearchResultFrame(String title, String author, String classification, String keywords, String user)
	{
		super("Search Results");
		advancedSearch = new AdvancedSearch(title, author, classification, keywords);
		numberOfResults = advancedSearch.getResultNumber();
		this.user = user;
		this.setLayout(new GridLayout(numberOfResults+2,4));
		this.add(lbSearch);
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		resultsArray = new JLabel[2*numberOfResults];
		getDetails = new JButton[numberOfResults];
		borrow = new JButton[numberOfResults];
		results = new String[2*numberOfResults];
		for (int i=0;i<numberOfResults;i++)
		{
			resultsArray[2*i] = new JLabel(advancedSearch.bi[i].getID());
			resultsArray[2*i+1] = new JLabel(advancedSearch.bi[i].getTitle());
			getDetails[i] = new JButton("MORE DETAILS");
			borrow[i] = new JButton("BORROW IT!");
			results[2*i] = advancedSearch.bi[i].getID();
			results[2*i+1] = advancedSearch.bi[i].getTitle();
			this.add(resultsArray[2*i]);
			this.add(resultsArray[2*i+1]);
			this.add(getDetails[i]);
			this.add(borrow[i]);
		}
		this.add(btReturn);
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.setSize(800, 50*(numberOfResults+2));
		GUIUtil.toCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		for (int i=0; i<numberOfResults; i++)
		{
			getDetails[i].addActionListener(this);
			borrow[i].addActionListener(this);
		}
		btReturn.addActionListener(this);
	}
	
	public SearchResultFrame(String keywords, String user)
	{
		super("Search Results");
		normalSearch = new NormalSearch(keywords);
		numberOfResults = normalSearch.getResultNumber();
		this.user = user;
		this.setLayout(new GridLayout(numberOfResults+2,4));
		this.add(lbSearch);
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		resultsArray = new JLabel[2*numberOfResults];
		getDetails = new JButton[numberOfResults];
		borrow = new JButton[numberOfResults];
		results = new String[2*numberOfResults];
		for (int i=0;i<numberOfResults;i++)
		{
			resultsArray[2*i] = new JLabel(normalSearch.bi[i].getID());
			resultsArray[2*i+1] = new JLabel(normalSearch.bi[i].getTitle());
			getDetails[i] = new JButton("MORE DETAILS");
			borrow[i] = new JButton("BORROW IT!");
			results[2*i] = normalSearch.bi[i].getID();
			results[2*i+1] = normalSearch.bi[i].getTitle();
			this.add(resultsArray[2*i]);
			this.add(resultsArray[2*i+1]);
			this.add(getDetails[i]);
			this.add(borrow[i]);
		}
		this.add(btReturn);
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.setSize(800, 50*(numberOfResults+2));
		GUIUtil.toCenter(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		for (int i=0; i<numberOfResults; i++)
		{
			getDetails[i].addActionListener(this);
			borrow[i].addActionListener(this);
		}
		btReturn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btReturn)
		{
			this.dispose();
			new SearchFrame(user);
		}
		else
		{
			for (int i=0; i<numberOfResults; i++)
			{
				if(e.getSource() == getDetails[i])
				{
					new DetailedInformationFrame(user, results[2*i], results[2*i+1]);
					System.out.println(results[2*i] + results[2*i+1]);
					return;
				}
				else if (e.getSource() == borrow[i])
				{
					BorrowBook bb = new BorrowBook(user, results[2*i]);
					if (!bb.checkUserAmount())
						JOptionPane.showMessageDialog(this, "You can't do that yet. The books you borrowed has reached the maximum!");
					else if (!bb.bookIsAvailable())
						JOptionPane.showMessageDialog(this, "No such books are available yet!");
					else
					{	
						bb.borrowBook();
						JOptionPane.showMessageDialog(this, "Borrow Successfully!");
					}
					return;
				}
			}
		}
	}

}
