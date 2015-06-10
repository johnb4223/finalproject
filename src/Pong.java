/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author johnb4223
 */

// make sure you rename this class if you are doing a copy/paste
public class Pong extends JComponent implements KeyListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    //paddles
    //player 1
    int p1Width = 15;
    int p1Height = 120;
    int p1X = 40;
    int p1Y = HEIGHT/2 - p1Height/2;
   
    //player 2   
    int p2Width = 15;
    int p2Height = 120;
    int p2X = WIDTH - 40 - p2Width;
    int p2Y = HEIGHT/2 - p2Height/2;
    
    
    int paddleSpeed;
    
    //ball
    int ballWidth = 20;
    int ballHeight = 20;
    int ballX = WIDTH/2 - ballWidth/2; //x postion
    int ballY = HEIGHT/2 - ballHeight/2; //y position
    int ballDX = 1; //x direction of ball
    int ballDY = 1;//y direction of ball
    int ballSpeed = 5;
    
    
    //scores
    int p1Score = 0;
    int p2Score = 0;
    
    //control variables
    boolean p1Up = false;
    boolean p1Down = false;
 
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        // GAME DRAWING GOES HERE 
        
        //black background
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        //ball
        g.setColor(Color.WHITE);
        g.fillRect(ballX, ballY, ballWidth, ballHeight);
        
        //paddles
        g.fillRect(p1X, p1Y, p1Width, p1Height);
        g.fillRect(p2X, p2Y, p2Width, p2Height);
       
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
            ballX += ballDX*ballSpeed;
            ballY += ballDY*ballSpeed;
            
            //bottom of ball hits bottom of screen
            if(ballY + ballHeight > HEIGHT)
            {
                ballDY = -1;
            }
            if(ballY < 0)
            {
                ballDY = 1;
            }           
            if(ballX + ballWidth > WIDTH)
            {
                ballDX = -1;
            }          
            if(ballX < 0)
            {
                ballDX = 1;
            }
            
            //paddles
            
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
        Pong game = new Pong();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
