/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.util.Scanner;

/**
 *
 * @author johnb4223
 */
public class Methods {
    
    static double addTen(double x)
    {
        x = x + 10;
        return x;
    }
    
    //calculating the distance between (x1,y1) and (x2,y2)
    static double calcDistance(int x1, int y1, int x2, int y2)
    {
        double distance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));  
        return distance;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //get the (x.y) for point 1
        System.out.println("please input an x coordinate for point 1:");
        int x1 = input.nextInt();
        System.out.println("please input an y coordinate for point 1:");
        int y1 = input.nextInt();
        
        //get the (x.y) for point 2
        System.out.println("please input an x coordinate for point 2:");
        int x2 = input.nextInt();
        System.out.println("please input an y coordinate for point 2:");
        int y2 = input.nextInt();
        
        double distance = calcDistance(x1,y1,x2,y2);
        System.out.println("The distance your two points is " + distance);
        
        distance = addTen(distance);
        System.out.println("10 added to the distance is " + distance);
    }
}
