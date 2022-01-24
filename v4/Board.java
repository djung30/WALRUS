import java.util.ArrayList;

public class Board {
	int [][] grid;

	public Board(){
		// Initializes the grid
		grid = new int[4][4];
	}

	public void newTile() {
		//Puts a 2 in a random spot that previously contained a zero
		ArrayList<Integer> spots = new ArrayList<Integer>();
		for(int i = 0; i < 4; i++){
  		for(int j = 0; j < 4; j++){
				if (grid[i][j] == 0){
					spots.add(4*i+j);
				}
			}
		}
		int pos = spots.get((int) Math.random()*spots.size());
		grid[pos / 4][pos % 4] = 2;
	}


	public boolean isEnded() {
		//Checks to see if there are any zeros in the grid, meaning that there are possible moves
		for(int i = 0; i < 4; i++){
  		for(int j = 0; j < 4; j++){
				if (grid[i][j] == 0){
					return false;
				}
			}
		}
		//Checks if any horizontal merging is possible
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 3; j++){
				if ((grid[i][j+1] == grid[i][j])){
					return false;
				}
			}
		}
		//Checks if any vertical merging is possible
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 4; j++){
				if ((grid[i+1][j] == grid[i][j])){
					return false;
				}
			}
		}
		return true;
	}
/*
	0  0  0  0
	0  0  0  0
	0  2  0  0
	0  0  0  0
*/
	String strArr(int[][] g) {
		String ret = "";
		for (int[] row: g) {
			for (int el : row) {
				ret += el;
			}
		}
		return ret;
	}
	public void printGrid(){
		//Prints the gird
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
        			System.out.print("  ");
        			System.out.print(grid[i][j]);
      			}
      		System.out.println();
    		}
    	System.out.println();
  }

	/*
	Next are the shifting methods for the for directions we can move.
	Each one can be broken down into a merging phase and a moving phase.
	*/
	void mergeRight(int[][] g){
		for(int i = 0; i < 4; i++){
			for(int j = 3; j > 0; j--){
				if(g[i][j] == g[i][j-1]){
					g[i][j] *= 2;
					g[i][j-1] = 0;
				}
			}
		}
	}
	void mergeLeft(int[][] g){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 3; j++){
				if(g[i][j] == g[i][j+1]){
					g[i][j] *= 2;
					g[i][j+1] =0;
				}
			}
		}
	}
	void mergeUp(int[][] g){
		for(int j = 0; j < 4; j++){
			for(int i = 0; i < 3; i++){
				if(g[i][j] == g[i+1][j]){
					g[i][j] *= 2;
					g[i+1][j] = 0;
				}
			}
		}
	}
	void mergeDown(int[][] g){
		for(int j = 0; j < 4; j++){
			for(int i = 3; i > 0; i--){
				if(g[i][j] == g[i-1][j]){
					g[i][j] *= 2;
					g[i-1][j] =0;
				}
			}
		}
	}
	void moveRight(int[][] g){
		int zIndex;
		for(int i = 0; i < 4; i++){
			zIndex = -1;
			for (int j = 3; j >= 0; j--){
				if (g[i][j] == 0 && zIndex == -1){
					zIndex = j;
				}
				else if (g[i][j] != 0 && zIndex != -1){
					g[i][zIndex] = g[i][j];
					g[i][j] = 0;
					zIndex--;
				}
			}
		}
	}
	void moveLeft(int[][] g){
		int zIndex;
		for(int i = 0; i < 4; i++){
			zIndex = -1;
			for (int j = 0; j < 4; j++){
				if (g[i][j] == 0 && zIndex == -1){
					zIndex = j;
				}
				else if (g[i][j] != 0 && zIndex != -1){
					g[i][zIndex] = g[i][j];
					g[i][j] = 0;
					zIndex++;
				}
			}
		}
	}
	void moveUp(int[][] g){
		int zIndex;
		for(int j = 0; j < 4; j++){
			zIndex = -1;
			for (int i = 0; i < 4; i++){
				if (g[i][j] == 0 && zIndex == -1){
					zIndex = i;
				}
				else if (g[i][j] != 0 && zIndex != -1){
					g[zIndex][j] = g[i][j];
					g[i][j] = 0;
					zIndex++;
				}
			}
		}
	}
	void moveDown(int[][] g){
		int zIndex;
		for(int j = 0; j < 4; j++){
			zIndex = -1;
			for (int i = 3; i >= 0; i--){
				if (g[i][j] == 0 && zIndex == -1){
					zIndex = i;
				}
				else if (g[i][j] != 0 && zIndex != -1){
					g[zIndex][j] = g[i][j];
					g[i][j] = 0;
					zIndex--;
				}
			}
		}
	}
	/*
	To shift tiles, we execute a moving phase to move all of the tiles to one side. We then merge adjacent
	tiles of the same value. Finally, we move once more to get everything to one side.
	However, we don't want the user to be able to do "junk moves." For instance, if all the tiles are on the bottom,
	then moving down should not spawn in a new tile for the user. Thus, we compare the version of the grid before and after shifting and return
	true if anything has changed
	*/
	public boolean shiftRight(){
		String before = strArr(grid);
		moveRight(grid);
		mergeRight(grid);
		moveRight(grid);
		String after = strArr(grid);
		return ! after.equals(before);
	}

	public boolean shiftLeft(){
		String before = strArr(grid);
		moveLeft(grid);
		mergeLeft(grid);
		moveLeft(grid);
		String after = strArr(grid);
		return ! after.equals(before);
	}

	public boolean shiftUp(){
		String before = strArr(grid);
		moveUp(grid);
		mergeUp(grid);
		moveUp(grid);
		String after = strArr(grid);
		return ! after.equals(before);
	}

	public boolean shiftDown(){
		String before = strArr(grid);
		moveDown(grid);
		mergeDown(grid);
		moveDown(grid);
		String after = strArr(grid);
		return ! after.equals(before);
	}

	//Tests
	public static void main(String[] args) {
		Board b = new Board();
		b.grid[0][0] = 2;
		b.printGrid();
		System.out.println(b.shiftUp());
		//b.shiftDown();
		//b.shiftRight();
		//b.shiftLeft();
		b.printGrid();
	}
}
