/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;

/**
 *
 * @author johnb4223
 */
public class MakingDecisions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City field = new City ();
        Robot worker = new Robot (field,0,5,Direction.WEST);
        //row 1
        new Thing (field,0,1);
        new Thing (field,0,2);
        new Thing (field,0,3);
        new Thing (field,0,4);
        //row 2
        new Thing (field,1,1);
        new Thing (field,1,2);
        new Thing (field,1,3);
        new Thing (field,1,4);
        //row 3
        new Thing (field,2,1);
        new Thing (field,2,2);
        new Thing (field,2,3);
        new Thing (field,2,4);
        //row 4
        new Thing (field,3,1);
        new Thing (field,3,2);
        new Thing (field,3,3);
        new Thing (field,3,4);
        //row 5
        new Thing (field,4,1);
        new Thing (field,4,2);
        new Thing (field,4,3);
        new Thing (field,4,4);
        
        //make the robot move
        
        worker.move();
        //while standing on a crop
        while(worker.canPickThing()){
             //harvest the crop 
            worker.pickThing();
             //move forward
            worker.move();
            if(worker.getAvenue() == 1){
                worker.pickThing();
                worker.turnLeft();
                worker.move();
                worker.turnLeft ();
        }
            if(worker.getAvenue() == 4)
            {        
            worker.pickThing();
            //turn right 
            worker.turnLeft();
            worker.turnLeft();
            worker.turnLeft();
            //move down
            worker.move();
            //turn right
            worker.turnLeft();
            worker.turnLeft();
            worker.turnLeft();
    }

