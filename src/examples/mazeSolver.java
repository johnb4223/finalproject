/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import becker.robots.Direction;
import becker.robots.MazeCity;
import becker.robots.Robot;
import becker.robots.Thing;

/**
 *
 * @author johnb4223
 */
public class mazeSolver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MazeCity maze = new MazeCity (10,10);
        Robot karel = new Robot (maze,0,0,Direction.EAST);
        new Thing (maze,0,9);
        
        //while karel cannot pick something up
        while(!karel.canPickThing())
        {
            //check left wall
            karel.turnLeft();
            //if the left wall is clear, move through it 
            if (karel.frontIsClear())
            {
                karel.move();
            }else // if there is a wall 
            {
                // face original direction 
                karel.turnLeft();
                karel.turnLeft();
                karel.turnLeft();
                if (karel.frontIsClear()) //if there is no wall 
                {
                    karel.move(); //move a space
                }else //if there is a wall
                {
                    //turn right ]
                     karel.turnLeft();
                     karel.turnLeft();
                     karel.turnLeft();
                }
            }
                
            
        }
        
    }
}
