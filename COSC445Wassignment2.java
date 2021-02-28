/* Title: something something Near Misses?
 * File name: ???
 * External files: ???
 * Generated files: small_output.txt ???
 * Programmers: Russell Ketterer, Benjamin Crawford, and William Lawson
 * Email addresses: kettererr@duq.edu, crawfordb2@duq.edu, lawsonw@duq.edu
 * COSC 445W-01 - Software Engineering
 * Date completed: ???
 * Date submitted: ???
 * Explanation: ???
 * External sources: ???
*/

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class COSC445Wassignment2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    try {
      File move_log = new File("small_output.txt"); //file to write to for recording current lowest
      if (move_log.createNewFile()) {
        System.out.println("small_output.txt has been created to record a list of current smallest misses.");
      }
      else {
        System.out.println("There was a problem generating small_output.txt.");
      }
    
      System.out.print("Give a value for k that's above 10.");
      int k = sc.nextInt();
      while (k <= 10) {
        System.out.print("Give a new value for k that's above 10.");
        k = sc.nextInt();
      }
    
      System.out.print("Give a value for n that's above 2.");
      int n = sc.nextInt();
      while (n <= 2) {
        System.out.println("Give a new value for n that's above 2.");
        n = sc.nextInt();
      }
    
      findMiss(k, n);
      String throwaway = sc.nextLine();
    }
    catch (IOException e) {
      System.out.println("An error occurred in creating or accessing small_output.txt.");
      e.printStackTrace();
    }
    sc.close();
  }
  
  static void findMiss(int k, int n) {
    /* The findMiss function takes in the values of k and n and finds the nearest whole number
     * by finding the ceiling and floor of the resulting z and comparing their diferences with z
     * to take the value of the smaller difference for later comparison against the current 
     * smallestMiss value. The program also makes use of a file writer for output to an external
     * .txt file. 
     * 
     * Variables in function: 
     * z: result of the "root n of (x^n + y^n) = z" formula. 
     * z_up: z rounded up using the ceiling function.
     * z_down: z rounded down using the floor funciton.
     * smallestMiss: the currently smallest miss for given values k and n. 
     */
    try {
      FileWriter myWriter = new FileWriter("small_output.txt");
      myWriter.write("For n = " + n + ":\n");
      
      double z, z_up, z_down;
      double smallestMiss = 1;
      
      for (int x=10; x<=k; x++) {
        for (int y=10; y<=k; y++) {
          z = Math.pow(Math.pow(x, n) + Math.pow(y, n), 1.0 / n); //z = nth root of (x^n + y^n)
          z_up = Math.ceil(z); //natural number above z
          z_down = Math.floor(z); //natural number below z
          if ((z_up - z) > (z - z_down)) { //comparison of differences of ceiling of floor and z, to floor of z and z.
            if (z/z_down < smallestMiss) {
              smallestMiss = (z/z_down);
              
              //the purpose of (((double)Math.round(z*100))/100) and similar math in print methods is to display two 
              //decimal places to the right of the value in question. in this case, z would multiplied by 100, 
              //rounded up, casted to double, and then has its decimal point moved again to display accurate data.
              System.out.println(z_down + " is " + (((double)Math.round(smallestMiss*10000))/100) + "% away from " + (((double)Math.round(z*100))/100) + " for x = " + x + " and y = " + y);
              myWriter.write(z_down + " is " + (((double)Math.round(smallestMiss*10000))/100) + "% away from " + (((double)Math.round(z*100))/100) + " for x = " + x + " and y = " + y + "\n");
            }
          }
          else if ((z_up - z) <= (z - z_down)) { //comparison of differences between floor of z and z, to ceiling of z and z.
            if ((1 - z/z_up) < smallestMiss) {
              smallestMiss = (1 - z/z_up); 
              
              System.out.println(z_up + " is " + (((double)Math.round(smallestMiss*10000))/100) + "% away from " + (((double)Math.round(z*100))/100) + " for x = " + x + " and y = " + y);
              myWriter.write(z_up + " is " + (((double)Math.round(smallestMiss*10000))/100) + "% away from " + (((double)Math.round(z*100))/100) + " for x = " + x + " and y = " + y + "\n");
            }
          }
          else { //error else
            System.out.println("error");
            myWriter.write("An error has occurred.\n");
            return;
          }
        }
      }
      myWriter.close();
    }
    catch (IOException e) { //error catching necessary for writing to txt file. 
      System.out.println("An error occurred in writing to small_output.txt.");
      e.printStackTrace();
    }
  }
}
