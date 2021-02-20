import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
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
    sc.close();
  }
  
  static void findMiss(int k, int n) {
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
          }
        }
        else if ((z_up - z) <= (z - z_down)) {
          if ((1 - z/z_up) < smallestMiss) {
            smallestMiss = 1 - z/z_up;
            System.out.println(z_up + " is " + (smallestMiss*100) + "% away from " + z + " for x = " + x + " and y = " + y);
          }
        }
        else {
          System.out.println("error");
          return;
        }
      }
    }
  }
}