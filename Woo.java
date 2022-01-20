import java.util.Scanner;

public class Woo {

	private static final String acceptedInputs = "wasdWASD";

	public static void main(String[] args) {
		int [][] grid = new int[4][4];
		Board game = new Board();
		game.populateBoard(grid);
		String s;
    String name = "";
    s = "~~~ 2048 : TERMINAL EDITION ~~~\n";
    s += "\n How To Play: \n";
    s += "\n Use your WASD to move the tiles. Tiles with the same number merge into one when they touch. Add them up to reach 2048! \n";
		s += "\n \n";
    System.out.print( s );
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your MOVE:");
		String move = input.nextLine();
		if (acceptedInputs.indexOf(move) == -1) {
			System.out.print("Your input is invalid, please enter your MOVE again, and make sure to use the WASD keys:");
		}
	}
}
