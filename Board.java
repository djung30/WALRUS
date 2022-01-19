public class Board {

	public Board(){
		int [][] grid = new int[4][4];
	}
	
	public static void populateBoard(int[][] a){
		a [(int) (Math.random()*3)][(int) (Math.random()*3)] = 2;
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
  	
  	public static void shiftRight( int[][] a ){
  		for(int i = 0; i < 4; i++){
  			for(int j = 0; j < 3; j++){
  				if(a[i][j+1]==0){
  					a[i][j+1]=a[i][j];
  					a[i][j] = 0;
  				}
  			}
  		}
  	}
  	
   	public static void shiftUp( int[][] a ){
  		for(int i = 3; i > 0; i=i-1){
  			for(int j = 0; j < 3; j++){
  				if(a[i-1][j]==0){
  					a[i-1][j]=a[i][j];
  					a[i][j] = 0;
  				}
  			}
  		}
  	}
  	
   	public static void shiftDown( int[][] a ){
  		for(int i = 0; i < 3; i++){
  			for(int j = 0; j < 4; j++){
  				if(a[i+1][j]==0){
  					a[i+1][j]=a[i][j];
  					a[i][j] = 0;
  				}
  			}
  		}
  	}
	
	public static void main(String[] args) {
		int [][] grid = new int[4][4];
		populateBoard(grid);
		print1(grid);
		shiftRight(grid);
		print1(grid);
		shiftDown(grid);
		print1(grid);
		shiftUp(grid);
		print1(grid);
	}
}
