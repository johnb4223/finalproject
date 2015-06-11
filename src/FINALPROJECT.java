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
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

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
    long desiredFPS = 30;
    long desiredTime = (1000)/desiredFPS;
  
    //controls
    boolean right = false, left = false, pause = false, enter = false;
    boolean inAir = false;
    
    // gravity variable and jumping 
    int gravity = 2;
    int dy = 0;
    
    //ball variable
   Rectangle ball = new Rectangle (390, 90 , 20, 20);
    
   int ballDX = 1; //x direction of ball
   int ballDY = 1;//y direction of ball
   int ballspeed = 5;
   
   int score = 0;
   boolean hasscored = true;
   
    //character variables 
   
   //1 3 5 6 7 STILL NEED TO ADD THEM TO MAKE THEM MOVE!!!! DO NOT FORGET
    Rectangle block1L = new Rectangle(0, 40, 100, 25);
    Rectangle block1M = new Rectangle(150, 40, 200, 25);
    Rectangle block1R = new Rectangle(400, 40, 650, 25);
    Rectangle block2L = new Rectangle(0, 120, 50, 25);
    Rectangle block2M = new Rectangle(100, 120, 350, 25);
    Rectangle block2R = new Rectangle(500, 120, 400, 25);
    Rectangle block3L = new Rectangle(0, 200, 200, 25);
    Rectangle block3M = new Rectangle(250, 200, 400, 25);
    Rectangle block3R = new Rectangle(700, 200, 650, 25);
    Rectangle block4L = new Rectangle(0, 280, 400, 25);
    Rectangle block4R = new Rectangle(450, 280, 350, 25);
    Rectangle block5L = new Rectangle(0, 360, 100, 25);
    Rectangle block5M = new Rectangle(150, 360, 550, 25);
    Rectangle block5R = new Rectangle(750, 360, 650, 25);
    Rectangle block6L = new Rectangle(0, 440, 250, 25);
    Rectangle block6M = new Rectangle(300, 440, 350, 25);   
    Rectangle block6R = new Rectangle(700, 440, 750, 25);
    Rectangle block7L = new Rectangle(0, 520, 200, 25);
    Rectangle block7M = new Rectangle(250, 520, 200, 25);
    Rectangle block7R = new Rectangle(500, 520, 850, 25);
    Rectangle block8L = new Rectangle(0, 600, 400, 25);
    Rectangle block8R = new Rectangle(450, 600, 350, 25);
    
    Rectangle[] blocks = {block1L, block1M, block1R, block2L, block2M, block2R, block3L, block3M, block3R, block4L, block4R, block5L, block5M, block5R, block6L, block6M, block6R, block7L, block7M, block7R, block8L, block8R};
    
    int blockmove = 1;
    
    int screennumber = 0;
    
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)

    
    public void paintMenuScreen(Graphics g)
    {
      // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
      // MENU
       g.drawString("PRESS ENTER TO START", WIDTH/2, HEIGHT/2); 
    }
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);
        
        //ball
        g.setColor(Color.RED);
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
        
        //"floors"
        g.setColor(Color.white);
        g.fillRect(block1L.x, block1L.y, block1L.width, block1L.height);
        g.fillRect(block1M.x, block1M.y, block1M.width, block1M.height);
        g.fillRect(block1R.x, block1R.y, block1R.width, block1R.height);
        g.fillRect(block2L.x, block2L.y, block2L.width, block2L.height);
        g.fillRect(block2M.x, block2M.y, block2M.width, block2M.height);
        g.fillRect(block2R.x, block2R.y, block2R.width, block2R.height);
        g.fillRect(block3L.x, block3L.y, block3L.width, block3L.height);
        g.fillRect(block3M.x, block3M.y, block3M.width, block3M.height);
        g.fillRect(block3R.x, block3R.y, block3R.width, block3R.height);
        g.fillRect(block4L.x, block4L.y, block4L.width, block4L.height);
        g.fillRect(block4R.x, block4R.y, block4R.width, block4R.height);
        g.fillRect(block5L.x, block5L.y, block5L.width, block5L.height);
        g.fillRect(block5M.x, block5M.y, block5M.width, block5M.height);
        g.fillRect(block5R.x, block5R.y, block5R.width, block5R.height);
        g.fillRect(block6L.x, block6L.y, block6L.width, block6L.height);
        g.fillRect(block6M.x, block6M.y, block6M.width, block6M.height);
        g.fillRect(block6R.x, block6R.y, block6R.width, block6R.height);
        g.fillRect(block7L.x, block7L.y, block7L.width, block7L.height);
        g.fillRect(block7M.x, block7M.y, block7M.width, block7M.height);
        g.fillRect(block7R.x, block7R.y, block7R.width, block7R.height);
        g.fillRect(block8L.x, block8L.y, block8L.width, block8L.height);
        g.fillRect(block8R.x, block8R.y, block8R.width, block8R.height);
        
        g.setColor(Color.red);
        g.drawString("score: " + score, 10, 10);
        
        if(ballspeed == 0 && blockmove == 0)
        {
            g.drawString("THE END", WIDTH/2, HEIGHT/2);
            g.drawString("YOUR SCORE IS: " + score, WIDTH/2 - 20, HEIGHT/2 +15);
        }
        
       // paintMenuScreen(g);
        
        
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
        
        
        while (!enter)
        {} 
        
        
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
            
           // everything happens when the game is not paused (space bar is not being held)
         
            if(!pause)
            {
                
                
            //apply gravity
            dy = dy + gravity;
            if(right)
            {
               ball.x += ballspeed; 
            }else if(left)
            {
                ball.x -= ballspeed; 
            }

            //move player in y direction 
            ball.y += dy;
            
            
            //moving the block and resetting it down at the bottom 
            for(int i = 0; i < blocks.length; i++)
            {
                blocks[i].y -= blockmove;
                if(blocks[i].y < 0)
                {
                    blocks[i]. y = 640;
                }
                
            }
            
            }
           
            //stopping the ball at the bottom
            if(ball.y > 600)
            {
                ball.y = 600;
            }
            
            //changing the speed of the floors and ball (changing difficulty) 
            if(score > 10)
            {
                blockmove = 4;
            }
            if(score > 20)
            {
                blockmove = 2;
                ballspeed = 9;
            }
            if(score > 30)
            {
                blockmove = 3;
                ballspeed = 11;
            }
            if(score > 40)
            {
                blockmove = 2;
                ballspeed = 9;
            }
            if(score > 50)
            {
                blockmove = 3;
                ballspeed = 7;
            }
            if(score > 60)
            {
                blockmove = 2;
                ballspeed = 9;
            }
            if(score > 70)
            {
                blockmove = 3;
                ballspeed = 11;
            }
            if(score > 80)
            {
                blockmove = 2;
                ballspeed = 9;
            }
            if(score > 90)
            {
                blockmove = 3;
                ballspeed = 7;
            }
            
            //ending the game if the ball hits the top of the screen
              if(ball.y < 0)
            {
                blockmove = 0;
                ballspeed = 0;
                
            }
            //handling the collisions and adding to the score each time it hits the floor          
            boolean collides = false;
            for(int i = 0; i < blocks.length; i ++)
            {
                if(ball.intersects(blocks[i]))
                {
                    collides = true;
                    if(!hasscored)
                    {
                        score ++;
                        hasscored = true;
                    }
                    handleCollision(ball,blocks[i]);
                    break;
                }
            }
            if(!collides)
            {
                hasscored = false;
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
        frame.addKeyListener(game);

        // starts my game loop
        game.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
         int key = e.getKeyCode();
         
        if(key == KeyEvent.VK_ENTER)
        {
            enter = true;
        }
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
            if(!pause)
            {
                  pause = true;
            }else
            {
                  pause = false;
            }
        }  
          
       
       
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT)
        {
            right = false;
        }
         if(key == KeyEvent.VK_LEFT)
        {
            left = false;
        }
         
       
            
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
            //ball is on the left
            if(ball.x < block.x)
            {
                ball.x -= overlap.width;
            }else if(ball.x + ball.width > block.x + block.width)
            {
                ball.x += overlap.width;
            }
        }else
        {
            dy = 0;
            if (ball.y < block.y)
            {
                //moves player up to correct 
                ball.y -= overlap.height;
                // I have landed 
                inAir = false;
            }else if (ball.y + ball.height > block.y + block.height)
            {
                ball.y += overlap.height;
            }
        }
    }



}
