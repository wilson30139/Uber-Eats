package List;
import java.awt.*;
import javax.swing.*;
public class List {
	private ScrollPane sList = new ScrollPane();
	private JPanel pList;
	private JLabel lChicken_Rice_1,lChicken_Rice_2,lChicken_Rice_3,lChicken_Rice_4,lChicken_Rice_5;
	private JLabel lChicken_Rice_6,lChicken_Rice_7;
	private JButton resubscrible_Chicken_Rice,detail_Chicken_Rice,gethelp_Chicken_Rice,Menu_Chicken_Rice;
	private ImageIcon iChicken_Rice;
	public List(ScrollPane sList) {
		this.sList = sList;
		pList = new JPanel();
		pList.setLayout(null);
		pList.setBackground(Color.WHITE);
		pList.setPreferredSize(new Dimension(600,2400));
		sList.add(pList);
		setList();
	}
	public void setList() {
		lChicken_Rice_1 = new JLabel("Order has been sent");
		lChicken_Rice_1.setFont(new Font("",Font.BOLD,20));
		lChicken_Rice_1.setBounds(50,150,200,200);
		pList.add(lChicken_Rice_1);
		
		lChicken_Rice_2 = new JLabel("<html> 2019/5/26 am11:40 <br> Order number C144A </html>");
		lChicken_Rice_2.setFont(new Font("",Font.BOLD,15));
		lChicken_Rice_2.setBounds(50,180,200,200);
		pList.add(lChicken_Rice_2);
		
		lChicken_Rice_3 = new JLabel("________________________________________________________________________________");
		lChicken_Rice_3.setFont(new Font("",Font.BOLD,20));
		lChicken_Rice_3.setBounds(0,250,800,200);
		pList.add(lChicken_Rice_3);
		
		lChicken_Rice_4 = new JLabel("Grilled Pork Chop with Rice");
		lChicken_Rice_4.setFont(new Font("",Font.BOLD,20));
		lChicken_Rice_4.setBounds(50,300,400,200);
	    pList.add(lChicken_Rice_4);
	    
//		lChicken_Rice_5 = new JLabel("Grilled Chicken Drumstick with Rice");
//		lChicken_Rice_6 = new JLabel("Meatball Soup");
//	    
		lChicken_Rice_7 = new JLabel("________________________________________________________________________________");
		lChicken_Rice_7.setFont(new Font("",Font.BOLD,20));
		lChicken_Rice_7.setBounds(0,350,800,200);
	    pList.add(lChicken_Rice_7);
	    
		resubscrible_Chicken_Rice = new JButton("repeat an order");
		resubscrible_Chicken_Rice.setBackground(Color.GREEN);
		resubscrible_Chicken_Rice.setBounds(400, 500, 150, 50);
	    pList.add(resubscrible_Chicken_Rice);
	    
		detail_Chicken_Rice = new JButton("view electronic details");
		detail_Chicken_Rice.setBounds(0, 600, 300, 50);
		pList.add(detail_Chicken_Rice);
	    
		gethelp_Chicken_Rice = new JButton("get help");
		gethelp_Chicken_Rice.setBounds(300, 600, 300, 50);
	    pList.add(gethelp_Chicken_Rice);
	    
	    iChicken_Rice = new ImageIcon("./image3/Chicken Rice.jpg");
	    Menu_Chicken_Rice = new JButton(iChicken_Rice);
	    Menu_Chicken_Rice.setIcon(iChicken_Rice);
	    Menu_Chicken_Rice.setBounds(10, 20, 580, 200);
		pList.add(Menu_Chicken_Rice);
		
	}
}
