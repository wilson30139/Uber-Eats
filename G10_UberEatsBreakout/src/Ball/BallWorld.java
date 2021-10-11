package Ball;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;
import javax.swing.*;



public class BallWorld extends JPanel {
	
	private JLabel lUberEats_1,lUberEats_2;
	private JButton bEnter;
	
	private static final int UPDATE_RATE = 30;

	private final int MAX = 30;
	private Ball[] ball;
//	private Ball ball;
//	private Ball ball2;
	private ContainerBox box;

	private DrawCanvas canvas;
	private int canvasWidth;
	private int canvasHeight;
	Thread gameThread;

	private volatile boolean running = true;

	public BallWorld(int width, int height, JButton bEnter) {
		
		lUberEats_1 = new JLabel("Uber");
		lUberEats_1.setForeground(Color.WHITE);
		lUberEats_1.setFont(new Font("",1,70));
		lUberEats_1.setBounds(220, 200, 200, 150);
		this.add(lUberEats_1);
		
		lUberEats_2 = new JLabel("Eats");
		lUberEats_2.setForeground(Color.GREEN);
		lUberEats_2.setFont(new Font("",1,70));
		lUberEats_2.setBounds(220, 260, 200, 150);
		this.add(lUberEats_2);
		
		this.bEnter = bEnter;
		this.bEnter.setForeground(Color.BLUE);
		this.bEnter.setFont(new Font("",1,20));
		this.bEnter.setBounds(250, 380, 100, 50);
		this.bEnter.setBackground(new Color(0,255,255));
		this.add(this.bEnter);
		
		canvasWidth = width;
		canvasHeight = height;

		Random rand = new Random();
		
		ball = new Ball[MAX];
		for(int i=0;i<ball.length;i++) {
			int radius = rand.nextInt(30)+20;
			int x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
			int y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
			
			int speed = 5;
			int angleInDegree = rand.nextInt(360);
			ball[i] = new Ball(x, y, radius, speed, angleInDegree, new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256),125));
		}

		box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.WHITE);

		canvas = new DrawCanvas();
		this.setLayout(new BorderLayout());
		this.add(canvas, BorderLayout.CENTER);

		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Component c = (Component) e.getSource();
				Dimension dim = c.getSize();
				canvasWidth = dim.width;
				canvasHeight = dim.height;
				box.set(0, 0, canvasWidth, canvasHeight);
			}
		});

		gameStart();
	}

	public void gameStart() {

		gameThread = new Thread() {
			public void run() {
				while (true) {
					gameUpdate();
					repaint();
					try {
						Thread.sleep(1000 / UPDATE_RATE);
					} catch (InterruptedException ex) {
					}
				}
			}
		};
		gameThread.start();
	}

	public void gameUpdate() {
		for(int i=0;i<ball.length;i++) {
			ball[i].moveOneStepWithCollisionDetection(box);
		}
	}

	class DrawCanvas extends JPanel {

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			box.draw(g);
			for(int i=0;i<ball.length;i++) {
				ball[i].draw(g);
			}
		}

		@Override
		public Dimension getPreferredSize() {
			return (new Dimension(canvasWidth, canvasHeight));
		}
	}
	public JButton setbEnter(JButton bEnter) {	
		return this.bEnter;
	}
}