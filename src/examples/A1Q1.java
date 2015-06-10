/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Wall;

/**
 *
 * @author johnb4223
 */
public class A1Q1 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City kw = new City ();
        Robot karel = new Robot (kw, 0, 2, Direction.WEST);

        //walls
        Wall wall1 = new Wall (kw, 1, 1, Direction.NORTH);
        Wall wall2 = new Wall (kw, 1, 2, Direction.NORTH);
        Wall wall3 = new Wall (kw, 1, 1, Direction.WEST);
        Wall wall4 = new Wall (kw, 2, 1, Direction.WEST);
        Wall wall5 = new Wall (kw, 2, 1, Direction.SOUTH);
        Wall wall6 = new Wall (kw, 2, 2, Direction.SOUTH);
        Wall wall7 = new Wall (kw, 2, 2, Direction.EAST);
        Wall wall8 = new Wall (kw, 1, 2, Direction.EAST);
        
        //make the robot move 
        karel.move ();
        karel.move ();
        karel.turnLeft ();
        karel.move ();
        karel.move ();
        karel.move ();
        karel.turnLeft ();
        karel.move ();
        karel.move ();
        karel.move ();
        karel.turnLeft ();
        karel.move ();
        karel.move ();
        karel.move ();
        karel.turnLeft ();
        karel.move ();
        
    }
}
