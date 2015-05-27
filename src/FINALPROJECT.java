/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author johnb4223
 */

// make sure you rename this class if you are doing a copy/paste
public class FINALPROJECT extends JComponent implements KeyListener {
      
    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
  
    //controls
    boolean right = false, left = false, jump = false;
    boolean inAir = false;
    
    // gravity variable and jumping 
    int gravity = 2;
    int dy = 0;
    
    //ball variable
   Rectangle ball = new Rectangle (390, 290 , 20, 20);
    
   int ballDX = 1; //x direction of ball
   int ballDY = 1;//y direction of ball
   int ballspeed = 2;
   
    //character variables 
   
    Rectangle block1L = new Rectangle(0, 40, 450, 25);
    Rectangle block1R = new Rectangle(500, 40, 300, 25);
    Rectangle block2L = new Rectangle(0, 120, 300, 25);
    Rectangle block2R = new Rectangle(350, 120, 400, 25);

    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);
        
        g.setColor(Color.RED);
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
        
        
        
        // GAME DRAWING ENDS HERE
    }
    
    
    // The main game loop
    // In here is where all the logic for my game will go
    public void run()
    {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done)
        {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
             //move the ball
           // ball.x += ballDX*ballspeed;
           // ball.y += ballDY*ballspeed;
            
            //apply gravity
            dy = dy + gravity;
            if(right)
            {
               ball.x += 5; 
            }else if(left)
            {
                ball.x -= 5; 
            }
            if(jump && !inAir)
            {
                dy = -30;
                inAir = true;
            }
            //move player in y direction 
            ball.y += dy;
            //player hits the ground
            if(ball.y > 500)
            {
                ball.y = 500; //on the ground
                dy = 0;
                inAir = false;
            }
            
            if(ball.intersects(block1L))
            {
                handleCollision(ball,block1L);
            }else if(ball.intersects(block1R))
            {
                handleCollision(ball, block1R);
            }
            
            
    
           
          

            // GAME LOGIC ENDS HERE 
            
            // update the drawing (calls paintComponent)
            repaint();
            
            
            
            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            if(deltaTime > desiredTime)
            {
                //took too much time, don't wait
            }else
            {
                try
                {
                    Thread.sleep(desiredTime - deltaTime);
                }catch(Exception e){};
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");
       
        // creates an instance of my game
        FINALPROJECT game = new FINALPROJECT();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        // adds the game to the window
        frame.add(game);
         
        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        
        // starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
      int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT)
        {
            right = true;
        }
         if(key == KeyEvent.VK_LEFT)
        {
            left = true;
        }
          if(key == KeyEvent.VK_SPACE)
        {
            jump = true;
        }  
    }

    @Override
    public void keyPressed(KeyEvent e) {
         int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT)
        {
            right = false;
        }
         if(key == KeyEvent.VK_LEFT)
        {
            left = false;
        }
          if(key == KeyEvent.VK_SPACE)
        {
            jump = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
     public void handleCollision (Rectangle player, Rectangle block)
    {
        //make the little overlap rectangle
        Rectangle overlap = player.intersection(block);
        
        //handle collision
        //if the height is bigger
        //height overpowers width so correct left/right 
        if(overlap.height > overlap.width)
        {
            //player is on the left
            if(player.x < block.x)
            {
                player.x -= overlap.width;
            }else if(player.x + player.width > block.x + block.width)
            {
                player.x += overlap.width;
            }
        }else
        {
            dy = 0;
            if (player.y < block.y)
            {
                //moves player up to correct 
                player.y -= overlap.height;
                // I have landed 
                inAir = false;
            }else if (player.y + player.height > block.y + block.height)
            {
                player.y += overlap.height;
            }
        }
    }
}
