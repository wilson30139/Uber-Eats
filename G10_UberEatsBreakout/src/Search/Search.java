package Search;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.*;

import Home.Home;

public class Search implements ActionListener{
	private JPanel[] pBestSearch;
	private String[] stBestSearch;
	
	
	private JPanel pCardSearch;
	private CardLayout c;
	private SearchMenu searchmenu;
	private JPanel pSearchMenu;
	private JButton bReturnSearch;
	
	private ScrollPane sSearch = new ScrollPane();
	private GridBagConstraints gbc;
	private JPanel pSearch;
	
	private JPanel pUpSearch;
	private TextField tfSearch;
	private JButton bSearch;
	
	private JLabel Popular_Category, More_Category;
	
	private final int Swidth = 230, Sheight = 200;
	private String[] sImageName;
	private ImageIcon[] iImageName;
	private JButton[] bImageName;
	
	public Search(JPanel pCardSearch) {
		this.pCardSearch = pCardSearch;
		c = new CardLayout();
		this.pCardSearch.setLayout(c);
		gbc = new GridBagConstraints();
		pSearch = new JPanel(new GridBagLayout());
		pSearch.setPreferredSize(new Dimension(500, 3000));
		pSearch.setBackground(Color.WHITE);
		this.sSearch.add(pSearch);
		this.pCardSearch.add(sSearch, "Search");
		setSearch();
		
		pSearchMenu = new JPanel();
		bReturnSearch = new JButton("Return Search");
		bReturnSearch.setBackground(new Color(0,225,225));
		bReturnSearch.setForeground(Color.ORANGE);
		bReturnSearch.setFont(new Font("Arial",Font.PLAIN,30));
		searchmenu = new SearchMenu(pSearchMenu,bReturnSearch);
		bReturnSearch.addActionListener(this);
		this.pCardSearch.add(pSearchMenu, "Home");
		
		pBestSearch = new JPanel[10];
		stBestSearch = new String[] {"Sanjiang Barbecue Rice", "Daqing Noodle Shop", "Golden Fairy Shrimp",
				"Life Warehouse", "Treasures", "Invincible Dumplings", "Tea Soup", "Tea Top",
				"Tiewan Thirteen Hall Ramen", "Chicory Chicken Rice"};
		for(int i=0;i<10;i++) {
			pBestSearch[i] = new JPanel();
			this.pCardSearch.add(pBestSearch[i], stBestSearch[i]);
		}
	}

	public void setSearch() {
		gbc.insets = new Insets(10, 10, 10, 10);

		pUpSearch = new JPanel(new FlowLayout());
		tfSearch = new TextField(50);
		tfSearch.setText("Search for a restaurant or meal");
		tfSearch.setVisible(true);
		pUpSearch.add(tfSearch);
		bSearch = new JButton("Search");
		bSearch.addActionListener(this);
		pUpSearch.add(bSearch);
		setGridBagConstraints(0, 0, 2, 1);
		pSearch.add(pUpSearch, gbc);

		Popular_Category = new JLabel("Popular category");
		Popular_Category.setFont(new Font("", 1, 30));
		Popular_Category.setForeground(Color.RED);
		setGridBagConstraints(0, 1, 2, 1);
		pSearch.add(Popular_Category, gbc);
		More_Category = new JLabel("More category");
		More_Category.setFont(new Font("", 1, 30));
		More_Category.setForeground(Color.ORANGE);
		setGridBagConstraints(0, 10, 2, 1);
		pSearch.add(More_Category, gbc);

		sImageName = new String[] { "./image2/Taiwanese.jpg", "./image2/Bubble Tea.jpg", "./image2/Chinese.jpg",
				"./image2/Japanese.jpg", "./image2/Juice and Smoothies.jpg", "./image2/Desserts.jpg",
				"./image2/Healthy.jpg", "./image2/American.jpg", "./image2/Breakfast and Brunch.jpg",
				"./image2/Korean.jpg", "./image2/Pizza.jpg", "./image2/Thai.jpg", "./image2/Italian.jpg",
				"./image2/Cantonese.jpg", "./image2/Burgers.jpg", "./image2/Vietnamese.jpg", "./image2/Cafe.jpg",
				"./image2/Bakery.jpg", "./image2/European.jpg", "./image2/Coffee and Tea.jpg",
				"./image2/Singaporean.jpg", "./image2/Indian.jpg", "./image2/French.jpg", "./image2/Malaysian.jpg" };
		iImageName = new ImageIcon[24];
		bImageName = new JButton[24];
		for (int i = 0; i < 16; i++) {
			iImageName[i] = new ImageIcon(sImageName[i]);
			iImageName[i].setImage(iImageName[i].getImage().getScaledInstance(Swidth, Sheight, Image.SCALE_DEFAULT));
			bImageName[i] = new JButton(iImageName[i]);
			bImageName[i].setPreferredSize(new Dimension(230, 200));
			bImageName[i].setIcon(iImageName[i]);
			bImageName[i].addActionListener(this);
			if (i % 2 == 0) {
				setGridBagConstraints(0, i / 2 + 2, 1, 1);
			} else if (i % 2 == 1) {
				setGridBagConstraints(1, (i + 3) / 2, 1, 1);
			}
			pSearch.add(bImageName[i], gbc);
		}
		for (int i = 16; i < 24; i++) {
			iImageName[i] = new ImageIcon(sImageName[i]);
			iImageName[i].setImage(iImageName[i].getImage().getScaledInstance(Swidth, Sheight, Image.SCALE_DEFAULT));
			bImageName[i] = new JButton(iImageName[i]);
			bImageName[i].setPreferredSize(new Dimension(230, 200));
			bImageName[i].setIcon(iImageName[i]);
			bImageName[i].addActionListener(this);
			if (i % 2 == 0) {
				setGridBagConstraints(0, i / 2 + 3, 1, 1);
			} else if (i % 2 == 1) {
				setGridBagConstraints(1, (i + 5) / 2, 1, 1);
			}
			pSearch.add(bImageName[i], gbc);
		}

	}
	
	public void setGridBagConstraints(int x, int y, int w, int h) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<24;i++) {
			if(e.getSource()==bImageName[i]) {
				c.show(pCardSearch, "Home");
			}
		}
		if(e.getSource()==bReturnSearch) {
			c.show(pCardSearch, "Search");
		}else if(e.getSource()==bSearch) {
			for(int i=0;i<10;i++) {
				if(tfSearch.getText()==stBestSearch[i]) {
					c.show(pCardSearch, stBestSearch[i]);
				}
			}
		}
	}

	
}
