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
public class Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //declare an array with 10 spots
        // [] is "array"
        int[] nums = new int[10];
        
        //inital the array to 0
        //goes from 0 to the length of the array
        for(int i = 0; i < nums.length; i++)
        { 
            nums[i] = 0;
        }
        
        for(int i = 0; i < nums.length; i++)
        {
         System.out.println("please enter a number ");
        nums[i] = input.nextInt();  
        }
         //add all the numbers in the array
        int total = 0;
        for(int i = 0; i < nums.length; i++)
        {
            total = total + nums[i];
        }
        
        System.out.println("the sum of the number is " + total );
        
        //find average
        int avg = total/nums.length;
        System.out.println("the average of the number is " + avg );
        
        //adding the long way
//        nums[1] = 15;
//        nums[2] = nums[0] * nums[1];
        
        //find the biggest number
        int biggest = nums[0];
        for(int i = 0; i < nums.length; i++)
        { 
            //check to see if the current number is bigger
            if(nums[i] > biggest)
            {
                //biggest number is the current number
                biggest = nums[i];
            }
        }
        System.out.println("the biggest number is " + biggest );
        
        
        
    }
}
