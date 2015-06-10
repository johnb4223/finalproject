/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;

/**
 *
 * @author johnb4223
 */
public class CountedLoops {
    private static int ave;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         City kw = new City();
        Robot karel = new Robot(kw, 1, 1, Direction.EAST);

//        int count = 4;
//        while(count > 0)
//        {
//            karel.move();
//            karel.move();
//            karel.turnLeft();
//            karel.turnLeft();
//            karel.turnLeft();
//            count--;
//        }

        for (int i = 0; i < 4; i++) {
            karel.move();
            karel.move();
            karel.turnLeft();
            karel.turnLeft();
            karel.turnLeft();
        }


        for (int street = 4; street > 0; street--) {
            for (int ave = 0; ave < 4; ave++) {
                karel.move();
            }
            // if street number is odd
            if (street % 2 == 1) {
                karel.turnLeft();
                karel.move();
                karel.turnLeft();
            } else {
                karel.turnLeft();
                karel.turnLeft();
                karel.turnLeft();
                karel.move();
                karel.turnLeft();
                karel.turnLeft();
                karel.turnLeft();
            }
        }

    }
}