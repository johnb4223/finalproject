/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.MazeCity;
import becker.robots.Robot;
import becker.robots.Thing;

/**
 *
 * @author johnb4223
 */
public class Variables {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        City kw =  new City ();
        Robot karel = new Robot (kw,1,1,Direction.EAST);
        MazeCity m = new MazeCity(10,10);
        int countLoops = 0;
        
        while(countLoops < 20) {
            new Thing(kw,1,3);
            countLoops = countLoops + 1;
            
        }
        //while the robot cannot pick anything up 
        // ! <-- NOT 
        while (! karel.canPickThing())
        {
            karel.move();
            
            //as long as there is something to pick up 
            // pick it up!
            int countThing = 0;
            while (karel.canPickThing())
            {
                karel.pickThing();
                countThings++;   
            }
        } //output the value of countThings
        System.out.println("Karel picked up " + countThings);
        int numberInPack = karel.countThingsInBackpack();
   
}
