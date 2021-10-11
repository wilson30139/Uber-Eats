package BreakoutClone;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
/**
 * The control logic and main display panel for game.
 */
public class BallWorldPanel extends JPanel {
   

private static final int UPDATE_RATE = 30;  // Frames per second (fps)
   
   private Ball ball;         // A single bouncing Ball's instance
   private ContainerBox box;  // The container rectangular box
   private Board board;
   private Brick brick;
  
   private DrawCanvas canvas; // Custom canvas for drawing the box/ball
   private int canvasWidth;
   private int canvasHeight;
   
  
  
   /**
    * Constructor to create the UI components and init the game objects.
    * Set the drawing canvas to fill the screen (given its width and height).
    * 
    * @param width : screen width
    * @param height : screen height
 * @param board_y 
    */
   public BallWorldPanel(int width, int height) {
  
      canvasWidth = width;
      canvasHeight = height;
      
      // Init the ball at a random location (inside the box) and moveAngle
      Random rand = new Random();
      int radius = 10;
      int x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
      int y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
      int speed = 10;
      int angleInDegree = rand.nextInt(360);
      ball = new Ball(x, y, radius, speed, angleInDegree, Color.RED);
     
      // Init the Container Box to fill the screen
      box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.BLACK, Color.WHITE);
      
      
     int board_x=320;	 
	 int board_y=450;
	 int  board_size_x=60;
	 int  board_size_y=10;
	 //Color color =Color.WHITE;
	 //private static final Color DEFAULT_COLOR = Color.WHITE;
	 
		int []brick_x = new int [10];
	    int []brick_y = new int [10];
	    int []brick_size_x = new int [10];
	    int []brick_size_y = new int [10];
        
    
      
      board = new Board(board_x,board_y, board_size_x, board_size_y,Color.WHITE);
      
      brick = new Brick(brick_x, brick_y, brick_size_x, brick_size_y,Color.GREEN);
      
     
      // Init the custom drawing panel for drawing the game
      canvas = new DrawCanvas();
      this.setLayout(new BorderLayout());
      this.add(canvas, BorderLayout.CENTER);
      
      // Handling window resize.
      this.addComponentListener(new ComponentAdapter() {
         @Override
         public void componentResized(ComponentEvent e) {
            Component c = (Component)e.getSource();
            Dimension dim = c.getSize();
            canvasWidth = dim.width;
            canvasHeight = dim.height;
            // Adjust the bounds of the container to fill the window
            box.set(0, 0, canvasWidth, canvasHeight);
         }
      });
  
      // Start the ball bouncing
      gameStart();
   }
   
   /** Start the ball bouncing. */
   public void gameStart() {
      // Run the game logic in its own thread.
      Thread gameThread = new Thread() {
         public void run() {
            while (true) {
               // Execute one time-step for the game 
               gameUpdate();
               // Refresh the display
               repaint();
               // Delay and give other thread a chance
               try {
                  Thread.sleep(1000 / UPDATE_RATE);
               } catch (InterruptedException ex) {}
            }
         }
      };
      gameThread.start();  // Invoke GaemThread.run()
   }
   
   /** 
    * One game time-step. 
    * Update the game objects, with proper collision detection and response.
    */
   public void gameUpdate() {
      ball.moveOneStepWithCollisionDetection(box,board,brick);
   }
   
   /** The custom drawing panel for the bouncing ball (inner class). */
   class DrawCanvas extends JPanel {
      
      public void paintComponent(Graphics g) {
         super.paintComponent(g);    // Paint background
         // Draw the box and the ball
         box.draw(g);
         ball.draw(g);
       board.draw(g);
       brick.draw(g);
         // Display ball's information
         g.setColor(Color.WHITE);
         g.setFont(new Font("Courier New", Font.PLAIN, 12));
         g.drawString("Ball " + ball.toString(), 20, 30);
      }
  
      /** Called back to get the preferred size of the component. */
      @Override
      public Dimension getPreferredSize() {
         return (new Dimension(canvasWidth, canvasHeight));
      }
   }
}