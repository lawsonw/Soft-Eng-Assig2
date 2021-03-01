import java.util.InputMismatchException;
import java.util.Scanner;
public class RDSEP2 {
	
	public static void main(String[] args) {
		
		printDescription();              
		findNearMisses(setValue(2, 12, "n"), setValue(10, 99999, "k"));
		
		
		
	}
	
	public static void findNearMisses(int nVal, int kVal) {
		
		//System.out.println("n value is " + nVal);
		//System.out.println("k value is " + kVal);
		System.out.println("Misses will be printed in the form (x,y, nearest integer z, n, k).");
		double zVal, missLow=9999, missVal=0;
		ValueSet block;
		for(int i=10; i<kVal+1; i++) {
			for(int j=i; j<kVal+1; j++) {
				zVal = (Math.pow(i, nVal) + Math.pow(j, nVal));
				zVal = Math.pow(zVal, 1.00/nVal);
				block = new ValueSet(i, j, zVal, (int)Math.floor(zVal), (int)Math.ceil(zVal), nVal, kVal, missVal);
				if(block.missVal < missLow) {
					missLow = block.missVal;
					System.out.println(block);
					if(missLow == 0)
						return;
				}

			}
		}
		
		
	}
	
	public static int setValue(int low, int high, String name) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter an integer value in the range ("+low+","+high+") for "+ name + ".");
		int retVal=0;
		  do{     
			     if(retVal!=0)
			      retVal =0;
			     try {
			           
			      retVal = sc.nextInt();
			      if(retVal < (low+1) || retVal > (high-1))
			        System.out.println("That is an invalid value for "+name+ ". Please enter an integer between "+low+" and "+ high +".");
			     }
			     
			     catch(InputMismatchException e) {
			      
			     System.out.println("That is an invalid value for "+name+ ". Please enter an integer between "+low+" and "+ high +".");
			     sc.next();
			     }
			    }
			    while(retVal < (low+1) || retVal > (high-1));
		  return retVal;
		  
		}
	
	
	public static void printDescription() {
		
		
		System.out.println("To find near misses, we will ask for values of n and k for the ");
		System.out.println(" equation x^n + y^n = z^n, where x and y range from 10 to k.");
		System.out.println();
		
		
	}

}
