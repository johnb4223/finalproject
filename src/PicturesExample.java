/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

/**
 *
 * @author johnb4223
 */

// make sure you rename this class if you are doing a copy/paste
public class PicturesExample extends JComponent implements KeyListener{

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    boolean up = false, down = false, right = false, left = false;
    //load pictures
    BufferedImage crono = ImageHelper.loadImage("pics//crono_front.png");
    BufferedImage[] runFront = new BufferedImage[6];
    
    long frameCount = 0;
    int frame = 0;
    
    int x = 100;
    int y = 100;
    int Speed = 5;
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
        
        if(down)
        {
            g.drawImage(runFront[frame],x,y,null);
        }
        g.drawImage(crono, x, y, null);
        
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
        
        runFront[0] = ImageHelper.loadImage("pics//crono_front_run.0000.png");
        runFront[1] = ImageHelper.loadImage("pics//crono_front_run.0001.png");
        runFront[2] = ImageHelper.loadImage("pics//crono_front_run.0002.png");
        runFront[3] = ImageHelper.loadImage("pics//crono_front_run.0003.png");
        runFront[4] = ImageHelper.loadImage("pics//crono_front_run.0004.png");
        runFront[5] = ImageHelper.loadImage("pics//crono_front_run.0005.png");
           
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done)
        {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            frameCount++;
            if(frameCount % 10 == 0)
            {
                frame ++;
                if(frame >= runFront.length)
                {
                    frame = 0;
                }
            }
            
            if(right)
            {
              x += Speed;  
            }else if (left)
            {
                x -= Speed;
            }
            
            if(up)
            {
              y -= Speed;  
            }else if (down)
            {
                y += Speed;
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
        PicturesExample game = new PicturesExample();
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
        if(key == KeyEvent.VK_UP)
        {
            up = true;
        }
        if(key == KeyEvent.VK_DOWN)
        {
            down = true;
        }
        if(key == KeyEvent.VK_LEFT)
        {
            left = true;
        }
        if(key == KeyEvent.VK_RIGHT)
        {
            right = true;
        }
    }
    

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP)
        {
            up = false;
        }
        if(key == KeyEvent.VK_DOWN)
        {
            down = false;
        }
        if(key == KeyEvent.VK_LEFT)
        {
            left = false;
        }
        if(key == KeyEvent.VK_RIGHT)
        {
            right = false;
        }
    }
    
}
