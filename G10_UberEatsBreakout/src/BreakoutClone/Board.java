package BreakoutClone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener,MouseListener,MouseMotionListener{

	static int board_x;	 
	  static int board_y;
	  static int  board_size_x;
	  static int  board_size_y;
	  static  int xdir=8;
	 private static  Color color ;
	 private static final Color DEFAULT_COLOR = Color.WHITE;
	
	 	 
     public Board(int board_x, int board_y,int  board_size_x,int  board_size_y,Color colorBoard) {
    	Board.board_x = board_x;
    	Board.board_y = board_y;
    	Board.board_size_x =board_size_x;
    	Board.board_size_y =board_size_y;
    	Board.color = colorBoard;
    	addMouseMotionListener(this);
    	addMouseListener(this);
     }
    
     
     public Board(int board_x, int board_y,int  board_size_x,int  board_size_y) {
     	this(board_x,board_y, board_size_x, board_size_y, DEFAULT_COLOR);
      }
      
     public void paint(Graphics g)  
     {
    	 super.paint(g);
    	 g.setColor(color);
		  g.drawRect(board_x, board_y, board_size_x,board_size_y);
     }
	   public static void draw(Graphics g) {
		   g.setColor(color);
		   g.drawRect(board_x, board_y, board_size_x,board_size_y);
	   }
	   
	   public void mouseMoved(MouseEvent evt)
		{
			
			board_x = evt.getX() - board_size_x/2;
		
			if (  board_x <= 0 )
				board_x  = 0;
			else if ( board_x  >= 640  - board_size_x  )
				board_x  = 640 - board_size_x;
			
			repaint();
		}
		public void mouseDragged(MouseEvent evt)
		{
		}
		
		public void actionPerformed(ActionEvent event)
		{
			//board_x=board_x+xdir;
			repaint();
		}
		

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

}
