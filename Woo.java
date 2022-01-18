public class Woo {
	
	public Woo() {
		int [][] m1 = new int[4][4];
	}
	
	public static void print1( int[][] a ){
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[i].length; j++){
        			System.out.print(" ");
        			System.out.print(a[i][j]);
      			}
      		System.out.println();
    		}
    	System.out.println();
  	}
	
	public static void main(String[] args) {
		int [][] m1 = new int[4][4];
		print1(m1);
	}
}
