/* Title: something something Near Misses?
 * File name: ???
 * External files: ???
 * Generated files: small_output.txt is generated to record the list of nearest misses.
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

class Main {
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
          if ((z_up - z) > (z - z_down)) {
            if (z/z_down < smallestMiss) {
              smallestMiss = z/z_down;
              System.out.println(z_down + " is " + (smallestMiss*100) + "% away from " + z + " for x = " + x + " and y = " + y);
              myWriter.write(z_down + " is " + (smallestMiss*100) + "% away from " + z + " for x = " + x + " and y = " + y + "\n");
            }
          }
          else if ((z_up - z) <= (z - z_down)) {
            if ((1 - z/z_up) < smallestMiss) {
              smallestMiss = 1 - z/z_up;
              System.out.println(z_up + " is " + (smallestMiss*100) + "% away from " + z + " for x = " + x + " and y = " + y);
              myWriter.write(z_up + " is " + (smallestMiss*100) + "% away from " + z + " for x = " + x + " and y = " + y + "\n");
            }
          }
          else {
            System.out.println("error");
            myWriter.write("An error has occurred.\n");
            return;
          }
        }
      }
      myWriter.close();
    }
    catch (IOException e) {
      System.out.println("An error occurred in writing to small_output.txt.");
      e.printStackTrace();
    }
  }
}