public class Board {
	public static boolean moved;
	public static boolean gameOver;
	public static int possibleMoves = 0;

	public Board(){
		int [][] grid = new int[4][4];
	}

	public static void populateBoard(int[][] a){
		a [(int) (Math.random()*3)][(int) (Math.random()*3)] = 2;
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


	public static void noPossibleMoves( int[][] a ) {
		possibleMoves = 0;
		for(int i = 0; i < 4; i++){
  			for(int j = 0; j < 3; j++){
        			if ((a[i][j+1] == a[i][j]) || (a[i][j] == 0)) {
        				possibleMoves++;
      				}

    			}
    		}

    	for(int i = 0; i < 3; i++){
  			for(int j = 0; j < 4; j++){
  				if ((a[i+1][j] == a[i][j]) || (a[i][j] == 0)) {
  					possibleMoves++;
  				}
  			}

  		}
  		if (possibleMoves < 1) {
  		gameOver = true;
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
		grid[0][1] = 4;
		grid[0][2] = 2;
		grid[0][3] = 4;

		grid[1][0] = 4;
		grid[1][1] = 2;
		grid[1][2] = 4;
		grid[1][3] = 2;

		grid[2][0] = 2;
		grid[2][1] = 4;
		grid[2][2] = 2;
		grid[2][3] = 4;

		grid[3][0] = 4;
		grid[3][1] = 2;
		grid[3][2] = 4;
		grid[3][3] = 2;

		print1(grid);
		shiftRight(grid);
		print1(grid);
		noPossibleMoves(grid);
		System.out.println(gameOver);
	}
}
