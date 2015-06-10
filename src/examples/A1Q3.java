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
public class A1Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            City kw = new City ();
            Robot karel = new Robot (kw, 3, 0, Direction.EAST);
            Thing flag = new Thing (kw, 3, 1);
            
            //walls 
            Wall wall1 = new Wall (kw, 3, 2, Direction.WEST);
            Wall wall2 = new Wall (kw, 3, 2, Direction.NORTH);
            Wall wall3 = new Wall (kw, 2, 3, Direction.WEST);
            Wall wall4 = new Wall (kw, 1, 3, Direction.WEST);
            Wall wall5 = new Wall (kw, 1, 3, Direction.NORTH);
            Wall wall6 = new Wall (kw, 1, 3, Direction.EAST);
            Wall wall7 = new Wall (kw, 2, 4, Direction.NORTH);
            Wall wall8 = new Wall (kw, 2, 4, Direction.EAST);
            Wall wall9 = new Wall (kw, 3, 4, Direction.EAST);
            
            //Make the robot move
            karel.move ();
            karel.pickThing();
            karel.turnLeft();
            karel.move();
            karel.turnLeft();
            karel.turnLeft();
            karel.turnLeft();
            karel.move ();
            karel.turnLeft();
            karel.move ();
            karel.move ();
            karel.turnLeft();
            karel.turnLeft();
            karel.turnLeft();
            karel.move();
            karel.putThing();
            karel.move();
            karel.turnLeft ();
            karel.turnLeft();
            karel.turnLeft();
            karel.move ();
            karel.turnLeft();
            karel.move ();
            karel.turnLeft();
            karel.turnLeft();
            karel.turnLeft();
            karel.move ();
            karel.move ();
            karel.turnLeft();
    }

    private static void turnLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
