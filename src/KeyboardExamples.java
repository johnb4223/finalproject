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

/**
 *
 * @author johnb4223
 */

// make sure you rename this class if you are doing a copy/paste
public class KeyboardExamples extends JComponent implements KeyListener{

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    int x = 400;
    int y = 300;
    int speed = 5;
    
    boolean up = false;
    boolean down = false;
    boolean right = false;
    boolean left = false;
    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
        g.setColor(Color.RED);
        g.fillOval(x, y, 50, 50);
        
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
            
            if(up)
            {
                y = y - speed;
            }
            if(down)
            {
                y = y + speed;
            }
            if(right)
            {
                x = x + speed;
            }
            if(left)
            {
                x = x - speed;
            }

            if(x < 0)//moving off the side 
            {
                x = 0;
            }
            if(x + 50 > WIDTH)
            {
                x = WIDTH - 50;
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
        KeyboardExamples game = new KeyboardExamples();
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
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_RIGHT)
        {
            right = true;
        }else if(keyCode == KeyEvent.VK_LEFT)
        {
            left = true;
        }else if(keyCode == KeyEvent.VK_UP)
        {
            up = true;
        }else if(keyCode == KeyEvent.VK_DOWN)
        {
            down = true;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_RIGHT)
        {
            right = false;
        }else if(keyCode == KeyEvent.VK_LEFT)   
        {
            left = false;
        }else if(keyCode == KeyEvent.VK_UP)
        {
            up = false;
        }else if(keyCode == KeyEvent.VK_DOWN)
        {
            down = false;
        }
    }
