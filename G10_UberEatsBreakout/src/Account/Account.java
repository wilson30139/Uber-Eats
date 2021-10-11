package Account;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

import Main.MP3;

public class Account implements ActionListener {
	private CardLayout c;
	private String filename;
	private String[] FName, FImage, FText;
	private MP3 mp3;
	private JPanel pAccount, pUpAccount, pfavorite, pfavorite2, ppaymentsetting, pHelp, pHelp2;
	private JButton selectmusic, favorite, payset, help, freefood, preferential, register, set, return_1, return_2,
			return_3, resume, suspend, checkinfo, masterBtn, newpayment, pastorder, accountpay, UEguide, viewpastaid,
			bOrder;
	private JLabel pay, payway, password, FYourFavorite, HelpTop, HPicture, HLastOrder, HPictureName, HText,
			HOtherTheme, HCustomerInfo;
	private JLabel[] FLabel, FNameLabel, FTextLabel;
	private ImageIcon mastercard, arrow, HIcon;
	private ImageIcon[] FIcon;
	private ScrollPane F, H;
	private GridBagConstraints gbc;

	public Account(JPanel pAccount) {
		gbc = new GridBagConstraints();

		pUpAccount = new JPanel();
		pUpAccount.setBackground(Color.WHITE);
		this.pUpAccount.setLayout(null);

		this.pAccount = pAccount;
		this.pAccount.setBackground(Color.WHITE);
		pUpAccount.setPreferredSize(new Dimension(620, 700));
		this.pAccount.add(pUpAccount);

		pfavorite = new JPanel();
		pfavorite.setBackground(Color.WHITE);
		pfavorite.setPreferredSize(new Dimension(620, 50));
		pfavorite.setVisible(false);
		this.pAccount.add(pfavorite);

		pfavorite2 = new JPanel(new GridBagLayout());
		F = new ScrollPane();
		pfavorite2.setPreferredSize(new Dimension(580, 3000));
		pfavorite2.setBackground(Color.WHITE);
		F.add(pfavorite2);
		F.setSize(600, 750);
		F.setVisible(false);
		this.pAccount.add(F);

		pHelp = new JPanel();
		pHelp.setBackground(Color.WHITE);
		pHelp.setVisible(false);
		pHelp.setPreferredSize(new Dimension(620, 50));
		pHelp.setVisible(false);
		this.pAccount.add(pHelp);

		pHelp2 = new JPanel(new GridBagLayout());
		H = new ScrollPane();
		pHelp2.setBackground(Color.WHITE);
		pHelp2.setPreferredSize(new Dimension(580, 1000));
		H.add(pHelp2);
		H.setSize(600, 750);
		H.setVisible(false);
		this.pAccount.add(H);

		ppaymentsetting = new JPanel();
		ppaymentsetting.setBackground(Color.WHITE);
		ppaymentsetting.setPreferredSize(new Dimension(620, 700));
		ppaymentsetting.setVisible(false);
		this.pAccount.add(ppaymentsetting);

		setUpAccount();
		setFavorite();
		setHelp();
		setPayment();
	}
	public void setUpAccount() {
		selectmusic = new JButton("Select Music");
		selectmusic.setBounds(150, 150, 300, 50);
		pUpAccount.add(selectmusic);
		selectmusic.addActionListener(this);

		favorite = new JButton("Your favorite");
		favorite.setBounds(150, 200, 300, 50);
		pUpAccount.add(favorite);
		favorite.addActionListener(this);

		payset = new JButton("Payment setting");
		payset.setBounds(150, 250, 300, 50);
		pUpAccount.add(payset);
		payset.addActionListener(this);

		help = new JButton("Help");
		help.setBounds(150, 300, 300, 50);
		pUpAccount.add(help);
		help.addActionListener(this);

		freefood = new JButton("Enjoy free food");
		freefood.setBounds(150, 350, 300, 50);
		pUpAccount.add(freefood);
		freefood.addActionListener(this);

		preferential = new JButton("Promotions");
		preferential.setBounds(150, 400, 300, 50);
		pUpAccount.add(preferential);
		preferential.addActionListener(this);

		register = new JButton("<html>Register UBER EATS<br>Food Delivery Service</html>");
		register.setBounds(150, 450, 300, 50);
		pUpAccount.add(register);
		register.addActionListener(this);

		set = new JButton("Setting");
		set.setBounds(150, 500, 300, 50);
		pUpAccount.add(set);
		set.addActionListener(this);

		suspend = new JButton("Suspend");
		suspend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mp3 == null) {
					System.out.println("No music");
				} else {
					mp3.stop();
				}
			}
		});
		suspend.setBounds(150, 100, 150, 50);
		pUpAccount.add(suspend);

		resume = new JButton("Resume");
		resume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mp3 == null) {
					System.out.println("No music");
				} else {
					mp3.resume();
				}
			}
		});
		resume.setBounds(300, 100, 150, 50);
		pUpAccount.add(resume);
	}

	public void setFavorite() { 

		pfavorite.setLayout(null);
		arrow = new ImageIcon("./image_pay/arrowhead.jpg");
		arrow.setImage(arrow.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
		return_1 = new JButton(arrow);
		return_1.setBounds(10, 0, 60, 50);
		return_1.setBorderPainted(false);
		return_1.setBackground(null);
		return_1.setFocusPainted(false);
		return_1.addActionListener(this);

		FYourFavorite = new JLabel("Your Favorite");
		FYourFavorite.setFont(new Font("", 1, 20));
		FYourFavorite.setBounds(250, 0, 200, 50);
		pfavorite.add(return_1);
		pfavorite.add(FYourFavorite);
		F.setVisible(false);

		gbc.insets = new Insets(10, 1, 10, 1);

		final int Hwidth = 200;
		final int Hheight = 200;
		final int Tsize = 25;
		final int Tsize2 = 20;

		FLabel = new JLabel[10];
		FNameLabel = new JLabel[10];
		FTextLabel = new JLabel[10];
		
		FImage = new String[] { "./image/Love Jinxian.jpg", "./image/Love Thirteen Class.jpg",
				"./image/Love Three Meat Rice.jpg", "./image/Love Nine.jpg", "./image/Love Tea Top.jpg",
				"./image/Love Daqing.jpg", "./image/Love Life.jpg", "./image/Love Tea Soup.jpg",
				"./image/Love Chicken Rice.jpg", "./image/Love No Enemy.jpg", };
		FName = new String[] { "Golden Fairy Shrimp", "Tiewan Thirteen Hall Ramen", "Chicory Chicken Rice", "Treasures",
				"Tea Top", "Daqing Noodle Shop", "Life Warehouse", "Tea Soup", "Sanjiang Barbecue Rice",
				"Invincible Dumplings" };
		FText = new String[] { "<html>$Taiwanese 30TWD fee<br>1orders<br>30~40mintues</html>",
				"<html>$Japanese  20TWD fee<br>5orders<br>25~35minutes</html>", "<html>$Taiwanese 30TWD fee<br>3orders<br>20~30minutes</html>",
				"<html>$Taiwanese 30TWD fee<br>3orders<br>30~40minutes</html>", "<html>$BubbleTea 30TWD fee<br>2orders<br>10~20minutes</html>",
				"<html>$Taiwanese 30TWD fee<br>1orders<br>30~40minutes</html>", "<html>$Healthy   30TWD fee<br>2orders<br>25~35minutes</html>",
				"<html>$BubbleTea 20TWD fee<br>1orders<br>10~20minutes</html>", "<html>$Taiwanese 20TWD fee<br>1orders<br>20~30minutes</html>",
				"<html>$Taiwanese 30TWD fee<br>1orders<br>30~40minutes</html>" };
		FIcon = new ImageIcon[10];

		for (int i = 0; i < 10; i++) {
			FIcon[i] = new ImageIcon(FImage[i]);
			FIcon[i].setImage(FIcon[i].getImage().getScaledInstance(Hwidth, Hheight, Image.SCALE_DEFAULT));
			FLabel[i] = new JLabel(FIcon[i]);
			setGridBagConstraints(0, 3 * i, 1, 2, true);
			pfavorite2.add(FLabel[i], gbc);

			FNameLabel[i] = new JLabel(FName[i]);
			FNameLabel[i].setFont(new Font("", 1, Tsize));
			setGridBagConstraints(1, 3 * i, 1, 1, true);
			pfavorite2.add(FNameLabel[i], gbc);

			FTextLabel[i] = new JLabel(FText[i]);
			FTextLabel[i].setFont(new Font("", 1, Tsize2));
			FTextLabel[i].setForeground(Color.GRAY);
			setGridBagConstraints(1, 1 + 3 * i, 1, 1, true);
			pfavorite2.add(FTextLabel[i], gbc);

			bOrder = new JButton("I want to order meals");
			bOrder.setFont(new Font("", 1, 20));
			bOrder.setForeground(Color.YELLOW);
			bOrder.setBackground(Color.BLUE);
			setGridBagConstraints(0, 2 + 3 * i, 1, 1, true);
			pfavorite2.add(bOrder, gbc);
		}
	};
	public void setPayment() { 
		ppaymentsetting.setLayout(null);

		arrow = new ImageIcon("./image_pay/arrowhead.jpg");
		arrow.setImage(arrow.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
		return_2 = new JButton(arrow);
		return_2.setBounds(10, 0, 60, 50);
		return_2.setBorderPainted(false);
		return_2.setBackground(null);
		return_2.setFocusPainted(false);
		return_2.addActionListener(this);
		ppaymentsetting.add(return_2);
		ppaymentsetting.setVisible(false);

		pay = new JLabel("Payment");
		pay.setFont(new Font("", Font.BOLD, 30));
		pay.setBounds(50, 50, 150, 100);
		ppaymentsetting.add(pay);

		payway = new JLabel("Payment Way");
		payway.setFont(new Font("", Font.BOLD, 15));
		payway.setForeground(Color.GRAY);
		payway.setBounds(55, 150, 100, 100);
		ppaymentsetting.add(payway);

		checkinfo = new JButton("View Information");
		checkinfo.setBounds(400, 250, 200, 50);
		checkinfo.setBorderPainted(false);
		checkinfo.setBackground(null);
		checkinfo.setFocusPainted(false);
		ppaymentsetting.add(checkinfo);

		mastercard = new ImageIcon("./image_pay/mastercard.jpg");
		masterBtn = new JButton(mastercard);
		masterBtn.setBounds(50, 250, 50, 50);
		masterBtn.setBorderPainted(false);
		masterBtn.setBackground(null);
		masterBtn.setFocusPainted(false);
		ppaymentsetting.add(masterBtn);

		password = new JLabel("************1234");
		password.setFont(new Font("", Font.BOLD, 20));
		password.setBounds(150, 225, 250, 100);
		ppaymentsetting.add(password);

		newpayment = new JButton("create payment way");
		newpayment.setForeground(Color.GREEN);
		newpayment.setFont(new Font("", Font.BOLD, 15));
		newpayment.setBounds(20, 350, 200, 50);
		newpayment.setBorderPainted(false);
		newpayment.setBackground(null);
		newpayment.setFocusPainted(false);
		ppaymentsetting.add(newpayment);
	};
	public void setHelp() { 
		pHelp.setLayout(null);
		arrow = new ImageIcon("./image_pay/arrowhead.jpg");
		arrow.setImage(arrow.getImage().getScaledInstance(60, 50, Image.SCALE_DEFAULT));
		return_3 = new JButton(arrow);
		return_3.setBounds(10, 0, 60, 50);
		return_3.setBorderPainted(false);
		return_3.setBackground(null);
		return_3.setFocusPainted(false);
		return_3.addActionListener(this);

		HelpTop = new JLabel("What kind of assistance do you need?");
		HelpTop.setFont(new Font("", 1, 20));
		HelpTop.setBounds(150, 0, 400, 50);
		pHelp.add(return_3);
		pHelp.add(HelpTop);

		HLastOrder = new JLabel("   Previous Order");
		HLastOrder.setFont(new Font("", 1, 22));
		setGridBagConstraints(0, 0, 2, 1, true);
		pHelp2.add(HLastOrder, gbc);

		HIcon = new ImageIcon("./image1/Jinxian 1.jpg");
		HIcon.setImage(HIcon.getImage().getScaledInstance(600, 280, Image.SCALE_DEFAULT));
		HPicture = new JLabel(HIcon);
		setGridBagConstraints(0, 1, 2, 1, true);
		pHelp2.add(HPicture, gbc);

		HPictureName = new JLabel("    Golden Fairy Shrimp");
		HPictureName.setFont(new Font("", 1, 20));
		HPictureName.setBackground(Color.BLACK);
		setGridBagConstraints(0, 2, 2, 1, true);
		pHelp2.add(HPictureName, gbc);

		HText = new JLabel("     2019/5/26  am11:40");
		HText.setForeground(Color.GRAY);
		HText.setFont(new Font("", 1, 18));
		setGridBagConstraints(0, 3, 2, 1, true);
		pHelp2.add(HText, gbc);

		HOtherTheme = new JLabel("    Other Topics");
		HOtherTheme.setFont(new Font("", 1, 22));
		HOtherTheme.setBackground(Color.BLACK);
		setGridBagConstraints(0, 4, 2, 1, true);
		pHelp2.add(HOtherTheme, gbc);

		pastorder = new JButton("Past Order");
		pastorder.setFont(new Font("", 1, 20));
		pastorder.setForeground(Color.GRAY);
		setGridBagConstraints(0, 5, 2, 1, true);
		pastorder.setBorderPainted(false);
		pastorder.setFocusPainted(false);
		pHelp2.add(pastorder, gbc);

		accountpay = new JButton("Account And Payment");
		accountpay.setFont(new Font("", 1, 20));
		accountpay.setForeground(Color.GRAY);
		setGridBagConstraints(0, 6, 2, 1, true);
		accountpay.setBorderPainted(false);
		accountpay.setFocusPainted(false);
		pHelp2.add(accountpay, gbc);

		UEguide = new JButton("Uber Eats Guide");
		UEguide.setFont(new Font("", 1, 20));
		UEguide.setForeground(Color.GRAY);
		setGridBagConstraints(0, 7, 2, 1, true);
		UEguide.setBorderPainted(false);
		UEguide.setFocusPainted(false);
		pHelp2.add(UEguide, gbc);

		HCustomerInfo = new JLabel("    Customer Service Message");
		HCustomerInfo.setFont(new Font("", 1, 22));
		HCustomerInfo.setBackground(Color.BLACK);
		setGridBagConstraints(0, 8, 2, 1, true);
		pHelp2.add(HCustomerInfo, gbc);

		viewpastaid = new JButton("View Past Assistance");
		viewpastaid.setFont(new Font("", 1, 20));
		viewpastaid.setForeground(Color.GRAY);
		setGridBagConstraints(0, 9, 2, 1, true);
		viewpastaid.setBorderPainted(false);
		viewpastaid.setFocusPainted(false);
		pHelp2.add(viewpastaid, gbc);
	};
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == selectmusic) {
			if (mp3 != null) {
				mp3.stop();
			}
			String userhome = System.getProperty("user.dir");
			System.out.println(userhome);
			JFileChooser jfc = new JFileChooser(userhome + "/music/");

			int returnValue = jfc.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				filename = selectedFile.getAbsolutePath();
			}
			mp3 = new MP3(filename);
			mp3.setLoop(true);
			mp3.play();
		} else if (e.getSource() == favorite) {
			pUpAccount.setVisible(false);
			pfavorite.setVisible(true);
			F.setVisible(true);
			System.out.println("Your favotite");
		} else if (e.getSource() == payset) {
			pUpAccount.setVisible(false);
			ppaymentsetting.setVisible(true);
			System.out.println("Payment setting");
		} else if (e.getSource() == help) {
			pUpAccount.setVisible(false);
			pHelp.setVisible(true);
			H.setVisible(true);
			System.out.println("Help");
		} else if (e.getSource() == return_1) {
			pfavorite.setVisible(false);
			pUpAccount.setVisible(true);
			F.setVisible(false);
			System.out.println("return");
		} else if (e.getSource() == return_2) {
			ppaymentsetting.setVisible(false);
			pUpAccount.setVisible(true);
			System.out.println("return");
		} else if (e.getSource() == return_3) {
			pHelp.setVisible(false);
			H.setVisible(false);
			pUpAccount.setVisible(true);
			System.out.println("return");
		}
	}
	public void setGridBagConstraints(int x, int y, int w, int h, boolean fill) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = h;
		gbc.gridwidth = w;
		if (fill)
			gbc.fill = GridBagConstraints.BOTH;
	}
}
