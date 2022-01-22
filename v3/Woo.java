
import java.util.Scanner;

public class Woo {
	private static final String acceptedInputs = "wasdWASD";
	public static boolean moved;
	public static boolean gameOver = false; 
	public static int possibleMoves = 0; 
	
	public static void main(String[] args) {
		int [][] grid = new int[4][4];
		Board game = new Board();
		game.populateBoard(grid);
		String s;
		String name = "";
    		s = "~~~ 2048 : TERMINAL EDITION ~~~\n";
    		s += "\n How To Play: \n";
    		s += "\n Use your WASD keys and the enter key to move the tiles. Tiles with the same number merge into one when they touch. Add them up to reach 2048! \n";
		s += "\n \n";
    		System.out.print( s );
    		Board.print1(grid);
    		while (gameOver != true){
    			moveDoer(inputGet(), grid);
    			Board.randomTwo(grid);
    			Board.print1(grid);
    			Board.noPossibleMoves(grid);
    			System.out.print( possibleMoves );
    		}
	}
	
	public static String inputGet() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your MOVE:");
		String move = input.nextLine();
		while (acceptedInputs.indexOf(move) == -1) {
			Scanner input2 = new Scanner(System.in);
			System.out.print("Your input is invalid, please enter your MOVE again, and make sure to use the WASD keys:");
			move = input.nextLine();
		}
		return move; 
	}
	
	public static void moveDoer(String input, int[][] a){
		if(input.equals("w") || input.equals("W")){
			Board.shiftUp(a);
		}
		if(input.equals("a") || input.equals("A")){
			Board.shiftLeft(a);
		}
		if(input.equals("s") || input.equals("S")){
			Board.shiftDown(a);
		}
		if(input.equals("d") || input.equals("D")){
			Board.shiftRight(a);
		}

	}
}
