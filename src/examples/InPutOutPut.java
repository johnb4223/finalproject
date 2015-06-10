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
public class InPutOutPut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String name; // to store someones name 
        System.out.print("Please enter your name:");
        name = input.nextLine(); // reads in the name
        
        //say hello to the user
        System.out.println("Hello " + name);
        System.out.println(); //blank line
        
        //getting a number
        System.out.println("Please enter a number");
        double aNumber = input.nextDouble();
        
        double answer = aNumber + 100;
        System.out.println(aNumber + " + 100 = " + answer);
        
    }
}
