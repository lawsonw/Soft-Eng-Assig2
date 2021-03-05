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
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class COSC445Wassignment2_2 {
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
    
      long n = setValue(2, 12, "n");
      long kBound = setUpperBound((int)n);
      long k = setValue(10, kBound, "k");
    
      findMiss(k, n);
      String throwaway = sc.nextLine();
    }
    catch (IOException e) {
      System.out.println("An error occurred in creating or accessing small_output.txt.");
      e.printStackTrace();
    }
    sc.close();
  }
  
  static void findMiss(long k, long n) {
    try {
      FileWriter myWriter = new FileWriter("small_output.txt");
      myWriter.write("For n = " + n + ":\n");
      
      double z, zn, z_up, z_down, test_up, test_down;
      double smallestMiss = 100;
      for (long x=10; x<=k; x++) {
        for (long y=x; y<=k; y++) {
          zn = Math.pow(x, n) + Math.pow(y, n);
          z = Math.pow(zn, 1.0 / n); //z = nth root of (x^n + y^n)
          z_up = Math.ceil(z); //natural number above z
          z_down = Math.floor(z); //natural number below z
          test_up = (Math.pow(z_up, n) - zn) / zn;
          test_down = (zn - Math.pow(z_down, n)) / zn;
          
          if (test_up >= test_down) {
            if (test_down <= smallestMiss) { //Russ EDIT: the && statement forced into else: error if it wasnt a new smallest miss
              smallestMiss = test_down;
              System.out.println(z_down + " is " + (smallestMiss*100) + "% away from " + z + " for x = " + x + " and y = " + y);
              myWriter.write(z_down + " is " + (smallestMiss*100) + "% away from " + z + " for x = " + x + " and y = " + y + "\n");
            }
          }
          else if (test_up < test_down) {
            if (test_up < smallestMiss) { //Russ EDIT: the && statement forced into else: error if it wasnt a new smallest miss
              smallestMiss = test_up;
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
      System.out.println("done with for loops");
      myWriter.close();
    }
    catch (IOException e) {
      System.out.println("An error occurred in writing to small_output.txt.");
      e.printStackTrace();
    }
  }
  
  public static long setValue(long low, long high, String name) {
  
  Scanner sc2 = new Scanner(System.in);
  System.out.println("Please enter an integer value in the range ("+low+","+high+") for "+ name + ".");
  long retVal=0;
    do{     
        if(retVal!=0)
         retVal =0;
        try {
              
         retVal = sc2.nextInt();
         if(retVal < (low+1) || retVal > (high-1))
           System.out.println("That is an invalid value for "+name+ ". Please enter an integer between "+low+" and "+ high +".");
        }
        
        catch(InputMismatchException e) {
         
        System.out.println("That is an invalid value for "+name+ ". Please enter an integer between "+low+" and "+ high +".");
        sc2.next();
        }
       }
       while(retVal < (low+1) || retVal > (high-1));
    sc2.close();
    return retVal;
    
  }
  
  public static long setUpperBound(int power) {
    //long maxLong = Long.MAX_VALUE;
    //long bound = (long)(Math.floor(Math.pow(maxLong, (1.0 / power))));
    int bound;
    switch (power) {
      case 3:
        bound = 12000;
        break;
      case 4:
        bound = 10500;
        break;
      case 5:
        bound = 9000;
        break;
      case 6:
        bound = 5000;
        break;
      case 7:
        bound = 2800;
        break;
      case 8:
        bound = 2300;
        break;
      case 9:
        bound = 2000;
        break;
      case 10:
        bound = 1700;
        break;
      case 11:
        bound = 1500;
        break;
      default:
        bound = 1500;
        break;
    }
    return bound;
  }
}
