
public class ValueSet {
	
	public int xVal;
	public int yVal;
	public double zVal;
	public int zInt;
	public int zValhigh;
	public int zVallow;
	public int nVal;
	public int kVal;
	public double missVal;
	
	
	
	public ValueSet(int xVal, int yVal, double zVal, int zValhigh, int zVallow, int nVal, int kVal, double missVal) {
		
		this.xVal = xVal;
		this.yVal = yVal;
		this.zValhigh = zValhigh;
		this.zVallow = zVallow;
		this.nVal = nVal;
		this.kVal = kVal;
		this.zVal = zVal;
		if(Math.abs(zVallow-zVal)< Math.abs(zValhigh-zVal)) {
			this.missVal = Math.abs(zVallow-zVal);
			this.zInt = zVallow;
		}
		else {
			this.missVal = Math.abs(zValhigh-zVal);
			 this.zInt = zValhigh;
		}
		
	}
	
	public String toString(){
		
		double zNVal = (Math.pow(xVal, nVal)+Math.pow(yVal, nVal));
        System.out.println();
		System.out.println("Near miss: ("+xVal+","+yVal+","+ zInt +","+nVal+","+kVal+")");
		System.out.println("Miss size: "+ missVal);
		return "Relative miss size percentage: " + (double)(Math.abs(Math.pow(zInt, nVal)-zNVal)/zNVal);
		
	}
	
	

}
