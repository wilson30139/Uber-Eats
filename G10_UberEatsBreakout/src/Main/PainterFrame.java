package Main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Ball.*;
import Home.*;
import Search.*;
import BreakoutClone.BallWorldPanel;
import List.List;
import Account.Account;

public class PainterFrame extends JFrame implements ActionListener{
	private GridBagConstraints gbc;
	private CardLayout c;
	
	private BallWorld ballworld;
	private JPanel pScreenSwitch;
	private JButton bEnter;
	
	private JTabbedPane tab1;
	private Home home;
	private Search search;
	private List list;
	private Account account;
	private BallWorldPanel ballworldpanel;
	
	private JPanel pAccount,pBreakout;
	private JPanel pCardHome, pCardSearch;
	private ScrollPane sSearch, sList;
	
	public PainterFrame() {
		super("Uber Eats");
		
		gbc = new GridBagConstraints();
		c = new CardLayout();
		pScreenSwitch = new JPanel(c);
		
		bEnter = new JButton("Enter");
		ballworld = new BallWorld(620,800,bEnter);
		bEnter = ballworld.setbEnter(bEnter);
		bEnter.addActionListener(this);
		
		tab1 = new JTabbedPane();
		tab1.setFont(new Font("",1,20));
		tab1.setForeground(Color.BLUE);
		
		
		pScreenSwitch.add(ballworld);
		pScreenSwitch.add(tab1);
		
		pCardHome = new JPanel();
		home = new Home(pCardHome);
		tab1.add("Home", pCardHome);//第一分頁
		
//		sSearch = new ScrollPane();
		pCardSearch = new JPanel();
		search = new Search(pCardSearch);
		tab1.add("Search", pCardSearch);//第二分頁
		
		sList = new ScrollPane();
		list = new List(sList);
		tab1.add("List", sList);//第三分頁
		
		pAccount = new JPanel();
//		pAccount.setBackground(Color.BLUE);
		account = new Account(pAccount);
		tab1.add("Account", pAccount);//第四分頁
		
		pBreakout = new JPanel(new GridBagLayout());
		pBreakout.setBackground(Color.WHITE);
		ballworldpanel = new BallWorldPanel(500,700);
		ballworldpanel.setPreferredSize(new Dimension(500,700));
		pBreakout.add(ballworldpanel);
		tab1.add("Breakout Clone", pBreakout);
		
		add(pScreenSwitch);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bEnter) {
			c.last(pScreenSwitch);
		}
		
	}
	
}
