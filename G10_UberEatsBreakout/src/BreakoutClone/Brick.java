package BreakoutClone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;


public class Brick {
	
	static int []brick_x = new int [10];
	static int []brick_y = new int [10];
	static int []brick_size_x = new int [10];
	static int []brick_size_y = new int [10];
	private static  Color color ;
    private static final Color DEFAULT_COLOR = Color.GREEN;
    
    public Brick(int[] brick_x, int[] brick_y,int[]  brick_size_x,int[]  brick_size_y,Color colorBrick) {
	    Brick.brick_x = brick_x;
	    Brick.brick_y = brick_y;
	    Brick.brick_size_x =brick_size_x;
	    Brick.brick_size_y =brick_size_y;
    }
/*	
    public Brick(int[] brick_x, int[] brick_y,int[]  brick_size_x,int[]  brick_size_y[]) {
     	this(int[] brick_x, int[] brick_y,int[]  brick_size_x,int[]  brick_size_y[], DEFAULT_COLOR);
     }
     */
   
    
    public void draw (Graphics g)
	{  
    	
    	for ( int i = 0 ; i < 8 ; i++ )
		{
			brick_x[i] = 40 + i * 50; 
			brick_y[i] = 100;
			brick_size_x[i] = 50;
			brick_size_y[i] = 30;
		}
    	//super.paint(g);
    	
		g.setColor(color);
		for ( int i = 0 ; i < 8 ; i++ )
		{
			g.fillRect(brick_x[i], brick_y[i], brick_size_x[i], brick_size_y[i]);
		}
		
	}

}
