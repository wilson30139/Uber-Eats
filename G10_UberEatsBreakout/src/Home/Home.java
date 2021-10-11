package Home;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;
import java.util.ArrayList;
import javax.swing.*;

import Main.AddSQL;
import Main.DeleteSQL;
import Search.Search;

public class Home extends JFrame implements ActionListener {

	private JPanel pCardHome;
	private CardLayout cHome;

	private ScrollPane sHome;
	private JPanel pHome;
	private GridBagConstraints gbcHome;

	private ScrollPane[] scMenu;
	private JPanel[] pMenu;
	private GridBagConstraints[] gbcMenu;

	private CardLayout cAnimation;
	private JPanel pAnimation;
	private String[] namesAnimation;
	private ImageIcon[] iAnimation;
	private JButton[] bAnimation;
	private Timer timeAnimation;
	private TimerTask timetaskAnimation;

	private final int Hwidth = 500, Hheight = 300;
	private String[] sNameFood, sNameImage;
	private JLabel[] lFood, NameFood;
	private ImageIcon[] iFood;
	private JButton[] bOrder;

	private String[] stMenu;
	private ImageIcon[] iMenu;
	private String[] stImageMenu;
	private JLabel[] lMenu;
	private String[][] sFoodName;
	private JLabel[][] lFoodName;
	private String[][] sFoodMoney;
	private JLabel[][] lFoodMoney;
	private JButton[][] bbuy;
	private JButton[][] bdelete;
	private JLabel lNumberSizeCount;
	private JTextField[][] tfFoodNumber;
	private Choice[][] chFoodSize;
	private JTextField[][] tfFoodCount;
	private JLabel lseparationline;
	private JButton[] bReturnMenu, bCheckMenu;
	private int MenuCount = 0;
	private AddSQL addsql;
	private DeleteSQL deletesql;
	private int SQLNumber = 1;
	private ArrayList<String> FoodList = new ArrayList<String>();
	private int FoodListCount = 0;
	private String stReplaceFoodMoney;
	private int inReplaceFoodMoney;
	
	private JPanel pCheck;
	private JButton bCheckReturn;
	private JLabel lCheck;
	private ArrayList<JLabel> arCheck = new ArrayList<JLabel>();
	private GridBagConstraints gbcCheck;
	private JButton bCancel;
	
	
	public Home(JPanel pCardHome) {

		cHome = new CardLayout();
		this.pCardHome = pCardHome;
		pCardHome.setLayout(cHome);

		sHome = new ScrollPane();
		gbcHome = new GridBagConstraints();
		pHome = new JPanel(new GridBagLayout());
		pHome.setPreferredSize(new Dimension(500, 4400));
		pHome.setBackground(Color.WHITE);
		sHome.add(pHome);
		this.pCardHome.add(sHome, "Home");
		setHome();
		
		scMenu = new ScrollPane[10];
		gbcMenu = new GridBagConstraints[10];
		pMenu = new JPanel[10];
		setMenu();
		
		gbcCheck = new GridBagConstraints();
		gbcCheck.insets = new Insets(5,5,5,5);
		pCheck = new JPanel(new GridBagLayout());
		pCheck.setBackground(Color.WHITE);
		bCheckReturn = new JButton("Retrun");
		bCheckReturn.setBackground(Color.BLUE);
		bCheckReturn.setFont(new Font("Arial",Font.PLAIN,30));
		bCheckReturn.setForeground(Color.YELLOW);
		bCheckReturn.addActionListener(this);
		gbcCheck.anchor = GridBagConstraints.CENTER;
		setCheckGridBagConstraints(0,0,2,1);
		pCheck.add(bCheckReturn, gbcCheck);
		bCancel = new JButton("Cancel");
		bCancel.setBackground(Color.BLUE);
		bCancel.setForeground(Color.YELLOW);
		bCancel.setFont(new Font("Arial",Font.PLAIN,30));
		bCancel.addActionListener(this);
		setCheckGridBagConstraints(2, 0, 2, 1);
		pCheck.add(bCancel,gbcCheck);
		lCheck = new JLabel("Check");
		lCheck.setFont(new Font("Arial",Font.PLAIN,40));
	    setCheckGridBagConstraints(0,1,5,1);
	    pCheck.add(lCheck,gbcCheck);
		this.pCardHome.add(pCheck, "Check");
		
		
	}
	
	public void setHome() {
		gbcHome.insets = new Insets(5, 5, 5, 5);

		cAnimation = new CardLayout();
		pAnimation = new JPanel(cAnimation);
		namesAnimation = new String[] { "./Animation/Animation1.jpg", "./Animation/Animation2.jpg",
				"./Animation/Animation3.jpg", "./Animation/Animation4.jpg", "./Animation/Animation5.jpg",
				"./Animation/Animation6.jpg" };
		iAnimation = new ImageIcon[6];
		bAnimation = new JButton[6];
		for (int i = 0; i < 6; i++) {
			iAnimation[i] = new ImageIcon(namesAnimation[i]);
			iAnimation[i].setImage(iAnimation[i].getImage().getScaledInstance(Hwidth, Hheight, Image.SCALE_DEFAULT));
			bAnimation[i] = new JButton(iAnimation[i]);
			bAnimation[i].setPreferredSize(new Dimension(500, 300));
			pAnimation.add(bAnimation[i]);
		}
		timeAnimation = new Timer();
		timetaskAnimation = new TimerTask() {
			@Override
			public void run() {
				cAnimation.next(pAnimation);

			}

		};
		timeAnimation.schedule(timetaskAnimation, 2 * 1000, 1 * 1000);
		setHomeGridBagConstraints(0, 0, 2, 1);
		pHome.add(pAnimation, gbcHome);

		sNameFood = new String[] { "Sanjiang Barbecue Rice", "Daqing Noodle Shop", "Golden Fairy Shrimp",
				"Life Warehouse", "Treasures", "Invincible Dumplings", "Tea Soup", "Tea Top",
				"Tiewan Thirteen Hall Ramen", "Chicory Chicken Rice" };
		sNameImage = new String[] { "./image1/Chicken Rice 1.jpg", "./image1/Daqing 1.jpg", "./image1/Jinxian 1.jpg",
				"./image1/Life 1.jpg", "./image1/Nine 1.jpg", "./image1/No Enemy 1.jpg", "./image1/Tea Soup 1.jpg",
				"./image1/Tea Top 1.jpg", "./image1/Thirteen Class 1.jpg", "./image1/Three Meat Rice 1.jpg" };
		NameFood = new JLabel[10];
		iFood = new ImageIcon[10];
		lFood = new JLabel[10];
		bOrder = new JButton[10];
		for (int i = 0; i < 10; i++) {
			NameFood[i] = new JLabel(sNameFood[i]);
			NameFood[i].setFont(new Font("", 1, 30));
			setHomeGridBagConstraints(0, 1 + 3 * i, 1, 1);
			pHome.add(NameFood[i], gbcHome);
			iFood[i] = new ImageIcon(sNameImage[i]);
			iFood[i].setImage(iFood[i].getImage().getScaledInstance(Hwidth, Hheight, Image.SCALE_DEFAULT));
			lFood[i] = new JLabel(iFood[i]);
			setHomeGridBagConstraints(0, 2 + 3 * i, 1, 1);
			pHome.add(lFood[i], gbcHome);
			bOrder[i] = new JButton("I want to order meals");
			bOrder[i].setFont(new Font("", 1, 20));
			bOrder[i].setForeground(Color.YELLOW);
			bOrder[i].setBackground(Color.BLUE);
			setHomeGridBagConstraints(0, 3 + 3 * i, 1, 1);
			pHome.add(bOrder[i], gbcHome);
			bOrder[i].addActionListener(this);
		}

	}
	public void setMenu() {
		stMenu = new String[] { "Sanjian Barbecue Rice Menu", "Daqing Noodle Shop Menu", "Gold Fairy Shrimp Menu",
				"Life Warehouse Menu", "Treasures Menu", "Invincible Dumplings Menu", "Tea Soup Menu", "Tea Top Menu",
				"Tiewan Thirteen Hall Ramen Menu", "Chicory Chicken Rice Menu" };
		iMenu = new ImageIcon[10];
		stImageMenu = new String[] { "./image1/Chicken Rice 1.jpg", "./image1/Daqing 1.jpg", "./image1/Jinxian 1.jpg",
				"./image1/Life 1.jpg", "./image1/Nine 1.jpg", "./image1/No Enemy 1.jpg", "./image1/Tea Soup 1.jpg",
				"./image1/Tea Top 1.jpg", "./image1/Thirteen Class 1.jpg", "./image1/Three Meat Rice 1.jpg", };
		lMenu = new JLabel[10];
		sFoodName = new String[][] {
				{ "Meatball Soup", "Grilled Chicken Drumstick with Rice", "Grilled Pork Chop with Rice",
						"Grilled Beef Steak with Rice", "Double Set for Two", "Fried Rice with Beef and Egg",
						"Fried Rice with Shrimp and Egg", "Deep-fried Pork Chop with Rice",
						"Grilled Mackerel with Rice", "Fried Rice with Chicken and Egg", "Grilled Salmon with Rice",
						"Grilled Matsuzaka Pork" },
				{ "Egg Drop Soup", "Handmade Dried Egg Noodles", "Clam Noodles", "Mushroom and Meatball Soup",
						"Noodles with Paste and Sesame Sauce", "Assorted Noodles", "Pork with Pickled Cabbage Noodles",
						"Spicy Pork Wonton Noodles", "Ramen with Soybean Paste", "Chili Thin Noodles",
						"Signature Century Egg Tofu", "Hot and Spicy Dish with Bread Stick" },
				{ "Shrimp Roll Rice", "Deep-Fried Chicken Drumstick Rice", "Pork Rib Rice", "Chicken Chop Rice",
						"Cod Fish Rice", "Braised Chicken Drumstick Rice", "Salmon Rice", "Soy-Stewed Pork Rice",
						"Pork Feet Rice", "Crispy Chicken Thigh Rice", "Braised Pork Rice with Vegetable",
						"Chicken Drumstick Noodles" },
				{ "Sauteed Pork Chop Quinoa Bento", "Prime Beef Short Ribs Quinoa Bento", "Grilled Chicken Breast",
						"Grilled Chicken Breast Quinoa Bento", "Beggie Quinoa Bento",
						"Taiwanese Pork Jowl Quinoa Bento", "Fresh Shrimp Quinoa Bento", "Salmon Quinoa Bento",
						"Lamb Chop Breast Quinoa Bento", "French Gratin Lobster Quinoa Bento", "Calamari Quinoa Bento",
						"New Zealand Pink Eel Quinoa Bento" },
				{ "Deep-Fried Pork Rib", "Vegetable Rice with Pork Rib", "Meat Sticky Rice Dumpling",
						"Rice with Chicken Drumstick", "Ham Stir-Fried Rice with Shrimp",
						"Beef Stir-Fried Rice with Pepper", "Fresh Meat Wonton Soup", "Egg Drop Soup with Vegetable",
						"Sesame Tangyuan", "Shrimp Stir-Fried Rice", "Vegetable and Meat Wonton Soup",
						"Pickled Cabbage Soup Noodles" },
				{ "Cabbage Pork Dumplings", "Leek Pork Dumplings", "Sweet and Sour Soup", "Scallion Pancake",
						"Corn Pork Dumpling", "Assorted Soup Noodles", "Leek Shrimp Dumpling",
						"Pork and Cabbage Dried Noodles", "Deep-fried Dumplings", "Veggie Dumplings",
						"Beef Soup Dumplings", "Sweet and Sour Soup Dumplings" },
				{ "Yakult Green Tea", "Sugarcane Black Tea", "Charbroiled Iron Guanyin", "Tapioca Milk Tea",
						"Black Tea Latte", "Fruit Tea", "Red Bean Latte with Tapioca", "Special Black Tea",
						"White Gourd Guanyin with Tapioca", "Kumquat Lemon", "Special Tea Latte", "Oriental Beauty" },
				{ "Jasmine Green Tea", "Milk Tea with Tapioca", "Signature Alpine Green Tea", "Sago Soup with Taro",
						"Green Tea with Yakult", "Fresh Fruit Juice", "Tapioca Milk Tea with Taro Rice Ball",
						"Fruit Black Tea", "Cold Brewed Lishan Oolong Tea", "Cold Btewed Osmanthus Oolong Tea",
						"Iron Guanyin with Milk Cap", "Cold Brewed Green Tea" },
				{ "Chicken Chop and Spicy Ramen", "Pork Chop and Spicy Ramen", "Fried Chicken and Spicy Ramen",
						"Chicken and Sapporo Miso Ramen", "Pork Chop and Tonkotsu Ramen",
						"Fried Chicken and Tonkotsu Ramen", "Pork Chop and Soy Sauce Ramen",
						"Chicken Chop and Tonkotsu Ramen", "Deep-Fried with Pork Broth Ramen",
						"Fried Chicken with Pork Ramen", "Noodles", "Suger Egg" },
				{ "Chicken Rice", "Braised Chicken Rice", "Braised Pork Rice", "Mixed Soup", "Kelp Egg Drop Soup",
						"Cold Noodles with Soybean Paste", "Original Cold Noodles", "Meatball Soup", "Miso Soup",
						"Miso Egg Drop Soup", "Miso Soup with Meatball", "Braised Tofu" } };
		lFoodName = new JLabel[10][12];
		sFoodMoney = new String[][] {
				{ "30  dollars", "130  dollars", "110  dollars", "140  dollars", "180  dollars", "100  dollars",
						"100  dollars", "100  dollars", "130  dollars", "100  dollars", "130  dollars", "80  dollars" },
				{ "40  dollars", "60  dollars", "140  dollars", "40  dollars", "85  dollars", "140  dollars", "95  dollars",
						"95  dollars", "75  dollars", "75  dollars", "60  dollars", "80  dollars" },
				{ "155  dollars", "165  dollars", "155  dollars", "165  dollars", "165  dollars", "165  dollars",
						"160  dollars", "155  dollars", "155  dollars", "140  dollars", "95  dollars", "165  dollars" },
				{ "280  dollars", "380  dollars", "125  dollars", "260  dollars", "260  dollars", "320  dollars",
						"299  dollars", "320  dollars", "480  dollars", "580  dollars", "299  dollars", "350  dollars" },
				{ "80  dollars", "110  dollars", "70  dollars", "120  dollars", "130  dollars", "120  dollars", "70  dollars",
						"50  dollars", "75  dollars", "130  dollars", "95  dollars", "90  dollars" },
				{ "90  dollars", "90  dollars", "50  dollars", "60  dollars", "90  dollars", "150  dollars", "120  dollars",
						"100  dollars", "230  dollars", "100  dollars", "130  dollars", "120  dollars" },
				{ "50  dollars", "25  dollars", "35  dollars", "49  dollars", "59  dollars", "59  dollars", "69  dollars",
						"35  dollars", "49  dollars", "55  dollars", "60  dollars", "60  dollars" },
				{ "25  dollars", "45  dollars", "30  dollars", "60  dollars", "45  dollars", "50  dollars", "50  dollars",
						"40  dollars", "39  dollars", "49  dollars", "45  dollars", "30  dollars" },
				{ "240  dollars", "240  dollars", "240  dollars", "240  dollars", "240  dollars", "240  dollars",
						"240  dollars", "240  dollars", "240  dollars", "240  dollars", "20  dollars", "30  dollars" },
				{ "60  dollars", "70  dollars", "60  dollars", "50  dollars", "35  dollars", "70  dollars", "55  dollars",
						"35  dollars", "25  dollars", "35  dollars", "45  dollars", "15  dollars" } };
		lFoodMoney = new JLabel[10][12];
		bbuy = new JButton[10][12];
		bdelete = new JButton[10][12];
		tfFoodNumber = new JTextField[10][12];
		chFoodSize = new Choice[10][12];
		tfFoodCount = new JTextField[10][12];
		bReturnMenu = new JButton[10];
		bCheckMenu = new JButton[10];
		
		for (int i = 0; i < 10; i++) {
			scMenu[i] = new ScrollPane();
			gbcMenu[i] = new GridBagConstraints();
			pMenu[i] = new JPanel(new GridBagLayout());
			pMenu[i].setPreferredSize(new Dimension(500, 5000));
			pMenu[i].setBackground(Color.WHITE);
			scMenu[i].add(pMenu[i]);
			this.pCardHome.add(scMenu[i], stMenu[i]);

			iMenu[i] = new ImageIcon(stImageMenu[i]);
			iMenu[i].setImage(iMenu[i].getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT));
			lMenu[i] = new JLabel(iMenu[i]);
			setMenuGridBagConstraints(0, 0, 2, 1);
			pMenu[i].add(lMenu[i], gbcMenu[i]);

			for (int j = 0; j < 12; j++) {
				gbcMenu[i].anchor = GridBagConstraints.WEST;
				gbcMenu[i].insets = new Insets(10, 10, 10, 10);
				lFoodName[i][j] = new JLabel(sFoodName[i][j]);
				lFoodName[i][j].setFont(new Font("Arial", Font.PLAIN, 30));
				setMenuGridBagConstraints(0, 7 * j + 1, 2, 1);
				pMenu[i].add(lFoodName[i][j], gbcMenu[i]);
				lFoodMoney[i][j] = new JLabel(sFoodMoney[i][j]);
				lFoodMoney[i][j].setFont(new Font("Arial", Font.PLAIN, 30));
				setMenuGridBagConstraints(0, 7 * j + 2, 2, 1);
				pMenu[i].add(lFoodMoney[i][j], gbcMenu[i]);
				bbuy[i][j] = new JButton("Buy");
				bbuy[i][j].setBackground(Color.BLUE);
				bbuy[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
				bbuy[i][j].setForeground(Color.YELLOW);
				setMenuGridBagConstraints(0, 7 * j + 3, 1, 1);
				pMenu[i].add(bbuy[i][j], gbcMenu[i]);
				bbuy[i][j].addActionListener(this);
				bdelete[i][j] = new JButton("Delete");
				bdelete[i][j].setBackground(Color.BLUE);
				bdelete[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
				bdelete[i][j].setForeground(Color.YELLOW);
				setMenuGridBagConstraints(1, 7 * j + 3, 1, 1);
				pMenu[i].add(bdelete[i][j], gbcMenu[i]);
				bdelete[i][j].addActionListener(this);	
				tfFoodNumber[i][j] = new JTextField(6);
				tfFoodNumber[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
				setMenuGridBagConstraints(0, 7 * j + 4, 1, 1);
				pMenu[i].add(tfFoodNumber[i][j], gbcMenu[i]);
				lNumberSizeCount = new JLabel("number");
				lNumberSizeCount.setFont(new Font("Arial", Font.PLAIN, 30));
				setMenuGridBagConstraints(1, 7 * j + 4, 1, 1);
				pMenu[i].add(lNumberSizeCount, gbcMenu[i]);	
				tfFoodCount[i][j] = new JTextField(6);
				tfFoodCount[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
				setMenuGridBagConstraints(0, 7 * j + 5, 1, 1);
				pMenu[i].add(tfFoodCount[i][j], gbcMenu[i]);
				lNumberSizeCount = new JLabel("share");
				lNumberSizeCount.setFont(new Font("Arial", Font.PLAIN, 30));
				setMenuGridBagConstraints(1, 7 * j + 5, 1, 1);
				pMenu[i].add(lNumberSizeCount, gbcMenu[i]);	
				chFoodSize[i][j] = new Choice();
				chFoodSize[i][j].setPreferredSize(new Dimension(100, 5));
				chFoodSize[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
				chFoodSize[i][j].add(" ");
				chFoodSize[i][j].add("small");
				chFoodSize[i][j].add("medium");
				chFoodSize[i][j].add("large");
				setMenuGridBagConstraints(0, 7 * j + 6, 1, 1);
				pMenu[i].add(chFoodSize[i][j], gbcMenu[i]);
				lNumberSizeCount = new JLabel("size");
				lNumberSizeCount.setFont(new Font("Arial", Font.PLAIN, 30));
				setMenuGridBagConstraints(1, 7 * j + 6, 1, 1);
				pMenu[i].add(lNumberSizeCount, gbcMenu[i]);		

				if (j < 11) {
					lseparationline = new JLabel("--------------------------------------------------");
					lseparationline.setFont(new Font("Arial", Font.PLAIN, 30));
					setMenuGridBagConstraints(0, 7 * j + 7, 2, 1);
					pMenu[i].add(lseparationline, gbcMenu[i]);
				}
				

			}
			bReturnMenu[i] = new JButton("Return");
			bReturnMenu[i].setBackground(Color.BLUE);
			bReturnMenu[i].setFont(new Font("Arial", Font.PLAIN, 30));
			bReturnMenu[i].setForeground(Color.YELLOW);
			bReturnMenu[i].addActionListener(this);
			gbcMenu[i].gridx = 0;
			gbcMenu[i].gridy = 84;
			gbcMenu[i].gridwidth = 1;
			gbcMenu[i].gridheight = 1;
			pMenu[i].add(bReturnMenu[i], gbcMenu[i]);
			bCheckMenu[i] = new JButton("Check");
			bCheckMenu[i].setBackground(Color.BLUE);
			bCheckMenu[i].setFont(new Font("Arial", Font.PLAIN, 30));
			bCheckMenu[i].setForeground(Color.YELLOW);
			bCheckMenu[i].addActionListener(this);
			gbcMenu[i].gridx = 1;
			pMenu[i].add(bCheckMenu[i], gbcMenu[i]);
			MenuCount++;
		}
	}
	public void setHomeGridBagConstraints(int x, int y, int w, int h) {
		gbcHome.gridx = x;
		gbcHome.gridy = y;
		gbcHome.gridwidth = w;
		gbcHome.gridheight = h;
	}

	public void setMenuGridBagConstraints(int x, int y, int w, int h) {
		gbcMenu[MenuCount].gridx = x;
		gbcMenu[MenuCount].gridy = y;
		gbcMenu[MenuCount].gridwidth = w;
		gbcMenu[MenuCount].gridheight = h;
	}

	
	public void setCheckGridBagConstraints(int x, int y, int w, int h) {
		gbcCheck.gridx = x;
		gbcCheck.gridy = y;
		gbcCheck.gridwidth = w;
		gbcCheck.gridheight = h;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int j=0;j<10;j++) {
			for(int i=0;i<12;i++) {
				if(e.getSource()==bReturnMenu[j]) {
					cHome.show(pCardHome, "Home");
				}else if(e.getSource()==bOrder[j]) {
					cHome.show(pCardHome, stMenu[j]);
				}else if(e.getSource()==bbuy[j][i]) {
					FoodList.add(String.valueOf(SQLNumber));
					FoodList.add(chFoodSize[j][i].getSelectedItem());
					FoodList.add(tfFoodCount[j][i].getText());
					stReplaceFoodMoney = sFoodMoney[j][i];
					if(stReplaceFoodMoney.length()==11) {
						stReplaceFoodMoney = stReplaceFoodMoney.substring(0, 2);
					}else {
						stReplaceFoodMoney = stReplaceFoodMoney.substring(0, 3);
					}
					if(chFoodSize[j][i].getSelectedItem() =="small") {
						inReplaceFoodMoney = (Integer.parseInt(stReplaceFoodMoney) - 20)*Integer.parseInt(tfFoodCount[j][i].getText());
					}else if(chFoodSize[j][i].getSelectedItem() == "medium"){
						inReplaceFoodMoney = Integer.parseInt(stReplaceFoodMoney)*Integer.parseInt(tfFoodCount[j][i].getText());
					}else if(chFoodSize[j][i].getSelectedItem() == "large") {
						inReplaceFoodMoney = (Integer.parseInt(stReplaceFoodMoney) + 20)*Integer.parseInt(tfFoodCount[j][i].getText());
					}
					FoodList.add(String.valueOf(inReplaceFoodMoney));
					FoodList.add(sFoodName[j][i]);
					
					addsql = new AddSQL(SQLNumber,chFoodSize[j][i].getSelectedItem(),Integer.valueOf(tfFoodCount[j][i].getText()),
							inReplaceFoodMoney,sFoodName[j][i]);
					FoodListCount += 5;
					SQLNumber++;
				}else if(e.getSource()==bdelete[j][i]) {
//					for(int k=0;k<FoodListCount;k++) {
//						System.out.println("我是第"+k+"個:"+FoodList.get(k));
//					}
//					int test1 = Integer.parseInt(tfFoodNumber[j][i].getText());
//					for(int k=0;k<(FoodListCount/5);k++) {
//						String str = FoodList.get(5*k);
//						int test2 = Integer.parseInt(str);
//						if(test1==test2) {
//							System.out.println("k是:"+k);
//							FoodList.remove(5*k);
//						}
//					}
//					FoodListCount -=5;
//					for(int k=0;k<FoodListCount;k++) {
//						System.out.println("我是第"+k+"個:"+FoodList.get(k));
//					}
					deletesql = new DeleteSQL(Integer.valueOf(tfFoodNumber[j][i].getText()));
				}else if(e.getSource()==bCheckMenu[j]) {
					for(int k=1;k<=(FoodListCount/5);k++) {
						for(int z=0;z<5;z++) {
							arCheck.add(new JLabel(FoodList.get(z + 5*k - 5)));
							arCheck.get(z + 5*k - 5).setFont(new Font("Arial",Font.PLAIN,20));
							gbcCheck.anchor = GridBagConstraints.CENTER;
							setCheckGridBagConstraints(z,k + 1,1,1);
							pCheck.add(arCheck.get(z + 5*k - 5), gbcCheck);
						}
					}
					cHome.show(pCardHome, "Check");
				}else if(e.getSource()==bCheckReturn) {
					cHome.show(pCardHome, "Home");
				}else if(e.getSource()==bCancel) {
					for(int k=0;k<FoodListCount;k++) {
						arCheck.get(k).setVisible(false);
					}
					FoodListCount = 0;
					
				}

			}
		}
		
		
	}
	
}
