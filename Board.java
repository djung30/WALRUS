public class Board {
	public static int[] storedRow0;
	public static int[] storedRow1;
	public static int[] storedRow2;
	public static int[] storedRow3;
	public static boolean moved;

	public Board(){
		int [][] grid = new int[4][4];
	}

	public static void populateBoard(int[][] a){
		a [(int) (Math.random()*3)][(int) (Math.random()*3)] = 2;
	}

	public static void storeArray(int[][] a){
		storedRow0 = a[0];
		storedRow1 = a[1];
		storedRow2 = a[2];
		storedRow3 = a[3];
	}

	public static void hasMoved(int[][] a){
		int counter = 0;
			if(a[0].equals(storedRow0)){
				counter++;
			}
			if(a[1].equals(storedRow1)){
				counter++;
			}
			if(a[2].equals(storedRow2)){
				counter++;
			}
			if(a[3].equals(storedRow3)){
				counter++;
			}
		if(counter == 4){
			moved = false;
		} else {
			moved = true;
		}
	}


	public static void randomTwo(int[][] a) {
		boolean isZero = false;
		int row;
		int column;
		while (isZero == false) {
			row = ((int) (Math.random()*3));
			column = ((int) (Math.random()*3));
			if (a[row][column] == 0) {
				isZero = true;
				a[row][column] = 2;
			}
		}
	}

/*
	0 0 0 0
	0 0 0 0
	0 2 0 0
	0 0 0 0
*/
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
			storeArray(a);
  		for(int i = 0; i < 4; i++){
  			for(int j = 0; j < 3; j++){
  				if(a[i][j+1]==0){
  					a[i][j+1] = a[i][j];
  					a[i][j] = 0;
  				}
					if ((a[i][j+1] == a[i][j]) && (a[i][j] != 0)) {
							a[i][j+1] = a[i][j+1] + a[i][j];
							a[i][j] = 0;
					}
  			}
  		}
			for(int i = 0; i < 4; i++){
  			for(int j = 0; j < 3; j++){
  				if(a[i][j+1]==0){
  					a[i][j+1] = a[i][j];
  					a[i][j] = 0;
  				}
				}
			}
			hasMoved(a);
  	}

		public static void shiftLeft( int[][] a ){
  		for(int i = 0; i < 4; i++){
  			for(int j = 3; j > 0; j--){
  				if(a[i][j-1]==0){
  					a[i][j-1]=a[i][j];
  					a[i][j] = 0;
					}
					if ((a[i][j-1] == a[i][j]) && (a[i][j] != 0)) {
								a[i][j-1] = a[i][j-1] + a[i][j];
								a[i][j] = 0;
  				}
  			}
  		}
			for(int i = 0; i < 4; i++){
  			for(int j = 3; j > 0; j--){
  				if(a[i][j-1]==0){
  					a[i][j-1]=a[i][j];
  					a[i][j] = 0;
					}
				}
			}
  	}

   	public static void shiftUp( int[][] a ){
  		for(int i = 3; i > 0; i=i-1){
  			for(int j = 0; j < 4; j++){
  				if(a[i-1][j] == 0){
  					a[i-1][j] =a [i][j];
  					a[i][j] = 0;
  				}
					if ((a[i-1][j] == a[i][j]) && (a[i][j] != 0)) {
							a[i-1][j] = a[i-1][j] + a[i][j];
							a[i][j] = 0;
					}
  			}
  		}
			for(int i = 3; i > 0; i=i-1){
  			for(int j = 0; j < 4; j++){
  				if(a[i-1][j] == 0){
  					a[i-1][j] =a [i][j];
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
					if ((a[i+1][j] == a[i][j]) && (a[i][j] != 0)) {
							a[i+1][j] = a[i+1][j] + a[i][j];
							a[i][j] = 0;
					}
  			}
  		}
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
		grid[0][0] = 2;
		grid[0][1] = 2;
		grid[0][2] = 2;
		grid[0][3] = 2;
		print1(grid);
		shiftRight(grid);
		print1(grid);
		System.out.println(moved);
	}
}
