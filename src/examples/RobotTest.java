package examples;


import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johnb4223
 */
public class RobotTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City kw = new City();
        Robot karel = new Robot(kw, 1, 2, Direction.EAST);
        Robot jeff = new Robot (kw, 1, 4, Direction.WEST);
        Thing trash = new Thing (kw,3,4);
       
        //walls
        Wall wall1 = new Wall (kw, 1, 2, Direction.NORTH);
        Wall wall2 = new Wall (kw, 1, 3, Direction.NORTH);
        Wall wall3 = new Wall (kw, 1, 4, Direction.NORTH); 
        
        // label the robots 
        karel.setLabel ("K");
        jeff.setLabel ("J");
        
        // make the robot move
        karel.move();
        karel.turnLeft();
        karel.turnLeft();
        karel.turnLeft();
        karel.move();
   
        // make the robot move
        jeff.move();
        jeff.turnLeft();
        jeff.move();
    }
}
        

        
