/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/**
 *
 * @author johnb4223
 */
public class A1Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City kw = new City(); 
        Robot karel = new Robot (kw, 1, 2, Direction.SOUTH);    
        Thing paper = new Thing (kw, 2, 2) ;
        
        //Walls
        Wall wall1 = new Wall (kw, 2, 1, Direction.SOUTH);
        Wall wall2 = new Wall (kw, 2, 1, Direction.WEST);
        Wall wall3 = new Wall (kw, 1, 1, Direction.WEST);
        Wall wall4 = new Wall (kw, 1, 1, Direction.NORTH);
        Wall wall5 = new Wall (kw, 1, 2, Direction.NORTH);
        Wall wall6 = new Wall (kw, 1, 2, Direction.EAST);
        Wall wall7 = new Wall (kw, 1, 2, Direction.SOUTH);
        
        //Make the robot move
        karel.turnLeft ();
        karel.turnLeft ();
        karel.turnLeft ();
        karel.move ();
        karel.turnLeft ();
        karel.move ();
        karel.turnLeft ();
        karel.move ();
        karel.pickThing();
        karel.turnLeft ();
        karel.turnLeft ();
        karel.move ();
        karel.turnLeft ();
        karel.turnLeft ();
        karel.turnLeft ();
        karel.move ();
        karel.turnLeft ();
        karel.turnLeft ();
        karel.turnLeft ();
        karel.move ();
        karel.turnLeft ();
        karel.turnLeft ();
        karel.turnLeft ();
    }
}
